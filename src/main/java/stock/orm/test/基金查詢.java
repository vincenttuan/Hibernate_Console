package stock.orm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import stock.orm.model.Fund;
import stock.orm.model.Stock;
import stock.orm.model.Trader;

public class 基金查詢 {
    public static void main(String[] args) {
        
        // 經由 Hibernate 存入資料表
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        Fund fund = session.get(Fund.class, 1);
        System.out.printf("基金名稱(Fund) : %s\n", fund.getName());
        System.out.printf("基金淨值(FundNet) : $%,d\n", fund.getFundNet().getValue());
        System.out.println("投資組合(Stock) : ");
        for(Stock stock : fund.getStocks()) {
            System.out.printf("\t%s %s\n", stock.getStockCode(), stock.getStockName());
        }
        System.out.println("基金經理人(Trader) : ");
        for(Trader trader : fund.getTraders()) {
            System.out.printf("\t%s\n", trader.getName());
        }
        
        tx.commit();
        
        
    }
}
