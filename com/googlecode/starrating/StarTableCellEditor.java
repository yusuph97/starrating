/*
 * @(#)StarTableCellEditor.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 * A {@link StarRating} table cell editor
 * @author ssoldatos
 * @since version 0.9
 */
public class StarTableCellEditor extends AbstractCellEditor implements TableCellEditor {

  private static final long serialVersionUID = 564563245634L;
  /** The editors {@link StarRating} object */
  protected StarRating rating;
  /** If the editor has a {@link ValueLabel} */
  private boolean valueLabelVisible;

  /**
   * Creates a default {@link StarRating} editor
   */
  public StarTableCellEditor() {
    this(false);
  }

  /**
   * Creates a default {@link StarRating} editor and sets if {@link ValueLabel}
   * will be visible.
   * @param hasValueLabel If valueLabel is visible
   */
  public StarTableCellEditor(boolean hasValueLabel) {
    super();
    rating = new StarRating();
    setValueLabelShown(hasValueLabel);
    rating.setRemoveButtonVisible(true);
  }

  @Override
  public Object getCellEditorValue() {
    return rating.getRate();
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    rating.setRate(Double.parseDouble(String.valueOf(value)));
    return rating;
  }

  @Override
  public boolean isCellEditable(EventObject e) {
    MouseEvent event = (MouseEvent) e;
    if (event.getClickCount() == 2) {
      return true;
    }
    return false;
  }

  /**
   * Set if the {@link ValueLabel} should be shown
   * @param valueLabelVisible If the value label is shown
   */
  public void setValueLabelShown(boolean valueLabelVisible) {
    rating.setValueLabelVisible(valueLabelVisible);
    setValueLabelVisible(valueLabelVisible);
  }

  /**
   * @return If value label is shown
   */
  public boolean isValueLabelVisible() {
    return valueLabelVisible;
  }

  /**
   * @param Sets the value label to visible
   */
  private void setValueLabelVisible(boolean hasValueLabel) {
    this.valueLabelVisible = hasValueLabel;
  }
}
