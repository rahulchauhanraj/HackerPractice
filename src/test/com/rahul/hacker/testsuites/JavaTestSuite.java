package com.rahul.hacker.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;

/**
 * Created by 212578960 on 9/1/2017.
 */
@RunWith(JavaTestSuite.class)
public class JavaTestSuite extends BaseTestSuite {

    private static final String[] INCLUDES = new String[] {"**/*Test.class", "**/*IT.class", "**/Test*.class", "**/*TestCase.class"};
    private static final String[] EXCLUDES = new String[] {"**/smoke/*.java"};

    public JavaTestSuite(final Class<?> clazz) throws InitializationError {
        super(clazz, INCLUDES, EXCLUDES);
    }
}