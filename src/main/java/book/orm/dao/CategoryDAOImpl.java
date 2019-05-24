package book.orm.dao;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import book.orm.model.Book;
import book.orm.model.Category;

public class CategoryDAOImpl implements ICategoryDAO {

    static {
        // 關閉 hibernate warn log
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    }
    
    @Override
    public boolean create(Category category) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(category);
        tx.commit();
        return true;
    }

    @Override
    public boolean update(Category category) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(category);
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(int id) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(get(id));
        tx.commit();
        return true;}

    @Override
    public Set<Category> queryAll() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List list = session.createQuery("from book.orm.model.Category").list();
        tx.commit();
        return new LinkedHashSet<>(list);
    }

    @Override
    public Category get(int id) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Category category = session.get(Category.class, id);
        tx.commit();
        return category;
    }

    @Override
    public Set<Book> queryBookById(int c_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
