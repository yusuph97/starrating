/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.starrating.demo;

import com.googlecode.starrating.StarRating;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

/**
 *
 * @author ssoldatos
 */
public class StarComboRenderer extends JLabel implements ListCellRenderer {
   private static final long serialVersionUID = 3245364674576L;
  private BufferedImage starBuffImage;

  public StarComboRenderer() {
    setOpaque(true);
    setHorizontalAlignment(LEFT);
    setVerticalAlignment(CENTER);
    setBorder(BorderFactory.createEmptyBorder());
    setPreferredSize(new Dimension(this.getWidth(), 20));
  }

  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    if (isSelected) {
      setBackground(list.getSelectionBackground());
      setForeground(list.getSelectionForeground());
    } else {
      setBackground(list.getBackground());
      setForeground(list.getForeground());
    }
    try {
      File f = (File) value;
      starBuffImage = ImageIO.read(f);
      setText(f.getName());
      starBuffImage = StarRating.resizeImage(starBuffImage, 16);
    } catch (IOException ex) {
      return this;
    } catch(IllegalArgumentException ex){
      return this;
    }
    setIcon(new ImageIcon(starBuffImage));
    return this;
  }

  
}
