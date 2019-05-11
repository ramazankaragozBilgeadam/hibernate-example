package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Double price;

    @ManyToMany(mappedBy = "productList")
    private List<CustomerOrder> customerOrderList;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id"/*,insertable = true,updatable = false*/)
    private Menu menu;


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<CustomerOrder> getCustomerOrderList() {
        return customerOrderList;
    }

    public void setCustomerOrderList(List<CustomerOrder> customerOrderList) {
        this.customerOrderList = customerOrderList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
