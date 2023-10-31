package dk.kea;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        Consumer<String> toUpper = x -> System.out.println(x.toUpperCase());
        toUpper.accept("viggo");

        Consumer<Long> square = t -> System.out.println(t*t);
        square.accept(50L);

        // opgave 3 - brug af metode
        List<String> lstStr = Arrays.asList("hej", "du", "der");
        forEachString(lstStr, toUpper);
        forEach(lstStr, toUpper);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> out = (Integer x) -> System.out.println(x);
        forEach(list, out);

        list.forEach(out);

        ZeroOneTwoArgument.TwoArgument twoPlus = (x, y) -> x + y;
        int ss = sumTwoArgFunction(list, twoPlus);
        System.out.println(ss);

        ZeroOneTwoArgument.TwoArgument twoMult = (x, y) -> x * y;
        ss = sumTwoArgFunction(list, twoMult);
        System.out.println(ss);

        //Opret en liste af dollarsedler
        List<Integer> dollarSedler = Arrays.asList(1,5,10);
        int pengedk = valutaomregner(dollarSedler, twoMult, 6);
        System.out.println("du har dk=" + pengedk);

        // opgave 4 brug
        //Decimal dollar
        List<Double> dollars = Arrays.asList(1.0, 5.0, 10.0);
        double pengedkdec = valutaomregnerG(dollars, (amount,kurs) -> (amount*kurs) , 6.55);
        System.out.println("du har dk=" + pengedkdec);
    }

    // opgave 2
    static void forEachString(List<String> listOfStrings, Consumer<String> consumer){
        for (String s:listOfStrings){
            consumer.accept(s);
        }
    }

    // opgave 3
    static <T> void forEach(List<T> lst, Consumer<T> consumer) {
        for (T t:lst){
            consumer.accept(t);
        }
    }

    static int sumTwoArgFunction(List<Integer> list, ZeroOneTwoArgument.TwoArgument two){
        int sum = 0;
        for (int t : list) {
            sum += two.myFunc(t, t);
        }
        return sum;
    }

    static int valutaomregner(List<Integer> list, ZeroOneTwoArgument.TwoArgument two, int kurs) {
        int sum = 0;
        for (int t : list) {
            sum += two.myFunc(t, kurs);
        }
        return sum;
    }

    // opgave 4
    public interface TwoArgumentG<T> {
        public T myFunc(T a, T b);
    }
    static Double valutaomregnerG(List<Double> list, TwoArgumentG<Double> two, Double kurs) {
        Double sum = 0.0;
        for (Double d : list) {
            sum += two.myFunc(d, kurs);
        }
        return sum;
    }

}
