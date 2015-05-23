package sqlapp.akrimkermi.com.DataParsingAndFetching;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.security.acl.Group;
import java.util.ArrayList;

import sqlapp.akrimkermi.com.Metier.User;
import sqlapp.akrimkermi.com.Metier.Etudiant;
import sqlapp.akrimkermi.com.Metier.Groupe;
/**
 * Created by akrim on 23/05/2015.
 */
public class DPFGroupe {
    private Context con;
    private String link = "http://localhost/GestionDeCours/Ressources/Groupes.json";// lien temporaire
    public volatile boolean parsingComplete = true;


    public DPFGroupe() {
    }

    public DPFGroupe(Context con) {
        this.con = con;
    }

    public DPFGroupe(String link) {
        this.link = link;
    }

    public ArrayList<Groupe> Parsing(String in) {
        try {
            JSONObject reader = new JSONObject(in);
            Integer NombreUsers = Integer.valueOf(reader.getInt("nombre"));

            JSONArray Users = reader.getJSONArray("groupes");
            ArrayList<Groupe> users = new ArrayList<Groupe>();
            for (int i = 0; i < NombreUsers; i++) {
                JSONObject Jsonuser = Users.getJSONObject(i);
                Integer groupe_id =Integer.valueOf(Jsonuser.getInt("groupe_id")) ;
                String intitule = Jsonuser.getString("intitule");
                Groupe usr = new Groupe(groupe_id,intitule);
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



    public ArrayList<Groupe> getAllGroupes(){
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
            InputStream stream = con.getAssets().open("Groupes.json");
            String data = convertStreamToString(stream);
            ArrayList<Groupe> AllUsers = Parsing(data);
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


    public Groupe getGroupeById(Integer id){
        ArrayList<Groupe> all = this.getAllGroupes();
        for (int i = 0; i <all.size() ; i++) {
            if(all.get(i).getId_groupe()==id){
                return all.get(i);
            }
        }
        return null;
    }


}
