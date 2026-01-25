package com.example.expenseTracker.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ExpenseTrackerController {

    @GetMapping("/getList")
    public void getListOfItems() {
        System.out.println("this are also the list of items to be added");
    }
}
