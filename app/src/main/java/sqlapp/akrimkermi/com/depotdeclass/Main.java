package sqlapp.akrimkermi.com.depotdeclass;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sqlapp.akrimkermi.com.Metier.User;


public class Main extends Activity {

    ArrayList<User> Registred_users = new ArrayList<User>();  //Entité de test





    private EditText username=null;
    private EditText  password=null;
    private TextView attempts;
    private Button login;
    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user1 = new User("Ismail Akrim","akrim@gmail.com","admin");   // Entité de test
        User user2 = new User("Mohamed El Karmi","karmi@gmail.com","Bratan"); //Entité de test
        Registred_users.add(user1);   //Entité de test
        Registred_users.add(user2);   //Entité de test
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        attempts = (TextView)findViewById(R.id.textView5);
        attempts.setTextSize(13);
        attempts.setText("attempts left : "+Integer.toString(counter));
        login = (Button)findViewById(R.id.button1);
    }

    /*partie de Test de mot de pass à déplacer en DBO : */

    public User getUserByEmail(String mail){
           for(int i=0;i<Registred_users.size();i++){
                   if (Registred_users.get(i).getEmail().equals(mail)){
                      User us = Registred_users.get(i);
                                return us;}

                }  return null;
    }

    public Boolean PasswordValid(String pass){

        if((getUserByEmail(username.getText().toString())!=null)&&pass.equals(getUserByEmail(username.getText().toString()).getPassword()))
        {
            return true;
        }else

        return false;
    }



    // fin de la partie test mot de passe

    public void login(View view){
           login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /*checking */

                    if(PasswordValid(password.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Redirecting...",
                                Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Menu_activity.class);
                    intent.putExtra("actualUser",getUserByEmail(username.getText().toString()).getName());
                    startActivity(intent);
                    } else{
                       Toast.makeText(getApplicationContext(), "Erreur D'identification",
                                Toast.LENGTH_SHORT).show();
                        attempts.setTextColor(Color.RED);
                        counter--;
                        attempts.setText("essaies : "+Integer.toString(counter));

                        if(counter==0){
                            login.setEnabled(false);
                        }

                    }
                }
            });



    }







}
/* // Redirection :
  login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),Menu_activity.class);
                    startActivity(intent);
                }
            });
 */
