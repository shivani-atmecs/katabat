package com.cmc.credagility.core.domain.channel;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmc.credagility.core.domain.account.Account;
import com.cmc.credagility.core.domain.base.BaseEntity;
import com.cmc.credagility.core.domain.portfolio.Portfolio;
import com.cmc.credagility.core.domain.responsible.Responsible;
import com.cmc.credagility.core.jpa.converter.StringEncryptionConverter;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  10/15/2014 14:33
 */
@Entity
@Table(
  name    = "ClientSmartPdfChannelData",
  indexes = {
    @Index(
      name = "ruleBatchIdIndex",
      columnList = "ruleBatchId"
    ), @Index(
      name = "strategyDateIndex",
      columnList = "strategyDate"
    )
  }
)
public class ClientSmartPdfChannelData extends BaseEntity implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** Use serialVersionUID for interoperability. */
  private static final long serialVersionUID = -116400292249435167L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "accountNum",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Account account;


  /** TODO: DOCUMENT ME! */
  @Column(
    name      = "balance",
    precision = 19,
    scale     = 2
  )
  protected String balance;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "clientSmartPdfChannelDataId",
    nullable = false
  )
  @GeneratedValue(strategy = IDENTITY)
  @Id protected Long clientSmartPdfChannelDataId;

  /** AccountNumber from another system. */
  protected Long data1;

  /** First Due Date Word. */
  protected String data10;

  /** Last Payment Amt. */
  protected String data11;

  /** Last Pmt Date. */
  protected String data12;

  /** Letter Settlement Amt. */
  protected String data13;

  /** Letter Settlement Rate. */
  protected String data14;

  /** Letter Settlement Saving. */
  protected String data15;

  /** Loan ID. */
  protected String data16;

  /** Loan Suffix Number. */
  protected String data17;

  /** Nbr of Payments Behind. */
  protected String data18;

  /** Next Monthly Pmt Amt. */
  protected String data19;

  /** 800 number. */
  protected String data2;

  /** Past Due Amt. */
  protected String data20;

  /** Present Amt Due. */
  protected String data21;

  /** Loan Program Name. */
  protected String data22;

  /** last Contact Date. */
  protected String data23;

  /** PTP Amount 1. */
  protected String data24;

  /** PTP Date 1. */
  protected String data25;

  /** PTP Amount 2. */
  protected String data26;

  /** PTP Date 2. */
  protected String data27;

  /** PTP Amount 3. */
  protected String data28;

  /** PTP Date 3. */
  protected String data29;

  /** Cosigner First. */
  protected String data3;

  /** PTP Amount 4. */
  protected String data30;

  /** PTP Date 4. */
  protected String data31;

  /** PTP Amount 5. */
  protected String data32;

  /** PTP Date 5. */
  protected String data33;

  /** PTP Amount 6. */
  protected String data34;

  /** PTP Date 6. */
  protected String data35;

  /** PTP Amount 7. */
  protected String data36;

  /** PTP Date 7. */
  protected String data37;

  /** PTP Amount 8. */
  protected String data38;

  /** PTP Date 8. */
  protected String data39;

  /** Cosigner Last. */
  protected String data4;

  /** PTP Amount 9. */
  protected String data40;

  /** PTP Date 9. */
  protected String data41;

  /** PTP Amount 10. */
  protected String data42;

  /** PTP Date 10. */
  protected String data43;

  /** PTP Amount 11. */
  protected String data44;

  /** PTP Date 11. */
  protected String data45;

  /** PTP Amount 12. */
  protected String data46;

  /** PTP Date 12. */
  protected String data47;

  /** Broken PTP Amount. */
  protected String data48;

  /** Broken PTP Date. */
  protected String data49;

  /** Cosigner First Last Name. */
  protected String data5;

  /** School Name. */
  protected String data50;

  /** Signature Line. */
  protected String data51;

  /** Today's Date word. */
  protected String data52;

  /** Today's Date num. */
  protected String data53;

  /** Client Website. */
  protected String data54;

  /** Video URL. */
  protected String data55;

  /** Hours of Operation. */
  protected String data56;

  /** Group Number. */
  protected String data57;

  /** Reference Number. */
  protected String data58;

  /** Days Delinquent. */
  protected String data6;

  /** Due Date numerical. */
  protected String data7;

  /** Due Date Word. */
  protected String data8;

  /** First Due Date Numerical. */
  protected String data9;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "emailAddress",
    nullable = true,
    length   = 80
  )
  protected String emailAddress;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "firstName",
    length = 50
  )
  protected String firstName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "fullName",
    length = 100
  )
  protected String fullName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "lastName",
    length = 50
  )
  protected String lastName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "originalAccountNumber",
    length = 80
  )
  @Convert(converter = StringEncryptionConverter.class)
  protected String originalAccountNumber;

  /** left 5 of the zipCode field. */
  @Column(
    name   = "password",
    length = 15
  )
  protected String password;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(name = "portfolioId")
  @ManyToOne(fetch = FetchType.LAZY)
  protected Portfolio portfolio;


  /** TODO: DOCUMENT ME! */
  @JoinColumn(
    name     = "respensibleId",
    nullable = true
  )
  @ManyToOne(fetch = FetchType.LAZY)
  protected Responsible responsible;


  /** TODO: DOCUMENT ME! */
  @Column(name = "ruleBatchId")
  protected Long ruleBatchId;


  /** TODO: DOCUMENT ME! */
  @Convert(converter = StringEncryptionConverter.class)
  protected String ssn;

  /**
   * INIT/ SKIPPED/ EXPORTED - "INIT" when the record is inserted to the table. "SKIPPED" when the record is skipped
   * while exporting to EMM due to missing data. "EXPORTED" when the record is exported to EMM
   */
  protected String status;


  /** TODO: DOCUMENT ME! */
  @Column(
    name     = "strategyDate",
    nullable = false
  )
  @Temporal(TemporalType.TIMESTAMP)
  protected Date strategyDate;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "templateId",
    length = 10
  )
  protected String templateId;

  /**
   * when the template Id (email letter code in the file) is "B5" then template Name should be
   * "PDF_SLMChargeOffFinalNotice". When the template Id is "B6" the template name should be "PDF_SLM120Day"
   */
  @Column(
    name   = "templateName",
    length = 50
  )
  protected String templateName;


  /** TODO: DOCUMENT ME! */
  @Column(
    name   = "zipCode",
    length = 10
  )
  protected String zipCode;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for account.
   *
   * @return  Account
   */
  public Account getAccount() {
    return account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for balance.
   *
   * @return  String
   */
  public String getBalance() {
    return balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for client smart pdf channel data id.
   *
   * @return  Long
   */
  public Long getClientSmartPdfChannelDataId() {
    return clientSmartPdfChannelDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data1.
   *
   * @return  Long
   */
  public Long getData1() {
    return data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data10.
   *
   * @return  String
   */
  public String getData10() {
    return data10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data11.
   *
   * @return  String
   */
  public String getData11() {
    return data11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data12.
   *
   * @return  String
   */
  public String getData12() {
    return data12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data13.
   *
   * @return  String
   */
  public String getData13() {
    return data13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data14.
   *
   * @return  String
   */
  public String getData14() {
    return data14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data15.
   *
   * @return  String
   */
  public String getData15() {
    return data15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data16.
   *
   * @return  String
   */
  public String getData16() {
    return data16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data17.
   *
   * @return  String
   */
  public String getData17() {
    return data17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data18.
   *
   * @return  String
   */
  public String getData18() {
    return data18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data19.
   *
   * @return  String
   */
  public String getData19() {
    return data19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data2.
   *
   * @return  String
   */
  public String getData2() {
    return data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data20.
   *
   * @return  String
   */
  public String getData20() {
    return data20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data21.
   *
   * @return  String
   */
  public String getData21() {
    return data21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data22.
   *
   * @return  String
   */
  public String getData22() {
    return data22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data23.
   *
   * @return  String
   */
  public String getData23() {
    return data23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data24.
   *
   * @return  String
   */
  public String getData24() {
    return data24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data25.
   *
   * @return  String
   */
  public String getData25() {
    return data25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data26.
   *
   * @return  String
   */
  public String getData26() {
    return data26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data27.
   *
   * @return  String
   */
  public String getData27() {
    return data27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data28.
   *
   * @return  String
   */
  public String getData28() {
    return data28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data29.
   *
   * @return  String
   */
  public String getData29() {
    return data29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data3.
   *
   * @return  String
   */
  public String getData3() {
    return data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data30.
   *
   * @return  String
   */
  public String getData30() {
    return data30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data31.
   *
   * @return  String
   */
  public String getData31() {
    return data31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data32.
   *
   * @return  String
   */
  public String getData32() {
    return data32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data33.
   *
   * @return  String
   */
  public String getData33() {
    return data33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data34.
   *
   * @return  String
   */
  public String getData34() {
    return data34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data35.
   *
   * @return  String
   */
  public String getData35() {
    return data35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data36.
   *
   * @return  String
   */
  public String getData36() {
    return data36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data37.
   *
   * @return  String
   */
  public String getData37() {
    return data37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data38.
   *
   * @return  String
   */
  public String getData38() {
    return data38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data39.
   *
   * @return  String
   */
  public String getData39() {
    return data39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data4.
   *
   * @return  String
   */
  public String getData4() {
    return data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data40.
   *
   * @return  String
   */
  public String getData40() {
    return data40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data41.
   *
   * @return  String
   */
  public String getData41() {
    return data41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data42.
   *
   * @return  String
   */
  public String getData42() {
    return data42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data43.
   *
   * @return  String
   */
  public String getData43() {
    return data43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data44.
   *
   * @return  String
   */
  public String getData44() {
    return data44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data45.
   *
   * @return  String
   */
  public String getData45() {
    return data45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data46.
   *
   * @return  String
   */
  public String getData46() {
    return data46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data47.
   *
   * @return  String
   */
  public String getData47() {
    return data47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data48.
   *
   * @return  String
   */
  public String getData48() {
    return data48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data49.
   *
   * @return  String
   */
  public String getData49() {
    return data49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data5.
   *
   * @return  String
   */
  public String getData5() {
    return data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data50.
   *
   * @return  String
   */
  public String getData50() {
    return data50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data51.
   *
   * @return  String
   */
  public String getData51() {
    return data51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data52.
   *
   * @return  String
   */
  public String getData52() {
    return data52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data53.
   *
   * @return  String
   */
  public String getData53() {
    return data53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data54.
   *
   * @return  String
   */
  public String getData54() {
    return data54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data55.
   *
   * @return  String
   */
  public String getData55() {
    return data55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data56.
   *
   * @return  String
   */
  public String getData56() {
    return data56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data57.
   *
   * @return  String
   */
  public String getData57() {
    return data57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data58.
   *
   * @return  String
   */
  public String getData58() {
    return data58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data6.
   *
   * @return  String
   */
  public String getData6() {
    return data6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data7.
   *
   * @return  String
   */
  public String getData7() {
    return data7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data8.
   *
   * @return  String
   */
  public String getData8() {
    return data8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for data9.
   *
   * @return  String
   */
  public String getData9() {
    return data9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for email address.
   *
   * @return  String
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for first name.
   *
   * @return  String
   */
  public String getFirstName() {
    return firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for full name.
   *
   * @return  String
   */
  public String getFullName() {
    return fullName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for last name.
   *
   * @return  String
   */
  public String getLastName() {
    return lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for original account number.
   *
   * @return  String
   */
  public String getOriginalAccountNumber() {
    return originalAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for password.
   *
   * @return  String
   */
  public String getPassword() {
    return password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for portfolio.
   *
   * @return  Portfolio
   */
  public Portfolio getPortfolio() {
    return portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for responsible.
   *
   * @return  Responsible
   */
  public Responsible getResponsible() {
    return responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for rule batch id.
   *
   * @return  Long
   */
  public Long getRuleBatchId() {
    return ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for ssn.
   *
   * @return  String
   */
  public String getSsn() {
    return ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for status.
   *
   * @return  String
   */
  public String getStatus() {
    return status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for strategy date.
   *
   * @return  Date
   */
  public Date getStrategyDate() {
    return strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template id.
   *
   * @return  String
   */
  public String getTemplateId() {
    return templateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for template name.
   *
   * @return  String
   */
  public String getTemplateName() {
    return templateName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for zip code.
   *
   * @return  String
   */
  public String getZipCode() {
    return zipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for account.
   *
   * @param  account  Account
   */
  public void setAccount(Account account) {
    this.account = account;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for balance.
   *
   * @param  balance  String
   */
  public void setBalance(String balance) {
    this.balance = balance;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for client smart pdf channel data id.
   *
   * @param  clientSmartPdfChannelDataId  Long
   */
  public void setClientSmartPdfChannelDataId(Long clientSmartPdfChannelDataId) {
    this.clientSmartPdfChannelDataId = clientSmartPdfChannelDataId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data1.
   *
   * @param  data1  Long
   */
  public void setData1(Long data1) {
    this.data1 = data1;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data10.
   *
   * @param  data10  String
   */
  public void setData10(String data10) {
    this.data10 = data10;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data11.
   *
   * @param  data11  String
   */
  public void setData11(String data11) {
    this.data11 = data11;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data12.
   *
   * @param  data12  String
   */
  public void setData12(String data12) {
    this.data12 = data12;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data13.
   *
   * @param  data13  String
   */
  public void setData13(String data13) {
    this.data13 = data13;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data14.
   *
   * @param  data14  String
   */
  public void setData14(String data14) {
    this.data14 = data14;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data15.
   *
   * @param  data15  String
   */
  public void setData15(String data15) {
    this.data15 = data15;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data16.
   *
   * @param  data16  String
   */
  public void setData16(String data16) {
    this.data16 = data16;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data17.
   *
   * @param  data17  String
   */
  public void setData17(String data17) {
    this.data17 = data17;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data18.
   *
   * @param  data18  String
   */
  public void setData18(String data18) {
    this.data18 = data18;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data19.
   *
   * @param  data19  String
   */
  public void setData19(String data19) {
    this.data19 = data19;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data2.
   *
   * @param  data2  String
   */
  public void setData2(String data2) {
    this.data2 = data2;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data20.
   *
   * @param  data20  String
   */
  public void setData20(String data20) {
    this.data20 = data20;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data21.
   *
   * @param  data21  String
   */
  public void setData21(String data21) {
    this.data21 = data21;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data22.
   *
   * @param  data22  String
   */
  public void setData22(String data22) {
    this.data22 = data22;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data23.
   *
   * @param  data23  String
   */
  public void setData23(String data23) {
    this.data23 = data23;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data24.
   *
   * @param  data24  String
   */
  public void setData24(String data24) {
    this.data24 = data24;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data25.
   *
   * @param  data25  String
   */
  public void setData25(String data25) {
    this.data25 = data25;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data26.
   *
   * @param  data26  String
   */
  public void setData26(String data26) {
    this.data26 = data26;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data27.
   *
   * @param  data27  String
   */
  public void setData27(String data27) {
    this.data27 = data27;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data28.
   *
   * @param  data28  String
   */
  public void setData28(String data28) {
    this.data28 = data28;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data29.
   *
   * @param  data29  String
   */
  public void setData29(String data29) {
    this.data29 = data29;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data3.
   *
   * @param  data3  String
   */
  public void setData3(String data3) {
    this.data3 = data3;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data30.
   *
   * @param  data30  String
   */
  public void setData30(String data30) {
    this.data30 = data30;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data31.
   *
   * @param  data31  String
   */
  public void setData31(String data31) {
    this.data31 = data31;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data32.
   *
   * @param  data32  String
   */
  public void setData32(String data32) {
    this.data32 = data32;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data33.
   *
   * @param  data33  String
   */
  public void setData33(String data33) {
    this.data33 = data33;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data34.
   *
   * @param  data34  String
   */
  public void setData34(String data34) {
    this.data34 = data34;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data35.
   *
   * @param  data35  String
   */
  public void setData35(String data35) {
    this.data35 = data35;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data36.
   *
   * @param  data36  String
   */
  public void setData36(String data36) {
    this.data36 = data36;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data37.
   *
   * @param  data37  String
   */
  public void setData37(String data37) {
    this.data37 = data37;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data38.
   *
   * @param  data38  String
   */
  public void setData38(String data38) {
    this.data38 = data38;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data39.
   *
   * @param  data39  String
   */
  public void setData39(String data39) {
    this.data39 = data39;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data4.
   *
   * @param  data4  String
   */
  public void setData4(String data4) {
    this.data4 = data4;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data40.
   *
   * @param  data40  String
   */
  public void setData40(String data40) {
    this.data40 = data40;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data41.
   *
   * @param  data41  String
   */
  public void setData41(String data41) {
    this.data41 = data41;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data42.
   *
   * @param  data42  String
   */
  public void setData42(String data42) {
    this.data42 = data42;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data43.
   *
   * @param  data43  String
   */
  public void setData43(String data43) {
    this.data43 = data43;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data44.
   *
   * @param  data44  String
   */
  public void setData44(String data44) {
    this.data44 = data44;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data45.
   *
   * @param  data45  String
   */
  public void setData45(String data45) {
    this.data45 = data45;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data46.
   *
   * @param  data46  String
   */
  public void setData46(String data46) {
    this.data46 = data46;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data47.
   *
   * @param  data47  String
   */
  public void setData47(String data47) {
    this.data47 = data47;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data48.
   *
   * @param  data48  String
   */
  public void setData48(String data48) {
    this.data48 = data48;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data49.
   *
   * @param  data49  String
   */
  public void setData49(String data49) {
    this.data49 = data49;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data5.
   *
   * @param  data5  String
   */
  public void setData5(String data5) {
    this.data5 = data5;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data50.
   *
   * @param  data50  String
   */
  public void setData50(String data50) {
    this.data50 = data50;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data51.
   *
   * @param  data51  String
   */
  public void setData51(String data51) {
    this.data51 = data51;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data52.
   *
   * @param  data52  String
   */
  public void setData52(String data52) {
    this.data52 = data52;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data53.
   *
   * @param  data53  String
   */
  public void setData53(String data53) {
    this.data53 = data53;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data54.
   *
   * @param  data54  String
   */
  public void setData54(String data54) {
    this.data54 = data54;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data55.
   *
   * @param  data55  String
   */
  public void setData55(String data55) {
    this.data55 = data55;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data56.
   *
   * @param  data56  String
   */
  public void setData56(String data56) {
    this.data56 = data56;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data57.
   *
   * @param  data57  String
   */
  public void setData57(String data57) {
    this.data57 = data57;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data58.
   *
   * @param  data58  String
   */
  public void setData58(String data58) {
    this.data58 = data58;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data6.
   *
   * @param  data6  String
   */
  public void setData6(String data6) {
    this.data6 = data6;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data7.
   *
   * @param  data7  String
   */
  public void setData7(String data7) {
    this.data7 = data7;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data8.
   *
   * @param  data8  String
   */
  public void setData8(String data8) {
    this.data8 = data8;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for data9.
   *
   * @param  data9  String
   */
  public void setData9(String data9) {
    this.data9 = data9;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for email address.
   *
   * @param  emailAddress  String
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for first name.
   *
   * @param  firstName  String
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for full name.
   *
   * @param  fullName  String
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for last name.
   *
   * @param  lastName  String
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for original account number.
   *
   * @param  originalAccountNumber  String
   */
  public void setOriginalAccountNumber(String originalAccountNumber) {
    this.originalAccountNumber = originalAccountNumber;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for password.
   *
   * @param  password  String
   */
  public void setPassword(String password) {
    this.password = password;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for portfolio.
   *
   * @param  portfolio  Portfolio
   */
  public void setPortfolio(Portfolio portfolio) {
    this.portfolio = portfolio;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for responsible.
   *
   * @param  responsible  Responsible
   */
  public void setResponsible(Responsible responsible) {
    this.responsible = responsible;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for rule batch id.
   *
   * @param  ruleBatchId  Long
   */
  public void setRuleBatchId(Long ruleBatchId) {
    this.ruleBatchId = ruleBatchId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for ssn.
   *
   * @param  ssn  String
   */
  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for status.
   *
   * @param  status  String
   */
  public void setStatus(String status) {
    this.status = status;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for strategy date.
   *
   * @param  strategyDate  Date
   */
  public void setStrategyDate(Date strategyDate) {
    this.strategyDate = strategyDate;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template id.
   *
   * @param  templateId  String
   */
  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for template name.
   *
   * @param  templateName  String
   */
  public void setTemplateName(String templateName) {
    this.templateName = templateName;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for zip code.
   *
   * @param  zipCode  String
   */
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * @see  com.cmc.credagility.core.domain.base.BaseEntity#toString()
   */
  @Override public String toString() {
    final String TAB = "    ";

    StringBuilder retValue = new StringBuilder();

    retValue.append("ClientSmartPdfChannelData ( ").append("clientSmartPdfChannelDataId = ").append(
      this.clientSmartPdfChannelDataId).append(TAB).append("emailAddress = ").append(this.emailAddress).append(TAB)
      .append("fullName = ").append(this.fullName).append(TAB).append("originalAccountNumber = ").append(
      this.originalAccountNumber).append(TAB).append("balance = ").append(this.balance).append(" )");

    return retValue.toString();
  }
} // end class ClientSmartPdfChannelData
