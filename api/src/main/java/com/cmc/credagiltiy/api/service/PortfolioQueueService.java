package com.cmc.credagiltiy.api.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.credagility.core.domain.mra.PortfolioQueueNode;
import com.cmc.credagiltiy.api.dto.PortfolioQueueNodeDTO;
import com.cmc.credagiltiy.api.repository.PortfolioQueueRepository;
import com.cmc.credagiltiy.api.repository.StrategyMasterBatchRepository;
import com.ozstrategy.credagility.core.domain.QueueAction;

@Service
public class PortfolioQueueService {
	private final Logger logger = LoggerFactory.getLogger(PortfolioQueueService.class);

	@Autowired
	private StrategyMasterBatchRepository strategyMasterBatchRepository;

	@Autowired
	private PortfolioQueueRepository queueRepository;

	public List<PortfolioQueueNodeDTO> findAllByPortfolioId(Long portfolioId) {

		logger.info("portfolioId: {}", portfolioId);

		List<Long> scheduleIds = strategyMasterBatchRepository.getActiveQueueScheduleIds();

		List<Object[]> queueActions = queueRepository.getActiveAgentTreeQueuesByPortfolioIds(scheduleIds, portfolioId);
		System.out.println("QueryService: queueActions--" + queueActions);

		Map<PortfolioQueueNode, List<QueueAction>> allQueues = buildPortfolioQueueNodeMap(queueActions);
		System.out.println("QueryService: queueMap --" + allQueues);

		List<Object[]> allAssignedQueueActions = queueRepository.getAllAgentAccountAssignmentQueues(portfolioId);

		Map<PortfolioQueueNode, List<QueueAction>> allAssigmentQueues = buildPortfolioQueueNodeMap(
				allAssignedQueueActions);

		Map<PortfolioQueueNode, List<QueueAction>> merged = this.mergeAgentAssignmentQueue(allQueues,
				allAssigmentQueues);

		List<PortfolioQueueNode> portfolioNodeList = buildPortfolioQueueNodes(merged);
		List<PortfolioQueueNodeDTO> portfolioQueues = Optional.ofNullable(portfolioNodeList)
				.map(nodeList -> nodeList.stream().map(PortfolioQueueNodeDTO::new).collect(Collectors.toList()))
				.orElseGet(ArrayList::new);

		System.out.println("QueryService: portfolioNodeList --" + portfolioQueues);
		System.out.println("QueryService: portfolioNodeList.size --" + portfolioQueues.size());

		return portfolioQueues;
	}

	private Map<PortfolioQueueNode, List<QueueAction>> mergeAgentAssignmentQueue(
			Map<PortfolioQueueNode, List<QueueAction>> queues, Map<PortfolioQueueNode, List<QueueAction>> assignments) {
		if ((queues == null) || queues.isEmpty()) {
			return assignments;
		}

		if ((assignments == null) || assignments.isEmpty()) {
			return queues;
		}

		Map<PortfolioQueueNode, List<QueueAction>> result = new HashMap<>();
		Set<PortfolioQueueNode> mergedKey = new LinkedHashSet<>(queues.keySet());
		mergedKey.addAll(assignments.keySet());

		for (PortfolioQueueNode node : mergedKey) {
			List<QueueAction> queueList = queues.get(node);
			List<QueueAction> assignmentList = assignments.get(node);

			if ((queueList == null) && (assignmentList != null)) {
				result.put(node, assignmentList);
			}

			if ((queueList != null) && (assignmentList == null)) {
				result.put(node, queueList);
			}

			if ((queueList != null) && (assignmentList != null)) {
				queueList.addAll(assignmentList);
				result.put(node, queueList);
			}
		}

		return result;
	} // end method mergeAgentAssignmentQueue

	private Map<PortfolioQueueNode, List<QueueAction>> buildPortfolioQueueNodeMap(List<?> queueActions) {
		Long start = System.currentTimeMillis();
		Map<PortfolioQueueNode, List<QueueAction>> portfolioQueueMap = new LinkedHashMap<PortfolioQueueNode, List<QueueAction>>();

		for (Object objs : queueActions) {
			Object[] objects = (Object[]) objs;
			String portfolioNameWithId = (String) objects[4] + "!" + (BigInteger) objects[3];
			String actionType = (objects.length > 7) ? (String) objects[7] : null;
			PortfolioQueueNode portfolioNode = new PortfolioQueueNode(portfolioNameWithId, "Portfolio", 0);

			List<QueueAction> queues;

			if (portfolioQueueMap.containsKey(portfolioNode)) {
				queues = portfolioQueueMap.get(portfolioNode);
			} else {
				queues = new ArrayList<QueueAction>();
			}

			QueueAction queueAction = new QueueAction();
			queueAction.setPath((objects[2] == null) ? null : (String) objects[2]);
			queueAction.setId((objects[0] == null) ? null : ((BigInteger) objects[0]).longValue());
			queueAction.setName((objects[1] == null) ? null : (String) objects[1]);
			queueAction.setActionType(actionType);
			queues.add(queueAction);
			portfolioQueueMap.put(portfolioNode, queues);
		} // end for

		Long end = System.currentTimeMillis();

		if (logger.isDebugEnabled()) {
			logger.debug("buildPortfolioQueueNodeMap cost time : " + (end - start) + " ms.");
		}

		return portfolioQueueMap;
	} // end method buildPortfolioQueueNodeMap

