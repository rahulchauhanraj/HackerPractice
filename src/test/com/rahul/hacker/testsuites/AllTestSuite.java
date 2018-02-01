package com.rahul.hacker.testsuites;

import com.ge.apm.alarmmanagement.asciidoc.ApiDocumentation;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by 212578960 on 9/1/2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        JavaTestSuite.class,
        ApiDocumentation.class
})
public class AllTestSuite {
    // the class remains empty, used only as a holder for the above annotations
}
