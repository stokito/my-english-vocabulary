package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.*;
import java.net.URL;
import java.util.HashMap;

public class Russian extends Language{
     @Override
    public Language opposit() {
        return new English();
    }

    @Override
    public Icon getTranslationIcon() {
        ClassLoader cldr = this.getClass().getClassLoader();
        URL imageUrl = cldr.getResource("icoRusToEng106x28.png");
        return new ImageIcon(imageUrl);
    }

    @Override
    public HashMap<Character, Character> getConvertCharacterMap() {
        return GlobalData.convertToRussianMap;
    }

    @Override
    public boolean isEnglish() {
        return false;
    }

    @Override
    public boolean isRussian() {
        return true;
    }

    @Override
    public String toString() {
        return "Russian";
    }
}
