package com.example.expenseTracker.Service;

import com.example.expenseTracker.Entity.ExpenseEntity;
import com.example.expenseTracker.Repository.ExpenseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;
    public void addExpense(ExpenseEntity expense) {
        expenseRepo.save(expense);
    }

    public List<ExpenseEntity> getExpenseList() {
        return expenseRepo.getExpenseList();
    }

    public Optional<ExpenseEntity> findById(int expenseId) {
       return expenseRepo.findById(expenseId);
    }

    public ExpenseEntity updateExpenseById(int id,ExpenseEntity entity) {
        ExpenseEntity entityExisisting = expenseRepo.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
        entityExisisting.setAmount(entity.getAmount());
        entityExisisting.setDate(entity.getDate());
        entityExisisting.setCategory(entity.getCategory());
        entityExisisting.setDescription(entity.getDescription());
        entityExisisting.setTitle(entity.getTitle());
        return expenseRepo.save(entityExisisting);

    }

    public  void deleteById(int id) {
        if(expenseRepo.findById(id).isEmpty()){
            throw new RuntimeException("Expense item doesn't found"+id);
        }
        expenseRepo.deleteById(id);
    }

    public List<ExpenseEntity> getExpenseListByCategory(String category) {
        return expenseRepo.findByCategory(category);
    }

    public List<ExpenseEntity> getByTitle(String keyword){
        return expenseRepo.findByTitle(keyword);
    }

    public int getTotalExpense() {
        return expenseRepo.getTotalExpense();
    }


}
