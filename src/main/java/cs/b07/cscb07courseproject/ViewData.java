package cs.b07.cscb07courseproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import user.Client;

public class ViewData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        Intent intent = getIntent();
        Client client = (Client) intent.getSerializableExtra("clientKey");
        String display = client.toString();

        TextView view  = (TextView) findViewById(R.id.client_info);

        view.setText(display);
    }
}

