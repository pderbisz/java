package agh.ics.oop.gui;
//import javafx.*;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;

import java.util.List;

public class App extends Application {

    public void start(Stage primaryStage) {
        List<String> raw =getParameters().getRaw();
        String[] args= new String[raw.size()];
        for(int i=0; i<raw.size(); i++){
            args[i]=raw.get(i);
        }
        MoveDirection[] directions = new OptionsParser().parse(args);
        //   IWorldMap map = new RectangularMap(10, 5);

        AbstractWorldMap map = new GrassField(10);

        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        Vector2d upRight = map.findUpperRight();
        int height=upRight.y;
        int width=upRight.x;
        System.out.println("height");
        System.out.println(height);
        System.out.println(width);
       // engine.run();

        GridPane gridPane = new GridPane();
        for(int i=0; i<height+1; i++){
            Integer a=i;
            Label label1= new Label(a.toString());
            gridPane.add(label1,0,height-i+1,1,1);
        }
        for(int i=1; i<=width+1; i++){
            Integer a=i-1;
            Label label1= new Label(a.toString());
            gridPane.add(label1,i,0,1,1);
        }
        Integer h=height+1;
        Integer w=width;
        Label label0= new Label("y / x");
        gridPane.add(label0,0,0,1,1);
        for(int i=0; i<=height; i++){
            for(int j=0; j<=width; j++){
                Object there=map.objectAt(new Vector2d(j,height-i));
                Label label1= new Label(" ");
                if(there != null){
                    label1=new Label(there.toString());
                }
                gridPane.add(label1,j+1,i+1,1,1);
            }
        }
        for(int j=0; j<=width+1; j++){
            ColumnConstraints column1 = new ColumnConstraints(10,10,Double.MAX_VALUE);
            column1.setHgrow(Priority.ALWAYS);
            gridPane.getColumnConstraints().addAll(column1); // first column gets any extra width
        }
        for(int j=0; j<=height+1; j++){
            RowConstraints column2 = new RowConstraints(10,10,Double.MAX_VALUE);
            column2.setVgrow(Priority.ALWAYS);
            gridPane.getRowConstraints().addAll(column2);
        }

       // ColumnConstraints column2 = new ColumnConstraints(10);
       // gridPane.getColumnConstraints().addAll(column1, column2); // first column gets any extra width
        gridPane.setGridLinesVisible(true);
        Scene scene = new Scene(gridPane, 50*(width+1), 50*(height+1));
        primaryStage.setScene(scene);
        primaryStage.show();
        engine.run();
    }
}
