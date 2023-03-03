import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class ProfileButtonTest extends BaseTest {

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    public void clickProfileButtonTest() {
        open(LoginPage.URL_LOGIN, LoginPage.class)
                .loginUser(user)
                .clickProfileButtonAfterAuth()
                .isProfileHeaderExist();

    }
}
