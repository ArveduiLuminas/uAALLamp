package gae.eu.bletester;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ISEN on 12/05/2017.
 */

public class LightCallOffReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        LightActivity.light_manager.sendTurnOffCommand();
    }
}
