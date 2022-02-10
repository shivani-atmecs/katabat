package com.cmc.credagility.core.domain.payment;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import org.springframework.util.StringUtils;

import com.cmc.credagility.core.domain.address.Address;
import com.cmc.credagility.core.domain.type.BankAccountType;
import com.cmc.credagility.core.domain.type.CardType;
import com.cmc.credagility.core.domain.type.FundingAccountType;


/**
 * <p>Simple util class to paser and build payment xml</p>
 *
 * <p><a href="PaymentPaserUtil.java.html"><i>View Source</i></a></p>
 *
 * @author   <a href="mailto:rojer@ozstrategy.com">Rojer Luo Jun</a>
 * @version  $Revision$, $Date$
 */
public class PaymentXMLUtil {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public static String STATUS_CODE = "statusCode";

  /** TODO: DOCUMENT ME! */
  public static String STATUS_TEXT = "statusText";

  /** TODO: DOCUMENT ME! */
  public static String TRANSACTION_ID = "transactionId";

  /** TODO: DOCUMENT ME! */
  public static String USER_FEE = "userFee";

  /** TODO: DOCUMENT ME! */
  public static String BILLER_FEE = "billerFee";

  /** DOCUMENT ME! */
  public static String SINGLE_USE = "Multi-Use";

  private static final String BANK = "BANK";

  private static final String CHECKING = "PERSONAL CHECKING";

  private static final String SAVING = "PERSONAL SAVINGS";

  private static final Log log = LogFactory.getLog(PaymentXMLUtil.class);

  //~ Enums ------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @author   $author$
   * @version  $Revision$, $Date$
   */
  public static enum ITSPaymentType {
    //~ Enum constants -------------------------------------------------------------------------------------------------

    Visa, MasterCard, AmEx, Discover, Check
  }

  /**
   * DOCUMENT ME!
   *
   * @author   $author$
   * @version  $Revision$, $Date$
   */
  public static enum oldITSPaymentType {
    //~ Enum constants -------------------------------------------------------------------------------------------------

    C, S, CC, DC
  }

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   xml  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getAciDeleteFundingAccRequestXml(PaymentXMLRequest xml) {
    Document document = DocumentHelper.createDocument();
    Element  root     = document.addElement("delete-funding-request",
        "http://www.princetonecom.com/fundingPortal/deletefundingrequest");
    root.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
    root.addAttribute("xsi:schemaLocation",
      "http://www.princetonecom.com/fundingPortal/deletefundingrequest delete_funding_request.xsd");
    root.addNamespace("", "http://www.princetonecom.com/fundingPortal/deletefundingrequest");

    Element identity = root.addElement("identity");
    addAciIdentityElement(identity, xml);

    root.addElement("billing-account-number").addText(xml.getAccountNumber());
    root.addElement("token-id").addText(xml.getToken());

    document.setRootElement(root);

    return "xml=" + document.asXML();
  } // end method getAciDeleteFundingAccRequestXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   xml  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getAciFundingAccountsRequestXml(PaymentXMLRequest xml) {
    Document document = DocumentHelper.createDocument();
    Element  root     = document.addElement("search-funding-token-request",
        "http://www.princetonecom.com/fundingPortal/searchfundingtokenrequest4");


    root.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
    root.addAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");

    Element identity = root.addElement("identity");

    addAciIdentityElement(identity, xml);

    if (xml.getAccountNumber() != null) {
      root.addElement("billing-account-number").addText(xml.getAccountNumber());
    }

    document.setRootElement(root);

    return "xml=" + document.asXML();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   xml  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getAciFundingAccTokenRequestXml(PaymentXMLRequest xml) {
    Document document = DocumentHelper.createDocument();
    Element  root     = document.addElement("generate-funding-token-request",
        "http://www.princetonecom.com/fundingPortal/generatefundingtokenrequest");
    root.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
    root.addAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");
    root.addNamespace("", "http://www.princetonecom.com/fundingPortal/generatefundingtokenrequest");

    Element identity = root.addElement("identity");
    addAciIdentityElement(identity, xml);
    addAciBasicElements(root, xml);
    root.addElement("funding-account-type").addText(xml.getTransactionType());

    if ("BANK".equalsIgnoreCase(xml.getTransactionType())) {
      Element bankAccount = root.addElement("bank-account");
      addAciBankAccountElement(bankAccount, xml);
    } else {
      Element cardAccount = root.addElement("card-account");
      addAciCardAccountElement(cardAccount, xml);
    }

    addAciFundingDetailsElements(root, xml);

    document.setRootElement(root);

    return "xml=" + document.asXML();
  } // end method getAciFundingAccTokenRequestXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   xml  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getAciMakePaymentRequestXml(PaymentXMLRequest xml) {
    Document document = DocumentHelper.createDocument();
    Element  root     = document.addElement("make-payment-request",
        "http://www.princetonecom.com/fundingPortal/makepaymentrequest");


