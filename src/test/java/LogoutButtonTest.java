import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;

public class LogoutButtonTest extends  BaseTest{


    @Test
    @DisplayName("Выйти из личного кабинета через кнопку Выйти")
    public void logoutProfileButton(){
        open(LoginPage.URL_LOGIN, LoginPage.class)
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton()
                .clickProfileButtonAfterAuth()
                .clickExitButton()
                .isEnterButtonExist();
    }
}