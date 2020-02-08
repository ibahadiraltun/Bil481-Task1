package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

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

        java.util.ArrayList<Integer> arr1 = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> arr2 = new java.util.ArrayList<>();
        arr1.add(1); arr1.add(2); arr1.add(3); arr1.add(4); arr1.add(5);
        arr2.add(2); arr2.add(3); arr2.add(4); arr2.add(5); arr2.add(6);
        String message = "hello";
        String key = "abcde";
        assertEquals("rndfn", App.encrypt(arr1, message, arr2, key));

    }

    public void testNullMessage() {
        java.util.ArrayList<Integer> arr1 = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> arr2 = new java.util.ArrayList<>();
        arr1.add(12); arr1.add(112); arr1.add(13); arr1.add(45); arr1.add(125);
        arr2.add(24); arr2.add(35); arr2.add(42); arr2.add(59); arr2.add(61);
        String message = "";
        String key = "abcde";
        assertEquals("none", App.encrypt(arr1, message, arr2, key));

    }

    public void testBig() {
        java.util.ArrayList<Integer> arr1 = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> arr2 = new java.util.ArrayList<>();
        arr1.add(126); arr1.add(1112); arr1.add(113); arr1.add(8912); arr1.add(4875); arr1.add(1215);
        arr2.add(124); arr2.add(3598); arr2.add(4211); arr2.add(5139); arr2.add(681);
        String message = "bahadiraltun";
        String key = "temporarykey";
        assertEquals("sewlyw", App.encrypt(arr1, message, arr2, key));
    }

    public void testNullKey() {
        java.util.ArrayList<Integer> arr1 = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> arr2 = new java.util.ArrayList<>();
        arr1.add(126); arr1.add(1112); arr1.add(113); arr1.add(4875); arr1.add(1215);
        arr2.add(124); arr2.add(3598); arr2.add(4211); arr2.add(5139); arr2.add(681);
        String message = "samplemessage";
        String key = "";
        assertEquals("none", App.encrypt(arr1, message, arr2, key));
    }

    public void testNullArr1() {
        java.util.ArrayList<Integer> arr1 = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> arr2 = new java.util.ArrayList<>();
        // arr1.add(126); arr1.add(1112); arr1.add(113); arr1.add(4875); arr1.add(1215);
        arr2.add(124); arr2.add(3598); arr2.add(4211); arr2.add(5139); arr2.add(681);
        String message = "samplemessage";
        String key = "samplekey";
        assertEquals("none", App.encrypt(arr1, message, arr2, key));
    }

    public void testNullArr2() {
        java.util.ArrayList<Integer> arr1 = new java.util.ArrayList<>();
        java.util.ArrayList<Integer> arr2 = new java.util.ArrayList<>();
        arr1.add(126); arr1.add(1112); arr1.add(113); arr1.add(4875); arr1.add(1215);
        // arr2.add(124); arr2.add(3598); arr2.add(4211); arr2.add(5139); arr2.add(681);
        String message = "samplemessage";
        String key = "samplekey";
        assertEquals("none", App.encrypt(arr1, message, arr2, key));
    }


}
