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
 * A {@link StarRating} table cell renderer
 * @author ssoldatos
 * @since version 0.9
 */
public class StarTableCellEditor extends AbstractCellEditor implements TableCellEditor {

  public static final long serialVersionUID = 124253466L;
  protected StarRating rating;
  protected boolean hasValueLabel;

  public StarTableCellEditor() {
    this(false);
  }

  public StarTableCellEditor(boolean hasValueLabel) {
    super();
    rating = new StarRating();
    setValueLabelShown(hasValueLabel);
    rating.setRemoveButtonShown(true);
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

  public void setValueLabelShown(boolean b) {
    rating.setValueLabelShown(b);
    hasValueLabel = b;
  }
 
}
