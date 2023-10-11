package lifeform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Devin The test cases for life form class.
 */
public class TestLifeForm {

  /**
   * Test functionality provided by LifeForm class.
   */
  @Test
  public void testLifeFormInitialization() {
    LifeForm entity = new MockLifeForm("Bob", 100);

    assertEquals("Bob", entity.getName());
    assertEquals(100, entity.getCurrentLifePoints());
  }

  /**
   * Test tracking of entity name
   */
  @Test
  public void testNameTracking() {
    LifeForm entity = new MockLifeForm("Bob", 100);

    assertEquals("Bob", entity.getName());
  }

  /**
   * Test tracking of entity name
   */
  @Test
  public void testNameTracking2() {
    LifeForm entity = new MockLifeForm("Steve", 100);

    String name = entity.getName();
    assertEquals("Steve", name);
  }

  /**
   * Test entity takes hit from enemy life form
   */
  @Test
  public void testTakeHitFirstAttack() {
    LifeForm entity = new MockLifeForm("Bob", 100);
    LifeForm enemy = new MockLifeForm("Steve", 100, 50);

    entity.takeHit(enemy);
    assertEquals(50, entity.getCurrentLifePoints());
  }

  /**
   * Test entity takes hit from enemy life form
   */
  @Test
  public void testTakeHitFirstAttack2() {
    LifeForm entity = new MockLifeForm("Bob", 500);
    LifeForm enemy = new MockLifeForm("Steve", 100, 50);

    entity.takeHit(enemy);
    assertEquals(450, entity.getCurrentLifePoints());
  }

  /**
   * Test that life form takes hit.
   */
  @Test
  public void testTakeHitMultipleAttacks() {
    LifeForm entity = new MockLifeForm("Bob", 100);
    LifeForm enemy = new MockLifeForm("Steve", 100, 50);

    entity.takeHit(enemy);
    assertEquals(50, entity.getCurrentLifePoints());

    entity.takeHit(enemy);
    assertEquals(0, entity.getCurrentLifePoints());
  }

  /**
   * Test that life form takes hit.
   */
  @Test
  public void testTakeHitMultipleAttacks2() {
    LifeForm entity = new MockLifeForm("Bob", 500);
    LifeForm enemy = new MockLifeForm("Steve", 100, 50);

    entity.takeHit(enemy);
    assertEquals(450, entity.getCurrentLifePoints());

    entity.takeHit(enemy);
    assertEquals(400, entity.getCurrentLifePoints());
  }

  /**
   * Test that lifeform can take damage from another lifeform.
   */
  @Test
  public void testAttackHurtsLifeForm() {
    LifeForm entity = new MockLifeForm("Bob", 100);
    LifeForm enemy = new MockLifeForm("Steve", 100);
    // Make entity take hit
    entity.takeHit(enemy);
    // Check damage is taken correctly
    assertEquals(99, entity.getCurrentLifePoints());
  }

  /**
   * Test that entity does not take damage from an enemy that is dead.
   */
  @Test
  public void testDeadEnemyAttack() {
    LifeForm entity = new MockLifeForm("Bob", 100);
    LifeForm enemy = new MockLifeForm("Steve", 0, 50);

    entity.takeHit(enemy);
    int entityHealth = entity.getCurrentLifePoints();
    // Entity should not have taken any damage
    assertEquals(100, entityHealth);
  }

}