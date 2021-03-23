package learn.katas.corejava.streams;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamsUsage1Solutions {

    private final LocalDate date = LocalDate.of(2021, 3, 23);
    private final List<Product> products = List.of(
            Product.builder().name("P1").price(10).bestBefore(date).build(),
            Product.builder().name("P23").price(11).bestBefore(date).build(),
            Product.builder().name("P345").price(12).bestBefore(date).build()
    );

    @Test
    void useFilter() {
        // Implement: Filter products with price > 10 and set discount 0.2
        List<Product> result = products.stream()
                .filter(p -> p.getPrice() > 10)
                .peek(p -> p.setDiscount(0.2))
                .collect(Collectors.toList());

        assertEquals(2, result.size());
        Predicate<Product> matchByDiscount = p -> p.getDiscount() == 0.2;
        boolean allMatch = result.stream().allMatch(matchByDiscount);
        assertTrue(allMatch);
    }

    @Test
    void useMap() {
        // Implement: Get bestBefore dates and add 3 days
        List<LocalDate> result = products.stream()
                .map(Product::getBestBefore)
                .map(d -> d.plusDays(3))
                .collect(Collectors.toList());

        Predicate<LocalDate> matchByDay = d -> d.getDayOfMonth() == 26;
        boolean allMatch = result.stream().allMatch(matchByDay);
        assertTrue(allMatch);
    }

    @Test
    void usePrimitiveStream() {
        // Implement: get sum of name lengths
        int totalLength = products.stream()
                .map(Product::getName)
                .mapToInt(String::length)
                .sum();
        assertEquals(9, totalLength);
    }

    @Test
    void useBiArgumentInterface() {
        final Map<Product, Integer> itemsQuantities = new HashMap<>();
        itemsQuantities.put(products.get(0), 10);
        itemsQuantities.put(products.get(1), 20);
        itemsQuantities.put(products.get(2), 30);

        // Implement: calculate total price of itemsQuantities
        DoubleAccumulator accumulator = new DoubleAccumulator(Double::sum, 0.0);
        itemsQuantities.forEach((p, q) -> accumulator.accumulate(p.getPrice() * q));
        double totalPrice = accumulator.get(); // 10*10 + 11*20 + 12*30 = 680

        assertEquals(680.0, totalPrice);
    }

    @Test
    void useCombinedFilters() {
        // Implement: filter products with name shorter than 3 or price greater than 11
        final Predicate<Product> byLength = p -> p.getName().length() < 3;
        final Predicate<Product> byPrice = p -> p.getPrice() > 11;
        List<Product> result = products.stream()
                .filter(byLength.or(byPrice))
                .collect(Collectors.toList());
        assertEquals(2, result.size());
    }

    @Test
    void useCombinedMapping() {
        // Implement: get names and trim the first letter 'P'
        Function<Product, String> toName = Product::getName;
        UnaryOperator<String> trimFirstLetter = s -> s.substring(1);

        List<String> result = products.stream()
                .map(toName.andThen(trimFirstLetter))
                .collect(Collectors.toList());

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
        final Predicate<Product> onlyTea = p -> p.getName().startsWith("Tea");
        double totalPrice = orders.stream()
                .flatMap(Order::items)
                .filter(onlyTea)
                .mapToDouble(Product::getPrice)
                .sum();

        assertEquals(60, totalPrice);
    }
}
