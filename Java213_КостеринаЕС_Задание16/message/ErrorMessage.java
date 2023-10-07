package org.top.applicationsquare.message;

public class ErrorMessage implements Message {
    private String error;
    public ErrorMessage(String message) {
        this.error = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
