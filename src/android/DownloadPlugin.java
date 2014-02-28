package com.sition.plugins;

import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Richard
 * Date: 28-2-14
 * Time: 9:13
 * To change this template use File | Settings | File Templates.
 */
public class DownloadPlugin extends CordovaPlugin {

    protected String DOWNLOADACTION = "download";

    @Override
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        Log.d("action", action);
        if (DOWNLOADACTION.equals(action)) {
            cordova.getThreadPool().execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = new URL(args.getString(0));
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                        connection.connect();

                        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                            callbackContext.error("exited with "+connection.getResponseCode()+" "+connection.getResponseMessage());
                        }

                        int filelength = connection.getContentLength();

                        InputStream ips = connection.getInputStream();
                        String uri = (String) args.getString(0);
                        String filename = uri.substring(uri.lastIndexOf("/") + 1);
                        OutputStream ops = new FileOutputStream("/sdcard/adplayer/tmp/" + filename);

                        byte data[] = new byte[4096];
                        long total = 0;
                        int count;
                        while ((count = ips.read(data)) != -1) {
                            total += count;
                            if (filelength > 0) {
                                ops.write(data, 0, count);
                            }
                        }
                        callbackContext.success();
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        callbackContext.error(e.getLocalizedMessage());
                        return;

                    } catch (JSONException e) {
                        callbackContext.error(e.getLocalizedMessage());
                        return;
                    }
                }
            });
            return true;
        }
        else{
            return false;
        }
    }
}
