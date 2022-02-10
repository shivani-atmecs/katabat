package com.cmc.credagility.core.repository.jdbc;

import java.util.Map;

/**
 * Created by lihao1 on 1/15/16.
 */
public interface SsoTokenRepositoryJdbc {
    Map<String,Object> getLoginInformation(String ucid);
    Map<String,Object> getLoginInformationByUCID(String ucid);
    Map<String,Object> getLoginInformationByOANHash(String accountId);
    Map<String,Object> getLoginInformationBySsnHash(String ssn);
    Map<String, Object> getLoginInformationByUCIDAndOANHash(String ucid, String oanHash);
    Map<String, Object> getLoginInformationByUCIDAndSsnHash(String ucid, String ssnHash);
    Map<String, Object> getLoginInformationByOANHashAndSsnHash(String oanHash, String ssnHash);
    Map<String, Object> getLoginInformationByUCIDAndOANHashAndSsnHash(String ucid, String oanHash, String ssnHash);
}
