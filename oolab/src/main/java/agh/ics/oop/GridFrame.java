package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GridFrame extends JFrame {
    private final int rows;
    private final int cols;
    private final int panel_w;
    private final int panel_h;
    private ArrayList<JPanel> cells;

    GridFrame(int rows, int cols){
        final int window_w = 400;
        final int window_h = 400;
        this.cells = new ArrayList<>();

        this.rows = rows;
        this.cols = cols;

        this.panel_w = window_w / cols;
        this.panel_h = window_h / rows;

        this.setTitle("Title");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(window_w,window_h);
        this.setVisible(true);

        this.setLayout(new BorderLayout());

        this.setBackground(Color.GREEN);


        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
                JPanel cell = new JPanel();
                cell.setBackground(Color.RED);
                cell.setBounds(panel_w * c, panel_h * r, panel_w, panel_h);
                //cell.setBorder(BorderFactory.createLineBorder(Color.black));
                JLabel textLabel = new JLabel();
                textLabel.setHorizontalAlignment(JLabel.CENTER);
                textLabel.setVerticalAlignment(JLabel.TOP);
                textLabel.setText("K");
                cell.add(textLabel);

                cells.add(cell);
            }
        }
    }

    public void present()
    {
        for(JPanel cell : cells)
        {
            this.add(cell);
        }

    }


}
