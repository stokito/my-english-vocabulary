package com.gmail.artbzv.myEnglishVocabulary;

import org.jawin.DispatchPtr;
import org.jawin.win32.Ole32;

public class Speaker {

    private static DispatchPtr winSpeakAPI;
    private static final Speaker speaker = new Speaker();

    private Speaker(){
        try {
            Ole32.CoInitialize();
            winSpeakAPI = new DispatchPtr("Sapi.SpVoice");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void say(Object obj){
        try {
            winSpeakAPI.invoke("Speak", obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
