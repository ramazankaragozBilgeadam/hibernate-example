package entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu extends BaseEntity {


    @Column(name = "menu_name",length = 15)
    private String menuName;

    /**
     * OneToMany ilişkiler de bağlanacak tablonun objeleri liste olarak tutulur.
     * ManyToOne ilişkinin tersidir.
     * JoinColumn da verilen fk ismi bağlanan objenin tablosunda tutulur.
     * FetchType.Eager default olarak relation da gelir.Eğer bu Type kullanırsa relationlı olduğu objelerin
     * içerisindeki relationlı objeleride beraberin de getirir.
     *
     * FetchType.Lazy olduğu durumlarda sadece sorumlu olduğu relationlı objeleri getirir.Tembel yükleme yapar.
     */
    @OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY )
    @JoinColumn(name = "menu_id")
    private List<Product> productList;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuName='" + menuName + '\''+
                '}';
    }
}
