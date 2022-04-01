package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.naming.CompositeName;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardOrderTest {
    @Test
    public void shouldSendForm() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $x("//input[@type='text']").val("Олег Тинькоф");
        $x("//input[@type='tel']").val("+79505647285");
        $x("//label[@data-test-id='agreement']").click();
        $x("//button[@type='button']").click();
        String actualText = $x("//p[@data-test-id='order-success']").getText().trim();
        String expectedText = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expectedText, actualText);
    }

}
