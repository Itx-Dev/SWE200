package gameplay;

/**
 * Interface for game timer.
 * 
 * @author Devin
 */
public interface Timer {

  /**
   * Adds time observer to observer list.
   * 
   * @param observer
   */
  void addTimeObserver(TimerObserver observer);

  /**
   * Remove time observer from observer list.
   * 
   * @param observer
   */
  void removeTimeObserver(TimerObserver observer);

  /**
   * Update current round by one round.
   */
  void timeChanged();
}
