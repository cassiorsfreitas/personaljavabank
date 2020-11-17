import org.academiadecodigo.bootcamp.InputScanner;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.LoginController;
import org.academiadecodigo.javabank.view.LoginView;
import org.academiadecodigo.javabank.view.Messages;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class LoginViewTest {

    private LoginController loginController;
    private LoginView loginView;
    private Prompt prompt;
    private PrintStream out;


    @Before
    public void setup() {
        // setup
        loginController = mock(LoginController.class);
        loginView = new LoginView();
        prompt = mock(Prompt.class);

        out = mock(PrintStream.class);
        System.setOut(out);

        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);
    }

    @Test
    public void ShowLoginPromptTest() {

        // setup
        int fakeId = 1;
        when(prompt.getUserInput(ArgumentMatchers.any(InputScanner.class))).thenReturn(fakeId);

        // exercise
        loginView.show();

        //verify
        verify(prompt).getUserInput(ArgumentMatchers.any(InputScanner.class));
        verify(loginController).onLogin(fakeId);
        verify(out, never()).println(Messages.VIEW_LOGIN_ERROR);

    }


}
