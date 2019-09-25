package com.example.zur10part2.utils;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IO {

    private  IO(){};



    public static String read(InputStream in) throws IOException {
        System.out.println(in);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            System.out.println(sb.toString());
         return sb.toString();
        }

    }
    public static String read(AssetManager am, String filename)throws IOException{

        InputStream in = am.open(filename);
        return  read(in);
    }
}
