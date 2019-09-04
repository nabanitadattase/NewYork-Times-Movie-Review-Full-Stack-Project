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
import org.json.JSONObject;

/**
 *
 * @author Nabanita
 */
public class DisplayMovieReview {

    public static String[] searchMovie() throws IOException, JSONException {
        //Api Calling with the parameter API key
        String url = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?api-key=2yvL9QdTsGrIs2JabxLvqbAr4dWN3EFs";
        URL obj = new URL(url);
//        create a connection
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setConnectTimeout(100000);
        con.setReadTimeout(100000);
        con.setInstanceFollowRedirects(true);
//        Getting Response code
//        System.out.println(String.valueOf(con.getResponseCode()));
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        Reading the file
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print response in String
//       response.toString()
 //Read JSON response and print
        JSONObject myResponse = new JSONObject(response.toString());
//        result after Reading JSON Response
//        Dynamically taking the size of array
        String[] value = new String[myResponse.getInt("num_results")];
        // read json array
        JSONArray arrObj = myResponse.getJSONArray("results");

        //        Getting the reviews
        for (int i = 0; i < arrObj.length(); i++) {
            JSONObject jsonObject = arrObj.getJSONObject(i);
            value[i] = jsonObject.getString("headline");

        }
        return value;
    }
}
