package sqlapp.akrimkermi.com.depotdeclass;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;




public class Notification_Activity extends ActionBarActivity {

    Button to_Prof;
    Button to_Colleges;
    EditText Subject;
    EditText Contente;
    String[] Profs_Emails = {"Imad.hafidi@gmail.com"};
    String[] Colleges_Emails = {"A@gmail.com"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_);
        this.to_Prof = (Button) findViewById(R.id.button_Send_to_Prof);
        this.to_Colleges = (Button)  findViewById(R.id.button_Send_to_Camarades);
        this.Subject = (EditText) findViewById(R.id.Sujet_Text);
        this.Contente = (EditText) findViewById(R.id.Contenu_field);

        String Cont=Contente.getText().toString();

        to_Prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailToProfIntent = new Intent(Intent.ACTION_SEND);
                emailToProfIntent.putExtra(Intent.EXTRA_EMAIL,Profs_Emails);
                emailToProfIntent.putExtra(Intent.EXTRA_SUBJECT,Subject.getText().toString());
                emailToProfIntent.setType("plain/text");
                emailToProfIntent.putExtra(Intent.EXTRA_TEXT,Contente.getText().toString());
                startActivity(emailToProfIntent);
            }
        });
        to_Colleges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailToProfIntent = new Intent(Intent.ACTION_SEND);
                emailToProfIntent.putExtra(Intent.EXTRA_EMAIL,Colleges_Emails);
                emailToProfIntent.putExtra(Intent.EXTRA_SUBJECT,Subject.getText().toString());
                emailToProfIntent.setType("plain/text");
                emailToProfIntent.putExtra(Intent.EXTRA_TEXT,Contente.getText().toString());
                startActivity(emailToProfIntent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
