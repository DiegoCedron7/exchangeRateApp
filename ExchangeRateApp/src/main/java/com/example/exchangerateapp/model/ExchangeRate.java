package com.example.exchangerateapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

@Document(collection = "exchange_rate")
@Data
public class ExchangeRate {
    @Id
    private String id;
    @Field("base_currency")
    private String baseCurrency;

    @Field("rates")
    private Map<String, Double> currencyRates;
}
