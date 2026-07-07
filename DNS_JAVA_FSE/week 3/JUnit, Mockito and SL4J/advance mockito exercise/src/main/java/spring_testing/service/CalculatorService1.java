package spring_testing.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService1 {

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        return a / b;
    }
    public void processData() throws InterruptedException {

    Thread.sleep(1000);

}

}