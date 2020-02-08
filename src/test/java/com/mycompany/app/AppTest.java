package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        // assertTrue( true );

        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {2, 3, 4, 5, 6};

        String message = "hello";
        String key = "abcde";

        

        assertEquals("rndfn", App.encrypt(arr1, message, arr2, key));

    }
}
