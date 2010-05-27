/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author ssoldatos
 */
class StarMouseAdapter extends MouseAdapter {

  private StarRating sr;
  private final int index;
  private Star star;
  private RemoveButton removeButton;
  static int STAR = 0;
  static int REMOVE_BUTTON = 1;
  private final int sourceType;

  /**
   * 
   * @param sr
   * @param index
   */
  public StarMouseAdapter(int index, int sourceType) {
    this.index = index;
    this.sourceType = sourceType;
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    processEvent(e);
    if (sr.isEnabled()) {
      sr.setBackground(Color.WHITE);
      sr.setOpaque(true);
      if (removeButton != null) {
        removeButton.setIcon(new ImageIcon(getClass().getResource(RemoveButton.REMOVE_IMAGE)));
      }
      sr.previewRate((double) (index + 1) / 2);
      super.mouseEntered(e);
    }
  }

  @Override
  public void mouseExited(MouseEvent e) {
    processEvent(e);
    if (sr.isEnabled()) {
      sr.setBackground(sr.getParent().getBackground());
      sr.setOpaque(false);
      if (removeButton != null) {
        removeButton.setIcon(new ImageIcon(getClass().getResource(RemoveButton.REMOVE_IMAGE_DISABLED)));
      }
      sr.setRate(sr.getRate());
      super.mouseExited(e);
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    processEvent(e);
    if (sr.isEnabled()) {
      sr.setRate((double) (index + 1) / 2);
      sr.previewRate((double) (index + 1) / 2);
      if (sr.getParent() instanceof JTable) {
        JTable table = (JTable) sr.getParent();
        table.getCellEditor().stopCellEditing();
      }
      super.mouseClicked(e);
    }
  }

  private void processEvent(MouseEvent e) {
    if (sourceType == STAR) {
      star = (Star) e.getSource();
      sr = (StarRating) star.getParent();
    } else if (sourceType == REMOVE_BUTTON) {
      removeButton = (RemoveButton) e.getSource();
      sr = (StarRating) removeButton.getParent();
    }
  }
}
