package sample;

/**
 * Created by Volker on 16.02.17.
 */
public class Model {
    public double calculate(double number1, double number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    return 0;
                }
                return number1 / number2;
/*              case "rt":
                double root = Math.sqrt(number1);
                return root; */
            case "^":
                return Math.pow(number1, number2);
  /*          case "x!":
                int j = (int) number1;
                long sum = 0;
                for (int i = 0; i < number1; i++) {
                    sum += j;
                    j--;
                }
                return sum;
            case "+/-":
                return -number1;*/
        }
        System.out.println("Unknown Operator");
        return 0;
    }

    public double changeSign(double number) {
        return -number;

    }


    public double factorize(double number) {
        double sum = 0;
        number = (int) number;
        int counter = (int) number;

        for (int i = 0; i < counter; i++) {
            sum += number;
            number--;
        }
        return sum;
    }

    public double sqrt(double number) {
        return Math.sqrt(number);
    }
}