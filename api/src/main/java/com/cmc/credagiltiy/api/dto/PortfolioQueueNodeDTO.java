package com.cmc.credagiltiy.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cmc.credagility.core.domain.mra.PortfolioQueueNode;

public class PortfolioQueueNodeDTO {

	private String queueName;
	private String queueId;
	private List<PortfolioQueueNodeDTO> children;

	public PortfolioQueueNodeDTO() {

	}

	public PortfolioQueueNodeDTO(PortfolioQueueNode queueNode) {
		this.queueName = queueNode.getName();
		this.queueId = queueNode.getQueueId();
		this.children = Optional.ofNullable(queueNode.getChildren())
				.map(list -> list.stream().map(PortfolioQueueNodeDTO::new).collect(Collectors.toList()))
				.orElseGet(ArrayList::new);
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getQueueId() {
		return queueId;
	}

	public void setQueueId(String queueId) {
		this.queueId = queueId;
	}

	public List<PortfolioQueueNodeDTO> getChildren() {
		return children;
	}

	public void setChildren(List<PortfolioQueueNodeDTO> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "PortfolioQueueNodeDTO [queueName=" + queueName + ", queueId=" + queueId + ", children=" + children
				+ "]";
	}

}
