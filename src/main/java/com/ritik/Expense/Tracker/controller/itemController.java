package com.ritik.Expense.Tracker.controller;

import com.ritik.Expense.Tracker.Services.itemService;
import com.ritik.Expense.Tracker.units.itemUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class itemController {
    @Autowired
    private itemService service;

    @PostMapping
    public void add(@RequestBody itemUnits item){
        service.add(item);
    }
    @GetMapping
    public List<itemUnits> print(){
        return service.output();
    }
}
