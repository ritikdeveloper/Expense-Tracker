package com.ritik.Expense.Tracker.units;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class itemUnits {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String itemName;
    private int itemPrice;
    private String itemDate;
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for itemName
    public String getItemName() {
        return itemName;
    }

    // Setter for itemName
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    // Getter for itemPrice
    public int getItemPrice() {
        return itemPrice;
    }

    // Setter for itemPrice
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    // Getter for itemDate
    public String getItemDate() {
        return itemDate;
    }

    // Setter for itemDate
    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }


}
