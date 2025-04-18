package com.smartfinance.expensetracker.controller;

import com.smartfinance.expensetracker.model.Expense;
import com.smartfinance.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/{userEmail}")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense, @PathVariable String userEmail) {
        return ResponseEntity.ok(expenseService.addExpense(expense, userEmail));
    }

    @GetMapping("/{userEmail}")
    public ResponseEntity<List<Expense>> getUserExpenses(@PathVariable String userEmail) {
        return ResponseEntity.ok(expenseService.getUserExpenses(userEmail));
    }

    @GetMapping("/{email}/summary")
    public ResponseEntity<Map<String, Double>> getExpenseSummary(
            @PathVariable String email,
            @RequestParam String range) {
        return ResponseEntity.ok(expenseService.getExpenseSummary(email, range));
    }
}