package com.example.exchangerateapp.controller;

import com.example.exchangerateapp.model.ExchangeRate;
import com.example.exchangerateapp.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ExchangeRateController {
    private final ExchangeRateService exchangeRateService;

    @GetMapping("/getCurrency/{base}")
    public ExchangeRate getByBaseCurrency(@PathVariable String base) {
        return exchangeRateService.findExchangeRateByBaseCurrency(base);
    }

    @GetMapping("/convert/{base}")
    public double convertCurrency(@PathVariable String base, @RequestParam("amount") double amount, @RequestParam("destinationCurrency") String destinationCurrency) {
        String upperDestinationCurrency = destinationCurrency.toUpperCase();
        String upperBase = base.toUpperCase();
        return exchangeRateService.convertCurrency(amount, upperBase, upperDestinationCurrency);
    }
}




