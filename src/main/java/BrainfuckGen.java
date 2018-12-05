import org.apache.commons.lang3.StringUtils;

public class BrainfuckGen {

  static String bf_buildHeader() {

    // this will build the start cells "{0, 10, 30, 60, 80, 100, 120}"
    return "++++++++++\n" + // we need 10 interation
            "\n" +
            "[-\n" +
            ">+\n" +
            ">+++\n" +
            ">++++++\n" +
            ">++++++++\n" +
            ">++++++++++\n" +
            ">++++++++++++\n" +
            "<<<<<<\n" +
            "]";

  }


  public static void main(String[] args) {
    System.out.println("Hello World");

    /* The text we want to generate the BF code for. */
    var strIn = "aAHallo WorldzZ\nBlah";

    System.out.println(bf_buildHeader());

    int currentCellIdx = 0;
    int[] startCell = {0, 10, 30, 60, 80, 100, 120};
    int[] currentCell = {0, 10, 30, 60, 80, 100, 120};

    for (int i = 0; i < strIn.length(); i++) {
      int charValue = (strIn.charAt(i));
      int bestIdx = findBestIndex(startCell, charValue);

      int lrSteps = bestIdx - currentCellIdx;
      bf_MoveHead(lrSteps);

      currentCellIdx = bestIdx;
      int steps = charValue - currentCell[currentCellIdx];
      bf_ChangeValue(steps);
      bf_PrintCurrentCell();

      currentCell[currentCellIdx] += steps;

     // System.out.println("Char " + (char)charValue + " " + bestIdx + " " + lrSteps + " " + steps + " " + charValue);
    }
  }

  private static void bf_PrintCurrentCell() {
    System.out.println(".");
  }

  private static void bf_ChangeValue(int steps) {
    if (steps > 0 ) {
      System.out.println(StringUtils.repeat("+", steps));
    }
    else if (steps < 0 ) {
      System.out.println(StringUtils.repeat("-", -steps));
    }
  }

  private static void bf_MoveHead(int lrSteps) {
    if (lrSteps > 0) {
      System.out.println(StringUtils.repeat(">", lrSteps));
    } else if (lrSteps < 0) {
      System.out.println(StringUtils.repeat("<", -lrSteps));
    }
  }

  static int findBestIndex(int[] a, int searchValue) {

    int bestIdx = 0;
    int cost = Math.abs(a[bestIdx] - searchValue);
    for (int i = 1; i <a.length; i++) {
      int testCost = Math.abs(a[i] - searchValue);
      if (testCost < cost) {
        cost = testCost;
        bestIdx = i;
      }
    }

    return bestIdx;
  }

}
