/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.starrating;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author ssoldatos
 */
 class StarMouseAdapter extends MouseAdapter {
  private StarRating sr;
  private final int index;
  private Star star;
  private RemoveButton removeButton;

  /**
   * 
   * @param sr
   * @param index
   */
  public StarMouseAdapter(int index) {
    this.index = index;
  }



  @Override
  public void mouseEntered(MouseEvent e) {
    processEvent(e);
    if (sr.isEnabled()) {
      sr.previewRate((double) index / 2);
      super.mouseEntered(e);
    }
  }

  @Override
  public void mouseExited(MouseEvent e) {
     processEvent(e);
    if (sr.isEnabled()) {
      sr.setRate(sr.getRate());
      super.mouseExited(e);
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
     processEvent(e);
    if (sr.isEnabled()) {
      sr.setRate((double) index / 2);
      sr.previewRate((double) index / 2);
      super.mouseClicked(e);
    }
  }

  private void processEvent(MouseEvent e) {
    Object source = e.getSource();
    if(source instanceof Star){
      star = (Star) source;
      sr = (StarRating) star.getParent();
    } else if (source instanceof RemoveButton){
      removeButton = (RemoveButton) source;
      sr = (StarRating) removeButton.getParent();
    }
  }
  
}
