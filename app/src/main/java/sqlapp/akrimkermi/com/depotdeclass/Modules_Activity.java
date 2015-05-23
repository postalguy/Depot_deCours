package sqlapp.akrimkermi.com.depotdeclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import sqlapp.akrimkermi.com.Metier.*;

public class Modules_Activity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_);

        /*En attente du nombre de modules et de leurs intitules -- implémentés en un liste de modules */
        /* test statique : */
        Cours Mod1 = new Cours(1,"Prog sys","language C Assuré par Madame Mandar");
        Cours Mod2 = new Cours(2,"Prog res","language C Assuré par Madame Mandar après la programmation système");
        Cours Mod3 = new Cours(3,"Java","Assuré par Mr Hafidi");
         ArrayList<Cours> Modules = new ArrayList<>();
        Modules.add(Mod1);
        Modules.add(Mod2);
        Modules.add(Mod3);



        Button[] buttons_modules = new Button[Modules.size()];
        LinearLayout ScrollviewtoLinear = (LinearLayout) findViewById(R.id.ScrollLinLay);
        for(int i=0;i<Modules.size();i++){
            buttons_modules[i]= new Button(this);
            buttons_modules[i].setText(Modules.get(i).getIntitule());
            final String Desc = Modules.get(i).getDescription();
            final Integer id_module = Modules.get(i).getId_cours();
            ScrollviewtoLinear.addView(buttons_modules[i]);
            buttons_modules[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),Cours_Activity.class);
                    intent.putExtra("description",Desc);
                    intent.putExtra("id_cours",id_module);
                    startActivity(intent);
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modules_, menu);
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
