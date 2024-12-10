package dev.stranik.lab16.utils;

import java.util.Map;

public class ExchangeRateResponse {
    private Map<String, Double> rates;

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }
}
