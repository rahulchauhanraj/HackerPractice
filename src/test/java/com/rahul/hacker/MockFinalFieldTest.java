package com.rahul.hacker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;


@RunWith(PowerMockRunner.class)
//@SuppressStaticInitializationFor("com.rahul.hacker.FinalFieldClass")
//@PrepareForTest({FinalFieldClass.class})
public class MockFinalFieldTest {

    @InjectMocks
    FinalFieldClass finalFieldClass = new FinalFieldClass();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Logger logger = PowerMockito.mock(Logger.class);
        Whitebox.setInternalState(finalFieldClass, logger);
    }


    @Test
    public void test() {
        finalFieldClass.demoMethod();
    }
}


