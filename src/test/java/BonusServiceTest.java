import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouIdCalculatedForRegisteredAndUnderLimit() {

        BonusService service = new BonusService();
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouIdCalculatedForRegisteredAndOverLimit() {

        BonusService service = new BonusService();
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouIdCalculatedForRegisteredAndOver2Limit() {
        BonusService service = new BonusService();
        long amount = 1_000_060;
        boolean registered = true;
        long expected = 300;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouIdCalculatedForNotRegisteredUserUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouIdCalculatedForNotRegisteredUserOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_060;
        boolean registered = false;
        long expected = 100;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
        }
}