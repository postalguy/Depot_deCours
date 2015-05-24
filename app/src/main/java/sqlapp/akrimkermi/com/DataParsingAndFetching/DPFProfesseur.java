package sqlapp.akrimkermi.com.DataParsingAndFetching;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
//import java.io.StringWriter;
//import java.net.HttpURLConnection;
import java.util.ArrayList;
//import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStreamReader;
//import sqlapp.akrimkermi.com.Metier.Etudiant;
import sqlapp.akrimkermi.com.Metier.Professeur;
import sqlapp.akrimkermi.com.Metier.User;
//import java.net.URL;

/**
 * Created by elkarmi on 23/05/2015.
 */
public class DPFProfesseur {
    private Context con;
    private DPFUser dpfu;
    private String link = "http://localhost/GestionDeCours/Ressources/Professeurs.json";// lien temporaire
    public volatile boolean parsingComplete = true;

    public  DPFProfesseur(){
        dpfu = new DPFUser();
    }
    // Test local
    public DPFProfesseur(Context co) {
        this.con = co;dpfu = new DPFUser();
    }
    public DPFProfesseur(String link) {
        this.link = link;dpfu = new DPFUser();
    }


    public ArrayList<Professeur> Parsing(String in) {
        try {
            JSONObject reader = new JSONObject(in);
            Integer NombreProfesseurs = Integer.valueOf(reader.getInt("nombre"));

            JSONArray Users = reader.getJSONArray("professeurs");
            ArrayList<Professeur> users = new ArrayList<Professeur>();
            for (int i = 0; i < NombreProfesseurs; i++) {
                JSONObject Jsonuser = Users.getJSONObject(i);
                Integer id_professeur = Integer.valueOf(Jsonuser.getInt("id_professeur"));

                Integer id_user = Integer.valueOf(Jsonuser.getInt("id_user"));
                User userprof = dpfu.getUserById(id_user);
                Professeur prof = new Professeur(id_user, userprof.getName(), userprof.getEmail(), userprof.getPassword(), id_professeur);
                users.add(prof);
            }
            parsingComplete = false;
            return users;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Professeur> getAllProfesseurs(){
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
            InputStream stream = con.getAssets().open("Professeurs.json");
            String data = convertStreamToString(stream);
            ArrayList<Professeur> AllProfesseurs = Parsing(data);
            stream.close();
            return AllProfesseurs;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public Professeur getProfesseurById(Integer id) {
        ArrayList<Professeur> prof = this.getAllProfesseurs();
        for (int i = 0; i < prof.size(); i++) {
            if (prof.get(i).getId_professeur() == id)
                return prof.get(i);
        }
        return null;
    }
}

