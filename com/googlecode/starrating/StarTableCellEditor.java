/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author ssoldatos
 */
public class StarTableCellEditor extends AbstractCellEditor implements TableCellEditor {

  private static final long serialVersionUID = 124253466L;
  private StarRating rating;
  private int w;
  private boolean hasValueLabel;

  public StarTableCellEditor() {
    this(false);
  }

  public StarTableCellEditor(boolean hasValueLabel) {
    super();
    rating = new StarRating();
    w = rating.getWidth();
    setValueLabelShown(hasValueLabel);
    rating.setRemoveButtonShown(true);

  }

  public double getValue(){
    return rating.getRate();
  }

  public Object getCellEditorValue() {
    return getRating().getRate();
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    getRating().setRate(Double.parseDouble(String.valueOf(value)));
    return getRating();
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
    getRating().setValueLabelShown(b);
    hasValueLabel = b;
  }

  /**
   * @return the rating
   */
  public StarRating getRating() {
    return rating;
  }
}
