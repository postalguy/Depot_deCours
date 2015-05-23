package sqlapp.akrimkermi.com.Metier;

import java.util.Date;

/**
<<<<<<< Updated upstream
 * Created by akrim ykhrydfsdf on 22/05/2015.
=======
 * Created by akrim on 22/05/2015.
>>>>>>> Stashed changes
 */
public class Document {
    private Integer id_document;
    private String intitule;
    private String lien;
    private Date date_creation;
    private Date date_modification;
    private String type;
    private String nature;
    private Professeur depose_par;
<<<<<<< Updated upstream
    private String nu; // to remove
=======
>>>>>>> Stashed changes

    public Document() {
    }

    public Document(Integer id_document, String intitule,String lien, Date date_modification, Date date_creation, String type, String nature, Professeur depose_par) {
        this.id_document = id_document;
        this.intitule = intitule;
        this.lien = lien;
        this.date_modification = date_modification;
        this.date_creation = date_creation;
        this.type = type;
        this.nature = nature;
        this.depose_par = depose_par;
    }

    public Document(Integer id_document, String intitule, Date date_creation, Date date_modification, String type, String nature) {
        this.id_document = id_document;
        this.intitule = intitule;
        this.date_creation = date_creation;
        this.date_modification = date_modification;
        this.type = type;
        this.nature = nature;
    }

    public Integer getId_document() {
        return id_document;
    }

    public void setId_document(Integer id_document) {
        this.id_document = id_document;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Professeur getDepose_par() {
        return depose_par;
    }

    public void setDepose_par(Professeur depose_par) {
        this.depose_par = depose_par;
    }
}
