package org.gwtbootstrap3.demo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * @author Sven Jacobs
 */
interface GwtBootstrap3DemoClientBundle extends ClientBundle {

    static final GwtBootstrap3DemoClientBundle INSTANCE = GWT.create(GwtBootstrap3DemoClientBundle.class);

    @Source("resource/js/prettify.js")
    TextResource prettiy();
}
