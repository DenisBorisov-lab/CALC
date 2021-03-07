package sample;

public enum Buttons {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    POINT(","),
    PM("+/-"),
    EQUAL("="),
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("×"),
    DIVISION("÷"),
    PERCENT("%"),
    SQUARE("x²"),
    CLEAR("AC");
    private String code;

    Buttons(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
