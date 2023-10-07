package org.top.applicationsquare.message;

public class InputMessage implements Message {
    private Double radius;

    public InputMessage(Double radius) {
        this.radius = radius;
    }

    public InputMessage() {}

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

}
