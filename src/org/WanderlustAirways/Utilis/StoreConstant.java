package org.WanderlustAirways.Utilis;

import java.util.UUID;

public class StoreConstant {
	
    public static final String MODULE = "module";
    public static final String ACTION = "action";
    public static final int USER_ROLE=2;
    public static String PASSWORD = UUID.randomUUID().toString().replaceAll("-", "");
    public static final String SUBJECT="PASSWORD WANDERLUST AIRWAYS";
    //module
    public static final String MOD_USER="user";
    public static final String MOD_HOME="home";
    public static final String MOD_ADMIN="admin";
    public static final String MOD_BOOK="book";
    public static final String MOD_BLACKUSER="blackuser";
    public static final String MOD_PAYMENT="payment";
    public static final String MOD_FLIGHTSTATUS="flightstatus";
    //servlet
    public static final String SERVLET_BASE="base";
    public static final String SERVLET_LOGIN="login";
    public static final String SERVLET_HOME="home";
    public static final String SERVLET_ADMIN="admin";
    public static final String SERVLET_BOOKFLIGHT="bookflight";
    public static final String SERVLET_CHECKUSER="checkuser";
    public static final String SERVLET_PAYMENTINFO="payment";
    public static final String SERVLET_FLIGHTSTATUS="flight";
    
    //Action 
    public static final String ACTION_REGISTRATION="registration";
    public static final String ACTION_VIEW="view";
    public static final String ACTION_SIGNUP="signup";
    public static final String ACTION_SIGNOUT="signout";
    public static final String ACTION_SEARCH="search";
    public static final String ACTION_CHECK="check";
    public static final String ACTION_PAYMENT="payment";
    public static final String ACTION_SELECTION="select";
    public static final String ACTION_FLIGHTSTATUS="status";
    public static final String ACTION_BLACKLISTEDUSERDETAILS="blackuserdetails";
}
