package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.*;
import java.net.URL;
import java.util.HashMap;

public class English extends Language{
    @Override
    public Language opposit() {
        return new Russian();
    }

    @Override
    public Icon getTranslationIcon() {
        ClassLoader cldr = this.getClass().getClassLoader();
        URL imageUrl = cldr.getResource("icoEngToRus106x28.png");
        return new ImageIcon(imageUrl);
    }

    @Override
    public HashMap<Character, Character> getConvertCharacterMap() {
        return GlobalData.convertToEnglishMap;
    }

    @Override
    public boolean isEnglish() {
        return true;
    }

    @Override
    public boolean isRussian() {
        return false;
    }

    @Override
    public String toString() {
        return "English";
    }
    //тест
}
