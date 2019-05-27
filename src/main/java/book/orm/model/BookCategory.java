package book.orm.model;

public class BookCategory {
    private int id;
    private int b_id;
    private int c_id;

    public BookCategory() {
    }

    public BookCategory(int b_id, int c_id) {
        this.b_id = b_id;
        this.c_id = c_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    
}
