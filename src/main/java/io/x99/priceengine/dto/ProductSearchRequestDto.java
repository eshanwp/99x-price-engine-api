package io.x99.priceengine.dto;

import io.x99.priceengine.dto.search.BaseSearchRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Builder
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductSearchRequestDto extends BaseSearchRequestDto implements Serializable {
    private static final long serialVersionUID = -3108028971337566232L;
    private String productName;
}
