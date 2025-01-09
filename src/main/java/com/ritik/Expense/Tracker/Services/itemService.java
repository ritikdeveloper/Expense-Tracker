package com.ritik.Expense.Tracker.Services;

import com.ritik.Expense.Tracker.repo.itemRepo;
import com.ritik.Expense.Tracker.units.itemUnits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class itemService {

    private final itemRepo repo;

    @Autowired
    public itemService(itemRepo repo) {
        this.repo = repo;
    }

    // Add a new item with the current date
    public String add(itemUnits item) {
        item.setItemDate(LocalDate.now().toString());
        repo.save(item);
        return "Item added successfully";
    }

    // Retrieve all items
    public List<itemUnits> output() {
        return repo.findAll();
    }

    // Calculate the total price of all items
    public int total() {
        return output().stream()
                .mapToInt(itemUnits::getItemPrice)
                .sum();
    }

    // Filter items by target date
    public List<itemUnits> filter(String targetDate) {
      return  repo.findByItemDate(targetDate);
//        return output().stream()
//                .filter(item -> item.getItemDate().equals(targetDate))
//                .collect(Collectors.toList());
    }

    // Filter items by price less than or equal to the given price
    public List<itemUnits> filterPrice(int price) {

        return repo.findByItemPriceLessThanEqual(price);
//        return output().stream()
//                .filter(item -> item.getItemPrice() <= price)
//                .collect(Collectors.toList());
    }
}
