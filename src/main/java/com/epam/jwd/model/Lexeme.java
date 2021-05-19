package com.epam.jwd.model;

public class Lexeme extends AbstractNotation{

    @Override
    public String toString() {
        return "Lexeme{" +
                "nodes=" + nodes +
                '}';
    }

    @Override
    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        nodes.forEach(item -> stringBuilder.append(item.getText()));
        return stringBuilder.toString();
    }
}
