package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.*;
import java.awt.*;

public class TranslationLearningPanel extends JPanel implements Comparable{

    private FilteredTextField textField;
    private JLabel answerLabel = new JLabel();

    public TranslationLearningPanel(Language language){
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        JPanel fieldLabelPanel = new JPanel(new GridLayout(1,0,0,10));
        add(fieldLabelPanel);
        textField = new FilteredTextField(language);
        MyTools.minimizeComponentHeight(textField);
        answerLabel.setMaximumSize(textField.getMaximumSize());
        fieldLabelPanel.add(textField);
        fieldLabelPanel.add(answerLabel);

        setMaximumSize(textField.getMaximumSize());
    }

    public void check(Translation translation) {
        if(translation == null){
            return;
        }                  
        if(translation.getTranslation().equals(textField.getText())){
            answerLabel.setText("OK");
            answerLabel.setForeground(Color.GREEN);
            translation.correctAnswer();
        } else {
            answerLabel.setText(translation.getTranslation());
            answerLabel.setForeground(Color.RED);
            translation.wrongAnswer();
        }
        translation.updateToDB();
    }

    @Override
    public String toString(){
        return textField.getText();
    }

    @Override
    public int compareTo(Object object) {
        return textField.getText().compareTo(object.toString());
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof Translation){
            return textField.getText().equals(((Translation) object).getTranslation());
        }
        return super.equals(object);
    }

    public void setText(String text){
        this.textField.setText(text);
    }

}
