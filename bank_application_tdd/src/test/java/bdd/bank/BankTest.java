package bdd.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    public void testEconomyCreditOfferUsualCustomer() {
        CreditOffer economyCreditOffer = new EconomyCreditOffer("1");
        Customer mike = new Customer("Mike", false);

        assertEquals("1", economyCreditOffer.getId());
        assertEquals(true, economyCreditOffer.addCustomer(mike));
        assertEquals(1, economyCreditOffer.getCustomersList().size());
        assertEquals("Mike", economyCreditOffer.getCustomersList().get(0).getName());

        assertEquals(true, economyCreditOffer.removeCustomer(mike));
        assertEquals(0, economyCreditOffer.getCustomersList().size());
    }

    @Test
    public void testEconomyCreditOfferVipCustomer() {
        CreditOffer economyCreditOffer = new EconomyCreditOffer("1");
        Customer john = new Customer("John", true);

        assertEquals("1", economyCreditOffer.getId());
        assertEquals(true, economyCreditOffer.addCustomer(john));
        assertEquals(1, economyCreditOffer.getCustomersList().size());
        assertEquals("John", economyCreditOffer.getCustomersList().get(0).getName());

        assertEquals(false, economyCreditOffer.removeCustomer(john));
        assertEquals(1, economyCreditOffer.getCustomersList().size());
    }

    @Test
    public void testBusinessCreditOfferUsualCustomer() {
        CreditOffer businessCreditOffer = new BusinessCreditOffer("2");

        Customer mike = new Customer("Mike", false);

        assertEquals(false, businessCreditOffer.addCustomer(mike));
        assertEquals(0, businessCreditOffer.getCustomersList().size());
        assertEquals(false, businessCreditOffer.removeCustomer(mike));
        assertEquals(0, businessCreditOffer.getCustomersList().size());

    }

    @Test
    public void testBusinessCreditOfferVipCustomer() {
        CreditOffer businessCreditOffer = new BusinessCreditOffer("2");

        Customer john = new Customer("John", true);

        assertEquals(true, businessCreditOffer.addCustomer(john));
        assertEquals(1, businessCreditOffer.getCustomersList().size());
        assertEquals(false, businessCreditOffer.removeCustomer(john));
        assertEquals(1, businessCreditOffer.getCustomersList().size());

    }
}
