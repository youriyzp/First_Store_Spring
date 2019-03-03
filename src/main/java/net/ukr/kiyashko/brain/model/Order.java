package net.ukr.kiyashko.brain.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "order", schema = "store")

public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "users_id", nullable = false)
    private User users;

    @Column(name = "last_order")
    private Date last_order;

    //указать summm=OrderItem.count*Product.price
    @Column(name = "summ", insertable = false, updatable = false)
    private double summ;//TODO Product.getPrice*OrderItem.getCount ???

    public Order() {
    }

    public Order(Long id, User user, Date last_order, double summ) {
        this.id = id;
        this.users = users;
        this.last_order = last_order;
//        this.product = product;
//        this.count = count;
        this.summ = getSumm();
    }
    //Как получить вычисляемое поле summ?
public void getSumm(Product.price,OrderItem.count){
        return Product.price*OrderItem.count};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return users;
    }

    public void setUser(User user) {
        this.users = users;
    }

    public Date getLast_order() {
        return last_order;
    }

    public void setLast_order(Date last_order) {
        this.last_order = last_order;
    }

    //public double getSumm() {
//        return summ;
//    }

    public void setSumm(double summ) {
        this.summ = summ;
    }


}
