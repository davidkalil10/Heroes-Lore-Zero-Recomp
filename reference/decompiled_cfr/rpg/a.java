/*
 * Decompiled with CFR 0.152.
 */
package rpg;

import rpg.c;
import rpg.d;
import rpg.e;

public abstract class a
extends az
implements Runnable,
d {
    public static int var_int_a;
    public static int var_int_b;
    public static int c;
    public static int d;
    public static int e;
    private static byte var_byte_b;
    public static boolean var_boolean_a;
    protected byte var_byte_a = (byte)-1;
    public static cm var_cm_a;
    public static int f;

    public abstract void void_a();

    public abstract void b();

    public a() {
        var_int_a = ct.var_javax_microedition_lcdui_Canvas_a.getWidth();
        var_int_b = ct.var_javax_microedition_lcdui_Canvas_a.getHeight();
        c = var_int_a >> 1;
        d = var_int_b >> 1;
    }

    public static void a(cm cm2) {
        cm2.b(0, 0, var_int_a, var_int_b);
    }

    public static void a(cm cm2, int n2) {
        cm2.b(0, 0, var_int_a, var_int_b);
        cm2.a(n2);
        cm2.a(0, 0, var_int_a, var_int_b);
    }

    public static void c() {
        if ((var_byte_b = (byte)(var_byte_b + 5)) < 0 || var_byte_b > 100) {
            var_byte_b = (byte)100;
        }
    }

    protected static void b(cm cm2) {
        int n2 = d;
        cm2.b(255);
        if (e == 3) {
            rpg.a.a(cm2, 0);
            cm2.a(14663551);
            ac.a(cm2, c - 48, n2 - 18, rpg.e.var_ch_b.a(1), 0);
            cm2.e(c - 50, n2, c + 48, n2);
            cm2.a(c - 51, n2 + 1, 2, 2);
            cm2.a(c + 48, n2 + 1, 2, 2);
            cm2.a(10452799);
            cm2.e(c - 50, n2 + 5, c + 48, n2 + 5);
            cm2.a(c - 51, n2 + 3, 2, 2);
            cm2.a(c + 48, n2 + 3, 2, 2);
        }
        if (e > 3) {
            cm2.b(0, 0, var_int_a, var_int_b);
            cm2.a(0);
            cm2.a(c + 25, n2 - 16, 18, 10);
            cm2.a(14663551);
            ac.a(cm2, c + 25, n2 - 16, "...".substring(0, 3).getBytes(), 1);
            cm2.a(14655295);
            cm2.a(c - 48, n2 + 2, 95 * var_byte_b / 100, 1);
            cm2.a(0xFFFF7F);
            cm2.a(c - 48, n2 + 3, 95 * var_byte_b / 100, 1);
        } else if (e < 3) {
            cm2.a(0);
            int n3 = (var_int_b + 11) / 12;
            for (int i2 = 0; i2 < n3; ++i2) {
                cm2.a(0, i2 * 12 + (e << 2), var_int_a, 4);
            }
        }
        e = e < 100 ? ++e : 4;
        cm2.a(0xFFFFFF);
        byte[] byArray = rpg.e.var_ch_a.a(15 + f);
        ac.a(cm2, 10, n2 + 10, var_int_a - 20, 0, byArray);
    }

    public static final void a(cm cm2, boolean bl2) {
        int n2;
        rpg.a.a(cm2, 10159117);
        cm2.a(0);
        cm2.a(0, 0, var_int_a, d);
        int n3 = rpg.e.var_cg_b.int_a();
        int n4 = rpg.e.var_cg_b.b();
        int n5 = var_int_a / n3 + 1;
        n4 = var_int_b - n4 >> 1;
        for (n2 = 0; n2 < n5; ++n2) {
            cm2.a(rpg.e.var_cg_b, n2 * n3, n4, 20);
        }
        if (bl2 && var_int_b >= 200) {
            n3 = rpg.e.var_cg_k.int_a();
            n4 = rpg.e.var_cg_k.b();
            n5 = var_int_a / n3 + 1;
            for (n2 = 0; n2 < n5; ++n2) {
                if (var_int_b > 240) {
                    cm2.a(rpg.e.var_cg_k, n2 * n3, 0, 20);
                    cm2.a(rpg.e.var_cg_c, n2 * n3, n4, 20);
                }
                cm2.a(rpg.e.var_cg_k, n2 * n3, var_int_b - n4, 20);
            }
        }
    }

    public static void c(cm cm2) {
        rpg.a.a(cm2, false);
        cm2.a(rpg.e.var_cg_e, c, d - d / 3, 3);
        cm2.a(0xFF0000);
    }

    protected static void a(boolean bl2) {
        if (bl2) {
            e = 3;
        } else {
            var_byte_b = 0;
            e = 3;
        }
        rpg.c.rpg_c_a().g();
    }
}

