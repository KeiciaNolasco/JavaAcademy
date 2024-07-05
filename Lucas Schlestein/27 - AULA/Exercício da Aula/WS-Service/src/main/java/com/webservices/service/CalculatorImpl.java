package com.webservices.service;


import jakarta.jws.WebService;

@WebService(endpointInterface = "com.webservices.service.Calculator")
public class CalculatorImpl implements Calculator {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double div(double a, double b) {
        return a * b;
    }

    @Override
    public double mult(double a, double b) {
        return a / b;
    }

}
