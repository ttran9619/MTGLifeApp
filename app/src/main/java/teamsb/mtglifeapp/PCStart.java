package teamsb.mtglifeapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class PCStart extends ActionBarActivity {

    Button venmoTrans, priceButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcstart);

        venmoTrans = (Button) findViewById(R.id.venmoTran);

        priceButton = (Button) findViewById(R.id.cardPrice);

        venmoTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VenmoTest.class);
                startActivity(intent);
            }
        });

        priceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PriceView.class);
                startActivity(intent);
            }
        });

    }

}
