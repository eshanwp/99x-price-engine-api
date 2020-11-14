package io.x99.priceengine.controller;

import io.x99.priceengine.dto.ProductSearchRequestDto;
import io.x99.priceengine.dto.ResponseDto;
import io.x99.priceengine.dto.search.BaseSearchResponseDto;
import io.x99.priceengine.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static io.x99.priceengine.util.constsnt.UrlConstant.PRODUCT_SEARCH;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * fetch all products
     *
     * @param productSearchRequestDto
     * @return
     * @author Eshan
     */
    @PostMapping(PRODUCT_SEARCH)
    ResponseDto<BaseSearchResponseDto> searchForItem(@RequestBody ProductSearchRequestDto productSearchRequestDto) {
        return new ResponseDto<BaseSearchResponseDto>().buildSuccessMsgWithData(productService.searchForProduct(productSearchRequestDto));
    }

}
