package timber.log.timberlogentriessample;

import android.app.Application;

import java.io.IOException;

import timber.log.Timber;
import timber.log.logentries.TimberLogentries;

public class SampleApplication extends Application {

    private static final String LOGENTRIES_TOKEN = "";

    @Override public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            try {
                Timber.plant(new TimberLogentries(this, LOGENTRIES_TOKEN));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

