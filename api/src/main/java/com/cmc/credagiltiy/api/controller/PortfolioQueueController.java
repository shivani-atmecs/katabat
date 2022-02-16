package com.cmc.credagiltiy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmc.credagiltiy.api.dto.BadRequestError;
import com.cmc.credagiltiy.api.dto.PortfolioQueueNodeDTO;
import com.cmc.credagiltiy.api.service.PortfolioQueueService;

@RestController
@RequestMapping("/api/queue")
public class PortfolioQueueController {

	@Autowired
	private PortfolioQueueService service;

	@GetMapping
	public ResponseEntity<List<PortfolioQueueNodeDTO>> findAllByPortfolioId(
			@RequestParam("portfolioId") Long portfolioId) {
		if (portfolioId == null) {
			ResponseEntity.badRequest().body(new BadRequestError("portfolioId Can not be null"));
		}
		return ResponseEntity.ok().body(service.findAllByPortfolioId(portfolioId));
	}
}