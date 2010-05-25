/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ssoldatos
 */
public class TableCellStarEditor extends AbstractCellEditor implements TableCellEditor {

  private static final long serialVersionUID = 124253466L;
  private StarRating rating;
  private int w;

  public TableCellStarEditor() {
    rating = new StarRating();
    w = rating.getWidth();
  }

  public Object getCellEditorValue() {
    return rating.getRate();
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    rating.setRate(Integer.parseInt(String.valueOf(value)));
    return rating;
  }

  @Override
  public boolean isCellEditable(EventObject e) {
    MouseEvent event = (MouseEvent) e;
    JTable table = (JTable) event.getSource();
    TableColumnModel colModel = table.getColumnModel();
    final int index = colModel.getColumnIndexAtX(event.getX());
    int colPosition = getColumnPosition(table, index);
    int colWidth = table.getColumnModel().getColumn(index).getWidth();
    if (event.getX() - colPosition - colWidth > -14) {
      return true;
    } else {
      return false;
    }
  }

  private int getColumnPosition(JTable table, int index) {
    int position = 0;
    int tablePositionX = table.getX() + table.getInsets().left;
    position = tablePositionX;
    for (int i = 0; i < index; i++) {
      position += table.getColumnModel().getColumn(i).getWidth();
    }

    return position;
  }
}
