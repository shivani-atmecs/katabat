package com.cmc.credagility.core.domain.util;

import com.ozstrategy.credagility.core.domain.PersonaAction;

import java.util.Comparator;

/**
 * Created by Yang Wang on 5/20/16.
 */
public class PersonaActionComparator implements Comparator<PersonaAction> {
  @Override public int compare(PersonaAction o1, PersonaAction o2) {
    if ((o1.getPriority() == null) && (o2.getPriority() == null)) {
      return 0;
    } else if ((o1.getPriority() != null) && (o2.getPriority() != null)) {
      return o2.getPriority().compareTo(o1.getPriority());
    } else if (o1.getPriority() == null) {
      return 1;
    }

    return -1;
  }
}
