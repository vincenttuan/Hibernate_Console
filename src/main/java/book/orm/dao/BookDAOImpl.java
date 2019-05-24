package book.orm.dao;

import java.util.logging.Level;
import org.hibernate.cfg.Configuration;

public class BookDAOImpl extends BaseDAOImpl implements IBookDAO {

    static {
        // 關閉 hibernate warn log
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    }
    
    @Override
    public void test() {
        Configuration cfg = new Configuration().configure();
        System.out.println(cfg.configure().getProperty("hibernate.connection.url"));
        System.out.println(cfg.configure().getProperty("hibernate.dialect"));
        System.out.println(cfg.configure().getProperty("current_session_context_class"));
        System.out.println(cfg.configure().getProperty("cache.provider_class"));
        System.out.println(cfg.configure().getProperty("show_sql"));
    }
}
