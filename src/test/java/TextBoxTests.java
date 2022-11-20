import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String userName = "Masha";

        open("/text-box");

        $("#userName").setValue(userName);
        $("#userEmail").setValue("Masha@masha.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Other address 1");
        $("#submit").click();

        $("#output").shouldBe(Condition.visible);
        $("#output #name").shouldHave(text(userName));
        $("#output #email").shouldHave(text("Masha@masha.com"));
        $("#output #currentAddress").shouldHave(text("Some address 1"));
        $("#output #permanentAddress").shouldHave(text("Other address 1"));
    }
}
