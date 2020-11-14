package io.x99.priceengine;

import io.x99.priceengine.dto.ProductSearchRequestDto;
import io.x99.priceengine.dto.search.BaseSearchResponseDto;
import io.x99.priceengine.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class ProductTest {

    @Autowired
    ProductService productService;

    @Test
    void searchForProduct() {
        ProductSearchRequestDto productSearchRequestDto = ProductSearchRequestDto.builder()
                .productName("Penguin-ears")
                .build();

        BaseSearchResponseDto baseSearchResponseDto = productService.searchForProduct(productSearchRequestDto);
        assertThat(baseSearchResponseDto).isNotNull();
        log.info(baseSearchResponseDto.toString());
    }

}
