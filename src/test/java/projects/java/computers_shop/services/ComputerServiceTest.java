package projects.java.computers_shop.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import projects.java.computers_shop.dtos.ComputerDTO;
import projects.java.computers_shop.models.Computer;
import projects.java.computers_shop.models.Store;
import projects.java.computers_shop.repositories.ComputerRepository;
import projects.java.computers_shop.repositories.StoreRepository;

class ComputerServiceTest {

    @Mock
    private ComputerRepository computerRepository;

    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private ComputerService computerService;

    private Store store;
    private Computer computer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        store = new Store(1L, "Tech Store", "John Doe", "123456789");
        computer = new Computer(1L, "Dell", 16, "Intel i7", "Windows 10", 1200.00, store);
    }

    @Test
    void testGetAllComputers() {
        Computer computer2 = new Computer(2L, "HP", 8, "AMD Ryzen 5", "Linux", 800.00, store);

        when(computerRepository.findAll()).thenReturn(Arrays.asList(computer, computer2));

        List<ComputerDTO> result = computerService.getAllComputers();

        assertThat(result, hasSize(2));
        assertThat(result.get(0).brand(), is("Dell"));
        assertThat(result.get(1).brand(), is("HP"));

        verify(computerRepository, times(1)).findAll();
    }

    @Test
    void testDeleteComputerByBrand() {
        when(computerRepository.findByBrandIgnoreCase("Dell")).thenReturn(computer);

        ComputerDTO result = computerService.deleteComputerByBrand("Dell");

        assertThat(result, notNullValue());
        assertThat(result.brand(), is("Dell"));

        verify(computerRepository, times(1)).findByBrandIgnoreCase("Dell");
        verify(computerRepository, times(1)).delete(computer);
    }

    @Test
    void testFindComputerByBrand() {
        when(computerRepository.findByBrandIgnoreCase("Dell")).thenReturn(computer);

        ComputerDTO result = computerService.findComputerByBrand("Dell");

        assertThat(result, notNullValue());
        assertThat(result.brand(), is("Dell"));

        verify(computerRepository, times(1)).findByBrandIgnoreCase("Dell");
    }

    @Test
    void testAddComputerWithNonexistentStore() {
        ComputerDTO computerDTO = new ComputerDTO(null, "Acer", 16, "Intel i5", "Windows 11", 1000.00, 99L);

        when(storeRepository.findById(99L)).thenReturn(Optional.empty());

        try {
            computerService.addComputer(computerDTO);
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("Store with ID 99 not found"));
        }

        verify(storeRepository, times(1)).findById(99L);
        verify(computerRepository, never()).save(computer);
    }
}
