package tech.gustavomedina.url.util;

import java.util.Random;

public class RandomString {

    private static final int START_RANGE = 5;
    private static final int FINAL_RANGE = 10;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();


    public static String generate(){
        int length = START_RANGE + RANDOM.nextInt((FINAL_RANGE - START_RANGE) + 1);
        var sb = new StringBuilder(length);

        for(int i = 0; i < length; i++){
            int index = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }


}
