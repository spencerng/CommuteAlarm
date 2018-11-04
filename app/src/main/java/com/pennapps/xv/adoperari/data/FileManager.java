package com.pennapps.xv.adoperari.data;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pennapps.xv.adoperari.models.Alarm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/** Static methods to save and load files
 * Created by sng on 1/21/2017.
 */

public class FileManager {

    public static final String ALARM_LIST_FILENAME = "Alarm List.json";

    public static ArrayList<Alarm> loadAlarmList(Context c) throws IOException{
        Type listEntries = new TypeToken<List<Alarm>>(){}.getType();
        Gson gson= new Gson();
        return gson.fromJson(readFile(ALARM_LIST_FILENAME, c), listEntries);

    }

    public static void saveAlarmList(ArrayList<Alarm> alarmList, Context c){
        Gson gson = new Gson();
        saveFile(gson.toJson(alarmList), ALARM_LIST_FILENAME, c);

    }

    public static void addSaveAlarm(Alarm alarm, Context c){
        ArrayList<Alarm> alarmList;
        try{
            alarmList = loadAlarmList(c);

        }catch(IOException e){
            alarmList = new ArrayList<>();
        }
        alarmList.add(alarm);
        saveAlarmList(alarmList, c);
    }

    public static void saveFile(String fileContents, String fileName, Context c){
        try {
            FileOutputStream fos = c.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(fileContents.getBytes());
            fos.close();
            Log.i("tag", "file saved");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String readFile(String fileName, Context c) throws IOException{


            FileInputStream fis = c.openFileInput(fileName);

            BufferedReader reader = new BufferedReader((new InputStreamReader(fis)));
            String data = "";
            String row;


            while ((row = reader.readLine()) != null)
                data += row;
            reader.close();
            return data;



    }

}
