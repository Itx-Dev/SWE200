package environment;

import lifeform.LifeForm;

/**
 * @author Devin Creates environment for life forms to live in.
 */
public class Environment {
  Cell[][] cells;
  int rows;
  int cols;

  /**
   * Initialize the environment with specified size of cells.
   * 
   * @param rows
   * @param cols
   */
  public Environment(int rows, int cols) {
    // Initialize size of cell array.
    cells = new Cell[rows][cols];
    this.rows = rows;
    this.cols = cols;
  }

  /**
   * Find life form in specified cell.
   * 
   * @param row
   * @param col
   * @return Life form at specified cell row and column values.
   */
  protected LifeForm getLifeForm(int row, int col) {
    try {
      /*
       * return current life form in cell if no life form is there return null
       */
      LifeForm currentLifeForm = cells[row][col].getLifeForm();
      return currentLifeForm;
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Add life form cell to specified location in cell array.
   * 
   * @param lf
   * @param row
   * @param col
   * @return true if life form was added, false if life form failed to be added.
   * @throws Exception
   */
  protected boolean addLifeForm(LifeForm lf, int row, int col) throws Exception {
    try {
      // Create cell to track given life form.
      Cell lifeFormCell = new Cell();
      // Add given life form to newly created cell.
      lifeFormCell.addLifeForm(lf);
      // Add newly created cell to array of cells at specified location.
      cells[row][col] = lifeFormCell;
      return true;
    } catch (Exception e) {
      /*
       * If row or column entered is too large or small for environment throw
       * exception
       */
      if (row > rows || col > cols || col < 0 || row < 0) {
        throw new Exception("Row or Column is out of range of environment ");
      }
      return false;
    }
  }

  /**
   * Remove life form from specified cell.
   * 
   * @param row
   * @param col
   */
  protected void removeLifeForm(int row, int col) {
    cells[row][col] = null;
  }

}
