package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.util.HashMap;

public class LanguageDocumentFilter extends DocumentFilter {

    HashMap <Character, Character> languageMap;

    public LanguageDocumentFilter(Language language){

        this.languageMap = language.getConvertCharacterMap();

    }

    public void insertString(FilterBypass fb, int offset, String string,
                             AttributeSet attr) throws BadLocationException {

        fb.insertString(offset, convertToLanguageLowerCase(string), attr);
    }

    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {
        
        fb.replace(offset, length, convertToLanguageLowerCase(text), attrs);
    }

    private String convertToLanguageLowerCase(String text) {

        text = text.toLowerCase();
        for (Character key : languageMap.keySet()){
            text = text.replace(key,languageMap.get(key));
        }

        return text;
    }

}
