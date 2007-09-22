/*
    ***
    30/06/98 rel. _.___- Swing, JBuilder2 e VSS.
 */
 
 
package net.infordata.em.tn5250;


import java.awt.*;
import java.util.*;
import java.awt.event.*;


/**
 * XI5250Emulator notification event.
 *
 * @version
 * @author   Valentino Proietti - Infordata S.p.A.
 */
public class XI5250EmulatorEvent extends EventObject {

  /**
   * Fired just berore trying to connect.
   */
  public static final int CONNECTING         = 0;
  /**
   * Connection established.
   */
  public static final int CONNECTED          = 1;
  /**
   * Connection closed.
   */
  public static final int DISCONNECTED       = 2;
  /**
   * Internal state is changed.
   */
  public static final int STATE_CHANGED      = 3;
  /**
   * A new 5250 panel has been received and it is ready for the user.
   */
  public static final int NEW_PANEL_RECEIVED = 4;
  /**
   * Fields removed.
   */
  public static final int FIELDS_REMOVED     = 5;
  /**
   * Data have been sended (ie. an aid-code was pressed)
   */
  public static final int DATA_SENDED        = 6;

  protected static final String[] cvIdDescr = {"CONNECTING",
                                               "CONNECTED",
                                               "DISCONNECTED",
                                               "STATE_CHANGED",
                                               "NEW_PANEL_RECEIVED",
                                               "FIELDS_REMOVED",
                                               "DATA_SENDED"};

  protected int         ivId;
  protected byte        ivAidCode;


  /**
   */
  public XI5250EmulatorEvent(int aId, XI5250Emulator aEm) {
    super(aEm);
    ivId = aId;
  }


  /**
   */
  public XI5250EmulatorEvent(int aId, XI5250Emulator aEm, byte anAidCode) {
    this(aId, aEm);
    ivAidCode = anAidCode;
  }


  /**
   */
  public int getID() {
    return ivId;
  }


  /**
   */
  public XI5250Emulator get5250Emulator() {
    return (XI5250Emulator)getSource();
  }


  /**
   * The aid code (DATA_SENDED event)
   */
  public byte getAidCode() {
    return ivAidCode;
  }


  /**
   */
  public String toString() {
    return super.toString() + "[" + cvIdDescr[ivId] + "]";
  }
}