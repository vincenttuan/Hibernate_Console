package book.orm.dao;

import java.util.Set;
import book.orm.model.Book;
import book.orm.model.Category;

public interface ICategoryDAO {
    boolean create(Category category);
    boolean update(Category category);
    boolean delete(int id);
    Set<Category> queryAll();
    Set<Book> queryBookById(int c_id);
    Category get(int id);
}
