package projects.java.computers_shop.controllers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import projects.java.computers_shop.dtos.ComputerDTO;
import projects.java.computers_shop.services.ComputerService;

class ComputerControllerTest {

    @Mock
    private ComputerService computerService;

    @InjectMocks
    private ComputerController computerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listComputers_ShouldReturnListOfComputers() {
        List<ComputerDTO> computers = Arrays.asList(
                new ComputerDTO(1L, "BrandA", 16, "Intel i7", "Windows", 1000.0, 1L),
                new ComputerDTO(2L, "BrandB", 32, "AMD Ryzen 5", "Linux", 1200.0, 2L));
        when(computerService.getAllComputers()).thenReturn(computers);

        ResponseEntity<List<ComputerDTO>> response = computerController.listComputers();

        assertThat(response.getStatusCode().value(), is(200));
        assertThat(response.getBody(), hasSize(2));
        assertThat(response.getBody().get(0).brand(), is("BrandA"));
        assertThat(response.getBody().get(1).brand(), is("BrandB"));
    }

    @Test
    void addComputer_ShouldAddAndReturnComputer() {

        ComputerDTO computer = new ComputerDTO(3L, "BrandC", 8, "Intel i5", "MacOS", 1500.0, 3L);
        when(computerService.addComputer(computer)).thenReturn(computer);

        ResponseEntity<ComputerDTO> response = computerController.addComputer(computer);

        assertThat(response.getStatusCode().value(), is(200));
        assertThat(response.getBody().brand(), is("BrandC"));
    }

    @Test
    void deleteComputer_ShouldDeleteAndReturnComputer_WhenFound() {

        String brand = "BrandA";
        ComputerDTO computer = new ComputerDTO(1L, "BrandA", 16, "Intel i7", "Windows", 1000.0, 1L);
        when(computerService.deleteComputerByBrand(brand)).thenReturn(computer);

        ResponseEntity<ComputerDTO> response = computerController.deleteComputer(brand);

        assertThat(response.getStatusCode().value(), is(200));
        assertThat(response.getBody().brand(), is("BrandA"));
    }

    @Test
    void deleteComputer_ShouldReturnNotFound_WhenNotFound() {

        String brand = "NonExistentBrand";
        when(computerService.deleteComputerByBrand(brand)).thenReturn(null);

        ResponseEntity<ComputerDTO> response = computerController.deleteComputer(brand);

        assertThat(response.getStatusCode().value(), is(404));
    }

    @Test
    void findComputer_ShouldReturnComputer_WhenFound() {

        String brand = "BrandA";
        ComputerDTO computer = new ComputerDTO(1L, "BrandA", 16, "Intel i7", "Windows", 1000.0, 1L);
        when(computerService.findComputerByBrand(brand)).thenReturn(computer);

        ResponseEntity<ComputerDTO> response = computerController.findComputer(brand);

        assertThat(response.getStatusCode().value(), is(200));
        assertThat(response.getBody().brand(), is("BrandA"));
    }

    @Test
    void findComputer_ShouldReturnNotFound_WhenNotFound() {

        String brand = "NonExistentBrand";
        when(computerService.findComputerByBrand(brand)).thenReturn(null);

        ResponseEntity<ComputerDTO> response = computerController.findComputer(brand);

        assertThat(response.getStatusCode().value(), is(404));
    }
}
