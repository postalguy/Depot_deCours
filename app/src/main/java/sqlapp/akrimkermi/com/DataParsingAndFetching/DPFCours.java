package sqlapp.akrimkermi.com.DataParsingAndFetching;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import sqlapp.akrimkermi.com.Metier.Document;
import sqlapp.akrimkermi.com.Metier.Etudiant;
import sqlapp.akrimkermi.com.Metier.Cours;
import sqlapp.akrimkermi.com.Metier.Professeur;

/**
 * Created by akrim on 23/05/2015.
 */
public class DPFCours {
    private Context con;
    private String link = "http://localhost/GestionDeCours/Ressources/Cours.json";// lien temporaire
    public volatile boolean parsingComplete = true;


    public DPFCours() {
    }

    public DPFCours(Context con) {
        this.con = con;
    }

    public DPFCours(String link) {
        this.link = link;
    }

    public ArrayList<Cours> Parsing(String in) {
        try {
            JSONObject reader = new JSONObject(in);
            Integer NombreUsers = Integer.valueOf(reader.getInt("nombre"));

            JSONArray Users = reader.getJSONArray("cours");
            ArrayList<Cours> users = new ArrayList<Cours>();
            for (int i = 0; i < NombreUsers; i++) {
                JSONObject Jsonuser = Users.getJSONObject(i);
                Integer cours_id =Integer.valueOf(Jsonuser.getInt("cours_id")) ;
                String intitule = Jsonuser.getString("intitule");
                String desc = Jsonuser.getString("description");
                Integer professeur_id =Integer.valueOf(Jsonuser.getInt("professeur_id")) ;
                Integer groupe_id =Integer.valueOf(Jsonuser.getInt("groupe_id")) ;
                Professeur prof = new DPFProfesseur().getProfesseurById(professeur_id);


                Cours usr = new Cours(cours_id,intitule,desc);
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



    public ArrayList<Cours> getAllCours(){
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
            InputStream stream = con.getAssets().open("Cours.json");
            String data = convertStreamToString(stream);
            ArrayList<Cours> AllUsers = Parsing(data);
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


    public Cours getCoursById(Integer id){
        ArrayList<Cours> all = this.getAllCours();
        for (int i = 0; i <all.size() ; i++) {
            if(all.get(i).getId_cours()==id){
                return all.get(i);
            }
        }
        return null;
    }


}
