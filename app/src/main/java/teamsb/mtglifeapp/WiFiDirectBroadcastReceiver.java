package teamsb.mtglifeapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;

import java.nio.channels.Channel;

/**
 * Created by Adam on 4/11/2015.
 */
public class WiFiDirectBroadcastReceiver extends BroadcastReceiver {

    private WifiP2pManager mManager;
    private Channel mChannel;
    private Activity mActivity;

    public WiFiDirectBroadcastReceiver(WifiP2pManager mManager, Channel channel, Activity activity) {
        super();
        this.mManager = mManager;
        this.mChannel = channel;
        this.mActivity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action))
        {
            //See if WiFi is enabled and update activity
            int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
            if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED)
            {
                //Wifi P2p is enabled
            }
            else
            {
                //Wifi p2p is not enabled
                System.out.println("Wifi P2p is not Enabled");
            }
        }
        else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action))
        {
            //Call Wifip2p.requestPeers to get list of peers
        }
        else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action))
        {
            //Respond to new connection or disconnection
        }
        else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action))
        {
            //respond to this device's wifi state changing
        }

    }
}
