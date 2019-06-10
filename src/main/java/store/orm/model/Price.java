package store.orm.model;

public class Price {
    private Long id; 
    private int money;
    private Pen pen;       

    public Price() {
    }

    public Price(int money) {
        this.money = money;
    }

    public Price(int money, Pen pen) {
        this.money = money;
        this.pen = pen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }
    
    
}
