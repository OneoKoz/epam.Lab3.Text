package com.epam.jwd.model;

public class Text extends AbstractNotation{

    @Override
    public String toString() {
        return "Text{" +
                "nodes=" + nodes +
                '}';
    }

    @Override
    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        nodes.forEach(item -> stringBuilder.append("\t").append(item.getText()).append("\n"));
        return stringBuilder.toString();
    }
}
