/*
 * @(#)ValueLabel.java	28/05/2010
 *
 * Copyright 2010 Spyros Soldatos
 */
package com.googlecode.starrating;

/**
 * Star Rating constants
 * @author lordovol
 * @since version 1.0
 */
public interface StarRatingConstants {

  /** The star image **/
  String STAR_IMAGE = "images/star.png";
  /** The smiling face image **/
  String FACE_IMAGE = "images/face.png";
  /** The euro image **/
  String EURO_IMAGE = "images/euro.png";
  /** The note image **/
  String NOTE_IMAGE = "images/note.png";
  /** The white star image **/
  String WHITE_STAR_IMAGE = "images/whiteStar.png";
  /** The property that changes when new rate is set */
  String RATE_CHANGED = "RATE_CHANGED";
  /** The remove button **/
  String REMOVE_BUTTON_IMAGE = "images/remove.png";
  /** The remove button's width **/
  int REMOVE_BUTTON_WIDTH = 20;
  /** The distance between the remove button and the first star **/
  int REMOVE_BUTTON_GAP = 6;
  /** The distance between the value label and the last star **/
  int LABEL_GAP = 10;
  /** The value labels width **/
  int LABEL_WIDTH = 30;
  /** The starrating height **/
  int STAR_RATING_HEIGHT = 20;
  /** The stars image height **/
  int STAR_IMAGE_HEIGHT = 16;
  /** The stars width **/
  int STAR_IMAGE_WIDTH = 8;
  /** The transparency of the disabled image **/
  float TRANSPARENCY = 0.2F;
}
