package learn.katas.corejava.fp.lambda1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongBinaryOperator;
import java.util.stream.LongStream;

/*
DONE:
Write a lambda expression that accepts two long arguments as a range borders
and calculates (returns) production of all numbers in this range (inclusively).
It's guaranteed that 0 <= left border <= right border.
if left border == right border then the result is any border.
*/
@SuppressWarnings("StatementWithEmptyBody")
public class BinaryOperations {

    // DONE: Implement product of all numbers in the specified range using loop in 5 lines
    private static final LongBinaryOperator PRODUCT_IN_RANGE_LOOPED_1 = (a, b) -> {
        long r = 1L;
        for (long v = a; v <= b; v++) {
            r *= v;
        }
        return r;
    };

    // DONE: Implement product of all numbers in the specified range using loop in 3 lines
    private static final LongBinaryOperator PRODUCT_IN_RANGE_LOOPED_2 = (a, b) -> {
        long r = 1L;
        for (long v = a; v <= b; r *= v++);
        return r;
    };

    // DONE: Implement product of all numbers in the specified range using loop in 2 lines
    private static final LongBinaryOperator PRODUCT_IN_RANGE_LOOPED_3 = (a, b) -> {
        for (long v = a + 1; v <= b; a *= v++);
        return a;
    };

    // DONE: Implement product of all numbers in the specified range using stream in 1 line
    private static final LongBinaryOperator PRODUCT_IN_RANGE_STREAMED =
            (a, b) -> LongStream.rangeClosed(a, b).reduce((x, y) -> x * y).orElse(a);

    public static BinaryOperations product() {
        return new BinaryOperations(List.of(
                PRODUCT_IN_RANGE_LOOPED_1,
                PRODUCT_IN_RANGE_LOOPED_2,
                PRODUCT_IN_RANGE_LOOPED_3,
                PRODUCT_IN_RANGE_STREAMED
        ));
    }

    private final List<LongBinaryOperator> operators;

    private BinaryOperations(List<LongBinaryOperator> operators) {
        this.operators = operators;
    }

    public List<Long> calculate(long a, long b) {
        List<Long> result = new ArrayList<>();
        operators.forEach(op -> result.add(op.applyAsLong(a, b)));
        return result;
    }
}
