package com.ozstrategy.credagility.core.repository.jdbc.impl;

import com.ozstrategy.credagility.core.domain.SurveyFlowAuditQuestion;
import com.ozstrategy.credagility.core.info.DocumentInfo;
import com.ozstrategy.credagility.core.repository.jdbc.WorkflowRepositoryJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/03/2014 16:02
 */
@Profile("jdbc")
@Repository("workflowRepositoryJdbc")
public class WorkflowRepositoryJdbcImpl extends JdbcDaoSupport implements WorkflowRepositoryJdbc {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static final RowMapper workflowDocumentMapper = new RowMapper() {
    @Override public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
      DocumentInfo info = new DocumentInfo();
      info.setDocId(rs.getLong("id"));
      info.setDocName(rs.getString("name"));
      info.setCreateDate(rs.getDate("createDate"));
      info.setDocumentCategoryId(rs.getLong("documentCategoryId"));
      info.setCategoryName(rs.getString("categoryName"));
      info.setStatusId(rs.getLong("statusId"));
      info.setStatusName(rs.getString("statusName"));
      info.setFileName(rs.getString("fileName"));
      info.setInstanceId(rs.getLong("instanceId"));
      info.setCreatorId(rs.getLong("creatorId"));
      info.setCreatorName(rs.getString("creatorName"));
      info.setFileSize(rs.getLong("fileSize"));
      info.setCategoryPath(rs.getString("categoryPath"));
      info.setExtension(rs.getString("extension"));
      info.setUploaded(rs.getBoolean("uploaded"));
// info.setInsCount(rs.getInt("insCount"));

