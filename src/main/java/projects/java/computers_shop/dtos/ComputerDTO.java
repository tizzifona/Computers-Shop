package projects.java.computers_shop.dtos;

public record ComputerDTO(Long id, String brand, int memory, String processor, String operatingSystem, double price,
        Long storeId) {

}
