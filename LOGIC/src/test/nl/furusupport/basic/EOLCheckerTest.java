package nl.furusupport.basic;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EOLCheckerTest {

    @Test
    void EOLTest() {
        Device mockDevice = new Device("Iphone 6", "xyz", 0, 200, LocalDate.of(2020,1,1),"Home");
        EOLChecker testEOL = new EOLChecker();

        assertEquals(DeviceState.ENDOFLIFEREACHED,testEOL.check(mockDevice));


    }

}