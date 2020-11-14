package io.x99.priceengine;

import io.x99.priceengine.dto.CalculateRequestDto;
import io.x99.priceengine.dto.PriceDto;
import io.x99.priceengine.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CalculatorTest {

    @Autowired
    CalculatorService calculatorService;

    @Test
    void priceCalculator() {
        CalculateRequestDto calculateRequestDto = CalculateRequestDto.builder()
                .requestQty(20)
                .productId(1)
                .build();

        PriceDto priceDto = calculatorService.priceCalculator(calculateRequestDto);
        assertThat(priceDto).isNotNull();
        log.info(priceDto.toString());
    }

}
