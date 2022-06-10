import java.util.Objects;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    @Override
    public String toString() {
        return "{" + this.first + ", " + this.second + "}";
    }

    public static void main(String[] args) {
        Pair<String, Integer> firstPair = new Pair<>("Hello World", 10);
        Pair<String, Integer> secondPair = new Pair<>("Bye World", 50);

        boolean equals = firstPair.equals(secondPair);

        String format = "First pair: %s and second pair: %s are equals: %s";

        System.out.println(String.format(format, firstPair, secondPair, equals));
    }
}