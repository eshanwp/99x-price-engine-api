package io.x99.priceengine.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PriceDto {
    private Double totalPrice;
    private Double totalDiscount;
    private Integer noOfCartoon;
    private Integer noOfUnits;
}
