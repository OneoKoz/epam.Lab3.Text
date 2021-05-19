package com.epam.jwd.iterpreter;

import java.util.*;

public class InfixToPostfixConverter {

    private final Map<String, Integer> precedenceMap = new HashMap<>();

    public InfixToPostfixConverter() {
        precedenceMap.put("|", 1);
        precedenceMap.put("^", 2);
        precedenceMap.put("&", 3);
        precedenceMap.put(">>", 4);
        precedenceMap.put("<<", 4);
        precedenceMap.put("~", 5);
    }

    private int getPrecedence(String c) {
        Integer precedence = precedenceMap.get(c);
        return precedence != null ? precedence : -1;
    }

    public List<String> infixToPostfix(String exp) {
        List<String> resultList = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        StringBuilder number = new StringBuilder();
        StringBuilder operator;
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (!number.toString().isBlank()) {
                    resultList.add(number.toString());
                    number = new StringBuilder();
                }
                if (c == '(') {
                    stack.push(String.valueOf(c));
                } else if (c == ')') {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        resultList.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    operator = new StringBuilder();
                    if (c == '<' || c == '>') {
                        operator.append(c).append(c);
                        i++;
                    } else {
                        operator.append(c);
                    }
                    while (!stack.isEmpty() && getPrecedence(operator.toString()) <= getPrecedence(stack.peek())) {
                        resultList.add(stack.pop());
                    }
                    stack.push(operator.toString());
                }
            }
        }
        if (!number.toString().isBlank()) {
            resultList.add(number.toString());
        }
        while (!stack.isEmpty()) {
            resultList.add(stack.pop());
        }
        return resultList;
    }
}
