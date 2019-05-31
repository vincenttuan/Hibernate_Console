package stock.orm.model;

import java.util.HashSet;
import java.util.Set;

public class Fund {

    private Integer fundId;
    private String name;
    private String desc;
    private Set<Stock> stocks = new HashSet<>();
    
    public Fund() {
    }
    
    public Fund(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Fund{" + "fundId=" + fundId + ", name=" + name + ", desc=" + desc + ", stocks=" + stocks + '}';
    }

}
