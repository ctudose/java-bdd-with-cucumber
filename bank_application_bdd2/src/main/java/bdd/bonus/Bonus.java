package bdd.bonus;

import bdd.bank.Customer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Bonus {


    public static final int VIP_FACTOR = 10;
    public static final int USUAL_FACTOR = 20;

    private Map<Customer, Integer> customersAmountMap = new HashMap<>();
    private Map<Customer, Integer> customersPointsMap = new HashMap<>();

    public Map<Customer, Integer> getCustomersPointsMap() {
        return Collections.unmodifiableMap(customersPointsMap);
    }

    public void addAmount(Customer customer, int amount) {
        if (customersAmountMap.containsKey(customer)) {
            customersAmountMap.put(customer, customersAmountMap.get(customer) + amount);
        } else {
            customersAmountMap.put(customer, amount);
        }
    }

    public void calculateGivenPoints() {
        for (Customer customer : customersAmountMap.keySet()) {
            if (customer.isVip()) {
                customersPointsMap.put(customer, customersAmountMap.get(customer)/ VIP_FACTOR);
            } else {
                customersPointsMap.put(customer, customersAmountMap.get(customer)/ USUAL_FACTOR);
            }
        }
    }
}
