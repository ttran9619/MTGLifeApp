package teamsb.mtglifeapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LifeHost extends ActionBarActivity {

    Button  infM1, infM5, infP1, infP5;
    Button  heaM1, heaM5, heaP1, heaP5;
    Button pass;

    TextView HLife, HInfect, HTCount;
    TextView P2Life, P2Infect, P2TCount, P2Name;
    TextView P3Life, P3Infect, P3TCount, P3Name;
    TextView P4Life, P4Infect, P4TCount, P4Name;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_host);


        final Player host = new Player ("Tyler");
        final Player player2 = new Player ("Tim");
        final Player player3 = new Player ("Adam");
        final Player player4 = new Player ("Erica");


        HLife = (TextView) findViewById(R.id.HostLife);
        HLife.setText(""+host.getLife());
        HInfect = (TextView) findViewById(R.id.HostInfect);
        HInfect.setText(""+host.getInfectCounter());
        HTCount = (TextView) findViewById(R.id.HostTurnCount);
        HTCount.setText(""+host.getTurnCount());

        P2Life = (TextView) findViewById(R.id.Player2Life);
        P2Life.setText(""+player2.getLife());
        P2Infect = (TextView) findViewById(R.id.Player2Infect);
        P2Infect.setText(""+player2.getInfectCounter());
        P2TCount = (TextView) findViewById(R.id.Player2TurnCount);
        P2TCount.setText(""+player2.getTurnCount());
        P2Name = (TextView) findViewById(R.id.Player2Name);
        P2Name.setText(""+player2.getName());

        P3Life = (TextView) findViewById(R.id.Player3Life);
        P3Life.setText(""+player3.getLife());
        P3Infect = (TextView) findViewById(R.id.Player3Infect);
        P3Infect.setText(""+player3.getInfectCounter());
        P3TCount = (TextView) findViewById(R.id.Player3TurnCount);
        P3TCount.setText(""+player3.getTurnCount());
        P3Name = (TextView) findViewById(R.id.Player3Name);
        P3Name.setText(""+player3.getName());

        P4Life = (TextView) findViewById(R.id.Player4Life);
        P4Life.setText(""+player4.getLife());
        P4Infect = (TextView) findViewById(R.id.Player4Infect);
        P4Infect.setText(""+player4.getInfectCounter());
        P4TCount = (TextView) findViewById(R.id.Player4TurnCount);
        P4TCount.setText(""+player4.getTurnCount());
        P4Name = (TextView) findViewById(R.id.Player4Name);
        P4Name.setText(""+player3.getName());



        heaM1= (Button) findViewById(R.id.HealthMinusOne);
        heaM5= (Button) findViewById(R.id.HealthMinusFive);
        heaP1= (Button) findViewById(R.id.HealthPlusOne);
        heaP5= (Button) findViewById(R.id.HealthPlusFive);

        infM1= (Button) findViewById(R.id.InfectMinusOne);
        infM5= (Button) findViewById(R.id.InfectMinusFive);
        infP1= (Button) findViewById(R.id.InfectPlusOne);
        infP5= (Button) findViewById(R.id.InfectPlusFive);


        heaM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                host.subLife(1);
                HLife.setText(""+host.getLife());
            }
        });

        heaM5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                host.subLife(5);
                HLife.setText(""+host.getLife());
            }
        });

        heaP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                host.addLife(1);
                HLife.setText(""+host.getLife());
            }
        });

        heaP5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                host.addLife(5);
                HLife.setText(""+host.getLife());
                HInfect.setText(""+host.getInfectCounter());
            }
        });

        infM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                host.subInfect(1);
                HLife.setText(""+host.getLife());
                HInfect.setText(""+host.getInfectCounter());
            }
        });

        infM5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                host.subInfect(5);
                HLife.setText(""+host.getLife());
                HInfect.setText(""+host.getInfectCounter());
            }
        });

        infP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                host.addInfect(1);
                HLife.setText(""+host.getLife());
                HInfect.setText(""+host.getInfectCounter());
            }
        });

        infP5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                host.addInfect(5);
                HLife.setText(""+host.getLife());
                HInfect.setText(""+host.getInfectCounter());
            }
        });

    }



    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onPause(){
        super.onPause();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_life_host, menu);
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
