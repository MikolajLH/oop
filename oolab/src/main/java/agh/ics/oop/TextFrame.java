package agh.ics.oop;

import javax.swing.*;
import java.awt.*;

public class TextFrame extends JFrame {
    private JLabel textlabel;

    TextFrame(){
        this.setTitle("Title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400,400);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(88,88,88));
        //this.pack();

        textlabel = new JLabel();
        textlabel.setHorizontalAlignment(JLabel.CENTER);
        textlabel.setVerticalAlignment(JLabel.TOP);
        textlabel.setFont(new Font("MV Boil", Font.PLAIN,26));

    }

    void setText(String text) {

        String html = "<html>" + text.replaceAll("\n","<br> ");

            textlabel.setText(html);
            this.add(textlabel);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
    }

}
