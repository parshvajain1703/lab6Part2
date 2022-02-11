package com.example.lab6_services_intent;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class DemoService extends IntentService {

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_DEMO = "com.example.lab6_services_intent.action.FOO";
    private static final String GOODBYE_MESSAGE = "com.example.lab6_services_intent.action.BAZ";

    // TODO: Rename parameters
    private String goodbyeMessage = "com.example.lab6_services_intent.extra.PARAM1";
    //private static final String EXTRA_PARAM2 = "com.example.lab6_services_intent.extra.PARAM2";

    public DemoService() {
        super("DemoService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionDemo(Context context, String goodbyeMessage) {
        Intent intent = new Intent(context, DemoService.class);
        intent.setAction(ACTION_DEMO);
        intent.putExtra(GOODBYE_MESSAGE, goodbyeMessage);
        //intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService

    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, DemoService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }
    */
    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (action.equals(ACTION_DEMO)) {
                this.goodbyeMessage = intent.getStringExtra(GOODBYE_MESSAGE);
                handleActionDemo(goodbyeMessage);
            } else {
                //
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onDestroy() {
        Toast.makeText(DemoService.this, goodbyeMessage, Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    private void handleActionDemo(String goodbyeMessage) {
        Toast.makeText(DemoService.this, "Service started", Toast.LENGTH_SHORT).show();

        synchronized (this) {
            try {
                wait(10000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stopSelf();
    }
}