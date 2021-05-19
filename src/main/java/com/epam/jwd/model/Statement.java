package com.epam.jwd.model;

import java.util.List;

public class Statement implements TextInterface{

    private final String node;

    public Statement(String node) {
        this.node = node;
    }

    public String getNode() {
        return node;
    }

    @Override
    public List<TextInterface> getNodes() {
        return null;
    }

    @Override
    public String getText() {
        return getNode();
    }
}
