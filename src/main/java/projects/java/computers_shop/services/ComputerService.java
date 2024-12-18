package projects.java.computers_shop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import projects.java.computers_shop.models.Computer;
import projects.java.computers_shop.models.Store;
import projects.java.computers_shop.dtos.ComputerDTO;
import projects.java.computers_shop.repositories.ComputerRepository;
import projects.java.computers_shop.repositories.StoreRepository;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private StoreRepository storeRepository;

    public List<ComputerDTO> getAllComputers() {
        return computerRepository.findAll()
                .stream()
                .map(computer -> new ComputerDTO(
                        computer.getId(),
                        computer.getBrand(),
                        computer.getMemory(),
                        computer.getProcessor(),
                        computer.getOperatingSystem(),
                        computer.getPrice(),
                        computer.getStore() != null ? computer.getStore().getId() : null))
                .collect(Collectors.toList());
    }

    public ComputerDTO addComputer(ComputerDTO computerDTO) {
        Store store = null;
        if (computerDTO.storeId() != null) {
            store = storeRepository.findById(computerDTO.storeId())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Store with ID " + computerDTO.storeId() + " not found"));
        }

        Computer computer = new Computer(
                computerDTO.id(),
                computerDTO.brand(),
                computerDTO.memory(),
                computerDTO.processor(),
                computerDTO.operatingSystem(),
                computerDTO.price(),
                store);

        computer.setStore(store);
        Computer savedComputer = computerRepository.save(computer);

        return new ComputerDTO(
                savedComputer.getId(),
                savedComputer.getBrand(),
                savedComputer.getMemory(),
                savedComputer.getProcessor(),
                savedComputer.getOperatingSystem(),
                savedComputer.getPrice(),
                savedComputer.getStore() != null ? savedComputer.getStore().getId() : null);
    }

    @Transactional
    public ComputerDTO deleteComputerByBrand(String brand) {
        Computer computer = computerRepository.findByBrand(brand);
        if (computer != null) {
            computerRepository.delete(computer);
            return new ComputerDTO(
                    computer.getId(),
                    computer.getBrand(),
                    computer.getMemory(),
                    computer.getProcessor(),
                    computer.getOperatingSystem(),
                    computer.getPrice(),
                    computer.getStore() != null ? computer.getStore().getId() : null);
        }
        return null;
    }

    public ComputerDTO findComputerByBrand(String brand) {
        Computer computer = computerRepository.findByBrand(brand);
        if (computer != null) {
            return new ComputerDTO(
                    computer.getId(),
                    computer.getBrand(),
                    computer.getMemory(),
                    computer.getProcessor(),
                    computer.getOperatingSystem(),
                    computer.getPrice(),
                    computer.getStore() != null ? computer.getStore().getId() : null);
        }
        return null;
    }
}
