package layout.com.layoutdemoapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import layout.com.layoutdemoapp.sharedpref.SharedPrefClass;

public class MainActivityAgent extends AppCompatActivity {

    EditText edt_fname, edt_lname, edt_addr;
    SharedPrefClass prefClass;
    Button btn_submit;
    String fname, lname, addr;
    TextView txt_company_name;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpref_layout);

        edt_fname = (EditText) findViewById(R.id.edt_fname);
        edt_lname = (EditText) findViewById(R.id.edt_lname);
        edt_addr = (EditText) findViewById(R.id.edt_addr);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        txt_company_name = (TextView) findViewById(R.id.txt_company_name);

        try {
            /** SharedPreferences */
            sharedPreferences = getSharedPreferences(SharedPrefClass.PREF_NAME, 0);
            // Session Manager
            prefClass = new SharedPrefClass(getApplicationContext());

            btn_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    fname = edt_fname.getText().toString();
                    lname = edt_lname.getText().toString();
                    addr = edt_addr.getText().toString();
                    prefClass.setData(fname, lname, addr);

                    String fname1 = sharedPreferences.getString(SharedPrefClass.KEY_FIRST_NAME, "");
                    String lname1 = sharedPreferences.getString(SharedPrefClass.KEY_LAST_NAME, "");
                    String addr1 = sharedPreferences.getString(SharedPrefClass.KEY_ADDRESS, "");

                    txt_company_name.setText(fname1 + "," + lname1 + "," + addr1);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}