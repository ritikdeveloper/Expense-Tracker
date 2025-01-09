package com.ritik.Expense.Tracker.repo;

import com.ritik.Expense.Tracker.units.itemUnits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface itemRepo extends JpaRepository<itemUnits,Integer> {

    List<itemUnits> findByItemPriceLessThanEqual(int price);
    List<itemUnits> findByItemDate(String date);
}
