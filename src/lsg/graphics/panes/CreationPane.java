package lsg.graphics.panes;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import lsg.graphics.widgets.texts.GameLabel;

public class CreationPane extends javafx.scene.layout.VBox {

    private javafx.scene.control.TextField nameField;
    private GameLabel titleLabel;
    private static final Duration ANIMATION_DURATION = Duration.millis(1500);


    public TextField getNameField() {
        return nameField;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public CreationPane(){
        nameField = new TextField();
        titleLabel = new GameLabel("Player Name");

        nameField.setMaxWidth(250);
        this.getChildren().addAll(titleLabel);
        this.getChildren().addAll(nameField);
        this.setAlignment(Pos.CENTER);
    }

    public void fadeIn(EventHandler<ActionEvent> finishedHandler){
        FadeTransition ft = new FadeTransition();
        ft.setNode(this);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.setDuration(ANIMATION_DURATION);
        ft.setCycleCount(1);
        ft.setOnFinished(finishedHandler);
        ft.play();
    }
}
