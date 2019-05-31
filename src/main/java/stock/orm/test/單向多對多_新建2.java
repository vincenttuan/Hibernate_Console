package stock.orm.test;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import stock.orm.model.Fund;
import stock.orm.model.Stock;

public class 單向多對多_新建2 {
    public static void main(String[] args) {
        
        // 經由 Hibernate 存入資料表
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        // 已知的股票
        Stock stock1 = session.get(Stock.class, 1);
        // 建立新股票
        Stock stock2 = new Stock("3008", "大立光");
        
        // 建立新基金
        Fund fund = new Fund("B", "高收益");
        Set<Stock> stocks = new HashSet<>();
        stocks.add(stock1);
        stocks.add(stock2);
        fund.setStocks(stocks);
        
        session.save(fund);
        
        tx.commit();
        
        
    }
}
