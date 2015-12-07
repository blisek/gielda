package com.bartarts.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bartarts.market.model.to.WalletTo;
import com.bartarts.market.services.WalletService;

@Controller
@RequestMapping("/brokerage/wallet")
public class WalletController {

	@Autowired
	private WalletService walletService;

	@RequestMapping(method = { RequestMethod.GET })
	public @ResponseBody WalletTo getWallet(@RequestParam("id") Long id) {
		return walletService.findById(id);
	}

	@RequestMapping("/open")
	public @ResponseBody WalletTo openWallet(
			@RequestParam("first_name") String firstName,
			@RequestParam("last_name") String lastName) {
		WalletTo wTo = new WalletTo(null, firstName, lastName, null, null);
		wTo = walletService.save(wTo);
		return wTo;
	}

	@RequestMapping(path = { "/close" }, method = { RequestMethod.DELETE })
	@ResponseStatus(code = HttpStatus.OK)
	public void closeWallet(@RequestParam("id") Long id) {

	}
}
