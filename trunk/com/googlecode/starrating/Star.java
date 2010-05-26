/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    this.index = index;
    this.starEnabled = enabled;
    String image = getImage();
    setIcon(new ImageIcon(getClass().getResource(image)));

    addMouseListener(new MouseAdapter() {

      @Override
      public void mouseEntered(MouseEvent e) {
        StarRating sr = getSRating();
        if (sr.isEnabled()) {
          sr.previewRate(index);
          super.mouseEntered(e);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        StarRating sr = getSRating();
        if (sr.isEnabled()) {
          sr.setRate(sr.getRate());
          super.mouseExited(e);
        }
      }

      @Override
      public void mouseClicked(MouseEvent e) {
        StarRating sr = getSRating();
        if (sr.isEnabled()) {
          sr.setRate(index);
          sr.previewRate(index);
          super.mouseClicked(e);
        }
      }
    });

  }

  private StarRating getSRating() {
    return (StarRating) getParent().getParent();
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
    if (index % 2 == 1) {
      isLeft = true;
      return starEnabled ? LEFT_ENABLED : LEFT_DISABLED;
    } else {
      return starEnabled ? RIGHT_ENABLED : RIGHT_DISABLED;
    }
  }
}
