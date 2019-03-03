package net.ukr.kiyashko.brain.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;


@Entity
// в базе нельзя большими буквами и слова разделять через дефис, указывать схему
@Table(name = "order_item", schema = "store")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    @Column(name = "count")
    private int count;
  //  private Object HashMap;

    public OrderItem(){}

    public OrderItem(Long id, Order order, Product product, int count) {
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

//    public  void getMapCount(){
//        return new HashMap<id,count>();
//    }
}
