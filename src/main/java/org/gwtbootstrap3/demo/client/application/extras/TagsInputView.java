package org.gwtbootstrap3.demo.client.application.extras;

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.extras.tagsinput.client.ui.TagsInput;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2016 GwtBootstrap3
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

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * @author Marko Nikolić <marko.nikolic@iten.rs>
 */
public class TagsInputView extends ViewImpl implements TagsInputPresenter.MyView {

    interface Binder extends UiBinder<Widget, TagsInputView> {
    }

    @UiField TagsInput markupTagsInput;
    @UiField TagsInput typeaheadTagsInput;
    
    @Inject
    public TagsInputView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        createMarkupTagsInput();
        createTypeaheadTagsInput();
    }

    private void createMarkupTagsInput() {
        List<String> tags = new ArrayList<String>();
        
        tags.add("Amsterdam");
        tags.add("Washington");
        tags.add("Sydney");
        tags.add("Beijing");
        tags.add("Cairo");
        
        for(String tag : tags) {
            markupTagsInput.add(tag);
        }
    }

    private void createTypeaheadTagsInput() {
        List<String> suggestions = new ArrayList<String>();
        
        suggestions.add("Amsterdam");
        suggestions.add("London");
        suggestions.add("Paris");
        suggestions.add("Washington");
        suggestions.add("New York");
        suggestions.add("Los Angeles");
        suggestions.add("Sydney");
        suggestions.add("Melbourne");
        suggestions.add("Canberra");
        suggestions.add("Beijing");
        suggestions.add("New Delhi");
        suggestions.add("Kathmandu");
        suggestions.add("Cairo");
        suggestions.add("Cape Town");
        suggestions.add("Kinshasa");
        
        typeaheadTagsInput.setTypeahead(suggestions);
    }
}
