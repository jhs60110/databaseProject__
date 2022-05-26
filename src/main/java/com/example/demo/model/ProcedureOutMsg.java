package com.example.demo.model;

public class ProcedureOutMsg {
    private String successYN;
    private String errorMessage;

    public String getSuccessYN() {
        return successYN;
    }

    public void setSuccessYN(String successYN) {
        this.successYN = successYN;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ProcedureOutMsg{" +
                "successYN='" + successYN + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}