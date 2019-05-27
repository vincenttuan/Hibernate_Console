package book.orm.test;

import book.orm.dao.BookCategoryDAOImpl;
import book.orm.dao.IBookCategoryDAO;

public class TestBookCategory {
    
    public static void main(String[] args) {
        IBookCategoryDAO dao = new BookCategoryDAOImpl();
        System.out.println(dao.queryCategoryByBookId(1));
        System.out.println(dao.queryCategoryByBookIdNotIn(1));
    }
    
}
