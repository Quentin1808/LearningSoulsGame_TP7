package lsg.graphics.widgets.texts;

import javafx.scene.Node;
import lsg.graphics.CSSFactory;

public class GameLabel extends javafx.scene.control.Label{

    public GameLabel(){
        super();
        this.getStylesheets().add(CSSFactory.getStyleSheet("LSGFont.css"));
        this.getStyleClass().addAll("game-font");
        this.getStyleClass().addAll("game-font-fx");
    }

    public GameLabel(String label){
        super(label);
        this.getStylesheets().add(CSSFactory.getStyleSheet("LSGFont.css"));
        this.getStyleClass().addAll("game-font");
        this.getStyleClass().addAll("game-font-fx");
    }

    public GameLabel(String label, Node n){
        super(label,n);
        this.getStylesheets().add(CSSFactory.getStyleSheet("LSGFont.css"));
        this.getStyleClass().addAll("game-font");
        this.getStyleClass().addAll("game-font-fx");
    }
}
