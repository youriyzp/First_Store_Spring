package net.ukr.kiyashko.brain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order",schema = "store")

public class Order {
    //private Long id;
    //  private Long user_id;
    // Date last_order;
    //private double summ;
    //private PersonEntity person;

    // @ManyToOne
    //  @JoinColumn(name = "person_id", referencedColumnName = "id")
    // public PersonEntity getPerson() {
    //     return this.person;
    //  }

    //  public void setPerson(PersonEntity person) {
//        this.person = person;
    //   }

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column(name = "user_id", length = 6, nullable = false)
    private Long user_id;

    @Column(name = "last_order")
    private Date last_order;
    //указать summm=OrderItem.count*Product.price
    @Column(name = "summ")
    private double summ;
    //код для многих к одному  User
   /* @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users", nullable = false)
    @JsonIgnore
    private User user;

    private Set<Product> products = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orderItem",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order(Long id, Long user_id, Date last_order, double summ) {
        this.id = id;
        this.user_id = user_id;
        this.last_order = last_order;
        this.summ = summ;
    }

    public Order() {

    }

    public Long getUser_id() {
        return user_id;
    }

    public Date getLast_order() {
        return last_order;
    }

    public double getSumm() {
        return summ;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setLast_order(Date last_order) {
        this.last_order = last_order;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }


}
