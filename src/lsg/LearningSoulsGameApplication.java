package lsg;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import lsg.graphics.CSSFactory;
import lsg.graphics.ImageFactory;
import lsg.graphics.panes.AnimationPane;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.TitlePane;
import lsg.graphics.widgets.texts.GameLabel;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

public class LearningSoulsGameApplication extends Application {

    private Scene scene;
    private AnchorPane root;
    private TitlePane gameTitle;
    private CreationPane creationPane;
    private String heroName;
    private AnimationPane animationPane;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Learning Souls Game");

        root = new AnchorPane();
        scene = new Scene(root, 1200,800);

        stage.setScene(scene);
        stage.setResizable(false);

        buildUI();
        addListeners();

        stage.show();
        startGame();
    }

    private void buildUI(){
        scene.getStylesheets().add(CSSFactory.getStyleSheet("LSG.css"));
        //root.getChildren().addAll(new GameLabel("Test d'utilisation du Label"));

        gameTitle = new TitlePane(scene,"Learning Souls Game");
        AnchorPane.setLeftAnchor(gameTitle, 0.0);
        AnchorPane.setTopAnchor(gameTitle, 0.0);
        AnchorPane.setRightAnchor(gameTitle, 0.0);
        root.getChildren().addAll(gameTitle);

        creationPane = new CreationPane();
        creationPane.setOpacity(0);
        AnchorPane.setTopAnchor(creationPane,0.0);
        AnchorPane.setLeftAnchor(creationPane,0.0);
        AnchorPane.setRightAnchor(creationPane,0.0);
        AnchorPane.setBottomAnchor(creationPane,0.0);
        root.getChildren().addAll(creationPane);

        animationPane = new AnimationPane(root);
    }

    /*public void startGame(){
        gameTitle.zoomIn(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent actionEvent) {
                creationPane.fadeIn(null);
                System.out.println("ZOOM Terminé !");
            }
        });
    }*/

    private void addListeners(){
        creationPane.getNameField().setOnAction((event -> {
            heroName = creationPane.getNameField().getText();
            System.out.println("Nom du héro : " + heroName);
            if(!heroName.equals("")){
                root.getChildren().remove(creationPane);
                gameTitle.zoomOut((eventOut -> {
                    System.out.println("DEZOOM !");
                }));
            }
        }));
    }

    public void startGame(){
        gameTitle.zoomIn((event-> {
            creationPane.fadeIn((event1 -> {
                ImageFactory.preloadAll((() -> {
                    System.out.println("Pré-chargement des images terminé");
                }));
            }));
        }));
    }

    private void play(){

    }

}
