package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.math.BigDecimal;
import java.util.Arrays;


public class ButtonActionService {

    private StringBuilder backstage = new StringBuilder();
    String[] worksheet = "0123456789+-×÷".split("");
    String[] special = "+-×÷".split("");

    public void visibleActioning(Button button, Label result, String value) {
        backstage = new StringBuilder();//clear



        button.setOnAction(new EventHandler<ActionEvent>() {


            @Override
            public void handle(ActionEvent event) {
                if (value.equals("AC")) {
                    result.setText("0");
                    backstage.setLength(0);
                } else if (Arrays.asList(worksheet).contains(value)) {
                    worksheets(result, value);
                } else if (value.equals("=")) {
                    calculations(result, special);
                } else if (value.equals(Buttons.SQUARE.getCode())) {
                    squareLogic(result);
                } else if (value.equals(Buttons.POINT.getCode())) {
                    pointDecision(result);
                } else if (value.equals(Buttons.ROOT.getCode())) {
                    rootLogic(result);
                } else if (value.equals(Buttons.PM.getCode())) {
                    pmLogic(result);
                }
            }
        });
        button.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (Arrays.asList(worksheet).contains(event.getText())) {
                    worksheets(result, event.getText());
                } else if (event.getCode() == KeyCode.ENTER) {
                    calculations(result, special);
                } else if (event.getCode() == KeyCode.BACK_SPACE && !result.getText().equals("Ошибка!") && !result.getText().equals("Infinity")) {
                    try {
                        result.setText(result.getText().substring(0, result.getText().length() - 1));
                        backstage = new StringBuilder(result.getText());
                    } catch (Exception exception) {
                        System.out.println("больше нечего удалять!");
                    }

                } else if (event.getCode() == KeyCode.EQUALS) {
                    worksheets(result, "+");
                } else if (event.getCode() == KeyCode.DELETE) {
                    result.setText("0");
                    backstage.setLength(0);
                } else if (event.getCode() == KeyCode.COMMA) {
                    pointDecision(result);
                }
                numPadVersion(event, result);
                System.out.println(event.getCode());
                System.out.println(event.getText());

            }
        });
    }

    public String logic(String firstNumber, String secondNumber, String symbol) {
        BigDecimal one = new BigDecimal(firstNumber);
        BigDecimal two = new BigDecimal(secondNumber);
        String returning;
        if (symbol.equals(Buttons.PLUS.getCode())) {
            one = one.add(two);
            returning = one.toString();
            return returning;
        } else if (symbol.equals(Buttons.MINUS.getCode())) {
            one = one.subtract(two);
            returning = one.toString();
            return returning;
        } else if (symbol.equals(Buttons.MULTIPLY.getCode())) {
            one = one.multiply(two);
            returning = one.toString();
            return returning;
        } else {
            BigDecimal answer;
            answer = one.divide(two, 5, BigDecimal.ROUND_HALF_EVEN);
            returning = answer.toString();
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
     * @param value
     */
    public void worksheets(Label result, String value) {
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

    public void rootLogic(Label result) {
        try {
            BigDecimal answer = new BigDecimal(backstage.toString());
            answer = BigDecimal.valueOf(Math.sqrt(answer.doubleValue()));
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

    public void numPadVersion(KeyEvent event, Label result) {
        String number = "";
        switch (event.getCode()) {
            case END:
                number = "1";
                worksheets(result, number);
                break;
            case INSERT:
                number = "0";
                worksheets(result, number);
                break;
            case DOWN:
                number = "2";
                worksheets(result, number);
                break;
            case PAGE_DOWN:
                number = "3";
                worksheets(result, number);
                break;
            case LEFT:
                number = "4";
                worksheets(result, number);
                break;
            case CLEAR:
                number = "5";
                worksheets(result, number);
                break;
            case RIGHT:
                number = "6";
                worksheets(result, number);
                break;
            case HOME:
                number = "7";
                worksheets(result, number);
                break;
            case UP:
                number = "8";
                worksheets(result, number);
                break;
            case PAGE_UP:
                number = "9";
                worksheets(result, number);
                break;
            case MULTIPLY:
                number = "×";
                worksheets(result, number);
                break;
            case DIVIDE:
            case SLASH:
                number = "÷";
                worksheets(result,  number);
                break;
            default:
                break;
        }
    }
}