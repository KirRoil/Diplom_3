import api.Generator;
import api.User;
import api.UserClient;
import api.UserCredentials;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {

    protected static final User user = Generator.getRandomUser();

    UserClient userClient;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    @Before
    public void init() {
        setUp();

        userClient = new UserClient();
        userClient.createUser(user);
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        UserCredentials userCredentials = new UserCredentials(user.getEmail(), user.getPassword());
        Response response = userClient.login(userCredentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            userClient.delete(response);
        }
    }
}
