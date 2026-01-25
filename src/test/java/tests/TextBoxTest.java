package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void fillTextBoxFormTest() {
        new TextBoxPage()
                .openPage()
                .setFullName("Shak Montan")
                .setEmail("montana90@gmail.ru")
                .setCurrentAddress("001 Haryana Karnal")
                .setPermanentAddress("Same as current")
                .submit();
        new TextBoxPage().checkOutput(
                "Shak Montan",
                "montana90@gmail.ru",
                "001 Haryana Karnal",
                "Same as current"
        );
    }
}