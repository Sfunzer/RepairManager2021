package nl.furusupport.basic;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LifeSpanCheckerTest {

    @Test
    void LifeSpanTest() {
        Device mockDevice = new Device("Iphone 6", "xyz", 210, 200, LocalDate.of(2020,1,1),"Home");
        LifeSpanChecker testLifeSpan = new LifeSpanChecker();

        assertEquals(DeviceState.LIFESPANPASSED,testLifeSpan.check(mockDevice));


    }



}