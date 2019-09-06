package com.xianzhi.platform.webapp.common.session;


import com.xianzhi.platform.webapp.common.model.AccountCO;

import java.util.Set;


public class SessionContextAccessor {

	@SuppressWarnings("unchecked")
	public static <T extends AccountCO> T getCurrentAccount() {
		return (T) HttpSessionContextUtility.getAttribute(AccountCO.getContextKey());
    }
	
	public static void setCurrentAccount(AccountCO account) {
		if (account == null) {
			HttpSessionContextUtility.removeAttribute(AccountCO.getContextKey());
		} else {
			HttpSessionContextUtility.setAttribute(AccountCO.getContextKey(), account);
		}
    }
}