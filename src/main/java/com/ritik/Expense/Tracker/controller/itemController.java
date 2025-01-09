package com.ritik.Expense.Tracker.controller;

import com.ritik.Expense.Tracker.Services.itemService;
import com.ritik.Expense.Tracker.units.itemUnits;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class itemController {

    private final itemService service;

    @Autowired
    public itemController(itemService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody itemUnits item) {
        String response = service.add(item);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<itemUnits>> print() {
        List<itemUnits> items = service.output();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/total")
    public ResponseEntity<Integer> total() {
        int totalAmount = service.total();
        return new ResponseEntity<>(totalAmount, HttpStatus.OK);
    }

    @GetMapping("/filter/date/{date}")
    public ResponseEntity<List<itemUnits>> filterDate(@PathVariable String date) {
        List<itemUnits> filteredItems = service.filter(date);
        if (filteredItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(filteredItems, HttpStatus.OK);
    }

    @GetMapping("/filter/price/{price}")
    public ResponseEntity<List<itemUnits>> filterPrice(@PathVariable int price) {
        List<itemUnits> filteredItems = service.filterPrice(price);
        if (filteredItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(filteredItems, HttpStatus.OK);
    }
}
