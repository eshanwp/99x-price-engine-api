package io.x99.priceengine.service;

import io.x99.priceengine.dto.CalculateRequestDto;
import io.x99.priceengine.dto.PriceDto;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

public interface CalculatorService {
    @Retryable(maxAttemptsExpression = "${spring.retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${spring.retry.backoff-delay}", maxDelayExpression = "${spring.retry.maxDelay}"))
    PriceDto priceCalculator(CalculateRequestDto calculateRequestDto);
}
