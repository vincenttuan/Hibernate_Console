package book.orm.test;

import java.util.Scanner;
import book.orm.dao.CategoryDAOImpl;
import book.orm.model.Category;

public class TestCategory {
    
    public static void main(String[] args) {
        menu();
        
    }
    
    public static void menu() {
        CategoryDAOImpl dao = new CategoryDAOImpl();
        System.out.println("------------------");
        System.out.println("1. 新增 Category 資料");
        System.out.println("2. 查詢 Category 資料(by id)");
        System.out.println("3. 查詢 Category 資料(全部)");
        System.out.println("4. 查詢 Book 資料(by c_id)");
        System.out.println("5. 修改 Category 資料");
        System.out.println("6. 刪除 Category 資料");
        System.out.println("7. Exit");
        System.out.println("------------------");
        System.out.println("請選擇:");
        Scanner scanner = new Scanner(System.in);
        switch(scanner.nextInt()) {
            case 1:
                Category category = new Category();
                System.out.println("請輸入類名:");
                category.setName(scanner.next());
                System.out.println("新增 : " + dao.create(category));
                break;
            case 2:
                System.out.println("請輸入category id:");
                System.out.println(dao.get(scanner.nextInt()));
                break;
            case 3:
                System.out.println(dao.queryAll());
                break;
            case 4:
                break;
            case 5:
                System.out.println("請輸入category id:");
                Category update_category = dao.get(scanner.nextInt());
                System.out.println(update_category);
                System.out.println("請輸入類名:");
                update_category.setName(scanner.next());
                System.out.println("修改 : " + dao.update(update_category));
                break;
            case 6:
                System.out.println("請輸入category id:");
                Category delete_category = dao.get(scanner.nextInt());
                System.out.println(delete_category);
                System.out.println("是否要刪除(y/n) ?");
                if(scanner.next().equalsIgnoreCase("y")) {
                    System.out.println("刪除 : " + dao.delete(delete_category.getId()));
                }
                break;    
            default:
                System.exit(0);
        }
        menu();
    }
    
}
