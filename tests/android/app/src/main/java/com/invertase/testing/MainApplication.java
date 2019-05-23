package com.invertase.testing;

import android.app.Application;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.devsupport.DevInternalSettings;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import io.invertase.firebase.app.ReactNativeFirebaseApp;
import io.invertase.firebase.app.ReactNativeFirebaseAppPackage;
import io.invertase.firebase.auth.ReactNativeFirebaseAuthPackage;
import io.invertase.firebase.database.ReactNativeFirebaseDatabasePackage;
import io.invertase.jet.JetPackage;

import java.util.Arrays;
import java.util.List;

//import io.invertase.firebase.analytics.ReactNativeFirebaseAnalyticsPackage;
//import io.invertase.firebase.config.ReactNativeFirebaseConfigPackage;
//import io.invertase.firebase.crashlytics.ReactNativeFirebaseCrashlyticsPackage;
//import io.invertase.firebase.fiam.ReactNativeFirebaseFiamPackage;
//import io.invertase.firebase.functions.ReactNativeFirebaseFunctionsPackage;
//import io.invertase.firebase.iid.ReactNativeFirebaseIidPackage;
//import io.invertase.firebase.invites.ReactNativeFirebaseInvitesPackage;
//import io.invertase.firebase.ml.naturallanguage.ReactNativeFirebaseMLNaturalLanguagePackage;
//import io.invertase.firebase.perf.ReactNativeFirebasePerfPackage;
//import io.invertase.firebase.storage.ReactNativeFirebaseStoragePackage;
//import io.invertase.firebase.utils.ReactNativeFirebaseUtilsPackage;

public class MainApplication extends Application implements ReactApplication {
  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.asList(
        new MainReactPackage(),
        new JetPackage(),
        new ReactNativeFirebaseAppPackage(),
        new ReactNativeFirebaseAuthPackage(),
        new ReactNativeFirebaseDatabasePackage()
//        new ReactNativeFirebaseAnalyticsPackage(),
//        new ReactNativeFirebaseInvitesPackage(),
//        new ReactNativeFirebaseCrashlyticsPackage(),
//        new ReactNativeFirebaseConfigPackage(),
//        new ReactNativeFirebaseMLNaturalLanguagePackage(),
//        new ReactNativeFirebaseStoragePackage(),
//        new ReactNativeFirebaseFunctionsPackage(),
//        new ReactNativeFirebaseFiamPackage(),
//        new ReactNativeFirebaseIidPackage(),
//        new ReactNativeFirebasePerfPackage(),
//        new ReactNativeFirebaseUtilsPackage()
      );
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    ReactNativeFirebaseApp.initializeSecondaryApp("secondaryFromNative", getApplicationContext());

    // TODO move to jet
    DevInternalSettings settings = (DevInternalSettings) getReactNativeHost()
      .getReactInstanceManager()
      .getDevSupportManager()
      .getDevSettings();

    if (settings != null) {
      settings.setBundleDeltasEnabled(false);
    }

    SoLoader.init(this, false);
  }
}
