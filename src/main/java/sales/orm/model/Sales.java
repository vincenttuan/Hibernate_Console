package sales.orm.model;

import java.util.HashSet;
import java.util.Set;

public class Sales {
    private String emNo;
    private String name;
    private Set<Customer> customers = new HashSet<>();

    public Sales() {
    }

    public Sales(String emNo, String name) {
        this.emNo = emNo;
        this.name = name;
    }

    public String getEmNo() {
        return emNo;
    }

    public void setEmNo(String emNo) {
        this.emNo = emNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
    
    
}

