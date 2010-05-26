/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import javax.swing.JLabel;

/**
 * The StarRating value label
 * @author lordovol
 */
public class ValueLabel extends JLabel {

  /**
   * Creates a default value label
   */
  public ValueLabel() {
    super();
  }

  /**
   * Creates a value label with a value of rate
   * @param rate The initial value
   */
  public void setValue(int rate) {
    double d = (double) rate / 2;
    setText(String.valueOf(d));
  }
}
