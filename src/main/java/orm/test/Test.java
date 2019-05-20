package orm.test;

import java.util.Scanner;
import orm.dao.BookDAOImpl;
import orm.model.Book;

public class Test {
    
    public static void main(String[] args) {
        menu();
        
    }
    
    public static void menu() {
        BookDAOImpl dao = new BookDAOImpl();
        System.out.println("------------------");
        System.out.println("1. 新增 Book 資料");
        System.out.println("2. 查詢 Book 資料(by id)");
        System.out.println("3. 查詢 Book 資料(全部)");
        System.out.println("4. 修改 Book 資料");
        System.out.println("5. 刪除 Book 資料");
        System.out.println("6. Exit");
        System.out.println("------------------");
        System.out.println("請選擇:");
        Scanner scanner = new Scanner(System.in);
        switch(scanner.nextInt()) {
            case 1:
                Book book = new Book();
                System.out.println("請輸入書名:");
                book.setName(scanner.next());
                System.out.println("請輸入價格:");
                book.setPrice(scanner.nextInt());
                System.out.println("新增 : " + dao.create(book));
                break;
            case 2:
                System.out.println("請輸入Book id:");
                System.out.println(dao.get(scanner.nextInt()));
                break;
            case 3:
                System.out.println(dao.queryAll());
                break;
            case 4:
                System.out.println("請輸入Book id:");
                Book update_book = dao.get(scanner.nextInt());
                System.out.println(update_book);
                System.out.println("請輸入書名:");
                update_book.setName(scanner.next());
                System.out.println("請輸入價格:");
                update_book.setPrice(scanner.nextInt());
                System.out.println("修改 : " + dao.update(update_book));
                break;
            case 5:
                System.out.println("請輸入Book id:");
                Book delete_book = dao.get(scanner.nextInt());
                System.out.println(delete_book);
                System.out.println("是否要刪除(y/n) ?");
                if(scanner.next().equalsIgnoreCase("y")) {
                    System.out.println("刪除 : " + dao.delete(delete_book.getId()));
                }
                break;    
            default:
                System.exit(0);
        }
        menu();
    }
    
}
