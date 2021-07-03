package com.misacfd.meshconverter;

import java.util.Objects;

public class NodeIdentMsh extends NodeIdent {
    private final long ident;
    private final int elemTyp;
    private final int nbTags;
    private final int tag1;
    private final int tag2;

    NodeIdentMsh(Builder builder) {
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

    public int getElemTyp() {
        return elemTyp;
    }

    public int getNbTags() {
        return nbTags;
    }

    public int getTag1() {
        return tag1;
    }

    public int getTag2() {
        return tag2;
    }

    public static class Builder extends NodeIdent.Builder<Builder> {
        private Long ident;
        private Integer elemTyp;
        private Integer nbTags;
        private Integer tag1;
        private Integer tag2;

        Builder() {
            super();
        }

        public Builder setIdent(long ident) {
            this.ident = ident;
            return this;
        }

        public Builder setElemTyp(int elemTyp) {
            this.elemTyp = elemTyp;
            return this;
        }

        public Builder setNbTags(int nbTags) {
            this.nbTags = nbTags;
            return this;
        }

        public Builder setTag1(int tag1) {
            this.tag1 = tag1;
            return this;
        }

        public Builder setTag2(int tag2) {
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
