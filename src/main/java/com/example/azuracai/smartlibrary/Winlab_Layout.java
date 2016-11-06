package com.example.azuracai.smartlibrary;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Winlab_Layout extends AppCompatActivity {

//    public EditText editText;
    public TextView textView;
    public Button save, refresh;

    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aaTextResource";

    private static Button Conf_sbm;

    private static Button Orbit_sbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winlab__layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        OnClickButtonListener();

        textView = (TextView) findViewById(R.id.availability);
        refresh = (Button) findViewById(R.id.load);
//        editText = (EditText) findViewById(R.id.editText);
        save = (Button) findViewById(R.id.save);

        File dir = new File(path);
        dir.mkdirs();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JSONTask().execute("http://192.168.207.141/test.php");
            }
        });
    }

    public class JSONTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            BufferedReader reader = null;

            HttpURLConnection connection = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (Integer.parseInt(result) == 1){
                textView.setText("0");
            }
            else {
                textView.setText("1");
            }
        }
    }

    public void OnClickButtonListener(){
        Conf_sbm = (Button) findViewById(R.id.win_conf);
        Conf_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("com.example.azuracai.smartlibrary.winlab_conf");
                        startActivity(intent);
                    }
                }
        );


        Orbit_sbm = (Button) findViewById(R.id.winlab_Orbit);
        Orbit_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent("com.example.azuracai.smartlibrary.winlab_orbit");
                        startActivity(intent);
                    }
                }
        );
    }

//    public void buttonSave(View view){
//        File file = new File(path + "/savedFile.txt");
//        String[] saveText = String.valueOf(editText.getText()).split(System.getProperty("line.separator"));
//
//        editText.setText("");
//
//        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
//
//        Save (file, saveText);
//    }

//    public void buttonLoad(View view){
//        File file = new File(path + "/savedFile.txt");
//        String [] loadText = Load(file);
//
//        Scanner s = new Scanner(this.getResources().openRawResource(R.raw.a));

//        String finalString = "";
//
//        finalString = s.next();
//
//        if (Integer.parseInt(s.next()) == 1){
//            textView.setBackgroundColor(Color.RED);
//        }
//
//        finalString = loadText[0];

//        textView.setText(finalString);
//
//        s.close();

//         try{
//             InputStream is = getResources().openRawResource(R.raw.a);
//             InputStreamReader inputStreamReader = new InputStreamReader(is, "UTF-8");
//             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//             String info = "";
//             while ((info = bufferedReader.readLine()) != null) {
//
//                 Log.i("info", info);
//
//             }
//         }
//         catch (IOException e){
//             e.printStackTrace();
//         }

//    }

//    public static void Save(File file, String[] data){
//        FileOutputStream fos = null;
//        try{
//            fos = new FileOutputStream(file);
//        }
//        catch (FileNotFoundException e){
//            e.printStackTrace();
//        }
//        try{
//            try{
//                for (int i = 0; i<data.length;i++){
//                    fos.write(data[i].getBytes());
//                    if (i < data.length-1){
//                        fos.write("\n".getBytes());
//                    }
//                }
//            }
//            catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//        finally{
//            try{
//                fos.close();
//            }
//            catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//    }


//    public static String[] Load(File file){
//        FileInputStream fis = null;
//        try{
//            fis = new FileInputStream(file);
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        InputStreamReader isr = new InputStreamReader(fis);
//        BufferedReader br = new BufferedReader(isr);
//
//        String test;
//        int anzahl = 0;
//        try{
//            while((test=br.readLine()) != null){
//                anzahl++;
//            }
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try{
//            fis.getChannel().position(0);
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//
//        String[] array = new String[anzahl];
//
//        String line;
//        int i = 0;
//
//        try{
//            while((line = br.readLine()) != null){
//                array[i] = line;
//                i++;
//            }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        return array;
//
//    }

}
