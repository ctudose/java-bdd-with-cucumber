package bdd.bank;

import java.util.*;

public abstract class CreditOffer {

	private String id;
    private int amount;
	Set<Customer> customersSet = new HashSet<Customer>();

	public CreditOffer(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public Set<Customer> getCustomersSet() {
		return Collections.unmodifiableSet(customersSet);
	}

	public abstract boolean addCustomer(Customer customer);

	public abstract boolean removeCustomer(Customer customer);

}
