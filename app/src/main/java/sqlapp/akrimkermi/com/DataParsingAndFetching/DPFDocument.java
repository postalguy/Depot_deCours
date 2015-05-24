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
import sqlapp.akrimkermi.com.Metier.Document;
import sqlapp.akrimkermi.com.Metier.Professeur;
import sqlapp.akrimkermi.com.Metier.User;
//import java.net.URL;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;

import sqlapp.akrimkermi.com.Metier.Cours;
import sqlapp.akrimkermi.com.Metier.Document;
import sqlapp.akrimkermi.com.Metier.Etudiant;
import sqlapp.akrimkermi.com.Metier.Groupe;
/**
 * Created by akrim on 23/05/2015.
 */
public class DPFDocument {
    private Context con;
    private String link = "http://localhost/GestionDeCours/Ressources/Cours.json";// lien temporaire
    public volatile boolean parsingComplete = true;

    public DPFDocument(Context con){
        this.con=con;
    }
    public DPFDocument(String link){
        this.link=link;
    }

    public ArrayList<Document> Parsing(String in){
        try {
            JSONObject reader = new JSONObject(in);
            Integer NombreDocument = Integer.valueOf(reader.getInt("nombre"));

            JSONArray Documents = reader.getJSONArray("documents");
            ArrayList<Document> documents = new ArrayList<>();
            for (int i = 0; i < NombreDocument; i++) {
                JSONObject Jsondoc = Documents.getJSONObject(i);

                /*private Integer id_document;
                private String intitule;
                private String lien;
                private Date date_creation;
                private Date date_modification;
                private String type;
                private String nature;
                private Professeur depose_par; */
                Integer id_document =Integer.valueOf(Jsondoc.getInt("document_id"));
                String intitule = Jsondoc.getString("intitule_doc");
                /*
                String ackwardDate = "/Date(1376841597000)/";
//Dirty convertion
Calendar calendar = Calendar.getInstance();
String ackwardRipOff = ackwardDate.replace("/Date(", "").replace(")/", "");
Long timeInMillis = Long.valueOf(ackwardRipOff);
calendar.setTimeInMillis(timeInMillis);
System.out.println(calendar.getTime().toGMTString()); //Prints 18 Aug 2013 15:59:57 GMT
                */

                //Date date_creation=Jsondoc.getString("date_creation");
                Integer cours_id =Integer.valueOf(Jsondoc.getInt("cours_id")) ;
               // String intitule = Jsondoc.getString("intitule");
                String desc = Jsondoc.getString("description");
                Integer professeur_id =Integer.valueOf(Jsondoc.getInt("professeur_id")) ;
                Integer groupe_id =Integer.valueOf(Jsondoc.getInt("groupe_id")) ;
                Professeur prof = new DPFProfesseur().getProfesseurById(professeur_id);

                //  Document doc = new Document(cours_id,intitule,desc);
               // doc.add(documents);
            }
            parsingComplete = false;
           // return doc;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Document> getAllDocument(){
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
            InputStream stream = con.getAssets().open("Documents.json");
            String data = convertStreamToString(stream);
            ArrayList<Document> AllDocuments = Parsing(data);
            stream.close();
            return AllDocuments;

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
