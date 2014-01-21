tyrus-client-android-test
=========================

Test project used to debug [Tyrus](https://tyrus.java.net) Client runtime on Android

You might notice that I'm not an expert in creating Android apps :) so please do not take this code seriously, there might be some bug or some Android runtime environment rule that was not respected. Main purpose was just to test whether Tyrus client can run on Android or not.

How to run
----------

Import the project in your favourite IDE and run. I used Android API 18 Platform and JDK 1.7 u51. The application is working on my phone (HTC ONE) and I did not do any extensive testing.

You have to add Tyrus runtime on classpath and include it to built application. Tyrus provides useful bundle: [tyrus-standalone-client](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22tyrus-standalone-client%22). Please note that you need version 1.5-SNAPSHOT and newer. Version 1.5 is not released yet (Jan 2014), so you need to use 1.5-SNAPSHOT from [java.net snapshot repository](https://maven.java.net/content/repositories/snapshots/org/glassfish/tyrus/bundles/tyrus-standalone-client/).

The application itself is just one Activity called MyActivity which contains one huge button. When "clicked", Tyrus Client will try to connect to "ws://echo.websocket.org" and send message. You can see the result in the Android console (tag "TYRUS-TEST").

I have to admit I don't know how to run this just from command line, so sorry for not sharing that information with you. Also you might need to modify file "local.properties" which contains path to installed JDK (it might be regenerated during project import).

Links
-----

-   [Tyrus](https://tyrus.java.net)
-   [TYRUS-256](https://java.net/jira/browse/TYRUS-256)
-   [My Blog](https://blogs.oracle.com/PavelBucek/)



