import org.academiadecodigo.bootcamp.InputScanner;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.javabank.controller.MainController;
import org.academiadecodigo.javabank.view.MainView;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class MainViewTest {

    private MainController mainController;
    private MainView mainView;
    private PrintStream out;
    private Prompt prompt;

    @Before
    public void setup() {

        // setup
        mainController = mock(MainController.class);
        mainView = new MainView();
        out = mock(PrintStream.class);
        prompt = mock(Prompt.class);

        System.setOut(out);

        mainView.setMainController(mainController);
        mainView.setPrompt(prompt);
    }

    @Test
    public void showTest() {

        // setup
        int fakeOp = 8;
        when(prompt.getUserInput(any(InputScanner.class))).thenReturn(fakeOp);

        // exercise
        mainView.show();

        // verify
        verify(mainController).onMenuSelection(fakeOp);
    }
}
