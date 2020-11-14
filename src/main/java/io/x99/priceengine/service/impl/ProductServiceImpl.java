package io.x99.priceengine.service.impl;

import io.x99.priceengine.dto.ProductDto;
import io.x99.priceengine.dto.ProductSearchRequestDto;
import io.x99.priceengine.dto.search.BaseSearchResponseDto;
import io.x99.priceengine.entity.Product;
import io.x99.priceengine.qdsl.ProductQdsl;
import io.x99.priceengine.repository.ProductRepository;
import io.x99.priceengine.service.ProductService;
import io.x99.priceengine.util.converter.EntityConverter;
import io.x99.priceengine.util.datatable.DataTableUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final EntityConverter entityConverter;

    public ProductServiceImpl(ProductRepository productRepository, EntityConverter entityConverter) {
        this.productRepository = productRepository;
        this.entityConverter = entityConverter;
    }

    @Override
    public BaseSearchResponseDto searchForProduct(ProductSearchRequestDto productSearchRequestDto) {
        final List<Product> list = productRepository.findAll(
                ProductQdsl.searchProductByCriteria(productSearchRequestDto),
                DataTableUtil.createPageRequest(productSearchRequestDto)
        ).getContent();

        List<ProductDto> dtoList = entityConverter.convert(list, ProductDto.class);

        return BaseSearchResponseDto.builder()
                .items(dtoList)
                .totalPages(DataTableUtil.calculateTotalNumberOfPages(dtoList.size(), productSearchRequestDto))
                .build();
    }
}
