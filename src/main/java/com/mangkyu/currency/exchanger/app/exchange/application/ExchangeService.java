package com.mangkyu.currency.exchanger.app.exchange.application;

import com.mangkyu.currency.exchanger.app.exchange.domain.port.in.ExchangeUseCase;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeErrorCode;
import com.mangkyu.currency.exchanger.app.exchange.error.ExchangeException;
import com.mangkyu.currency.exchanger.app.exchangerate.domain.port.in.GetExchangeRateUseCase;
import com.mangkyu.currency.exchanger.app.money.domain.Currency;
import com.mangkyu.currency.exchanger.app.money.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExchangeService implements ExchangeUseCase {

    private final GetExchangeRateUseCase getExchangeRateUseCase;

    @Override
    public Money exchangeMoney(final Money money, final Currency target) {
        if (!Currency.canBeTarget(target)) {
            throw new ExchangeException(ExchangeErrorCode.INVALID_TARGET_CURRENCY);
        }

        final double exchangeRate = getExchangeRateUseCase.getExchangeRate(money.getCurrency(), target);
        return money.exchange(exchangeRate, target);
    }

}
