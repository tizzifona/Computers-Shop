package projects.java.computers_shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.java.computers_shop.models.Computer;
import projects.java.computers_shop.repositories.ComputerRepository;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public Computer addComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    public Computer deleteComputerByBrand(String brand) {
        return computerRepository.deleteByBrand(brand);
    }

    public Computer findComputerByBrand(String brand) {
        return computerRepository.findByBrand(brand);
    }
}
