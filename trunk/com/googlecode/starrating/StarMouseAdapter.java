/*
 * @(#)StarMouseAdapter.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 * A MouseAdapter for receiving mouse events
 * @author ssoldatos
 * @since version 0.9
 */
class StarMouseAdapter extends MouseAdapter {

  /** The source object's index if it's a {@link Star} or -1 if the source is a
   * {@link RemoveButton} or {@link ValueLabel} */
  private int index = -1;
  /** The {@link #sourceType} for a {@link Star} source  */
  static int STAR = 0;
  /** The {@link #sourceType} for a {@link RemoveButton} source  */
  static int REMOVE_BUTTON = 1;
  /** The {@link #sourceType} for {@link ValueLabel}   source   */
  static int VALUE_LABEL = 2;
  /** The {@link #sourceType} for {@link ValueLabel}   source   */
  static int STARRATING = 3;
  /** The event's source type:<br />
   *           <code>STAR</code>,
   *           <code>REMOVE_BUTTON</code>,
   *           <code>VALUE_LABEL</code>,
   *           <code>STARRATING</code>,
   */
  private int sourceType = REMOVE_BUTTON;
  /** The {@link StarRating} that the source component belongs */
  private StarRating starRating;
  /** If starrating is a table editor **/
  private boolean isTableEditor;
  /** If rating is enabled **/
  private boolean enabledStatus;

  /**
   * Creates a {@link StarMouseAdapter} to receive mouse events from a component
   * that can be a {@link Star}, a {@link RemoveButton}, a {@link ValueLabel} or
   * a {@link StarRating}<br />
   * If the component is not of one of these types an IllegalArgument exception is thrown
   * @param source The source component of this event
   */
  public StarMouseAdapter(Component source) {
    this.starRating = (StarRating) source.getParent();
    if (source instanceof Star) {
      Star star = (Star) source;
      this.index = star.getIndex();
      this.sourceType = STAR;
    } else if (source instanceof RemoveButton) {
      this.index = -1;
      this.sourceType = REMOVE_BUTTON;
    } else if (source instanceof ValueLabel) {
      this.index = -1;
      this.sourceType = VALUE_LABEL;
    } else if (source instanceof StarRating) {
      this.starRating = (StarRating) source;
      this.index = -1;
      this.sourceType = STARRATING;

    } else {
      throw new IllegalArgumentException("Wrong source component, must be a "
          + "Star, ValueLabel, RemoveButton or StarRating");
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    enabledStatus = starRating.isRatingEnabled();
    if (starRating.isEnabled() && starRating.isEditing) {
      if (starRating.getParent() instanceof JTable) {
        isTableEditor = true;
      }
      starRating.setOpaque(true);
      if (!isTableEditor) {
        this.starRating.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
      } else {
        this.starRating.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      }
      if (sourceType == REMOVE_BUTTON) {
        RemoveButton removeButton = (RemoveButton) e.getSource();
        removeButton.setIcon(new ImageIcon(getClass().getResource(RemoveButton.REMOVE_IMAGE)));
        starRating.previewRate((double) (index + 1) / 2);
      } else if (sourceType == STAR) {
        starRating.previewRate((double) (index + 1) / 2);
      }
      super.mouseEntered(e);
    }
  }

  @Override
  public void mouseExited(MouseEvent e) {
    if (mouseLeftStarRating(e)) {
      starRating.setRatingEnabled(enabledStatus);
      starRating.isEditing = true;
    }
    if (starRating.isEnabled() && starRating.isEditing) {
      starRating.setOpaque(false);
      if (!isTableEditor) {
        this.starRating.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      } else {
        this.starRating.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      }

      if (sourceType == REMOVE_BUTTON) {
        RemoveButton removeButton = (RemoveButton) e.getSource();
        removeButton.setIcon(removeButton.getDisabledIcon());
      }
      starRating.setRate(starRating.getRate());
      super.mouseExited(e);
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (starRating.isEnabled() && sourceType != VALUE_LABEL && starRating.isEditing) {
      starRating.setRate((double) (index + 1) / 2);
      starRating.previewRate((double) (index + 1) / 2);
      if (!isTableEditor) {
        this.starRating.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      } else {
        this.starRating.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
      }
      this.starRating.setOpaque(false);

      if (isTableEditor) {
        JTable table = (JTable) starRating.getParent();
        table.getCellEditor().stopCellEditing();
      } else {
        starRating.isEditing = false;
      }
      super.mouseClicked(e);
    }
  }

  /**
   * Checks if the mouse has left the {@link StarRating} area.
   * @param e The mouse event
   * @return True is mouse is outside the {@link StarRating} bounds
   */
  private boolean mouseLeftStarRating(MouseEvent e) {
    Point p = e.getLocationOnScreen();
    double mouseX = p.getX();
    double mouseY = p.getY();
    Point srP = starRating.getLocationOnScreen();
    if ((mouseX < starRating.getX())
        || (mouseY > srP.getY() + starRating.getHeight())
        || (mouseX > srP.getX() + starRating.getWidth())
        || (mouseY < srP.getY())) {
      return true;
    }
    return false;
  }
}
