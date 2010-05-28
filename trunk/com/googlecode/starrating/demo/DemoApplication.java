/*
 * @(#)DemoApplication.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating.demo;

import javax.swing.JFrame;

/**
 * The demo as an application
 * @author ssoldatos
 * @since version 0.9
 */
public class DemoApplication extends javax.swing.JFrame {

  /** Creates new form test */
  public DemoApplication() {
    add(new DemoPanel());
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    setTitle("SStarRating Demo");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new DemoApplication();
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
