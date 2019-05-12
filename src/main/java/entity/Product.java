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

    @ManyToMany(mappedBy = "productList",fetch = FetchType.LAZY)
    private List<CustomerOrder> customerOrderList;

    /*CascadeType.PERSIST, Sadece Kayıt Atmak İçin Kullanır.
    CascadeType.DETACH, İlişkili objeleri birbirinden ayırmak İçin Kullanır.
    CascadeType.MERGE, Sadece Güncellemek için kullanılıur.
    CascadeType.REFRESH, İlişkili objeleri select atmak için.
    CascadeType.REMOVE, İlişkili objeleri beraberinde silmek için.
    CascadeType.ALL Yukarıdaki tüm işlemleri yapıyor.  */
    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "menu_id"/*,insertable = true,updatable = false*/)
    private Menu menu;

    public Product() {
    }

    public Product(String productName, Double price) {
        this.productName = productName;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", customerOrderList=" + customerOrderList +
                ", menu=" + menu +
                '}';
    }
}
