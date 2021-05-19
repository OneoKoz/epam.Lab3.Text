package com.epam.jwd.model;

public class Sentence extends AbstractNotation {

    @Override
    public String toString() {
        return "Sentence{" +
                "nodes=" + nodes +
                '}';
    }

    @Override
    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        nodes.forEach(item -> stringBuilder.append(item.getText()).append(" "));
        return stringBuilder.toString();
    }
}
