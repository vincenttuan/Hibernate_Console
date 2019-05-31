package stock.orm.model;

public class Stock implements java.io.Serializable {

    private Integer stockId;
    private String stockCode;
    private String stockName;
    
    public Stock() {
        
    }

    public Stock(String stockCode, String stockName) {
        this.stockCode = stockCode;
        this.stockName = stockName;
    }
    
    

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public String toString() {
        return "Stock{" + "stockId=" + stockId + ", stockCode=" + stockCode + ", stockName=" + stockName + '}';
    }
    
    
}
