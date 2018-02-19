package com.reactlibrary;

import android.app.KeyguardManager;
import android.content.Context;
import android.app.Activity;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;

import com.facebook.react.modules.core.DeviceEventManagerModule;

public class RNLockStateModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

  private ReactApplicationContext mReactContext;
  private Activity mCurrentActivity;

  public RNLockStateModule(ReactApplicationContext reactContext,  Activity activity) {
    super(reactContext);
    mCurrentActivity = activity;
    mReactContext = reactContext;
    mReactContext.addLifecycleEventListener(this);
  }

  @Override
  public String getName() {
    return "RNLockState";
  }

  @Override
  public void onHostPause() {
    KeyguardManager myKM = (KeyguardManager) mReactContext.getSystemService(Context.KEYGUARD_SERVICE);

    if(myKM.inKeyguardRestrictedInputMode()) {
      getReactApplicationContext()
        .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
        .emit("locked", null);
    }
  }

  @Override
  public void onHostResume() {
    getReactApplicationContext()
      .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
      .emit("unlocked", null);
  }

  @Override
  public void onHostDestroy() {
      // Activity `onDestroy`
  }
}
