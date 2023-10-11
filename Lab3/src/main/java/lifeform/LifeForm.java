package lifeform;

/**
 * Keeps track of the information assocaited with a simple life form. Also
 * provides the functionality realtion to the life form.
 */
public abstract class LifeForm {

  // Instance variables
  private String name;
  protected int currentLifePoints;
  private int attackStrength = 1;

  /**
   * Life Form constructor given name and lifepoints
   * 
   * @param name       , the name of the life form.
   * @param lifePoints , the current starting life points of the life form.
   */
  public LifeForm(String name, int lifePoints) {
    this.name = name;
    this.currentLifePoints = lifePoints;
  }

  /**
   * Constructor for Life Form given name, lifepoints, and attack
   * 
   * @param name
   * @param lifePoints
   * @param attack
   */
  public LifeForm(String name, int lifePoints, int attack) {
    this(name, lifePoints);
    this.attackStrength = attack;
  }

  /**
   * @return name of life form.
   */
  public String getName() {
    return name;
  }

  /**
   * Return life points of current entity
   * 
   * @return current life points of life form.
   */
  public int getCurrentLifePoints() {
    return currentLifePoints;
  }

  /**
   * @return the attack strength of given life form
   */
  public int getAttackStrength() {
    return attackStrength;
  }

  /**
   * Take damage away from entity
   * 
   * @param enemy
   */
  public void takeHit(LifeForm enemy) {
    int enemyHealth = enemy.getCurrentLifePoints();
    // Find the attak strength of enemy.
    int enemyAttackStrength = enemy.getAttackStrength();
    // If enemy is dead their attack strength is 0
    if (enemyHealth <= 0) {
      enemyAttackStrength = 0;
    }
    // Take damage from current life points.
    currentLifePoints = currentLifePoints - enemyAttackStrength;

    // If entity's life points go negative set to zero.
    if (currentLifePoints < 0) {
      currentLifePoints = 0;
    }
  }

  /**
   * Take damage away from entity
   * 
   * @param damage
   */
  public void takeHit(int damage) {
    // Take damage from current life points.
    currentLifePoints = currentLifePoints - damage;

    // If entity's life points go negative set to zero.
    if (currentLifePoints < 0) {
      currentLifePoints = 0;
    }
  }

  /**
   * Attack another Lifefrom with attack strength
   * 
   * @param opponent
   */
  public void attack(LifeForm opponent) {
    opponent.takeHit(this);

  }

  public void updateTime(int time) {
    // TODO Auto-generated method stub
    
  }

}