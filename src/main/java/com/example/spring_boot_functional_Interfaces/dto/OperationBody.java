package com.example.spring_boot_functional_Interfaces.dto;

public class OperationBody {
    private int a;
    private int b;
    private String op;

    public OperationBody(int a, int b, String op) {
        this.a = a;
        this.b = b;
        this.op = op;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public int getB() {
        return b;
    }
    public void setB(int b) {
        this.b = b;
    }
    public String getOp() {
        return op;
    }
    public void setOp(String op) {
        this.op = op;
    }
}
