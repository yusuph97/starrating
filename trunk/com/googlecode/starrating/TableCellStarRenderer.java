/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.starrating;

import java.awt.Component;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ssoldatos
 */
class TableCellStarRenderer  extends DefaultTableCellRenderer {
  private StarRating rating = new StarRating();

  @Override
  public Component getTableCellRendererComponent(JTable table,
      Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    if(isSelected){
      rating.setBackground(table.getSelectionBackground());
    } else {
      rating.setBackground(table.getBackground());
    }
    if (value instanceof Integer) {
      rating.setRate(Integer.parseInt(value.toString()));
    }
    return rating;
  }
}
