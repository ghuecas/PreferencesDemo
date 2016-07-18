package es.upm.dit.adsw.preferencesdemo;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String COUNTER= "contador";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the app's shared preferences
        SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Get the value for the run counter
        int counter = app_preferences.getInt(COUNTER, 0);

        // Update the TextView
        TextView text = (TextView) findViewById(R.id.text);
        String times= getString(R.string.timesStr, counter);
        text.setText(times);

        // Increment the counter
        SharedPreferences.Editor editor = app_preferences.edit();
        editor.putInt(COUNTER, ++counter);
        editor.commit(); // Very important
    }
}
