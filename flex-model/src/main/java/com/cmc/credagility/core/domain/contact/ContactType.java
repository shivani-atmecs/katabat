package com.cmc.credagility.core.domain.contact;

/**
 * <p>This interface is implemented by PhoneType, EmailType and AddressType. It returns a typeCode String which is used
 * to look up a value in internationalized text resources.</p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  10/14/2014 17:57
 */
public interface ContactType {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * Define contact type internationalization property lookup code. This code is used only for internationalization
   * purpose: to look up an internationalized description name for this particular type. It is computed as
   *
   * <p>getClass().getSimpleName()+type.getTypeId(),</p>
   *
   * <p>where typeId is the primary key.</p>
   *
   * <p>So for HomePhone, typeCode would be "PhoneType1".</p>
   *
   * <p>This means we can support multiple unlimited home phones, etc:</p>
   *
   * <p>PhoneType1=Home Phone 1 PhoneType2=Home Phone 2 PhoneType2=Work Phone ...</p>
   *
   * @return  define contact type internationalization property lookup code.
   */
  String getTypeCode();
}
