package dk.kea;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class DemoDat23C {
    public static void main(String[] args) {
        //liste af tal
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        //map square
        List<Integer> squareNumbers = numbers.stream()
                .map((x) -> x * x)
                .toList();
        System.out.println("Square: " + squareNumbers);

        Integer sum = numbers.stream()
                .reduce(0, (accumulator, increment) -> accumulator + increment);
        System.out.println("Sum: " + sum);

        Integer product = numbers.stream()
                .reduce(1, (accumulator, increment) -> {
                    System.out.println(accumulator);
                    return accumulator * increment;}
                );
        System.out.println("Product: " + product);

        //liste af strings
        List<String> names = Arrays.asList("stream", "map", "filter", "toList");

        //filter
        List<String> result = names.stream()
                .filter(s -> s.startsWith("s"))
                .toList();
        System.out.println("Result filter: " + result);

        //sorted og forEach
        names.stream()
                .sorted()
                .forEach(s -> System.out.println(s));


    }


}
