package io.x99.priceengine.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    private Integer id;
    private String productName;
    private Double unitPrice;
    private Double cartoonPrice;
    private Integer cartoonQty;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "unit_price")
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "cartoon_price")
    public Double getCartoonPrice() {
        return cartoonPrice;
    }

    public void setCartoonPrice(Double cartoonPrice) {
        this.cartoonPrice = cartoonPrice;
    }

    @Basic
    @Column(name = "cartoon_qty")
    public Integer getCartoonQty() {
        return cartoonQty;
    }

    public void setCartoonQty(Integer cartoonQty) {
        this.cartoonQty = cartoonQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(unitPrice, product.unitPrice) &&
                Objects.equals(cartoonPrice, product.cartoonPrice) &&
                Objects.equals(cartoonQty, product.cartoonQty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, unitPrice, cartoonPrice, cartoonQty);
    }
}
