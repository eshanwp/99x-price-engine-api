package io.x99.priceengine.service;

import io.x99.priceengine.dto.ProductSearchRequestDto;
import io.x99.priceengine.dto.search.BaseSearchResponseDto;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

public interface ProductService {
    @Retryable(maxAttemptsExpression = "${spring.retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${spring.retry.backoff-delay}", maxDelayExpression = "${spring.retry.maxDelay}"))
    BaseSearchResponseDto searchForProduct(ProductSearchRequestDto productSearchRequestDto);
}
