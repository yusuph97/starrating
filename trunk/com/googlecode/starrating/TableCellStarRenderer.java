/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ssoldatos
 */
class TableCellStarRenderer extends DefaultTableCellRenderer {

  private StarRating rating = new StarRating();
  boolean hasValueLabel;

  public TableCellStarRenderer(boolean label) {
    super();
    setValueLabelShown(label);
  }

  TableCellStarRenderer() {
    this(false);
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
    if (value instanceof Integer) {
      rating.setRate(Integer.parseInt(value.toString()));
    }
    return rating;
  }

  public void setValueLabelShown(boolean b) {
    rating.setValueLabelShown(b);
    hasValueLabel = b;
  }
}
