package teamsb.mtglifeapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;


public class LifeHost extends ActionBarActivity {

    Button  infM1, infM5, infP1, infP5;
    Button  heaM1, heaM5, heaP1, heaP5;
    Button pass, back;

    ImageButton GBLife, HBLife;

    RadioButton gIndi, hIndi;

    TextView HLife, HInfect, HTCount, HName;
    TextView GLife, GInfect, GTCount, GName;

    CheckBox HostLight, GuestLight;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_host);

        final Player host = new Player (global.hostName);
        final Player guest = new Player (global.guestName);


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
        GName = (TextView) findViewById(R.id.GuestName);
        GName.setText(""+guest.getName());




        heaM1= (Button) findViewById(R.id.HealthMinusOne);
        heaM5= (Button) findViewById(R.id.HealthMinusFive);
        heaP1= (Button) findViewById(R.id.HealthPlusOne);
        heaP5= (Button) findViewById(R.id.HealthPlusFive);

        infM1= (Button) findViewById(R.id.InfectMinusOne);
        infM5= (Button) findViewById(R.id.InfectMinusFive);
        infP1= (Button) findViewById(R.id.InfectPlusOne);
        infP5= (Button) findViewById(R.id.InfectPlusFive);

        pass = (Button) findViewById(R.id.PassButton);
        back = (Button) findViewById(R.id.BackButton);

        HostLight = (CheckBox) findViewById(R.id.HostTurnLight);
        GuestLight = (CheckBox) findViewById(R.id.GuestTurnLight);

        hIndi = (RadioButton) findViewById(R.id.HostIndicator);
        gIndi = (RadioButton) findViewById(R.id.GuestIndicator);

        GBLife = (ImageButton) findViewById(R.id.GuestLifeButton);
        HBLife = (ImageButton) findViewById(R.id.HostLifeButton);



        //Random Gen
        Random rand = new Random();

        if(rand.nextInt()%2==0){
            hIndi.setChecked(true);
            HostLight.setChecked(true);
            host.takeTurn();
        }else{
            gIndi.setChecked(true);
            GuestLight.setChecked(true);
            guest.takeTurn();
        }


        heaM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hIndi.isChecked()){
                    host.subLife(1);
                    HLife.setText(""+host.getLife());
                }else
                if(gIndi.isChecked()){
                    guest.subLife(1);
                    GLife.setText(""+guest.getLife());
                }
            }
        });

        heaM5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hIndi.isChecked()){
                    host.subLife(5);
                    HLife.setText(""+host.getLife());
                }
                if(gIndi.isChecked()){
                    guest.subLife(5);
                    GLife.setText(""+guest.getLife());
                }
            }
        });

        heaP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hIndi.isChecked()){
                    host.addLife(1);
                    HLife.setText(""+host.getLife());
                }else
                if(gIndi.isChecked()){
                    guest.addLife(1);
                    GLife.setText(""+guest.getLife());
                }
            }
        });

        heaP5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hIndi.isChecked()){
                    host.addLife(5);
                    HLife.setText(""+host.getLife());
                }else
                if(gIndi.isChecked()){
                    guest.addLife(5);
                    GLife.setText(""+guest.getLife());
                }
            }
        });

        infM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hIndi.isChecked()){
                    host.subInfect(1);
                    HLife.setText(""+host.getLife());
                    HInfect.setText(""+host.getInfectCounter());
                }else
                if(gIndi.isChecked()){
                    guest.subInfect(1);
                    GLife.setText(""+guest.getLife());
                    GInfect.setText(""+guest.getInfectCounter());
                }

            }
        });

        infM5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hIndi.isChecked()){
                    host.subInfect(5);
                    HLife.setText(""+host.getLife());
                    HInfect.setText(""+host.getInfectCounter());
                }else
                if(gIndi.isChecked()){
                    guest.subInfect(5);
                    GLife.setText(""+guest.getLife());
                    GInfect.setText(""+guest.getInfectCounter());
                }
            }
        });

        infP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hIndi.isChecked()){
                    host.addInfect(1);
                    HLife.setText(""+host.getLife());
                    HInfect.setText(""+host.getInfectCounter());
                }else
                if(gIndi.isChecked()){
                    guest.addInfect(1);
                    GLife.setText(""+guest.getLife());
                    GInfect.setText(""+guest.getInfectCounter());
                }
            }
        });

        infP5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hIndi.isChecked()){
                    host.addInfect(5);
                    HLife.setText(""+host.getLife());
                    HInfect.setText(""+host.getInfectCounter());
                }else
                if(gIndi.isChecked()){
                    guest.addInfect(5);
                    GLife.setText(""+guest.getLife());
                    GInfect.setText(""+guest.getInfectCounter());
                }
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(host.getTurnStatus()){
                    host.passTurn();
                    guest.takeTurn();

                    host.addTurnCount();;
                    HTCount.setText(""+host.getTurnCount());

                    HostLight.setChecked(host.getTurnStatus());
                    GuestLight.setChecked(guest.getTurnStatus());
                }else
                if(guest.getTurnStatus()){
                    guest.passTurn();
                    host.takeTurn();

                    guest.addTurnCount();;
                    GTCount.setText(""+guest.getTurnCount());

                    GuestLight.setChecked(guest.getTurnStatus());
                    HostLight.setChecked(host.getTurnStatus());
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(host.getTurnStatus()){
                    guest.takeTurn();
                    host.passTurn();

                    guest.subTurnCount();;
                    GTCount.setText(""+guest.getTurnCount());

                    GuestLight.setChecked(guest.getTurnStatus());
                    HostLight.setChecked(host.getTurnStatus());
                }else
                if(guest.getTurnStatus()){
                    guest.passTurn();
                    host.takeTurn();

                    host.subTurnCount();;
                    HTCount.setText(""+host.getTurnCount());

                    HostLight.setChecked(host.getTurnStatus());
                    GuestLight.setChecked(guest.getTurnStatus());
                }

            }
        });

        GBLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gIndi.setChecked(true);
                hIndi.setChecked(false);
            }
        });

        HBLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gIndi.setChecked(false);
                hIndi.setChecked(true);
            }
        });

    }

}
