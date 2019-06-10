package dept.orm.test;

import dept.orm.model.Department;
import dept.orm.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class 單向多對一 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Tom");
        Employee emp2 = new Employee("Joe");
        Department department = new Department("Sales");
        // 多方必須意識到單方的存在
        emp1.setDepartment(department);
        emp2.setDepartment(department);
        
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        
        session.beginTransaction();
        
        session.save(emp1);
        session.save(emp2);
        
        session.getTransaction().commit();
        
        System.out.println("Done");
        
    }
}