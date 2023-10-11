package lifeform;

import exceptions.RecoveryRateException;
import gameplay.TimerObserver;
import recovery.RecoveryBehavior;

/**
 * Class for Alien Life form
 * 
 * @author Devin
 */
public class Alien extends LifeForm implements TimerObserver {

  // Instance Variables
  private final int maxLifePoints;
  // How many rounds it takes for alien to begin recovering.
  private int recoveryRate = 0;
  private static final int defaultStrength = 10;
  RecoveryBehavior recoveryBehavior;

  /**
   * Constructor for Alien class
   * 
   * @param name
   * @param lifePoints
   * @param recoveryBehavior
   * @param maxLifePoints
   * @throws RecoveryRateException
   */
  public Alien(String name, int lifePoints, RecoveryBehavior recoveryBehavior) 
      throws RecoveryRateException {
    super(name, lifePoints, defaultStrength);
    // Set max health of alien to maxLifePoints
    maxLifePoints = lifePoints;
    // Set recovery behavior of alien to given behavior
    this.recoveryBehavior = recoveryBehavior;
  }

  /**
   * Sets Default Values for recovery and attackStrength
   * 
   * @param name
   * @param lifePoints
   * @throws RecoveryRateException
   */
  public Alien(String name, int lifePoints) throws RecoveryRateException {
    super(name, lifePoints, defaultStrength);

    this.maxLifePoints = lifePoints;
  }

  /**
   * @param name
   * @param lifePoints
   * @param recoveryBehavior
   * @param recoveryRate
   */
  public Alien(String name, int lifePoints, RecoveryBehavior recoveryBehavior, int recoveryRate) {
    super(name, lifePoints, defaultStrength);

    this.recoveryBehavior = recoveryBehavior;
    this.recoveryRate = recoveryRate;
    this.maxLifePoints = lifePoints;
  }

  /**
   * Make the alien recover
   */
  protected void recover() {
    // Find how many life points the alien should recover
    int recoveryPoints = recoveryBehavior.calculateRecovery(currentLifePoints, maxLifePoints);

    currentLifePoints = recoveryPoints;
  }

  /**
   * @return original starting health of alien
   */
  public int getMaxLifePoints() {
    return maxLifePoints;
  }

  /**
   * @return the rate at which the alien recovers
   * @throws RecoveryRateException
   */
  public int getRecoveryRate() throws RecoveryRateException {
    if (recoveryRate < 0) {
      throw new RecoveryRateException("Recovery Rate cannot be negative");
    } else {
      return recoveryRate;
    }

  }

  @Override
  public void updateTime(int time) {
    // Check that recoveryRate is greater than zero
    if (recoveryRate > 0) {
      if (time % recoveryRate == 0) {
        recover();
      }
    }

  }
}