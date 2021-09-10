package bdd.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class CreditOffer {

	private String id;
	List<Customer> customersList = new ArrayList<Customer>();

	public CreditOffer(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public List<Customer> getCustomersList() {
		return Collections.unmodifiableList(customersList);
	}

	public abstract boolean addCustomer(Customer customer);

	public abstract boolean removeCustomer(Customer customer);

}
