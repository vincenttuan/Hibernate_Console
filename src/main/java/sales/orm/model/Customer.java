package sales.orm.model;

public class Customer {
    private String cid;
    private String name;
    private String emNo; // 儲存 emNo

    public Customer() {
    }

    public Customer(String cid, String name, String emNo) {
        this.cid = cid;
        this.name = name;
        this.emNo = emNo;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmNo() {
        return emNo;
    }

    public void setEmNo(String emNo) {
        this.emNo = emNo;
    }
    
    
}
