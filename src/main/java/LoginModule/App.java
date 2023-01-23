package LoginModule;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        LoginBackend loginbackend = new LoginBackend();
        loginbackend.load();
        System.out.println(loginbackend.getLoginInfo().get("john"));
		LoginPage loginPage = new LoginPage(loginbackend.getLoginInfo());

    }
}
