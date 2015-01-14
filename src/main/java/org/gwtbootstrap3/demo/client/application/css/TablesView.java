package org.gwtbootstrap3.demo.client.application.css;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 GwtBootstrap3
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

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.AbstractCellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.RangeChangeEvent;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import org.gwtbootstrap3.client.ui.Pagination;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.gwt.ButtonCell;
import org.gwtbootstrap3.client.ui.gwt.CellTable;
import org.gwtbootstrap3.client.ui.gwt.DataGrid;
import org.gwtbootstrap3.demo.client.pojo.TableTestPojo;

/**
 * @author Joshua Godi
 */
public class TablesView extends ViewImpl implements TablesPresenter.MyView {
    @UiField(provided = true)
    DataGrid<TableTestPojo> dataGrid = new DataGrid<TableTestPojo>(10);
    @UiField
    Pagination dataGridPagination;
    @UiField(provided = true)
    CellTable<TableTestPojo> cellTable = new CellTable<TableTestPojo>(10);
    @UiField
    Pagination cellTablePagination;

    interface Binder extends UiBinder<Widget, TablesView> {
    }

    private SimplePager dataGridPager = new SimplePager();
    private SimplePager cellTablePager = new SimplePager();
    private ListDataProvider<TableTestPojo> dataGridProvider = new ListDataProvider<TableTestPojo>();
    private ListDataProvider<TableTestPojo> cellTableProvider = new ListDataProvider<TableTestPojo>();

    @Inject
    TablesView(final Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        initTable(dataGrid, dataGridPager, dataGridPagination, dataGridProvider);
        initTable(cellTable, cellTablePager, cellTablePagination, cellTableProvider);
        initMockData(dataGridPagination, dataGridPager, dataGridProvider);
        initMockData(cellTablePagination, cellTablePager, cellTableProvider);
    }

    private void initMockData(final Pagination pagination, final SimplePager simplePager, final ListDataProvider<TableTestPojo> dataProvider) {
        for (int i = 0; i < 25; i++) {
            dataProvider.getList().add(new TableTestPojo("Test " + i, "Test " + i, "Test " + i));
        }
        dataProvider.flush();
        pagination.rebuild(simplePager);
    }

    private void initTable(final AbstractCellTable<TableTestPojo> grid, final SimplePager pager, final Pagination pagination, final ListDataProvider<TableTestPojo> dataProvider) {
        final TextColumn<TableTestPojo> col1 = new TextColumn<TableTestPojo>() {

            @Override
            public String getValue(final TableTestPojo object) {
                return String.valueOf(object.getField1());
            }
        };
        grid.addColumn(col1, "Field 1");

        final TextColumn<TableTestPojo> col2 = new TextColumn<TableTestPojo>() {

            @Override
            public String getValue(final TableTestPojo object) {
                return String.valueOf(object.getField1());
            }
        };
        grid.addColumn(col2, "Field 2");

        final TextColumn<TableTestPojo> col3 = new TextColumn<TableTestPojo>() {

            @Override
            public String getValue(final TableTestPojo object) {
                return String.valueOf(object.getField1());
            }
        };
        grid.addColumn(col3, "Field 3");

        final Column<TableTestPojo, String> col4 = new Column<TableTestPojo, String>(new ButtonCell(ButtonType.PRIMARY, IconType.GITHUB)) {
            @Override
            public String getValue(TableTestPojo object) {
                return "Click Me";
            }
        };
        col4.setFieldUpdater(new FieldUpdater<TableTestPojo, String>() {
            @Override
            public void update(int index, TableTestPojo object, String value) {
                Window.alert("Clicked!");
            }
        });
        grid.addColumn(col4, "Buttons");

        grid.addRangeChangeHandler(new RangeChangeEvent.Handler() {

            @Override
            public void onRangeChange(final RangeChangeEvent event) {
                pagination.rebuild(pager);
            }
        });

        pager.setDisplay(grid);
        pagination.clear();
        dataProvider.addDataDisplay(grid);
    }
}
