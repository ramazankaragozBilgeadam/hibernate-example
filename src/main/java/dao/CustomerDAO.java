package dao;


import entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class CustomerDAO extends BaseDAO {


    public void kaydet(Customer customer){

        Transaction transaction=null;

        try {
            transaction=getSession().beginTransaction();
            getSession().save(customer);
        }catch (HibernateException ex){
            ex.printStackTrace();
            transaction.rollback();
        }finally {
            transaction.commit();
        }

    }


}
