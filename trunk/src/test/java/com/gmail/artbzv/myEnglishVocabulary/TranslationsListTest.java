package com.gmail.artbzv.myEnglishVocabulary;

import junit.framework.TestCase;

public class TranslationsListTest extends TestCase {

    public void testPopEqual() throws Exception {
        TranslationsList translationsList = new TranslationsList();
        addTranslationByWord(translationsList, "амои");
        addTranslationByWord(translationsList, "мои");
        TranslationLearningPanel translationLearningPanel = new TranslationLearningPanel(new English());
        translationLearningPanel.setText("мои");
        Translation translation = translationsList.popEqual(translationLearningPanel);
        assertEquals(translation.getTranslation(), "мои");
    }

    private void addTranslationByWord(TranslationsList translationsList, String word) {
        TranslationData translationData = new TranslationData();
        translationData.russianWord = word;
        translationsList.add(new Translation(translationData, new English()));
    }
}
