package stock.orm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import stock.orm.model.Fund;
import stock.orm.model.Investor;

public class 投資人新增 {
    public static void main(String[] args) {
        
        // 經由 Hibernate 存入資料表
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        Fund fund = session.get(Fund.class, 1);
        Investor investor = new Investor();
        investor.setFund(fund);
        investor.setName("Happy");
        investor.setUnits(10000.0);
        investor.setNetValue(fund.getFundNet().getValue());
        
        session.save(investor);
        
        tx.commit();
        
        
    }
}
