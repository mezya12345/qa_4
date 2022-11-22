package homeTests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests extends TestBase {

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Masha");
        $("#lastName").setValue("Mezentseva");
        $("#userEmail").setValue("masha@masha.com");
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("5");
        $(".react-datepicker__year-select").selectOptionByValue("1988");
        $(".react-datepicker__day--011").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/orange.jpg"));
        $("#currentAddress").setValue("Novosibirsk, street X");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldBe(Condition.visible);
        $(".table-responsive tr:nth-child(1) td:nth-child(2)").shouldHave(text("Masha Mezentseva"));
        $(".table-responsive tr:nth-child(2) td:nth-child(2)").shouldHave(text("masha@masha.com"));
        $(".table-responsive tr:nth-child(3) td:nth-child(2)").shouldHave(text("Female"));
        $(".table-responsive tr:nth-child(4) td:nth-child(2)").shouldHave(text("1234567890"));
        $(".table-responsive tr:nth-child(5) td:nth-child(2)").shouldHave(text("11 June,1988"));
        $(".table-responsive tr:nth-child(6) td:nth-child(2)").shouldHave(text("Chemistry"));
        $(".table-responsive tr:nth-child(7) td:nth-child(2)").shouldHave(text("Reading"));
        $(".table-responsive tr:nth-child(8) td:nth-child(2)").shouldHave(text("orange.jpg"));
        $(".table-responsive tr:nth-child(9) td:nth-child(2)").shouldHave(text("Novosibirsk, street X"));
        $(".table-responsive tr:nth-child(10) td:nth-child(2)").shouldHave(text("Haryana Karnal"));
        $("#closeLargeModal").click();
    }
}
