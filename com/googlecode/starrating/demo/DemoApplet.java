/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.googlecode.starrating.demo;

import javax.swing.JApplet;

/**
 *
 * @author lordovol
 */
public class DemoApplet extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */
  @Override
    public void init() {
    add(new DemoPanel());
    }

    // TODO overwrite start(), stop() and destroy() methods

}
