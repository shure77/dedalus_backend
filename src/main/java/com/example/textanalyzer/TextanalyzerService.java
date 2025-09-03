package com.example.textanalyzer;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class TextanalyzerService {

    public List<LetterResult> analyzeVowels(String input) {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("A", 0);
        result.put("E", 0);
        result.put("I", 0);
        result.put("O", 0);
        result.put("U", 0);

        char[] chars = input.toUpperCase().toCharArray();

        System.out.println(chars);

        for (char c : chars) {
            if (result.containsKey(String.valueOf(c))) {
                result.put(String.valueOf(c), result.get(String.valueOf(c)) + 1);
            }
        }

        List<LetterResult> letterResultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            letterResultList.add(new LetterResult(entry.getKey(), entry.getValue()));
        }

        return letterResultList;
    }

    public List<LetterResult> analyzeConsonants(String input) {
        Map<String, Integer> result = new HashMap<>();
        Set<String> vowels = new HashSet<>(Arrays.asList("A", "E", "I", "O", "U"));

        char[] chars = input.toUpperCase().toCharArray();
        for (char c : chars) {
            String letter = String.valueOf(c);
            if (!vowels.contains(letter) && letter.matches("[A-Z]")) {
                result.put(letter, result.getOrDefault(letter, 0) + 1);
            }
        }

        List<LetterResult> letterResultList = result.entrySet().stream()
                .map(entry -> new LetterResult(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(lr -> lr.letter))
                .collect(Collectors.toList());

        return letterResultList;
    }

        public List<LetterResult> toSortedList (Map < String, Integer > resultMap){
            return resultMap.entrySet()
                    .stream()
                    .map(entry -> new LetterResult(entry.getKey(), entry.getValue()))
                    .sorted(Comparator.comparing(o -> o.letter))
                    .collect(Collectors.toList());
        }
}
