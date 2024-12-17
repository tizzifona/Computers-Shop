package projects.java.computers_shop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projects.java.computers_shop.dtos.StoreDTO;
import projects.java.computers_shop.models.Store;
import projects.java.computers_shop.repositories.StoreRepository;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public Store addStore(StoreDTO storeDTO) {
        Store store = new Store();
        store.setName(storeDTO.name());
        store.setOwner(storeDTO.owner());
        store.setTaxId(storeDTO.taxid());
        return storeRepository.save(store);
    }

    public StoreDTO getStoreById(Long id) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if (storeOptional.isEmpty()) {
            throw new RuntimeException("Store with ID" + id + "not found!");
        }
        Store store = storeOptional.get();
        return new StoreDTO(store.getName(), store.getOwner(), store.getTaxId());
    }

}
