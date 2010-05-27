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

  /**
   * 
   * @param sr
   * @param index
   */
  public StarMouseAdapter(int index) {
    this.index = index;
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
      sr.previewRate((double) index / 2);
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
      sr.setRate((double) index / 2);
      sr.previewRate((double) index / 2);
      if (sr.getParent() instanceof JTable) {
        JTable table = (JTable) sr.getParent();
        table.getCellEditor().stopCellEditing();
      }
      super.mouseClicked(e);
    }
  }

  private void processEvent(MouseEvent e) {
    Object source = e.getSource();
    if (source instanceof Star) {
      star = (Star) source;
      sr = (StarRating) star.getParent();
    } else if (source instanceof RemoveButton) {
      removeButton = (RemoveButton) source;
      sr = (StarRating) removeButton.getParent();
    }
  }
}
