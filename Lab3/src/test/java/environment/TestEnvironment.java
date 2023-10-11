package environment;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import lifeform.LifeForm;
import lifeform.MockLifeForm;

/**
 * @author Devin The test cases for environment class.
 */
public class TestEnvironment {
  /**
   * Test Initialization of environment and that the cells are empty.
   */
  @Test
  public void testInitialization() {
    Environment environment = new Environment(1, 1);
    assertEquals(null, environment.cells[0][0]);
  }

  /**
   * Test adding of life form cell to cell array
   * 
   * @throws Exception
   */
  @Test
  public void testAddLifeForm() throws Exception {
    Environment environment = new Environment(2, 3);
    LifeForm lf = new MockLifeForm("Steve", 100);
    environment.addLifeForm(lf, 1, 2);
    assertEquals(lf, environment.getLifeForm(1, 2));
  }

  /**
   * Test adding of life form cell to cell array
   * 
   * @throws Exception
   */
  @Test
  public void testAddLifeForm2() throws Exception {
    Environment environment = new Environment(2, 3);
    LifeForm lf = new MockLifeForm("Steve", 100);
    environment.addLifeForm(lf, 0, 0);
    assertEquals(lf, environment.getLifeForm(0, 0));
  }

  /**
   * Test that smaller index throws exception.
   * 
   * @throws Exception
   */
  @Test(expected = Exception.class)
  public void testBoundaryLifeFormCells() throws Exception {
    Environment environment = new Environment(0, 0);
    LifeForm lf = new MockLifeForm("Jake", 100);
    environment.addLifeForm(lf, -1, 0);
  }

  /**
   * Test that larger index throws exception.
   * 
   * @throws Exception
   */
  @Test(expected = Exception.class)
  public void testBoundaryLifeFormCells2() throws Exception {
    Environment environment = new Environment(2, 3);
    LifeForm lf = new MockLifeForm("John", 100);
    environment.addLifeForm(lf, 3, 4);
  }

  /**
   * Test the addition and removal of a life form.
   * 
   * @throws Exception
   */
  @Test
  public void testRemovalofLifeForm() throws Exception {
    Environment environment = new Environment(2, 3);
    LifeForm lf = new MockLifeForm("Phil", 100);
    environment.addLifeForm(lf, 1, 2);
    environment.removeLifeForm(1, 2);
    assertEquals(null, environment.getLifeForm(1, 2));
  }

  /**
   * Test the addition and removal of a life form.
   * 
   * @throws Exception
   */
  @Test
  public void testRemovalofLifeForm2() throws Exception {
    Environment environment = new Environment(2, 3);
    LifeForm lf = new MockLifeForm("Phil", 100);
    environment.addLifeForm(lf, 0, 0);
    environment.removeLifeForm(0, 0);
    assertEquals(null, environment.getLifeForm(0, 0));
  }

}
