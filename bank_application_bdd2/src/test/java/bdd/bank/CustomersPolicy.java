package bdd.bank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomersPolicy {
    private CreditOffer creditOffer;
    private Customer mike;
    private Customer john;

    @Given("^there is an economy credit offer$")
    public void there_is_an_economy_credit_offer() throws Throwable {
        creditOffer = new EconomyCreditOffer("1");
    }

    @When("^we have a usual customer$")
    public void we_have_a_usual_customer() throws Throwable {
        mike = new Customer("Mike", false);
    }

    @Then("^you can add and remove him from an economy credit offer$")
    public void you_can_add_and_remove_him_from_an_economy_credit_offer() throws Throwable {
        assertAll("Verify all conditions for a usual customer and an economy credit offer",
                () -> assertEquals("1", creditOffer.getId()),
                () -> assertEquals(true, creditOffer.addCustomer(mike)),
                () -> assertEquals(1, creditOffer.getCustomersSet().size()),
                () -> assertTrue(creditOffer.getCustomersSet().contains(mike)),
                () -> assertEquals(true, creditOffer.removeCustomer(mike)),
                () -> assertEquals(0, creditOffer.getCustomersSet().size())
        );
    }

    @When("^we have a VIP customer$")
    public void we_have_a_VIP_customer() throws Throwable {
        john = new Customer("John", true);
    }

    @Then("^you can add him but cannot remove him from an economy credit offer$")
    public void you_can_add_him_but_cannot_remove_him_from_an_economy_credit_offer() throws Throwable {
        assertAll("Verify all conditions for a VIP customer and an economy credit offer",
                () -> assertEquals("1", creditOffer.getId()),
                () -> assertEquals(true, creditOffer.addCustomer(john)),
                () -> assertEquals(1, creditOffer.getCustomersSet().size()),
                () -> assertTrue(creditOffer.getCustomersSet().contains(john)),
                () -> assertEquals(false, creditOffer.removeCustomer(john)),
                () -> assertEquals(1, creditOffer.getCustomersSet().size())
        );
    }

    @Given("^there is an business credit offer$")
    public void there_is_an_business_credit_offer() throws Throwable {
        creditOffer = new BusinessCreditOffer("2");
    }

    @Then("^you cannot add or remove him from a business credit offer$")
    public void you_cannot_add_or_remove_him_from_a_business_credit_offer() throws Throwable {
        assertAll("Verify all conditions for a usual customer and a business credit offer",
                () -> assertEquals(false, creditOffer.addCustomer(mike)),
                () -> assertEquals(0, creditOffer.getCustomersSet().size()),
                () -> assertEquals(false, creditOffer.removeCustomer(mike)),
                () -> assertEquals(0, creditOffer.getCustomersSet().size())
        );
    }

    @Then("^you can add him but cannot remove him from a business credit offer$")
    public void you_can_add_him_but_cannot_remove_him_from_a_business_credit_offer() throws Throwable {
        assertAll("Verify all conditions for a VIP customer and a business credit offer",
                () -> assertEquals(true, creditOffer.addCustomer(john)),
                () -> assertEquals(1, creditOffer.getCustomersSet().size()),
                () -> assertEquals(false, creditOffer.removeCustomer(john)),
                () -> assertEquals(1, creditOffer.getCustomersSet().size())
        );
    }

    @Given("^there is an premium credit offer$")
    public void there_is_an_premium_credit_offer() throws Throwable {
        creditOffer = new PremiumCreditOffer("3");
    }

    @Then("^you cannot add or remove him from a premium credit offer$")
    public void you_cannot_add_or_remove_him_from_a_premium_credit_offer() throws Throwable {
        assertAll("Verify all conditions for a usual customer and a premium credit offer",
                () -> assertEquals(false, creditOffer.addCustomer(mike)),
                () -> assertEquals(0, creditOffer.getCustomersSet().size()),
                () -> assertEquals(false, creditOffer.removeCustomer(mike)),
                () -> assertEquals(0, creditOffer.getCustomersSet().size())
        );
    }

    @Then("^Then you can add and remove him from a premium credit offer$")
    public void then_you_can_add_and_remove_him_from_a_premium_credit_offer() throws Throwable {
        assertAll("Verify all conditions for a VIP customer and a premium credit offer",
                () -> assertEquals(true, creditOffer.addCustomer(john)),
                () -> assertEquals(1, creditOffer.getCustomersSet().size()),
                () -> assertEquals(true, creditOffer.removeCustomer(john)),
                () -> assertEquals(0, creditOffer.getCustomersSet().size())
        );
    }

    @Then("^you cannot add a usual customer to a credit offer more than once$")
    public void you_cannot_add_him_to_an_economy_credit_offer_more_than_once() throws Throwable {
        for (int i=0; i<10; i++) {
            creditOffer.addCustomer(mike);
        }
        assertAll("Verify a usual customer can be added to an economy credit offer only once",
                () -> assertEquals(1, creditOffer.getCustomersSet().size()),
                () -> assertTrue(creditOffer.getCustomersSet().contains(mike)),
                () -> assertTrue(new ArrayList<>(creditOffer.getCustomersSet()).get(0).getName().equals("Mike"))
        );
    }

    @Then("^you cannot add a VIP customer to a credit offer more than once$")
    public void you_cannot_add_a_VIP_customer_to_a_credit_offer_more_than_once() throws Throwable {
        for (int i=0; i<10; i++) {
            creditOffer.addCustomer(john);
        }
        assertAll("Verify a usual customer can be added to an economy credit offer only once",
                () -> assertEquals(1, creditOffer.getCustomersSet().size()),
                () -> assertTrue(creditOffer.getCustomersSet().contains(john)),
                () -> assertTrue(new ArrayList<>(creditOffer.getCustomersSet()).get(0).getName().equals("John"))
        );
    }
}
