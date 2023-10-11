package recovery;

public class RecoveryFractional implements RecoveryBehavior {
  double percentRecovery;

  public RecoveryFractional(double percentRecovery) {
    this.percentRecovery = (double) percentRecovery;
  }

  /**
   * Calculate anount of life points to recover, fractionally
   */
  public int calculateRecovery(int currentLife, int maxLife) {
    // Make sure cannot come back from dead.
    if (currentLife <= 0) {
      currentLife = 0;
      return currentLife;
    }

    // Recover
    currentLife += Math.ceil(currentLife * percentRecovery);

    // Make sure currentLifePoints don't exceed maxLifePoints.
    if (currentLife >= maxLife) {
      currentLife = maxLife;
      return currentLife;
    }

    return currentLife;
  }

}
