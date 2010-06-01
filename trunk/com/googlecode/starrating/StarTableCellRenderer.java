/*
 * @(#)StarTableCellRenderer.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * A {@link StarRating} cell renderer
 * @author ssoldatos
 * @since version 0.9
 */
public class StarTableCellRenderer extends DefaultTableCellRenderer {

  private static final long serialVersionUID = 23525346L;
  /** The {@link StarRating} object */
  private StarRating rating = new StarRating();

  /**
   * Creates a default cell renderer with no {@link ValueLabel} and
   * no {@link RemoveButton}.
   */
  StarTableCellRenderer() {
    this(false, false);
  }

  /**
   * Creates a default renderer and sets if {@link ValueLabel} and
   * {@link RemoveButton} are shown.
   * @param isValueLabelShown If {@link ValueLabel} should be shown
   * @param isRemoveButtonShown If {@link RemoveButton} should be shown.
   */
  public StarTableCellRenderer(boolean isValueLabelShown, boolean isRemoveButtonShown) {
    setValueLabelShown(isValueLabelShown);
    rating.setRemoveButtonVisible(isRemoveButtonShown);
    rating.setBackground(Color.WHITE);
    rating.setOpaque(true);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table,
      Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    if (isSelected) {
      rating.setBackground(table.getSelectionBackground());
    } else {
      rating.setBackground(table.getBackground());
    }
    if (value instanceof Double) {
      rating.setRate(Double.parseDouble(value.toString()));
    }
    return rating;
  }

  /**
   * Sets if the {@link ValueLabel} is shown.
   * @param isValueLabelShown
   */
  public void setValueLabelShown(boolean isValueLabelShown) {
    rating.setValueLabelVisible(isValueLabelShown);
  }
}
