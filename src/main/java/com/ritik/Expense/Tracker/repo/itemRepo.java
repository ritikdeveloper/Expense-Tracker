package com.ritik.Expense.Tracker.repo;

import com.ritik.Expense.Tracker.units.itemUnits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itemRepo extends JpaRepository<itemUnits,Integer> {
}
