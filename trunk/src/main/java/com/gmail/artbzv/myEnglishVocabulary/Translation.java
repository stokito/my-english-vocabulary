package com.gmail.artbzv.myEnglishVocabulary;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Translation implements Comparable{

    private Language languageFrom;
    private TranslationData translationData = new TranslationData();

    public Translation(TranslationData translationData, Language language) {

        this(language);
        this.translationData = translationData;

    }

    public Translation(Language language) {
        this.languageFrom = language;
    }

    public Translation(){
        
    }

    public void insertToDB(){
        Connection connection = WordsDB.getConnection();
        try {
            PreparedStatement prepStatement = connection.prepareStatement("INSERT INTO Translations " +
                    "(English,Russian,EnglishRemembered,RussianRemembered,LastStudied) " +
                    "VALUES (?,?,?,?,?)");
            prepStatement.setString(1, translationData.englishWord);
            prepStatement.setString(2, translationData.russianWord);
            prepStatement.setInt(3, translationData.englishRemembered);
            prepStatement.setInt(4, translationData.russianRemembered);
            prepStatement.setTimestamp(5, new Timestamp(translationData.lastStudied.getTime()));
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (Exception e) {
            new Warning(e);
        }
    }

    public void updateToDB() {
        Connection connection = WordsDB.getConnection();
        try {
            PreparedStatement prepStatement = connection.prepareStatement("UPDATE TRANSLATIONS\n" +
                    "SET English=?,Russian=?,EnglishRemembered=?,RussianRemembered=?,LastStudied=?\n" +
                    "WHERE English=? and Russian=?");
            prepStatement.setString(1, translationData.englishWord);
            prepStatement.setString(2, translationData.russianWord);
            prepStatement.setInt(3, translationData.englishRemembered);
            prepStatement.setInt(4, translationData.russianRemembered);
            prepStatement.setTimestamp(5, new Timestamp(translationData.lastStudied.getTime()));
            prepStatement.setString(6, translationData.englishWordKey);
            prepStatement.setString(7, translationData.russianWordkey);
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (Exception e) {
            new Warning(e);
        }
    }

    public void setRussianWord(String russianWord) {
        translationData.russianWord = russianWord;
    }

    public void setEnglishWord(String englishWord) {
        translationData.englishWord = englishWord;
    }

    public String getWord() {

        if(languageFrom.isEnglish()){
            return translationData.englishWord;
        } else if(languageFrom.isRussian()){
            return translationData.russianWord;
        }
        return null;

    }

    public String getTranslation() {

        if(languageFrom.isEnglish()){
            return translationData.russianWord;
        } else if(languageFrom.isRussian()){
            return translationData.englishWord;
        }
        return null;

    }

    public void correctAnswer() {

        if(languageFrom.isEnglish()){
            translationData.englishRemembered++;
        } else if(languageFrom.isRussian()){
            translationData.russianRemembered++;
        }

    }

    public void wrongAnswer() {

        if(languageFrom.isEnglish()){
            translationData.englishRemembered--;
        } else if(languageFrom.isRussian()){
            translationData.russianRemembered--;
        }

    }

    @Override
    public int compareTo(Object object) {
        if(languageFrom.isRussian()){
            return translationData.englishWord.compareTo(object.toString());
        } else {
            return translationData.russianWord.compareTo(object.toString());
        }
    }
    
    public double calculateRelevancyIndex(Object pattern) {

        ArrayList listOfCharsPattern = MyTools.charArrayToArrayList(pattern.toString().toCharArray());
        ArrayList listOfCharsThis = MyTools.charArrayToArrayList(getTranslation().toCharArray());
        double countFound = 0;
        double countNotFound = 0;

        for(Object charPattern : listOfCharsPattern){
            if(listOfCharsThis.contains(charPattern)){
                countFound++;
                listOfCharsThis.remove(charPattern);
            } else {
                countNotFound++;
            }
        }
        double countLeftAfterSearch = listOfCharsThis.size();

        return countFound / (countNotFound + countLeftAfterSearch + 1);

    }
}
