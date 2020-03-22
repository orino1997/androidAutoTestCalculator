public class MathematicalOperationsSteps {

    public int multiplicationOperation(int...numbers) {
        int resultNumber = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            resultNumber *= numbers[i];
        }
        return resultNumber;
    }

    public int subtractionOperation(int...numbers) {
        int resultNumber = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            resultNumber -= numbers[i];
        }
        return resultNumber;
    }

    public int additionOperation(int...numbers) {
        int resultNumber = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            resultNumber += numbers[i];
        }
        return resultNumber;
    }

}
