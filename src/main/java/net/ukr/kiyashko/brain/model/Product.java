package net.ukr.kiyashko.brain.model;

import net.ukr.kiyashko.brain.model.enums.UnitEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product",schema = "store")
public class Product  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 6, nullable = false)
    private Long id;

    @Column(name = "name_product")
    private String name_product;

    @Column(name = "price")
    private double price;

    @Column(name = "unit")
    @Enumerated(EnumType.STRING)
    private UnitEnum unit;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderItem> orderItems;

    public Product(Long id, String name_product, double price, UnitEnum unit) {
        this.id = id;
        this.name_product = name_product;
        this.price = price;
        this.unit = unit;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public UnitEnum getUnit() {
        return unit;
    }


}
