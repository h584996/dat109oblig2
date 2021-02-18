package rental_company.client_test;

import org.junit.jupiter.api.Test;
import rental_company.Address;
import rental_company.Client;
import rental_company.Office;

import static org.junit.jupiter.api.Assertions.assertNull;

public class ClientTest {

    @Test
    public void testNewlyCreatedClientHasNullRentalInfo(){
        assertNull(new Client("test", "Test", new Address("a", 123, "test"), 123).getRentalInfo());
    }
}
