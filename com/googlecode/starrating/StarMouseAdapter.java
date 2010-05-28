/*
 * @(#)StarMouseAdapter.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 * A MouseAdapter for receiving mouse events
 * @author ssoldatos
 * @since version 0.9
 */
class StarMouseAdapter extends MouseAdapter {

  /** The source object's index if it's a {@link Star} or -1 if the source is a
   * {@link RemoveButton}  */
  private final int index;
  /** The {@link #sourceType} for a {@link Star} source  */
  static int STAR = 0;
  /** The {@link #sourceType} for a {@link RemoveButton} source  */
  static int REMOVE_BUTTON = 1;
  /** The event's source type:<br />
   *           <code>STAR</code>,
   *           <code>REMOVE_BUTTON</code>,*/
  private final int sourceType;

  /**
   * Creates a {@link StarMouseAdapter} for a {@link Star} with an index of
   * {@link #index}<br />
   * If index is -1 the source is a {@link RemoveButton} else it's a {@link Star}
   * @param index
   */
  public StarMouseAdapter(int index) {
    this.index = index;
    this.sourceType = index == -1 ? REMOVE_BUTTON : STAR;
  }

  /**
   * If {@link StarRating} rating is enabled it sets it's background color to
   * white and opaque to true<br />
   * If source is {@link RemoveButton} sets it's icon to the enabled one and
   * the {@link ValueLabel} text to 0.0
   */
  @Override
  public void mouseEntered(MouseEvent e) {
    StarRating sr = processEvent(e);
    if (sr.isEnabled()) {
      sr.setBackground(Color.WHITE);
      sr.setOpaque(true);
      if (sourceType == REMOVE_BUTTON) {
        RemoveButton removeButton = (RemoveButton) e.getSource();
        removeButton.setIcon(new ImageIcon(getClass().getResource(RemoveButton.REMOVE_IMAGE)));
      }
      sr.previewRate((double) (index + 1) / 2);
      super.mouseEntered(e);
    }
  }

  /**
   * If {@link StarRating} rating is enabled it sets it's opaque to false<br />
   * If source is {@link RemoveButton} sets it's icon to the disabled one and
   * previews the {@link ValueLabel} text to the {@link StarRating} rate
   */
  @Override
  public void mouseExited(MouseEvent e) {
    StarRating sr = processEvent(e);
    if (sr.isEnabled()) {
      //sr.setBackground(sr.getParent().getBackground());
      sr.setOpaque(false);
      if (sourceType == REMOVE_BUTTON) {
        RemoveButton removeButton = (RemoveButton) e.getSource();
        removeButton.setIcon(new ImageIcon(getClass().getResource(RemoveButton.REMOVE_IMAGE_DISABLED)));
      }
      sr.setRate(sr.getRate());
      super.mouseExited(e);
    }
  }

  /**
   * If {@link StarRating} rating is enabled it sets the {@link StarRating} rate
   * and the {@link ValueLabel} text to the one selected.<br />
   * If {@link StarRating} is used as a {@link StarTableCellEditor} it stops the
   * cell editing by calling {@link StarTableCellEditor#stopCellEditing()}
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    StarRating sr = processEvent(e);
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

  /**
   * Proccesses the event and gets the {@link StarRating} that originated the event
   * @param event The Mouse event
   */
  private StarRating processEvent(MouseEvent event) {
    if (sourceType == STAR) {
      Star star = (Star) event.getSource();
      return  (StarRating) star.getParent();
    } else if (sourceType == REMOVE_BUTTON) {
      RemoveButton removeButton = (RemoveButton) event.getSource();
      return (StarRating) removeButton.getParent();
    }
    return null;
  }
}
