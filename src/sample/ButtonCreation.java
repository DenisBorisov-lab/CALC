package sample;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ButtonCreation {
    private Button nol;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button point;
    private Button pm;
    private Button equal;
    private Button plus;
    private Button minus;
    private Button multiply;
    private Button division;
    private Button percent;
    private Button square;
    private Button clear;
    private Label result;
    private ButtonActionService buttonActionService;
    private Buttons buttons;

    public Button buttonCreate(String name, int x, int y, GridPane root){
        Button button = new Button(name);
        root.add(button, x, y);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        return button;
    }
    public void createComponent(GridPane root){
        result = new Label("0");
        GridPane.setHalignment(result, HPos.RIGHT);
        GridPane.setValignment(result, VPos.CENTER);
        root.add(result, 0, 0, 4, 1);

        buttonActionService = new ButtonActionService();
        nol = buttonCreate(Buttons.ZERO.getCode(), 1, 5, root);
        buttonActionService.visibleActioning(nol, result, buttons.ZERO.getCode());
        one = buttonCreate(Buttons.ONE.getCode(), 0, 4, root);
        buttonActionService.visibleActioning(one, result, buttons.ONE.getCode());
        two = buttonCreate(Buttons.TWO.getCode(), 1, 4, root);
        buttonActionService.visibleActioning(two, result, buttons.TWO.getCode());
        three = buttonCreate(Buttons.THREE.getCode(), 2, 4, root);
        buttonActionService.visibleActioning(three, result, buttons.THREE.getCode());
        four = buttonCreate(Buttons.FOUR.getCode(), 0, 3, root);
        buttonActionService.visibleActioning(four, result, buttons.FOUR.getCode());
        five = buttonCreate(Buttons.FIVE.getCode(), 1, 3, root);
        buttonActionService.visibleActioning(five, result, buttons.FIVE.getCode());
        six = buttonCreate(Buttons.SIX.getCode(), 2, 3, root);
        buttonActionService.visibleActioning(six, result, buttons.SIX.getCode());
        seven = buttonCreate(Buttons.SEVEN.getCode(), 0, 2, root);
        buttonActionService.visibleActioning(seven, result, buttons.SEVEN.getCode());
        eight = buttonCreate(Buttons.EIGHT.getCode(), 1, 2, root);
        buttonActionService.visibleActioning(eight, result, buttons.EIGHT.getCode());
        nine = buttonCreate(Buttons.NINE.getCode(), 2, 2, root);
        buttonActionService.visibleActioning(nine, result, buttons.NINE.getCode());
        point = buttonCreate(Buttons.POINT.getCode(), 2, 5, root);
        buttonActionService.visibleActioning(point, result, buttons.POINT.getCode());
        pm = buttonCreate(Buttons.PM.getCode(), 0, 5, root);
        buttonActionService.visibleActioning(pm, result, buttons.PM.getCode());
        equal = buttonCreate(Buttons.EQUAL.getCode(), 3, 5, root);
        buttonActionService.visibleActioning(equal, result, buttons.EQUAL.getCode());
        plus = buttonCreate(Buttons.PLUS.getCode(), 3, 4, root);
        buttonActionService.visibleActioning(plus, result, buttons.PLUS.getCode());
        minus = buttonCreate(Buttons.MINUS.getCode(), 3, 3, root);
        buttonActionService.visibleActioning(minus, result, buttons.MINUS.getCode());
        multiply = buttonCreate(Buttons.MULTIPLY.getCode(), 3, 2, root);
        buttonActionService.visibleActioning(multiply, result, buttons.MULTIPLY.getCode());
        division = buttonCreate(Buttons.DIVISION.getCode(), 3, 1, root);
        buttonActionService.visibleActioning(division, result, buttons.DIVISION.getCode());
        percent = buttonCreate(Buttons.PERCENT.getCode(), 2, 1, root);
        buttonActionService.visibleActioning(percent, result, buttons.PERCENT.getCode());
        square = buttonCreate(Buttons.SQUARE.getCode(), 1, 1, root);
        buttonActionService.visibleActioning(square, result, buttons.SQUARE.getCode());
        clear = buttonCreate(Buttons.CLEAR.getCode(), 0, 1, root);
        buttonActionService.visibleActioning(clear, result, buttons.CLEAR.getCode());


    }
}
