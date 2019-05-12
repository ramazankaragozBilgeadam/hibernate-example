package dao;

import entity.Menu;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class MenuDAO extends BaseDAO{


    public void kaydet(Menu menu){

        Transaction transaction=null;


        try{
            transaction=getSession().beginTransaction();

            getSession().save(menu);

        }catch (HibernateException ex){
            ex.printStackTrace();
            transaction.rollback();
        }finally {
            transaction.commit();
        }

    }
}
