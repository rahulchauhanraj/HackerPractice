package com.rahul.hacker.problems;

import org.quartz.CronExpression;

import java.util.Date;

public class EnableCron {

    public static void main (String[] args) throws Exception {
        String exp = "* * 2-5,13-15 * * ?";
        boolean valid = CronExpression.isValidExpression(exp);
        if (valid) {
            CronExpression cronExpression = new CronExpression(exp);
            System.out.println(cronExpression.isSatisfiedBy(new Date()));
        }
    }
}
