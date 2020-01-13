package cs.b07.cscb07courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

import systemdata.SystemData;
import user.Billing;
import user.Client;

public class MainActivity extends AppCompatActivity {
    private DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private SystemData data = new SystemData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user clicks the add button */
    public void addClient(View view) {
        //Intent intent = new Intent(this, AddData.class);
        EditText clientInfoField = (EditText) findViewById(R.id.add_client);
        String clientInfo = clientInfoField.getText().toString();
        String[] clientArr = clientInfo.split(";");
        Client client = null;
        try {
            Date expDate = date.parse(clientArr[5]);
            Billing bill = new Billing(clientArr[3], clientArr[4], expDate);
            client = new Client(clientArr[0], clientArr[1], clientArr[2], bill);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        data.addClient(client);
        //intent.putExtra("clientKey", client);
        //startActivity(intent);
    }

    public void viewClient(View view) {
        Intent intent = new Intent(this, ViewData.class);
        EditText emailInfoText = (EditText) findViewById(R.id.view_client);
        String email = emailInfoText.getText().toString();
        Client client = data.searchClient(email);
        intent.putExtra("clientKey", client);
        startActivity(intent);
    }
}

