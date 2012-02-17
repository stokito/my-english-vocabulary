package com.gmail.artbzv.myEnglishVocabulary;

import java.sql.*;

public class WordsDB {

    private static Connection connection;

    public static void initConnection(){
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            //connection = DriverManager.getConnection("jdbc:hsqldb:file://H:\\Java\\IdeaProjects\\MyEnglishVocabulary\\MyEnglishVocabularyDB\\.lck", "sa", "1");
            connection = DriverManager.getConnection("jdbc:hsqldb:file://G:\\Java\\IdeaProjects\\MyEnglishVocabulary\\MyEnglishVocabularyDB\\.lck", "sa", "1");
        } catch (Exception e) {
            new Warning(e);
        }
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (Exception e) {
            new Warning(e);
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static TranslationsList getRandomTranslationList(Language language) {

        TranslationsList translationsList = new TranslationsList();

        try {
            PreparedStatement prepStatement = connection.prepareStatement("select ENGLISH, RUSSIAN, EnglishRemembered, RussianRemembered, LASTSTUDIED\n" +
                    "from translations\n" +
                    "where " + language + "=(select top 1 " + language + "\n" +
                    "        from translations\n" +
                    "        where laststudied=(Select min(laststudied)\n" +
                    "                from translations" +
                    "                where " + language + "Remembered<" + GlobalData.getStudiedDelimiter() + "))");
            prepStatement.execute();
            ResultSet resultSet =  prepStatement.getResultSet();

            while(resultSet.next()){
                Translation translation = new Translation(new TranslationData(resultSet), language);
                translationsList.add(translation);
            }
            prepStatement.close();
        } catch (Exception e) {
            new Warning(e);
        }

        return translationsList;

    }
}
