package com.bartarts.market.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bartarts.market.business.brokerage.Brokerage;
import com.bartarts.market.business.structures.CounterOffer;
import com.bartarts.market.business.structures.Offer;
import com.bartarts.market.helpers.CurrencyHelper;
import com.bartarts.market.model.to.SavingTo;
import com.bartarts.market.model.to.SharePriceTo;
import com.bartarts.market.model.to.ShareTo;
import com.bartarts.market.model.to.WalletTo;
import com.bartarts.market.services.SharePriceService;
import com.bartarts.market.services.StockService;
import com.bartarts.market.services.WalletService;

@Controller
@RequestMapping("/brokerage/shares")
public class ShareController {

	@Autowired
	private StockService stockService;

	@Autowired
	private SharePriceService sharePriceService;

	@Autowired
	private WalletService walletService;

	@Autowired
	private Brokerage brokerage;

	@RequestMapping(path = { "/buy" }, method = { RequestMethod.POST })
	public @ResponseBody ShareTo buyShares(
			@RequestParam("wallet_id") Long wallet_id,
			@RequestParam("share_price_id") Long share_price_id,
			@RequestParam("quantity") Long quantity) {
		SharePriceTo sharePriceTo = sharePriceService.findById(share_price_id);
		Long stockId = sharePriceTo.getStockId();
		WalletTo wallet = walletService.findById(wallet_id);
		Optional<SavingTo> savingPLN = wallet.getSavings().stream()
				.filter(s -> CurrencyHelper.PLN.equals(s.getCurrency()))
				.findFirst();

		SavingTo plnSavings = savingPLN.get();
		Offer offer = new Offer(plnSavings.getQuantity(),
				sharePriceTo.getPrice(), quantity);
		CounterOffer counterOffer = brokerage.buy(offer);

		Optional<ShareTo> holderShare = wallet.getShares().stream()
				.filter(s -> s.getStock().getId() == stockId).findFirst();
		ShareTo shareTo = null;
		if (holderShare.isPresent()) {
			shareTo = holderShare.get();
			shareTo.setQuantity(shareTo.getQuantity()
					+ counterOffer.getAmount());
		} else {
			shareTo = new ShareTo(null, counterOffer.getAmount(), wallet,
					stockService.findById(stockId));
			wallet.getShares().add(shareTo);
		}

		plnSavings.setQuantity(plnSavings.getQuantity().subtract(
				counterOffer.getTotalPrice()));
		walletService.update(wallet);
		return shareTo;
	}

	@RequestMapping(path = { "/sell" }, method = { RequestMethod.POST })
	public @ResponseBody ShareTo sellShares(
			@RequestParam("wallet_id") Long wallet_id,
			@RequestParam("share_price_id") Long share_price_id,
			@RequestParam("quantity") Long quantity) {
		return null;
	}
}
