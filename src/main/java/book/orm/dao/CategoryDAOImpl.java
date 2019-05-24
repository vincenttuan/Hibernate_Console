package book.orm.dao;

import java.util.Set;
import java.util.logging.Level;
import book.orm.model.Book;

public class CategoryDAOImpl extends BaseDAOImpl implements ICategoryDAO {

    static {
        // 關閉 hibernate warn log
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    }
    
    @Override
    public Set<Book> queryBookById(int c_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