    root.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
    root.addAttribute("xmlns:xsd", "http://www.w3.org/2001/XMLSchema");

    Element identity = root.addElement("identity");

    addAciIdentityElement(identity, xml);

    if (xml.getToken() != null) {
      root.addElement("funding-token-id").addText(xml.getToken());
    }

    if (xml.getEcommIndicator() != null) {
      root.addElement("ecommerce-indicator").addText(xml.getEcommIndicator());
    }

    if (xml.getEntryClass() != null) {
      root.addElement("nacha-standard-entry-class").addText(xml.getEntryClass());
    }

    if (xml.getTransactionType() != null) {
      root.addElement("credit-debit-indicator").addText(xml.getTransactionType());
    }


    if (xml.getPaymentDate() != null) {
      root.addElement("requested-payment-date").addText(xml.getPaymentDate());
    }

    Element remittance = root.addElement("remittance");

    addAciRemittanceElement(remittance, xml);

    if (xml.getProductCode() != null) {
      root.addElement("product").addText(xml.getProductCode());
    }

    if (xml.getMerchantTxnId() != null) {
      root.addElement("transaction-code").addText(xml.getMerchantTxnId());
    }

    if (xml.getEmailAddress() != null) {
      root.addElement("email-address").addText(xml.getEmailAddress());
    }

    document.setRootElement(root);

