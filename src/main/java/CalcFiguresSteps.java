public class CalcFiguresSteps {
    public int intParse(String figureName) {
        return Integer.parseInt(figureName.replace("−", "-"));
    }
}
