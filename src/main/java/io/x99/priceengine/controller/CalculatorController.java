package io.x99.priceengine.controller;

import io.x99.priceengine.dto.CalculateRequestDto;
import io.x99.priceengine.dto.PriceDto;
import io.x99.priceengine.dto.ResponseDto;
import io.x99.priceengine.service.CalculatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static io.x99.priceengine.util.constsnt.UrlConstant.CALCULATE;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    /**
     * @param calculateRequestDto
     * @return
     * @author Eshan
     * Calculate price according to the product and request qty
     */
    @PostMapping(CALCULATE)
    public ResponseDto<PriceDto> priceCalculator(@RequestBody CalculateRequestDto calculateRequestDto) {
        return new ResponseDto<PriceDto>().buildSuccessMsgWithData(calculatorService.priceCalculator(calculateRequestDto));
    }

}
