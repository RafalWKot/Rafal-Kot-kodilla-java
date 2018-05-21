package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("car",text -> text.toUpperCase());
        poemBeautifier.beautify("girl",text -> "A->" + text +"<-A");
        poemBeautifier.beautify("beautiful",text -> {
            String result = text.charAt(0) + "_";
            for (int i = 1; i < text.length() -1 ; i++) {
                result = result + text.charAt(i) + "_";
            }
            result = result + text.charAt(text.length() - 1);
            return result;
        } );
        poemBeautifier.beautify("night",text -> {
            String result = String.valueOf(text.charAt(text.length() - 1));
            for (int i = text.length() - 2; i >= 0; i--) {
                result = result + text.charAt(i);
            }
            return result;
        });
    }
}
