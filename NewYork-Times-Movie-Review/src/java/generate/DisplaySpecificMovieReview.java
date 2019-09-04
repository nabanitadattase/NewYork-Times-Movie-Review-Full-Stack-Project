/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package generate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author Nabanita
 */
public class DisplaySpecificMovieReview {

    public static String[] specificSearchMovie(String MovieName) throws IOException, JSONException {
//Api Calling with the parameter API key & specific Movie Name    
        String url = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?api-key=2yvL9QdTsGrIs2JabxLvqbAr4dWN3EFs&query=" + MovieName;
        URL obj = new URL(url);
        //create a connection
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setConnectTimeout(100000);
        con.setReadTimeout(100000);
        con.setInstanceFollowRedirects(true);
        //        Getting Response code
//        System.out.println(String.valueOf(con.getResponseCode()));

//        Reading the file
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print in String
//        System.out.println(response.toString());
        //Read JSON response and print
        org.json.JSONObject myResponse = new org.json.JSONObject(response.toString());
//        result after Reading JSON Response
//        Dynamically taking the size of array
        String[] value1 = new String[myResponse.getInt("num_results")];
        // read json array
        JSONArray arrObj = myResponse.getJSONArray("results");
//        Getting the reviews
        for (int i = 0; i < arrObj.length(); i++) {
            org.json.JSONObject jsonObject = arrObj.getJSONObject(i);
            value1[i] = jsonObject.getString("headline");
        }
        return value1;
    }
}
