package projects.java.computers_shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projects.java.computers_shop.dtos.StoreDTO;
import projects.java.computers_shop.models.Store;
import projects.java.computers_shop.services.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/add")
    public ResponseEntity<Store> addStore(@RequestBody StoreDTO storeDTO) {
        Store store = storeService.addStore(storeDTO);
        return ResponseEntity.ok(store);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable Long id) {
        StoreDTO storeDTO = storeService.getStoreById(id);
        return ResponseEntity.ok(storeDTO);
    }
}
