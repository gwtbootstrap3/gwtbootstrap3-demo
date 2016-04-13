package org.gwtbootstrap3.demo.client.application.extras;

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

import java.util.ArrayList;
import java.util.List;

import org.gwtbootstrap3.extras.tagsinput.client.callback.ItemTextCallback;
import org.gwtbootstrap3.extras.tagsinput.client.callback.ItemValueCallback;
import org.gwtbootstrap3.extras.tagsinput.client.callback.TagClassCallback;
import org.gwtbootstrap3.extras.tagsinput.client.ui.MVTagsInput;
import org.gwtbootstrap3.extras.tagsinput.client.ui.TagsInput;
import org.gwtbootstrap3.extras.tagsinput.client.ui.base.SingleValueTagsInput;
import org.gwtbootstrap3.extras.typeahead.client.base.CollectionDataset;
import org.gwtbootstrap3.extras.typeahead.client.base.StringDataset;
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
    @UiField MVTagsInput multiValueTagsInput;
    @UiField TagsInput typeaheadTagsInput;
    
    class Item {
        
        private String text;
        private Integer value;
        
        public Item(String text, Integer value) {
            setText(text);
            setValue(value);
        }
        
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public Integer getValue() {
            return value;
        }
        public void setValue(Integer value) {
            this.value = value;
        }
    }
    
    @UiField SingleValueTagsInput<Item> joTagsInput;
    
    @UiField TagsInput categoryTagsInput;
    
    @Inject
    public TagsInputView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        
        createMarkupTagsInput();
        createMultiValueTagsInput();
        createTypeaheadTagsInput();
        createJOTagsInput();
        createCategoryTagsInput();
    }

    private void createMarkupTagsInput() {
        List<String> tags = new ArrayList<String>();
        
        tags.add("Sydney");
        tags.add("Beijing");
        tags.add("Cairo");
        
        for(String tag : tags) {
            markupTagsInput.add(tag);
        }
    }

    private void createMultiValueTagsInput() {
        List<String> tags = new ArrayList<String>();
        
        tags.add("Sydney");
        tags.add("Beijing");
        tags.add("Cairo");
        
        multiValueTagsInput.add(tags);
    }
    
    private void createTypeaheadTagsInput() {
        List<String> suggestions = new ArrayList<String>();
        
        suggestions.add("Belgrade");
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
        
        StringDataset dataset = new StringDataset(suggestions);
        
        typeaheadTagsInput.setDatasets(dataset);
        typeaheadTagsInput.reconfigure();
    }

    private void createJOTagsInput() {        
        final ItemValueCallback<Item> cbValue = new ItemValueCallback<Item>() {
            @Override
            public String getItemValue(Item item) {
                return item.getValue().toString();
            }
        };
        
        final ItemTextCallback<Item> cbText = new ItemTextCallback<Item>() {
            @Override
            public String getItemText(Item item) {
                return item.getText();
            }
        };
        
        joTagsInput.setItemValue(cbValue);
        joTagsInput.setItemText(cbText);
        joTagsInput.reconfigure();

        // Add tags
        List<Item> tags = new ArrayList<Item>();
        tags.add(new Item("Belgrade", 1));
        tags.add(new Item("Amsterdam", 1));
        tags.add(new Item("London", 2));
        joTagsInput.add(tags);
        
        // Create suggestions
        List<Item> suggestions = new ArrayList<Item>();
        suggestions.add(new Item("Belgrade", 4));
        suggestions.add(new Item("Athens", 5));
        CollectionDataset<Item> dataset = new CollectionDataset<Item>(suggestions) {
            @Override
            public String getValue(Item datum) {
                return datum != null ? datum.getText() : "";
            }
        };
        joTagsInput.setDatasets(dataset);
    }

    private void createCategoryTagsInput() {
        categoryTagsInput.setTagClass(new TagClassCallback<String>() {
            @Override
            public String getTagClass(String item) {
                switch(item) {
                case "Belgrade":   return "label label-primary";
                case "Amsterdam":  return "label label-danger label-important";
                case "Washington": return "label label-success";
                case "Sydney":     return "label label-default";
                case "Beijing":    return "label label-warning";
                case "Cairo":      return "label label-info";
                default:           return "label label-info";
                }
            }
        });
        categoryTagsInput.reconfigure();
        
        List<String> tags = new ArrayList<String>();
        
        tags.add("Sydney");
        tags.add("Beijing");
        tags.add("Cairo");
        
        for(String tag : tags) {
            categoryTagsInput.add(tag);
        }
    }
}
