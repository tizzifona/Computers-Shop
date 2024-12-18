package projects.java.computers_shop.dtos;

public record StoreDTO(Long id, String name, String owner, String taxid) {

    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String owner() {
        return owner;
    }

    public String taxid() {
        return taxid;
    }

}
