package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AutoDriver {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_DRIVER_PATH = Paths.get("./drivers.json");


    public static void autoDriver() {

        Driver[] driver = {
                Driver.makeDriver(1, "Petr"),
                Driver.makeDriver(2, "Vova"),
                Driver.makeDriver(3, "Sasha"),
                Driver.makeDriver(4, "Toma"),
                Driver.makeDriver(5, "Misha")
        };

        String driverT = GSON.toJson(driver);
        writeDriver(driverT);

        Driver[] drivers2 = GSON.fromJson(readDriver(), Driver[].class);
        System.out.println("                              ");
        System.out.println(" #  Driver      | Bus          ");
        System.out.println("--+-----------+-------------+");
        for (Driver a : drivers2) {
            System.out.println(a.toString());
        }

    }
    //==========================написание файла==========================================//
        private static void writeDriver(String obj){
            Path write = Paths.get(String.valueOf("./drivers.json"));

            try {
                Files.writeString(write, obj, StandardOpenOption.CREATE,
                        StandardOpenOption.WRITE);
            } catch (IOException e) {
                e.getMessage();
            }

        }

    //========================чтение файла=============================================//
        private static String readDriver () {
            String json = "";

            try {
                FileReader dr = new FileReader(String.valueOf("./drivers.json"));
                int d;
                while ((d = dr.read()) != -1) {
                    json += (char) d;
                }
                return json;
            } catch (IOException e) {
                e.getMessage();
            }
            return json;
        }

    }
