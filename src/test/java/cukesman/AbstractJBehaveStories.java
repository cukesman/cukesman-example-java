package cukesman;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.SilentlyAbsorbingFailure;
import org.jbehave.core.io.AbsolutePathCalculator;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.parsers.gherkin.GherkinStoryParser;
import org.jbehave.core.reporters.ConsoleOutput;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import cukesman.jbehave.CukesmanStoryReporter;

import static org.jbehave.core.reporters.Format.CONSOLE;

public abstract class AbstractJBehaveStories extends JUnitStories {

    private CukesmanStoryReporter cukesmanReporter = new CukesmanStoryReporter();

    @Override
    public abstract InjectableStepsFactory stepsFactory();

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();

        return new MostUsefulConfiguration()
                .usePathCalculator(new AbsolutePathCalculator())
                .useFailureStrategy(new SilentlyAbsorbingFailure())
                .useStoryParser(new GherkinStoryParser())
                .useParameterConverters(new ParameterConverters())
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryPathResolver(new UnderscoredCamelCaseResolver())
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
                        .withDefaultFormats()
                        .withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
                        .withFormats(CONSOLE)
                        .withFailureTrace(true)
                        .withFailureTraceCompression(true)
                        .withReporters(cukesmanReporter, new ConsoleOutput())
                        );
    }

}
