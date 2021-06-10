package com.qa.opencart.util;

import java.util.ArrayList;
import java.util.List;

public class ConstantsUtil {

	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_ERROR_MESSAGE = " Warning: No match for E-Mail Address and/or Password";
	public static final String HOME_PAGE_TITLE = "Your Store";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_CREATION_SUCESS_FILE="Your Account Has Been Created!";
	public static final String ACCOUNT_LOGOUT_HEADER_TITLE="Account Logout";
	public static final String REGISTER_ACCOUNT_DATA="Register";

	public static final List<String> expMenyoptions() {

		List<String> expmenu = new ArrayList<>();

		expmenu.add("Login");
		expmenu.add("Register");
		expmenu.add("Forgotten Password");
		expmenu.add("My Account");
		expmenu.add("Address Book");
		expmenu.add("Wish List");
		expmenu.add("Order History");
		expmenu.add("Downloads");
		expmenu.add("Recurring payments");
		expmenu.add("Reward Points");
		expmenu.add("Returns");
		expmenu.add("Transactions");
		expmenu.add("Newsletter");

		return expmenu;

	}

	public static final List<String> accountHeaderTitles() {
		List<String> expAccountHeader = new ArrayList<>();
		expAccountHeader.add("My Account");
		expAccountHeader.add("My Orders");
		expAccountHeader.add("My Affiliate Account");
		expAccountHeader.add("Newsletter");

		return expAccountHeader;
	}
	
	public static final List<String> accountHeaderSubmenuTitles() {
		List<String> expAccountHeaderSubmenutitle = new ArrayList<>();
		expAccountHeaderSubmenutitle.add("Edit your account information");
		expAccountHeaderSubmenutitle.add("Change your password");
		expAccountHeaderSubmenutitle.add("Modify your address book entries");
		expAccountHeaderSubmenutitle.add("Modify your wish list");
		expAccountHeaderSubmenutitle.add("View your order history");
		expAccountHeaderSubmenutitle.add("Downloads");
		expAccountHeaderSubmenutitle.add("Your Reward Points");
		expAccountHeaderSubmenutitle.add("View your return requests");
		expAccountHeaderSubmenutitle.add("Your Transactions");
		expAccountHeaderSubmenutitle.add("Recurring payments");
		expAccountHeaderSubmenutitle.add("Register for an affiliate account");
		expAccountHeaderSubmenutitle.add("Subscribe / unsubscribe to newsletter");
		

		return expAccountHeaderSubmenutitle;
	}

}
