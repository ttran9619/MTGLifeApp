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

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lclogin, menu);
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
