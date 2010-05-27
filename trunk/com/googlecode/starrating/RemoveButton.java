/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import java.awt.Color;
import java.awt.Cursor;
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

  public static String REMOVE_IMAGE = "images/remove.png";
  public static String REMOVE_IMAGE_DISABLED = "images/remove_d.png";

  public RemoveButton() {
    super();
    setBorder(BorderFactory.createEmptyBorder());
    setOpaque(false);
    setBackground(Color.WHITE);
    setPreferredSize(new Dimension(20, 20));
    setIcon(new ImageIcon(getClass().getResource(REMOVE_IMAGE_DISABLED)));
    setCursor(new Cursor(Cursor.HAND_CURSOR));
    addMouseListener(new StarMouseAdapter(0));
  }

  
}
