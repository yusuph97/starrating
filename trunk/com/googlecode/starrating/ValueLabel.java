/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import java.awt.Dimension;
import javax.swing.BorderFactory;
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
    
  }

  ValueLabel(double rate) {
    super();
    setOpaque(false);
    setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    setValue(rate);
  }

  /**
   * Creates a value label with a value of rate
   * @param rate The initial value
   */
  public void setValue(double rate) {
    setText(String.valueOf(rate));
  }
}
