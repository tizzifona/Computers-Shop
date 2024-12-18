package projects.java.computers_shop.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StoreTest {
    private Store store;

    @BeforeEach
    void setUp() {
        store = new Store(1L, "Tech Store", "John Doe", "123456789");
    }

    @Test
    void testConstructorAndGetters() {
        assertThat(store.getId(), is(1L));
        assertThat(store.getName(), is("Tech Store"));
        assertThat(store.getOwner(), is("John Doe"));
        assertThat(store.getTaxId(), is("123456789"));
    }

    @Test
    void testSetters() {
        store.setId(2L);
        store.setName("Gadget Store");
        store.setOwner("Jane Doe");
        store.setTaxId("987654321");

        assertThat(store.getId(), is(2L));
        assertThat(store.getName(), is("Gadget Store"));
        assertThat(store.getOwner(), is("Jane Doe"));
        assertThat(store.getTaxId(), is("987654321"));
    }
}
