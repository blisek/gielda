package com.bartarts.market;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.bartarts.market.helpers.StockCsvParser;
import com.bartarts.market.model.to.StockTo;
import com.bartarts.market.services.StockService;

@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(Application.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		if (args.length > 0) {
			LOGGER.info("Parsing csv files started...");
			StockService stockService = ctx.getBean("stockService",
					StockService.class);
			Arrays.stream(args).forEach(
					arg -> {
						try {
							File f = new File(arg);
							List<StockTo> parsed = StockCsvParser
									.parseCSV(new FileInputStream(f));
							stockService.saveAll(parsed);
						} catch (Exception e) {
							LOGGER.warn(String.format(
									"Exception while parsing [%s]", arg), e);
						}
					});
			LOGGER.info("Parsing csv files finished.");
		}
	}
}
