package book.orm.dao;

import book.orm.model.Category;
import java.util.Set;

public interface IBookCategoryDAO extends IBaseDAO {
    Set<Category> queryCategoryByBookId(int b_id);
    Set<Category> queryCategoryByBookIdNotIn(int b_id);
}
