package com.kodilla.stream;


import com.kodilla.stream.beautifier.PoemBeautifier;



public class StreamMain {

    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Decorate",(text) -> text = "ABC" + text + "ABC");
        poemBeautifier.beautify("Decorate",(text) -> text += text + text);
        poemBeautifier.beautify("Decorate",(text) -> text.toUpperCase());
        poemBeautifier.beautify("Decorate",(text) -> {
            String resultText = "";
            String singleText = "";
            for (int i=0; i<text.length(); i++) {
                singleText = text.substring(i,i+1);
                resultText += singleText + singleText;
            }
            return resultText.toUpperCase();
        });
    }
}