	private List<PortfolioQueueNode> buildPortfolioQueueNodes(Map<PortfolioQueueNode, List<QueueAction>> allQueues) {
		Long start = System.currentTimeMillis();
		List<PortfolioQueueNode> result = new ArrayList<PortfolioQueueNode>();

		for (PortfolioQueueNode portfolioNode : allQueues.keySet()) {
			List<QueueAction> queues = allQueues.get(portfolioNode);
			Set<String> queueNameIds = new LinkedHashSet<String>();
			StringBuilder path = new StringBuilder();
			Map<String, String> queueActionTypeMap = new HashMap<>();
			int loopIndex = 0;

			for (QueueAction queue : queues) {
				String queueNameId = queue.getName() + "!" + queue.getId();
				queueNameIds.add(queueNameId);
				queueActionTypeMap.put(queueNameId, queue.getActionType());

				if ((queue.getPath() == null) || "".equals(queue.getPath())) {
					queue.setPath("");
				}

				path.append(queue.getPath());
				loopIndex++;

				if (loopIndex < queues.size()) {
					path.append(",");
				}
			}

			// String newPath = filterSuitQueuePath(path.toString(), "<", queueNameIds);

			if (logger.isDebugEnabled()) {
				logger.debug("Build portfolio queue nodes path:  ------>>>>>" + path.toString());
				// log.debug("Build portfolio queue nodes new path: ------>>>>>" + newPath);
			}

			Long start0 = System.currentTimeMillis();
			List<PortfolioQueueNode> graph = buildTreeNodeGraph(path.toString(), "<", queueNameIds, queueActionTypeMap);
			Long end0 = System.currentTimeMillis();

			if (logger.isDebugEnabled()) {
				logger.debug("single buildTreeNodeGraph cost time : " + (end0 - start0) + " ms.");
			}

			portfolioNode.addChildren(graph);
			result.add(portfolioNode);
		} // end for

		Long end = System.currentTimeMillis();

		if (logger.isDebugEnabled()) {
			logger.debug("buildPortfolioQueueNodes cost time : " + (end - start) + " ms.");
		}

		// Collections.sort(result);

		return result;
	} // end method buildPortfolioQueueNodes

