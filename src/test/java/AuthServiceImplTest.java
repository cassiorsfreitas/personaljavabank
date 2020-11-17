import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class AuthServiceImplTest {

    private AuthServiceImpl authServiceImpl;
    private CustomerService customerService;
    private Customer fakeCustomer;

    @Before
    public void setup() {

        // setup
        authServiceImpl = new AuthServiceImpl();
        customerService = mock(CustomerService.class);

        authServiceImpl.setCustomerService(customerService);

    }

    @Test
    public void authenticateSuccessTest() {

        // setup
        int fakeId = 143;
        fakeCustomer = mock(Customer.class);
        when(customerService.get(fakeId)).thenReturn(fakeCustomer);

        // exercise
        boolean authResult = authServiceImpl.authenticate(fakeId);

        // validate
        Assert.assertTrue(authResult);

        // teardown
        fakeCustomer = null;

    }

    @Test
    public void authenticateFailTest() {

        // setup
        int fakeId = 143;
        when(customerService.get(fakeId)).thenReturn(null);

        // exercise
        boolean authResult = authServiceImpl.authenticate(fakeId);

        // validate
        Assert.assertFalse(authResult);
    }

    @Test
    public void getAccessingCustomerTest() {

        // setup
        int fakeId = 143;
        fakeCustomer = mock(Customer.class);
        when(customerService.get(fakeId)).thenReturn(fakeCustomer);
        when(fakeCustomer.getId()).thenReturn(fakeId);

        // exercise
        authServiceImpl.authenticate(fakeId);
        Customer customer = authServiceImpl.getAccessingCustomer();

        // validate
        Assert.assertEquals(fakeCustomer, customer);

        // teardown
        fakeCustomer = null;
    }

}
