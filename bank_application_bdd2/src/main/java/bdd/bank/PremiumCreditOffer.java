package bdd.bank;

public class PremiumCreditOffer extends CreditOffer {

	public PremiumCreditOffer(String id) {
		super(id);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		if (customer.isVip()) {
			return customersSet.add(customer);
		}
		return false;
	}

	@Override
	public boolean removeCustomer(Customer customer) {
        if (customer.isVip()) {
            return customersSet.remove(customer);
        }
	    return false;
	}

}
