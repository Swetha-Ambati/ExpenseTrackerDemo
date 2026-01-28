package com.example.expenseTracker.Repository;

import com.example.expenseTracker.Entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepo extends JpaRepository<ExpenseEntity,Long> {

     ExpenseEntity save(ExpenseEntity expense);
    @Query("select e from ExpenseEntity e")
     List<ExpenseEntity> getExpenseList();
     Optional<ExpenseEntity> findById(int expenseId);
     void deleteById(int id);

//    @Query("select * from expenseentity e where e.category like %:keyword%")
     List<ExpenseEntity> findByCategory(@Param("keyword") String keyword);

//    @Query("select * from expenseentity e where e.title like %:keyword%")
//     List<ExpenseEntity> getExpenseByTitle(@Param("keyword") String keyword);

     List<ExpenseEntity> findByTitle(@Param("keyword") String keyword);

    @Query("select SUM(amount) from ExpenseEntity")
     int getTotalExpense();
}
