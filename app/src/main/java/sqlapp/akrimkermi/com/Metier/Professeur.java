package sqlapp.akrimkermi.com.Metier;

/**
 * Created by akrim on 22/05/2015.
 */
public class Professeur extends User {
  private Integer id_professeur;

    public Professeur() {
    }

    public Professeur(Integer user_id,String name,String email,String password,Integer id_professeur) {
        super(user_id,name,email,password);
        this.id_professeur = id_professeur;
    }

    public Integer getId_professeur() {
        return id_professeur;
    }

    public void setId_professeur(Integer id_professeur) {
        this.id_professeur = id_professeur;
    }


}
