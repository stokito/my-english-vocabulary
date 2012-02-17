package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

public class FilteredTextField extends JTextField{

    public FilteredTextField(Language language){
        ((AbstractDocument) getDocument()).setDocumentFilter(new LanguageDocumentFilter(language));
    }

}
