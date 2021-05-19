package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractNotation implements TextInterface{

    protected final ArrayList<TextInterface> nodes = new ArrayList<>();

    @Override
    public List<TextInterface> getNodes() {
        return nodes;
    }

    public void addNode(TextInterface node) {
        nodes.add(node);
    }

    public void addNodes(List<TextInterface> nodes) {
        this.nodes.addAll(nodes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractNotation that = (AbstractNotation) o;
        return Objects.equals(nodes, that.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }
}
