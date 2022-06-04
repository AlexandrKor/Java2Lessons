package HomeWork3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task1 {

    private static final String[] INPUT_DATA = {
            "итерация",
            "массив",
            "Java","Java",
            "Метод",
            "переменная",
            "цикл","цикл","цикл",
            "Метод",
            "переменная",
            "баги","Java","баги",
            "Java"
    };

    public static void main(String[] args) {
        Map<String, Integer> individWords = new LinkedHashMap<>();
        for (String word : INPUT_DATA){
            Integer individual = individWords.get(word);
            if (individual == null){
                individual = 0;
            }
            individWords.put(word, individual + 1);
        }

        for (Map.Entry<String, Integer> entry : individWords.entrySet()) {
            System.out.printf("Слово %s - %d раз %n", entry.getKey(), entry.getValue());
        }
    }
}
