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
public class Star extends JLabel implements StarRatingConstants{

  /** The stars index */
  private final int index;
  /** If it's the left half of the star or not */
  private boolean isLeft;
  /** If the image is the enabled one */
  private boolean starEnabled;
  /** The buffered image of the star **/
  private BufferedImage starBuffImage;
  /** The Url of the star image **/
  private URL url;
  private URL starImage;

  /**
   * Creates a Star
   * @param index The star's index.
   * @param enabled If the star uses the enabled image as it's icon
   * @param starImage The URL of the star image to use
   */
  Star(final int index, boolean enabled, URL starImage) {
    super();
    this.index = index;
    this.starEnabled = enabled;
    this.starImage = starImage;
    setIcon(starImage);
    setBorder(BorderFactory.createEmptyBorder());
    setPreferredSize(new Dimension(STAR_IMAGE_WIDTH, STAR_RATING_HEIGHT));
    setOpaque(false);
    setCursor(new Cursor(Cursor.HAND_CURSOR));
  }

   /**
   * Adds a {@link StarMouseAdapter} for receiving mouse events
   */
  public void addStarMouseAdapter() {
    addMouseListener(new StarMouseAdapter(this));
  }

  /**
   * Sets the star's icon to the disabled one
   */
  public void disableStar() {
    starEnabled = false;
    if (isLeft) {
      setIcon(new ImageIcon(getSplittedImage(0, false)));
    } else {
      setIcon(new ImageIcon(getSplittedImage(1, false)));
    }
  }

  /**
   * Sets the star's icon to the enabled one
   */
  public void enableStar() {
    starEnabled = true;
    if (isLeft) {
      setIcon(new ImageIcon(getSplittedImage(0, true)));
    } else {
      setIcon(new ImageIcon(getSplittedImage(1, true)));
    }
  }

  /**
   * Gets the stars image depending on it's {@link #index}
   * and its {@link #starEnabled}
   * @return the image
   */
  private BufferedImage getImage() {
    if (getIndex() % 2 == 0) {
      isLeft = true;
      return starEnabled ? getSplittedImage(0, true) : getSplittedImage(0, false);
    } else {
      return starEnabled ? getSplittedImage(1, true) : getSplittedImage(1, false);
    }
  }

  /**
   * @return the index
   */
  public int getIndex() {
    return index;
  }

  private BufferedImage getSplittedImage(int index, boolean opaque) {
    int w = starBuffImage.getWidth() / 2;
    int h = starBuffImage.getHeight() / 1;
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
          return img;
        }
        num++;
      }
    }

    return null;
  }

  /**
   * @return the starImage
   */
  public URL getStarImage() {
    return starImage;
  }

  /**
   * @param starImage the starImage to set
   */
  public void setStarImage(URL starImage) {
    setIcon(starImage);
  }

  private void setIcon(URL starImage) {
    try {
      starBuffImage = ImageIO.read(starImage);
    } catch (IOException ex1) {
      url = Star.class.getResource(StarRating.STAR_IMAGE);
      try {
        starBuffImage = ImageIO.read(url);
      } catch (IOException ex) {
      }
    }
    starBuffImage = StarRating.resizeImage(starBuffImage, STAR_IMAGE_HEIGHT);
    BufferedImage image = getImage();
    setIcon(new ImageIcon(image));
    validate();
    repaint();
  }
}
