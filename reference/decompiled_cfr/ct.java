/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.midlet.MIDlet
 */
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import rpg.RPGHeroEx;

public final class ct {
    public static Display var_javax_microedition_lcdui_Display_a;
    private static ct var_ct_a;
    public static Canvas var_javax_microedition_lcdui_Canvas_a;

    private ct(Display display) {
        var_javax_microedition_lcdui_Display_a = display;
    }

    public static int a(int n2) {
        if (var_javax_microedition_lcdui_Canvas_a != null) {
            return var_javax_microedition_lcdui_Canvas_a.getGameAction(n2);
        }
        return n2;
    }

    public static void a(az az2) {
        if (f.a(az2)) {
            var_javax_microedition_lcdui_Display_a.setCurrent((Displayable)var_javax_microedition_lcdui_Canvas_a);
        }
    }

    public static ct a() {
        if (var_ct_a == null) {
            var_ct_a = new ct(Display.getDisplay((MIDlet)RPGHeroEx.a));
            var_javax_microedition_lcdui_Canvas_a = new f();
        }
        return var_ct_a;
    }

    static {
        var_javax_microedition_lcdui_Display_a = null;
        var_ct_a = null;
        var_javax_microedition_lcdui_Canvas_a = null;
    }
}

