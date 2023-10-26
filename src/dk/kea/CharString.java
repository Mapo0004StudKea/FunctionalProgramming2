package dk.kea;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CharString {
    public static void main(String[] args) {
        String vowels = "aeiouyæøå";
        Predicate<Character> isVowel = (p) -> vowels.indexOf(p) != -1;

        List<Character> lst = Arrays.asList('a', 'b', 'c', 'd', 'e');
        List<Character> vowList = lst.stream().filter(isVowel).collect(Collectors.toList());
        vowList.forEach(System.out::println);

        long vokalCount = "Hej hvor er du".chars().mapToObj(c -> (char) c).filter(isVowel).count();
        System.out.println("vokalCount: " + vokalCount);

        List<String> strings = List.of("hej", "hvor", "er", "du henne");
        var obj = strings.stream().flatMapToInt(s -> s.chars());
        obj.forEach(a -> System.out.println((char) a));

        long lstCount = strings.stream().flatMapToInt(s -> s.chars()).mapToObj(c -> (char) c).filter(isVowel).count();
        System.out.println("vowel count: " + lstCount);
    }
}
