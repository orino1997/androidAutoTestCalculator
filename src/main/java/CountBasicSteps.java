public class CountBasicSteps {
    MathematicalOperationsSteps math = new MathematicalOperationsSteps();
    public int countResultForFixedNumberOperation(String operation, int...args) {
        int result = 0;
        if (operation.equalsIgnoreCase("умножение")) {
            result = math.multiplicationOperation(args);
        } else if (operation.equalsIgnoreCase("вычесть")) {
            result = math.subtractionOperation(args);
        } else if (operation.equalsIgnoreCase("сложить")) {
            result = math.additionOperation(args);
        }
        return result;
    }
}
