package sqlapp.akrimkermi.com.Metier;

/**
 * Created by akrim on 22/05/2015.
 */
public class Etudiant extends User {
     private Integer id_etudiant;
    private Integer id_groupe;


    public Etudiant(){
        super();
    }
    public Etudiant(Integer ide,Integer idg){
        super();
        id_etudiant=ide; id_groupe=idg;
    }
    public Etudiant(Integer uid,String name,String email,String password,Integer ide,Integer idg){
        super(uid,name,email,password);
        this.id_etudiant=ide;
        this.id_groupe=idg;
    }


    public Integer getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(Integer id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public Integer getId_groupe() {
        return id_groupe;
    }

    public void setId_groupe(Integer id_groupe) {
        this.id_groupe = id_groupe;
    }
}

