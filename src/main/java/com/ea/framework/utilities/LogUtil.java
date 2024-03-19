package com.ea.framework.utilities;

import com.ea.framework.config.Settings;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

    //File format for the log name
    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy' at 'HH.mm.ss");
    String fileNameFormat = date.format(formatter);
    private BufferedWriter bufferedWriter = null;
    //Create log files
    public void createLogFile() throws IOException {
        try{
            var directory = new File(Settings.LogPath);
            if(!directory.exists()) {
                directory.mkdir();
            }
            //Create file
            var logFile = new File(directory + "/" + fileNameFormat + ".log");
            var fileWriter = new FileWriter(logFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //Write message within the log file
    public void write(String message){
        try{
            formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy' at 'HH.mm.ss");
            var dateFormt = date.format(formatter);
            bufferedWriter.write("["+dateFormt+"] "+message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
