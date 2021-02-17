package learn.katas.start;

public class FizzBuzz {
    /**
     * This method accepts the numbers from 1 to 100 and returns them as a String.
     * But for multiples of three it returns the String "Fizz" instead of the number and for the
     * multiples of five it returns the String "Buzz". For numbers which are multiples of both
     * three and five the method returns the String "FizzBuzz".
     *
     * @param number a number from 1 to 100
     * @return a String representing the number or the Strings "Fizz", "Buzz" and "FizzBuzz"
     *         as described above
     * @throws IllegalArgumentException if the number is not in the 1-100 range.
     */
    public String toFizzBuzzString(int number) {
        if (number < 1 || 100 < number) {
            throw new IllegalArgumentException("Number is not in the range 1-100: " + number);
        }
        if (number % 3 == 0) {
            if (number % 5 == 0) {
                return "FizzBuzz";
            }
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
