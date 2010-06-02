/*
 * @(#)Star.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A  acting as a half of a star<br />
 * Depending on its {@link #index} and {@link #starEnabled} the left/right or
 * enabled/disabled image is used<br />
 * The default stars size is 8x20<br />
 * A {@link StarMouseAdapter} can be added for receiving mouse events
 * @author ssoldatos
 * @since version 0.9
 */
class Star extends JLabel implements StarRatingConstants {

  private static final long serialVersionUID = 454564635L;
  /** The stars index */
  private final int index;
  /** If it's the left half of the star or not */
  private boolean isLeft;
  /** If the image is the enabled one */
  private boolean starEnabled;
  /** The buffered image of the star **/
  private BufferedImage starBuffImage;
  /** The image that's used as a star **/
  private ImageIcon wholeStarImage;

  /**
   * Creates a Star
   * @param index The star's index.
   * @param enabled If the star uses the enabled image as it's icon
   * @param wholeStarImage The ImageIcon of the star image to use
   */
  Star(final int index, boolean enabled, ImageIcon wholeStarImage) {
    super();
    this.index = index;
    this.starEnabled = enabled;
    this.wholeStarImage = resizeImage(wholeStarImage);
    createBufferedImage();
    setIcon(getHalfStarImage());
    setBorder(BorderFactory.createEmptyBorder());
    setPreferredSize(new Dimension(STAR_IMAGE_WIDTH, STAR_RATING_HEIGHT));
    setOpaque(false);
    setCursor(new Cursor(Cursor.HAND_CURSOR));
  }

  /**
   * Adds a {@link StarMouseAdapter} for receiving mouse events
   */
  void addStarMouseAdapter() {
    addMouseListener(new StarMouseAdapter(this));
  }

  /**
   * Get the star's index
   * @return the index
   */
  int getIndex() {
    return index;
  }

  /**
   * Sets the star's icon to the disabled one
   */
  void disableStar() {
    starEnabled = false;
    if (isLeft) {
      setIcon(getSplittedImage(0, false));
    } else {
      setIcon(getSplittedImage(1, false));
    }
  }

  /**
   * Sets the star's icon to the enabled one
   */
  void enableStar() {
    starEnabled = true;
    if (isLeft) {
      setIcon(getSplittedImage(0, true));
    } else {
      setIcon(getSplittedImage(1, true));
    }
  }

  /**
   * Gets the stars half image depending on it's {@link #index}
   * and its {@link #starEnabled}
   * @return the half of the stars image
   */
  ImageIcon getHalfStarImage() {
    if (getIndex() % 2 == 0) {
      isLeft = true;
      return starEnabled ? getSplittedImage(0, true) : getSplittedImage(0, false);
    } else {
      return starEnabled ? getSplittedImage(1, true) : getSplittedImage(1, false);
    }
  }

  private ImageIcon getSplittedImage(int index, boolean opaque) {
    int w = starBuffImage.getWidth() / 2;
    int h = starBuffImage.getHeight();
    int num = 0;
    BufferedImage img;
    for (int y = 0; y < 2; y++) {
      for (int x = 0; x < 2; x++) {
        if (num == index) {
          img = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
          // Tell the graphics to draw only one block of the image
          Graphics2D g = img.createGraphics();
          if (!opaque) {
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, TRANSPARENCY));
            g.drawImage(img, null, 0, 0);
          }
          g.drawImage(starBuffImage, 0, 0, w, h, w * x, h * y, w * x + w, h * y + h, null);
          g.dispose();
          return new ImageIcon(img);
        }
        num++;
      }
    }

    return null;
  }

  /**
   * Gets the star image to use
   * @return the starImage
   */
  ImageIcon getWholeStarImage() {
    return wholeStarImage;
  }

  /**
   * Sets the star image to use.
   * @param starImage the starImage to set
   */
  void setWholeStarImage(ImageIcon starImage) {
    this.wholeStarImage = resizeImage(starImage);
    createBufferedImage();
    setIcon(getHalfStarImage());
    validate();
    repaint();
  }

  private void createBufferedImage() {
    starBuffImage = new BufferedImage(wholeStarImage.getIconWidth(), wholeStarImage.getIconHeight(), 6);
    Image im = wholeStarImage.getImage();
    Graphics2D g = starBuffImage.createGraphics();
    g.drawImage(im, 0, 0, this);

  }

  private ImageIcon resizeImage(ImageIcon icon) {
    int w = icon.getIconWidth();
    int h = icon.getIconHeight();
    double r = (double) w / h;
    int newHeight = STAR_IMAGE_HEIGHT;
    int newWidth = (int) (STAR_IMAGE_HEIGHT * r);
    Image image = icon.getImage();
    Image scaled = image.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
    return new ImageIcon(scaled);
  }
}
