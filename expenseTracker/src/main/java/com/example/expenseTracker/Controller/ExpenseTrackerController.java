package com.example.expenseTracker.Controller;

import com.example.expenseTracker.Entity.ExpenseEntity;
import com.example.expenseTracker.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/test")
public class ExpenseTrackerController {

    @Autowired
    private ExpenseService service;


    @GetMapping("/saveExpense")
   public void addExpense(@RequestBody ExpenseEntity expense){
       service.addExpense(expense);
   }

   public List<ExpenseEntity> getAllExpenses(){
       return service.getExpenseList();
   }

   public Optional<ExpenseEntity> getExpenseListById(@RequestParam int expenseId){
       return service.findById(expenseId);
   }

   public ExpenseEntity updateExpenseById(int id,ExpenseEntity expense){
       ExpenseEntity entity = service.updateExpenseById(id,expense);
       return entity;
   }

   public ResponseEntity<String> deleteExpenseById(@PathVariable  int  id){
       service.deleteById(id);
       return ResponseEntity.ok("Expense deleted successfully");
   }

   public List<ExpenseEntity> getExpenseListByCategory(String category){
       return service.getExpenseListByCategory(category);
   }

   public int getTotalExpense(){
       return service.getTotalExpense();
   }
}
