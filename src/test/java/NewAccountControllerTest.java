import org.academiadecodigo.javabank.controller.NewAccountController;
import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.AuthService;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class NewAccountControllerTest {

    private NewAccountController newAccountController;
    private AuthService authService;
    private View view;
    private AccountFactory accountFactory;
    private Customer customer;

    @Before
    public void setup() {

        // setup
        newAccountController = new NewAccountController();
        authService = mock(AuthService.class);
        view = mock(View.class);
        accountFactory = mock(AccountFactory.class);
        customer = mock(Customer.class);
        AccountService accountService = mock(AccountService.class);

        when(authService.getAccessingCustomer()).thenReturn(customer);

        newAccountController.setAuthService(authService);
        newAccountController.setAccountService(accountService);
        newAccountController.setView(view);
        newAccountController.setAccountFactory(accountFactory);

    }

    @Test
    public void initTest() {

        // setup
        int id = 12;
        Account account = mock(Account.class);
        when(account.getId()).thenReturn(id);
        when(accountFactory.createAccount(any(AccountType.class))).thenReturn(account);

        // exercise
        newAccountController.init();

        // verify
        verify(view).show();
        verify(accountFactory).createAccount(any(AccountType.class));
        verify(authService).getAccessingCustomer();
        verify(customer).addAccount(account);
        assertEquals(id, (int) newAccountController.getNewAccountId());
        int newAccountId = newAccountController.getNewAccountId();
        assertEquals(newAccountId, id);

    }
}
