package enseignant.touil.s_enseignant.main.components;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.Toast;

import enseignant.touil.s_enseignant.R;
import enseignant.touil.s_enseignant.main.AppBase;
import enseignant.touil.s_enseignant.main.components.AppCompatPreferenceActivity;

public class SettingsActivity extends AppCompatPreferenceActivity {
    Activity base = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBar();
        addPreferencesFromResource(R.xml.pref_general);


        Preference myPref = findPreference("clear_schedule");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(base);
                alert.setTitle("Êtes-vous sûr ?");
                alert.setMessage("Cela effacera toutes vos données de planification");
                alert.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String qu = "DROP TABLE SCHEDULE";
                        if (AppBase.handler.execAction(qu)) {
                            Toast.makeText(getBaseContext(), "Terminé", Toast.LENGTH_LONG).show();
                            AppBase.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });
        myPref = findPreference("clear_attendance");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(base);
                alert.setTitle("Êtes-vous sûr ?");
                alert.setMessage("Cela effacera toutes vos données de présence");
                alert.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String qu = "DROP TABLE ATTENDANCE";
                        if (AppBase.handler.execAction(qu)) {
                            Toast.makeText(getBaseContext(), "Terminé", Toast.LENGTH_LONG).show();
                            AppBase.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });

        myPref = findPreference("clear_notes");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(base);
                alert.setTitle("Êtes-vous sûr ?");
                alert.setMessage("Cela effacera toutes vos données Notes");
                alert.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String qu = "DROP TABLE NOTES";
                        if (AppBase.handler.execAction(qu)) {
                            Toast.makeText(getBaseContext(), "Terminé", Toast.LENGTH_LONG).show();
                            AppBase.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });

        myPref = findPreference("clear_student");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(base);
                alert.setTitle("Êtes-vous sûr ?");
                alert.setMessage("Cela effacera toutes vos données d'étudiant");
                alert.setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String qu = "DROP TABLE STUDENT";
                        if (AppBase.handler.execAction(qu)) {
                            Toast.makeText(getBaseContext(), "Terminé", Toast.LENGTH_LONG).show();
                            AppBase.handler.createTable();
                            dialog.dismiss();
                        }
                    }
                });
                alert.setNegativeButton("NON", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.show();
                return true;
            }
        });
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
