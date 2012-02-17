package com.gmail.artbzv.myEnglishVocabulary;

import java.util.*;

public class TranslationsList{

    private ArrayList<Translation> translationsList = new ArrayList<Translation>();
    private String word;

    public void add(Translation translation){
        if(word == null){
            word = translation.getWord();
        } else if( ! translation.getWord().equals(word)){
            throw(new IllegalArgumentException());
        }
        translationsList.add(translation);
    }

    public int size() {
        return translationsList.size();
    }

    public String getWord() {
        return word;
    }

    public void sort(){
        Collections.sort(translationsList);
    }


    public Translation get(int index) {
        return translationsList.get(index);
    }

    public Translation popMostRelevant(TranslationLearningPanel translPanel) {
        Translation mostRelevantTranslation  = Collections.max(translationsList, new RelevancyComparator(translPanel));
        translationsList.remove(mostRelevantTranslation);
        return mostRelevantTranslation;
    }

    public Translation popEqual(TranslationLearningPanel translPanel) {
        Translation equalTranslation = null;
        int indexOf = translationsList.indexOf(translPanel);
        if(indexOf >= 0){
            equalTranslation = translationsList.get(indexOf);
            translationsList.remove(equalTranslation);
        }
        return equalTranslation;
    }

    private class RelevancyComparator implements Comparator<Translation> {

        private Object pattern;

        public RelevancyComparator(Object pattern) {
            this.pattern = pattern;
        }

        @Override
        public int compare(Translation translation1, Translation translation2) {
            double relevancyIndex1 = translation1.calculateRelevancyIndex(pattern);
            double relevancyIndex2 = translation2.calculateRelevancyIndex(pattern);
            return Double.compare(relevancyIndex1,relevancyIndex2);
        }

    }

}
