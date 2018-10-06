/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Smith
 */
public class First extends Application {

    private ImageView space0;
    private ImageView space1;
    private Rectangle space0Clip;
    private Rectangle space1Clip;
    private ImageView ship;

    private ImageView quit;

    private double sX = 0;
    private DoubleProperty coordXReal = new SimpleDoubleProperty(0);
    private FadeTransition fadeTransition;
    private DropShadow shipShadow;

    private SimpleDoubleProperty xOff = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty yOff = new SimpleDoubleProperty(0.0);
    private SimpleDoubleProperty sOff = new SimpleDoubleProperty(5.0);
    private SimpleDoubleProperty scale = new SimpleDoubleProperty(0.5);
    private Timeline shipFlyAway;

    private boolean exited = true;

//    private double sY = 0;
//    private DoubleProperty coordYReal = new SimpleDoubleProperty(0);
    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        space0 = new ImageView(new Image(First.class.getResourceAsStream("images/space0.jpg")));
        space0Clip = new Rectangle(1600, 1440);
        space0Clip.setArcHeight(40);
        space0Clip.setArcWidth(40);
        space1 = new ImageView(new Image(First.class.getResourceAsStream("images/space1.jpg")));
        space1Clip = new Rectangle(1600, 1440);
        space1Clip.setArcHeight(40);
        space1Clip.setArcWidth(40);
        space1.setOpacity(0.0);

        setShark();

        fadeTransition = new FadeTransition(Duration.seconds(1), space1);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);

        setXDrag();
        setQuit();
        // setYDrag();

        space0.setClip(space0Clip);
        space1.setClip(space1Clip);

        Pane root = new Pane();
        root.getChildren().addAll(space0, space1, ship, quit);

        Scene myScene = new Scene(root, 1800, 1000);
        myScene.setFill(null);
        primaryStage.setScene(myScene);
        primaryStage.show();

    }

    private void setShark() {
        ship = new ImageView(new Image(First.class.getResourceAsStream("images/ship.png")));
        ship.setScaleX(0.5);
        ship.setScaleY(0.5);
        ship.opacityProperty().bind(space1.opacityProperty());

        ship.scaleXProperty().bind(scale);
        ship.scaleYProperty().bind(scale);
        ship.xProperty().bind(xOff);
        ship.yProperty().bind(yOff);

        shipShadow = new DropShadow(5.0, 5.0, 0.0, Color.BLACK);
        shipShadow.offsetXProperty().bind(sOff);
        shipShadow.offsetYProperty().bind(sOff);

        ship.setEffect(shipShadow);

        shipFlyAway = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(sOff, 0),
                        new KeyValue(scale, 0.5),
                        new KeyValue(xOff, 0),
                        new KeyValue(yOff, 0)),
                new KeyFrame(new Duration(5000),
                        new KeyValue(sOff, -100),
                        new KeyValue(scale, 0.05),
                        new KeyValue(xOff, 2500),
                        new KeyValue(yOff, 800))
        );

        ship.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                shipFlyAway.play();
            }
        });

    }

    private void setXDrag() {

        space0.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                sX = t.getSceneX() - coordXReal.getValue();
            }
        });

        space0.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                coordXReal.set(t.getSceneX() - sX);
            }
        });

        space0.xProperty().bind(coordXReal);

        space1.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                sX = t.getSceneX() - coordXReal.getValue();
            }
        });

        space1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                coordXReal.set(t.getSceneX() - sX);
            }
        });

        space1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                //space1.setOpacity(1.0);
                if (exited) {
                    fadeTransition.setRate(1.0);
                    fadeTransition.play();
                    exited = false;
                }
            }
        });

        space1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                //space1.setOpacity(0.0);
                if (!space1Clip.contains(new Point2D(t.getSceneX(), t.getSceneY()))) {
                    fadeTransition.setRate(-1.0);
                    fadeTransition.play();
                    exited = true;
                }
            }
        });
        space1.xProperty().bind(coordXReal);
    }

    /*  private void setYDrag() {
        
        space0.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                sY = t.getSceneY() - coordYReal.getValue();
            }
        });
        
        space0.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                coordYReal.set(t.getSceneY() - sY);
            }
        });
        
        space0.yProperty().bind(coordYReal);
    }
     */
    private void setQuit() {
        quit = new ImageView(new Image(First.class.getResourceAsStream("images/close.png")));
        quit.setFitHeight(60);
        quit.setFitWidth(60);
        quit.setX(1500);
        quit.setY(20);

        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                System.exit(0);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
