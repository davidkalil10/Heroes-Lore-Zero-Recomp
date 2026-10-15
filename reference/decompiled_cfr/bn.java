/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Font
 */
import javax.microedition.lcdui.Font;

public final class bn {
    private Font var_javax_microedition_lcdui_Font_a = null;
    private static final bn var_bn_a;

    private bn(Font font) {
        this.var_javax_microedition_lcdui_Font_a = font;
    }

    public static bn a() {
        return var_bn_a;
    }

    public final int a(String string, int n2, int n3) {
        return this.var_javax_microedition_lcdui_Font_a.substringWidth(string, 0, n3);
    }

    static {
        var_bn_a = new bn(Font.getDefaultFont());
    }
}

