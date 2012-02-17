package com.gmail.artbzv.myEnglishVocabulary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{

    CardLayout cardLayout = new CardLayout();
    JPanel centralPanel;

    public MainFrame(){

        super("English vocabulary");

        add(createButtonPanel(), BorderLayout.NORTH);
        add(centralPanel = createCentralPanel());
        add(createAuthorInfoPannel(), BorderLayout.SOUTH);

        setSize(850,500);
        setVisible(true);
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                WordsDB.closeConnection();
                System.exit(0);
            }
        });
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private JPanel createButtonPanel() {

        JPanel buttonPanel = new JPanel();

        JButton switchPanelButton = new JButton("Test");
        switchPanelButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.next(centralPanel);
            }
        });
        buttonPanel.add(switchPanelButton);

        return buttonPanel;

    }

    private JPanel createCentralPanel() {

        JPanel centralPanel = new JPanel(cardLayout);
        centralPanel.add(new LearningWordsPanel(),"LearningWordsPanel");
        centralPanel.add(new AddingWordsPanel(),"AddingWordsPanel");

        return centralPanel;

    }

    private JPanel createAuthorInfoPannel() {

        JPanel authorInfoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel authorInfoLabel = new JLabel("<html> Made by Artem Urkov <a href=\"mailto:artbzv@gmail.com\"> artbzv@gmail.com</a>");
        authorInfoPanel.add(authorInfoLabel);

        return authorInfoPanel;

    }

}
