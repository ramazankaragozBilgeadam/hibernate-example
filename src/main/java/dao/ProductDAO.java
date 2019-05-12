package dao;

import entity.Product;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO extends BaseDAO {



    public void kaydet(Product product){

        Transaction transaction=null;
        try {

            transaction=getSession().beginTransaction();

            getSession().save(product);

        }catch (HibernateException ex){

            transaction.rollback();

        }finally {
            transaction.commit();
        }
    }


    public List<Product> findAllByMenuId(Long menuId){

        Transaction transaction=null;
        List<Product> productList=null;
        try {
            transaction=getSession().beginTransaction();

            /*Query<Product> productQuery=getSession()
                    .createQuery("from Product where menu="+menuId,Product.class);*/

            Query<Product> productQuery=getSession()
                    .createQuery("from Product where menu.id=:menuId",Product.class);

            productQuery.setParameter("menuId",menuId);

            productList=productQuery.getResultList();

        }catch (HibernateException ex){
            ex.printStackTrace();
            transaction.rollback();
        }finally {
            transaction.commit();
        }

        return productList;
    }
}
