package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //Student Registration Form
        $("#firstName").setValue("Shak");
        $("#lastName").setValue("Montan");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("0000000001");
        $("#userEmail").setValue("montana90@gmail.ru");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1996")).click();
        $(".react-datepicker__month-select").$(byText("November")).click();
        $(".react-datepicker__month").$(byText("11")).click();

        //Subjects
        $(".subjects-auto-complete__input").click();
        $("[aria-autocomplete=list").sendKeys("n");
        $(byText("English")).click();
        //Hobbies
        $("#hobbiesWrapper").$(byText("Music")).click();
        //Picture
        $("#uploadPicture").uploadFromClasspath("image.png");
        //Address
        $("#currentAddress").setValue("IN, Karnal, Haryana, 132001, Street No. 12, Mangalpur, Kunjpura Road");

        //State and City
        $("#stateCity-wrapper").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();
        // Table
        $(".table-responsive").$(byText("Student Name")).closest("tr").shouldHave(text("Shak Montan"));
        $(".table-responsive").$(byText("Student Email")).closest("tr").shouldHave(text("montana90@gmail.ru"));
        $(".table-responsive").$(byText("Gender")).closest("tr").shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).closest("tr").shouldHave(text("0000000001"));
        $(".table-responsive").$(byText("Date of Birth")).closest("tr").shouldHave(text("11 November,1996"));
        $(".table-responsive").$(byText("Subjects")).closest("tr").shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).closest("tr").shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).closest("tr").shouldHave(text("image.png"));
        $(".table-responsive").$(byText("Address")).closest("tr").shouldHave(text("IN, Karnal, Haryana, 132001, Street No. 12, Mangalpur, Kunjpura Road"));
        $(".table-responsive").$(byText("State and City")).closest("tr").shouldHave(text("Haryana Karnal"));
        $("#closeLargeModal").click();
    }
}
