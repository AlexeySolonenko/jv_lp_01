package com.timbuchalka;

import java.io.*;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {
        //FileWriter localFile = null;
        /* there are checked and unchecked exeptoins. */
        /* checked are not allowed to be ignored - must be either caught or specified */

        /* !!!!! TRY INTRODUCES A NEW SCOPE BLOCK */
//        try {
//////            localFile = new FileWriter("locations.txt");
//////            for (Location location : locations.values()) {
//////                localFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//////                //throw new IOException("test exceptoin thrown while writing");
//////
//////            }
//////            //localFile.close();
//////        } finally {
//////            System.out.println("In finally block");
//////            if (localFile != null) {
//////                System.out.println("Attempting to close the file ");
//////                localFile.close();
//////            }
//////        }
//        try (FileWriter locFile = new FileWriter("locations.txt");
//             FileWriter dirFile = new FileWriter("directions.txt")) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()) {
//                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                }
//            }
//        }

//        try(
//                BufferedWriter locWriter = new BufferedWriter(new FileWriter("locations.txt",true));
//                BufferedWriter dirWriter = new BufferedWriter(new FileWriter("directions.txt",true));)
//        {
//            for(Location location: locations.values()){
//                locWriter.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                //locWriter.newLine();
//                for(String direction: location.getExits().keySet()){
//                    if(!direction.equals("Q")){
//                    dirWriter.write(location.getLocationID() + ","+direction+","+location.getExits().get(direction));
//                    }
//                    //dirWriter.newLine();
//                }
//            }
//        } catch (IOException e){
//            e.printStackTrace();
//        }

//        try (
//                DataOutputStream locFile = new DataOutputStream((new BufferedOutputStream(new FileOutputStream("locations.dat"))))
//        ) {
//
//            for (Location location : locations.values()) {
//                locFile.writeInt(location.getLocationID());
//                locFile.writeUTF(location.getDescription());
//                System.out.println("Writint location: " + location.getLocationID() + ": " + location.getDescription());
//                System.out.println("Writing" + (location.getExits().size()-1) + "exits.");
//                locFile.writeInt((location.getExits().size()-1));
//                for(String direction: location.getExits().keySet()){
//                    if(!direction.equalsIgnoreCase("Q")){
//                        System.out.println("\t\t" + direction +"," + location.getExits().get(direction));
//                        locFile.writeUTF(direction);
//                        locFile.writeInt(location.getExits().get(direction));
//                    }
//                }
//            }
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        try (
                ObjectOutputStream locFile = new ObjectOutputStream((new BufferedOutputStream(new FileOutputStream("locations.dat"))))
        ) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
    }

    static {

//        try{FileWriter locFile = new FileWriter("locations.txt");
//            FileWriter dirFile = new FileWriter("directions.txt"){
//            }
//        }


        /**/
        //Scanner scanner = null;
//     //   try{
//            scanner = new Scanner(new FileReader("locations_big.txt"));
//            scanner.useDelimiter(",");
//            while(scanner.hasNextLine()){
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(loc, new Location(loc, description,tempExit));
//            }
//        } catch(IOException e){
//            e.printStackTrace();
//        } finally{
//            if(scanner != null){
//                scanner.close();
//            }
//        }

//        try (
//                Scanner locsScanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")));
//                Scanner exitsScanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")))
//        ) {
//            locsScanner.useDelimiter(",");
//            while (locsScanner.hasNextLine()) {
//                int loc = locsScanner.nextInt();
//                locsScanner.skip(locsScanner.delimiter());
//                String description = locsScanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                Map<String, Integer> tempExit = new LinkedHashMap<>();
//                locations.put(loc, new Location(loc, description, tempExit));
//            }
//            locsScanner.useDelimiter(",");
//            while (exitsScanner.hasNextLine()) {
//                String input = exitsScanner.nextLine();
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        try (
//                BufferedReader locsReader = new BufferedReader(new FileReader("locations_big.txt"));
//                BufferedReader exitsReader = new BufferedReader(new FileReader("directions_big.txt"))
//        ) {
//            //locsReader.useDelimiter(",");
//            String line;
//            String[] data;
//            while ((line = locsReader.readLine()) != null) {
//                data = line.split(",");
//                System.out.println("Imported loc: " + data[0] + ": " + data[1]);
//                Map<String, Integer> tempExit = new HashMap<>();
//                locations.put(Integer.parseInt(data[0]), new Location(Integer.parseInt(data[0]), data[1], tempExit));
//            }
//            while ((line = exitsReader.readLine()) != null) {
//                data = line.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /* OBJECT IS WRITTEN UNIQUELY/ONCE PER FILE - PER INSTANCE */

        /*
        * 1. This first four types will containe the number of location (bytes 0-3)
        * 2. The next four types will contian the start offset of the locations section (4-7)
        * 3. The next seciotnof the file will conitain the index (the index is 1692 byes long. It will start at bye 8 and end at byte 1699
        * 4. The final section of the file will contain the location records (the dat). It will start at byte 1700
        * */



        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream((new FileInputStream("locations.dat"))))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    System.out.println("Read location " + location.getLocationID() + ": " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");

                    locations.put(location.getLocationID(),location);
                } catch(InvalidClassException ice){
                    System.out.println("Invalid class exception");
                } catch(EOFException io) {
                    io.printStackTrace();
                    eof = true;
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
//            while (!eof) {
//                try {
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locId = locFile.readInt();
//                    String description = locFile.readUTF();
//                    int numExits = locFile.readInt();
//                    System.out.println("Read location: " + locId + " : " + description);
//                    System.out.println("Found " + numExits + " exits");
//                    for (int i = 0; i < numExits; i++) {
//                        String direction = locFile.readUTF();
//                        int destination = locFile.readInt();
//                        exits.put(direction, destination);
//                        System.out.println("\t\t" + direction + ", " + destination);
//
//                    }
//                    locations.put(locId, new Location(locId, description, exits));
//                    /* generated automatically EOFException */
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
