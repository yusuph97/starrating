/*
 * @(#)Star.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A label acting as a half of a star<br />
 * Depending on its {@link #index} and {@link #starEnabled} the left/right or
 * enabled/disabled image is used<br />
 * The default stars size is 8x20<br />
 * A {@link StarMouseAdapter} for receiving mouse events
 * @author ssoldatos
 * @since version 0.9
 */
public class Star extends JLabel {

  /** The stars index */
  private final int index;
  /** If it's the left half of the star or not */
  private boolean isLeft;
  /** The left star enabled image */
  public static String LEFT_ENABLED = "images/ls.png";
  /** The left star disabled image */
  public static String LEFT_DISABLED = "images/ls_d.png";
  /** The right star enabled image */
  public static String RIGHT_ENABLED = "images/rs.png";
  /** The right star disabled image */
  public static String RIGHT_DISABLED = "images/rs_d.png";
  /** If the image is the enabled one */
  private final boolean starEnabled;

  /**
   * Creates a Star
   * @param index The star's index.
   * @param enabled If the star uses the enabled image as it's icon
   */
  Star(final int index, boolean enabled) {
    super();
    this.index = index;
    this.starEnabled = enabled;
    setBorder(BorderFactory.createEmptyBorder());
    setPreferredSize(new Dimension(8, 20));
    String image = getImage();
    setBackground(Color.WHITE);
    setOpaque(false);
    setIcon(new ImageIcon(getClass().getResource(image)));
    setCursor(new Cursor(Cursor.HAND_CURSOR));
  }

/**
 * Adds a {@link StarMouseAdapter} for receiving mouse events
 */
  void addStarMouseAdapter(){
    addMouseListener(new StarMouseAdapter(index));
  }

  /**
   * Gets the left half star enabled image icon
   * @return  The image icon
   */
  public ImageIcon getLeftEnabled() {
    return new ImageIcon(getClass().getResource(LEFT_ENABLED));
  }

  /**
   * Gets the left half star disabled image icon
   * @return  The image icon
   */
  public ImageIcon getLeftDisabled() {
    return new ImageIcon(getClass().getResource(LEFT_DISABLED));
  }

  /**
   * Gets the right half star enabled image icon
   * @return  The image icon
   */
  public ImageIcon getRightEnabled() {
    return new ImageIcon(getClass().getResource(RIGHT_ENABLED));
  }

  /**
   * Gets the right half star disabled image icon
   * @return  The image icon
   */
  public ImageIcon getRightDisabled() {
    return new ImageIcon(getClass().getResource(RIGHT_DISABLED));
  }

  /**
   * Sets the star's icon to the disabled one
   */
  void disableStar() {
    if (isLeft) {
      setIcon(getLeftDisabled());
    } else {
      setIcon(getRightDisabled());
    }
  }


  /**
   * Sets the star's icon to the enabled one
   */
  void enableStar() {
    if (isLeft) {
      setIcon(getLeftEnabled());
    } else {
      setIcon(getRightEnabled());
    }
  }

  /**
   * Gets the stars image depending on it's {@link #index}
   * and its {@link #starEnabled}
   * @return the image
   */
  private String getImage() {
    if (index % 2 == 0) {
      isLeft = true;
      return starEnabled ? LEFT_ENABLED : LEFT_DISABLED;
    } else {
      return starEnabled ? RIGHT_ENABLED : RIGHT_DISABLED;
    }
  }
}
