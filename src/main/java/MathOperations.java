public enum MathOperations {
    MULTIPLICATION("умножение"),
    SUBTRACTION("вычесть"),
    ADDITION("сложить");

    private String operationName;

    MathOperations(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public String toString() {
        return operationName;
    }
}
