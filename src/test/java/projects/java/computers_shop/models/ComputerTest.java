package projects.java.computers_shop.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private Computer computer;
    private Store mockStore;

    @BeforeEach
    void setUp() {
        mockStore = mock(Store.class);
        computer = new Computer(1L, "Dell", 16, "Intel i7", "Windows 10", 1200.00, mockStore);
    }

    @Test
    void testConstructorAndGetters() {
        assertThat(computer.getId(), is(1L));
        assertThat(computer.getBrand(), is("Dell"));
        assertThat(computer.getMemory(), is(16));
        assertThat(computer.getProcessor(), is("Intel i7"));
        assertThat(computer.getOperatingSystem(), is("Windows 10"));
        assertThat(computer.getPrice(), is(1200.00));
        assertThat(computer.getStore(), is(mockStore));
    }

    @Test
    void testSetters() {
        Store newMockStore = mock(Store.class);

        computer.setId(2L);
        computer.setBrand("HP");
        computer.setMemory(32);
        computer.setProcessor("AMD Ryzen 7");
        computer.setOperatingSystem("Linux");
        computer.setPrice(1500.00);
        computer.setStore(newMockStore);

        assertThat(computer.getId(), is(2L));
        assertThat(computer.getBrand(), is("HP"));
        assertThat(computer.getMemory(), is(32));
        assertThat(computer.getProcessor(), is("AMD Ryzen 7"));
        assertThat(computer.getOperatingSystem(), is("Linux"));
        assertThat(computer.getPrice(), is(1500.00));
        assertThat(computer.getStore(), is(newMockStore));
    }

    @Test
    void testStoreIntegration() {
        when(mockStore.getName()).thenReturn("Tech Store");

        assertThat(computer.getStore().getName(), is("Tech Store"));
        verify(mockStore, times(1)).getName();
    }
}
