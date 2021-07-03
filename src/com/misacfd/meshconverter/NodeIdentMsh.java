package com.misacfd.meshconverter;

import java.util.Objects;

public class NodeIdentMsh extends NodeIdent {
    private final long ident;
    private final long elemTyp;
    private final long nbTags;
    private final long tag1;
    private final long tag2;

    private NodeIdentMsh(Builder builder) {
        super(builder);
        this.ident = Objects.requireNonNull(builder.ident, "ident");
        this.elemTyp = Objects.requireNonNull(builder.elemTyp, "elemTyp");
        this.nbTags = Objects.requireNonNull(builder.nbTags, "nbTags");
        this.tag1 = Objects.requireNonNull(builder.tag1, "tag1");
        this.tag2 = Objects.requireNonNull(builder.tag2, "tag2");
    }

    public static Builder builder() {
        return new Builder();
    }

    public long getIdent() {
        return ident;
    }

    public long getElemTyp() {
        return elemTyp;
    }

    public long getNbTags() {
        return nbTags;
    }

    public long getTag1() {
        return tag1;
    }

    public long getTag2() {
        return tag2;
    }

    public static class Builder extends NodeIdent.Builder<Builder> {
        private Long ident;
        private Long elemTyp;
        private Long nbTags;
        private Long tag1;
        private Long tag2;

        private Builder() {
            super();
        }

        public Builder setIdent(long ident) {
            this.ident = ident;
            return this;
        }

        public Builder setElemTyp(long elemTyp) {
            this.elemTyp = elemTyp;
            return this;
        }

        public Builder setNbTags(long nbTags) {
            this.nbTags = nbTags;
            return this;
        }

        public Builder setTag1(long tag1) {
            this.tag1 = tag1;
            return this;
        }

        public Builder setTag2(long tag2) {
            this.tag2 = tag2;
            return this;
        }

        public Builder of(NodeIdentMsh nodeIdentMsh) {
            this.ident = nodeIdentMsh.ident;
            this.elemTyp = nodeIdentMsh.elemTyp;
            this.nbTags = nodeIdentMsh.nbTags;
            this.tag1 = nodeIdentMsh.tag1;
            this.tag2 = nodeIdentMsh.tag2;
            return this;
        }

        public NodeIdentMsh build() {
            return new NodeIdentMsh(this);
        }
    }
}
