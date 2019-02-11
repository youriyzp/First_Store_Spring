package net.ukr.kiyashko.brain.model;

import javax.persistence.*;


@Entity
@Table(name = "orderItem")

public class OrderItem {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column(name = "order_id", length = 6, nullable = false)
    private Long order_id;

    @Column(name = "product_id", length = 6, nullable = false)
    private Long product_id;

    @Column(name = "count")
    private int count;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
  //  @JoinColumn(name = "product_id", name = "order_id", nullable = false)
  //  @JsonIgnore
  //  private OrderItem orderItem;

    public OrderItem(Long id, Long order_id, Long product_id, int count) {
        this.id = id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.count = count;
    }

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
