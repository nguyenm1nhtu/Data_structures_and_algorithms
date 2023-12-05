package Bai5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P28 {

    public static void main(String[] args) {
        List<String> sentences = new ArrayList<>();
        for (int i = 0; i < 92; i++) {
            sentences.add("I will never spam my friends again.");
        }

        String typo1 = " never spam my fr again.";
        String typo2 = "I will never spam again.";
        String typo3 = "I will never spam my frien again";
        String typo4 = "I will never sam my friends agn.";
        String typo5 = "I will never spam my riends again.";
        String typo6 = "I will ever pam my fiends again.";
        String typo7 = "I ill ever spam my fr again.";
        String typo8 = " ill ever pam y friends gain.";
        String[] typos = {typo1,typo2,typo3,typo4,typo5,typo6,typo7,typo8};
        for (int i = 0; i < 8; i++) {
            sentences.add(typos[i]);
        }

        Collections.shuffle(sentences);
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%d) %s\n", i, sentences.get(i-1));
        }
    }


}
