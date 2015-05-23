package sqlapp.akrimkermi.com.DataParsingAndFetching;

import android.content.Context;

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
}
