package com.pivotcoachingacademy.Pages;

public enum SideBar {
	MY_ACCOUNT("My Account", MyAccount.class), 
	EDIT_ACCOUNT("Edit Account", EditAccount.class),
	PASSWORD("", ChangePassword.class), 
	WISH_LIST("Wish List", MyWishList.class),
	NEWSLETTER("Newsletter",NewsletterSubscription.class),
	Returns("Returns",Returns.class),
	ADDRESSBOOK("Address Book", AddressBook.class);
	
	String pageName;
	Class<?> pageClass;
	private SideBar(String pageName, Class<?> pageClass) {
		this.pageName = pageName;
		this.pageClass = pageClass;
	}	
	public String getPageName() {
		return pageName;
	}

	public Class<?> getPageClass() {
		return pageClass;
	}

	public static SideBar getPageUsingText(String text) {
		SideBar[] sideBarContents = SideBar.values();
		for (int i = 0; i < sideBarContents.length; i++) {
			if (sideBarContents[i].name().toLowerCase().equalsIgnoreCase(text)) {
				return sideBarContents[i];
			}
		}
		return null;
	}

}
