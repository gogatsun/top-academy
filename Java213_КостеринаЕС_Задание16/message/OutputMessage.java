package org.top.applicationsquare.message;


public record OutputMessage(Double radius, Double perimeter, Double square) implements Message {
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", perimeter=" + perimeter +
                ", square=" + square +
                '}';
    }
}
