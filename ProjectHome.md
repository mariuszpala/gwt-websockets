Simple GWT module for use of WebSocket connections in GWT projects.  This has been tested against 'jetty-distribution-7.0.1.v20091125', and also now against the jwebsocket project.

Add the following line to your modulename.gwt.xml file:

`<inherits name='com.sunshineapps.gwt.websockets.gwtwebsockets'/>`

Include the latest jar file from the downloads page.

The rest should be fairly straight forward, but I'll try put together a small demo application next.

I've tested the client code now with both latest builds of Chromium and Safari and it sems to work.