package com.misacfd.meshconverter;

import java.util.List;
import java.util.Objects;

public class NodeIdent {
    private final List<Long> idNode;

    protected NodeIdent(Builder<?> builder) {
        this.idNode = Objects.requireNonNull(builder.idNode, "idNode");
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<Long> getIdNode() {
        return idNode;
    }

    public static class Builder<T extends Builder<T>> {
        private List<Long> idNode;

        protected Builder() {
        }

        public T setIdNode(List<Long> idNode) {
            this.idNode = idNode;
            return (T) this;
        }

        public Builder of(NodeIdent nodeIdent) {
            this.idNode = nodeIdent.idNode;
            return this;
        }

        public NodeIdent build() {
            return new NodeIdent(this);
        }
    }
}
