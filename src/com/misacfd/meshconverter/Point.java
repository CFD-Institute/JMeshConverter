package com.misacfd.meshconverter;

import java.util.Objects;

public class Point {
    private final double x;
    private final double y;
    private final double z;
    private final long ident;

    private Point(Builder builder) {
        this.x = Objects.requireNonNull(builder.x, "x");
        this.y = Objects.requireNonNull(builder.y, "y");
        this.z = Objects.requireNonNull(builder.z, "z");
        this.ident = Objects.requireNonNull(builder.ident, "ident");
    }

    public static Builder builder() {
        return new Builder();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public long getIdent() {
        return ident;
    }

    public static class Builder {
        private Double x;
        private Double y;
        private Double z;
        private Long ident;

        private Builder() {
        }

        public Builder setX(double x) {
            this.x = x;
            return this;
        }

        public Builder setY(double y) {
            this.y = y;
            return this;
        }

        public Builder setZ(double z) {
            this.z = z;
            return this;
        }

        public Builder setIdent(long ident) {
            this.ident = ident;
            return this;
        }

        public Builder of(Point point) {
            this.x = point.x;
            this.y = point.y;
            this.z = point.z;
            this.ident = point.ident;
            return this;
        }

        public Point build() {
            return new Point(this);
        }
    }
}
