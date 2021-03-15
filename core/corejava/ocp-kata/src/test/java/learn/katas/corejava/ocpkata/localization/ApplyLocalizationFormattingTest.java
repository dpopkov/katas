package learn.katas.corejava.ocpkata.localization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class ApplyLocalizationFormattingTest {

    private final double price = 3.14;
    private final double discount = 0.2;
    private final LocalDateTime validBefore = LocalDateTime.of(2021, 3, 15, 20, 43);

    @Test
    void usePatternAndFormatMessageForUsEnglish() {
        final Locale locale = Locale.US;
        // todo: initialize resource bundle for messages and get offer and date time patterns
        ResourceBundle bundle = null;
        String offerPattern = null;
        String dateTimePattern = null;

        final String product = "Tea";

        // todo: initialize formatters
        NumberFormat currencyFormat = null;
        NumberFormat percentFormat = null;
        DateTimeFormatter dateTimeFormatter = null;

        // todo: format parameters and apply for formatting result message
        String formattedPrice = null;
        String formattedDiscount = null;
        String formattedDate = null;
        String resultMessage = null;
        final String expected = "Tea, price: $3.14, (applied 20% discount), valid until Monday, 15 of March 2021 at 20:43";
        Assertions.assertEquals(expected, resultMessage);
    }

    @Test
    void usePatternAndFormatMessageForRu() {
        final Locale locale = new Locale("ru", "RU");
        // todo: initialize resource bundle for messages and get offer and date time patterns
        ResourceBundle bundle = null;
        String offerPattern = null;
        String dateTimePattern = null;

        final String product = "Чай";

        // todo: initialize formatters
        NumberFormat currencyFormat = null;
        NumberFormat percentFormat = null;
        DateTimeFormatter dateTimeFormatter = null;

        // todo: format parameters and apply for formatting result message
        String formattedPrice = null;
        String formattedDiscount = null;
        String formattedDate = null;
        String resultMessage = null;
        final String nonBreakingSpace = "\u00A0";
        final String expected = "Чай, цена: 3,14 ₽, (с учетом 20" + nonBreakingSpace + "% скидки), "
                + "действительно до 15 марта 2021, понедельник в 20:43";
        Assertions.assertEquals(expected, resultMessage);
    }
}
