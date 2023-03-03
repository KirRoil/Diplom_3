package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {
    public final static String URL_PROFILE = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(how = How.XPATH, using = "//a[text()='Профиль']")
    private SelenideElement profileButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoStellarButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement logoutButton;


    @Step("Кликнуть на кнопку Выход")
    public LoginPage clickExitButton() {
        logoutButton.click();
        return page(LoginPage.class);
    }

    @Step("Проверить что заголовок Профиль существует")
    public boolean isProfileHeaderExist() {
        profileButton.shouldBe(Condition.visible);
        return profileButton.exists();
    }

    @Step("Кликнуть на кнопку конструктора")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }

    @Step("Кликнуть на Лого")
    public MainPage clickLogoButton() {
        logoStellarButton.click();
        return page(MainPage.class);
    }
}
