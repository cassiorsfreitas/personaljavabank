import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.MainController;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.UserOptions;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MainControllerTest {

    private MainController mainController;
    private AuthService authService;
    private Controller controller;
    private Customer customer;
    private View view;

    @Before
    public void setup() {

        // setup
        mainController = new MainController();

        controller = mock(Controller.class);
        authService = mock(AuthService.class);
        view = mock(View.class);
        customer = mock(Customer.class);

        Map<Integer, Controller> controllerMap = new HashMap<>();
        controllerMap.put(UserOptions.DEPOSIT.getOption(), controller);

        mainController.setControllerMap(controllerMap);
        mainController.setAuthService(authService);
        mainController.setView(view);

    }

    @Test
    public void initTest() {

        // exercise
        mainController.init();

        // verify
        verify(view).show();

    }

    @Test
    public void onMenuSelectionSuccessTest() {

        // exercise
        mainController.onMenuSelection(UserOptions.DEPOSIT.getOption());

        // verify
        verify(controller).init();
    }

    @Test(expected = IllegalStateException.class)
    public void onMenuSelectionFailTest() {

        // exercise
        mainController.onMenuSelection(8);
    }


    @Test
    public void getCustomerNameTest() {

        // setup
        String name = "Edgar";
        when(customer.getName()).thenReturn(name);
        when(authService.getAccessingCustomer()).thenReturn(customer);

        // validate
        assertEquals(mainController.getCustomerName(), name);
    }
}
