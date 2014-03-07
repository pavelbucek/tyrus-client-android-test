package com.example.AndroidClientTest;

import java.io.IOException;
import java.net.URI;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final Button button = (Button) findViewById(R.id.myButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("TYRUS-TEST", "### 0 Button.onClick");

                final AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        try {
                            final ClientManager client = ClientManager.createClient();

                            Log.i("TYRUS-TEST", "### 1 AsyncTask.doInBackground");
                            client.connectToServer(new Endpoint() {
                                @Override
                                public void onOpen(Session session, EndpointConfig EndpointConfig) {

                                    try {
                                        session.addMessageHandler(new MessageHandler.Whole<String>() {
                                            @Override
                                            public void onMessage(String message) {
                                                Log.i("TYRUS-TEST", "### 3 Tyrus Client onMessage: " + message);
                                            }
                                        });

                                        Log.i("TYRUS-TEST", "### 2 Tyrus Client onOpen");
                                        session.getBasicRemote().sendText("Do or do not, there is no try.");
                                    } catch (IOException e) {
                                        // do nothing
                                    }
                                }
                            }, ClientEndpointConfig.Builder.create().build(), URI.create("ws://echo.websocket.org"));

                        } catch (DeploymentException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                };

                asyncTask.execute();
            }
        });
    }
}
