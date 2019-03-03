package net.ukr.kiyashko.brain.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

//import java.util.Collection;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order", schema = "store")

public class Order  implements Serializable {
    //private Long id;
    //  private Long user_id;
    // Date last_order;
    //private double summ;
    //private PersonEntity person;
//
//     @ManyToOne
//      @JoinColumn(name = "user_id", referencedColumnName = "id")
//     public Id getId() {
//         return this.id;
//      }
//
//      public void setPerson(PersonEntity person) {
//        this.person = person;
//    //   }

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Long id;
    //    //Вместо этой колонки вставил связь М:1 от User Id
    //    @Column(name = "user_id", length = 6, nullable = false)
//    private Long user_id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "users_id", nullable = false)
    //  @JsonIgnore
    private User users;

    @Column(name = "last_order")
    private Date last_order;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "product_id", nullable = false)
    //  @JsonIgnore
    private Product product;

    @Column(name = "count")
    private int count;


    //указать summm=OrderItem.count*Product.price
    @Column(name = "summ")
    private double summ;//TODO Product.getPrice*OrderItem.getCount ???
    //код для многих к одному  User

    public Order() {

    }

    public Order(Long id, User user, Date last_order, Product product, int count, double summ) {
        this.id = id;
        this.users = users;
        this.last_order = last_order;
        this.product = product;
        this.count = count;
        this.summ = summ;
    }

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

    public double getSumm() {
        return summ;
    }

    public void setSumm(double summ) {
        this.summ = summ;
    }
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


}
