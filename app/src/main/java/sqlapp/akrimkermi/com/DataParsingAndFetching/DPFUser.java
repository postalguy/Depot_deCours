package sqlapp.akrimkermi.com.DataParsingAndFetching;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import sqlapp.akrimkermi.com.Metier.Etudiant;
import sqlapp.akrimkermi.com.Metier.User;
import java.net.URL;


/**
 * Created by akrim on 23/05/2015.
 */
public class DPFUser {

    private Context con;
    private String link = "http://localhost/GestionDeCours/Ressources/Users.json";// lien temporaire
    public volatile boolean parsingComplete = true;

    public DPFUser() {
    }

    // Test local
    public DPFUser(Context co) {
        this.con = co;
    }


    public DPFUser(String link) {
        this.link = link;
    }

    public ArrayList<User> Parsing(String in) {
        try {
            JSONObject reader = new JSONObject(in);
            Integer NombreUsers = Integer.valueOf(reader.getInt("nombre"));

            JSONArray Users = reader.getJSONArray("users");
            ArrayList<User> users = new ArrayList<User>();
            for (int i = 0; i < NombreUsers; i++) {
            JSONObject Jsonuser = Users.getJSONObject(i);
           // Integer user_id =Integer.valueOf(Jsonuser.getInt("user_id")) ;
            String username = Jsonuser.getString("nom")+Jsonuser.getString("prenom");
            String email = Jsonuser.getString("email");
            String password = Jsonuser.getString("password");
            User usr = new User(username,email,password);
            users.add(usr);
            }
            parsingComplete = false;
            return users;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }



    public ArrayList<User> getAllUsers(){
                try {
                    //URL url = new URL(link);
                   // HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                   // conn.setReadTimeout(10000 /* milliseconds */);
                   // conn.setConnectTimeout(15000 /* milliseconds */);
                   // conn.setRequestMethod("GET");
                   // conn.setDoInput(true);
                    // Starts the query
                   // conn.connect();
                   // InputStream stream = conn.getInputStream();
                     InputStream stream = con.getAssets().open("Users.json");
                    String data = convertStreamToString(stream);
                    ArrayList<User> AllUsers = Parsing(data);
                    stream.close();
                    return AllUsers;

                } catch (Exception e) {
                    e.printStackTrace();
                }
        return null;
    }


    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }


}
