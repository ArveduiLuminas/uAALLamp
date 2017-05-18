package gae.eu.bletester;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ISEN on 12/05/2017.
 */

public class LightCallOnReceiver extends BroadcastReceiver {
    static public String messageTest = "rien";
    @Override
    public void onReceive(Context context, Intent intent) {
        messageTest = "Reçu et démarré";
        LightActivity.light_manager.sendTurnOnCommand();
    }
}
