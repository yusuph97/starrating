/*
 * @(#)DemoApplet.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating.demo;

import javax.swing.JApplet;

/**
 * The demo as an applet
 * @author lordovol
 * @since version 0.9
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
