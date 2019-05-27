package book.orm.model;

public class BookCategory {
    private int bc_id;
    private int b_id;
    private int c_id;

    public BookCategory() {
    }

    public BookCategory(int b_id, int c_id) {
        this.b_id = b_id;
        this.c_id = c_id;
    }

    public int getBc_id() {
        return bc_id;
    }

    public void setBc_id(int bc_id) {
        this.bc_id = bc_id;
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
