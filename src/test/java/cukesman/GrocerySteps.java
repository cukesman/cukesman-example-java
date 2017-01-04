package cukesman;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class GrocerySteps {

    @Given("I go to the bakery")
    public void givenIGoToTheBakery() {
        System.out.print("Going to the bakery.");
    }

    @When("I buy $count bread")
    public void whenIBuyBread(int count) {
        System.out.print("Buying " + count + " bread.");
    }

    @When("I buy $count croissants")
    public void whenIBuyCroissant(int count) {
        System.out.print("Buying " + count + " croissants.");
    }

    @Then("I have to pay $count EUR")
    public void thenIHaveToPay(int count) {
        System.out.print("Having to pay " + count + " EUR.");
    }
}
