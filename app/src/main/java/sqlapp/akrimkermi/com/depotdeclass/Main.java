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


public class Main extends Activity {

    private EditText username=null;
    private EditText  password=null;
    private TextView attempts;
    private Button login;
    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.editText1);
        password = (EditText)findViewById(R.id.editText2);
        attempts = (TextView)findViewById(R.id.textView5);
        attempts.setTextSize(13);
        attempts.setText("attempts left : "+Integer.toString(counter));
        login = (Button)findViewById(R.id.button1);
    }


    public void login(View view){
           login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /*checking */
                    if(username.getText().toString().equals("admin") &&
                            password.getText().toString().equals("admin")){
                        Toast.makeText(getApplicationContext(), "Redirecting...",
                                Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Menu_activity.class);
                    intent.putExtra("actualUser",username.getText().toString());
                    startActivity(intent);
                    } else{
                        Toast.makeText(getApplicationContext(), "Erreur D'identification",
                                Toast.LENGTH_SHORT).show();
                        attempts.setTextColor(Color.RED);
                        counter--;
                        attempts.setText("attempts left : "+Integer.toString(counter));

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
