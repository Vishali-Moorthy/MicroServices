/**
 * 
 */
package com.visha.web;

import java.util.List;

/**
 * @author Dinesh.Rajput
 *
 */
public interface AccountRepository {
	
	List<Account> getAllAccounts();
	
	Account getAccount(String number);
}
