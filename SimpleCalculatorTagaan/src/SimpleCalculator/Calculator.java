package SimpleCalculator;

import java.util.Stack;

public class Calculator {

    public Calculator() {
    }

    public double calculate(String expression) throws ArithmeticException {
        String[] tokens = expression.split("\\s+");
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                operands.push(Double.valueOf(token));
            } else if (isOperator(token)) {
                char operator = token.charAt(0);
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(operator)) {
                    processOperator(operands, operators);
                }
                operators.push(operator);
            } else if (token.equals("√")) {
                operands.push(Math.sqrt(operands.pop()));
            } else if (token.equals("^2")) { 
                double operand = operands.pop();
                operands.push(operand * operand);
            } else if (token.equals("%")) {
                double operand2 = operands.pop();
                double operand1 = operands.pop();
                operands.push(operand1 % operand2);
            } else if (token.equals("-")) { 
                if (operands.isEmpty()) {
                    operands.push(-1.0);
                    operators.push('*'); 
                } else {
                    operands.push(-operands.pop());
                }
            }
        }

        while (!operators.isEmpty()) {
            processOperator(operands, operators);
        }

        if (operands.size() != 1) {
            throw new IllegalArgumentException("Invalid expression format");
        }

        return operands.pop();
    }

    private boolean isNumber(String token) {
        try {
            Double.valueOf(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return token.length() == 1 && "+-*/".contains(token);
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/', '%' -> {
                return 2;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private void processOperator(Stack<Double> operands, Stack<Character> operators) {
        double operand2 = operands.pop();
        double operand1 = operands.pop();
        char operator = operators.pop();
        switch (operator) {
            case '+' -> operands.push(operand1 + operand2);
            case '-' -> operands.push(operand1 - operand2);
            case '*' -> operands.push(operand1 * operand2);
            case '/' -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                operands.push(operand1 / operand2);
            }
            case '%' -> operands.push(operand1 % operand2);
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
