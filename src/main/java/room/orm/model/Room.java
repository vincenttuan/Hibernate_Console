package room.orm.model;

import java.util.HashSet;
import java.util.Set;

public class Room {

    private Long id;
    private String address;
    private Set<Tenant> tenants = new HashSet<>();

    public Room() {
    }

    public Room(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(Set<Tenant> tenants) {
        this.tenants = tenants;
    }
    
    
    
}
