package com.mycompany.app;

public class App {

    public static String encrypt(Integer[] table_message, String message, Integer[] table_key, String key) {

        // shift every char of message with table_message[index], if index exceeds message head back to start index.
        // shift every char of key with table_key[index], if index exceeds key head back to start index.

        // encrypted message is (message[i] + key[i]) for all i.

        int size_message = message.length();
        int size_key = key.length();
        
        String shifted_message = "";
        for (int i = 0; i < table_message.length; i++) {
            int shift_amount = table_message[i];
            char ch = message.charAt(i % size_message);
            if ((ch >= 'a' && ch <= 'z') == false) {
                System.out.println("String contains non-lowercase letters");
                return "None";
            }
            char shifted_char = (char) (((ch - 'a') + shift_amount) % 26 + 'a');
            shifted_message = shifted_message + shifted_char;
        }
        System.out.println(shifted_message);


        String shifted_key = "";
        for (int i = 0; i < table_key.length; i++) {
            int shift_amount = table_key[i];
            char ch = message.charAt(i % size_key);
            char shifted_char = (char) (((ch - 'a') + shift_amount) % 26 + 'a');
            shifted_key = shifted_key + shifted_char;
        }
        System.out.println(shifted_key);

        size_message = shifted_message.length();
        size_key = shifted_key.length();

        String encrypted_message = "";
        for (int i = 0; i < Math.min(size_message, size_key); i++) {
            char new_char = (char) (((shifted_message.charAt(i) - 'a') + (shifted_key.charAt(i) - 'a')) % 26 + 'a');
            encrypted_message = encrypted_message + new_char;
        }

        return encrypted_message;
    }

    
}
