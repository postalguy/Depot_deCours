package sqlapp.akrimkermi.com.DataParsingAndFetching;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import sqlapp.akrimkermi.com.Metier.Etudiant;
import sqlapp.akrimkermi.com.Metier.User;
import java.net.URL;


/**
 * Created by akrim on 23/05/2015.
 */
public class DPFUser {

 //   private ArrayList<User> AllUsers;
    private String link = "http://localhost/GestionDeCours/Ressources/Users.json";// lien temporaire


    public DPFUser() {
    }

    public DPFUser(String link) {
        this.link = link;
    }

    public ArrayList<User> getAllUsers() {
        try {


            Integer NombreUsers =0;
            Integer user_id;
            String nom;
            String prenom;
            String email;
            String password;



            JSONObject reader = new JSONObject(in);
            NombreUsers = Integer.valueOf(reader.getInt("nombre"));

            JSONArray Users = reader.getJSONArray("users");



            JSONObject sys  = reader.getJSONObject("sys");
            country = sys.getString("country");
            JSONObject main  = reader.getJSONObject("main");
            temperature = main.getString("temp");

            pressure = main.getString("pressure");
            humidity = main.getString("humidity");

            parsingComplete = false;



        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        return null;
    }



    public void fetchJson(){
        Thread th = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    URL url = new URL(link);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    // Starts the query
                    conn.connect();
                    InputStream stream = conn.getInputStream();

                    String data = convertStreamToString(stream);

                    readAndParseJSON(data);
                    stream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


}
