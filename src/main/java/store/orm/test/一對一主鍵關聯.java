package store.orm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import store.orm.model.Ball;
import store.orm.model.Color;

public class 一對一主鍵關聯 {

    public static void main(String[] args) {
        Ball ball = new Ball("B1");
        Color color = new Color("Red");

        // 互相設定關聯
        ball.setColor(color);
        color.setBall(ball);

        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();

        session.save(ball);

        session.getTransaction().commit();
    }
}
