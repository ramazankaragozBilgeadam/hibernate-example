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


        customerKaydet();
    }


    public static void customerKaydet(){

        CustomerDAO customerDAO=new CustomerDAO();
        ProductDAO productDAO=new ProductDAO();

        List<Product> productList=productDAO.findAllByMenuId(1L);

        CustomerInformation customerInformation=new CustomerInformation();
        customerInformation.setCity("Ankara");
        customerInformation.setPhoneNumber("5318245656");
        customerInformation.setStreet("Sümbül");
        customerInformation.setDetailAddress("Parkin Karsisi");
        customerInformation.setCreatedBy("Ramazan");

        CustomerOrder customerOrder=new CustomerOrder();
        customerOrder.setCreatedBy("Ramazan");
        customerOrder.setTotal(getOrderTotal(productList));
        customerOrder.setProductList(productList);

        Customer customer=new Customer();
        customer.setCustomerOrder(customerOrder);
        customer.setCustomerInformation(customerInformation);
        customer.setFirsName("Veli");
        customer.setLastName("Yılmaz");
        customer.setCreatedBy("Ramazan");

        customerDAO.kaydet(customer);



    }

    /**
     * Müşterinin siparişindeki ürünlerin tutarını hesaplayıp dönen method.
     * @param productList
     * @return
     */
    public static Double getOrderTotal(List<Product> productList){

        Double total=0.0;

        if (productList!=null&&!productList.isEmpty()){

            for (Product product:productList) {

                total+=product.getPrice();
            }

        }



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