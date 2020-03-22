public class MathematicalOperationsSteps {

    public int multiplicationOperation(int...args) {
        int resultNumber = args[0];
        for(int i = 1; i < args.length; i++) {
            resultNumber *= args[i];
        }
        return resultNumber;
    }

    public int subtractionOperation(int...args) {
        int resultNumber = args[0];
        for(int i = 1; i < args.length; i++) {
            resultNumber -= args[i];
        }
        return resultNumber;
    }

    public int additionOperation(int...args) {
        int resultNumber = args[0];
        for(int i = 1; i < args.length; i++) {
            resultNumber += args[i];
        }
        return resultNumber;
    }

}
