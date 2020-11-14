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
public class CalculateRequestDto implements Serializable {
    private static final long serialVersionUID = 4279314392983593751L;
    private Integer productId;
    private Integer requestQty;
}
