package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LearningWordsPanel extends JPanel{

    private Language language;
    private TranslationsList translationsList;
    private JPanel translationsListPanel = MyTools.createVerticalPanel();
    private JLabel wordLabel = new JLabel();
    private ArrayList<TranslationLearningPanel> listOfLerningPanels = new ArrayList<TranslationLearningPanel>();

    public LearningWordsPanel(){

        language = new Russian();

        setLayout(new BorderLayout(0,5));

        JPanel boxC1 = MyTools.createVerticalPanel();
        add(boxC1);

        {
            Box boxC1R1 = Box.createHorizontalBox();
            boxC1R1.add(new ButtonChangeLanguage());
            boxC1R1.add(Box.createHorizontalGlue());
            boxC1.add(boxC1R1);

            Box boxC1R2 = Box.createHorizontalBox();
            boxC1R2.add(wordLabel);
            boxC1R2.add(Box.createHorizontalGlue());
            boxC1.add(boxC1R2);

            Box boxC1R3 = Box.createHorizontalBox();
            //MyTools.minimizeComponentHeight(translationsListPanel);
            boxC1R3.add(translationsListPanel);
            boxC1.add(boxC1R3);
            
            Box boxC1R4 = Box.createHorizontalBox();
            boxC1R4.add(new ButtonNextWord());
            boxC1R4.add(new ButtonCheckWord());
            boxC1R4.add(Box.createHorizontalGlue());
            boxC1.add(boxC1R4);

            boxC1.add(Box.createVerticalGlue());
        }


    }

    private void nextWord(){

        translationsList = WordsDB.getRandomTranslationList(language);
        wordLabel.setText(translationsList.getWord());
        translationsListPanel.removeAll();
        listOfLerningPanels.clear();

        for(int i = 0; i < translationsList.size(); i++){
            TranslationLearningPanel newTranslationLearningPanel = new TranslationLearningPanel(language);
            listOfLerningPanels.add(newTranslationLearningPanel);
            translationsListPanel.add(newTranslationLearningPanel);
        }

        translationsListPanel.repaint();
        translationsListPanel.revalidate();

    }

    public void check(){

        for(TranslationLearningPanel translPanel:listOfLerningPanels){
            Translation translation = translationsList.popEqual(translPanel);
            translPanel.check(translation);
        }
        for(TranslationLearningPanel translPanel:listOfLerningPanels){
            Translation translation = translationsList.popMostRelevant(translPanel);
            translPanel.check(translation);
        }

    }
    
    private class ButtonNextWord extends JButton {
        public ButtonNextWord(){
            setText("Next");
            addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    nextWord();
                }
            });
        }
    }

    private class ButtonCheckWord extends JButton {
        public ButtonCheckWord(){
            setText("Check");
            addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    check();
                }
            });
        }
    }

    private class ButtonChangeLanguage extends JButton {
        public ButtonChangeLanguage(){
            setIcon(language.getTranslationIcon());
            addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e) {
                    language = language.opposit();
                    setIcon(language.getTranslationIcon());
                }
            });
        }
    }
}
