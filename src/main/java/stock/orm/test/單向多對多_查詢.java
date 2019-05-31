package stock.orm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import stock.orm.model.Fund;

public class 單向多對多_查詢 {
    public static void main(String[] args) {
        
        // 經由 Hibernate 存入資料表
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        Fund fund = session.get(Fund.class, 1);
        System.out.println(fund.getFundId());
        System.out.println(fund.getName());
        System.out.println(fund.getDesc());
        System.out.println(fund.getStocks());
        
        tx.commit();
        
        
    }
}
