package lifeform;

/**
 * Class for Human Life Form
 * 
 * @author Devin
 */
public class Human extends LifeForm {

  // Instance variables
  private int armor;
  private static final int attackStrength = 5;

  /**
   * Human constructor
   * 
   * @param name
   * @param lifePoints
   * @param attackStrength
   * @param armor
   */
  public Human(String name, int lifePoints, int armor) {
    super(name, lifePoints, attackStrength);
    setArmorPoints(armor);
  }

  /**
   * Getter for Human Armor Points.
   * 
   * @return Armor points of Human
   */
  public int getArmorPoints() {
    return armor;
  }

  /**
   * Set the Human's Armor Points.
   * 
   * @param points
   */
  public void setArmorPoints(int points) {
    // If armor is set below zero make it zero
    if (points <= 0) {
      points = 0;
    }

    this.armor = points;
  }

  /**
   * Override LifeForm.takeHit() to account for armor
   */
  @Override
  public void takeHit(LifeForm lifeForm) {
    int lifeformAttackStrength = lifeForm.getAttackStrength();
    int damage = (lifeformAttackStrength - armor);

    if (damage > 0) {
      currentLifePoints = currentLifePoints - damage;
    }

    System.out.println();
  }

}