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

  /** The editors {@link StarRating} object */
  protected StarRating rating;
  /** If the editor has a {@link ValueLabel} */
  private boolean valueLabelVisible;

  public StarTableCellEditor() {
    this(false);
  }

  public StarTableCellEditor(boolean hasValueLabel) {
    super();
    rating = new StarRating();
    setValueLabelShown(hasValueLabel);
    rating.setRemoveButtonVisible(true);
  }

  public double getValue(){
    return rating.getRate();
  }

  public Object getCellEditorValue() {
    return rating.getRate();
  }

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

  public void setValueLabelShown(boolean valueLabelVisible) {
    rating.setValueLabelVisible(valueLabelVisible);
    setValueLabelVisible(valueLabelVisible);
  }

  /**
   * @return the hasValueLabel
   */
  public boolean isValueLabelVisible() {
    return valueLabelVisible;
  }

  /**
   * @param hasValueLabel the hasValueLabel to set
   */
  public void setValueLabelVisible(boolean hasValueLabel) {
    this.valueLabelVisible = hasValueLabel;
  }
 
}
