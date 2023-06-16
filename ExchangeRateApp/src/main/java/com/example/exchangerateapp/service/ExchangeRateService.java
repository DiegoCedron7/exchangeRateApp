package com.example.exchangerateapp.service;

import com.example.exchangerateapp.model.ExchangeRate;
import com.example.exchangerateapp.repository.ExchangeRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class ExchangeRateService {
    private final ExchangeRateRepository exchangeRateRepository;

    public ExchangeRate findExchangeRateByBaseCurrency(String baseCurrency) {
        return exchangeRateRepository.findExchangeRateByBaseCurrency(baseCurrency);
    }

    public double convertCurrency(double amount, String baseCurrency, String destinationCurrency) {
        ExchangeRate exchangeRate = exchangeRateRepository.findExchangeRateByBaseCurrency(baseCurrency);

        Map<String, Double> rates = exchangeRate.getCurrencyRates();
        Double destinationRate = rates.get(destinationCurrency);

        if (destinationRate == null) throw new IllegalArgumentException("No existe papu.");

        return amount * destinationRate;
    }
}
