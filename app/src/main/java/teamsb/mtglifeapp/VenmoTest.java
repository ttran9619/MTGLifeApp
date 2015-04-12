package teamsb.mtglifeapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class VenmoTest extends ActionBarActivity {

    EditText recipient, amount, note;
    Button pay, charge;
    final int REQUEST_CODE_VENMO_APP_SWITCH = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venmo_test);


        recipient = (EditText) findViewById(R.id.friendsVenmo);
        amount = (EditText) findViewById(R.id.amount);
        note = (EditText) findViewById(R.id.note);
        pay = (Button) findViewById(R.id.pay);
        charge = (Button) findViewById(R.id.charge);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rec = recipient.getText().toString();
                String am = amount.getText().toString();
                String n = note.getText().toString();
                String p = "pay";
                try  {
                    Intent venmoIntent = VenmoLibrary.openVenmoPayment("2535", "MTGLifeApp", rec, am, n, p);
                    startActivityForResult(venmoIntent, REQUEST_CODE_VENMO_APP_SWITCH);
                } catch (android.content.ActivityNotFoundException e){

                    Context context = getApplicationContext();
                    CharSequence text = "Venmo Installation Not Detected";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });

        charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rec = recipient.getText().toString();
                String am = amount.getText().toString();
                String n = note.getText().toString();
                String p = "charge";
                try {
                    Intent venmoIntent = VenmoLibrary.openVenmoPayment("2535", "MTGLifeApp", rec, am, n, p);
                    startActivityForResult(venmoIntent, REQUEST_CODE_VENMO_APP_SWITCH);
                }  catch (android.content.ActivityNotFoundException e){
                    Context context = getApplicationContext();
                    CharSequence text = "Venmo Installation Not Detected";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }


            }
        });
            }

            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                switch (requestCode) {
                    case REQUEST_CODE_VENMO_APP_SWITCH: {
                        if (resultCode == RESULT_OK) {
                            String signedrequest = data.getStringExtra("signedrequest");
                            if (signedrequest != null) {
                                VenmoLibrary.VenmoResponse response = (new VenmoLibrary()).validateVenmoPaymentResponse(signedrequest, "TUzLetByjsqy9vj2pDaeqVM7HTx926Vm");
                                if (response.getSuccess().equals("1")) {
                                    //Payment successful.  Use data from response object to display a success message
                                    String note = response.getNote();
                                    String amount = response.getAmount();
                                }
                            } else {
                                String error_message = data.getStringExtra("error_message");
                                //An error ocurred.  Make sure to display the error_message to the user
                            }
                        } else if (resultCode == RESULT_CANCELED) {
                            //The user cancelled the payment
                        }
                        break;
                    }
                }
            }
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_venmo_test, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
