
package com.reactlibrary;

import android.app.KeyguardManager;
import android.content.Context;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Callback;

public class RNLockStateModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNLockStateModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNLockState";
  }
}
