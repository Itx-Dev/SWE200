package environment;

import lifeform.LifeForm;

/**
 * A cell that can hold a LifeForm.
 */
public class Cell {
  LifeForm lifeForm;
  int numOfLifeForms;

  /**
   * Constructor of Cell class.
   */
  public Cell() {
    numOfLifeForms = 0;
  }

  /**
   * @return the LifeForm in this Cell.
   */
  protected LifeForm getLifeForm() {
    return lifeForm;
  }

  /**
   * Tries to add the LifeForm to the Cell. Will not add if a LifeForm is already
   * present.
   * 
   * @param lf
   * @param entity the lifeform held in the cell.
   * @return true if the LifeForm was added to the Cell, false otherwise.
   */
  protected boolean addLifeForm(LifeForm entity) {
    // Only space for one life form
    if (numOfLifeForms < 1) {
      // Set instance life form equal to one passed.
      lifeForm = entity;
      // Count life forms in cell
      numOfLifeForms++;
      return true;
    } else {
      return false;
    }
  }

  protected void removeLifeForm() {
    // Remove life form from cell.
    lifeForm = null;
    // Indicate removal of life form.
    numOfLifeForms--;
  }
}
