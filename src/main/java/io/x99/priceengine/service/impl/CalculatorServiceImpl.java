package io.x99.priceengine.service.impl;

import io.x99.priceengine.dto.CalculateRequestDto;
import io.x99.priceengine.dto.PriceDto;
import io.x99.priceengine.entity.Product;
import io.x99.priceengine.exception.RecordNotFoundException;
import io.x99.priceengine.repository.ProductRepository;
import io.x99.priceengine.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {
    private final ProductRepository productRepository;
    private final MessageSource messageSource;

    public CalculatorServiceImpl(ProductRepository productRepository, MessageSource messageSource) {
        this.productRepository = productRepository;
        this.messageSource = messageSource;
    }

    @Override
    public PriceDto priceCalculator(CalculateRequestDto calculateRequestDto) {

        PriceDto priceDto = new PriceDto();
        Optional<Product> productOptional = productRepository.findById(calculateRequestDto.getProductId());
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            Integer cartoonQty = calculateRequestDto.getRequestQty() / product.getCartoonQty();
            Integer balanceQty = calculateRequestDto.getRequestQty() - (product.getCartoonQty() * cartoonQty);
            double totalCartoonPrice;
            double totalSingleUnitPrice;
            double total;
            double discount = 0.00;

            /*If you purchase single units, the price is acquired using the carton price multiplied
            by an increase of 30% (1.3). (to compensate for manual labor)*/
            totalSingleUnitPrice = product.getUnitPrice() * 1.3 * balanceQty;

            if (cartoonQty >= 3) {
                /*If you purchase 3 cartons or more, you will receive a 10% discount off
                the carton price*/
                discount = product.getCartoonPrice() * cartoonQty * 0.1;
                totalCartoonPrice = (product.getCartoonPrice() * cartoonQty) - (discount);
                total = totalCartoonPrice + totalSingleUnitPrice;

            } else {
                totalCartoonPrice = product.getCartoonPrice() * cartoonQty;
                total = totalCartoonPrice + totalSingleUnitPrice;
            }

            priceDto.setTotalPrice(total);
            priceDto.setTotalDiscount(discount);
            priceDto.setNoOfCartoon(cartoonQty);
            priceDto.setNoOfUnits(balanceQty);

        } else {
            throw new RecordNotFoundException(messageSource.getMessage("no.records.matches.the.search.criteria", new Object[0], Locale.ENGLISH));
        }
        return priceDto;
    }
}
