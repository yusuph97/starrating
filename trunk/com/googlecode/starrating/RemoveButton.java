/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author ssoldatos
 */
public class RemoveButton extends JLabel {

  private static String REMOVE_IMAGE = "images/remove.png";

  public RemoveButton() {
    super();
    setBorder(BorderFactory.createEmptyBorder());
    setOpaque(false);
    setBackground(Color.WHITE);
    setPreferredSize(new Dimension(20, 20));
    setIcon(new ImageIcon(getClass().getResource(REMOVE_IMAGE)));
    addMouseListener(new MouseAdapter() {

      @Override
      public void mouseEntered(MouseEvent e) {
        StarRating sr = getSRating();
        if (sr.isEnabled()) {
          sr.previewRate(0.0);
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
          sr.setRate(0.0);
          sr.previewRate(0.0);
          super.mouseClicked(e);
        }
      }
    });
  }

  private StarRating getSRating() {
    return (StarRating) getParent().getParent();
  }
}
