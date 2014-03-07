tyrus-client-android-test
=========================

Test project used to debug [Tyrus](https://tyrus.java.net) Client runtime on Android

You might notice that I'm not an expert in creating Android apps :) so please do not take this code seriously, there might be some bug or some Android runtime environment rule that was not respected. Main purpose was just to test whether Tyrus client can run on Android or not.

How to run
----------

1. Install Android components.

  ```
  $ android update sdk --no-ui --force --all --filter build-tools-19.0.3
  $ android update sdk --no-ui --force --all --filter android-19
  ```

2. Build and install application.

  ```
  $ gradle clean installDebug
  ```

The application itself is just one `Activity` called `MyActivity` which contains one huge button. When clicked, Tyrus Client will try to connect to `ws://echo.websocket.org` and send message. You can see the result in the Android console (tag `TYRUS-TEST`).

Links
-----

-   [Tyrus](https://tyrus.java.net)
-   [TYRUS-256](https://java.net/jira/browse/TYRUS-256)
-   [My Blog](https://blogs.oracle.com/PavelBucek/)
