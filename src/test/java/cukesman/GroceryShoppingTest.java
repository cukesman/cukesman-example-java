package cukesman;

import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.List;

public class GroceryShoppingTest extends AbstractJBehaveStories {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new GrocerySteps());
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("Grocery_Shopping.feature");
    }

}
