package com.mangkyu.currency.exchanger.app.exchangerate.domain.port.out;

import com.mangkyu.currency.exchanger.app.exchangerate.adapter.persistence.AddExchangeRateHistoryRequest;

public interface SaveExchangeRateHistoryPort {
    void save(final AddExchangeRateHistoryRequest request);
}
