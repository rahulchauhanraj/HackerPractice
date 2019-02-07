package com.rahul.hacker;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticMethodClass.class})
public class MockStaticMethodTest {

    @Test
    public void test() {
        StaticMethodClass staticMethodClass = PowerMockito.mock(StaticMethodClass.class);
        PowerMockito.mockStatic(StaticMethodClass.class);
        PowerMockito.when(StaticMethodClass.getInstance()).thenReturn(staticMethodClass);
        System.out.println("Setup completed.");
    }
}


