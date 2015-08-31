package com.itstep.ppjava13v1.student.viktorK.core;


import java.util.LinkedList;

/**
 * Created by on 14.01.2015.
 *
 * @author Viktor
 */
public class MathCal {

    public static double eval(StringBuffer mathematicalExpressions) {
        LinkedList<Double> numbers = new LinkedList<Double>(); // сюда наваливают цифры
        LinkedList<Character> operators = new LinkedList<Character>(); // сюда опрераторы и numbers и operators в порядке поступления
        for (int i = 0; i < mathematicalExpressions.length(); i++) { // парсим строку с выражением и вычисляем
            char c = mathematicalExpressions.charAt(i);
            if (isSpace(c))
                continue;
            if (c == '(')
                operators.add('(');
            else if (c == ')') {
                while (operators.getLast() != '(')
                    processOperator(numbers, operators.removeLast());
                operators.removeLast();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && priority(operators.getLast()) >= priority(c))
                    processOperator(numbers, operators.removeLast());
                operators.add(c);
            } else {
                String operand = "";
                while (i < mathematicalExpressions.length() && Character.isDigit(mathematicalExpressions.charAt(i)))
                    operand += mathematicalExpressions.charAt(i++);
                --i;
                numbers.add(Double.parseDouble(operand));
            }
        }
        while (!operators.isEmpty())
            processOperator(numbers, operators.removeLast());
        return numbers.get(0); // возврат результата
    }

    private static void processOperator(LinkedList<Double> numbers, char operation) {
        double r = numbers.removeLast(); // выдёргиваем из упорядоченного листа последний элемент
        double l = numbers.removeLast(); // также
        switch (operation) { // выполняем действие между l и r в зависимости от оператора в кейсе и результат валим в numbers
            case '+':
                numbers.add(l + r);
                break;
            case '-':
                numbers.add(l - r);
                break;
            case '*':
                numbers.add(l * r);
                break;
            case '/':
                numbers.add(l / r);
                break;
            case '%':
                numbers.add(l % r);
                break;
        }
    }

    private static boolean isSpace(char c) { // тру если пробел
        return c == ' ';
    }

    private static boolean isOperator(char operation) { // возвращяем тру если один из символов ниже
        return operation == '+' || operation == '-' || operation == '*' || operation == '/' || operation == '%';
    }

    private static int priority(char operation) {
        switch (operation) { // при + или - возврат 1, при * / % 2 иначе -1
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }

}

