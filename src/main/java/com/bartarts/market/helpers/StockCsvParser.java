package com.bartarts.market.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bartarts.market.model.to.SharePriceTo;
import com.bartarts.market.model.to.StockTo;

public class StockCsvParser {
	public static final int COLUMNS_COUNT = 3;
	public static final int COMPANY_NAME_INDEX = 0;
	public static final int DATE_INDEX = 1;
	public static final int PRICE_INDEX = 2;
	public static final String DELIMITER = ",";
	public static final String DATE_FORMAT = "yyyyMMdd";

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory
			.getLogger(StockCsvParser.class);
	private static SimpleDateFormat dateParser;

	public static List<StockTo> parseCSV(InputStream data) throws IOException,
			NumberFormatException, ParseException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				data))) {
			HashMap<String, List<SharePriceTo>> sharePrices = new HashMap<>();
			String line;

			while ((line = reader.readLine()) != null) {
				String[] splittedLine = line.split(DELIMITER);
				if (splittedLine.length != COLUMNS_COUNT)
					continue;

				String companyName = splittedLine[COMPANY_NAME_INDEX].trim();
				String dateString = splittedLine[DATE_INDEX].trim();
				String priceString = splittedLine[PRICE_INDEX].trim();

				// LOGGER.info("companyName: " + companyName);
				// LOGGER.info("dateString: " + dateString);
				// LOGGER.info("priceString: " + priceString);

				List<SharePriceTo> sharePricesList = getListOrPutIfNotExists(
						sharePrices, companyName);
				sharePricesList.add(new SharePriceTo(null,
						parseDate(dateString), new BigDecimal(priceString),
						null));
			}

			return sharePrices
					.entrySet()
					.stream()
					.map(entry -> new StockTo(null, entry.getKey(), entry
							.getValue())).collect(Collectors.toList());
		}
	}

	private static List<SharePriceTo> getListOrPutIfNotExists(
			HashMap<String, List<SharePriceTo>> map, String key) {
		List<SharePriceTo> list = map.get(key);
		if (list == null) {
			list = new ArrayList<>();
			map.put(key, list);
		}
		return list;
	}

	private static Date parseDate(String dateString) throws ParseException {
		if (dateParser == null)
			dateParser = new SimpleDateFormat(DATE_FORMAT);
		return dateParser.parse(dateString);
	}
}
