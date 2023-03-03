import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class MoveToConstructorSectionsTest extends BaseTest {

    @Test
    @DisplayName("Перейти в Булочки в конструкторе по кнопке")
    public void moveBunsSectionButtonTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .clickSaucesButton()
                .clickBunsButton()
                .isBunsHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Перейти в Соусы в конструкторе по кнопке")
    public void moveSaucesSectionButtonTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .clickSaucesButton()
                .isSaucesHeaderDisplayed();
    }

    @Test
    @DisplayName("Перейти в Начинки в конструкторе по кнопке")
    public void moveFillingsSectionButtonTest() {

        open(MainPage.URL_MAIN, MainPage.class)
                .clickFillingsButton()
                .isSaucesHeaderDisplayed();
    }

    @Test
    @DisplayName("Скролл к Булочкам в конструторе")
    public void moveBunsSectionScrollTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .scrollToBunsHeader()
                .isBunsHeaderIsDisplayed();
    }


    @Test
    @DisplayName("Скролл к Соусам в конструторе")
    public void moveSaucesSectionScrollTest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .scrollToSaucesHeader()
                .isSaucesHeaderDisplayed();
    }


    @Test
    @DisplayName("Скролл к Начинкам в конструторе")
    public void moveFillingsSectionScrollest() {
        open(MainPage.URL_MAIN, MainPage.class)
                .scrollToFillingsHeader()
                .isFillingsHeaderDisplayed();
    }

}