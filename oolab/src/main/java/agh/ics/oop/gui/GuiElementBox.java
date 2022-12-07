package agh.ics.oop.gui;
//import javafx.*;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
public class GuiElementBox  {
    public VBox vbox;
    public GuiElementBox(AbstractObject object){
        Image image;
        {
            try {
                image = new Image(new FileInputStream(object.getSrc()));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label label= new Label(object.getPos().toString());
        vbox = new VBox(imageView, label);
        vbox.setAlignment(Pos.BASELINE_CENTER);
    }
    public VBox createBox(AbstractObject object) {
        Image image;
        {
            try {
                image = new Image(new FileInputStream(object.getSrc()));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        Label label= new Label(object.getPos().toString());
        VBox vbox = new VBox(imageView, label);
        vbox.setAlignment(Pos.BASELINE_CENTER);
        return vbox;
    }

}
