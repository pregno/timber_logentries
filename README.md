# Timber Logentries

This is a timber extension for send logs to [logentries](http://www.logentries.com) platform.

It's a basic porting of the [logentries android library](https://github.com/LogentriesCommunity/le_android) for using it with Timber.

## Usage

First of all, please refer to [Timber](https://github.com/JakeWharton/timber) project on how to use it.

For using TimberLogentries you should plant the TimberLogentries class.

```
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
```

## Download

Maven is coming soon.
For now just clone, fork or download this project

## Known Issues

For now the http `POST` is not supported. I plan to introduce OkHttp for making `POST` request

## License

```
Copyright 2013 Andrea Pregnolato

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
