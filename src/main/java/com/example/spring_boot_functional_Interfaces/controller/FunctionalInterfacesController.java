package com.example.spring_boot_functional_Interfaces.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_functional_Interfaces.dto.OperationBody;
import com.example.spring_boot_functional_Interfaces.interfaces.Operation;

@RestController
@RequestMapping("/functional")
public class FunctionalInterfacesController {

    @PostMapping("/calc")
    public ResponseEntity<Double> calc(@RequestBody OperationBody operationBody) {
        Map<String, Operation> operations = new HashMap<>();
        operations.put("add", (x, y) -> x + y);
        operations.put("subtract", (x, y) -> x - y);
        operations.put("multiply", (x, y) -> x * y);
        operations.put("divide", (x, y) -> x / y);

        double result = 0;

        Operation selectedOperation = operations.get(operationBody.getOp());
        if (selectedOperation != null) {
            result = selectedOperation.apply(operationBody.getA(), operationBody.getB());
        } else {
            throw new UnsupportedOperationException("Invalid operation");
        }

        return ResponseEntity.ok(result);
    }

}
