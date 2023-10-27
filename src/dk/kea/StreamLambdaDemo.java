package dk.kea;
import java.util.List;
import java.util.Arrays;

public class StreamLambdaDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using a Stream and Lambda Expression to perform operations on the list
        System.out.println("Original List: " + numbers);

        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(x -> x % 2 == 0).toList();
                //.collect(java.util.stream.Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);

        // Square each number
        List<Integer> squaredNumbers = numbers.stream()
                .map(x -> x * x)
                .collect(java.util.stream.Collectors.toList());
        System.out.println("Squared Numbers: " + squaredNumbers);

        // Sum of all elements
        int sum = numbers.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println("Sum of all numbers: " + sum);

        // Find the maximum number
        int max = numbers.stream()
                //.max((x, y) -> Integer.compare(x, y))
                .max(Integer::compare)
                .orElse(0);
        System.out.println("Maximum Number: " + max);

        numbers.stream()
                //.forEach(x -> System.out.println(x));
                .forEach(System.out::println);

    }
}


