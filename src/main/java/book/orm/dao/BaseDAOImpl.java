package book.orm.dao;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseDAOImpl implements IBaseDAO {

    static {
        // 關閉 hibernate warn log
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    }
    
    @Override
    public boolean create(Object object) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(object);
        tx.commit();
        return true;
    }

    @Override
    public boolean update(Object object) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(object);
        tx.commit();
        return true;
    }

    @Override
    public boolean delete(Class cla, int id) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(get(cla, id));
        tx.commit();
        return true;}

    @Override
    public Set<Object> queryAll(Class cls) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List list = session.createQuery("from " + cls.getName()).list();
        tx.commit();
        return new LinkedHashSet<>(list);
    }

    @Override
    public Object get(Class cls, int id) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Object object = session.get(cls, id);
        tx.commit();
        return object;
    }

}
