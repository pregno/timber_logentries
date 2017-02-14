package timber.log.timberlogentriessample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import timber.log.Timber;
import timber.log.logentries.TimberLogentries;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
