package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.*;
import java.util.HashMap;

public abstract class Language {

    public abstract Language opposit();

    public abstract Icon getTranslationIcon();

    public abstract HashMap<Character, Character> getConvertCharacterMap();

    public abstract boolean isEnglish();

    public abstract boolean isRussian();

    public abstract String toString();

}
