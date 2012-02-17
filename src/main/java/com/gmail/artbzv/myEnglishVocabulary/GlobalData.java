package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.*;
import java.util.HashMap;

public class GlobalData {
    public static JFrame mainFrame;
    public static HashMap <Character, Character> convertToEnglishMap = new HashMap();
    public static HashMap <Character, Character> convertToRussianMap = new HashMap();
    public static int translationLabelHeight = 10;
    public static int translationLabelWidth = 100;

    public static void initialize() {
        WordsDB.initConnection();
        initConvertToEnglishMap();
        initConvertToRussianMap();
    }

    private static void initConvertToEnglishMap() {
        convertToEnglishMap = new HashMap <Character, Character>();
        convertToEnglishMap.put('й','q'); 
    }

    private static void initConvertToRussianMap() {
        convertToRussianMap = new HashMap <Character, Character>();
        convertToRussianMap.put('q','й');
    }


    public static int getStudiedDelimiter() {
        return 3;
    }
}
