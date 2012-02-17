package com.gmail.artbzv.myEnglishVocabulary;

public class Main {

    public static void main(String[] args) {
        GlobalData.initialize();
        new MainFrame();
        Speaker.say("Wellcome to english vocabulary");
    }

}
