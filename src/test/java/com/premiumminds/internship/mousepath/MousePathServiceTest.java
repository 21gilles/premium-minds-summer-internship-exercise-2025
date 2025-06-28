package com.premiumminds.internship.mousepath;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MousePathServiceTest {

  public MousePathServiceTest() {
  }

  @Test
  void horizontalStraight() {
    final char[][] grid = this.convert(new String[] {
      "     ",
      "X---X",
      "     "
    });
    assertTrue(new MousePathService().isValidGrid(grid));
  }

  @Test
  void verticalStraight() {
    final char[][] grid = this.convert(new String[] {
      "X  ",
      "|  ",
      "|  ",
      "|  ",
      "X  "
    });
    assertTrue(new MousePathService().isValidGrid(grid));
  }

  @Test
  void simpleCorner() {
    final char[][] grid = this.convert(new String[] {
      "X-+  ",
      "  |  ",
      "  X  "
    });
    assertTrue(new MousePathService().isValidGrid(grid));
  }

  @Test
  void adjacentEndpointsRow() {
    final char[][] grid = this.convert(new String[] {
      "XX"
    });
    assertTrue(new MousePathService().isValidGrid(grid));
  }

  @Test
  void adjacentEndpointsCol() {
    final char[][] grid = this.convert(new String[] {
      "X",
      "X"
    });
    assertTrue(new MousePathService().isValidGrid(grid));
  }

  @Test
  void missingCorner() {
    final char[][] grid = this.convert(new String[] {
      "X-+X"
    });
    assertFalse(new MousePathService().isValidGrid(grid));
  }

  @Test
  void loopPath() {
    final char[][] grid = this.convert(new String[] {
      "X-+-X",
      "|   |",
      "X---X"
    });
    assertFalse(new MousePathService().isValidGrid(grid));
  }

  @Test
  void extraLineSegment() {
    final char[][] grid = this.convert(new String[] {
      "X-+  ",
      "| |  ",
      "X-+  ",
      "  |X "
    });
    assertFalse(new MousePathService().isValidGrid(grid));
  }

  @Test
  void PersonNoChildrenTest() {
    final char[][] grid = this.convert(new String[] {
      "           ",
      "X---------X",
      "           ",
      "           "
    });
    assertTrue(new MousePathService().isValidGrid(grid));
  }

  @Test
  void PersonOneChildTest() {
    final char[][] grid = this.convert(new String[] {
      " X  ",
      " |  ",
      " +  ",
      " X  "
    });
    assertFalse(new MousePathService().isValidGrid(grid));
  }

  private char[][] convert(String[] input) {
    if (input == null) {
      return new char[0][0];
    }
    int rows = input.length;
    int cols = 0;
    for (String s : input) {
      if (s != null) {
        cols = Math.max(cols, s.length());
      }
    }

    char[][] result = new char[rows][cols];

    for (int i = 0; i < rows; i++) {
      if (input[i] != null) {
        for (int j = 0; j < input[i].length(); j++) {
          result[i][j] = input[i].charAt(j);
        }
      }
    }

    return result;
  }
}
