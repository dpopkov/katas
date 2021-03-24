package learn.katas.corejava.streams;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

public class StreamsUsage1 {

    private final LocalDate date = LocalDate.of(2021, 3, 23);
    private final List<Product> products = List.of(
            Product.builder().name("P1").price(10).bestBefore(date).build(),
            Product.builder().name("P23").price(11).bestBefore(date).build(),
            Product.builder().name("P345").price(12).bestBefore(date).build()
    );

    @Test
    void useFilter() {
        // Implement: Filter products with price > 10 and set discount 0.2
        List<Product> result = null;

        assertEquals(2, result.size());
        Predicate<Product> matchByDiscount = p -> p.getDiscount() == 0.2;
        boolean allMatch = result.stream().allMatch(matchByDiscount);
        assertTrue(allMatch);
    }

    @Test
    void useMap() {
        // Implement: Get bestBefore dates and add 3 days
        List<LocalDate> result = null;

        Predicate<LocalDate> matchByDay = d -> d.getDayOfMonth() == 26;
        boolean allMatch = result.stream().allMatch(matchByDay);
        assertTrue(allMatch);
    }

    @Test
    void usePrimitiveStream() {
        // Implement: get sum of name lengths
        int totalLength = -1;

        assertEquals(9, totalLength);
    }

    @Test
    void useBiArgumentInterface() {
        final Map<Product, Integer> itemsQuantities = new HashMap<>();
        itemsQuantities.put(products.get(0), 10);
        itemsQuantities.put(products.get(1), 20);
        itemsQuantities.put(products.get(2), 30);

        // Implement: calculate total price of itemsQuantities
        double totalPrice = -1; // 10*10 + 11*20 + 12*30 = 680

        assertEquals(680.0, totalPrice);
    }

    @Test
    void useCombinedFilters() {
        // Implement: filter products with name shorter than 3 or price greater than 11
        final Predicate<Product> byLength = p -> p.getName().length() < 3;
        final Predicate<Product> byPrice = p -> p.getPrice() > 11;
        List<Product> result = null;;

        assertEquals(2, result.size());
    }

    @Test
    void useCombinedMapping() {
        // Implement: get names and trim the first letter 'P'
        Function<Product, String> toName = null;
        UnaryOperator<String> trimFirstLetter = null;
        List<String> result = null;;

        boolean noneMatch = result.stream().noneMatch(n -> n.startsWith("P"));
        assertTrue(noneMatch);
    }

    @Test
    void useFlatMap() {
        List<Order> orders = List.of(
                Order.builder()
                        .item(Product.builder().name("Tea1").price(10).build())
                        .item(Product.builder().name("Coffee1").price(11).build())
                        .item(Product.builder().name("Tea11").price(20).build())
                        .build(),
                Order.builder()
                        .item(Product.builder().name("Coffee2").price(10).build())
                        .item(Product.builder().name("Tea2").price(30).build())
                        .build()
        );

        // Implement: get Tea products and calculate total price
        final Predicate<Product> onlyTea = null;
        double totalPrice = -1;

        assertEquals(60, totalPrice);
    }

    @Test
    void useIntermediateStreamOperations1() {
        String[] data = {"A", "C", "B", "D", "B", "D"};
        // Implement: remove duplicates, sort, make lower case and concatenate strings except 1st and 2nd
        String result = null;

        assertEquals("cd", result);
    }

    @Test
    void useIntermediateStreamOperations2() {
        String[] data = {"B", "C", "A", "E", "D", "F"};
        // Implement: include elements starting with C and before D, and get no more than 2 elements
        String result = null;

        assertEquals("CA", result);
    }

    @Test
    void useShortCircuitTerminalOperations() {
        final String[] values = {"RED", "GREEN", "BLUE"};
        // Implement: test that all are GREEN
        boolean allGreen = false;
        // Implement: test that any one is GREEN
        boolean anyGreen = false;
        // Implement: test no one is GREEN
        boolean noneGreen = false;
        // Implement: find any element
        Optional<String> any = null;
        // Implement: find first element
        Optional<String> first = null;

        assertFalse(allGreen);
        assertTrue(anyGreen);
        assertFalse(noneGreen);
        assertEquals("RED", any.get());
        assertEquals("RED", first.get());
    }

    @Test
    void useReduce() {
        // Implement: concatenate names of the products
        String names = null; // products.stream()
        assertEquals("P1P23P345", names);

        // Implement: concatenate names of the products starting with Prefix and divided with '-' symbol
        String namesPrefixed = null; // products.stream()
        assertEquals("Prefix-P1-P23-P345", namesPrefixed);
    }
}
