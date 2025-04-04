package Assingment;

import java.util.*;

public class FindVowels {
    
    public static int count(String sentence) {
        int count = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
      
        List<String> sentences = new ArrayList<>(Arrays.asList("Hello","We are from GIFT"));

        sentences.sort((a, b) -> Integer.compare(count(a), count(b)));

        System.out.println("Sentences sorted by vowel count:");
        for (int i = 0; i < sentences.size(); i++) {
            String sentence = sentences.get(i);
            System.out.println(sentence + " Vowels are " + count(sentence));
        }
    }
}
