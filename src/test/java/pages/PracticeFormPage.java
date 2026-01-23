package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    // Поля формы
    private final SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genderFemale = $("#genterWrapper").$(byText("Female")),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesMusic = $("#hobbiesWrapper").$(byText("Music")),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit");

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstName(String name) {
        firstName.setValue(name);
        return this;
    }

    public PracticeFormPage setLastName(String name) {
        lastName.setValue(name);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        userEmail.setValue(email);
        return this;
    }

    public PracticeFormPage selectGenderFemale() {
        genderFemale.click();
        return this;
    }

    public PracticeFormPage setMobile(String number) {
        userNumber.setValue(number);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $$(".react-datepicker__day").findBy(text(day)).click();
        return this;
    }
    public PracticeFormPage addSubject(String subject) {
        subjectsInput.click();
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage selectHobbyMusic() {
        hobbiesMusic.click();
        return this;
    }

    public PracticeFormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public PracticeFormPage setAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public PracticeFormPage setStateAndCity(String stateName, String cityName) {
        state.click();
        $(byText(stateName)).click();
        city.click();
        $(byText(cityName)).click();
        return this;
    }

    public void submit() {
        submitButton.click();
    }
}
