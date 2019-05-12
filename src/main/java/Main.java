import dao.CustomerDAO;
import dao.MenuDAO;
import dao.ProductDAO;
import entity.*;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {


    public static void main(final String[] args) throws Exception {

        //onMenuKaydet("Menu 1");
        //displayProductList(1L);

        //displayProductListWithHql();
        //displayProductListWithCriteria();


    }


    public static void customerKaydet(){

        CustomerDAO customerDAO=new CustomerDAO();

        CustomerInformation customerInformation=new CustomerInformation();
        customerInformation.setCity("Ankara");
        customerInformation.setPhoneNumber("5318245656");
        customerInformation.setStreet("Sümbül");
        customerInformation.setDetailAddress("Parkın Karşısı");
        customerInformation.setCreatedBy("Ramazan");

        CustomerOrder customerOrder=new CustomerOrder();
        customerOrder.setCreatedBy("Ramazan");



    }

    public static Double getOrderTotal(){

        Double total=0.0;


        return total;
    }


    public static void displayProductListWithHql() {
        ProductDAO productDAO = new ProductDAO();

        try {
            productDAO.findAllWithHql().stream().forEach(System.out::println);
        } catch (NullPointerException ex) {
            System.out.println("Products are not found.");
        }
    }

    public static void displayProductListWithCriteria() {
        ProductDAO productDAO = new ProductDAO();

        try {
            productDAO.findAllWithCriteria().stream().forEach(System.out::println);
        } catch (NullPointerException ex) {
            System.out.println("Products are not found.");
        }
    }


    public static void displayProductList(Long menuId) {

        ProductDAO productDAO = new ProductDAO();

        try {
            productDAO.findAllByMenuId(menuId).stream().forEach(System.out::println);
        } catch (NullPointerException ex) {
            System.out.println("Products are not found.");
        }


    }


    public static void onMenuKaydet(String menuName) {

        MenuDAO menuDAO = new MenuDAO();

        Product product1 = new Product();
        product1.setProductName("Cortado");
        product1.setPrice(12.00);
        product1.setCreatedBy("Ramazan");

        Product product2 = new Product("Latte", 15.00);
        product2.setCreatedBy("Ali");

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);


        Menu menu = new Menu();
        menu.setMenuName(menuName);
        menu.setProductList(productList);
        menu.setCreatedBy("Ramazan");

        menuDAO.kaydet(menu);
    }
}