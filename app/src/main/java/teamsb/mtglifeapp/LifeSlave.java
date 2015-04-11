package teamsb.mtglifeapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class LifeSlave extends ActionBarActivity {

    Button infM1, infM5, infP1, infP5;
    Button  heaM1, heaM5, heaP1, heaP5;
    Button pass;


    TextView HLife, HInfect, HTCount, HName;
    TextView GLife, GInfect, GTCount, GName;
    TextView O1Life, O1Infect, O1TCount, O1Name;
    TextView O2Life, O2Infect, O2TCount, O2Name;

    CheckBox HostLight, GuestLight, Other1Light, Other2Light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_slave);

        final Player host = new Player ("Tyler");
        final Player guest = new Player ("Tim");
        final Player other1 = new Player ("Adam");
        final Player other2 = new Player ("Erica");


        HLife = (TextView) findViewById(R.id.HostLife);
        HLife.setText(""+host.getLife());
        HInfect = (TextView) findViewById(R.id.HostInfect);
        HInfect.setText(""+host.getInfectCounter());
        HTCount = (TextView) findViewById(R.id.HostTurnCount);
        HTCount.setText(""+host.getTurnCount());
        HName = (TextView) findViewById(R.id.HostName);
        HName.setText(""+host.getName());

        GLife = (TextView) findViewById(R.id.GuestLife);
        GLife.setText(""+guest.getLife());
        GInfect = (TextView) findViewById(R.id.GuestInfect);
        GInfect.setText(""+guest.getInfectCounter());
        GTCount = (TextView) findViewById(R.id.GuestTurnCount);
        GTCount.setText(""+guest.getTurnCount());

        O1Life = (TextView) findViewById(R.id.Other1Life);
        O1Life.setText("" + other1.getLife());
        O1Infect = (TextView) findViewById(R.id.Other1Infect);
        O1Infect.setText(""+other1.getInfectCounter());
        O1TCount = (TextView) findViewById(R.id.Other1TurnCount);
        O1TCount.setText(""+other1.getTurnCount());
        O1Name = (TextView) findViewById(R.id.Other1Name);
        O1Name.setText(""+other1.getName());

        O2Life = (TextView) findViewById(R.id.Player4Life);
        O2Life.setText(""+  other2.getLife());
        O2Infect = (TextView) findViewById(R.id.Other2Infect);
        O2Infect.setText(""+other2.getInfectCounter());
        O2TCount = (TextView) findViewById(R.id.Other2TurnCount);
        O2TCount.setText(""+other2.getTurnCount());
        O2Name = (TextView) findViewById(R.id.Player4Name);
        O2Name.setText(""+other2.getName());


        heaM1= (Button) findViewById(R.id.HealthMinusOne);
        heaM5= (Button) findViewById(R.id.HealthMinusFive);
        heaP1= (Button) findViewById(R.id.HealthPlusOne);
        heaP5= (Button) findViewById(R.id.HealthPlusFive);

        infM1= (Button) findViewById(R.id.InfectMinusOne);
        infM5= (Button) findViewById(R.id.InfectMinusFive);
        infP1= (Button) findViewById(R.id.InfectPlusOne);
        infP5= (Button) findViewById(R.id.InfectPlusFive);

        pass = (Button) findViewById(R.id.PassButton);

        HostLight.setChecked(true);
        host.takeTurn();



        heaM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guest.subLife(1);
                GLife.setText(""+host.getLife());
            }
        });

        heaM5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guest.subLife(5);
                GLife.setText(""+guest.getLife());
            }
        });

        heaP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guest.addLife(1);
                GLife.setText(""+guest.getLife());
            }
        });

        heaP5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guest.addLife(5);
                GLife.setText(""+guest.getLife());
                GInfect.setText(""+guest.getInfectCounter());
            }
        });

        infM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guest.subInfect(1);
                GLife.setText(""+guest.getLife());
                GInfect.setText(""+guest.getInfectCounter());
            }
        });

        infM5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guest.subInfect(5);
                GLife.setText(""+guest.getLife());
                GInfect.setText(""+guest.getInfectCounter());
            }
        });

        infP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guest.addInfect(1);
                GLife.setText(""+guest.getLife());
                GInfect.setText(""+guest.getInfectCounter());
            }
        });

        infP5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guest.addInfect(5);
                GLife.setText(""+guest.getLife());
                GInfect.setText(""+guest.getInfectCounter());
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(guest.getTurnStatus()){

                    //Pass Turn data to HOST
                }

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_life_slave, menu);
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
