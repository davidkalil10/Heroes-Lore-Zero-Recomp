/*
 * Decompiled with CFR 0.152.
 */
package rpg;

import rpg.RPGHeroEx;
import rpg.a;
import rpg.b;
import rpg.e;
import rpg.g;

public final class c
implements Runnable {
    private static final byte[] var_byte_arr_a;
    private static c var_rpg_c_a;
    private ct var_ct_a = ct.a();
    private a var_rpg_a_a;
    public static byte var_byte_a;
    public static byte var_byte_b;
    public static byte var_byte_c;
    public static boolean var_boolean_a;
    private static byte var_byte_e;
    public static boolean var_boolean_b;
    public static boolean var_boolean_c;
    private static boolean g;
    public static byte var_byte_d;
    private static long var_long_a;
    public static boolean var_boolean_d;
    private static int var_int_a;
    private static int var_int_b;
    private static long var_long_b;
    public static boolean var_boolean_e;
    public static ds var_ds_a;
    public static boolean f;

    c() {
        new ar();
        var_int_a = var_byte_arr_a[var_byte_b];
        c c2 = this;
        rpg.c.a(var_int_a);
    }

    public static c rpg_c_a() {
        return var_rpg_c_a;
    }

    public final synchronized void void_a() {
        var_boolean_e = true;
        bq.b();
        c.a(true);
        if (this.var_rpg_a_a != null) {
            this.var_rpg_a_a.void_a();
        }
    }

    public final synchronized void b() {
        if (var_boolean_e) {
            var_boolean_e = false;
        }
        if (this.var_rpg_a_a != null) {
            this.var_rpg_a_a.b();
        }
    }

    public final void c() {
        rpg.e.e();
        this.var_rpg_a_a = bv.bv_a();
        bv.bv_a().a((byte)1);
        ct.a(this.var_rpg_a_a);
        new Thread(this).start();
        if (var_ds_a == null) {
            var_ds_a = new ds(RPGHeroEx.a);
        }
    }

    public final void d() {
        this.var_rpg_a_a = bs.bs_a();
        di.void_b();
        ct.a(this.var_rpg_a_a);
        bv.d();
    }

    public final void run() {
        if (!f) {
            f = true;
            while (f) {
                Exception exception;
                try {
                    if (f.var_boolean_a || f.var_boolean_b) {
                        ct.var_javax_microedition_lcdui_Canvas_a.repaint();
                        try {
                            Thread.sleep(50L);
                        }
                        catch (InterruptedException interruptedException) {
                            exception = interruptedException;
                            interruptedException.printStackTrace();
                        }
                        continue;
                    }
                    f.a();
                    long l2 = System.currentTimeMillis() - var_long_b;
                    if (l2 < (long)var_int_b) {
                        try {
                            Thread.sleep((long)var_int_b - l2);
                        }
                        catch (InterruptedException interruptedException) {}
                    } else {
                        Thread.sleep(10L);
                    }
                    if (do.var_boolean_c) {
                        do.var_long_a -= System.currentTimeMillis() - var_long_b;
                        do.var_boolean_c = false;
                    }
                    var_long_b = System.currentTimeMillis();
                    if (var_boolean_e) continue;
                    if (!di.var_boolean_f) {
                        bq.a();
                    }
                    this.var_rpg_a_a.void_a(rpg.a.var_int_a, rpg.a.var_int_b);
                }
                catch (Exception exception2) {
                    exception = exception2;
                    exception2.printStackTrace();
                }
            }
        }
    }

    public static void e() {
        long l2 = System.currentTimeMillis() - var_long_b;
        if (l2 < (long)var_int_b) {
            try {
                Thread.sleep((long)var_int_b - l2);
                return;
            }
            catch (InterruptedException interruptedException) {
                return;
            }
        }
        Thread.yield();
    }

    public static void a(int n2) {
        var_int_b = 1000 / n2;
    }

    public final void f() {
        rpg.c.a(var_int_a);
    }

    public final void g() {
        rpg.c.a(10);
    }

    public final void h() {
        rpg.c.a(20);
    }

    public static void a(byte by2) {
        var_byte_b = by2;
        var_int_a = var_byte_arr_a[by2];
    }

    public final void i() {
        Object object = this;
        rpg.c.a(20);
        try {
            object = this;
            byte[] byArray = rpg.b.byte_arr_a();
            object = byArray;
            object = byArray;
            var_byte_a = (byte)((byArray[0] & 0xF0) >> 4);
            var_boolean_c = (object[0] & 8) != 0;
            g = (object[0] & 4) != 0;
            var_boolean_b = (object[0] & 2) != 0;
            var_boolean_a = (object[0] & 1) != 0;
            var_byte_b = (byte)((object[1] & 0xF0) >> 4);
            var_byte_e = (byte)(object[1] & 0xF);
            var_byte_c = (byte)object[2];
            var_long_a = rpg.g.long_a((byte[])object, 3);
            di.var_int_f = rpg.g.int_a((byte[])object, 11);
            var_byte_d = (byte)object[15];
            var_boolean_d = object[16] == true;
        }
        catch (Exception exception) {
            try {
                if (var_long_a == 0L) {
                    var_long_a = rpg.g.a();
                }
                this.j();
            }
            catch (Exception exception2) {}
        }
        rpg.c.a(var_byte_b);
    }

    public final void j() {
        byte[] byArray = new byte[24];
        int n2 = 0 | (var_byte_a & 0xF) << 4;
        if (var_boolean_c) {
            n2 |= 8;
        }
        if (g) {
            n2 |= 4;
        }
        if (var_boolean_b) {
            n2 |= 2;
        }
        if (var_boolean_a) {
            n2 |= 1;
        }
        byArray[0] = (byte)n2;
        byArray[1] = (byte)((var_byte_b & 0xF) << 4 | var_byte_e);
        byArray[2] = var_byte_c;
        rpg.g.a(var_long_a, byArray, 3);
        rpg.g.a(di.var_int_f, byArray, 11);
        byArray[15] = var_byte_d;
        byArray[16] = (byte)(var_boolean_d ? 1 : 0);
        rpg.b.a(byArray);
    }

    public static final void k() {
        if (var_boolean_a) {
            ct.var_javax_microedition_lcdui_Display_a.vibrate(300);
        }
    }

    static {
        var_byte_arr_a = new byte[]{6, 10, 14, 18};
        var_rpg_c_a = new c();
        var_byte_a = (byte)3;
        var_byte_b = (byte)2;
        var_byte_c = (byte)2;
        var_boolean_a = true;
        var_byte_e = 0;
        var_boolean_b = false;
        var_boolean_c = false;
        g = true;
        var_byte_d = 0;
        var_long_a = 0L;
        var_boolean_d = true;
        var_ds_a = null;
        f = false;
    }
}

