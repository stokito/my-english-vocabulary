package com.gmail.artbzv.myEnglishVocabulary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class TranslationData {

    public String englishWordKey;
    public String russianWordkey;
    public String englishWord;
    public String russianWord;
    public int englishRemembered;
    public int russianRemembered;
    public Date lastStudied;

    public TranslationData(ResultSet resultSet) throws SQLException {
        englishWord = englishWordKey = resultSet.getString("English");
        russianWord = russianWordkey = resultSet.getString("Russian");
        englishRemembered = resultSet.getInt("EnglishRemembered");
        russianRemembered = resultSet.getInt("RussianRemembered");
        lastStudied = resultSet.getDate("LastStudied");
    }

    public TranslationData() {
        
    }
}
