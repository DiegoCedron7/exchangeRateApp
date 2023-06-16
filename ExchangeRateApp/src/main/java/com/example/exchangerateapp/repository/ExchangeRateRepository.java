package com.example.exchangerateapp.repository;


import com.example.exchangerateapp.model.ExchangeRate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExchangeRateRepository extends MongoRepository<ExchangeRate, String> {
    ExchangeRate findExchangeRateByBaseCurrency(String baseCurrency);
}
