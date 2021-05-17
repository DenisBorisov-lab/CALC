package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private final ButtonCreation bc = new ButtonCreation();

    private final DoubleProperty fontSize = new SimpleDoubleProperty(10);

    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();
        Components.createColumn(root);
        Components.createRows(root);
        bc.createComponent(root);
        Scene scene = new Scene(root, 400, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Calculator");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("imgicon.png")));
        stage.show();
        //root.setGridLinesVisible(true);
        fontSize.bind(scene.widthProperty().add(scene.heightProperty()).divide(30));
        root.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
