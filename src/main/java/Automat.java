public class Automat {
    public int amountOfStates;
    public String[][] matrix;
    public int priority;
    public String name;

    public Automat() {
        amountOfStates = 0;
        matrix = new String[amountOfStates][amountOfStates];
        priority = 0;
        name = "";
    }

    public Pair<Boolean, Integer>max(String input, int skip) {
        int amount = 0;
        boolean is = false;
        for(int i = skip, j = 0; i < input.length(); i++) {
            for(int k = 0; k < amountOfStates; k++) {
                String tmp = String.valueOf(input.charAt(i));
                if (matrix[j][k].contains(tmp)) {
                    j = k;
                    amount++;
                    is = true;
                    break;
                }
                if (k == amountOfStates - 1) {
                    return new Pair<>(is, amount);
                }
            }
        }
        return new Pair<>(is, amount);
    }
}