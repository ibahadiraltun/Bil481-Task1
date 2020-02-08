# Encryption Algorithm!

## Description
   Algorithm uses given integer arrays to shift characters of message and key.
    

 - It takes two arrays and two strings(message and key).
 - It shifts every char of message by array1[index], also shifts every char of key by array2[index].
 - Eventually, it gathers message and key with summing up ascii values of each index.

## Arguments

Function call is required 4 parameters.

 1. ArrayList of integers that will be use to shift message.
 2. Message as a string.
 3. ArrayList of integers that will be use to shift key.
 4. Key as a string.

Sample call:
```java
java.util.ArrayList<Integer> arr1 =  new  java.util.ArrayList<>();
java.util.ArrayList<Integer> arr2 =  new  java.util.ArrayList<>();

arr1.add(126); arr1.add(1112); arr1.add(113); arr1.add(4875); arr1.add(1215);
arr2.add(124); arr2.add(3598); arr2.add(4211); arr2.add(5139); arr2.add(681);

String message =  "samplemessage";
String key =  "samplekey";

encrypt(arr1, message, arr2, key);
```


[![Build Status](https://travis-ci.com/ibahadiraltun/Bil481-Task1.svg?branch=master)](https://travis-ci.com/ibahadiraltun/Bil481-Task1)


# Demo Site

Demo site: https://boiling-mesa-38472.herokuapp.com/compute
