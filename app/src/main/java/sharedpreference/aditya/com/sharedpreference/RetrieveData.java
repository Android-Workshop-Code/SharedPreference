package sharedpreference.aditya.com.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Aditya on 7/31/2015.
 */
public class RetrieveData extends ActionBarActivity{

    TextView tvName, tvEmail, tvPass;
    public static String name, pass, email;
    Button bRetrieve;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPass = (TextView) findViewById(R.id.tvPass);

        bRetrieve = (Button) findViewById(R.id.bRetrieve);

        bRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences(MainActivity.MyPREFERENCES, MODE_PRIVATE);
                String restoredText = prefs.getString("text", null);
                /**if (restoredText != null){
                    name = prefs.getString(MainActivity.Name, "No name defined");
                    pass = prefs.getString(MainActivity.Pass, "No password defined");
                    email = prefs.getString(MainActivity.Email, "No email defined");
                }*/

                name = prefs.getString(MainActivity.Name, "No name defined");
                pass = prefs.getString(MainActivity.Pass, "No pass defined");
                email = prefs.getString(MainActivity.Email, "No email defined");

                tvName.setText(name);
                tvPass.setText(pass);
                tvEmail.setText(email);
            }
        });
    }
}
