package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class PracticeTest {
    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 60000;
        Configuration.headless = true;
    }

    @Test
    public void testFillTextBoxForm() {
        String userName = "Alex W";
        String email = "alex-w@mail.ru";
        String currentAddress = "132, My Street, Bigtown BG23 4YZ.";
        String permanentAddress = "456 White Finch St.North Augusta, SC 29860";

        open("/text-box");

        $("#userName").setValue(userName);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        $("#submit").click();

        assertThat($("#output").$("#email").getText()).isEqualTo("Email:" + email);
        assertThat($("#output").$("#currentAddress").getText()).isEqualTo("Current Address :" + currentAddress);
        assertThat($("#output").$("#permanentAddress").getText()).isEqualTo("Permananet Address :" + permanentAddress);
    }
}

