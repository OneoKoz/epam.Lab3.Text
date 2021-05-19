package com.epam.jwd.iterpreter;

public class ComplementExpression implements Expression {

    private final Expression expression;

    public ComplementExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public int interpret() {
        return ~expression.interpret();
    }
}
