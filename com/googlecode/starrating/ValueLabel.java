/*
 * @(#)ValueLabel.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * A label displaying the {@link StarRating} rate.
 * @author lordovol
 * @since version 0.9
 */
public class ValueLabel extends JLabel {

  /**
   * Creates a default {@link ValueLabel}
   */
  public ValueLabel() {
  }

  /**
   * Creates a {@link ValueLabel} and sets it's text to rate
   * @param rate The rate
   */
  public ValueLabel(double rate) {
    super();
    setOpaque(false);
    setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 0));
    setHorizontalAlignment(SwingConstants.RIGHT);
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
