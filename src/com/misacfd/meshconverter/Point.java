package com.misacfd.meshconverter;

import java.util.Objects;

public class Point {
    private final double x;
    private final double y;
    private final double z;

    private Point(Builder builder) {
        this.x = Objects.requireNonNull(builder.x, "x");
        this.y = Objects.requireNonNull(builder.y, "y");
        this.z = Objects.requireNonNull(builder.z, "z");
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


    public static class Builder {
        private Double x;
        private Double y;
        private Double z;

        Builder() {
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

        public Builder of(Point point) {
            this.x = point.x;
            this.y = point.y;
            this.z = point.z;
            return this;
        }

        public Point build() {
            return new Point(this);
        }
    }
}
