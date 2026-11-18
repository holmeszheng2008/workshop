package com.ga.hsbc.module1;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public record CashFlowTradeResponse(
        String tradeId,
        String clientId,
        Metal metal,
        BigDecimal quantityTroyOz,
        BigDecimal pricePerTroyOz,
        String currency,
        LocalDate settlementDate,
        TradeStatus status,
        Instant createdAt,
        BigDecimal cashAmount
) {
    public CashFlowTradeResponse {
        if (tradeId == null || tradeId.isBlank()) {
            throw new IllegalArgumentException("tradeId must not be null or blank");
        }
        if (clientId == null || clientId.isBlank()) {
            throw new IllegalArgumentException("clientId must not be null or blank");
        }
        if (metal == null) {
            throw new IllegalArgumentException("metal must not be null");
        }
        if (quantityTroyOz == null || quantityTroyOz.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("quantityTroyOz must be positive");
        }
        if (pricePerTroyOz == null || pricePerTroyOz.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("pricePerTroyOz must be positive");
        }
        if (currency == null || !currency.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("currency must be a 3-letter uppercase code");
        }
        if (settlementDate == null) {
            throw new IllegalArgumentException("settlementDate must not be null");
        }
        if (status == null) {
            throw new IllegalArgumentException("status must not be null");
        }
        if (createdAt == null) {
            throw new IllegalArgumentException("createdAt must not be null");
        }
        if (cashAmount == null || cashAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("cashAmount must be positive");
        }
    }
}
