package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * The test cases for the Cell class.
 */
public class TestCell {
  /**
   * At initialization, the Cell should be empty and not contain a LifeForm.
   */
  @Test
  public void testCellInitializtion() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
  }

  /**
   * Checks to see if we change the LifeForm held by the Cell that getLifeForm
   * properly responds to this change.
   */
  @Test
  public void testAddLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 100);
    Cell cell = new Cell();
    // The cell is empty so this should work.
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
  }

  /**
   * Test that a life form can be added.
   */
  @Test
  public void testAddLifeForm2() {
    LifeForm bob = new MockLifeForm("Bob", 100);
    Cell cell = new Cell();
    // The cell is empty so this should work.
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
  }

  /**
   * Test that adding another life form does not overwrite the first.
   */
  @Test
  public void testOccupiedCell() {
    LifeForm bob = new MockLifeForm("Bob", 100);
    LifeForm fred = new MockLifeForm("Fred", 100);
    Cell cell = new Cell();
    // The cell is empty so this should work.
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
    // The cell is not empty so this should fail.
    success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());
  }

  /**
   * Test that adding another life form does not overwrite the first.
   */
  @Test
  public void testOccupiedCell2() {
    LifeForm bob = new MockLifeForm("bob", 100);
    LifeForm fred = new MockLifeForm("fred", 100);
    Cell cell = new Cell();
    // Should work since cell is empty
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    // Should fail since cell is full
    boolean fail = cell.addLifeForm(fred);
    assertFalse(fail);

  }

  /**
   * Test that a life form can be added and then removed.
   */
  @Test
  public void testRemoveLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 100);
    LifeForm fred = new MockLifeForm("Fred", 100);
    Cell cell = new Cell();
    // Test life form bob was added.
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    // Test life form bob was removed.
    cell.removeLifeForm();
    assertNull(cell.getLifeForm());
    // Test life form fred could added.
    boolean success2 = cell.addLifeForm(fred);
    assertTrue(success2);
  }

  /**
   * Test that a life form can be added and then removed.
   */
  @Test
  public void testRemoveLifeForm2() {
    LifeForm bob = new MockLifeForm("Bob", 100);
    LifeForm fred = new MockLifeForm("Fred", 100);
    Cell cell = new Cell();
    // Test life form bob was added.
    boolean success = cell.addLifeForm(fred);
    assertTrue(success);
    // Test life form fred was removed.
    cell.removeLifeForm();
    assertNull(cell.getLifeForm());
    // Test life form bob could added.
    boolean success2 = cell.addLifeForm(bob);
    assertTrue(success2);
  }

}
