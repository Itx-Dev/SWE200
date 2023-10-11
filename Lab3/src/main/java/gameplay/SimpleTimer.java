package gameplay;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple timer for game time.
 * 
 * @author Devin
 */
public class SimpleTimer extends Thread implements Timer {
  private int round = 0;
  private int sleepTime = 0;

  private static final int maxRounds = 50;

  // Create list of observers.
  private List<TimerObserver> timerObservers = new ArrayList<>();

  /**
   * Construct a Simple Timer.
   */
  public SimpleTimer() {

  }

  /**
   * Construct a Simple Timer that can sleep.
   * 
   * @param sleep
   */
  public SimpleTimer(int sleep) {
    sleepTime = sleep;
  }

  /**
   * Add time oberserver to this timer.
   */
  @Override
  public void addTimeObserver(TimerObserver observer) {
    timerObservers.add(observer);
  }

  /**
   * Remove time observer from this timer.
   */
  @Override
  public void removeTimeObserver(TimerObserver observer) {
    timerObservers.remove(observer);
  }

  /**
   * Updates round by one round.
   */
  @Override
  public void timeChanged() {
    round++;
    timerObservers.forEach(ob -> ob.updateTime(round));
  }

  /**
   * Updates round at fixed interval
   */
  public void run() {
    while (round <= maxRounds) {
      try {
        Thread.sleep(sleepTime); // Sleep First
        timeChanged(); // Notify Observers later
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

  /**
   * @return the current round
   */
  public int getRound() {
    return round;
  }

  /**
   * @return the amount of observers.
   */
  public int getNumObservers() {
    return timerObservers.size();
  }

}
