package components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ResultModal {
    private final SelenideElement modalTable = $(".table-responsive");
    public ResultModal checkField(String label, String expectedValue) {
        modalTable.$(byText(label)).closest("tr").shouldHave(text(expectedValue));
        return this;
    }
    public ResultModal checkStateAndCity(String stateAndCity) {
        modalTable.$(byText("State and City")).closest("tr").shouldHave(text(stateAndCity));
        return this;
    }
    public void close() {
        $("#closeLargeModal").click();
    }
}