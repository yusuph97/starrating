/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This is the half of a star
 * @author ssoldatos
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
   * Creates a half star
   * @param im
   * @param index
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
    addMouseListener(new StarMouseAdapter(index,StarMouseAdapter.STAR));
  }

  void addStarMouseAdapter(){
    addMouseListener(new StarMouseAdapter(index,StarMouseAdapter.STAR));
  }

  public ImageIcon getLeftEnabled() {
    return new ImageIcon(getClass().getResource(LEFT_ENABLED));
  }

  public ImageIcon getLeftDisabled() {
    return new ImageIcon(getClass().getResource(LEFT_DISABLED));
  }

  public ImageIcon getRightEnabled() {
    return new ImageIcon(getClass().getResource(RIGHT_ENABLED));
  }

  public ImageIcon getRightDisabled() {
    return new ImageIcon(getClass().getResource(RIGHT_DISABLED));
  }

  void clearRate() {
    if (isLeft) {
      setIcon(getLeftDisabled());
    } else {
      setIcon(getRightDisabled());
    }
  }

  void setRate() {
    if (isLeft) {
      setIcon(getLeftEnabled());
    } else {
      setIcon(getRightEnabled());
    }
  }

  private String getImage() {
    if (index % 2 == 0) {
      isLeft = true;
      return starEnabled ? LEFT_ENABLED : LEFT_DISABLED;
    } else {
      return starEnabled ? RIGHT_ENABLED : RIGHT_DISABLED;
    }
  }
}
