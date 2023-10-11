package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.RecoveryRateException;

/**
 * Test Cases for recovery none behavior.
 * 
 * @author Devin
 *
 */
public class TestRecoveryNone {

  /**
   * Test that RecoveryNone does not recover and return current life points
   */
  @Test
  public void testRecoveryNoneAtMax() {
    RecoveryNone rn = new RecoveryNone();
    int maxLifePts = 100;
    int currentLifePts = 100;
    int recover = rn.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(100, recover);
  }

  @Test
  public void testRecoveryNoneAtMax2() {
    RecoveryNone rn = new RecoveryNone();
    int maxLifePts = 200;
    int currentLifePts = 200;
    int recover = rn.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(200, recover);
  }

  @Test
  public void testRecoveryNoneUnderMax() throws RecoveryRateException {
    RecoveryNone rn = new RecoveryNone();
    int maxLifePts = 100;
    int currentLifePts = 50;
    assertEquals(50, rn.calculateRecovery(currentLifePts, maxLifePts));
  }

  @Test
  public void testRecoveryNoneUnderMax2() throws RecoveryRateException {
    RecoveryNone rn = new RecoveryNone();
    int maxLifePts = 100;
    int currentLifePts = 25;
    assertEquals(25, rn.calculateRecovery(currentLifePts, maxLifePts));
  }
}
