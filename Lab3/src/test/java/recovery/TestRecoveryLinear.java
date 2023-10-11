package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryLinear {
  /**
   * Test recovery doesn't work when no damage is done
   */
  @Test
  public void noRecoveryWhenNotHurt() {
    RecoveryLinear rl = new RecoveryLinear(3);
    int maxLifePts = 30;
    int result = rl.calculateRecovery(maxLifePts, maxLifePts);
    assertEquals(maxLifePts, result);
  }

  @Test
  public void noRecoveryWhenNotHurt2() {
    RecoveryLinear rl = new RecoveryLinear(3);
    int maxLifePts = 50;
    int result = rl.calculateRecovery(maxLifePts, maxLifePts);
    assertEquals(maxLifePts, result);
  }

  /**
   * Test Linear Recovery recover's health (not going over maxLifePts)
   */
  @Test
  public void testLinearRecoveryNotMaxxed() {
    RecoveryLinear rl = new RecoveryLinear(3);
    int maxLifePts = 30;
    int currentLifePts = 25;
    int result = rl.calculateRecovery(currentLifePts, maxLifePts);

    assertEquals(currentLifePts + 3, result);
  }

  /**
   * Test alien life points cant go over maxLifePts when recovering
   */
  @Test
  public void testLinearRecoveryNearMax() {
    RecoveryLinear rl = new RecoveryLinear(3);
    int maxLifePts = 30;
    int currentLifePts = 29;
    int result = rl.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(maxLifePts, result);
  }

  /**
   * Test the value on a perfect recovery.
   */
  @Test
  public void testPerfectRecovery() {
    RecoveryLinear rl = new RecoveryLinear(3);
    int maxLifePts = 30;
    int currentLifePts = 27;
    int result = rl.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(maxLifePts, result);
  }

  /**
   * Test the value on a perfect recovery.
   */
  @Test
  public void testPerfectRecovery2() {
    RecoveryLinear rl = new RecoveryLinear(50);
    int maxLifePts = 100;
    int currentLifePts = 50;
    int result = rl.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(maxLifePts, result);
  }

  /**
   * Test the alien cannot gain pts if it is dead (life points = 0)
   */
  @Test
  public void testDead() {
    RecoveryLinear rl = new RecoveryLinear(3);
    int maxLifePts = 30;
    int currentLifePts = 0;
    int result = rl.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(0, result);
  }

  /**
   * Test the alien cannot gain pts if it is dead (life points = 0)
   */
  @Test
  public void testDead2() {
    RecoveryLinear rl = new RecoveryLinear(3);
    int maxLifePts = 30;
    int currentLifePts = 0;
    int result = rl.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(0, result);
  }
}