      return info;
    }
  };

  //~ Constructors -----------------------------------------------------------------------------------------------------

  /**
   * Creates a new WorkflowRepositoryJdbcImpl object.
   *
   * @param  dataSource  DataSource
   */
  @Autowired public WorkflowRepositoryJdbcImpl(DataSource dataSource) {
    setDataSource(dataSource);
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.jdbc.WorkflowRepositoryJdbc#countWorkflowDocument(Long, String)
   */
  @Override public Integer countWorkflowDocument(Long responsibleId, String queryText) {
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT COUNT(DISTINCT doc.id) FROM EnterpriseDocument doc ").append(
      "LEFT JOIN ResponsibleDocumentInstance ins ON doc.id = ins.documentId AND ins.responsibleId =? AND ins.active ='Y' ")
      .append("LEFT JOIN DocumentStatus sta ON ins.statusId=sta.id ").append(
      "LEFT JOIN DocumentCategory cat ON doc.documentCategoryId=cat.id ").append(
      "LEFT JOIN User u on ins.creatorId=u.id ").append(
      "WHERE doc.status not in ('DELETED','DISABLE') and doc.contextType ='Account' AND doc.active ='Y' ");

    if (StringUtils.hasText(queryText)) {
      sql.append(" AND (").append("doc.name like '%").append(queryText).append("%'").append("OR cat.name like '%")
        .append(queryText).append("%'").append("OR ins.fileName like '%").append(queryText).append("%'").append(") ");
    }

    List<Object> result = getJdbcTemplate().queryForList(sql.toString(), new Object[] { responsibleId }, Object.class);
    Long         count  = 0L;

    if (result.size() > 0) {
      count = (Long) result.get(0);
    }


    return count.intValue();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.jdbc.WorkflowRepositoryJdbc#getAnswerOptionsByProvider(Long)
   */
  @Override public List<Object[]> getAnswerOptionsByProvider(Long questionId) {
    List<Object[]> objects = new ArrayList<>();

    List<String> queries = getJdbcTemplate().queryForList(
        "SELECT w.searchQuery FROM WorkflowAnswerOptionConfig w INNER JOIN PortfolioQuestionVersion p ON w.id = p.workflowAnswerOptionConfigId WHERE p.id = ? ",
        new Object[] { questionId },
        String.class);

    if ((queries != null) && (queries.size() > 0)) {
      String sql = queries.get(0);
      objects = getJdbcTemplate().query(sql, new RowMapper<Object[]>() {
            @Override public Object[] mapRow(ResultSet resultSet, int i) throws SQLException {
              String name = resultSet.getString("displayName");
              Long   id   = resultSet.getLong("externalEntityId");

              return new Object[] { name, id };
            }
          });
    }

    return objects;
  } // end method getAnswerOptionsByProvider

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.jdbc.WorkflowRepositoryJdbc#getAuditQuestion(Long, Long,
   *       Long, Long)
   */
  @Override public SurveyFlowAuditQuestion getAuditQuestion(Long responsibleId, Long flowStepId, Long auditInstanceId,
    Long questionId) {
    List<SurveyFlowAuditQuestion> questions = getJdbcTemplate().queryForList(
        "SELECT aques.* FROM SurveyFlowAuditQuestion aques WHERE aques.questionId = ? AND aques.surveyFlowAuditStepId = ("
        + "SELECT step.id FROM SurveyFlowAuditStep step WHERE step.responsibleId = ? AND step.surveyFlowAuditInstanceId =? "
        + "AND step.flowStepId= ? AND step.status='FINISHED' ORDER BY step.createDate DESC, step.lastUpdateDate DESC LIMIT 0, 1)",
        new Object[] { questionId, responsibleId, auditInstanceId, flowStepId }, SurveyFlowAuditQuestion.class);

    if (questions.size() > 0) {
      return questions.get(0);
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.ozstrategy.credagility.core.repository.jdbc.WorkflowRepositoryJdbc#readWorkflowDocument(Long, String,
   *       int, int)
   */
  @Override public List<DocumentInfo> readWorkflowDocument(Long responsibleId, String queryText, int start, int size) {
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT DISTINCT doc.id,doc.name,ins.createDate,doc.documentCategoryId,cat.name categoryName,").append(
      "ins.statusId,sta.name statusName,ins.fileName,ins.id instanceId,u.id creatorId, CONCAT(CONCAT(u.firstName,' ' ), u.lastName) creatorName, ")

// .append("ins.fileSize,ins.categoryPath, ins.extension, ins.uploaded, count(rdi.id) insCount ")
    .append("ins.fileSize,ins.categoryPath, ins.extension, ins.uploaded ").append(
      "FROM EnterpriseDocument doc LEFT JOIN ( SELECT b.* FROM (SELECT a.* FROM ResponsibleDocumentInstance a ").append(
      "WHERE a.responsibleId =? AND a.active ='Y' ORDER BY a.createDate DESC, a.lastUpdateDate DESC ").append(
      "LIMIT 18446744073709551615) b GROUP BY b.documentId ) ins ON doc.id = ins.documentId ").append(
      "LEFT JOIN DocumentStatus sta ON ins.statusId=sta.id ").append(
      "LEFT JOIN DocumentCategory cat ON doc.documentCategoryId=cat.id ").append(
      "LEFT JOIN User u on ins.creatorId=u.id ").append(
      "LEFT JOIN ResponsibleDocumentInstance rdi ON rdi.documentId = doc.id and rdi.responsibleId=? ").append(
      "WHERE doc.status != 'DELETED' and doc.status != 'DISABLE' and doc.contextType ='Account' AND doc.active ='Y' ");

    if (StringUtils.hasText(queryText)) {
      sql.append(" AND (").append("doc.name like '%").append(queryText).append("%'").append("OR cat.name like '%")
        .append(queryText).append("%'").append("OR ins.fileName like '%").append(queryText).append("%'").append(") ");
    }

    if (size > 0) {
      sql.append("LIMIT ").append(start).append(", ").append(size);
    }

    return getJdbcTemplate().query(sql.toString(), new Object[] { responsibleId, responsibleId },
        workflowDocumentMapper);
  } // end method readWorkflowDocument
} // end class WorkflowRepositoryJdbcImpl