    return "xml=" + document.asXML();
  } // end method getAciMakePaymentRequestXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   payment  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getConvergeACHTransactionXml(PaymentXMLRequest payment) {
    DocumentFactory factory   = DocumentFactory.getInstance();
    QName           rootQName = factory.createQName("txn");

    Element  root     = factory.createElement(rootQName);

    addConvergeMerchantID(root, payment);


    root.addElement("ssl_aba_number").addText(payment.getAbaNumber());
    root.addElement("ssl_bank_account_number").addText(payment.getBankAccountNumber());
    root.addElement("ssl_amount").addText(payment.getAmount());
    root.addElement("ssl_bank_account_type").addText(payment.getBankAccountType());
    root.addElement("ssl_agree").addText(payment.getAgree());
    root.addElement("ssl_ecs_product_code").addText(payment.getProductCode());
    root.addElement("ssl_first_name").addText(payment.getFirstName());
    root.addElement("ssl_last_name").addText(payment.getLastName());
    root.addElement("ssl_merchant_txn_id").addText(payment.getMerchantTxnId());


    Document document = factory.createDocument();
    document.setRootElement(root);

    return document.asXML();
  } // end method getConvergeACHTransactionXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   xml  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getConvergeBinLookupXml(PaymentXMLRequest xml) {
    DocumentFactory factory   = DocumentFactory.getInstance();
    QName           rootQName = factory.createQName("txn");
    Element         root      = factory.createElement(rootQName);

    Document document = factory.createDocument();
    document.setRootElement(root);

    addConvergeMerchantID(root, xml);

    root.addElement("ssl_card_number").addText(xml.getCardNumber());

    return document.asXML();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   payment  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getConvergeCardTokenXml(PaymentXMLRequest payment) {
    DocumentFactory factory   = DocumentFactory.getInstance();
    QName           rootQName = factory.createQName("txn");
    Element         root      = factory.createElement(rootQName);

    addConvergeMerchantID(root, payment);


    root.addElement("ssl_card_number").addText(payment.getCardNumber());
    root.addElement("ssl_exp_date").addText(payment.getExpDate());
    root.addElement("ssl_cvv2cvc2_indicator").addText(payment.getCvvIndicator());
    if (payment.getCvv() != null){
      root.addElement("ssl_cvv2cvc2").addText(payment.getCvv());
    }
    root.addElement("ssl_first_name").addText(payment.getFirstName());
    root.addElement("ssl_last_name").addText(payment.getLastName());
    root.addElement("ssl_avs_address").addText(payment.getAddress());
    root.addElement("ssl_state").addText(payment.getState());
    root.addElement("ssl_avs_zip").addText(payment.getZip());
    root.addElement("ssl_add_token").addText(payment.getAddToken());


    Document document = factory.createDocument();
    document.setRootElement(root);

    return document.asXML();
  } // end method getConvergeCardTokenXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   payment  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getConvergeCardTransactionXml(PaymentXMLRequest payment) {
    DocumentFactory factory   = DocumentFactory.getInstance();
    QName           rootQName = factory.createQName("txn");
    Element         root      = factory.createElement(rootQName);

    addConvergeMerchantID(root, payment);


    root.addElement("ssl_token").addText(payment.getToken());
    root.addElement("ssl_merchant_initiated_unscheduled").addText(payment.getMerchantInitiated());
    root.addElement("ssl_amount").addText(payment.getAmount());
    root.addElement("ssl_merchant_txn_id").addText(payment.getMerchantTxnId());


    Document document = factory.createDocument();
    document.setRootElement(root);

    return document.asXML();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   payment  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getITSAccountValidationXml(Payment payment) {
    DocumentFactory factory   = DocumentFactory.getInstance();
    QName           rootQName = factory.createQName("transaction");
    Element         root      = factory.createElement(rootQName);

    addITSUserIdAndPwd(root, payment);

    Document document = factory.createDocument();
    document.setRootElement(root);

    return document.asXML();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   payment  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getITSEnumPaymentMethodsXml(Payment payment) {
    DocumentFactory factory   = DocumentFactory.getInstance();
    QName           rootQName = factory.createQName("transaction");
    Element         root      = factory.createElement(rootQName);

    addITSUserIdAndPwd(root, payment);
    addITStotalAmount(root, payment);

    Document document = factory.createDocument();
    document.setRootElement(root);

    return document.asXML();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   payment  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getITSFeeCalculaulationXml(Payment payment) {
    DocumentFactory factory   = DocumentFactory.getInstance();
    QName           rootQName = factory.createQName("transaction");
    Element         root      = factory.createElement(rootQName);

    addITSUserIdAndPwd(root, payment);
    addITStotalAmount(root, payment);
    addITSPaymentType(root, payment);

    Document document = factory.createDocument();
    document.setRootElement(root);

    return document.asXML();
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   payment  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getITSPaymentType(Payment payment) {
    if (payment.isUsingBankAccount()) {
      return ITSPaymentType.Check.name();
    } else if (payment.isUsingAmex()) {
      return ITSPaymentType.AmEx.name();
    } else if (payment.isUsingVisa()) {
      return ITSPaymentType.Visa.name();
    } else if (payment.isUsingMasterCard()) {
      return ITSPaymentType.MasterCard.name();
    } else if (payment.isUsingDiscover()) {
      return ITSPaymentType.Discover.name();
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   payment  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getITSSubmitTransactionXml(Payment payment) {
    DocumentFactory factory   = DocumentFactory.getInstance();
    QName           rootQName = factory.createQName("transaction");
    Element         root      = factory.createElement(rootQName);

    addITSUserIdAndPwd(root, payment);
    addITStotalAmount(root, payment);

    String text = payment.getFundingInformation().getHolderFullName();

    if (!StringUtils.hasText(text)) {
      text = payment.getResponsible().getFullName();
    }

    if (text != null) {
      root.addElement("customername").addText(text);
    }

    addITSPaymentType(root, payment);

    if (!payment.isUsingCard()) {
      // Using bank account
      text = payment.getFundingInformation().getRoutingNumber();
      root.addElement("aba_routing_number").addText(text);
      text = payment.getFundingInformation().getFundingAccountNum();
      root.addElement("check_account").addText(text);
      root.addElement("check_number").addText("99999");
    } else {
      // Using card
      text = payment.getFundingInformation().getFundingAccountNum();
      root.addElement("cc_number").addText(text);

      if (StringUtils.hasText(payment.getFundingInformation().getCvv())) {
        root.addElement("cc_cvv").addText(
          payment.getFundingInformation().getCvv());
      } else {
        root.addElement("cc_cvv").addText("");
      }

      text = payment.getCardExpirationDate4();

      if (text == null) {
        text = "";
      }

      root.addElement("cc_exp_date").addText(text);

    } // end if-else

    text = payment.getFundingInformation().getAddress().getPostalCode();

    if (text == null) {
      text = "";
    }

    root.addElement("zipcode").addText(text);

    Document document = factory.createDocument();
    document.setRootElement(root);

    return document.asXML();
  } // end method getITSSubmitTransactionXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   itsType  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getSystemCardTypeFromITSPaymentType(String itsType) {
    if (ITSPaymentType.AmEx.name().equalsIgnoreCase(itsType)) {
      return CardType.AMERICANEEXPRESS.toString();
    }

    if (ITSPaymentType.Visa.name().equalsIgnoreCase(itsType)) {
      return CardType.VISA.toString();
    }

    if (ITSPaymentType.Discover.name().equalsIgnoreCase(itsType)) {
      return CardType.DISCOVER.toString();
    }

    if (ITSPaymentType.MasterCard.name().equalsIgnoreCase(itsType)) {
      return CardType.MASTERCARD.toString();
    }

    return itsType;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Generate the request xml.
   *
   * @param   request  DOCUMENT ME!
   *
   * @return  generate the request xml.
   */
  public static String getXml(PaymentRequest request) {
    // build xml from request
    // create document from jobs
    DocumentFactory factory   = DocumentFactory.getInstance();
    QName           rootQName = factory.createQName("transaction");
    Element         root      = factory.createElement(rootQName);

    String text = null;

    text = request.getUserId();

    if (text != null) {
      root.addElement("userid").addText(text);
    }

    text = request.getPassword();

    if (text != null) {
      root.addElement("password").addText(text);
    }

    text = request.getVendorId();

    if (text != null) {
      root.addElement("vendor_id").addText(text);
    }

    text = request.getInformational();

    if (text != null) {
      root.addElement("informational").addText(text);
    }

    text = request.getScheduleDate();

    if (text != null) {
      root.addElement("schedule_date").addText(text);
    }

    text = request.getFudingAccountType();

    if (text != null) {
      root.addElement("funding_account_type").addText(text);
    }

    text = request.getCardType();

    if (text != null) {
      root.addElement("card_type").addText(text);
    }

    text = request.getAccountNum();

    if (text != null) {
      root.addElement("account_num").addText(text);
    }

    text = request.getCustomerName();

    if (text != null) {
      root.addElement("customername").addText(text);
    }

    text = request.getAmount();

    if (text != null) {
      root.addElement("amount").addText(text);
    }

    text = request.getCardNumber();

    if (text != null) {
      root.addElement("card_number").addText(text);
    }

    text = request.getCardExpDate();

    if (text != null) {
      root.addElement("card_exp_date").addText(text);
    }

    text = request.getZipCode();

    if (text != null) {
      root.addElement("zipcode").addText(text);
    }

    text = request.getCvv();

    if (text != null) {
      root.addElement("cvv").addText(text);
    }

    text = request.getAbaRoutingNumber();

    if (text != null) {
      root.addElement("aba_routing_number").addText(text);
    }

    text = request.getBankAccount();

    if (text != null) {
      root.addElement("bank_account").addText(text);
    }

    text = request.getCheckNumber();

    if (text != null) {
      root.addElement("check_number").addText(text);
    }

    Document document = factory.createDocument();
    document.setRootElement(root);
    // the DOM is finished!

    return document.asXML();
  } // end method getXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   result  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static String getXmlPaymentResponse(PaymentResultWrapper result) {
    DocumentFactory factory   = DocumentFactory.getInstance();
    QName           rootQName = factory.createQName("transaction_result");
    Element         root      = factory.createElement(rootQName);

    String        text;
    DecimalFormat df = new DecimalFormat("#######0.00");

    text = result.getVersion();

    if (text == null) {
      text = "";
    }

    root.addElement("version").addText(text);

    if (result.getPayment() != null) {
      text = result.getPayment().getAuthCode();

      if (text == null) {
        text = "";
      }

      root.addElement("auth_code").addText(text);

      // Added for Prarie
      root.addElement("transaction_id").addText(text);

      text = result.getPayment().getResponsible().getUserLogon();

      if (text == null) {
        text = "";
      }

      root.addElement("account_num").addText(text);

      text = df.format(result.getPayment().getAmount());

      if (text == null) {
        text = "";
      }

      root.addElement("amount").addText(text);

      BigDecimal fee = result.getPayment().getFee();

      if (fee == null) {
        fee = new BigDecimal("0.0");
      }

      text = df.format(fee);

      if (text == null) {
        text = "";
      }

      root.addElement("fee").addText(text);

      addFundingElements(result, root, result.getPayment().getFundingInformation());

    } // end if

    PaymentProgram program = result.getPaymentProgram();

    if (program != null) {
      text = program.getProgramId().toString();

      if (text == null) {
        text = "";
      }

      root.addElement("program_id").addText(text);

      text = df.format(program.getTotalAmount());

      if (text == null) {
        text = "";
      }

      root.addElement("amount").addText(text);

      text = program.getDuration().toString();

      if (text == null) {
        text = "";
      }

      root.addElement("duration").addText(text);

      Set<PaymentProgramInstallment>      installments = program.getInstallments();
      Iterator<PaymentProgramInstallment> it           = installments.iterator();
      PaymentProgramInstallment           installment  = it.next();

      text = installment.getPayment().getAuthCode();

      if (text == null) {
        text = "";
      }

      root.addElement("auth_code").addText(text);

      addFundingElements(result, root, installment.getPayment().getFundingInformation());

    } // end if

    text = result.getStatusCode();

    if (text == null) {
      text = "";
    }

    root.addElement("status_code").addText(text);

    text = result.getStatusText();

    if (text == null) {
      text = "";
    }

    root.addElement("status_text").addText(text);

    Document document = factory.createDocument();
    document.setRootElement(root);

    return document.asXML();
  } // end method getXmlPaymentResponse

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   type     DOCUMENT ME!
   * @param   version  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   */
  public static boolean isITSCard(String type, String version) {
    if (!StringUtils.hasText(version)) {
      return isOldITSCard(type);
    }

    return isITSCard(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   xmlString  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  public static PaymentXMLResponse parseACISearchFundingXml(String xmlString) throws Exception {
    PaymentXMLResponse   response     = new PaymentXMLResponse();
    List<FundingAccount> fundingAccts = new ArrayList<FundingAccount>();
    Document             document     = DocumentHelper.parseText(xmlString);

    Element root = document.getRootElement();


    for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
      Element j = (Element) i.next();
      log.info("Name:" + j.getName());

      if (log.isDebugEnabled()) {
        log.debug("Value:" + j.getData());
      }

      if ("status".equalsIgnoreCase(j.getName())) {
        response.setResultMessage((String) j.getData());
      } else if ("message".equalsIgnoreCase(j.getName())) {
        for (Iterator<?> m = j.elementIterator(); m.hasNext();) {
          Element message = (Element) m.next();
          log.info("Name:" + message.getName());

          if (log.isDebugEnabled()) {
            log.debug("Value:" + message.getData());
          }

          if ("message-code".equalsIgnoreCase(message.getName())) {
            response.setResult((String) message.getData());
          } else if ("message-text".equalsIgnoreCase(message.getName())) {
            response.setDescription((String) message.getData());
          }

          m.remove();
        }
      }

      if ("token-list".equalsIgnoreCase(j.getName())) {
        Element       tokenList = root.element("token-list");
        List<Element> token     = tokenList.elements("token");

        System.out.println("List length : " + token.size());

        for (Element element : token) {
          FundingAccount facct = new FundingAccount();
          facct.setCreateDate(new Date());
          facct.setLastUpdateDate(new Date());

          Address            address = new Address();
          FundingInformation finfo   = new FundingInformation();

          if (element.elementTextTrim("token-id") != null) {
            facct.setExternalReferenceNumber(element.elementTextTrim("token-id"));
          }

          if (element.elementTextTrim("funding-account-nickname") != null) {
            finfo.setNickName(element.elementTextTrim("funding-account-nickname"));
          }

          if (element.elementTextTrim("signature-debit") == null) {
            finfo.setType(FundingAccountType.BANKACCOUNT.toString());
          } else {
            if ("True".equalsIgnoreCase(element.elementTextTrim("signature-debit"))) {
              finfo.setType(FundingAccountType.DEBITCARD.toString());
            } else if ("False".equalsIgnoreCase(element.elementTextTrim("signature-debit"))) {
              finfo.setType(FundingAccountType.CREDITCARD.toString());
            }
          }

          if (CHECKING.equalsIgnoreCase(element.elementTextTrim("funding-sub-type"))) {
            finfo.setSubType(BankAccountType.CHECKING.toString());
          } else if (SAVING.equalsIgnoreCase(element.elementTextTrim("funding-sub-type"))) {
            finfo.setSubType(BankAccountType.SAVING.toString());
          } else {
            log.info("Setting subtype from response:" + element.elementTextTrim("funding-sub-type"));
            finfo.setSubType(element.elementTextTrim("funding-sub-type"));
          }

          if (element.elementTextTrim("masked-funding-account") != null) {
            finfo.setFundingAccountNum(element.elementTextTrim("masked-funding-account"));
          }

          if (element.elementTextTrim("expiry-date") != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("MMddyy");
           Date date = formatter.parse(element.elementTextTrim("expiry-date"));
           System.out.println("Date : " +date);
            finfo.setExpirationDate(formatter.parse(element.elementTextTrim("expiry-date")));
          }

          if (element.elementTextTrim("funding-account-holder-name") != null) {
            finfo.setHolderFullName(element.elementTextTrim("funding-account-holder-name"));
          }

          if (element.elementTextTrim("state") != null) {
            address.setProvince(element.elementTextTrim("state"));
          }

          if (element.elementTextTrim("zip-code") != null) {
            address.setPostalCode(element.elementTextTrim("zip-code"));
          }

          if (element.elementTextTrim("country-code") != null) {
            address.setCountry(element.elementTextTrim("country-code"));
          }

          if (address != null) {
            System.out.println("Address is not null ");
            finfo.setAddress(address);
          }

          facct.setFundingInformation(finfo);
          fundingAccts.add(facct);


          System.out.println("External Ref Number : " + facct.getExternalReferenceNumber());
          // System.out.println(element.elementTextTrim("funding-sub-type"));


        } // end for

      } // end if


    } // end for

    response.setFundingAccounts(fundingAccts);

    return response;
  } // end method parseACISearchFundingXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   xmlString  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  public static PaymentXMLResponse parseACIXml(String xmlString) throws Exception {
    PaymentXMLResponse response = new PaymentXMLResponse();

    try {
      Document document = DocumentHelper.parseText(xmlString);
      Element  root     = document.getRootElement();

      for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
        Element j = (Element) i.next();
        log.info("Name:" + j.getName());

        if (log.isDebugEnabled()) {
          log.debug("Value:" + j.getData());
        }

        if ("status".equalsIgnoreCase(j.getName())) {
          response.setResultMessage((String) j.getData());
        } else if ("message".equalsIgnoreCase(j.getName())) {
          for (Iterator<?> m = j.elementIterator(); m.hasNext();) {
            Element message = (Element) m.next();
            log.info("Name:" + message.getName());

            if (log.isDebugEnabled()) {
              log.debug("Value:" + message.getData());
            }

            if ("message-code".equalsIgnoreCase(message.getName())) {
              response.setResult((String) message.getData());
            } else if ("message-text".equalsIgnoreCase(message.getName())) {
              response.setDescription((String) message.getData());
            }

            m.remove();
          }
        } else if ("token-id".equalsIgnoreCase(j.getName())) {
          response.setToken((String) j.getData());
        } else if ("masked-funding-account".equalsIgnoreCase(j.getName())) {
          response.setBankAccountNumber((String) j.getData());
        } else if ("funding-sub-type".equalsIgnoreCase(j.getName())) {
          response.setBankAccountType((String) j.getData());
          response.setCardType((String) j.getData());
        } else if ("funding-account-nickname".equalsIgnoreCase(j.getName())) {
          response.setNickName((String) j.getData());
        } else if ("single-use".equalsIgnoreCase(j.getName())) { }
        else if ("confirmation-number".equalsIgnoreCase(j.getName())) {
          response.setTxnId((String) j.getData());
        } // end if-else

        i.remove();
      } // end for
    } catch (Exception e) {
      log.error(e);
      response.setResult("999999");

      String exception = null;

      if ((e != null) && (e.toString() != null)) {
        exception = e.toString();

        if (e.toString().length() <= 30) {
          exception = e.toString().substring(0, 30);
        }
      }

      response.setDescription("Exception:" + exception);
    } // end try-catch

    return response;
  } // end method parseACIXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * DOCUMENT ME!
   *
   * @param   xmlString  DOCUMENT ME!
   *
   * @return  DOCUMENT ME!
   *
   * @throws  Exception  DOCUMENT ME!
   */
  public static PaymentXMLResponse parseConvergeXml(String xmlString) throws Exception {
    PaymentXMLResponse response = new PaymentXMLResponse();

    Document document = DocumentHelper.parseText(xmlString);

    String xpath = "/txn/ssl_bank_account_type";
    response.setBankAccountType(document.valueOf(xpath));
    xpath = "/txn/ssl_result_message";
    response.setResultMessage(document.valueOf(xpath));
    xpath = "/txn/ssl_txn_id";
    response.setTxnId(document.valueOf(xpath));
    xpath = "/txn/errorCode";
    response.setErrorCode(document.valueOf(xpath));
    xpath = "/txn/errorMessage";
    response.setErrorMessage(document.valueOf(xpath));
    xpath = "/txn/debit";
    response.setDebit(document.valueOf(xpath));
    xpath = "/txn/ssl_result";
    response.setResult(document.valueOf(xpath));
    xpath = "/txn/ssl_token";
    response.setToken(document.valueOf(xpath));


    return response;
  } // end method parseConvergeXml

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * parseITSResponseXml.
   *
   * @param   xmlString  String
   *
   * @return  Map
   *
   * @throws  Exception  exception
   */
  public static Map<String, String> parseITSResponseXml(String xmlString) throws Exception {
    Document            document = DocumentHelper.parseText(xmlString);
    Map<String, String> result   = new HashMap<String, String>();
    String              xpath    = "/transaction_result/status_code";
    result.put(STATUS_CODE, document.valueOf(xpath));
    xpath = "/transaction_result/status_text";
    result.put(STATUS_TEXT, document.valueOf(xpath));
    xpath = "/transaction_result/transaction_id";
    result.put(TRANSACTION_ID, document.valueOf(xpath));
    xpath = "/transaction_result/ufee_paid";
    result.put(USER_FEE, document.valueOf(xpath));
    xpath = "/transaction_result/bfee_paid";
    result.put(BILLER_FEE, document.valueOf(xpath));

    return result;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * parseXml.
   *
   * @param   xmlString  String
   *
   * @return  PaymentResponse
   *
   * @throws  Exception  exception
   */
  public static PaymentResponse parseXml(String xmlString) throws Exception {
    PaymentResponse response = new PaymentResponse();

    Document document = DocumentHelper.parseText(xmlString);

    System.out.println("document : " + document.asXML());

    String xpath = "/transaction_result/userid";
    response.setUserId(document.valueOf(xpath));
    xpath = "/transaction_result/password";
    response.setPassword(document.valueOf(xpath));
    xpath = "/transaction_result/vendor_id";
    response.setVendorId(document.valueOf(xpath));
    xpath = "/transaction_result/informational";
    response.setInformational(document.valueOf(xpath));
    xpath = "/transaction_result/schedule_date";
    response.setScheduleDate(document.valueOf(xpath));
    xpath = "/transaction_result/customername";
    response.setCustomerName(document.valueOf(xpath));
    xpath = "/transaction_result/funding_account_type";
    response.setFudingAccountType(document.valueOf(xpath));
    xpath = "/transaction_result/card_type";
    response.setCardType(document.valueOf(xpath));
    xpath = "/transaction_result/accountNum";
    response.setAccountNum(document.valueOf(xpath));
    xpath = "/transaction_result/amount";
    response.setAmount(document.valueOf(xpath));
    xpath = "/transaction_result/ufee_paid";
    response.setUfeePaid(document.valueOf(xpath));
    xpath = "/transaction_result/bfee_paid";
    response.setBfeePaid(document.valueOf(xpath));
    xpath = "/transaction_result/total_paid";
    response.setTotalPaid(document.valueOf(xpath));
    xpath = "/transaction_result/payment_account";
    response.setPaymentAccount(document.valueOf(xpath));
    xpath = "/transaction_result/card_exp_date";
    response.setCardExpDate(document.valueOf(xpath));
    xpath = "/transaction_result/cvv";
    response.setCvv(document.valueOf(xpath));
    xpath = "/transaction_result/aba_routing_number";
    response.setAbaRoutingNumber(document.valueOf(xpath));
    xpath = "/transaction_result/check_number";
    response.setCheckNumber(document.valueOf(xpath));
    xpath = "/transaction_result/status_code";
    response.setStatusCode(document.valueOf(xpath));
    xpath = "/transaction_result/status_text";
    response.setStatusText(document.valueOf(xpath));
    xpath = "/transaction_result/transaction_id";
    response.setTransactionId(document.valueOf(xpath));
    xpath = "/txn/ssl_txn_id";
    response.setTransactionId(document.valueOf(xpath));

    return response;
  } // end method parseXml

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addAciBankAccountElement(Element root, PaymentXMLRequest request) {
    String text = null;

    text = request.getBankAccountType();

    if (text != null) {
      root.addElement("bank-account-type").addText(text);
    }

    text = request.getAbaNumber();

    if (text != null) {
      root.addElement("routing-number").addText(text);
    }

    text = request.getBankAccountNumber();

    if (text != null) {
      root.addElement("bank-account-number").addText(text);
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addAciBasicElements(Element root, PaymentXMLRequest request) {
    String text = null;

    text = request.getAccountNumber();

    if (text != null) {
      root.addElement("billing-account-number").addText(text);
    }

    text = request.getPartnerId();

    if (text != null) {
      root.addElement("division-id").addText(text);
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addAciCardAccountElement(Element root, PaymentXMLRequest request) {
    String text = null;

    text = request.getCardNumber();

    if (text != null) {
      root.addElement("card-number").addText(text);
    }

    text = request.getExpMonth();

    if (text != null) {
      root.addElement("expiration-month").addText(text);
    }

    text = request.getExpYear();

    if (text != null) {
      root.addElement("expiration-year").addText(text);
    }

    text = request.getCvv();

    if (text != null) {
      root.addElement("security-code").addText(text);
    }

  } // end method addAciCardAccountElement

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addAciFundingDetailsElements(Element root, PaymentXMLRequest request) {
    String text = null;

    text = request.getFirstName() + " " + request.getLastName();

    if (text != null) {
      root.addElement("account-holder-name").addText(text);
    }

    text = request.getState();

    if (text != null) {
      root.addElement("account-state").addText(text);
    }

    text = request.getZip();

    if (text != null) {
      root.addElement("account-postal-code").addText(text);
    }

    text = request.getNickName();

    if (text != null) {
      root.addElement("funding-account-nickname").addText(text);
    }

    text = SINGLE_USE;

    if (text != null) {
      root.addElement("single-use").addText(text);
    }

  } // end method addAciFundingDetailsElements

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addAciIdentityElement(Element root, PaymentXMLRequest payment) {
    String text = null;

    text = payment.getMerchantId();

    if (text != null) {
      root.addElement("business-id").addText(text);
    }

    text = payment.getUserId();

    if (text != null) {
      root.addElement("login").addText(text);
    }

    text = payment.getPin();

    if (text != null) {
      root.addElement("password").addText(text);
    }

  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addAciRemittanceElement(Element root, PaymentXMLRequest payment) {
    Element billing = root.addElement("billing-account");

    String text = null;

    text = payment.getAccountNumber();

    if (text != null) {
      billing.addElement("billing-account-number").addText(text);
    }

    text = payment.getAmount();

    if (text != null) {
      root.addElement("remit-amount").addText(text);
    }

    Element remitField = root.addElement("payment-remit-field");


    if (text != null) {
      remitField.addElement("value").addText(text);
    }

    Element remitField1 = root.addElement("payment-remit-field");

    remitField1.addElement("value").addText("");

    Element remitField2 = root.addElement("payment-remit-field");

    remitField2.addElement("value").addText("");


  } // end method addAciRemittanceElement

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addConvergeMerchantID(Element root, PaymentXMLRequest payment) {
    String text = null;
    text = payment.getMerchantId();

    if (text != null) {
      root.addElement("ssl_merchant_ID").addText(text);
    }

    text = payment.getUserId();

    if (text != null) {
      root.addElement("ssl_user_id").addText(text);
    }

    text = payment.getPin();

    if (text != null) {
      root.addElement("ssl_pin").addText(text);
    }

    text = payment.getVendorId();

    if (text != null) {
      root.addElement("ssl_vendor_id").addText(text);
    }

    text = payment.getPartnerId();

    if (text != null) {
      root.addElement("ssl_partner_app_id").addText(text);
    }

    text = payment.getTransactionType();

    if (text != null) {
      root.addElement("ssl_transaction_type").addText(text);
    }

    text = payment.getTestMode();

    if (text != null) {
      root.addElement("ssl_test_mode").addText(text);
    }
  } // end method addConvergeMerchantID

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addFundingElements(PaymentResultWrapper result,
    Element root, FundingInformation f) {
    String text;
    text = f.getHolderFullName();

    if (text == null) {
      text = "";
    }

    root.addElement("customername").addText(text);

    text = f.getType();

    if (text == null) {
      text = "";
    }

    root.addElement("fund_acct_type").addText(text);

    text = f.getSubType();

    if (text == null) {
      text = "";
    }

    root.addElement("fund_acct_subtype").addText(text);

    text = f.getRoutingNumber();

    if (text == null) {
      text = "";
    }

    root.addElement("aba_routing_number").addText(text);

    text = f.getFundingAccountNum();

    if (text == null) {
      text = "";
    }

    root.addElement("payment_account").addText(text);

    SimpleDateFormat sf = new SimpleDateFormat("MMyy");

    try {
      text = sf.format(f.getExpirationDate());
    } catch (Exception e) {
      text = "";
    }

    root.addElement("cc_exp_date").addText(text);

    text = f.getCvv();

    if (text == null) {
      text = "";
    }

    root.addElement("cc_cvv").addText(text);

    text = f.getAddress().getPostalCode();

    if (text == null) {
      text = "";
    }

    root.addElement("zipcode").addText(text);
  } // end method addFundingElements

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addITSPaymentType(Element e, Payment payment) {
    String text = null;
    text = getITSPaymentType(payment);

    if (text != null) {
      e.addElement("payment_type").addText(text);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addITStotalAmount(Element e, Payment payment) {
    String text = null;
    text = payment.getTotalAmountStr();

    if (text != null) {
      e.addElement("amount").addText(text);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static void addITSUserIdAndPwd(Element e, Payment payment) {
    String text = null;
    text = payment.getPaymentServiceId();

    if (text != null) {
      e.addElement("userid").addText(text);
    }

    text = payment.getResponsible().getUserLogon();

    if (text != null) {
      e.addElement("password").addText(text);
    }
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * Check if a payment type for ITS is card payment.
   *
   * @param   type  DOCUMENT ME!
   *
   * @return  check if a payment type for ITS is card payment.
   */
  private static boolean isITSCard(String type) {
    return ITSPaymentType.AmEx.name().equalsIgnoreCase(type)
      || ITSPaymentType.Visa.name().equalsIgnoreCase(type)
      || ITSPaymentType.Discover.name().equalsIgnoreCase(type)
      || ITSPaymentType.MasterCard.name().equalsIgnoreCase(type);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private static boolean isOldITSCard(String type) {
    return oldITSPaymentType.CC.name().equalsIgnoreCase(type)
      || oldITSPaymentType.DC.name().equalsIgnoreCase(type);
  }

} // end class PaymentXMLUtil
