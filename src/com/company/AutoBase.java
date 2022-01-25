package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AutoBase {

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
   // public static final Path WRITE_PATH = Paths.get("./trucks.json");

    public static void autoBase(){

        Truck[] trucks = {
                Truck.makeTruck(1, TruckTruck.RENAULT_MAGNUM,"",State.BASE),
                Truck.makeTruck(2, TruckTruck.BMV,"",State.BASE),
                Truck.makeTruck(3, TruckTruck.DAF_XT,"",State.BASE),
                Truck.makeTruck(4, TruckTruck.TOYOTA,"",State.BASE),
                Truck.makeTruck(5, TruckTruck.VOLVO,"",State.BASE)

        };
        String truckDrivers = GSON.toJson(trucks);
        write(truckDrivers);


        Truck[] truck1 = GSON.fromJson(readFile(),Truck[].class);
        System.out.println("--------------------Trucks--------------------------------------"+'\n'+
                "#|"+ " Bus                     " + "| Driver  " + "  | State  "+ '\n' +
                "-+-------------------------+--------------------+---------------"+'\n');
        for(Truck a: truck1){
            System.out.println(a.toString());
        }


    }
    //==========================написание файла==========================================//
    private static void write(String obj){
        Path write = Paths.get(java.lang.String.valueOf("./trucks.json"));

        try {
            Files.writeString(write, obj, StandardOpenOption.CREATE,
                    StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.getMessage();
        }
    }
    //========================чтение файла=============================================//
    private static String readFile() {
        String json = "";

        try {
            FileReader dr = new FileReader(java.lang.String.valueOf("./trucks.json"));
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
