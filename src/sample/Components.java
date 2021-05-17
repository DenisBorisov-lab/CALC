package sample;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Components {

    public static void createRows(GridPane root) {
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

    public static void createColumn(GridPane root) {
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
}
