package com.bartarts.market.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bartarts.market.helpers.DateHelper;
import com.bartarts.market.model.to.SharePriceTo;
import com.bartarts.market.services.SharePriceService;

@Controller
@RequestMapping("/stock/shares")
public class SharePriceController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SharePriceController.class);

	@Autowired
	private SharePriceService sharePriceService;

	@RequestMapping("/between")
	public @ResponseBody List<SharePriceTo> sharePricesBetween(
			@RequestParam("start") String start, @RequestParam("end") String end) {
		try {
			Date ds = DateHelper.parseDate(DateHelper.DATABASE_DATE_MUSTER,
					start);
			Date de = DateHelper
					.parseDate(DateHelper.DATABASE_DATE_MUSTER, end);
			return sharePriceService.findByDateBetween(ds, de);
		} catch (Exception e) {
			LOGGER.error(
					String.format("While parsing [%s] and [%s]:", start, end),
					e);
			return new ArrayList<>();
		}
	}
}
