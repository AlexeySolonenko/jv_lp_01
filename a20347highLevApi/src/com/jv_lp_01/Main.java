package com.jv_lp_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {

            //URL url = new URL("http://example.org");
            //URL url = new URL("http://example.org/somepage.html");
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
            //URLConnection urlConnection = url.openConnection();
            /* http connection is per connection, but url is reusable */
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //https://api.flickr.com/services/feeds/photos_public.gne?tags=cats

            /* unlike url connection, connect here is automatic and implicit - run only where necessary */
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            //http://openjdk.java.net/jeps/110
            //http://hc.apache.org/httpcomponents-client-ga


            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));


            String line = "";
            while ( (line = inputReader.readLine()) != null) {
                line = inputReader.readLine();
                System.out.println(line);
            }
            inputReader.close();


            /* example with url connection */
//            urlConnection.setDoOutput(true);
//            urlConnection.connect();
//            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for(Map.Entry<String, List<String>> entry: headerFields.entrySet()){
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("-------key = " + key);
//                for(String string: value){
//                    System.out.println("value = " + string);
//                }
//            }

//            String line = "";
//            while(line != null){
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();


            /* one way of doing things - with a stream */
            //URI uri = url.toURI();
//            BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
//            String line = "";
//            while(line != null){
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();

            /*db throws exception  */
//            URI uri = new URI("db://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//            URI baseUri = new URI("http://username:password@myserver.com:5000");
//            /* but URL does accept http schema (protocol) */
//            uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//            URI relativeUri1 = new URI("/catalogue/phones?os=android#samsung");
//            URI relativeUri2 = new URI("/catalogue/tvs?manufacturer=samsung");
//            URI relativeUri3 = new URI("/stores/locations?zip=12345");
//            URI resolvedUri1 = baseUri.resolve(relativeUri1);
//            URI resolvedUri2 = baseUri.resolve(relativeUri2);
//            URI resolvedUri3 = baseUri.resolve(relativeUri3);
//            /* relative does not work URI has to be absolute
//             *  */
//            uri = new URI("/catalogue/phones?os=android#samsung");
//
//            /* does not work */
//            //URL url= uri.toURL();
//            /* let's try this one - gives us an absolute URL  */
//            URL url1 = resolvedUri1.toURL();
//            System.out.println("URL = " + url1);
//
//            URL url2 = resolvedUri2.toURL();
//            System.out.println("URL = " + url2);
//
//            URL url3 = resolvedUri3.toURL();
//            System.out.println("URL = " + url3);
//
//            URI relativzeddURI = baseUri.relativize(resolvedUri2);
//            System.out.println("Relative URI = " + relativzeddURI);

            /* also works */
            //URI uri = new URI("hello");

//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme specific part = " + uri.getRawSchemeSpecificPart());
//            System.out.println("Authrority  = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Frament = " + uri.getFragment());
//        } catch (URISyntaxException e) {
//            System.out.println("URI Bad Syntax Exception" + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL malformed : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception + " + e.getMessage());
        }

    }
}
