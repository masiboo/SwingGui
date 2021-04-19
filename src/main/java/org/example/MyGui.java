package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

    public class MyGui {
        private JList<String> docList;
        private JPanel mainPanel;
        private DefaultListModel<String> listDocModel;

        public MyGui(){

            listDocModel = new DefaultListModel<>();

            try (InputStream resource = MyGui.class.getResourceAsStream("/data.csv");
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))) {
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    listDocModel.addElement(line);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            docList = new JList<>(listDocModel);
            mainPanel = new JPanel();
            mainPanel.add(docList);
            //docList.setModel(listDocModel);
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("MyGui");
            frame.setContentPane(new MyGui().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize( new Dimension( 800, 800));
            frame.pack();
            frame.setVisible(true);
        }
    }
