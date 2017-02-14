package timber.log.logentries;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import timber.log.Timber;

public class TimberLogentries extends Timber.Tree {

    private AsyncLoggingWorker loggingWorker;

    public TimberLogentries(Context context, String token) throws IOException {
        loggingWorker = new AsyncLoggingWorker(context, token, null);
    }

    public TimberLogentries(Context context, String token, AsyncLoggingWorker.Config config) throws IOException {
        loggingWorker = new AsyncLoggingWorker(context, token, config);
    }

    @Override protected void log(int priority, String tag, String message, Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return;
        }
        loggingWorker.addLineToQueue(message);
    }
}
