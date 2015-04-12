package teamsb.mtglifeapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LCLoginAct extends ActionBarActivity {

    Button start;

    EditText hostName, guestName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lclogin);

        start = (Button) findViewById(R.id.StartButton);
        hostName = (EditText) findViewById(R.id.HostName);
        guestName = (EditText) findViewById(R.id.GuestName);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                global.hostName = hostName.getText().toString();
                global.guestName = guestName.getText().toString();
                Intent intent = new Intent(v.getContext(), LifeHost.class);
                startActivity(intent);
            }
        });

    }

}
