package gae.eu.bletester;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class LightActivity extends Activity implements LightUtils.OnLightListener {

    EditText red;
    EditText green;
    EditText blue;
    EditText warm;

    Switch onoff;
    Button color_command;
    Button warm_command;

    static LightUtils light_manager;
    boolean light_available=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        light_manager=LightUtils.getLightUtils();
        light_manager.setLightListener(this);

        setContentView(R.layout.activity_light);
        red=(EditText)findViewById(R.id.red);
        green=(EditText)findViewById(R.id.green);
        blue=(EditText)findViewById(R.id.blue);

        warm=(EditText)findViewById(R.id.warm);

        color_command=(Button)findViewById(R.id.command);
        color_command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!light_available){
                    Toast.makeText(getApplicationContext(), "You can't send commands,light is not available.", Toast.LENGTH_LONG).show();
                    return;
                }
                int red_val=0;
                int green_val=0;
                int blue_val=0;

                try{
                    red_val=Integer.parseInt( red.getText().toString() );
                    green_val=Integer.parseInt( green.getText().toString() );
                    blue_val=Integer.parseInt(blue.getText().toString());
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Please provide number in textfields", Toast.LENGTH_LONG).show();
                    return;
                }
                light_manager.sendRGBColorCommand(red_val,green_val,blue_val);
            }
        });

        warm_command=(Button)findViewById(R.id.warm_command);
        warm_command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!light_available){
                    Toast.makeText(getApplicationContext(), "You can't send commands,light is not available.", Toast.LENGTH_LONG).show();
                    return;
                }
                int w_val=0;
                try{ w_val=Integer.parseInt( warm.getText().toString() );}
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Please provide number in textfield", Toast.LENGTH_LONG).show();
                    return;
                }
                light_manager.sendWarmCommand(w_val);
            }
        });


        onoff=(Switch)findViewById(R.id.onoff);
        onoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!light_available){
                    Toast.makeText(getApplicationContext(), "You can't send commands,light is not available.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(isChecked) light_manager.sendTurnOnCommand();
                else light_manager.sendTurnOffCommand();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView monTexte = (TextView)findViewById(R.id.Message_de_test);
        monTexte.setText(LightCallOnReceiver.messageTest);
        startService(new Intent(this, LightService.class));
    }

    @Override
    public void onLightReady() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Now you can send commands to the light.", Toast.LENGTH_LONG).show();
                light_available=true;
            }
        });
           }
}
