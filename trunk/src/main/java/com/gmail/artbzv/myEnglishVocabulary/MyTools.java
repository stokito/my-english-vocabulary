package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyTools {

    public static JPanel createVerticalPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        return p;
    }

    public static JPanel createHorizontalPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        return p;
    }

    public static void setGroupAlignmentX(JComponent container, float alignment){
        for(Component component:container.getComponents()){
            ((JComponent) component).setAlignmentX(alignment);
        }
    }

    public static void setGroupAlignmentY(JComponent container, float alignment){
        for(Component component:container.getComponents()){
            ((JComponent) component).setAlignmentY(alignment);
        }
    }

    public static void minimizeComponentHeight(JComponent component){
        Dimension size = component.getPreferredSize();
        size.width = component.getMaximumSize().width;
        component.setMaximumSize(size);
    }

    public static ArrayList charArrayToArrayList(char[] array){
        ArrayList arrayList = new ArrayList();
        for (char charFromArray : array) {
            arrayList.add(charFromArray);
        }
        return arrayList;
    }

}
