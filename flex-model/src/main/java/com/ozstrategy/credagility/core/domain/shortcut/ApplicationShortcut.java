package com.ozstrategy.credagility.core.domain.shortcut;

import javax.persistence.*;
import java.io.Serializable;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:kunzhou.tang@ozstrategy.com">Kunzhou Tang</a>
 * @version  10/16/2014 16:31
 */
@Entity
@Table(name = "ApplicationShortcut")
public class ApplicationShortcut implements Serializable {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = -5586793677391533215L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  @EmbeddedId protected AppShortcutPK appShortcutPK;

  /** TODO: DOCUMENT ME! */
  @Column(
    nullable = false,
    length   = 64
  )
  protected String hotkeys;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for app shortcut PK.
   *
   * @return  AppShortcutPK
   */
  public AppShortcutPK getAppShortcutPK() {
    return appShortcutPK;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for hotkeys.
   *
   * @return  String
   */
  public String getHotkeys() {
    return hotkeys;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for app shortcut PK.
   *
   * @param  appShortcutPK  AppShortcutPK
   */
  public void setAppShortcutPK(AppShortcutPK appShortcutPK) {
    this.appShortcutPK = appShortcutPK;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for hotkeys.
   *
   * @param  hotkeys  String
   */
  public void setHotkeys(String hotkeys) {
    this.hotkeys = hotkeys;
  }

  //~ Inner Classes ----------------------------------------------------------------------------------------------------

  @Embeddable public static class AppShortcutPK implements Serializable {
    //~ Static fields/initializers -------------------------------------------------------------------------------------

    private static final long serialVersionUID = 8995400520761797960L;

    //~ Instance fields ------------------------------------------------------------------------------------------------

    @Column(
      nullable = false,
      length   = 64
    )
    @Enumerated(value = EnumType.STRING)
    protected ShortcutAction action;

    @Column(
      nullable = false,
      length   = 64
    )
    @Enumerated(value = EnumType.STRING)
    protected ShortCutApp application;

    //~ Methods --------------------------------------------------------------------------------------------------------

    @Override public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }

      if (obj == null) {
        return false;
      }

      if (getClass() != obj.getClass()) {
        return false;
      }

      AppShortcutPK other = (AppShortcutPK) obj;

      if (action == null) {
        if (other.action != null) {
          return false;
        }
      } else if (!action.equals(other.action)) {
        return false;
      }

      if (application == null) {
        if (other.application != null) {
          return false;
        }
      } else if (!application.equals(other.application)) {
        return false;
      }

      return true;
    } // end method equals

    //~ ----------------------------------------------------------------------------------------------------------------

    public ShortcutAction getAction() {
      return action;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    public ShortCutApp getApplication() {
      return application;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    @Override public int hashCode() {
      final int prime  = 31;
      int       result = 1;
      result = (prime * result) + ((application == null) ? 0 : application.hashCode());
      result = (prime * result) + ((action == null) ? 0 : action.hashCode());

      return result;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    public void setAction(ShortcutAction action) {
      this.action = action;
    }

    //~ ----------------------------------------------------------------------------------------------------------------

    public void setApplication(ShortCutApp application) {
      this.application = application;
    }
  } // end class AppShortcutPK
} // end class ApplicationShortcut
