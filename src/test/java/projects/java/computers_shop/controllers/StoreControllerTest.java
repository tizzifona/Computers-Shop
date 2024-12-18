package projects.java.computers_shop.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import projects.java.computers_shop.dtos.StoreDTO;
import projects.java.computers_shop.models.Store;
import projects.java.computers_shop.services.StoreService;

@ExtendWith(MockitoExtension.class)
class StoreControllerTest {

    @Mock
    private StoreService storeService;

    @InjectMocks
    private StoreController storeController;

    private Store store;
    private StoreDTO storeDTO;

    @BeforeEach
    void setUp() {
        storeDTO = new StoreDTO(1L, "Tech Shop", "John Doe", "123456789");
        store = new Store();
        store.setId(1L);
        store.setName("Tech Shop");
        store.setOwner("John Doe");
        store.setTaxId("123456789");
    }

    @Test
    void addStore_ShouldReturnStore_WhenStoreIsAdded() {

        when(storeService.addStore(storeDTO)).thenReturn(store);

        ResponseEntity<Store> response = storeController.addStore(storeDTO);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(notNullValue()));
        assertThat(response.getBody().getId(), is(1L));
        assertThat(response.getBody().getName(), is("Tech Shop"));
        assertThat(response.getBody().getOwner(), is("John Doe"));
        assertThat(response.getBody().getTaxId(), is("123456789"));

        verify(storeService).addStore(storeDTO);
    }

    @Test
    void getStoreById_ShouldReturnStoreDTO_WhenStoreExists() {

        when(storeService.getStoreById(1L)).thenReturn(storeDTO);

        ResponseEntity<StoreDTO> response = storeController.getStoreById(1L);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(notNullValue()));
        assertThat(response.getBody().id(), is(1L));
        assertThat(response.getBody().name(), is("Tech Shop"));
        assertThat(response.getBody().owner(), is("John Doe"));
        assertThat(response.getBody().taxid(), is("123456789"));

        verify(storeService).getStoreById(1L);
    }

    @Test
    void listStores_ShouldReturnListOfStoreDTOs() {

        List<StoreDTO> storeDTOList = List.of(storeDTO);
        when(storeService.getAllStores()).thenReturn(storeDTOList);

        ResponseEntity<List<StoreDTO>> response = storeController.listStores();

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(not(empty())));
        assertThat(response.getBody().size(), is(1));
        assertThat(response.getBody().get(0).id(), is(1L));
        assertThat(response.getBody().get(0).name(), is("Tech Shop"));
        assertThat(response.getBody().get(0).owner(), is("John Doe"));
        assertThat(response.getBody().get(0).taxid(), is("123456789"));

        verify(storeService).getAllStores();
    }
}
