package com.silvertech.dsalgo.algo.array;

import static org.junit.jupiter.api.Assertions.*;

import com.silvertech.dsalgo.utility.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DutchNationalFlagTest {

  private DutchNationalFlag dnf;

  @BeforeEach
  void setUp() {
    dnf = new DutchNationalFlag();
  }

  @AfterEach
  void tearDown() {
    dnf=null;
  }

  @Test
  void solve() {
    int[] inp = {0,1,0,1,2,1,2,0,1};
    this.dnf.solve(inp);
    assertTrue(Utils.isSorted(inp));
  }
}