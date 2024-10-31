package com.example.spring_boot_functional_Interfaces.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_functional_Interfaces.dto.OperationBody;

@RestController
@RequestMapping("/spaghetti")
public class SpaghettiConditionalsController {

    @PostMapping("/calc")
    public ResponseEntity<Double> calc(@RequestBody OperationBody operation) {

        double result = 0;

        if (operation.getOp().equals("add")) {
            result = operation.getA() + operation.getB();
        } else if (operation.getOp().equals("subtract")) {
            result = operation.getA() - operation.getB();
        } else if (operation.getOp().equals("multiply")) {
            result = operation.getA() * operation.getB();
        } else if (operation.getOp().equals("divide")) {
            result = (double) operation.getA() / operation.getB();
        } else {
            throw new UnsupportedOperationException("Invalid operation");
        }

        return ResponseEntity.ok(result);
    }

}
