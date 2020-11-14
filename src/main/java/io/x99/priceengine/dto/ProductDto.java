package io.x99.priceengine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private static final long serialVersionUID = -4105001242682243256L;
    private Integer id;
    private String productName;
    private Double unitPrice;
    private Double cartoonPrice;
    private Integer cartoonQty;
}
