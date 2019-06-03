package room.orm.test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import room.orm.model.Room;
import room.orm.model.Tenant;

public class 多對一 {

    public static void main(String[] args) {
        //create();
        readRoom(); // 將每一房中有哪些個人分別印出 Ex: A01 -> Mary, Tom
        //readTenant(); // 將每人分別在哪一房印出 Ex: Mary -> A01
    }

    public static void readRoom() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();

        List<Room> list = session.createQuery("from room.orm.model.Room").list();
        for(Room room : list) {
            System.out.println(room.getAddress() + " --> " + room.getTenants());
            if(room.getTenants().size() == 0) {
                String hql = "from room.orm.model.Tenant where room_id=:room_id";
                Query query = session.createQuery(hql);
                query.setParameter("room_id", room.getId());
                List<Tenant> tenants = query.list();
                for(Tenant tenant : tenants) {
                    System.out.println(tenant.getName());
                }
            }
        }
        
        session.getTransaction().commit();
    }

    public static void readTenant() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();

        List<Tenant> list = session.createQuery("from room.orm.model.Tenant").list();
        for(Tenant tenant : list) {
            System.out.println(tenant.getName() + " --> " + tenant.getRoom().getAddress());
        }
        
        session.getTransaction().commit();
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
