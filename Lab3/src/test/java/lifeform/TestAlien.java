package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.RecoveryRateException;
import gameplay.SimpleTimer;
import gameplay.TimerObserver;
import recovery.RecoveryBehavior;
import recovery.RecoveryFractional;
import recovery.RecoveryLinear;
import recovery.RecoveryNone;

/**
 * @author Devin Test cases for Alien class
 */
public class TestAlien {

  /**
   * Test Alien Initilization where an alien can hold a name and life points.
   * 
   * @throws RecoveryRateException
   */
  @Test
  public void testAlienInitialization() throws RecoveryRateException {
    Alien alien = new Alien("Zee", 250, new RecoveryNone(), 0);
    assertEquals("Zee", alien.getName());
    assertEquals(250, alien.getCurrentLifePoints());
  }

  /**
   * Test Alien's maxLifePoints and currentLifePoints work after Alien takes a
   * hit.
   * 
   * @throws RecoveryRateException
   */
  @Test
  public void testAlienMaxHealth() throws RecoveryRateException {
    Alien alien = new Alien("Zee", 250, new RecoveryNone(), 0);
    LifeForm entity = new MockLifeForm("Steve", 100, 50);

    alien.takeHit(entity);
    assertEquals(250, alien.getMaxLifePoints());
    assertEquals(200, alien.getCurrentLifePoints());
  }

  /**
   * Test Linear Recovery with Aliens
   * 
   * @throws RecoveryRateException
   */
  @Test
  public void testAlienLinearRecovery() throws RecoveryRateException {
    RecoveryBehavior rb = new RecoveryLinear(3);
    Alien alien = new Alien("Bob", 100, rb);
    LifeForm entity = new MockLifeForm("Steve", 100, 50);

    alien.takeHit(entity);
    alien.recover();
    assertEquals(53, alien.getCurrentLifePoints());
  }

  /**
   * Test Fractional Recovery with Aliens
   * 
   * @throws RecoveryRateException
   */
  @Test
  public void testAlienFractionalRecovery() throws RecoveryRateException {
    RecoveryBehavior rb = new RecoveryFractional(0.1);
    Alien alien = new Alien("Steve", 100, rb);
    LifeForm entity = new MockLifeForm("Steve", 100, 50);

    alien.takeHit(entity);
    alien.recover();
    assertEquals(55, alien.getCurrentLifePoints());
  }

  /**
   * Test Human armor absorbs Alien's hit
   * 
   * @throws RecoveryRateException
   */
  @Test
  public void testAlienDefaultStrength() throws RecoveryRateException {
    Alien alien = new Alien("Steve", 100);

    int attackStrength = alien.getAttackStrength();
    assertEquals(10, attackStrength);
  }

  /**
   * Test alien tracks recovery rate
   * 
   * @throws RecoveryRateException
   */
  @Test
  public void testAlienRecoveryRate() throws RecoveryRateException {
    Alien alien = new Alien("John", 100, new RecoveryNone(), 5);

    assertEquals(5, alien.getRecoveryRate());
  }

  /**
   * Test alien does not recover at zero.
   */
  @Test
  public void testAlienRecoveryRateIsZero() {
    // Create Alien
    RecoveryBehavior recoverFractional = new RecoveryFractional(0.1);
    Alien alien = new Alien("Steve", 100, recoverFractional, 0);
    // Create Enemy
    LifeForm enemyLifeForm = new MockLifeForm("Joe", 100, 50);
    // Create Timer with alien observer
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(alien);

    alien.takeHit(enemyLifeForm);

    timer.timeChanged();
    timer.timeChanged();

    assertEquals(50, alien.getCurrentLifePoints());
  }

  /**
   * Test that alien recovers linearly, 1 point every 2 rounds.
   * 
   * @throws RecoveryRateException
   */
  @Test
  public void testAlienLinearRecoveryRate() throws RecoveryRateException {
    // Create Enemy
    LifeForm enemyLifeForm = new MockLifeForm("Bob", 100, 5);
    // Create Alien
    RecoveryBehavior recoverLinear = new RecoveryLinear(1);
    Alien alien = new Alien("Steve", 100, recoverLinear, 2);
    // Create Timer
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(alien);

    // Check that round starts at zero
    assertEquals(0, timer.getRound());

    // Make Alien take Hit
    alien.takeHit(enemyLifeForm);
    assertEquals(95, alien.getCurrentLifePoints());
    // Increment round
    timer.timeChanged();
    assertEquals(1, timer.getRound());
    // Check that alien did not recover too early.
    assertEquals(95, alien.getCurrentLifePoints());
    // Increment round
    timer.timeChanged();
    assertEquals(2, timer.getRound());

    // Check that alien recovered
    assertEquals(96, alien.getCurrentLifePoints());
  }

  /**
   * Test that alien recovers fractionally.
   * 
   * @throws RecoveryRateException
   */
  @Test
  public void testAlienFractionalRecoveryRate() throws RecoveryRateException {
    // Create Alien
    RecoveryBehavior recoverFractional = new RecoveryFractional(0.1);
    Alien alien = new Alien("Steve", 100, recoverFractional, 2);
    // Create Enemy
    LifeForm enemyLifeForm = new MockLifeForm("Joe", 100, 50);
    // Create Timer with alien observer
    SimpleTimer timer = new SimpleTimer();
    timer.addTimeObserver(alien);

    // Check round starts at zero
    assertEquals(0, timer.getRound());
    // Have alien take damage
    alien.takeHit(enemyLifeForm);
    assertEquals(50, alien.getCurrentLifePoints());
    // Increment round
    timer.timeChanged();
    assertEquals(1, timer.getRound());
    // Check that alien didn't recover too early
    assertEquals(50, alien.getCurrentLifePoints());
    // Increment round
    timer.timeChanged();
    assertEquals(2, timer.getRound());
    // Check that alien recovered 10% after two rounds
    assertEquals(55, alien.getCurrentLifePoints());
  }

  /**
   * Test that rounds are tracked properly.
   */
  @Test
  public void testTimeTracking() {
    SimpleTimer timer = new SimpleTimer();

    assertEquals(0, timer.getRound());
    timer.timeChanged();
    assertEquals(1, timer.getRound());
    timer.timeChanged();
    assertEquals(2, timer.getRound());
  }

  /**
   * Test that removing an observer disables recovering.
   */
  @Test
  public void testRemovalOfObserver() {
    SimpleTimer timer = new SimpleTimer();
    Alien alien = new Alien("Steve", 100, new RecoveryLinear(2), 1);

    timer.addTimeObserver(alien);

    alien.takeHit(5);
    assertEquals(95, alien.getCurrentLifePoints());
    timer.timeChanged();

    assertEquals(97, alien.getCurrentLifePoints());
    timer.removeTimeObserver(alien);

    timer.timeChanged();
    assertEquals(97, alien.getCurrentLifePoints());

  }

  /**
   * Throw exception if recovery rate is negative
   * 
   * @throws RecoveryRateException
   */
  @Test(expected = RecoveryRateException.class)
  public void testNegRecovery() throws RecoveryRateException {
    RecoveryBehavior recoveryLinear = new RecoveryLinear(1);
    Alien alien = new Alien("AlienBob", 15, (RecoveryBehavior) recoveryLinear, -8);
    assertEquals(8, alien.getRecoveryRate());
  }

}