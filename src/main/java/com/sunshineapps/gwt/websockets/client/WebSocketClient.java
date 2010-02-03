/*
 *  Copyright (c)2010 Peter Bridge
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sunshineapps.gwt.websockets.client;

/**
 * Very simple approach to using a websocket from within gwt
 * @author Peter Bridge - 2010-01-02
 * @version $Id: $
 */
public class WebSocketClient {
    final WebSocketCallback callback;

    /**
     * @param callback - used for websocket callback
     */
    public WebSocketClient(WebSocketCallback callback) {
        this.callback = callback;
    }

    @SuppressWarnings("unused")
    private final void onopen() {
        callback.connected();
    }

    @SuppressWarnings("unused")
    private final void onclose() {
        callback.disconnected();
    }

    @SuppressWarnings("unused")
    private final void onmessage(String message) {
        callback.message(message);
    }

    public native void connect(String server) /*-{
        var that = this;
        if (!window.WebSocket) {
            alert("WebSocket connections not supported by this browser");
            return;
        }
        console.log("WebSocket connecting to "+server);
        that._ws=new WebSocket(server);
        console.log("WebSocket connected "+that._ws.readyState);

        that._ws.onopen = function() {
            if(!that._ws) {
                console.log("WebSocket not really opened?");
                console.log("WebSocket["+server+"]._ws.onopen()");
                return;
            }
             console.log("onopen, readyState: "+that._ws.readyState);
             that.@com.sunshineapps.gwt.websockets.client.WebSocketClient::onopen()();
             console.log("onopen done");
        };


        that._ws.onmessage = function(response) {
            console.log("WebSocket _onmessage() data="+response.data);
            if (response.data) {
                that.@com.sunshineapps.gwt.websockets.client.WebSocketClient::onmessage(Ljava/lang/String;)( response.data );
            }
        };

        that._ws.onclose = function(m) {
             console.log("WebSocket["+server+"]_ws.onclose() state:"+that._ws.readyState);
             that.@com.sunshineapps.gwt.websockets.client.WebSocketClient::onclose()();
        };
    }-*/;

    public native void send(String message) /*-{
        if (this._ws) {
            console.log("WebSocket sending:"+message);
            this._ws.send(message);
        } else {
            alert("not connected!" + this._ws);
        }
    }-*/;

    public native void close() /*-{
        console.log("WebSocket closing");
        this._ws.close();
        console.log("WebSocket closed");
    }-*/;

}
