package recovery;

public class RecoveryLinear implements RecoveryBehavior {
  int step;

  public RecoveryLinear(int step) {
    this.step = step;
  }

  /**
   * Calculate amount of life points to recover, linearly
   */
  public int calculateRecovery(int currentLife, int maxLife) {
    // Check if alien is dead
    if (currentLife <= 0) {
      return 0;
    }

    currentLife += step;

    // Check currentLifePoints doesn't exceed maxLifePoints
    if (currentLife >= maxLife) {
      currentLife = maxLife;
    }

    return currentLife;
  }
}
