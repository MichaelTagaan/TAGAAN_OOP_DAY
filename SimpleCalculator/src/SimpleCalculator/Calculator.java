package SimpleCalculator;

public class Calculator {
    
    public static double evaluateExpression(String expression) {
        try {
            String[] parts;
            double num1, num2;
            char operator;
            
            if (expression.contains("+")) {
                parts = expression.split("\\+");
                num1 = Double.parseDouble(parts[0]);
                num2 = Double.parseDouble(parts[1]);
                return num1 + num2;
            } else if (expression.contains("-")) {
                parts = expression.split("-");
                num1 = Double.parseDouble(parts[0]);
                num2 = Double.parseDouble(parts[1]);
                return num1 - num2;
            } else if (expression.contains("*")) {
                parts = expression.split("\\*");
                num1 = Double.parseDouble(parts[0]);
                num2 = Double.parseDouble(parts[1]);
                return num1 * num2;
            } else if (expression.contains("/")) {
                parts = expression.split("/");
                num1 = Double.parseDouble(parts[0]);
                num2 = Double.parseDouble(parts[1]);
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            } else {
                
                return Double.parseDouble(expression);
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        }
        }
}
  
