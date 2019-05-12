import dao.MenuDAO;
import dao.ProductDAO;
import entity.BaseEntity;
import entity.Menu;
import entity.Product;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {


    public static void main(final String[] args) throws Exception {

      //onMenuKaydet("Menu 1");

      displayProductList(1L);

    }


    public static void displayProductList(Long menuId){

        ProductDAO productDAO=new ProductDAO();

        try {
            productDAO.findAllByMenuId(menuId).stream().forEach(System.out::println);
        }catch (NullPointerException ex){
            System.out.println("Products are not found.");
        }


    }


    public static void onMenuKaydet(String menuName){

        MenuDAO menuDAO=new MenuDAO();

        Product product1=new Product();
        product1.setProductName("Cortado");
        product1.setPrice(12.00);
        product1.setCreatedBy("Ramazan");

        Product product2=new Product("Latte",15.00);
        product2.setCreatedBy("Ali");

        List<Product> productList=new ArrayList<>();
        productList.add(product1);
        productList.add(product2);


        Menu menu=new Menu();
        menu.setMenuName(menuName);
        menu.setProductList(productList);
        menu.setCreatedBy("Ramazan");

        menuDAO.kaydet(menu);
    }
}