package dao;

import entity.Product;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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


    public List<Product> findAllWithHql(){

        Transaction transaction=null;
        List<Product> productList=null;
        try{

            transaction=getSession().beginTransaction();

            productList=getSession()
                    .createQuery("from Product",Product.class)
                    .getResultList();

        }catch (HibernateException ex){
            ex.printStackTrace();
            transaction.rollback();
        }finally {
            transaction.commit();
        }

        return productList;
    }

    public List<Product> findAllWithCriteria(){

        Transaction transaction=null;
        List<Product> productList=null;

        try{
            transaction=getSession().beginTransaction();

            CriteriaBuilder cb=getSession().getCriteriaBuilder();
            CriteriaQuery<Product> criteriaQuery=cb.createQuery(Product.class);
            Root<Product> root=criteriaQuery.from(Product.class);

            criteriaQuery.select(root).where(cb.lessThan(root.get("price"),15.00));

            productList=getSession().createQuery(criteriaQuery).getResultList();


        }catch (HibernateException ex){
            ex.printStackTrace();
            transaction.rollback();
        }finally {
            transaction.commit();
        }

        return productList;
    }
}
