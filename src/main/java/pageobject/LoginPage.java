package pageobject;

import api.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.sun.xml.txw2.output.StaxSerializer;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    public final static String URL_LOGIN = "https://stellarburgers.nomoreparties.site/login";

    //Текст Вход на странице авторизации
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement authorizationButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationButton;

    //Поле Email
    @FindBy(how = How.XPATH, using = "//label[text()='Email']//following-sibling::input")
    private SelenideElement emailField;

    //Поле Пароль
    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']//following-sibling::input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement errorPasswordMessage;

    @FindBy(how = How.XPATH, using = "//div/p/a[text()='Войти']")
    private SelenideElement enterLinkButton;

    @Step("Подождать пока появится кнопка Авторизация")
    public void waitForAuthButton() {
        authorizationButton.shouldBe(Condition.visible);
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public RegistrationPage clickRegistrationButtonLoginPage() {
        registrationButton.click();
        return page(RegistrationPage.class);
    }

    @Step("Подождать пока не появится кнопка Войти")
    public LoginPage enterHeaderShouldBeVisible() {
        enterButton.shouldBe(Condition.visible);
        authorizationButton.shouldBe(Condition.enabled);
        return this;
    }

    @Step("Ввести email")
    public LoginPage setEmail(String email) {
        emailField.click();
        emailField.val(email);
        return this;
    }

    @Step("Ввести пароль")
    public LoginPage setPassword(String password) {
        passwordField.click();
        passwordField.val(password);
        return this;
    }

    @Step("Кликнуть на кнопку Войти на странице логина")
    public MainPage clickLoginPageAuthButton() {
        authorizationButton.shouldBe(Condition.enabled).click();
        return page(MainPage.class);
    }

    @Step("Ввести данные пользователя")
    public MainPage loginUser(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        return clickLoginPageAuthButton();
    }

    @Step("Ввести данные пользователя")
    public MainPage loginRegisterUser(String email, String password) {
        Selenide.sleep(250);
        setEmail(email);
        setPassword(password);
        return clickLoginPageAuthButton();
    }

    @Step("Проверить что кнопка Войти есть на странице")
    public boolean isEnterButtonExist() {
        enterButton.shouldBe(Condition.visible);
        return enterButton.exists();
    }

    @Step("Проверить сообщение об ошибке")
    public boolean isErrorMessageAppear() {
        return errorPasswordMessage.exists();
    }

    @Step("Проверить что отобразился текст с ошибкой ")
    public LoginPage errorPasswordMessageGetText() {
        Assert.assertEquals("Некорректный пароль",
                errorPasswordMessage.shouldBe(Condition.visible)
                        .getText());
        return this;
    }

    public LoginPage clickEnterLinkButton() {
        enterLinkButton.click();
        return page(LoginPage.class);
    }
}
