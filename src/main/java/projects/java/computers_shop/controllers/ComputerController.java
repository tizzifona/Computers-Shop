package projects.java.computers_shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projects.java.computers_shop.dtos.ComputerDTO;
import projects.java.computers_shop.services.ComputerService;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping
    public ResponseEntity<List<ComputerDTO>> listComputers() {
        return ResponseEntity.ok(computerService.getAllComputers());
    }

    @PostMapping("/add")
    public ResponseEntity<ComputerDTO> addComputer(@RequestBody ComputerDTO computerDTO) {
        return ResponseEntity.ok(computerService.addComputer(computerDTO));
    }

    @DeleteMapping("/delete/{brand}")
    public ResponseEntity<ComputerDTO> deleteComputer(@PathVariable String brand) {
        ComputerDTO deletedComputer = computerService.deleteComputerByBrand(brand);
        if (deletedComputer != null) {
            return ResponseEntity.ok(deletedComputer);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{brand}")
    public ResponseEntity<ComputerDTO> findComputer(@PathVariable String brand) {
        ComputerDTO computer = computerService.findComputerByBrand(brand);
        if (computer != null) {
            return ResponseEntity.ok(computer);
        }
        return ResponseEntity.notFound().build();
    }
}
