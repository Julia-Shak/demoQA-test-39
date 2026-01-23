package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressTextarea = $("#currentAddress"),
            permanentAddressTextarea = $("#permanentAddress"),
            submitButton = $("#submit");

    public TextBoxPage  openPage() {

        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;

    }

    public TextBoxPage setFullName(String name) {
        fullNameInput.setValue(name);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String address) {
        currentAddressTextarea.setValue(address);
        return this;
    }

    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressTextarea.setValue(address);
        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }

    public TextBoxPage checkOutput(String fullName, String email, String currentAddr, String permAddr) {
        $("#name").shouldHave(text("Name:" + fullName));
        $("#email").shouldHave(text("Email:" + email));

        // Проверяем АТРИБУТ value, а не текст
        $("#currentAddress").shouldHave(attribute("value", currentAddr));
        $("#permanentAddress").shouldHave(attribute("value", permAddr));

        return this;
    }
}