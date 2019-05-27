package book.orm.dao;

import book.orm.model.Category;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class BookCategoryDAOImpl extends BaseDAOImpl implements IBookCategoryDAO {

    @Override
    public Set<Category> queryCategoryByBookId(int b_id) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        //---------------------------
        String hql = "from book.orm.model.Category c where c.id in ( select bc.c_id from book.orm.model.BookCategory bc where bc.b_id =:b_id)";
        Query query = session.createQuery(hql);
        query.setParameter("b_id", b_id);
        List list = query.list();
        //---------------------------
        tx.commit();
        return new LinkedHashSet<>(list);
    }

    @Override
    public Set<Category> queryCategoryByBookIdNotIn(int b_id) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        //---------------------------
        String hql = "from book.orm.model.Category c where c.id not in ( select bc.c_id from book.orm.model.BookCategory bc where bc.b_id =:b_id)";
        Query query = session.createQuery(hql);
        query.setParameter("b_id", b_id);
        List list = query.list();
        //---------------------------
        tx.commit();
        return new LinkedHashSet<>(list);
    }
    
}
