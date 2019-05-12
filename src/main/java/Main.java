import dao.ProductDAO;
import entity.Menu;
import entity.Product;
import util.HibernateUtil;

import java.util.Date;

public class Main {


    public static void main(final String[] args) throws Exception {

        ProductDAO productDAO=new ProductDAO();

        Menu menu=new Menu();
        menu.setMenuName("Menu 1");
        menu.setCreatedBy("Ali");
        menu.setCreatedDate(new Date());

        Product product=new Product();

        product.setPrice(12.0);
        product.setProductName("Latte");
        product.setCreatedBy("Ramazan");
        product.setCreatedDate(new Date());
        product.setMenu(menu);

        //productDAO.kaydet(product);

    }
}