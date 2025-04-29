package com.premiumminds.internship.mousepath;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class MousePathServiceTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public MousePathServiceTest() {
  };

  @Test
  public void PersonNoChildrenTest() {
    final char[][] grid = this.convert(new String[] {
      "           ",
      "X---------X",
      "           ",
      "           "
      });
      ;
      assertTrue(new MousePathService().isValidGrid(grid));
  }

  @Test
  public void PersonOneChildTest() {
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
