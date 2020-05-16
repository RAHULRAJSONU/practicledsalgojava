package com.silvertech.dsalgo.algo.thirtydaysleetcodechallange;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BackspaceStringCompareTest {

  @Test
  void compare() {
    assertTrue(BackspaceStringCompare.compare("ac#d#c","a#ac#c"));
  }

  @Test
  void compare_negativeScenario() {
    assertTrue(BackspaceStringCompare.compare("#d#c#","###"));
  }

  @Test
  void compare_negativeScenarioWithEmptyString() {
    assertTrue(BackspaceStringCompare.compare("",""));
  }
}