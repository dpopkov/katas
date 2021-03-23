package learn.katas.corejava.streams;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product {

    private String name;
    private double price;
    private double discount;
    private LocalDate bestBefore;
}
