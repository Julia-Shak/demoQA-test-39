package components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTable {
    private final SelenideElement table = $(".table-responsive");

    public ResultTable checkField(String label, String expectedValue) {
        table.$(byText(label)).closest("tr").shouldHave(text(expectedValue));
        return this;
    }

    public ResultTable checkStateAndCity(String expectedValue) {
        table.$(byText("State and City")).closest("tr").shouldHave(text(expectedValue));
        return this;
    }

    public void close() {
        $("#closeLargeModal").click();
    }
}