package com.ozstrategy.credagility.core;

import com.cmc.credagility.core.domain.account.Account;

import javax.persistence.Id;
import java.lang.reflect.Field;

/**
 * Created by kangpan on 3/17/16.
 */
public class Test {

  public static String getPkName(Class cls) {
    Field[] fields = cls.getDeclaredFields();
    String pkName = null;
    for (Field field : fields) {
      if (field.isAnnotationPresent(Id.class)) {
        pkName = field.getName();
        break;
      }
    }
    return pkName;
  }

  public static void main(String[] args) {
    System.out.println(getPkName(Account.class));
  }
}
