/*
 * @(#)RemoveButton.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A {@link JLabel} that acts like a button for clearing the rate (sets it to 0.0)
 * The label has a default size of 20x20 with an empty border<br />
 * A {@link StarMouseAdapter} can be added for receiving mouse events
 * @author ssoldatos
 * @since version 0.9
 */
public class RemoveButton extends JLabel {

  /** The label's icon enabled image */
  public static String REMOVE_IMAGE = "images/remove.png";

  /**
   * Creates a RemoveButton
   */
  public RemoveButton() {
    super();
    setBorder(BorderFactory.createEmptyBorder());
    setPreferredSize(new Dimension(20, 20));
    setIcon(new ImageIcon(getClass().getResource("images/remove.png")));
    setIcon(getDisabledIcon());
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    setOpaque(false);
  }

  
}
