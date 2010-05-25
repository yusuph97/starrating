/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sstarrating;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ssoldatos
 */
public class Star extends JLabel {

  private final int index;
  private boolean isLeft;
  public static String LEFT_ENABLED = "images/ls.png";
  public static String LEFT_DISABLED = "images/ls_d.png";
  public static String RIGHT_ENABLED = "images/rs.png";
  public static String RIGHT_DISABLED = "images/rs_d.png";

  Star(String im, final int index) {
    this.index = index;
    if (index % 2 == 1){
      isLeft = true;
    }
    setIcon(new ImageIcon(getClass().getResource(im)));
    addMouseListener(new MouseAdapter() {

      @Override
      public void mouseEntered(MouseEvent e) {
        StarRating sr = (StarRating) getParent().getParent();
        sr.previewRate(index);
        super.mouseEntered(e);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        StarRating sr = (StarRating) getParent().getParent();
        sr.setRate(sr.getRate());
        super.mouseExited(e);
      }

      @Override
      public void mouseClicked(MouseEvent e) {
        StarRating sr = (StarRating) getParent().getParent();
        sr.setRate(index);
        sr.previewRate(index);
        super.mouseClicked(e);
      }


    });

  }

  public ImageIcon getLeftEnabled() {
    return new ImageIcon(getClass().getResource(LEFT_ENABLED));
  }

  public ImageIcon getLeftDisabled() {
    return new ImageIcon(getClass().getResource(LEFT_DISABLED));
  }

  public ImageIcon getRightEnabled() {
    return new ImageIcon(getClass().getResource(RIGHT_ENABLED));
  }

  public ImageIcon getRightDisabled() {
    return new ImageIcon(getClass().getResource(RIGHT_DISABLED));
  }

  void clearRate() {
    if(isLeft){
      setIcon(getLeftDisabled());
    } else {
      setIcon(getRightDisabled());
    }
  }

  void setRate() {
     if(isLeft){
      setIcon(getLeftEnabled());
    } else {
      setIcon(getRightEnabled());
    }
  }
}
