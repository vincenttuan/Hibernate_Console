package stock.orm.test;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import stock.orm.model.Fund;
import stock.orm.model.Stock;

public class 單向多對多_新建 {
    public static void main(String[] args) {
        
        // 建立新股票
        Stock stock1 = new Stock("2330", "台積電");
        Stock stock2 = new Stock("2317", "鴻海");
        
        // 建立新基金
        Fund fund = new Fund("A", "高科技");
        Set<Stock> stocks = new HashSet<>();
        stocks.add(stock1);
        stocks.add(stock2);
        fund.setStocks(stocks);
        
        // 經由 Hibernate 存入資料表
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        session.save(fund);
        
        tx.commit();
        
        
    }
}
