package th.co.cdgs.numberToAlphabet;

public class NumberToAlphabet {

    public String decript(String input) {
        String[] parts = input.split("#");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            int number = Integer.parseInt(part);
            char alphabet = (char) ('a' + number - 1);
            result.append(alphabet);
        }

        return result.toString();
    }
}