
package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 15000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;

    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //ввод значений
        $("#firstName").setValue("Shak");
        $("#lastName").setValue("Svetlov");
        $("#userEmail").setValue("shak.svet@gmail.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("0000000001");
 }
}
