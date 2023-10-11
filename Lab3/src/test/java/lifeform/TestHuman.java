package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.RecoveryRateException;

/**
 * Test cases for Human class
 * 
 * @author Devin
 */
public class TestHuman {

  /**
   * Test the initialization of two humans with and without armor points
   */
  @Test
  public void testHumanInitilization() {
    Human human = new Human("Steve", 100, 0);
    assertEquals("Steve", human.getName());
    assertEquals(100, human.getCurrentLifePoints());
    assertEquals(0, human.getArmorPoints());

    Human human2 = new Human("John", 100, 50);
    assertEquals("John", human2.getName());
    assertEquals(100, human.getCurrentLifePoints());
    assertEquals(50, human2.getArmorPoints());
  }

  /**
   * Test the setting of armor.
   */
  @Test
  public void testSetArmorPoints() {
    Human human = new Human("Bob", 100, 0);
    human.setArmorPoints(600);
    int armor = human.getArmorPoints();
    assertEquals(600, armor);
  }

  /**
   * Test setting armor again.
   */
  @Test
  public void testSetArmorPoints2() {
    Human human = new Human("Bob", 100, 0);
    human.setArmorPoints(50);
    int armor = human.getArmorPoints();
    assertEquals(50, armor);
  }

  /**
   * Test receiving correct armor amount.
   */
  @Test
  public void testGetArmorPoints() {
    Human human = new Human("Bob", 100, 500);
    int armor = human.getArmorPoints();
    assertEquals(500, armor);

  }

  /**
   * Test receving correct armor amount again.
   */
  @Test
  public void testGetArmorPoints2() {
    Human human = new Human("Bob", 100, 25);
    int armor = human.getArmorPoints();
    assertEquals(25, armor);
  }

  /**
   * Test negative armor given in constructor
   */
  @Test
  public void testNegativeArmorPoints() {
    Human human = new Human("Steve", 100, -5);
    assertEquals(0, human.getArmorPoints());
  }

  /**
   * Test negative armor points a second time
   */
  @Test
  public void testNegativeArmorPoints2() {
    Human human = new Human("Steve", 100, -10000);
    assertEquals(0, human.getArmorPoints());
  }

  @Test
  public void testDefaultHumanAttack() {
    Human human = new Human("Steve", 100, 10);
    assertEquals(5, human.getAttackStrength());
  }

  /**
   * Test that human can be attacked by Alien
   * 
   * @throws RecoveryRateException
   */
  @Test
  public void testArmorAbsorbsAll() throws RecoveryRateException {
    Human human = new Human("Bob", 100, 10);
    Alien alien = new Alien("Steve", 100);

    human.takeHit(alien);
    int humanHealth = human.getCurrentLifePoints();

    assertEquals(100, humanHealth);
  }

  /**
   * @throws RecoveryRateException
   */
  @Test
  public void testArmorReducesDamage() throws RecoveryRateException {
    Human human = new Human("Bob", 100, 5);
    Alien alien = new Alien("Steve", 100);

    human.takeHit(alien);

    assertEquals(95, human.getCurrentLifePoints());

  }

  /**
   * Test that armor absorbs alien attack
   * 
   * @throws RecoveryRateException
   */
  @Test
  public void testArmorAbsorbsAll2() throws RecoveryRateException {
    Human human = new Human("Bob", 100, 10);
    Alien alien = new Alien("Steve", 100);

    human.takeHit(alien);

    assertEquals(100, human.getCurrentLifePoints());
  }

}