	public List<PortfolioQueueNode> buildTreeNodeGraph(String path, String splitTag, Set<String> queueNameIds,
			Map<String, String> queueActionTypeMap) {
		// String[] bp = path.split(",");
		//
		// Map<String, Map<String, LinkedHashSet<String>>> resultMap =
		// new LinkedHashMap<String, Map<String, LinkedHashSet<String>>>();
		List<PortfolioQueueNode> queueViews = new ArrayList<PortfolioQueueNode>();
		Long start = System.currentTimeMillis();

		// for (String exp : bp) {
		// String[] xp = exp.split(splitTag);
		// String child = xp[0];
		//
		// if (log.isDebugEnabled()) {
		// log.debug("loop child : " + child + " for exp : " + exp);
		// }
		//
		// // Check path if contain unAssign queue path. like below :
		// // AA New In!2212<Case Gold Agent A!1294,AA New In!2212<CaseGold!1402,AA New
		// In!2212<SPC!1606"
		// // If CaseGold!1402 is not assign to the access role. then we will cutting
		// the path."
		//
		// if (queueNameIds.contains(child)) {
		// Map<String, LinkedHashSet<String>> queues = new LinkedHashMap<String,
		// LinkedHashSet<String>>();
		// String parent = xp[xp.length - 1];
		// LinkedHashSet<String> ch = new LinkedHashSet<String>();
		//
		// if (xp.length > 1) {
		// ch.add(child);
		// }
		//
		// if (queueNameIds.contains(parent)) {
		// queues.put(parent, ch);
		// }
		//
		// String root = buildTreeData(parent, child, child, bp, splitTag, 0, 0, queues,
		// queueNameIds);
		//
		// if (log.isDebugEnabled()) {
		// log.debug("Root queue : ------>>>>>" + root);
		// log.debug("queues : ------>>>>>" + queues);
		// }
		//
		// if (!resultMap.containsKey(root)) {
		// resultMap.put(root, queues);
		// } else {
		// Map<String, LinkedHashSet<String>> existChildren = resultMap.get(root);
		//
		// for (String cc : queues.keySet()) {
		// if (existChildren.containsKey(cc)) {
		// existChildren.get(cc).addAll(queues.get(cc));
		// } else {
		// existChildren.put(cc, queues.get(cc));
		// }
		// }
		//
		// resultMap.put(root, existChildren);
		// }
		// } // end if
		//
		// } // end for

		List<String> list = Arrays.asList(path.split(","));
		Map<String, Set<String>> nodeMap = new ConcurrentHashMap<String, Set<String>>();
		list.parallelStream().forEach(param -> {
			Set<String> childSet = new LinkedHashSet<String>();
			String[] nodes = param.split(splitTag);
			String child = nodes[0];
			String parent = nodes[nodes.length - 1];

			if (queueNameIds.contains(child)) {
				if (nodes.length > 1) {
					System.arraycopy(nodes, 0, nodes, nodes.length - 1, nodes.length - 1);
					childSet.addAll(Arrays.asList(nodes));
				}

				if ((parent != null) && queueNameIds.contains(parent)) {
					if (nodeMap.get(parent) != null) {
						nodeMap.get(parent).addAll(childSet);
					} else {
						nodeMap.put(parent, childSet);
					}
				}
			}
		});

		Long end = System.currentTimeMillis();

		if (logger.isDebugEnabled()) {
			logger.debug("buildTreeData cost time : " + (end - start) + " ms.");
		}

		Long start1 = System.currentTimeMillis();

		// for (String s : resultMap.keySet()) {
		// Map<String, LinkedHashSet<String>> childMap = resultMap.get(s);
		// LinkedHashMap<String, PortfolioQueueNode> addedChildMap = new
		// LinkedHashMap<String, PortfolioQueueNode>();
		// PortfolioQueueNode rootNode = new PortfolioQueueNode(s, null, 0);
		// buildTreeNode(childMap, rootNode, 0, addedChildMap);
		// queueViews.add(rootNode);
		// }

		for (String key : nodeMap.keySet()) {
			LinkedHashSet<String> set = (LinkedHashSet<String>) nodeMap.get(key);
			Map<String, LinkedHashSet<String>> childMap = new HashMap<String, LinkedHashSet<String>>();
			childMap.put(key, set);

			LinkedHashMap<String, PortfolioQueueNode> addedChildMap = new LinkedHashMap<String, PortfolioQueueNode>();
			PortfolioQueueNode rootNode = new PortfolioQueueNode(key, null, 0);
			// rootNode.setActionType(queueActionTypeMap.get(key));
			buildTreeNode(childMap, rootNode, 0, addedChildMap, queueActionTypeMap);
			queueViews.add(rootNode);
		}

		Long end1 = System.currentTimeMillis();

		if (logger.isDebugEnabled()) {
			logger.debug("buildTreeNode cost time : " + (end1 - start1) + " ms.");
		}

		return queueViews;
	} // end method buildTreeNodeGraph

	private static void buildTreeNode(Map<String, LinkedHashSet<String>> childMap, PortfolioQueueNode parentNode,
			Integer level, LinkedHashMap<String, PortfolioQueueNode> addedChildMap,
			Map<String, String> queueActionTypeMap) {
		LinkedHashSet<String> children = childMap.get(parentNode.getNameWithId());

		if ((children != null) && (children.size() > 0)) {
			level++;

			for (String child : children) {
				PortfolioQueueNode childNode;

				if (addedChildMap.containsKey(child)) {
					childNode = addedChildMap.get(child);

					if (childNode.getLevel() < level) {
						childNode.getParentNode().getChildren().remove(childNode);
						childNode.setLevel(level);
						childNode.setParentNode(parentNode);
						parentNode.addChild(childNode);
						addedChildMap.put(child, childNode);
					} else if (childNode.getLevel() == level) {
						childNode = new PortfolioQueueNode(child, null, level);
						// childNode.setActionType(queueActionTypeMap.get(child));
						childNode.setParentNode(parentNode);
						parentNode.addChild(childNode);
						addedChildMap.put(child, childNode);
					}
				} else {
					childNode = new PortfolioQueueNode(child, null, level);
					// childNode.setActionType(queueActionTypeMap.get(child));
					childNode.setParentNode(parentNode);
					parentNode.addChild(childNode);
					addedChildMap.put(child, childNode);
				}

				buildTreeNode(childMap, childNode, level, addedChildMap, queueActionTypeMap);
			} // end for

			// }
		} // end if
	} // end method buildTreeNode
}
