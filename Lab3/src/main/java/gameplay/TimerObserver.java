package gameplay;

/**
 * Interface for time observer.
 * 
 * @author Devin
 */
public interface TimerObserver {
  /**
   * Call Observer to update round.
   * 
   * @param time
   */
  void updateTime(int time);
}
