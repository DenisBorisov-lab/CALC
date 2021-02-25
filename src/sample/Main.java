package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application {

    Button nol;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button point;
    Button pm;
    Button equal;
    Button plus;
    Button minus;
    Button multiply;
    Button division;
    Button percent;
    Button square;
    Button clear;
    Label result;
    GridPane root;

    private DoubleProperty fontSize = new SimpleDoubleProperty(10);

    @Override
    public void start(Stage stage) throws Exception{
        root = new GridPane();
        createColumn(root);
        createRows(root);
        createComponent(root);
        Scene scene = new Scene(root, 400, 600);
        stage.setScene(scene);
        //root.setGridLinesVisible(true);
        stage.setResizable(false);
        stage.setTitle("Calculator");
        stage.show();
        fontSize.bind(scene.widthProperty().add(scene.heightProperty()).divide(30));
        root.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString()));

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
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
    public Button buttonCreate(String name, int x, int y){
        Button button = new Button(name);
        root.add(button, x, y);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        return button;
    }
    public void createComponent(GridPane root){

        nol = buttonCreate("0", 1, 5);
        one = buttonCreate("1", 0, 4);
        two = buttonCreate("2", 1, 4);
        three = buttonCreate("3", 2, 4);
        four = buttonCreate("4", 0, 3);
        five = buttonCreate("5", 1, 3);
        six = buttonCreate("6", 2, 3);
        seven = buttonCreate("7", 0, 2);
        eight = buttonCreate("8", 1, 2);
        nine = buttonCreate("9", 2, 2);
        point = buttonCreate(",", 2, 5);
        pm = buttonCreate("+/-", 0, 5);
        equal = buttonCreate("=", 3, 5);
        plus = buttonCreate("+", 3, 4);
        minus = buttonCreate("-", 3, 3);
        multiply = buttonCreate("×", 3, 2);
        division = buttonCreate("÷", 3, 1);
        percent = buttonCreate("%", 2, 1);
        square = buttonCreate("x²", 1, 1);
        clear = buttonCreate("AC", 0, 1);

        result = new Label("12313");
        GridPane.setHalignment(result, HPos.RIGHT);
        GridPane.setValignment(result, VPos.CENTER);
        root.add(result, 0, 0, 4, 1);
    }
    
    public static void main(String[] args) { launch(args); }
}
