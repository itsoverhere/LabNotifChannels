package edu.mobapde.labnotifchannels;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvHello;
    public static final String CHANNEL_ID = "edu.mobapde.labnotifchannels.MainActivity";
    public static final String CHANNEL_NAME = "NotifChannels";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = (TextView) findViewById(R.id.tv_hello);

        tvHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager
                        = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);

                Notification.Builder builder = new Notification.Builder(getBaseContext(), CHANNEL_ID)
                        .setContentTitle("Title")
                        .setContentText("Text")
                        .setSmallIcon(R.mipmap.ic_launcher);

                NotificationChannel channel
                        = new NotificationChannel(CHANNEL_ID,
                        CHANNEL_NAME,
                        NotificationManager.IMPORTANCE_DEFAULT);

                channel.enableLights(true);
                channel.enableVibration(true);
                channel.setLightColor(Color.GRAY);

                notificationManager.createNotificationChannel(channel);

                notificationManager.notify(1, builder.build());
            }
        });
    }
}
