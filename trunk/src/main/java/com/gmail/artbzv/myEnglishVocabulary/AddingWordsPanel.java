package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddingWordsPanel extends JPanel {

    private Translation translation;
    private JLabel russianWordLabel = new JLabel("Russian");
    private JLabel englishWordLabel = new JLabel("English");
    private JTextField russianTextField = new FilteredTextField(new Russian());
    private JTextField englishTextField = new FilteredTextField(new English());
    private JButton sumbit = new JButton("Sumbit");

    public AddingWordsPanel(){

        translation = new Translation();

        russianTextField.addCaretListener(new CaretListener(){

            @Override
            public void caretUpdate(CaretEvent e) {
                translation.setRussianWord(russianTextField.getText());
            }
        });

        englishTextField.addCaretListener(new CaretListener(){

            @Override
            public void caretUpdate(CaretEvent e) {
                translation.setEnglishWord(englishTextField.getText());
            }
        });

        sumbit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                translation.insertToDB();
            }
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel boxR1 = MyTools.createHorizontalPanel();

        MyTools.minimizeComponentHeight(englishTextField);
        MyTools.minimizeComponentHeight(russianTextField);
        boxR1.add(englishWordLabel);
        boxR1.add(englishTextField);
        boxR1.add(russianWordLabel);
        boxR1.add(russianTextField);
        boxR1.add(sumbit);

        add(boxR1);
        add(Box.createVerticalGlue());
        
    }

}
