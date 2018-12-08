package de.skerkewitz.brainfuck;

import de.skerkewitz.brainfuck.BrainfuckSink;

public class BrainfuckGen {

  /**
   * This will build our character cells.
   */
  private static String defaultCharacterTable() {

    // this will build the start cells "{0, 10, 30, 60, 80, 100, 120}"
    return "++++++++++" + // we need 10 interation
            "[-" +
            ">+" +
            ">+++" +
            ">++++++" +
            ">++++++++" +
            ">++++++++++" +
            ">++++++++++++" +
            "<<<<<<" +
            "]";
  }

  public static void main(String[] args) {

    /* The text we want to generate the BF code for. */
    var strIn = args[0];

    var brainfuckSink = new BrainfuckSink();
    brainfuckSink.addRawFragment(defaultCharacterTable());

    int currentCellIdx = 0;
    int[] startCell = {0, 10, 30, 60, 80, 100, 120};
    int[] currentCell = {0, 10, 30, 60, 80, 100, 120};

    for (int i = 0; i < strIn.length(); i++) {
      int charValue = (strIn.charAt(i));
      int bestIdx = findBestCellIndex(startCell, charValue);

      int lrSteps = bestIdx - currentCellIdx;
      brainfuckSink.moveHead(lrSteps);

      currentCellIdx = bestIdx;
      int steps = charValue - currentCell[currentCellIdx];
      brainfuckSink.changeCellValue(steps);
      brainfuckSink.printCurrentCell();

      currentCell[currentCellIdx] += steps;

     // System.out.println("Char " + (char)charValue + " " + bestIdx + " " + lrSteps + " " + steps + " " + charValue);
    }

    System.out.println("Brainfuck code:\n" + brainfuckSink.compile());
  }

  /**
   * Find the best suited cell (lowest absolute distance) in the given array.
   *
   * @param cells the cell array to use
   * @param searchValue the value we are looking for
   * @return the cell with the lowest absolute distance from the search value.
   */
  private static int findBestCellIndex(int[] cells, int searchValue) {

    int bestIdx = 0;
    int cost = Math.abs(cells[bestIdx] - searchValue);
    for (int i = 1; i <cells.length; i++) {
      int testCost = Math.abs(cells[i] - searchValue);
      if (testCost < cost) {
        cost = testCost;
        bestIdx = i;
      }
    }

    return bestIdx;
  }
}
