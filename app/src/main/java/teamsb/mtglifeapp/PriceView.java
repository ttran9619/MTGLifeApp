package teamsb.mtglifeapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class PriceView extends ActionBarActivity {

    WebView web;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_view);

        web = (WebView) findViewById(R.id.webView);

        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://magic.tcgplayer.com/db/pricefinder.asp");
        web.setWebViewClient(new WebViewClient());
    }

}
