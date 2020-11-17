import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoginControllerTest {

    private LoginController loginController;
    private Controller nextController;
    private AuthService authService;
    private View view;

    @Before
    public void setup() {

        // setup
        loginController = new LoginController();

        nextController = mock(Controller.class);
        authService = mock(AuthService.class);
        view = mock(View.class);

        loginController.setNextController(nextController);
        loginController.setAuthService(authService);
        loginController.setView(view);

    }

    @Test
    public void initTest() {
        // exercise
        loginController.init();

        // validate
        verify(view).show();
    }

    @Test
    public void loginSuccessTest() {

        // setup
        int fakeId = 10;
        when(authService.authenticate(fakeId)).thenReturn(true);

        // exercise
        loginController.onLogin(fakeId);

        // validate
        verify(authService).authenticate(fakeId);
        verify(nextController).init();
        verify(view, never()).show();

    }

    @Test
    public void loginFailTest() {

        // setup
        int fakeId = 10;
        when(authService.authenticate(anyInt())).thenReturn(false);

        // exercise
        loginController.onLogin(fakeId);

        // validate
        verify(authService).authenticate(fakeId);
        verify(nextController, never()).init();
        verify(view).show();
    }

}
