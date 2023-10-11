package gameplay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Class to test simple timer class.
 * 
 * @author Devin
 */
public class TestSimpleTimer {

  /**
   * Test a simple timer can be made.
   */
  @Test
  public void testSimpleTimerInitialization() {
    SimpleTimer timer = new SimpleTimer();

    // Check the round starts at zero.
    int round = timer.getRound();
    assertEquals(0, round);

    // Check that there are no observers.
    int observers = timer.getNumObservers();
    assertEquals(0, observers);

    // Checks that SimpleTiemr timer is of type Timer.
    assertTrue(timer instanceof Timer);
  }

  /**
   * Test the addition of an observer.
   */
  @Test
  public void testAddingObserver() {
    MockSimpleTimerObserver timerObserver = new MockSimpleTimerObserver();
    SimpleTimer timer = new SimpleTimer();

    // Add observer to timer.
    timer.addTimeObserver(timerObserver);

    // Find number of observers in observer list.
    int sizeOfObserverList = timer.getNumObservers();

    // Check that the observer was added.
    assertEquals(1, sizeOfObserverList);
  }

  /**
   * Test timer.timeChanged() functions properly without observers
   */
  @Test
  public void testIncrementOfRoundsNoObserver() {
    SimpleTimer timer = new SimpleTimer();
    // Check that rounds start at zero
    assertEquals(0, timer.getRound());
    // Update Round
    timer.timeChanged();
    // Check that round incremented when timeChanged() was called
    assertEquals(1, timer.getRound());
  }

  /**
   * Test timer.timeChanged() functions properly with observers
   */
  @Test
  public void testIncrementOfRoundsWithObservers() {
    MockSimpleTimerObserver timerObserver = new MockSimpleTimerObserver();
    SimpleTimer timer = new SimpleTimer();
    // Check that observer was added.
    timer.addTimeObserver(timerObserver);
    assertEquals(1, timer.getNumObservers());
    // Check that second observer was added.
    timer.addTimeObserver(timerObserver);
    assertEquals(2, timer.getNumObservers());

    // Check that rounds start at zero
    assertEquals(0, timer.getRound());

    // Check that round incremented when timeChanged() was called
    timer.timeChanged();
    assertEquals(1, timer.getRound());

    // Check that round incremented by 1 when timeChanged() was called.
    timer.timeChanged();
    assertEquals(2, timer.getRound());
  }

  /**
   * This tests that SimpleTimer will update time once every second.
   * 
   * @throws InterruptedException
   */
  @Test
  public void testSimpleTimerAsThread() throws InterruptedException {
    SimpleTimer st = new SimpleTimer(1000);
    st.start();
    Thread.sleep(250); // So we are 1/4th a second different
    for (int x = 0; x < 5; x++) {
      assertEquals(x, st.getRound()); // assumes round starts at 0
      Thread.sleep(1000); // wait for the next time change
    }
  }

}
