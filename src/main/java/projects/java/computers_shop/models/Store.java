package projects.java.computers_shop.models;

public class Store {
    private Long id;
    private String name;
    private String owner;
    private String taxId;

    public Store(Long id, String name, String owner, String taxId) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.taxId = taxId;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
}
