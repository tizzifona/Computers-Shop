package projects.java.computers_shop.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import projects.java.computers_shop.dtos.StoreDTO;
import projects.java.computers_shop.models.Store;
import projects.java.computers_shop.repositories.StoreRepository;

class StoreServiceTest {

    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private StoreService storeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getStoreById_ShouldReturnStoreDTO_WhenStoreExists() {
        Store store = new Store();
        store.setId(1L);
        store.setName("Tech Shop");
        store.setOwner("John Doe");
        store.setTaxId("123456789");

        when(storeRepository.findById(1L)).thenReturn(Optional.of(store));

        StoreDTO result = storeService.getStoreById(1L);

        assertThat(result.id(), is(1L));
        assertThat(result.name(), is("Tech Shop"));
        assertThat(result.owner(), is("John Doe"));
        assertThat(result.taxid(), is("123456789"));
        verify(storeRepository).findById(1L);
    }

    @Test
    void getStoreById_ShouldThrowException_WhenStoreDoesNotExist() {
        when(storeRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> storeService.getStoreById(1L));
        assertThat(exception.getMessage(), is("Store with ID1not found!"));
        verify(storeRepository).findById(1L);
    }

    @Test
    void getAllStores_ShouldReturnListOfStoreDTOs() {
        Store store1 = new Store();
        store1.setId(1L);
        store1.setName("Tech Shop");
        store1.setOwner("John Doe");
        store1.setTaxId("123456789");

        Store store2 = new Store();
        store2.setId(2L);
        store2.setName("Gadget Store");
        store2.setOwner("Jane Smith");
        store2.setTaxId("987654321");

        when(storeRepository.findAll()).thenReturn(List.of(store1, store2));

        List<StoreDTO> result = storeService.getAllStores();

        assertThat(result, hasSize(2));

        assertThat(result.get(0).id(), equalTo(1L));
        assertThat(result.get(0).name(), equalTo("Tech Shop"));
        assertThat(result.get(0).owner(), equalTo("John Doe"));
        assertThat(result.get(0).taxid(), equalTo("123456789"));

        assertThat(result.get(1).id(), equalTo(2L));
        assertThat(result.get(1).name(), equalTo("Gadget Store"));
        assertThat(result.get(1).owner(), equalTo("Jane Smith"));
        assertThat(result.get(1).taxid(), equalTo("987654321"));

        verify(storeRepository).findAll();
    }

    @Test
    void addStore_ShouldReturnStore_WhenStoreIsAdded() {

        StoreDTO storeDTO = new StoreDTO(1L, "Tech Shop", "John Doe", "123456789");
        Store store = new Store();
        store.setId(1L);
        store.setName("Tech Shop");
        store.setOwner("John Doe");
        store.setTaxId("123456789");

        when(storeRepository.save(Mockito.<Store>any())).thenReturn(store);

        Store result = storeService.addStore(storeDTO);

        assertThat(result, is(notNullValue()));
        assertThat(result.getId(), equalTo(1L));
        assertThat(result.getName(), equalTo("Tech Shop"));
        assertThat(result.getOwner(), equalTo("John Doe"));
        assertThat(result.getTaxId(), equalTo("123456789"));

        verify(storeRepository).save(Mockito.<Store>any());
    }

}
