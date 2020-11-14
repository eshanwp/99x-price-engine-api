package io.x99.priceengine.qdsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.x99.priceengine.dto.ProductSearchRequestDto;
import io.x99.priceengine.entity.QProduct;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static org.springframework.util.StringUtils.isEmpty;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductQdsl {
    public static Predicate searchProductByCriteria(ProductSearchRequestDto productSearchRequestDto) {
        BooleanBuilder where = new BooleanBuilder();
        QProduct qProduct = QProduct.product;

        if (!isEmpty(productSearchRequestDto.getProductName())) {
            where.and(qProduct.productName.containsIgnoreCase(productSearchRequestDto.getProductName()));
        }

        return where;
    }
}
