package com.polobix.testCases;

import org.testng.annotations.Test;

public class images extends BaseClass {
	
	@Test
	public void TC_Imagetest() {
		checkImageStatus("https://koinpro.io/portal/dashboard");
	}

}
