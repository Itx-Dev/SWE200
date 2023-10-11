package recovery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestRecoveryFractional {

  @Test
  public void testWhenNotHurt() {
    RecoveryFractional rf = new RecoveryFractional(0.5);
    int maxLifePts = 100;
    int currentLifePts = 100;
    int result = rf.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(100, result);
  }

  @Test
  public void testWhenNotHurt2() {
    RecoveryFractional rf = new RecoveryFractional(0.5);
    int maxLifePts = 500;
    int currentLifePts = 500;
    int result = rf.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(500, result);
  }

  @Test
  public void testStepGreaterThanDamage() {
    RecoveryFractional rf = new RecoveryFractional(0.1);
    int maxLifePoints = 100;
    int currentLifePoints = 90;
    int result = rf.calculateRecovery(currentLifePoints, maxLifePoints);
    assertEquals(99, result);
  }

  @Test
  public void testStepGreaterThanDamage2() {
    RecoveryFractional rf = new RecoveryFractional(0.1);
    int maxLifePoints = 100;
    int currentLifePoints = 93;
    int result = rf.calculateRecovery(currentLifePoints, maxLifePoints);
    assertEquals(100, result);
  }

  @Test
  public void testStepLessThanDamage() {
    RecoveryFractional rf = new RecoveryFractional(0.1);
    int maxLifePoints = 100;
    int currentLifePoints = 95;
    int result = rf.calculateRecovery(currentLifePoints, maxLifePoints);
    assertEquals(100, result);
  }

  @Test
  public void testStepLessThanDamage2() {
    RecoveryFractional rf = new RecoveryFractional(0.1);
    int maxLifePoints = 50;
    int currentLifePoints = 25;
    int result = rf.calculateRecovery(currentLifePoints, maxLifePoints);
    assertEquals(28, result);
  }

  @Test
  public void testDead() {
    RecoveryFractional rf = new RecoveryFractional(0.5);
    int maxLifePts = 100;
    int currentLifePts = 0;
    int result = rf.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(0, result);
  }

  @Test
  public void testDead2() {
    RecoveryFractional rf = new RecoveryFractional(0.5);
    int maxLifePts = 500;
    int currentLifePts = 0;
    int result = rf.calculateRecovery(currentLifePts, maxLifePts);
    assertEquals(0, result);
  }

}
