package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class RecoveryPasswordPage {

    public final static String URL_FORGOT_PASSWORD = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(xpath = "//a[text()='Войти']")
    private SelenideElement linkPasswordRecoveryToLoginForm;

    @Step("Кликнуть Войти на странице восстановления пароля")
    public LoginPage clickRecoveryPasswordButton() {
        linkPasswordRecoveryToLoginForm.click();
        return page(LoginPage.class);
    }
}
