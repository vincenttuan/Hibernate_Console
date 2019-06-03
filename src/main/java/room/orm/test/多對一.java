package room.orm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import room.orm.model.Room;
import room.orm.model.Tenant;

public class 多對一 {

    public static void main(String[] args) {

        create();

    }

    public static void create() {
        Room room1 = new Room();
        room1.setAddress("A01");

        Room room2 = new Room();
        room2.setAddress("B02");

        Tenant t1 = new Tenant("Mary");
        t1.setRoom(room1);

        Tenant t2 = new Tenant("Tom");
        t2.setRoom(room1);

        Tenant t3 = new Tenant("Jane");
        t3.setRoom(room2);

        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();

        session.save(t1);
        session.save(t2);
        session.save(t3);

        session.getTransaction().commit();

    }
}
