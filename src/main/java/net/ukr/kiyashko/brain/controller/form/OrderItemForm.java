package net.ukr.kiyashko.brain.controller.form;

import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.model.Product;

public class OrderItemForm {
    private Long id;
    private Order order;
    private Product product;
    private int count;

    public OrderItemForm(){}


    public OrderItemForm(Long id, Order order, Product product, int count) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}