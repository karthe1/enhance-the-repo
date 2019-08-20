package com.karthick.testcases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.karthick.questions.ValidateMailAddress;

/**
 * 
 * @author zkarrxx
 *
 * This is a test class for validating the Email validation application using JUnit 4 and Mockito 2+
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class EmailValidationTest {

	private static final String MOCK_OUTPUT = "Email validation has been completed";

	@Spy
	@InjectMocks
	private static ValidateMailAddress validMailAddress;

	@Test
	public void testValidEmailAddress() {
		String[] conditions = { "good123@bad.com", "foo@bar.com", "good.boy@company.com",
				"blackmaliyahoo.kumar1.@yahoo.com", "56790kumar.kumar_1.89@gmial.com" };
		for (String emailId : conditions) {
			assertTrue(validMailAddress.emailValidation(emailId));
		}
	}

	@Test
	public void testInValidEmailAddress() {
		String[] conditions = { "admin#codeeval.com", "this is not an email id", "blackmaliyahoo.kumar1_1_89@yahoo.pom",
				"blackmaliyahoo.kumar(1.@yahhoo.com" };
		for (String emailId : conditions) {
			assertFalse(validMailAddress.emailValidation(emailId));
		}
	}

	@AfterClass
	public static void afterClass() {
		when(validMailAddress.endTest("End")).thenReturn(MOCK_OUTPUT);
	}

}
