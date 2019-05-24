package book.orm.dao;

import java.util.Set;
import book.orm.model.Book;

public interface ICategoryDAO extends IBaseDAO {
    Set<Book> queryBookById(int c_id);
}
