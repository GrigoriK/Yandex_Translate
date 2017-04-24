package com.example.grishany.yandex_mobilization2017;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Grishany on 20.04.2017.
 */

public  class Yandex_translate {


//Метод перевода текста с одного языка на другой
    public static String translate(String lang, String input) throws IOException {
        String urlStr = "https://translate.yandex.net/api/v1.5/tr.json/translate?" +
                "key=trnsl.1.1.20170403T232753Z.cf9e98bfcf86a12a.be0898e4f2c200889f6d7b974e056e016d7afc52";
        URL urlObj = new URL(urlStr);
        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(input, "UTF-8") + "&lang=" + lang);

        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();
        int start = json.indexOf("[");
        int end = json.indexOf("]");
        String translated = json.substring(start + 2, end - 1);
        return translated;

    }

    public static String declare(String input) throws IOException {
        String urlStr = "https://translate.yandex.net/api/v1.5/tr.json/detect?" +
                "key=trnsl.1.1.20170403T232753Z.cf9e98bfcf86a12a.be0898e4f2c200889f6d7b974e056e016d7afc52";
        URL urlObj = new URL(urlStr);
        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(input, "UTF-8"));

        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();
        int start = json.indexOf(",");
         int end = json.indexOf("}");
        String translated = json.substring(start + 9, end - 2);
               return translated;


    }
//Получение списка всех языков
      public static  HashMap<String,String> getLangs () throws IOException {
        String urlStr = "https://translate.yandex.net/api/v1.5/tr.json/getLangs?" +
                "key=trnsl.1.1.20170403T232753Z.cf9e98bfcf86a12a.be0898e4f2c200889f6d7b974e056e016d7afc52";
        URL urlObj = new URL(urlStr);
        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
        dataOutputStream.writeBytes("ui="+URLEncoder.encode("ru", "UTF-8"));

        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();

        int end = json.indexOf("]");
        String translated = json.substring(end+11, json.length()-2 );


        String [] str = translated.split(",");
//При преобразовании кодировок буква "И" не отображается.Пришлось самому добавлять.
        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<(str.length-1);i++){
            String stroc=new String (str[i].getBytes(), "UTF-8");
            int start=stroc.indexOf(":");
            int k=str.length-1;
            String key=stroc.substring(1,start-1);
            String value=stroc.substring(start+2,stroc.length()-1);
            String s="И";
            switch(i){
                case(18):
                case(24):
                case(28):
                case(34):
                case(35):
                case(36):
                case(91):
                {
                    value=s+value.substring(2,value.length());
                }
                break;
            }


            map.put(key,value);


        }
        return map;
    }
}
