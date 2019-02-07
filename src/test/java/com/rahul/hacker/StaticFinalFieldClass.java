package com.rahul.hacker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class StaticFinalFieldClass {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaticFinalFieldClass.class);

    public boolean demoMethod() {
        System.out.println("Demo started");
        if (LOGGER.isInfoEnabled()) {
            System.out.println("@@@@@@@@@@@@@@ ------- info is enabled");
        } else {
            System.out.println("info is disabled");
        }
        return LOGGER.isInfoEnabled();
    }
}
