package projects.java.computers_shop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.java.computers_shop.models.Computer;
import projects.java.computers_shop.dtos.ComputerDTO;
import projects.java.computers_shop.repositories.ComputerRepository;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    public List<ComputerDTO> getAllComputers() {
        return computerRepository.findAll()
                .stream()
                .map(computer -> new ComputerDTO(
                        computer.getBrand(),
                        computer.getMemory(),
                        computer.getProcessor(),
                        computer.getOperatingSystem(),
                        computer.getPrice()))
                .collect(Collectors.toList());
    }

    public ComputerDTO addComputer(ComputerDTO computerDTO) {
        Computer computer = new Computer(
                null,
                computerDTO.brand(),
                computerDTO.memory(),
                computerDTO.processor(),
                computerDTO.operatingSystem(),
                computerDTO.price());

        Computer savedComputer = computerRepository.save(computer);
        return new ComputerDTO(
                savedComputer.getBrand(),
                savedComputer.getMemory(),
                savedComputer.getProcessor(),
                savedComputer.getOperatingSystem(),
                savedComputer.getPrice());
    }

    public ComputerDTO deleteComputerByBrand(String brand) {
        Computer computer = computerRepository.deleteByBrand(brand);
        if (computer != null) {
            return new ComputerDTO(
                    computer.getBrand(),
                    computer.getMemory(),
                    computer.getProcessor(),
                    computer.getOperatingSystem(),
                    computer.getPrice());
        }
        return null;
    }

    public ComputerDTO findComputerByBrand(String brand) {
        Computer computer = computerRepository.findByBrand(brand);
        if (computer != null) {
            return new ComputerDTO(
                    computer.getBrand(),
                    computer.getMemory(),
                    computer.getProcessor(),
                    computer.getOperatingSystem(),
                    computer.getPrice());
        }
        return null;
    }
}
