package store.orm.model;

public class Pen {
    private Long id; 
    private String name;
    private Price price;

    public Pen() {
    }

    public Pen(String name) {
        this.name = name;
    }

    public Pen(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    
}
