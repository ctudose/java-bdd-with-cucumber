package bdd.bank;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerPolicy {
    private CreditOffer economyCreditOffer;
    private CreditOffer businessCreditOffer;
    private Customer mike;
    private Customer john;

    @Given("^there is an economy credit offer$")
    public void thereIsAnEconomyCreditOffer() throws Throwable {
        economyCreditOffer = new EconomyCreditOffer("1");
    }

    @When("^we have a usual customer$")
    public void weHaveAUsualCustomer() throws Throwable {
        mike = new Customer("Mike", false);
    }

    @Then("^you can add and remove him from an economy credit offer$")
    public void youCanAddAndRemoveHimFromAnEconomyCreditOffer() throws Throwable {
        assertAll("Verify all conditions for a usual customer and an economy credit offer",
                () -> assertEquals("1", economyCreditOffer.getId()),
                () -> assertEquals(true, economyCreditOffer.addCustomer(mike)),
                () -> assertEquals(1, economyCreditOffer.getCustomersSet().size()),
                () -> assertTrue(economyCreditOffer.getCustomersSet().contains(mike)),
                () -> assertEquals("Mike", new ArrayList<Customer>(economyCreditOffer.getCustomersSet()).get(0).getName()),
                () -> assertEquals(true, economyCreditOffer.removeCustomer(mike)),
                () -> assertEquals(0, economyCreditOffer.getCustomersSet().size())
        );
    }

    @When("^we have a VIP customer$")
    public void weHaveAVIPCustomer() throws Throwable {
        john = new Customer("John", true);
    }

    @Then("^you can add him but cannot remove him from an economy credit offer$")
    public void youCanAddHimButCannotRemoveHimFromAnEconomyCreditOffer() throws Throwable {
        assertAll("Verify all conditions for a VIP customer and an economy credit offer",
                () -> assertEquals("1", economyCreditOffer.getId()),
                () -> assertEquals(true, economyCreditOffer.addCustomer(john)),
                () -> assertEquals(1, economyCreditOffer.getCustomersSet().size()),
                () -> assertTrue(economyCreditOffer.getCustomersSet().contains(john)),
                () -> assertEquals("John", new ArrayList<Customer>(economyCreditOffer.getCustomersSet()).get(0).getName()),
                () -> assertEquals(false, economyCreditOffer.removeCustomer(john)),
                () -> assertEquals(1, economyCreditOffer.getCustomersSet().size())
        );
    }

    @Given("^there is an business credit offer$")
    public void thereIsAnBusinessCreditOffer() throws Throwable {
        businessCreditOffer = new BusinessCreditOffer("2");
    }

    @Then("^you cannot add or remove him from a business credit offer$")
    public void youCannotAddOrRemoveHimFromABusinessCreditOffer() throws Throwable {
        assertAll("Verify all conditions for a usual customer and a business credit offer",
                () -> assertEquals(false, businessCreditOffer.addCustomer(mike)),
                () -> assertEquals(0, businessCreditOffer.getCustomersSet().size()),
                () -> assertEquals(false, businessCreditOffer.removeCustomer(mike)),
                () -> assertEquals(0, businessCreditOffer.getCustomersSet().size())
        );
    }

    @Then("^you can add him but cannot remove him from a business credit offer$")
    public void youCanAddHimButCannotRemoveHimFromABusinessCreditOffer() throws Throwable {
        assertAll("Verify all conditions for a VIP customer and a business credit offer",
                () -> assertEquals(true, businessCreditOffer.addCustomer(john)),
                () -> assertEquals(1, businessCreditOffer.getCustomersSet().size()),
                () -> assertEquals(false, businessCreditOffer.removeCustomer(john)),
                () -> assertEquals("John", new ArrayList<Customer>(businessCreditOffer.getCustomersSet()).get(0).getName()),
                () -> assertEquals(1, businessCreditOffer.getCustomersSet().size())
        );
    }
}
