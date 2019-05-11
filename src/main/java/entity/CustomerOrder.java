package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class CustomerOrder extends BaseEntity{

    @Column(name = "total")
    private Double total;

    /**
     * ManyToMany ilişkiler de yeni bir eşleştirme tablosu oluşturulur.
     * Her iki tablonun da fk ismi bu eşleştirme tablosunda oluşturulur.
     * ManyToMany ilişkiler list of object şeklinde oluşturulur.
     */
    @ManyToMany
    @JoinTable(name = "orders_products"
            ,joinColumns = {@JoinColumn(name = "customer_order_id")}
            ,inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> productList;


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
