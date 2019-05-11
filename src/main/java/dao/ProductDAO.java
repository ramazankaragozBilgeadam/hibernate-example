package dao;

import entity.Product;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

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
}
