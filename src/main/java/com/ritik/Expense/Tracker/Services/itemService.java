package com.ritik.Expense.Tracker.Services;

import com.ritik.Expense.Tracker.repo.itemRepo;
import com.ritik.Expense.Tracker.units.itemUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class itemService {
    @Autowired
    private itemRepo Repo;
    public String add(itemUnits item){
        item.setItemDate(new Date().toString());
        Repo.save(item);
    return "done";
    }
    public List<itemUnits> output(){
        return Repo.findAll();
    }

}
