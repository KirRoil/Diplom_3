import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.RecoveryPasswordPage;
import pageobject.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class AuthorizationTest extends BaseTest {

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void authButtonMainPageAuthTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .clickLoginButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void authButtonProfileAuthTest() {

        open(MainPage.URL_MAIN, MainPage.class)
                .clickProfileButtonBeforeAuth()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void authButtonRegistrationAuthTest() {

        open(RegistrationPage.URL_REGISTER, RegistrationPage.class)
                .clickRegistrationPageAuthButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void authButtonRecoveryPassTest() {

        open(RecoveryPasswordPage.URL_FORGOT_PASSWORD, RecoveryPasswordPage.class)
                .clickRecoveryPasswordButton()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickLoginPageAuthButton()
                .isCreateOrderButtonAppear();
    }

}
