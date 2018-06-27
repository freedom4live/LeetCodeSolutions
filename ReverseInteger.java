import java.util.stream.Stream;

public class ReverseInteger {
    public static void main(String[] args) {
        int result = reverse(123);
    }

    public static int reverse(int x) {
        int buff = 0;
        int result = 0;
        int multiplier = 10;
        boolean isFirst = true;
        boolean isNegative = false;

        if (x < 0) {
            x *= -1;
            isNegative = true;
        }

        while (x > 0) {
            if (!isFirst) {
                buff *= multiplier;
            }
            int subResult = x % multiplier;
            buff += subResult;
            x -= subResult;
            x = x / multiplier;

            if (!isFirst && buff - result * multiplier != subResult) return 0;
            isFirst = false;

            if (result <= buff) {
                result = buff;
            } else {
                return 0;
            }
        }

        if (isNegative) result *= -1;
        return result;
    }
}
