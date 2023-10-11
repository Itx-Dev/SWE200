package gameplay;

/**
 * Simulate Timer
 * 
 * @author Devin
 */
public class MockSimpleTimerObserver implements TimerObserver {
  /**
   * Initial time is zero.
   */
  public int myTime = 0;

  /**
   * Method to update the game time.
   * 
   * @param time
   */
  @Override
  public void updateTime(int time) {
    myTime = time;

  }
}
