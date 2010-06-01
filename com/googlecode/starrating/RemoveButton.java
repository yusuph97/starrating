/*
 * @(#)RemoveButton.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GrayFilter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A {@link JLabel} that acts like a button for clearing the rate (sets it to 0.0)
 * The label has a default size of 20x20 with an empty border<br />
 * A {@link StarMouseAdapter} can be added for receiving mouse events
 * @author ssoldatos
 * @since version 0.9
 */
public class RemoveButton extends JLabel implements StarRatingConstants {

  private static final long serialVersionUID = 3453546456L;

  /**
   * Creates a RemoveButton
   */
  public RemoveButton() {
    super();
    setBorder(BorderFactory.createEmptyBorder(0, 0, 0, REMOVE_BUTTON_GAP));
    setIcon(new ImageIcon(getClass().getResource(REMOVE_BUTTON_IMAGE)));
    setIcon(getDisabledIcon());
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    setOpaque(false);
    setPreferredSize(new Dimension(REMOVE_BUTTON_WIDTH + REMOVE_BUTTON_GAP, STAR_RATING_HEIGHT));
  }

 
}

