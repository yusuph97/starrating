/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * test.java
 *
 * Created on 25 Μαϊ 2010, 10:08:46 πμ
 */
package com.googlecode.starrating.demo;

import javax.swing.JFrame;

/**
 *
 * @author ssoldatos
 */
public class test extends javax.swing.JFrame {

  /** Creates new form test */
  public test() {
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
        new test();
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
