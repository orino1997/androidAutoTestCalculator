public class CountBasicSteps {
    private MathematicalOperationsSteps math = new MathematicalOperationsSteps();

    public int countResultForFixedNumberOperation(MathOperations operation, int...numbers) {
        int result = 0;
        if (operation.equals(MathOperations.MULTIPLICATION)) {
            result = math.multiplicationOperation(numbers);
        } else if (operation.equals(MathOperations.SUBTRACTION)) {
            result = math.subtractionOperation(numbers);
        } else if (operation.equals(MathOperations.ADDITION)) {
            result = math.additionOperation(numbers);
        }
        return result;
    }
}
