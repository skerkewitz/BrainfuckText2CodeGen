package de.skerkewitz.brainfuck;

import org.apache.commons.lang3.StringUtils;

public class BrainfuckSink {

  private final StringBuilder strBuilder = new StringBuilder();


  /**
   * Add the given brainfuck fragment to this brainfuck sink instance.
   *
   * No validation of any kind is performed!
   *
   * @param fragment a string containing a the brainfuck code fragement.
   */
  public void addRawFragment(String fragment) {
    strBuilder.append(fragment);
  }

  /**
   * Move the head left, right or not all depending on the give value.
   *
   * @param lrSteps negative value will move the head left, positive values will move the head right. Zero will not move
   *                the head at all.
   */
  public void moveHead(int lrSteps) {
    if (lrSteps > 0) {
      addRawFragment(StringUtils.repeat(">", lrSteps));
    } else if (lrSteps < 0) {
      addRawFragment(StringUtils.repeat("<", -lrSteps));
    }
  }

  public void changeCellValue(int steps) {
    if (steps > 0 ) {
      addRawFragment(StringUtils.repeat("+", steps));
    } else if (steps < 0 ) {
      addRawFragment(StringUtils.repeat("-", -steps));
    }
  }

  public void printCurrentCell() {
    addRawFragment(".");
  }


  public String compile() {
    return strBuilder.toString();
  }
}
