package tests;

import com.codeborne.selenide.Configuration;
import components.ResultModal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTest {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void minimalDataTest() {
        // Только обязательные поля: First Name, Last Name, Gender, Mobile
        new PracticeFormPage()
                .openPage()
                .removeBanners()
                .setFirstName("Min")
                .setLastName("User")
                .selectGenderFemale()
                .setMobile("3981449006")
                .submit();

        $(".modal-content").shouldBe(visible);

        new ResultModal()
                .checkField("Student Name", "Min User")
                .checkField("Gender", "Female")
                .checkField("Mobile", "3981449006")
                .close()
        ;
    }
    @Test
    void fullFormSubmissionTest() {
        new PracticeFormPage()
                .openPage()
                .removeBanners()
                .setFirstName("Shak")
                .setLastName("Montan")
                .setEmail("montana90@gmail.ru")
                .selectGenderFemale()
                .setMobile("0000000001")
                .setDateOfBirth("11", "November", "1996")
                .addSubject("English")
                .selectHobbyMusic()
                .uploadPicture("image.png")
                .setAddress("001")
                .setStateAndCity("Haryana", "Karnal")
                .submit();
        $(".modal-content").shouldBe(visible);

        new ResultModal()
                .checkField("Student Name", "Shak Montan")
                .checkField("Student Email", "montana90@gmail.ru")
                .checkField("Gender", "Female")
                .checkField("Mobile", "0000000001")
                .checkField("Date of Birth", "11 November,1996")
                .checkField("Subjects", "English")
                .checkField("Hobbies", "Music")
                .checkField("Picture", "image.png")
                .checkField("Address", "001")
                .checkStateAndCity("Haryana Karnal")
                .close();
    }

    @Test
    void negativeEmailTest() {
        new PracticeFormPage()
                .openPage()
                .removeBanners()
                .setFirstName("Bad")
                .setLastName("Email")
                .setEmail("invalid-email") // ← невалидный email (нет @)
                .selectGenderFemale()
                .setMobile("1234567890")
                .submit();

        // Проверяем, что модальное окно НЕ появилось (даже через 4 секунды)
        $(".modal-content").shouldNot(exist);
    }

   @Test
   void negativeMobileTooShortTest() {
       new PracticeFormPage()
               .openPage()
               .removeBanners()
               .setFirstName("Short")
               .setLastName("Number")
               .setEmail("short@num.com")
               .selectGenderFemale()
               .setMobile("123456789") // ← 9 цифр → невалидно
               .submit();

       // Проверяем, модалка НЕ появилась
       $(".modal-control").shouldNot(exist);

    }
}