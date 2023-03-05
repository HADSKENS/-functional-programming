import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        String sentence = "в б б а а а г г г г д д д д д д е е е е ё ж з и й";

        List<String> words = new ArrayList<>();
        for (String s : sentence.split(" ")) {
            words.add(s.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").toLowerCase());
            count++;
        }

        Map<String, Long> frequency = countDuplicates(words);
        List<Map.Entry<String, Long>> list =
                new LinkedList<Map.Entry<String, Long>>(frequency.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o2,
                               Map.Entry<String, Long> o1) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        System.out.println("Кол-во слов в тексте " + count);
        if (list.size() < 10) {
            System.out.println("Топ 10 использованных слов");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("Топ 10 использованных слов");
            for (int i = 0; i < 10; i++) {
                System.out.println(list.get(i));
            }
        }
    }


    public static Map<String, Long> countDuplicates(List<String> inputList) {
        return inputList.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
    }
}
