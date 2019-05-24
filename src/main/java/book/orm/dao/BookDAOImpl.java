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

public class BookDAOImpl implements IBookDAO {

    static {
        // 關閉 hibernate warn log
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    }
    
    @Override
    public void test() {
        Configuration cfg = new Configuration().configure();
        System.out.println(cfg.configure().getProperty("hibernate.connection.url"));
        System.out.println(cfg.configure().getProperty("hibernate.dialect"));
        System.out.println(cfg.configure().getProperty("current_session_context_class"));
        System.out.println(cfg.configure().getProperty("cache.provider_class"));
        System.out.println(cfg.configure().getProperty("show_sql"));
    }

    @Override
    public boolean create(Book book) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        return true;
    }

    @Override
    public boolean update(Book book) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(book);
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
    public Set<Book> queryAll() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List list = session.createQuery("from book.orm.model.Book").list();
        tx.commit();
        return new LinkedHashSet<>(list);
    }

    @Override
    public Book get(int id) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Book book = session.get(Book.class, id);
        tx.commit();
        return book;
    }

}
