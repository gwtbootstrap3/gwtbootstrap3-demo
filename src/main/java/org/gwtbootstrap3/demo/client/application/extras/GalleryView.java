package org.gwtbootstrap3.demo.client.application.extras;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2014 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.extras.gallery.client.ui.Gallery;

/**
 * @author Ben Dol
 */
public class GalleryView extends ViewImpl implements GalleryPresenter.MyView {

    interface Binder extends UiBinder<Widget, GalleryView> {
    }

    @UiField Gallery gallery;
    @UiField Gallery galleryWithControls;

    @Inject
    GalleryView(final Binder uiBinder) {
      initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler({"delete1", "delete2", "delete3", "delete4", "delete5", "delete6"})
    protected void deleteFirstClick(ClickEvent event) {
        Element element = Element.as(event.getNativeEvent().getEventTarget());
        Element item = element.getParentElement();
        if(item != null) {
            item.getParentElement().removeFromParent();
        }
    }
}