package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Arrays;


public class ButtonActionService {

    private StringBuilder backstage = new StringBuilder();

    public void visibleActioning(Button button, Label result, String value) {
        backstage = new StringBuilder();//clear

        button.setOnAction(new EventHandler<ActionEvent>() {
            String[] worksheet = "0123456789+-×÷".split("");
            String[] special = "+-×÷".split("");

            @Override
            public void handle(ActionEvent event) {
                if (value.equals("AC")) {
                    result.setText("0");
                    backstage.setLength(0);
                } else if (Arrays.asList(worksheet).contains(value)) {
                    worksheets(result, special, value);
                } else if (value.equals("=")) {
                    calculations(result, special);
                } else if (value.equals(Buttons.SQUARE.getCode())) {
                    squareLogic(result);
                } else if (value.equals(Buttons.POINT.getCode())) {
                    pointDecision(result);
                } else if (value.equals(Buttons.PERCENT.getCode())) {
                    percentLogic(result);
                } else if (value.equals(Buttons.PM.getCode())) {
                    pmLogic(result);
                }
            }
        });
    }

    public String logic(String firstNumber, String secondNumber, String symbol) {
        Double one = Double.parseDouble(firstNumber);
        Double two = Double.parseDouble(secondNumber);
        String returning;
        if (symbol.equals(Buttons.PLUS.getCode())) {
            one = one + two;
            returning = Double.toString(one);
            return returning;
        } else if (symbol.equals(Buttons.MINUS.getCode())) {
            one = one - two;
            returning = Double.toString(one);
            return returning;
        } else if (symbol.equals(Buttons.MULTIPLY.getCode())) {
            one = one * two;
            returning = Double.toString(one);
            return returning;
        } else {
            double answer;
            answer = one / two;
            returning = Double.toString(answer);
            return returning;
        }
    }

    public void bugCorrection(Label result) {
        if (backstage.substring(backstage.length() - 1).equals("0") && backstage.substring(backstage.length() - 2, backstage.length() - 1).equals(".")) {
            backstage = new StringBuilder(backstage.toString().substring(0, backstage.length() - 2));
        }
        result.setText(backstage.toString());
    }

    public void pm(Label result) {
        if (backstage.substring(0, 1).equals(Buttons.MINUS.getCode())) {
            backstage.delete(0, 1);
        } else {
            backstage.insert(0, Buttons.MINUS.getCode());
        }
        result.setText(backstage.toString());
    }

    /**
     * @param result
     * @param special
     * @param value
     */
    public void worksheets(Label result, String[] special, String value) {
        if (backstage.length() >= 2 && Arrays.asList(special).contains(backstage.substring(backstage.length() - 1, backstage.length())) && Arrays.asList(special).contains(value)) {
            backstage.setLength(0);
            result.setText("Ошибка!");
        } else {
            if (backstage.length() < 1 && value.equals("0")) {
                result.setText("0");
            } else {
                backstage.append(value);
                result.setText(backstage.toString());
            }
        }

    }

    public void calculations(Label result, String[] special) {
        String firstNumber;
        String secondNumber;
        String symbol;
        int cnt = 0;
        for (int i = 0; i < backstage.length() - 1; i++) {
            if (Arrays.asList(special).contains(backstage.substring(i, i + 1)) && i != 0) {
                try {
                    firstNumber = backstage.substring(0, i);
                    symbol = backstage.substring(i, i + 1);
                    secondNumber = backstage.substring(i + 1, backstage.length());
                    cnt++;
                    backstage = new StringBuilder(logic(firstNumber, secondNumber, symbol));
                    bugCorrection(result);
                } catch (Exception e) {
                    System.out.println("");
                    result.setText("Ошибка!");
                    backstage.setLength(0);
                    break;
                }
            }
        }
        if (cnt > 1) {
            System.out.println("");
            result.setText("Ошибка!");
            backstage.setLength(0);
        }
    }

    public void squareLogic(Label result) {
        try {
            double answer = Double.parseDouble(backstage.toString());
            answer = Math.pow(answer, 2);
            backstage = new StringBuilder(Double.toString(answer));
            bugCorrection(result);
        } catch (Exception e) {
            result.setText("Ошибка!");
            backstage.setLength(0);
        }
    }

    public void percentLogic(Label result) {
        try {
            Double answer = new Double(backstage.toString());
            answer = answer * 0.01;
            backstage = new StringBuilder(answer.toString());
            bugCorrection(result);
        } catch (Exception e) {
            result.setText("Ошибка!");
            backstage.setLength(0);
        }
    }

    public void pmLogic(Label result) {
        try {
            pm(result);
        } catch (Exception ex) {
            result.setText("Ошибка!");
            backstage.setLength(0);
        }
    }

    public void pointDecision(Label result) {
        if (backstage.length() == 0) {
            backstage.append("0.");
        } else {
            backstage.append(".");
        }
        result.setText(backstage.toString());
    }
}
