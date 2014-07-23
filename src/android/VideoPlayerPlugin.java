package com.sition.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class VideoPlayerPlugin extends CordovaPlugin{

    @Override
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if(action.equals("play")){
            webView.loadUrl("javascript:$('#mainVid')[0].play()");
        }
        return super.execute(action, args, callbackContext);
    }
}
