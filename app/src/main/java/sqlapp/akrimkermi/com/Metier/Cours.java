package sqlapp.akrimkermi.com.Metier;

import java.util.ArrayList;

/**
 * Created by akrim on 22/05/2015.
 */
public class Cours {

    private Integer id_cours;
    private String intitule;
    private String description;
    private ArrayList<Document> documents;


    public Cours() {

    }
    public Cours(Integer id_cours, String intitule, String description) {

        this.id_cours = id_cours;
        this.intitule = intitule;
        this.description = description;
    }
    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Integer getId_cours() {
        return id_cours;
    }

    public void setId_cours(Integer id_cours) {
        this.id_cours = id_cours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public void AddDocument(Document Doc){
        this.documents.add(Doc);
    }



}
