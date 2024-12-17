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

import projects.java.computers_shop.models.Computer;
import projects.java.computers_shop.services.ComputerService;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping
    public ResponseEntity<List<Computer>> listComputers() {
        return ResponseEntity.ok(computerService.getAllComputers());
    }

    @PostMapping("/add")
    public ResponseEntity<Computer> addComputer(@RequestBody Computer computer) {
        return ResponseEntity.ok(computerService.addComputer(computer));
    }

    @DeleteMapping("/delete/{brand}")
    public ResponseEntity<Computer> deleteComputer(@PathVariable String brand) {
        return ResponseEntity.ok(computerService.deleteComputerByBrand(brand));
    }

    @GetMapping("/find/{brand}")
    public ResponseEntity<Computer> findComputer(@PathVariable String brand) {
        return ResponseEntity.ok(computerService.findComputerByBrand(brand));
    }

}
