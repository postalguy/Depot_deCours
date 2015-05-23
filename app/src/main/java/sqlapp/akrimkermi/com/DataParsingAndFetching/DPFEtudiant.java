package sqlapp.akrimkermi.com.DataParsingAndFetching;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import sqlapp.akrimkermi.com.Metier.User;
import sqlapp.akrimkermi.com.Metier.Etudiant;
import sqlapp.akrimkermi.com.Metier.Groupe;
/**
 * Created by akrim on 23/05/2015.
 */
public class DPFEtudiant {
    private Context con;
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

}
