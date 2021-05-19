package com.epam.jwd.iterpreter;

import com.epam.jwd.exception.InvalidOperatorException;

import java.util.List;
import java.util.Stack;

public class ExpressionFactory {

    public static ExpressionFactory instance = new ExpressionFactory();

    private final static String OPERATOR_PATTERN = "[~^&|]|(>>)|(<<)";
    private final static String UNARY_OPERATOR_PATTERN = "~";

    private ExpressionFactory() {
    }

    private boolean isOperator(String s) {
        return s.matches(OPERATOR_PATTERN);
    }

    private boolean isUnaryOperator(String s) {
        return s.matches(UNARY_OPERATOR_PATTERN);
    }

    private Expression create(String operator, Expression left, Expression right) {
        switch (operator) {
            case "&":
                return new AndExpression(left, right);
            case "|":
                return new OrExpression(left, right);
            case "^":
                return new XorExpression(left, right);
            case ">>":
                return new RightShiftExpression(left, right);
            case "<<":
                return new LeftShiftExpression(left, right);
            case "~":
                return new ComplementExpression(left);
        }
        return null;
    }

    public int countResult(List<String> tokens) throws InvalidOperatorException {
        Stack<Expression> stack = new Stack<>();
        for (String s : tokens) {
            if (isOperator(s)) {
                Expression rightExpression = null;
                if (!isUnaryOperator(s)) {
                    rightExpression = stack.pop();
                }
                Expression leftExpression = stack.pop();
                Expression operator = create(s, leftExpression, rightExpression);
                if (operator == null) {
                    throw new InvalidOperatorException(s);
                }
                int result = operator.interpret();
                stack.push(new TerminalExpression(result));
            } else {
                Expression i = new TerminalExpression(Integer.parseInt(s));
                stack.push(i);
            }
        }
        return stack.pop().interpret();
    }
}
