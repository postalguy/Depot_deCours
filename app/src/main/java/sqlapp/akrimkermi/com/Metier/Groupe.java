package sqlapp.akrimkermi.com.Metier;

import java.util.ArrayList;

/**
 * Created by akrim on 22/05/2015.
 */
public class Groupe {
    private Integer id_groupe;
    private String intitule;
    private ArrayList<Etudiant> etudiants;

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }


    public Groupe() {
    }

    public Groupe(Integer id_groupe, String intitule) {
        this.id_groupe = id_groupe;
        this.intitule = intitule;

    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }



    public Integer getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(Integer id_groupe) {
        this.id_groupe = id_groupe;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void AddEtudiant(Etudiant et){
        this.etudiants.add(et);
    }


}


