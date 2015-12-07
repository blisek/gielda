package com.bartarts.market.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bartarts.market.helpers.DateHelper;
import com.bartarts.market.model.to.StockTo;
import com.bartarts.market.services.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	@RequestMapping(path = { "/all" }, method = { RequestMethod.GET })
	public @ResponseBody List<StockTo> stockAll() {
		return stockService.findAll();
	}

	@RequestMapping("/between")
	public @ResponseBody List<StockTo> stockBetweenDates(
			@RequestParam("start") String start, @RequestParam("end") String end) {
		try {
			Date ds = DateHelper.parseDate(DateHelper.DATABASE_DATE_MUSTER,
					start);
			Date de = DateHelper
					.parseDate(DateHelper.DATABASE_DATE_MUSTER, end);
			return stockService.findAllByDateBetween(ds, de);
		} catch (Exception e) {
			LOGGER.error(
					String.format("While parsing [%s] and [%s]:", start, end),
					e);
			return new ArrayList<>();
		}
	}

	@RequestMapping("/by-date")
	public @ResponseBody List<StockTo> stockByDate(
			@RequestParam("date") String stringDate) {
		try {
			Date date = DateHelper.parseDate(DateHelper.DATABASE_DATE_MUSTER,
					stringDate);
			return stockService.findAllByDate(date);
		} catch (Exception e) {
			LOGGER.error(String.format("While parsing [%s]", stringDate), e);
			return new ArrayList<>();
		}
	}

	@RequestMapping("/")
	public @ResponseBody String something() {
		return "hello";
	}
}
