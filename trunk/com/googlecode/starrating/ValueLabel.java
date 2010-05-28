/*
 * @(#)ValueLabel.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * A label displaying the {@link StarRating} rate.
 * @author lordovol
 * @since version 0.9
 */
public class ValueLabel extends JLabel {

  /**
   * Creates a default value label
   */
  public ValueLabel() {
  }

  /**
   * Creates a {@link ValueLabel} with a default text
   * @param rate The rate
   */
  public ValueLabel(double rate) {
    super();
    setOpaque(false);
    setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    setValue(rate);
  }

  /**
   * Sets the {@link ValueLabel} text
   * @param rate The text
   */
  public void setValue(double rate) {
    setText(String.valueOf(rate));
  }
}
