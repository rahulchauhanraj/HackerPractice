package com.rahul.hacker.testsuites;

import com.ge.apm.alarmmanagement.utilities.TestClassesPatternResolver;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 212578960 on 9/1/2017.
 */
public class BaseTestSuite extends Suite {
    // Restrict search to this base package
    private static final String BASE_PACKAGE = "com.ge.apm.alarmmanagement";

    public BaseTestSuite(final Class<?> clazz, String[] includes, String[] excludes) throws InitializationError {
        super(clazz, findTestClasses(includes, excludes));
    }

    private static Class<?>[] findTestClasses(String[] includes, String[] excludes) throws InitializationError {
        try {
            TestClassesPatternResolver resolver = new TestClassesPatternResolver(
                    BASE_PACKAGE, Arrays.asList(includes), Arrays.asList(excludes));
            List<Class<?>> classes = resolver.getClasses();
            return classes.toArray(new Class[classes.size()]);
        } catch (Exception e) {
            List<Throwable> errors = new ArrayList<Throwable>();
            errors.add(e);
            throw new InitializationError(errors);
        }
    }
}
