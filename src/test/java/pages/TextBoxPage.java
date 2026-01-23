package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressTextarea = $("#currentAddress"),
            permanentAddressTextarea = $("#permanentAddress"),
            submitButton = $("#submit");

    public TextBoxPage  openPage(String s){
        openPage("/text-box");
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
        $("#currentAddress").shouldHave(text("Current Address :" + currentAddr));
        $("#permanentAddress").shouldHave(text("Permananet Address :" + permAddr));
        return this;
    }
}