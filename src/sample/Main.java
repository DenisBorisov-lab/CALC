package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application {

    private GridPane root;
    private ButtonCreation bc = new ButtonCreation();

    private DoubleProperty fontSize = new SimpleDoubleProperty(10);

    @Override
    public void start(Stage stage) throws Exception{
        root = new GridPane();
        createColumn(root);
        createRows(root);
        bc.createComponent(root);
        Scene scene = new Scene(root, 400, 600);
        stage.setScene(scene);
        //root.setGridLinesVisible(true);
        stage.setResizable(false);
        stage.setTitle("Calculator");
        stage.show();
        fontSize.bind(scene.widthProperty().add(scene.heightProperty()).divide(30));
        root.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString()));
    }

    public static void createColumn(GridPane root){
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(25);
        root.getColumnConstraints().add(column1);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(25);
        root.getColumnConstraints().add(column2);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(25);
        root.getColumnConstraints().add(column3);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(25);
        root.getColumnConstraints().add(column4);
    }

    public static void createRows(GridPane root){
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(16.7);
        root.getRowConstraints().add(row1);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(16.7);
        root.getRowConstraints().add(row2);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(16.7);
        root.getRowConstraints().add(row3);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(16.7);
        root.getRowConstraints().add(row4);
        RowConstraints row5 = new RowConstraints();
        row5.setPercentHeight(16.7);
        root.getRowConstraints().add(row5);
        RowConstraints row6 = new RowConstraints();
        row6.setPercentHeight(16.7);
        root.getRowConstraints().add(row6);
    }
    
    public static void main(String[] args) { launch(args); }
}
