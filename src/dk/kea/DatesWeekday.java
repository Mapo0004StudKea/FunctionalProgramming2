package dk.kea;

import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DatesWeekday {

    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(2020,9,7);
        Stream<LocalDate> tenDates = IntStream.range(1,10).mapToObj(i -> birthday.plusYears(i));
        //tenDates.forEach(System.out::println);
        Stream<String> dateStream = tenDates.map(date -> "Year=" + date.getYear() + " Weekday=" + date.getDayOfWeek());
        dateStream.forEach(System.out::println);

        LocalDate skuddag = LocalDate.of(2020, 2, 29);
        Stream<LocalDate> skudDates = IntStream.range(1,10).mapToObj(i -> skuddag.plusYears(i));
        skudDates.forEach(System.out::println);

        Predicate<Integer> leapYear = year -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        var obj = IntStream
                .iterate(LocalDate.now().getYear(), year -> year + 1)
                .mapToObj(i -> (Integer) i)
                .filter(leapYear)
                .limit(4);
        obj.forEach(System.out::println);


    }
}
