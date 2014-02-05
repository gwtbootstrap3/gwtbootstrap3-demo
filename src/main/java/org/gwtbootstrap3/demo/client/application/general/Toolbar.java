package org.gwtbootstrap3.demo.client.application.general;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * @author godi
 */
public class Toolbar {
    private static final String STYLE = "style";
    private static final String FONT_SIZE = "fontsize";
    private static final String COLOR = "color";
    private static final String PARA = "para";
    private static final String HEIGHT = "height";
    private static final String INSERT = "insert";
    private static final String TABLE = "table";
    private static final String HELP = "help";
    private static final String BOLD = "bold";
    private static final String ITALIC = "italic";
    private static final String UNDERLINE = "underline";
    private static final String CLEAR = "clear";
    private static final String UL = "ul";
    private static final String OL = "ol";
    private static final String PARAGRAPH = "paragraph";
    private static final String PICTURE = "picture";
    private static final String LINK = "link";

    private boolean showStyleButton;
    private boolean showBoldButton;
    private boolean showItalicButton;
    private boolean showUnderlineButton;
    private boolean showClearButton;
    private boolean showFontSizeButton;
    private boolean showColorButton;
    private boolean showUnorderedListButton;
    private boolean showOrderedListButton;
    private boolean showParagraphButton;
    private boolean showLineHeightButton;
    private boolean showInsertPictureButton;
    private boolean showInsertLinkButton;
    private boolean showInsertTableButton;
    private boolean showHelpButton;

    public Toolbar setShowStyleButton(boolean showStyleButton) {
        this.showStyleButton = showStyleButton;
        return this;
    }

    public Toolbar setShowBoldButton(boolean showBoldButton) {
        this.showBoldButton = showBoldButton;
        return this;
    }

    public Toolbar setShowItalicButton(boolean showItalicButton) {
        this.showItalicButton = showItalicButton;
        return this;
    }

    public Toolbar setShowUnderlineButton(boolean showUnderlineButton) {
        this.showUnderlineButton = showUnderlineButton;
        return this;
    }

    public Toolbar setShowClearButton(boolean showClearButton) {
        this.showClearButton = showClearButton;
        return this;
    }

    public Toolbar setShowFontSizeButton(boolean showFontSizeButton) {
        this.showFontSizeButton = showFontSizeButton;
        return this;
    }

    public Toolbar setShowColorButton(boolean showColorButton) {
        this.showColorButton = showColorButton;
        return this;
    }

    public Toolbar setShowUnorderedListButton(boolean showUnorderedListButton) {
        this.showUnorderedListButton = showUnorderedListButton;
        return this;
    }

    public Toolbar setShowOrderedListButton(boolean showOrderedListButton) {
        this.showOrderedListButton = showOrderedListButton;
        return this;
    }

    public Toolbar setShowParagraphButton(boolean showParagraphButton) {
        this.showParagraphButton = showParagraphButton;
        return this;
    }

    public Toolbar setShowLineHeightButton(boolean showLineHeightButton) {
        this.showLineHeightButton = showLineHeightButton;
        return this;
    }

    public Toolbar setShowInsertPictureButton(boolean showInsertPictureButton) {
        this.showInsertPictureButton = showInsertPictureButton;
        return this;
    }

    public Toolbar setShowInsertLinkButton(boolean showInsertLinkButton) {
        this.showInsertLinkButton = showInsertLinkButton;
        return this;
    }

    public Toolbar setShowInsertTableButton(boolean showInsertTableButton) {
        this.showInsertTableButton = showInsertTableButton;
        return this;
    }

    public Toolbar setShowHelpButton(boolean showHelpButton) {
        this.showHelpButton = showHelpButton;
        return this;
    }

    public JavaScriptObject build() {
        JsArray array = JavaScriptObject.createArray().cast();

        buildStyle(array);
        buildStyles(array);
//        buildFontSize(array);
//        buildColor(array);
//        buildPara(array);
//        buildHeight(array);
//        buildInsert(array);
//        buildTable(array);
//        buildHelp(array);

        return array;
    }

    private void buildStyles(JsArray array) {
        JavaScriptObject styles = JavaScriptObject.createArray().cast();

        if (showBoldButton) {
            pushToValueArray(styles, BOLD);
        }

        if (showItalicButton) {
            pushToValueArray(styles, ITALIC);
        }

        if (showUnderlineButton) {
            pushToValueArray(styles, UNDERLINE);
        }

        if (showClearButton) {
            pushToValueArray(styles, CLEAR);
        }

        if (!styles.toString().isEmpty()) {
            array.push(toJSArray(STYLE, styles));
        }
    }

    private void buildStyle(JsArray array) {
        if (showStyleButton) {
            array.push(toJSArray(STYLE, toValueArray(STYLE)));
        }
    }

    private native JavaScriptObject toJSArray(String key, JavaScriptObject value)/*-{
        return [key, value];
    }-*/;

    private native JavaScriptObject toValueArray(String value1)/*-{
        return [value1];
    }-*/;

    private native void pushToValueArray(JavaScriptObject object, String value)/*-{
        object.push(value);
    }-*/;
}
