package sqlapp.akrimkermi.com.DataParsingAndFetching;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import sqlapp.akrimkermi.com.Metier.User;
import sqlapp.akrimkermi.com.Metier.Etudiant;
import sqlapp.akrimkermi.com.Metier.Groupe;
/**
 * Created by akrim on 23/05/2015.
 */
public class DPFEtudiant {
    private Context con;
    private DPFUser dpfu;
    private String link = "http://localhost/GestionDeCours/Ressources/Etudiant.json";// lien temporaire
    public volatile boolean parsingComplete = true;


    public DPFEtudiant() {
    }

    public DPFEtudiant(String link) {
        this.link = link;
    }

    public DPFEtudiant(Context con) {
        this.con = con;
    }

    public ArrayList<Etudiant> Parsing(String in) {
        try {
            JSONObject reader = new JSONObject(in);
            Integer NombreEtudiants = Integer.valueOf(reader.getInt("nombre"));

            JSONArray Users = reader.getJSONArray("users");
            ArrayList<Etudiant> users = new ArrayList<Etudiant>();
            for (int i = 0; i < NombreEtudiants; i++) {
                JSONObject Jsonuser = Users.getJSONObject(i);
                 Integer id_etudiant =Integer.valueOf(Jsonuser.getInt("id_etudiant")) ;
                Integer id_groupe =Integer.valueOf(Jsonuser.getInt("id_groupe")) ;
                Integer id_user = Integer.valueOf(Jsonuser.getInt("id_user"));
                User useret = dpfu.getUserById(id_user);
                Etudiant et = new Etudiant(id_user,useret.getName(),useret.getEmail(),useret.getPassword(),id_etudiant,id_groupe);
                users.add(et);
            }
            parsingComplete = false;
            return users;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Etudiant> getAllEtudiants(){
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
            InputStream stream = con.getAssets().open("Etudiants.json");
            String data = convertStreamToString(stream);
            ArrayList<Etudiant> AllEtudiants = Parsing(data);
            stream.close();
            return AllEtudiants;

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
