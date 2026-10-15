/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.d;
import rpg.e;

public final class df
extends db
implements d {
    private static df var_df_a;
    private static byte var_byte_a;
    private static byte var_byte_b;
    private static byte[] var_byte_arr_a;
    private static byte[] var_byte_arr_b;
    private static short var_short_a;
    private static short var_short_b;
    private static int var_int_a;
    private static do var_do_a;
    private static boolean var_boolean_a;
    private static int var_int_b;
    private static int var_int_c;
    private static byte var_byte_c;
    private static int var_int_d;
    private static byte var_byte_d;
    private static byte[] var_byte_arr_c;
    private static byte[] var_byte_arr_d;
    private static short var_short_c;
    private static short var_short_d;
    private static short var_short_e;
    private static short var_short_f;
    private static byte var_byte_e;
    private static byte var_byte_f;
    private static short var_short_g;
    private static short var_short_h;
    private static short var_short_i;
    private static bl var_bl_a;
    private static byte var_byte_g;
    private static byte var_byte_h;
    private static byte[] O;
    private static boolean var_boolean_b;
    private static byte[] P;
    private static eb var_eb_a;
    private static eb var_eb_b;
    private static byte[][] var_byte_arr_arr_a;
    private static n var_n_a;
    private static byte var_byte_i;
    private static byte j;
    private static final byte[][] var_byte_arr_arr_i;
    private static cg var_cg_a;

    public static void void_d() {
        df.void_e();
        var_int_c = 0;
        var_do_a = di.var_do_a;
        if (di.var_g_a != null) {
            di.var_g_a.var_boolean_d = true;
        }
    }

    public static void void_e() {
        db.void_c();
        df.void_h();
        var_int_d = -1;
        var_byte_arr_d = null;
        var_bl_a = null;
        var_byte_g = (byte)-1;
        var_byte_h = (byte)-1;
        df.O[0] = -1;
        var_byte_b = (byte)-1;
        var_boolean_b = false;
        var_byte_d = (byte)-1;
        var_byte_i = (byte)-1;
        var_n_a = null;
        var_byte_arr_arr_a = null;
        var_eb_a = null;
        P = null;
        var_int_c = 255;
        var_int_b = 0;
        var_byte_d = (byte)-1;
    }

    private static void a(byte[] byArray) {
        P = byArray;
        var_boolean_b = false;
    }

    public static final void void_a(byte[] byArray, int n2) {
        var_df_a = null;
        System.gc();
        Runtime.getRuntime().gc();
        var_df_a = new df();
        var_df_a.int_a(byArray, n2);
    }

    protected final boolean a(byte by2, m object) {
        switch (by2) {
            case 0: {
                ((m)object).a(var_byte_arr_a, 2);
                di.b((int)var_byte_arr_a[0], var_byte_arr_a[1]);
                return true;
            }
            case 1: {
                ((m)object).a(var_byte_arr_b, 2);
                var_byte_g = var_byte_arr_b[0];
                var_byte_g = (byte)(var_byte_arr_b[1] == 0 ? -1 : (int)var_byte_g);
                return true;
            }
            case 6: {
                ((m)object).a(var_byte_arr_a, 2);
                return var_byte_arr_a[0] == -1 || di.byte_a((int)var_byte_arr_a[0]) == var_byte_arr_a[1];
            }
            case 2: {
                ((m)object).a(var_byte_arr_a, 2);
                bj bj2 = di.bj_a(var_byte_arr_a[0]);
                object = bj2.byte_arr_b();
                for (int i2 = 0; i2 < ((Object)object).length; ++i2) {
                    as as2;
                    if (object[i2] < 0 || (as2 = bj2.as_a((int)object[i2])) == null || as2.var_byte_a != var_byte_arr_a[0] || as2.var_byte_b != var_byte_arr_a[1] || !as2.c()) continue;
                    return true;
                }
                break;
            }
            case 3: {
                ((m)object).a(var_byte_arr_a, 3);
                int n2 = di.bj_a(var_byte_arr_a[0]).int_a(var_byte_arr_a[0], var_byte_arr_a[1]);
                by2 = (byte)n2;
                return n2 >= var_byte_arr_a[2];
            }
            case 4: {
                ((m)object).a(var_byte_arr_a, 2);
                if (var_byte_arr_a[1] == 0) {
                    return var_do_a.byte_a() <= var_byte_arr_a[0];
                }
                return var_do_a.byte_a() >= var_byte_arr_a[0];
            }
            case 5: {
                by2 = (byte)((m)object).short_a();
                ((m)object).a(var_byte_arr_a, 1);
                if (var_byte_arr_a[0] == 0) {
                    return di.var_int_e <= by2;
                }
                return di.var_int_e >= by2;
            }
            case 7: {
                ((m)object).a(var_byte_arr_a, 3);
                for (int i3 = 0; i3 < 3; ++i3) {
                    if (var_byte_arr_a[i3] == -1 || di.boolean_a(var_byte_arr_a[i3] & 0xFF)) continue;
                    return false;
                }
                return true;
            }
            case 8: {
                df.var_byte_arr_a[0] = ((m)object).byte_a();
                if (var_byte_arr_a[0] == 0) {
                    return di.var_byte_h == 0;
                }
                return di.var_byte_h > 0;
            }
            case 9: {
                df.var_byte_arr_a[0] = ((m)object).byte_a();
                return var_byte_arr_a[0] == var_byte_a;
            }
            case 10: {
                g.var_int_a = 0;
                return true;
            }
        }
        return false;
    }

    protected final boolean b(byte n2, m object) {
        var_byte_b = n2;
        g g2 = di.var_g_a;
        block0 : switch (n2) {
            case 0: {
                ((m)object).a(var_byte_arr_b, 1);
                var_byte_d = var_byte_arr_b[0];
                df.void_g();
                if (!var_boolean_b) break;
                di.var_int_c = di.var_int_a;
                di.var_int_d = di.var_int_b;
                break;
            }
            case 1: {
                ((m)object).a(var_byte_arr_b, 2);
                var_byte_d = (byte)-1;
                df.void_g();
                df.void_a((int)var_byte_arr_b[0], (int)var_byte_arr_b[1]);
                var_byte_d = (byte)-2;
                break;
            }
            case 2: {
                ((m)object).a(var_byte_arr_b, 2);
                var_byte_d = (byte)-1;
                df.void_g();
                df.void_a((int)var_byte_arr_b[0], (int)var_byte_arr_b[1]);
                var_byte_d = (byte)-2;
                break;
            }
            case 3: {
                ((m)object).a(var_byte_arr_b, 2);
                n2 = var_byte_arr_arr_i[di.var_byte_b][var_byte_arr_b[0] - 1];
                var_do_a.l((byte)n2);
                var_int_a = do.byte_a(n2) * var_byte_arr_b[1];
                break;
            }
            case 4: {
                ((m)object).a(var_byte_arr_b, 1);
                var_do_a.void_a((byte)1);
                var_do_a.void_c(var_byte_arr_b[0]);
                break;
            }
            case 5: {
                ((m)object).a(var_byte_arr_b, 1);
                g.void_a(var_byte_arr_b[0]);
                break;
            }
            case 6: {
                ((m)object).a(var_byte_arr_b, 2);
                df.a(var_do_a, (short)(var_byte_arr_b[0] << 4), (short)(var_byte_arr_b[1] << 4));
                break;
            }
            case 7: {
                ((m)object).a(var_byte_arr_b, 1);
                if (var_boolean_b) {
                    ((du)df.var_do_a).h = (short)(((du)df.var_do_a).h + (rpg.d.H[df.var_do_a.var_byte_c] * var_byte_arr_b[0] << 4));
                    ((du)df.var_do_a).i = (short)(((du)df.var_do_a).i + (rpg.d.I[df.var_do_a.var_byte_c] * var_byte_arr_b[0] << 4));
                    df.a(var_do_a, ((du)df.var_do_a).h, ((du)df.var_do_a).i);
                    break;
                }
                var_short_a = (short)(((du)df.var_do_a).h + (rpg.d.H[df.var_do_a.var_byte_c] * var_byte_arr_b[0] << 4));
                var_short_b = (short)(((du)df.var_do_a).i + (rpg.d.I[df.var_do_a.var_byte_c] * var_byte_arr_b[0] << 4));
                var_do_a.void_a((byte)2);
                break;
            }
            case 9: {
                ((m)object).a(var_byte_arr_b, 1);
                boolean bl2 = var_byte_arr_b[0] == 1;
                object = var_do_a;
                ((du)var_do_a).l = bl2;
                return true;
            }
            case 10: {
                ((m)object).a(var_byte_arr_b, 1);
                var_do_a.void_d(var_byte_arr_b[0]);
                return true;
            }
            case 8: {
                var_do_a.void_a((byte)0, var_do_a.int_f((byte)0));
                var_do_a.void_a((byte)1, var_do_a.int_f((byte)1));
                var_do_a.void_a((byte)3, var_do_a.int_f((byte)3));
                break;
            }
            case 11: {
                n2 = ((m)object).short_a();
                var_do_a.void_c(0 - n2);
                break;
            }
            case 12: {
                int n3;
                ((m)object).a(var_byte_arr_b, 9);
                int n4 = n3 = di.var_byte_h > 2 ? 2 : (int)di.var_byte_h;
                if (var_byte_arr_b[n3 * 3] != -1 && di.bj_a(var_byte_arr_b[n3 * 3]).int_a(var_byte_arr_b[n3 * 3], var_byte_arr_b[n3 * 3 + 1]) < var_byte_arr_b[n3 * 3 + 2]) {
                    df.a(rpg.e.var_ch_g.a(54));
                    return false;
                }
                if (var_byte_arr_b[n3 * 3] == -1) break;
                di.bj_a(var_byte_arr_b[n3 * 3]).b(var_byte_arr_b[n3 * 3], var_byte_arr_b[n3 * 3 + 1], var_byte_arr_b[n3 * 3 + 2]);
                break;
            }
            case 13: {
                n2 = ((m)object).short_a();
                di.e(0 - n2);
                break;
            }
            case 14: {
                ((m)object).a(var_byte_arr_b, 1);
                var_int_a = var_byte_arr_b[0];
                break;
            }
            case 15: {
                n2 = ((m)object).short_a();
                var_do_a.void_c(n2);
                break;
            }
            case 16: {
                int n5;
                ((m)object).a(var_byte_arr_b, 9);
                int n6 = n5 = di.var_byte_h > 2 ? 2 : (int)di.var_byte_h;
                if (var_byte_arr_b[n5 * 3] == -1) break;
                as as2 = as.a(var_byte_arr_b[n5 * 3], var_byte_arr_b[n5 * 3 + 1]);
                int n7 = di.bj_a(var_byte_arr_b[n5 * 3]).a(as2, (int)var_byte_arr_b[n5 * 3 + 2]);
                if (n7 >= var_byte_arr_b[n5 * 3 + 2]) break;
                if (n7 > 0) {
                    di.bj_a(var_byte_arr_b[n5 * 3]).b(as2.var_byte_a, as2.var_byte_b, n7);
                }
                --n5;
                while (n5 >= 0) {
                    if (var_byte_arr_b[n5 * 3 + 1] > 0) {
                        di.bj_a(var_byte_arr_b[n5 * 3]).b(as2.var_byte_a, as2.var_byte_b, var_byte_arr_b[n5 * 3 + 1]);
                    }
                    --n5;
                }
                df.a(rpg.e.var_ch_g.a(53));
                return false;
            }
            case 17: {
                n2 = 0;
                for (int i2 = 0; i2 < 3; ++i2) {
                    if (i2 == (di.var_byte_h > 2 ? 2 : (int)di.var_byte_h)) {
                        n2 = ((m)object).short_a();
                        continue;
                    }
                    ((m)object).short_a();
                }
                di.e(n2);
                break;
            }
            case 18: {
                byte by2 = (byte)rpg.g.a(0, 18);
                n2 = rpg.g.a(0, 183);
                int n8 = n2 = n2 < 0 ? n2 + 256 : n2;
                if (by2 <= 15) {
                    if (n2 > 28) {
                        by2 = 20;
                        n2 = 6;
                    } else {
                        object = as.a(by2, (byte)n2);
                        if (object instanceof bm) {
                            object = (bm)object;
                            if (((bm)object).var_byte_d >= var_do_a.byte_a() + 10) {
                                by2 = 20;
                                n2 = 6;
                            }
                        }
                    }
                } else if (by2 == 16) {
                    n2 = (byte)(n2 / 16);
                } else if (by2 == 17) {
                    n2 = (byte)(n2 / 12);
                } else if (by2 == 18) {
                    n2 = (byte)(n2 / 4);
                }
                object = as.a(by2, (byte)n2);
                if (di.bj_a(((as)object).var_byte_a).a((as)object, 1) > 0) break;
                df.a(rpg.e.var_ch_g.a(53));
                return false;
            }
            case 19: {
                ((m)object).a(var_byte_arr_b, 1);
                var_do_a.h((int)var_byte_arr_b[0]);
                break;
            }
            case 20: {
                n2 = 0;
                for (int i3 = 0; i3 < 3; ++i3) {
                    if (i3 == (di.var_byte_h > 2 ? 2 : (int)di.var_byte_h)) {
                        n2 = ((m)object).b();
                        continue;
                    }
                    ((m)object).b();
                }
                var_do_a.j(n2);
                break;
            }
            case 21: {
                ((m)object).a(var_byte_arr_b, 6);
                rpg.e.rpg_e_a().void_a(var_byte_arr_b);
                break;
            }
            case 22: {
                bs.bs_a().g();
                break;
            }
            case 23: {
                ((m)object).a(O, 4);
                int n9 = O[0] < 0 ? 256 + O[0] : O[0];
                if (n9 == di.var_g_a.var_byte_b) {
                    df.a(var_do_a, (short)(O[1] << 4), (short)(O[2] << 4));
                    var_byte_h = 0;
                    df.O[0] = -1;
                }
                return false;
            }
            case 24: {
                ((m)object).a(var_byte_arr_b, 3);
                if (var_byte_arr_b[0] >= 0) {
                    bl bl3 = di.var_g_a.var_bl_arr_a[var_byte_arr_b[0]];
                    bl3.g(var_byte_arr_b[1]);
                    var_int_a = bl3.byte_a((int)var_byte_arr_b[1]) * var_byte_arr_b[2];
                    break;
                }
                var_byte_i = var_byte_arr_b[1];
                j = 0;
                break;
            }
            case 25: {
                ((m)object).a(var_byte_arr_b, 2);
                g2.b(var_byte_arr_b[0], var_byte_arr_b[1]);
                break;
            }
            case 26: {
                ((m)object).a(var_byte_arr_b, 2);
                df.a(var_byte_arr_b[0], var_byte_arr_b[1], (byte)1);
                break;
            }
            case 27: {
                ((m)object).a(var_byte_arr_b, 2);
                g2.void_a(var_byte_arr_b[1], var_byte_arr_b[0]);
                return true;
            }
            case 28: {
                ((m)object).a(var_byte_arr_b, 3);
                bl bl4 = di.var_g_a.var_bl_arr_a[var_byte_arr_b[0]];
                df.a(bl4, (short)(var_byte_arr_b[1] << 4), (short)(var_byte_arr_b[2] << 4));
                break;
            }
            case 30: {
                ((m)object).a(var_byte_arr_b, 2);
                this.void_a(var_byte_arr_b[0], var_byte_arr_b[1]);
                break;
            }
            case 31: {
                ((m)object).a(var_byte_arr_b, 4);
                n2 = 3;
                while (true) {
                    int n10 = n2;
                    n2 = n2 - 1;
                    if (n10 <= 0) break block0;
                    this.void_a(var_byte_arr_b[n2], var_byte_arr_b[3]);
                }
            }
            case 32: {
                ((m)object).a(var_byte_arr_b, 2);
                bl bl5 = g2.var_bl_arr_a[var_byte_arr_b[0]];
                if (var_byte_arr_b[1] == 0) {
                    boolean bl6 = false;
                    object = bl5;
                    bl5.l = bl6;
                    bl5.v();
                } else {
                    boolean bl7 = true;
                    object = bl5;
                    bl5.l = bl7;
                    bl5.a(((du)bl5).h, ((du)bl5).i);
                    bl5.u();
                }
                return true;
            }
            case 33: {
                ((m)object).a(var_byte_arr_b, 2);
                bl bl8 = g2.var_bl_arr_a[var_byte_arr_b[0]];
                bl8.void_d(var_byte_arr_b[1]);
                return true;
            }
            case 29: {
                ((m)object).a(var_byte_arr_b, 2);
                bl bl9 = g2.var_bl_arr_a[var_byte_arr_b[0]];
                bl9.void_b(var_byte_arr_b[1] == 0 ? -1 : 0);
                return true;
            }
            case 34: {
                break;
            }
            case 35: {
                ((m)object).a(var_byte_arr_b, 2);
                dx dx2 = var_byte_arr_b[0] == 0 ? g2.var_dx_arr_a[var_byte_arr_b[1]] : (var_byte_arr_b[0] == 1 ? g2.var_dx_arr_b[var_byte_arr_b[1]] : g2.var_dx_arr_c[var_byte_arr_b[1]]);
                boolean bl10 = false;
                object = dx2;
                dx2.l = bl10;
                break;
            }
            case 36: {
                break;
            }
            case 37: {
                ((m)object).a(var_byte_arr_b, 3);
                dx dx3 = null;
                if (var_byte_arr_b[0] == 0) {
                    dx3 = g2.var_dx_arr_a[var_byte_arr_b[1]];
                } else if (var_byte_arr_b[0] == 1) {
                    dx3 = g2.var_dx_arr_b[var_byte_arr_b[1]];
                } else if (var_byte_arr_b[1] < g2.var_dx_arr_c.length) {
                    dx3 = g2.var_dx_arr_c[var_byte_arr_b[1]];
                }
                if (dx3 != null) {
                    boolean bl11 = var_byte_arr_b[2] == 1;
                    object = dx3;
                    dx3.l = bl11;
                }
                return true;
            }
            case 38: {
                df.void_h();
                var_n_a = new dw(null);
                break;
            }
            case 39: {
                df.void_h();
                var_n_a = new ay();
                break;
            }
            case 40: {
                df.void_h();
                var_n_a = new da(null);
                break;
            }
            case 41: {
                df.void_h();
                var_n_a = new cc(null);
                break;
            }
            case 42: {
                ((m)object).a(var_byte_arr_b, 1);
                if (var_boolean_b) break;
                var_short_i = 1;
                byte by3 = var_byte_arr_b[0];
                object = this;
                ((df)object).a(by3, (byte)-1, (byte)0);
                break;
            }
            case 43: {
                ((m)object).a(var_byte_arr_b, 3);
                if (var_boolean_b) break;
                var_short_i = 0;
                this.a(var_byte_arr_b[2], var_byte_arr_b[0], var_byte_arr_b[1]);
                break;
            }
            case 44: {
                ((m)object).a(var_byte_arr_b, 1);
                if (var_boolean_b) break;
                var_short_i = 0;
                byte by4 = var_byte_arr_b[0];
                object = this;
                ((df)object).a(by4, (byte)-1, (byte)0);
                break;
            }
            case 45: {
                ((m)object).a(var_byte_arr_b, 1);
                di.var_g_a.var_boolean_e = var_byte_arr_b[0] == 1;
                break;
            }
            case 46: {
                ((m)object).a(var_byte_arr_b, 2);
                if (var_boolean_b) {
                    var_int_d = -1;
                    var_int_c = var_byte_arr_b[0] == 1 ? 255 : 0;
                    break;
                }
                var_int_d = 0;
                var_boolean_a = var_byte_arr_b[0] == 1;
                var_byte_c = var_byte_arr_b[1];
                break;
            }
            case 47: {
                ((m)object).a(var_byte_arr_b, 1);
                if (!var_boolean_b) {
                    var_int_d = 0;
                }
                switch (var_byte_arr_b[0]) {
                    case 0: {
                        var_int_b = 0;
                        var_int_c = 255;
                        break;
                    }
                    case 1: {
                        var_int_b = 0xFFFFFF;
                        var_int_c = 0;
                        break;
                    }
                    case 2: {
                        var_int_b = 0;
                        var_int_c = 0;
                        break;
                    }
                    case 3: {
                        var_int_b = 0;
                        var_int_c = 255;
                        break;
                    }
                    case 4: {
                        var_int_b = 0;
                        var_int_c = 255;
                        if (var_boolean_b) {
                            var_int_d = -1;
                            break;
                        }
                        for (n2 = 0; n2 < var_byte_arr_c.length; n2 = (int)((byte)(n2 + 1))) {
                            df.var_byte_arr_c[n2] = (byte)rpg.g.a(-5, 5);
                        }
                        break;
                    }
                }
                break;
            }
            case 48: {
                ((m)object).a(var_byte_arr_b, 2);
                int n11 = var_int_b = var_byte_arr_b[1] == 0 ? 0 : 0xFFFFFF;
                if (var_boolean_b) {
                    var_int_d = -1;
                    var_int_c = var_byte_arr_b[0] == 1 ? 255 : 0;
                    break;
                }
                var_boolean_a = var_byte_arr_b[0] == 1;
                var_int_d = 0;
                break;
            }
            case 49: {
                break;
            }
            case 50: {
                ((m)object).a(var_byte_arr_b, 2);
                if (var_boolean_b) break;
                bq.c();
                bq.a(var_byte_arr_b[0]);
                break;
            }
            case 51: {
                bl bl12;
                if (g2.var_bl_arr_a != null && (bl12 = g2.bl_a()) != null) {
                    df.a(bl12, ((du)df.var_do_a).h, ((du)df.var_do_a).i);
                    bl12.void_b(0);
                    break;
                }
                return true;
            }
            case 52: {
                ((m)object).a(var_byte_arr_b, 1);
                bl bl13 = g2.bl_a();
                if (bl13 != null) {
                    boolean bl14 = var_byte_arr_b[0] == 1;
                    object = bl13;
                    bl13.l = bl14;
                }
                return true;
            }
            case 53: {
                ((m)object).a(var_byte_arr_b, 2);
                n2 = var_byte_arr_b[0];
                int n12 = n2 = n2 < 0 ? n2 + 256 : n2;
                if (var_byte_arr_b[1] == 0) {
                    di.void_d(n2);
                } else {
                    di.void_c(n2);
                }
                db.void_b();
                return true;
            }
            case 54: {
                ((m)object).a(var_byte_arr_b, 2);
                di.a((int)var_byte_arr_b[0], var_byte_arr_b[1]);
                var_boolean_b = false;
                db.void_b();
                return true;
            }
            case 55: {
                ((m)object).a(var_byte_arr_b, 3);
                di.var_g_a.a(var_byte_arr_b[0], var_byte_arr_b[1], var_byte_arr_b[2]);
                break;
            }
            case 56: {
                ((m)object).a(var_byte_arr_b, 3);
                if (var_byte_arr_b[2] == 0) {
                    int n13 = var_byte_arr_b[1] * g.var_byte_c + var_byte_arr_b[0];
                    di.var_g_a.var_byte_arr_a[n13] = (byte)(di.var_g_a.var_byte_arr_a[n13] | 0xC0);
                    break;
                }
                int n14 = var_byte_arr_b[1] * g.var_byte_c + var_byte_arr_b[0];
                di.var_g_a.var_byte_arr_a[n14] = (byte)(di.var_g_a.var_byte_arr_a[n14] & 0xFFFFFF3F);
                break;
            }
            case 57: {
                ((m)object).a(var_byte_arr_b, 1);
                di.var_g_a.var_boolean_d = var_byte_arr_b[0] == 1;
                break;
            }
            case 58: {
                ((m)object).a(var_byte_arr_b, 4);
                di.a((int)var_byte_arr_b[1], (int)var_byte_arr_b[2], (int)var_byte_arr_b[0]);
            }
        }
        return var_boolean_b;
    }

    private final void void_a(byte by2, byte by3) {
        bl bl2 = di.var_g_a.var_bl_arr_a[by2];
        if (var_boolean_b) {
            ((du)bl2).h = (short)(((du)bl2).h + (rpg.d.H[bl2.var_byte_c] * by3 << 4));
            ((du)bl2).i = (short)(((du)bl2).i + (rpg.d.I[bl2.var_byte_c] * by3 << 4));
            df.a(bl2, ((du)bl2).h, ((du)bl2).i);
            return;
        }
        var_short_a = (short)(((du)bl2).h + (rpg.d.H[bl2.var_byte_c] * by3 << 4));
        var_short_b = (short)(((du)bl2).i + (rpg.d.I[bl2.var_byte_c] * by3 << 4));
        bl2.var_short_a = (byte)(by3 << 1);
        df.a(by2, bl2.var_byte_c, (byte)2);
    }

    protected final void a(byte n2, byte[] byArray) {
        int n3 = n2 = n2 < 0 ? n2 + 256 : n2;
        if (byArray.length > 0) {
            var_boolean_b = false;
            var_byte_arr_arr_a = new byte[byArray.length][];
            int n4 = byArray[0] < 0 ? 256 + byArray[0] : byArray[0];
            byte[] byArray2 = db.byte_arr_a(n4);
            boolean bl2 = false;
            if (byArray2.length != rpg.d.a_.length) {
                bl2 = true;
            } else {
                for (n4 = rpg.d.a_.length - 1; n4 >= 0; --n4) {
                    if (byArray2[n4] == rpg.d.a_[n4]) continue;
                    bl2 = true;
                    break;
                }
            }
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                n4 = byArray[i2] < 0 ? 256 + byArray[i2] : byArray[i2];
                df.var_byte_arr_arr_a[i2] = db.byte_arr_a(n4);
            }
            var_eb_a = new bt(null, db.byte_arr_a(n2), var_byte_arr_arr_a, bl2);
        }
    }

    private static void void_f() {
        int n2 = rpg.a.var_int_a;
        if (var_cg_a == null) {
            var_cg_a = cg.a(n2, 37);
        }
        cm cm2 = var_cg_a.cm_a();
        cm2.b(0, 0, n2, 37);
        cm2.a(0);
        if (var_short_i == 0) {
            cm2.a(3, 3, n2 - 6, 31);
            cm2.a(0x3F3F3F);
            cm2.d(0, 0, n2 - 1, 36);
            cm2.d(2, 2, n2 - 5, 32);
            cm2.a(10452799);
            cm2.d(1, 1, n2 - 3, 34);
            return;
        }
        cm2.a(0, 0, n2, 37);
    }

    private void a(int n2, byte by2, byte by3) {
        df.void_f();
        var_byte_e = by2;
        var_byte_f = by3;
        var_byte_arr_d = db.byte_arr_a(n2 < 0 ? n2 + 256 : n2);
        var_short_c = 0;
        var_short_e = 0;
        var_short_d = 0;
        var_short_f = (short)var_byte_arr_d.length;
        var_short_g = (short)-1;
        var_short_h = 0;
    }

    private static boolean boolean_h() {
        short s2;
        if (var_cg_a == null) {
            return false;
        }
        cm cm2 = var_cg_a.cm_a();
        int n2 = 255;
        cm cm3 = cm2;
        cm3.b(n2);
        if (var_short_e == var_short_d) {
            var_short_c = (short)(var_short_c + var_short_e);
            var_short_d = 0;
            var_short_g = (short)(var_short_g + 1);
        }
        if (var_short_g >= var_short_h + 1) {
            return false;
        }
        if (var_short_d == 0) {
            var_short_d = (short)ac.a(var_byte_arr_d, var_short_c, rpg.a.var_int_a - 20, 2);
            var_short_e = 0;
        }
        if ((var_short_e = (short)ac.a(var_byte_arr_d, var_short_c, s2 = var_short_e)) > var_short_d) {
            var_short_e = (short)(var_short_e - (var_short_e - var_short_d));
        }
        cm2.b(0, 0, var_cg_a.int_a(), var_cg_a.b());
        cm2.a(0xFFFFFF);
        if (var_short_i == 0) {
            ac.a(cm2, 12, 7 + (var_short_g - var_short_h) * 14, rpg.a.var_int_a - 20, 1, var_byte_arr_d, var_short_c, s2, var_short_e);
        } else {
            ac.a(cm2, rpg.a.var_int_a >> 1, 7 + (var_short_g - var_short_h) * 14, rpg.a.var_int_a - 20, var_byte_arr_d, var_short_c, var_short_e, 1);
        }
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public static final boolean boolean_c() {
        block22: {
            block20: {
                block21: {
                    if (!db.boolean_a()) {
                        di.void_c((byte)3);
                        return false;
                    }
                    if (df.var_n_a != null || df.P != null) {
                        return true;
                    }
                    di.void_c((byte)4);
                    if (df.var_boolean_b) break block20;
                    if (df.var_eb_a == null) break block21;
                    v0 = true;
                    break block22;
                }
                switch (df.var_byte_b) {
                    case 0: {
                        ** GOTO lbl79
                    }
                    case 4: 
                    case 5: 
                    case 6: {
                        ** GOTO lbl79
                    }
                    case 7: {
                        if (df.var_do_a.h == df.var_short_a && df.var_do_a.i == df.var_short_b) ** GOTO lbl22
                        df.var_do_a.var_byte_b = (byte)2;
                        v0 = true;
                        break block22;
lbl22:
                        // 1 sources

                        df.var_do_a.void_a((byte)1);
                        ** GOTO lbl79
                    }
                    case 42: 
                    case 43: 
                    case 44: {
                        if (df.var_byte_arr_d == null) ** GOTO lbl79
                        df.boolean_h();
                        v0 = true;
                        break block22;
                    }
                    case 46: {
                        if (df.var_int_d < 0 || df.var_int_d >= 16) ** GOTO lbl35
                        ++df.var_int_d;
                        v0 = true;
                        break block22;
lbl35:
                        // 1 sources

                        df.var_byte_c = (byte)-1;
                        ** GOTO lbl79
                    }
                    case 47: {
                        if (df.var_byte_arr_b[0] != 3) ** GOTO lbl45
                        if (df.var_int_d < 0 || df.var_int_d >= 8) ** GOTO lbl43
                        df.var_int_c = ++df.var_int_d % 2 == 0 ? 255 : 0;
                        v0 = true;
                        break block22;
lbl43:
                        // 1 sources

                        df.var_int_c = 255;
                        ** GOTO lbl79
lbl45:
                        // 1 sources

                        if (df.var_byte_arr_b[0] != 4) ** GOTO lbl79
                        if (df.var_int_d < 0 || df.var_int_d >= df.var_byte_arr_c.length >> 1) ** GOTO lbl52
                        di.var_g_a.var_int_b = df.var_byte_arr_c[df.var_int_d << 1];
                        di.var_g_a.var_int_c = df.var_byte_arr_c[(df.var_int_d << 1) + 1];
                        ++df.var_int_d;
                        v0 = true;
                        break block22;
lbl52:
                        // 1 sources

                        di.var_g_a.var_int_b = 0;
                        di.var_g_a.var_int_c = 0;
                        df.var_int_c = 255;
                        ** GOTO lbl79
                    }
                    case 48: {
                        if (df.var_int_d < 0 || df.var_int_d >= 16) ** GOTO lbl79
                        df.var_int_c = df.var_boolean_a != false ? (df.var_int_d << 4) - 1 : (16 - ++df.var_int_d << 4) - 1;
                        if (df.var_int_c < 0) {
                            df.var_int_c = 0;
                        }
                        v0 = true;
                        break block22;
                    }
                    case 30: {
                        var0 = di.var_g_a.var_bl_arr_a[df.var_byte_arr_b[0]];
                        if (var0.h == df.var_short_a && var0.i == df.var_short_b) ** GOTO lbl69
                        var0.var_byte_b = (byte)2;
                        v0 = true;
                        break block22;
lbl69:
                        // 1 sources

                        var0.void_a((byte)1);
                        ** GOTO lbl79
                    }
                    case 24: {
                        if (df.var_int_a == 1 && df.var_byte_arr_b[2] > 0) {
                            var0 = di.var_g_a.var_bl_arr_a[df.var_byte_arr_b[0]];
                            var0.void_a((byte)1);
                        }
                        ** GOTO lbl79
                    }
                    case 3: {
                        if (df.var_int_a == 1 && df.var_byte_arr_b[1] > 0) {
                            df.var_do_a.void_a((byte)1);
                        }
                    }
lbl79:
                    // 15 sources

                    default: {
                        if (df.var_int_a <= 0 || --df.var_int_a == 0) break;
                        v0 = true;
                        break block22;
                    }
                }
            }
            df.var_byte_b = (byte)-1;
            v0 = false;
        }
        if (!v0 && !df.var_df_a.boolean_b()) {
            df.var_boolean_b = false;
            if (df.var_byte_h >= 0) {
                rpg.e.var_cg_arr_f = null;
                var0_1 = df.var_byte_h;
                df.var_byte_h = (byte)-1;
                df.boolean_a((byte)-1, var0_1);
                bs.var_boolean_c = true;
                return true;
            }
            df.void_e();
            di.void_c((byte)3);
            df.var_do_a.q();
        }
        if (df.O[0] != -1) {
            di.b(df.O[0], df.O[1], df.O[2], df.O[3]);
            df.void_d();
            db.void_a();
            return false;
        }
        di.var_g_a.d();
        df.var_do_a.void_c();
        bs.var_boolean_c = true;
        return true;
    }

    public static void a(cm cm2) {
        int n2;
        if (var_boolean_b) {
            return;
        }
        if (var_n_a != null) {
            bs.bs_a().f();
            var_n_a.c(cm2);
            return;
        }
        if (var_byte_d != -2) {
            df.void_g();
        }
        di.a(false, false);
        if (var_byte_c >= 0) {
            int n3 = 0;
            int n4 = 0;
            n2 = 0;
            int n5 = 0;
            int n6 = rpg.a.var_int_b - 33;
            int n7 = n6 / 16;
            int n8 = rpg.a.var_int_a;
            int n9 = n8 / 16;
            switch (var_byte_c) {
                case 0: {
                    n2 = rpg.a.var_int_a;
                    if (var_byte_arr_b[0] == 0) {
                        n5 = var_int_d * n7;
                        break;
                    }
                    n4 = var_int_d * n7;
                    n5 = rpg.a.var_int_b;
                    break;
                }
                case 1: {
                    n2 = rpg.a.var_int_a;
                    if (var_byte_arr_b[0] == 0) {
                        n5 = rpg.a.var_int_b;
                        n4 = n6 - var_int_d * n7;
                        break;
                    }
                    n5 = n6 - var_int_d * n7;
                    break;
                }
                case 2: {
                    n5 = rpg.a.var_int_b;
                    if (var_byte_arr_b[0] == 0) {
                        n2 = var_int_d * n9;
                        break;
                    }
                    n3 = var_int_d * n9;
                    n2 = rpg.a.var_int_a;
                    break;
                }
                case 3: {
                    n5 = rpg.a.var_int_b;
                    if (var_byte_arr_b[0] == 0) {
                        n2 = rpg.a.var_int_a;
                        n3 = n8 - var_int_d * n9;
                        break;
                    }
                    n2 = n8 - var_int_d * n9;
                }
            }
            df.b(cm2);
            cm2.a(n3, n4, n2, n5);
        }
        cm cm3 = cm2;
        if (var_int_c == 0) {
            cm3.a(var_int_b);
            cm3.b(0, 0, bs.j, rpg.a.var_int_b);
            cm3.a(0, 0, bs.j, rpg.a.var_int_b);
        } else {
            n2 = 255;
            cm cm4 = cm3;
            cm4.b(n2);
            df.b(cm3);
            if (var_byte_i < 0) {
                di.var_g_a.c();
            }
        }
        if (var_int_c > 0) {
            cm2.a(0);
            cm2.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
            if (var_byte_i < 0) {
                cm2.a(0, rpg.a.var_int_b - 37, rpg.a.var_int_a, 37);
                df.b(cm2);
            } else {
                cm2.a(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
                if (j >= rpg.e.var_s_a.a(var_byte_i)) {
                    j = 0;
                    if (var_byte_i == 1 || var_byte_i == 3) {
                        var_byte_i = (byte)(var_byte_i + 1);
                    }
                }
                rpg.e.var_s_a.a(var_byte_i, (byte)0, j, rpg.a.var_int_a >> 1, rpg.a.var_int_b + 50 >> 1);
                j = (byte)(j + 1);
            }
        }
        if (var_byte_arr_d != null) {
            cm3 = cm2;
            int n10 = rpg.a.c - (rpg.a.var_int_a >> 1);
            n2 = var_short_i == 0 ? (short)(rpg.a.var_int_b - 37) : (short)(rpg.a.var_int_b - 33 - 37 >> 1);
            if (var_short_i > 0) {
                cm3.a(0);
                cm3.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
                cm3.a(0, rpg.a.var_int_b - 37, rpg.a.var_int_a, 37);
            }
            cm3.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
            cm3.a(var_cg_a, n10, n2, 20);
            if (var_byte_e >= 0) {
                if (var_byte_f != 0) {
                    cm3.a(rpg.e.var_cg_arr_f[var_byte_e], n10 + var_cg_a.int_a(), n2, 40);
                } else {
                    cm3.a(rpg.e.var_cg_arr_f[var_byte_e], n10, n2, 36);
                }
            }
            if (!di.var_boolean_d) {
                di.var_boolean_d = true;
                rpg.b.boolean_a();
                di.var_boolean_f = true;
                di.var_byte_arr_a = rpg.e.var_ch_a.a(14);
            }
        }
        if (var_byte_arr_arr_a != null && var_eb_a != null) {
            var_eb_a.a(cm2);
        }
        if (!var_boolean_b && var_eb_a == null) {
            cm2.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
            cm2.a(rpg.e.o, rpg.a.var_int_a - 1, rpg.a.var_int_b - 1, 40);
        }
        if (P != null) {
            bo.a(cm2, rpg.a.var_int_a - rpg.d.e_ >> 1, rpg.a.var_int_b - 174 - 40 >> 1, P, 2);
        }
        cm3 = cm2;
        if (var_int_c > 0 && var_int_c < 255) {
            n2 = 255 - var_int_c;
            cm cm5 = cm3;
            cm5.b(n2);
            cm3.a(var_int_b);
            cm3.b(0, 0, bs.j, rpg.a.var_int_b);
            cm3.a(0, 0, bs.j, rpg.a.var_int_b);
        }
    }

    public static final boolean a(do do_) {
        if (((du)do_).j || ((du)do_).k) {
            return false;
        }
        byte by2 = di.var_g_a.byte_a((int)do_.s, (int)do_.t);
        return df.boolean_a((byte)0, by2);
    }

    static final boolean boolean_d() {
        if (((du)df.var_do_a).j || ((du)df.var_do_a).k) {
            return false;
        }
        byte by2 = di.var_g_a.byte_a(df.var_do_a.s + rpg.d.H[df.var_do_a.var_byte_c], df.var_do_a.t + rpg.d.I[df.var_do_a.var_byte_c]);
        return df.boolean_a((byte)3, by2);
    }

    public static boolean boolean_e() {
        if (di.boolean_a(253) || di.boolean_a(254)) {
            df.boolean_a((byte)-1, (byte)3);
            return false;
        }
        if (var_do_a.boolean_a()) {
            di.void_c((byte)4);
            var_eb_a = new br(null, rpg.d.b_, '\u0000');
            return false;
        }
        return true;
    }

    public static boolean boolean_a(int n2, int n3) {
        if (P != null) {
            if (n2 == 8 || n3 == 53) {
                P = null;
                df.void_e();
                df.boolean_c();
            }
            return true;
        }
        if (var_n_a != null) {
            return var_n_a.boolean_a(n2, n3);
        }
        if (var_eb_a != null) {
            if (n2 == 8 || n3 == 53) {
                if (var_eb_a instanceof bt) {
                    db.void_a(var_eb_a.a());
                } else {
                    if (var_eb_a.a() == 0) {
                        var_do_a.p(50);
                    }
                    df.void_e();
                    di.void_c((byte)3);
                    var_do_a.q();
                }
                var_eb_a = null;
                return true;
            }
            return var_eb_a.boolean_a(n2, n3);
        }
        if (var_boolean_b) {
            return true;
        }
        if (n3 == -7) {
            var_int_c = 255;
            n3 = 255;
            Object object = cm.cm_a();
            ((cm)object).b(n3);
            if (di.var_boolean_d) {
                var_boolean_b = true;
            }
            object = var_df_a;
            switch (var_byte_b) {
                case 7: {
                    df.a(var_do_a, var_short_a, var_short_b);
                    var_do_a.void_a((byte)1);
                    break;
                }
                case 30: {
                    object = di.var_g_a.var_bl_arr_a[var_byte_arr_b[0]];
                    df.a((al)object, var_short_a, var_short_b);
                    ((bl)object).void_a((byte)1);
                }
            }
            var_byte_b = (byte)-1;
            var_byte_arr_d = null;
            return true;
        }
        switch (var_byte_b) {
            case 42: 
            case 43: 
            case 44: {
                if (!n.f(n2, n3)) break;
                if (var_short_e < var_short_d) {
                    while (df.boolean_h()) {
                    }
                    break;
                }
                if (var_short_c >= var_short_f) {
                    var_byte_arr_d = null;
                    break;
                }
                if (var_short_g < var_short_h + 1) break;
                var_short_h = (short)(var_short_h + 1);
                df.void_f();
            }
        }
        return true;
    }

    public static final boolean boolean_f() {
        do do_ = di.var_do_a;
        if (((du)do_).j || ((du)do_).k) {
            return false;
        }
        byte by2 = di.var_g_a.byte_a((int)do_.s, (int)do_.t);
        if (df.boolean_a((byte)1, by2)) {
            return true;
        }
        by2 = di.var_g_a.byte_a(do_.s + rpg.d.H[do_.var_byte_c], do_.t + rpg.d.I[do_.var_byte_c]);
        if (df.boolean_a((byte)2, by2)) {
            return true;
        }
        if (g.var_boolean_c) {
            return false;
        }
        boolean bl2 = true;
        byte by3 = do_.var_byte_c;
        du du2 = do_;
        if ((du2 = du2.a((byte)0, by3, (byte)1)) != null && du2 instanceof bl) {
            by2 = ((bl)du2).byte_b();
        }
        if (by2 > 0 && by2 <= 127 && df.boolean_a((byte)2, by2)) {
            if (du2 != null) {
                by2 = rpg.d.N[df.var_do_a.var_byte_c];
                var_bl_a = (bl)du2;
                var_bl_a.e(by2);
            }
            return true;
        }
        return false;
    }

    public static final boolean a(byte by2) {
        var_boolean_b = false;
        return df.boolean_a((byte)-1, by2);
    }

    public static final boolean boolean_g() {
        df.void_d();
        if (di.var_g_a.var_byte_b == 60 || di.var_g_a.var_byte_b == 61) {
            rpg.e.a(di.var_g_a.var_byte_b - 60);
            var_byte_i = 0;
            j = 0;
        }
        var_byte_g = (byte)-1;
        boolean bl2 = df.boolean_a((byte)-1, (byte)0);
        if (var_byte_g >= 0 || di.var_g_a.var_byte_a >= 0) {
            bq.c();
            bq.b(var_byte_g >= 0 ? var_byte_g : di.var_g_a.var_byte_a, true);
        }
        var_byte_g = (byte)-1;
        bq.var_long_a = 0L;
        return bl2;
    }

    private static final boolean boolean_a(byte by2, byte by3) {
        if (by3 < 0) {
            return false;
        }
        var_byte_a = by2;
        if (var_df_a.boolean_a(by3)) {
            var_do_a.q();
            df.boolean_c();
            return true;
        }
        return false;
    }

    private static void a(byte by2, byte by3, byte by4) {
        bl bl2 = di.var_g_a.var_bl_arr_a[by2];
        if (by3 > 0) {
            bl2.void_c(by3);
        }
        if (by4 != 0) {
            bl2.void_a(by4);
        }
    }

    private static void void_a(int n2, int n3) {
        di.var_int_a = -(n2 << 4) + rpg.a.c;
        di.var_int_b = -(n3 << 4) + rpg.a.d;
    }

    private static void void_g() {
        if (var_byte_d == -1) {
            di.void_c();
            return;
        }
        bl bl2 = di.var_g_a.var_bl_arr_a[var_byte_d];
        di.var_int_a = bs.l - ((du)bl2).h;
        di.var_int_b = bs.m - ((du)bl2).i;
    }

    private static void a(al al2, short s2, short s3) {
        al2.v();
        al2.void_a((byte)1);
        al2.a(s2, s3);
        al2.E();
        al2.u();
        di.var_g_a.c(al2);
    }

    private static void void_h() {
        var_boolean_b = false;
        var_int_c = 255;
        var_int_b = 0;
    }

    private static void b(cm cm2) {
        cm2.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b - 37);
    }

    static {
        var_byte_a = (byte)-1;
        var_byte_b = (byte)-1;
        var_byte_arr_a = new byte[5];
        var_byte_arr_b = new byte[9];
        var_int_a = 0;
        var_do_a = null;
        var_boolean_a = false;
        var_int_b = 0;
        var_int_c = 255;
        var_byte_c = (byte)-1;
        var_int_d = -1;
        var_byte_d = (byte)-1;
        var_byte_arr_c = new byte[6];
        var_byte_arr_d = null;
        var_short_c = 0;
        var_short_d = 0;
        var_short_e = 0;
        var_short_f = 0;
        var_byte_e = 0;
        var_byte_f = 0;
        var_short_g = 0;
        var_short_h = 0;
        var_short_i = 0;
        var_bl_a = null;
        var_byte_g = (byte)-1;
        var_byte_h = (byte)-1;
        O = new byte[4];
        var_boolean_b = false;
        P = null;
        var_eb_a = null;
        var_eb_b = null;
        var_byte_arr_arr_a = null;
        var_n_a = null;
        var_byte_i = (byte)-1;
        j = (byte)-1;
        var_byte_arr_arr_i = new byte[][]{{16, 17, 18, 19}, {20, 21, 22, 23}, {20, 21, 22, 23}, {20, 21, 22, 23}, {14, 15, 16, 17}, {19, 20, 21, 22}};
        var_cg_a = null;
    }
}

