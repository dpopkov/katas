package learn.katas.corejava.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Order {

    private final List<Product> items;

    private Order(List<Product> items) {
        this.items = items;
    }

    public Stream<Product> items() {
        return items.stream();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final List<Product> items = new ArrayList<>();

        public Builder item(Product product) {
            items.add(product);
            return this;
        }

        public Order build() {
            return new Order(items);
        }
    }
}
