package lifeform;

public class MockLifeForm extends LifeForm {

  /**
   * Allow for attack strength to be picked
   * 
   * @param name
   * @param points
   * @param attack
   */
  public MockLifeForm(String name, int points, int attack) {
    super(name, points, attack);
  }

  /*
   * Default attack to value of 1 if not given.
   */
  public MockLifeForm(String name, int points) {
    super(name, points, 1);
  }
}