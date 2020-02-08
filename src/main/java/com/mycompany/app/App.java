package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App {

    public static String encrypt(java.util.ArrayList<Integer> table_message, String message, java.util.ArrayList<Integer> table_key, String key) {

        // shift every char of message with table_message[index], if index exceeds message head back to start index.
        // shift every char of key with table_key[index], if index exceeds key head back to start index.

        // encrypted message is (message[i] + key[i]) for all i.

        if (message.length() == 0 || key.length() == 0 || table_message.size() == 0 || table_key.size() == 0) {
            return "none";
        }

        int size_message = message.length();
        int size_key = key.length();
        
        message = message.toLowerCase();
        key = key.toLowerCase();

        String shifted_message = "";
        for (int i = 0; i < table_message.size(); i++) {
            int shift_amount = table_message.get(i);
            char ch = message.charAt(i % size_message);
            char shifted_char = (char) (((ch - 'a') + shift_amount) % 26 + 'a');
            shifted_message = shifted_message + shifted_char;
        }
        System.out.println(shifted_message);

        String shifted_key = "";
        for (int i = 0; i < table_key.size(); i++) {
            int shift_amount = table_key.get(i);
            char ch = message.charAt(i % size_key);
            char shifted_char = (char) (((ch - 'a') + shift_amount) % 26 + 'a');
            shifted_key = shifted_key + shifted_char;
        }
        System.out.println(shifted_key);

        size_message = shifted_message.length();
        size_key = shifted_key.length();

        String encrypted_message = "";
        for (int i = 0; i < Math.max(size_message, size_key); i++) {
            char new_char = (char) (((shifted_message.charAt(i % shifted_message.length()) - 'a') + (shifted_key.charAt(i % shifted_key.length()) - 'a')) % 26 + 'a');
            encrypted_message = encrypted_message + new_char;
        }

        System.out.println(encrypted_message);

        return encrypted_message;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);
        //   Integer[] arr1 = new Integer[inputList.size()];
        //   for (int i = 0; i < inputList.size(); i++) {
        //     arr1[i] = inputList.get(i);
        //   }

          String message = req.queryParams("input2").replaceAll("\\s","");
          // int input2AsInt = Integer.parseInt(input2);

          String input3 = req.queryParams("input3");
          sc1 = new java.util.Scanner(input3);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          System.out.println(inputList2);
        //   Integer[] arr2 = new Integer[inputList.size()];
        //   for (int i = 0; i < inputList.size(); i++) {
        //     arr2[i] = inputList.get(i);
        //   }

          String key = req.queryParams("input4").replaceAll("\\s","");
          // int input2AsInt = Integer.parseInt(input2);

          String result = key;

          Map map = new HashMap<String, String>();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }



}
