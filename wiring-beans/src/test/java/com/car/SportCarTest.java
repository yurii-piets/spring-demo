package com.car;

import com.config.CarsSpringConfig;
import com.racer.Racer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = CarsJavaConfig.class)
@ContextConfiguration(classes = CarsSpringConfig.class)
public class SportCarTest {
    @Autowired
    private Car car;

    @Autowired
    private Racer racer;

    @Test
    public void carNotNull() {
        assertNotNull(car);
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void drive() {
        racer.drive();
        String expected = "Driving BMW 7\r\n";
        String actual = systemOutRule.getLog();
        assertEquals(expected, actual);
    }
}