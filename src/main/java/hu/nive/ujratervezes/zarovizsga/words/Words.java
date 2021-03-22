package hu.nive.ujratervezes.zarovizsga.words;

import java.util.List;

public class Words {

    public static final List<Character> DIGITS = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');


    public boolean hasMoreDigits(String s) {
        int digitCounter = 0;
        int otherCharCounter = 0;
        for (char c : s.toCharArray()) {
            if (DIGITS.contains(c)) {
                digitCounter++;
            } else {
                otherCharCounter++;
            }
        }
        return digitCounter > otherCharCounter;
    }


}

/*
    A Words osztálynak legyen egy boolean hasMoreDigits(String s) metódusa, mely visszaadja,
        hogy a szóban több számjegy van-e, mint többi karakter. Azaz a aa111 szóban három számjegy
        van és kettő többi, azaz true értéket ad vissza.*/
