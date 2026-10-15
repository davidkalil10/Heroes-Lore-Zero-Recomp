/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import rpg.d;

public final class f
extends Canvas {
    public static az var_az_a;
    private static int var_int_a;
    private static int var_int_b;
    private static int var_int_c;
    private static int var_int_d;
    private static int e;
    private static int f;
    private static int g;
    private static Image var_javax_microedition_lcdui_Image_a;
    private static boolean var_boolean_c;
    private static int h;
    private static int i;
    private static int j;
    public static boolean var_boolean_a;
    private static byte var_byte_a;
    private static ea var_ea_a;
    private static boolean var_boolean_d;
    public static boolean var_boolean_b;
    private int k = 0;
    private int l = 0;
    private static byte[][] var_byte_arr_arr_a;

    public f() {
        this.setFullScreenMode(true);
        try {
            var_javax_microedition_lcdui_Image_a = Image.createImage((String)"/vpad.png");
        }
        catch (Exception exception) {}
        e = this.getWidth();
        g = super.getHeight();
        var_int_c = var_javax_microedition_lcdui_Image_a.getHeight();
        var_int_d = var_javax_microedition_lcdui_Image_a.getWidth();
        f = g - var_int_c;
        var_int_a = var_int_c / 3;
        var_int_b = var_int_d / 5;
    }

    protected final void paint(Graphics object) {
        if (var_boolean_a) {
            int n2 = e;
            int n3 = g;
            object.setColor(0);
            object.fillRect(0, 0, n2, f);
            object.setColor(0xFFFFFF);
            if (var_byte_a < 20) {
                object = new cm((Graphics)object);
                ac.a((cm)object, n2 >> 1, n3 >> 1, rpg.d.C, 0, 1);
            }
            byte by2 = var_byte_a;
            var_byte_a = (byte)(by2 + 1);
            if (by2 > 30) {
                var_byte_a = 0;
            }
            return;
        }
        if (cm.var_javax_microedition_lcdui_Image_a != null) {
            object.drawImage(cm.var_javax_microedition_lcdui_Image_a, 0, 0, 20);
            if (var_javax_microedition_lcdui_Image_a != null) {
                object.drawImage(var_javax_microedition_lcdui_Image_a, 0, f, 20);
            }
        }
    }

    protected final void keyPressed(int n2) {
        if (n2 == -12) {
            bq.i();
        }
        if (var_boolean_b) {
            return;
        }
        if (!ds.var_boolean_a) {
            return;
        }
        if (var_boolean_a) {
            if (this.isShown()) {
                var_boolean_a = false;
                bq.j();
                if (var_az_a != null) {
                    var_az_a.b();
                }
            }
            return;
        }
        h = n2;
    }

    protected final void keyReleased(int n2) {
        i = n2;
    }

    public static void a() {
        if (h != 0) {
            if (j != 0) {
                if (var_az_a != null) {
                    var_az_a.boolean_a(1, j);
                }
                j = 0;
            }
            j = h;
            if (var_az_a != null) {
                var_az_a.boolean_a(0, h);
            }
            h = 0;
        }
        if (i != 0) {
            if (j != 0) {
                if (var_az_a != null) {
                    var_az_a.boolean_a(1, j);
                }
                j = 0;
            }
            i = 0;
        }
    }

    protected final void showNotify() {
    }

    protected final void hideNotify() {
        if (!ds.var_boolean_a) {
            return;
        }
        var_boolean_a = true;
        bq.i();
        if (var_az_a != null) {
            var_az_a.boolean_a(1, j);
            j = 0;
            var_az_a.void_a();
        }
    }

    public static boolean a(az az2) {
        boolean bl2 = var_az_a == null;
        var_az_a = az2;
        return bl2;
    }

    public final int getWidth() {
        return 240;
    }

    public final int getHeight() {
        return f;
    }

    public final void sizeChanged(int n2, int n3) {
        var_boolean_b = n2 > n3;
        if (n2 > n3) {
            if (var_boolean_c && var_javax_microedition_lcdui_Image_a != null) {
                return;
            }
            var_boolean_c = true;
            return;
        }
        if (!var_boolean_c && var_javax_microedition_lcdui_Image_a != null) {
            return;
        }
        var_boolean_c = false;
    }

    public final void pointerPressed(int n2, int n3) {
        try {
            this.k = n2 / var_int_b;
            if (n3 > f) {
                this.l = (n3 - f) / var_int_a;
                this.keyPressed(var_byte_arr_arr_a[this.l][this.k]);
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void pointerReleased(int n2, int n3) {
        n3 = j;
        f f2 = this;
        i = n3;
    }

    static {
        var_az_a = null;
        var_javax_microedition_lcdui_Image_a = null;
        var_boolean_c = false;
        h = 0;
        i = 0;
        j = 0;
        var_boolean_a = false;
        var_byte_a = 0;
        var_ea_a = null;
        var_boolean_d = false;
        var_boolean_b = false;
        var_byte_arr_arr_a = new byte[][]{{-6, 49, 50, 51, -7}, {53, 52, 53, 54, 48}, {42, 55, 56, 57, 35}};
    }
}

