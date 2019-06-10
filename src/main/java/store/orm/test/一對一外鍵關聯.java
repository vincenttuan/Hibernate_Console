package store.orm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import store.orm.model.Pen;
import store.orm.model.Price;

public class 一對一外鍵關聯 {

    public static void main(String[] args) {
        Pen pen = new Pen("P3");
        Price price = new Price(300);
        
        //price.setPen(pen);
        pen.setPrice(price);

        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();

        //session.save(price);
        session.save(pen);

        session.getTransaction().commit();
    }
}
