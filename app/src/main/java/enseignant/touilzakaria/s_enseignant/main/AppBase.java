package enseignant.touilzakaria.s_enseignant.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

import enseignant.touilzakaria.s_enseignant.R;
import enseignant.touilzakaria.s_enseignant.main.components.About;
import enseignant.touilzakaria.s_enseignant.main.components.GridAdapter;
import enseignant.touilzakaria.s_enseignant.main.components.SettingsActivity;
import enseignant.touilzakaria.s_enseignant.main.database.DatabaseHandler;

public class AppBase extends AppCompatActivity {

    public static ArrayList<String> divisions;
    public static DatabaseHandler handler;
    public static Activity activity;
    ArrayList<String> basicFields;
    GridAdapter adapter;
    GridView gridView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mai_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        basicFields = new ArrayList<>();
        handler = new DatabaseHandler(this);
        activity = this;

        getSupportActionBar().show();
        divisions = new ArrayList<>();
        divisions.add("4eme année génie informatique");
        divisions.add("4eme année génie industriel");
        divisions.add("4eme année génie mécanique");
        divisions.add("4eme année génie electrique");
        divisions.add("4eme année génie civil");
        divisions.add("5eme année génie industriel");
        divisions.add("5eme année génie informatique");
        divisions.add("5eme année génie mécanique");
        divisions.add("5eme année génie electrique");
        divisions.add("5eme année génie civil");
        gridView = (GridView) findViewById(R.id.grid);
        basicFields.add("PRÉSENCE");
        basicFields.add("PLANIFICATEUR");
        basicFields.add("REMARQUES");
        basicFields.add("PROFIL");
        adapter = new GridAdapter(this, basicFields);
        gridView.setAdapter(adapter);
    }

    public void loadSettings(MenuItem item) {
        Intent launchIntent = new Intent(this, SettingsActivity.class);
        startActivity(launchIntent);
    }

    public void loadAbout(MenuItem item) {
        Intent launchIntent = new Intent(this, About.class);
        startActivity(launchIntent);
    }
}
