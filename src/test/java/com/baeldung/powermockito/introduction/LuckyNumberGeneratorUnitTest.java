package com.baeldung.powermockito.introduction;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.baeldung.powermockito.introduction.LuckyNumberGenerator")
public class LuckyNumberGeneratorUnitTest {

	//Testing the real default lucky number - 100 is returned if you pass in null
	@Test
	public final void basicTest() {
		assertEquals(100,new LuckyNumberGenerator().getLuckyNumber(null));
	}
	
	// Checks getLuckyNumber(null) means getDefaultLuckyNumber() is called
    @Test
    public final void givenPrivateMethodWithReturn_whenUsingPowerMockito_thenCorrect() throws Exception {
        LuckyNumberGenerator mockLuckNumberGenerator = spy(new LuckyNumberGenerator());

        when(mockLuckNumberGenerator, "getDefaultLuckyNumber").thenReturn(300);

        int result = mockLuckNumberGenerator.getLuckyNumber(null);

        assertEquals(300, result);
    }

    // Checks that getLuckyNumber("Jack") means private method getComputedLuckyNumber() called with some integer
    @Test
    public final void givenPrivateMethodWithArgumentAndReturn_whenUsingPowerMockito_thenCorrect() throws Exception {
        LuckyNumberGenerator mockLuckNumberGenerator = spy(new LuckyNumberGenerator());

        doReturn(1).when(mockLuckNumberGenerator, "getComputedLuckyNumber", ArgumentMatchers.anyInt());

        int result = mockLuckNumberGenerator.getLuckyNumber("Jack");

        assertEquals(1, result);
    }

    // Checks that getLuckyNumber("Tyranosorous") means private method saveIntoDatabase() called with some string
    @Test
    public final void givenPrivateMethodWithNoArgumentAndReturn_whenUsingPowerMockito_thenCorrect() throws Exception {
        LuckyNumberGenerator mockLuckNumberGenerator = spy(new LuckyNumberGenerator());

        int result = mockLuckNumberGenerator.getLuckyNumber("Tyranosorous");

        verifyPrivate(mockLuckNumberGenerator).invoke("saveIntoDatabase", ArgumentMatchers.anyString());
        assertEquals(10000, result);
    }

}
