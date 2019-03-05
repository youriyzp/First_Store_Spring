package net.ukr.kiyashko.brain.controller.form;

import net.ukr.kiyashko.brain.model.Order;
import net.ukr.kiyashko.brain.model.Product;
import net.ukr.kiyashko.brain.model.User;

import java.util.Date;

public class OrderForm {
    private Long id;
    private User users;
    private Date last_order;
    private double summ;

    public OrderForm(){}

    public OrderForm(Long id, User users, Date last_order, double summ) {
        this.id = id;
        this.users = users;
        this.last_order = last_order;
        this.summ = summ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Date getLast_order() {
        return last_order;
    }

    public void setLast_order(Date last_order) {
        this.last_order = last_order;
    }

    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }
}