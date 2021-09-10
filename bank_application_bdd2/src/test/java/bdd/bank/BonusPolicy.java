package bdd.bank;

import bdd.bonus.Bonus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusPolicy {
    private Customer mike;
    private Customer john;
    private Bonus bonus = new Bonus();

    @Given("^we have a usual customer with credit offers$")
    public void we_have_a_usual_customer_with_credit_offers() throws Throwable {
        mike = new Customer("Mike", false);
    }

    @When("^the usual customer has credit offers with amounts (\\d+) and (\\d+) and (\\d+)$")
    public void the_usual_customer_has_credit_offers_with_amounts_and_and(int amount1, int amount2, int amount3) throws Throwable {
        bonus.addAmount(mike, amount1);
        bonus.addAmount(mike, amount2);
        bonus.addAmount(mike, amount3);
    }

    @Then("^the bonus points of the usual customer should be (\\d+)$")
    public void the_bonus_points_of_the_usual_customer_should_be(int points) throws Throwable {
        bonus.calculateGivenPoints();
        assertEquals(points, bonus.getCustomersPointsMap().get(mike).intValue());
    }

    @Given("^we have a VIP customer with credit offers$")
    public void we_have_a_VIP_customer_with_credit_offers() throws Throwable {
        john = new Customer("John", true);
    }

    @When("^the VIP customer has credit offers with amounts (\\d+) and (\\d+) and (\\d+)$")
    public void the_VIP_customer_has_credit_offers_with_amounts_and_and(int amount1, int amount2, int amount3) throws Throwable {
        bonus.addAmount(john, amount1);
        bonus.addAmount(john, amount2);
        bonus.addAmount(john, amount3);
    }

    @Then("^the bonus points of the VIP customer should be (\\d+)$")
    public void the_bonus_points_of_the_VIP_customer_should_be(int points) throws Throwable {
        bonus.calculateGivenPoints();
        assertEquals(points, bonus.getCustomersPointsMap().get(john).intValue());
    }

}
