package agh.ics.oop.gui;

import agh.ics.oop.*;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    final double screen_w = 400;
    final double screen_h = 400;

    AbstractWorldMap map;
    IEngine engine;

    public void init(){

        try {
            List<String> args = getParameters().getRaw();
            MoveDirection[] directions = OptionsParser.parse(args);

            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(2, 3)};
            engine = new SimulationEngine(directions, map, positions);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }


    public void start(Stage primaryStage){

        Vector2d lL = map.lowerLeft();
        Vector2d uR = map.upperRight();

        final int W = uR.x - lL.x + 1;
        final int H = uR.y - lL.y + 1;

        final double field_w = screen_w / (W + 1);
        final double field_h = screen_h / (H + 1);

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        for(int y = 0; y < H + 1; y++)
            for(int x = 0; x < W + 1; x++){
                grid.getColumnConstraints().add(new ColumnConstraints(field_w));
                grid.getRowConstraints().add(new RowConstraints(field_h));
                int gy = y;
                String S;
                if(x == 0 && y == 0) S = "x/y";
                else if(x == 0) S = Integer.toString(H - y + lL.y);
                else if(y == 0) S = Integer.toString(x - 1 + lL.x);
                else{
                    Object o = map.objectAt(new Vector2d(x-1,y-1).add(lL));
                    S = o == null ? " " : o.toString();
                    gy = H + 1 - y;
                }
                Label label = new Label(S);
                grid.add(label,x,gy, 1,1);
                GridPane.setHalignment(label, HPos.CENTER);
            }


        Scene scene = new Scene(grid, screen_w, screen_h);
        primaryStage.setScene(scene);

        primaryStage.show();
        engine.run();
    }
}
