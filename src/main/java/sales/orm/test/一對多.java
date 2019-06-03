package sales.orm.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sales.orm.model.Customer;
import sales.orm.model.Sales;

public class 一對多 {

    public static void main(String[] args) {
        //create();
        //readSales();
        readCustomer();
    }
    
    public static void readSales() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        
        List<Sales> saleses = session.createQuery("from sales.orm.model.Sales").list();
        for(Sales sales : saleses) {
            System.out.print(sales.getName() + "->");
            for(Customer customer : sales.getCustomers()) {
                System.out.print(customer.getName() + ", ");
            }
            System.out.println();
        }
    }
    
    public static void readCustomer() {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();
        
        List<Customer> customers = session.createQuery("from sales.orm.model.Customer").list();
        for(Customer customer : customers) {
            System.out.print(customer.getName() + "->");
            Sales sales = session.get(Sales.class, customer.getEmNo());
            System.out.println(sales.getName());
        }
    }
    
    public static void create() {
        Sales s1 = new Sales("A038", "黃藥師");
        Sales s2 = new Sales("C549", "江湖郎中");

        Customer c1 = new Customer("0978978978", "張無忌", s1.getEmNo());
        Customer c2 = new Customer("0912345678", "趙敏", s1.getEmNo());
        Customer c3 = new Customer("0911223344", "周芷若", s2.getEmNo());

        Set<Customer> sc1 = new HashSet<Customer>();
        sc1.add(c1);
        sc1.add(c2);
        s1.setCustomers(sc1);

        Set<Customer> sc2 = new HashSet<Customer>();
        sc2.add(c3);
        s2.setCustomers(sc2);

        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        session.beginTransaction();

        session.save(s1); 
        session.save(s2);

        session.getTransaction().commit();

    }
}
