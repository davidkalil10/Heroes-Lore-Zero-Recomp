/*
 * Decompiled with CFR 0.152.
 */
import java.util.Random;
import rpg.RPGHeroEx;
import rpg.a;
import rpg.c;
import rpg.d;
import rpg.e;
import rpg.f;

public final class bs
extends a {
    private static byte var_byte_b;
    public static boolean var_boolean_b;
    public static int j;
    public static int k;
    public static int l;
    public static int m;
    public static boolean var_boolean_c;
    public static boolean var_boolean_d;
    public static boolean[] var_boolean_arr_a;
    public static boolean var_boolean_e;
    private static bs var_bs_a;
    int n = 0;
    private static final byte var_byte_c;
    private static final byte var_byte_d;
    private static int o;
    private static cd var_cd_a;
    private static cg var_cg_a;
    private ch var_ch_a;
    private int p;
    private byte var_byte_e;
    private boolean var_boolean_f = false;
    private int q = 0;
    private byte var_byte_f = (byte)2;
    private int[] var_int_arr_a = new int[]{0, 0, 0, 0};
    private static boolean g;
    private final int[] var_int_arr_b = new int[]{9700099, 0xFF0303, 16740355, 11862787};
    private final int[] var_int_arr_c = new int[]{0xFFFF00};
    private final int[] var_int_arr_d = new int[]{51968, 0x99F900, 51968};
    private final int[] var_int_arr_e = new int[]{5747455, 3208959, 5747455};

    public bs() {
        j = rpg.a.var_int_a;
        k = rpg.a.var_int_b - 33;
        l = j - 16 >> 1;
        m = k >> 1;
        if (var_byte_b < 0) {
            var_byte_b = 1;
            try {
                String string = RPGHeroEx.a.getAppProperty("Cheat-Enable");
                if (string != null) {
                    string.trim().equals("true");
                }
                return;
            }
            catch (Exception exception) {
                Exception exception2 = exception;
                exception.printStackTrace();
            }
        }
    }

    public static bs bs_a() {
        if (var_bs_a == null) {
            var_bs_a = new bs();
        }
        return var_bs_a;
    }

    public final void void_a() {
        this.var_byte_f = (byte)2;
    }

    public final void b() {
        bq.var_long_a = 0L;
        if (di.var_byte_d == 2) {
            bq.a();
        }
        this.boolean_a(1, 53);
        bs.boolean_a();
        rpg.a.var_boolean_a = true;
        var_boolean_c = true;
        var_boolean_e = true;
        rpg.a.e = 3;
        this.var_byte_f = (byte)2;
    }

    public static void e(cm cm2) {
        if (rpg.a.var_int_a > 240) {
            cm2.b(di.var_g_a.var_int_d, di.var_g_a.var_int_e, Math.min(di.var_g_a.var_short_a, j - di.var_g_a.var_int_d), Math.min(di.var_g_a.var_short_b, k - di.var_g_a.var_int_e));
            return;
        }
        cm2.b(0, 0, j, k);
    }

    protected final void d(cm cm2) {
        rpg.a.var_cm_a = cm2;
        bs bs2 = this;
        this.var_boolean_f = false;
        if (bs2.q != 0) {
            bs2.boolean_a(1, bs2.q);
            bs2.q = 0;
        }
        if (di.var_boolean_f) {
            eb.f(cm2, rpg.f.c, (rpg.f.d << 1) - 20, rpg.d.e_, 150);
            cm2.a(15723216);
            cm2.d(rpg.f.c, (rpg.f.d << 1) - 20, rpg.d.e_ - 1, 149);
            cm2.a(3550755);
            if (di.var_byte_arr_a != null) {
                ac.a(cm2, rpg.f.c + 10, (rpg.f.d << 1) - 10, rpg.f.b - 10, 1, di.var_byte_arr_a);
                ac.a(cm2, rpg.a.c, rpg.a.var_int_b - 62, rpg.e.var_ch_a.a(27), 0, 1);
            }
            return;
        }
        di.void_a();
        switch (di.var_byte_d) {
            case 1: {
                rpg.a.b(rpg.a.var_cm_a);
                break;
            }
            case 2: {
                if (this.var_byte_f > 0) {
                    rpg.a.var_boolean_a = true;
                    this.var_byte_f = (byte)(this.var_byte_f - 1);
                }
                i.i_a().c(rpg.a.var_cm_a);
                break;
            }
            case 3: {
                this.d();
                break;
            }
            case 7: {
                bs2 = this;
                cm2 = rpg.a.var_cm_a;
                if (bs2.n < 5) {
                    int n2 = rpg.a.var_int_b / 5;
                    int n3 = n2 / 5;
                    for (int i2 = 0; i2 < 5; ++i2) {
                        cm2.a(0, n2 * i2, rpg.a.var_int_a, n3 * bs2.n);
                    }
                } else {
                    rpg.a.a(cm2, 0);
                    byte[] byArray = rpg.e.var_ch_b.a(14);
                    int n4 = ac.a(byArray);
                    cm2.a(0x5F3F3F);
                    ac.a(cm2, rpg.a.c - n4 / 2 + 1, rpg.a.d - 20 + 1, 200, 1, byArray, 0, 0, bs2.n - 5 << 1);
                    cm2.a(0xFF3F3F);
                    ac.a(cm2, rpg.a.c - n4 / 2, rpg.a.d - 20, 200, 1, byArray, 0, 0, bs2.n - 5 << 1);
                    int n5 = bs2.n - 5;
                    if (n5 > 8) {
                        n5 = 8;
                    }
                    do.a(rpg.a.c, rpg.a.d + 20, n5);
                    if (bs2.n > 43) {
                        rpg.e.rpg_e_a().d();
                        bs.bs_a().a((byte)2, false);
                    }
                }
                ++bs2.n;
                break;
            }
            case 4: {
                if (!df.boolean_c()) break;
                df.a(rpg.a.var_cm_a);
                break;
            }
            case 5: {
                this.a(ax.ax_a());
                ax.ax_a().e(rpg.a.var_cm_a);
                break;
            }
            case 8: {
                this.a(null);
                di.var_g_a.a(rpg.a.var_cm_a);
                break;
            }
            case 10: {
                bs2 = this;
                cm2 = rpg.a.var_cm_a;
                rpg.a.a(cm2, 0);
                if (bs2.p > 0) {
                    bs2.i();
                    break;
                }
                int n6 = bs2.p * 7;
                if (bs2.n < 3) {
                    cm2.a(50 + 50 * bs2.n, 50 + 50 * bs2.n, 50 + 50 * bs2.n);
                } else if (bs2.n < 15) {
                    cm2.a(0xFFFFFF);
                } else if (bs2.n < 18) {
                    cm2.a(255 - 50 * (bs2.n - 15), 255 - 50 * (bs2.n - 15), 255 - 50 * (bs2.n - 15));
                } else {
                    cm2.a(0);
                }
                int n7 = rpg.a.var_int_b - 84 >> 1;
                for (int i3 = 0; i3 < 7; ++i3) {
                    byte[] byArray = ((ch)null).a(n6 + i3);
                    if (byArray == null) continue;
                    ac.a(cm2, rpg.a.c, n7 + i3 * 15, byArray, 0, 1);
                }
                if (bs2.n < 20) {
                    ++bs2.n;
                    break;
                }
                if (bs2.p > 0) break;
                ++bs2.p;
                bs2.n = 0;
                break;
            }
            case 11: {
                cm2 = rpg.a.var_cm_a;
                cm2.b(255);
                rpg.a.a(cm2, 0);
                cm2.a(0xFFFFFF);
                ac.a(cm2, rpg.a.c, rpg.a.d - 20, rpg.e.var_ch_b.a(di.var_byte_h > 0 ? 34 : 33), 0, 1);
                ac.a(cm2, rpg.a.c, rpg.a.d + 10, rpg.e.var_ch_b.a(32), 0, 1);
            }
        }
        rpg.c.e();
    }

    public final void d() {
        if (rpg.c.var_byte_c > 0) {
            di.void_c();
            di.d();
            di.a(true, true);
        } else {
            di.d();
            di.void_c();
        }
        di.var_g_a.c();
        this.f();
    }

    public final void run() {
        if (di.var_byte_d == 1) {
            e e2 = rpg.e.rpg_e_a();
            switch (this.var_byte_a) {
                case 2: {
                    di.m();
                    i.i_a();
                    e2.void_a();
                    bq.b((byte)0, true);
                    di.void_b();
                    break;
                }
                case 3: {
                    i.void_a();
                    rpg.e.var_ca_a = e2.ca_a();
                    e2.b();
                    this.var_byte_a = (byte)4;
                }
                case 4: {
                    df.void_d();
                    rpg.e.g();
                    bq.f();
                    di.a((byte)2, di.var_byte_e, di.var_byte_f, di.var_byte_g);
                }
            }
            this.var_byte_a = (byte)-1;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final boolean boolean_a(int n2, int n3) {
        int n4;
        if (rpg.c.rpg_c_a() == null) return true;
        if (rpg.c.var_boolean_e) {
            return true;
        }
        if (n4 == 35 && di.var_boolean_f) {
            di.var_boolean_f = false;
            return true;
        }
        if (di.var_boolean_f) {
            return true;
        }
        if (n2 == 0) {
            int n5;
            this.var_boolean_f = true;
            void var1_2 = n4;
            switch (var1_2) {
                case -7: 
                case -6: {
                    n5 = var1_2;
                    break;
                }
                default: {
                    n5 = ct.a((int)var1_2);
                }
            }
            int n6 = n5;
            switch (di.var_byte_d) {
                case 3: {
                    int n7 = n4;
                    n4 = n6;
                    bs bs2 = this;
                    String string = RPGHeroEx.a.getAppProperty("Cheat-Enable");
                    if (string != null && string.trim().equals("true")) {
                        System.out.println("keyPressedRunning : " + n7);
                        bs2.var_int_arr_a[3] = bs2.var_int_arr_a[2];
                        bs2.var_int_arr_a[2] = bs2.var_int_arr_a[1];
                        bs2.var_int_arr_a[1] = bs2.var_int_arr_a[0];
                        bs2.var_int_arr_a[0] = n7;
                        if (bs2.var_int_arr_a[0] == 52 && bs2.var_int_arr_a[1] == 51 && bs2.var_int_arr_a[2] == 50 && bs2.var_int_arr_a[3] == 49) {
                            var_byte_b = 0;
                            var_boolean_b = true;
                        }
                        if (bs2.var_int_arr_a[0] == 49 && bs2.var_int_arr_a[1] == 50 && bs2.var_int_arr_a[2] == 51 && bs2.var_int_arr_a[3] == 52) {
                            var_byte_b = 1;
                            var_boolean_b = false;
                        }
                    }
                    switch (n4) {
                        case 1: {
                            n7 = 50;
                            break;
                        }
                        case 6: {
                            n7 = 56;
                            break;
                        }
                        case 2: {
                            n7 = 52;
                            break;
                        }
                        case 5: {
                            n7 = 54;
                            break;
                        }
                        case 8: {
                            n7 = 53;
                            break;
                        }
                        case -7: {
                            if (eb.var_boolean_f) return true;
                            bs.boolean_a();
                            return true;
                        }
                        case -6: {
                            if (!bs.boolean_a()) return true;
                            di.void_a((byte)6);
                            return true;
                        }
                    }
                    switch (n7) {
                        case 53: {
                            do do_ = di.var_do_a;
                            switch (do_.var_byte_b) {
                                case 6: 
                                case 7: {
                                    return true;
                                }
                                case 2: {
                                    if (di.boolean_c()) break;
                                    di.e();
                                    break;
                                }
                            }
                            if (di.var_g_a.boolean_a(do_.s, do_.t)) return true;
                            if (df.boolean_f()) return true;
                            if (!g.var_boolean_c) return true;
                            di.void_b(0);
                            return true;
                        }
                        case 50: {
                            di.void_b((byte)1);
                            return true;
                        }
                        case 56: {
                            di.void_b((byte)2);
                            return true;
                        }
                        case 52: {
                            di.void_b((byte)3);
                            return true;
                        }
                        case 54: {
                            di.void_b((byte)4);
                            return true;
                        }
                        case 49: {
                            bs.a(0);
                            return true;
                        }
                        case 51: {
                            bs.a(1);
                            return true;
                        }
                        case 55: {
                            bs.a(2);
                            return true;
                        }
                        case 57: {
                            bs.a(3);
                            return true;
                        }
                        case 48: {
                            var_boolean_d = di.var_do_a.boolean_a(true);
                            return true;
                        }
                        case 35: {
                            if (var_byte_b == 0) {
                                var_boolean_b = !var_boolean_b;
                            }
                            var_boolean_d = di.var_do_a.boolean_a(false);
                            return true;
                        }
                        case 42: {
                            if (!bs.boolean_a()) return true;
                            if (rpg.c.var_byte_d == 1) {
                                di.a((byte)6, (byte)2);
                                return true;
                            }
                            if (rpg.c.var_byte_d != 0) return true;
                            g = true;
                            di.a((byte)3, (byte)8, (byte)3);
                            var_boolean_e = true;
                        }
                    }
                    return true;
                }
                case 5: {
                    ax.ax_a().boolean_a(n6, n4);
                    return true;
                }
                case 4: {
                    df.boolean_a(n6, n4);
                    return true;
                }
                case 2: {
                    i.i_a().boolean_a(n6, n4);
                    return true;
                }
                case 8: {
                    if (n4 != -7) {
                        if (n6 != 8) {
                            if (n4 != -6) return true;
                        }
                        if (g) return true;
                    }
                    if (g) {
                        g = false;
                        di.a((byte)3, (byte)3, (byte)1);
                    } else {
                        di.void_a((byte)6);
                        ax.k = true;
                    }
                    var_boolean_c = true;
                    return true;
                }
                case 11: {
                    if (n6 != 8) {
                        if (n4 != 53) return true;
                    }
                    di.a((byte)8, (byte)2);
                }
            }
            return true;
        }
        if (n2 != 1) return true;
        if (di.var_byte_d != 3) {
            return true;
        }
        if (this.var_boolean_f) {
            this.q = n4;
            return true;
        }
        if (di.var_do_a.var_byte_b == 2 && !di.boolean_c()) {
            di.e();
        }
        di.var_do_a.void_e();
        return true;
    }

    private static boolean boolean_a() {
        if (di.var_do_a == null || di.var_do_a.var_byte_b == 1) {
            return true;
        }
        if (di.var_do_a.var_byte_b == 2 && !di.boolean_c()) {
            di.e();
            return true;
        }
        return false;
    }

    private static void a(int n2) {
        if (!g.var_boolean_c) {
            return;
        }
        switch (di.var_do_a.var_byte_b) {
            case 6: 
            case 7: 
            case 9: 
            case 10: {
                return;
            }
        }
        int n3 = di.var_byte_arr_b[n2];
        if (n3 < 0) {
            return;
        }
        if (di.var_int_arr_a[n2] > 0) {
            return;
        }
        di.void_b(di.boolean_b(n2) ? n3 : n3 + 100);
    }

    public final void a(byte by2, boolean bl2) {
        this.var_byte_a = by2;
        di.var_byte_d = 1;
        rpg.a.f = new Random().nextInt();
        rpg.a.f = Math.abs(rpg.a.f) % 11;
        rpg.a.a(false);
        new Thread(var_bs_a).start();
    }

    public static void e() {
        rpg.a.var_boolean_a = true;
        var_boolean_c = true;
    }

    public final void f() {
        int n2;
        int n3;
        int n4;
        if (o > 0 && var_cd_a != null && bs.var_cd_a.var_byte_b != 7) {
            n4 = rpg.a.var_int_a - var_byte_c;
            rpg.a.var_cm_a.a(var_cg_a, n4, 0, 20);
            rpg.a.var_cm_a.a(0xFF3F2F);
            rpg.a.var_cm_a.a(n4 + 42 + 2, 24, var_byte_d * (var_cd_a.int_c() - 1) / var_cd_a.int_d() - 1, 2);
            if (di.var_byte_d == 3) {
                --o;
            }
        } else {
            bs.h();
        }
        n4 = rpg.a.var_int_a - 120 >> 1;
        int n5 = rpg.a.var_int_b - 33;
        do do_ = di.var_do_a;
        if ((do_.var_short_a > 0 || do_.var_short_b > 0) && di.var_byte_d == 3 && g.var_int_a <= 0) {
            this.var_byte_e = (byte)(this.var_byte_e + 1);
            if (this.var_byte_e < 5) {
                bs.e(rpg.a.var_cm_a);
                n3 = 0;
                n2 = n4 - 40;
                if (rpg.a.var_int_a < 240) {
                    n2 += 20;
                }
                if (do_.var_short_a > 0) {
                    rpg.a.var_cm_a.a(rpg.e.var_cg_arr_c[0], n2, n5 - 2, 36);
                    n3 = 12;
                }
                if (do_.var_short_b > 0) {
                    rpg.a.var_cm_a.a(rpg.e.var_cg_arr_c[1], n2 + n3, n5 - 2, 36);
                }
            }
            if (this.var_byte_e >= 8) {
                this.var_byte_e = 0;
            }
        }
        if (var_boolean_c) {
            rpg.a.var_cm_a.b(0, n5, rpg.a.var_int_a, 33);
            rpg.a.var_cm_a.a(0);
            rpg.a.var_cm_a.a(0, n5, rpg.a.var_int_a, 33);
            if (rpg.e.q != null) {
                rpg.a.var_cm_a.a(rpg.e.q, 0, n5, 20);
                if (rpg.a.var_int_a > 176) {
                    n.b(rpg.a.var_cm_a, di.var_do_a.byte_a(), 40, n5 + 20, 4, 0);
                    n.b(rpg.a.var_cm_a, di.var_int_e, 17, n5 + 10, 4, 0);
                }
                if (rpg.e.var_cg_k != null) {
                    if (rpg.e.var_cg_l != null) {
                        rpg.a.var_cm_a.a(rpg.e.var_cg_l, rpg.a.var_int_a - rpg.e.var_cg_l.int_a(), n5, 20);
                    }
                    rpg.a.var_cm_a.a(rpg.e.var_cg_k, rpg.a.var_int_a - rpg.e.var_cg_k.int_a(), n5, 20);
                }
            }
            rpg.a.var_cm_a.a(rpg.e.var_cg_j, n4, n5, 20);
            if (rpg.a.var_int_a >= 360 && rpg.e.var_cg_k != null) {
                rpg.a.var_cm_a.a(rpg.e.var_cg_k, n4 - 60, n5, 20);
                rpg.a.var_cm_a.a(rpg.e.var_cg_k, n4 + 120, n5, 20);
            }
        }
        if (var_boolean_c || var_boolean_d) {
            if (bs.a(true, n4 + 86, n5 + 16)) {
                n.b(rpg.a.var_cm_a, 0, n4 + 83, n5 + 19, 4, 0);
                var_boolean_d = false;
            }
            if (bs.a(false, n4 + 104, n5 + 16)) {
                rpg.a.a(rpg.a.var_cm_a);
                rpg.a.var_cm_a.a(0xFFFFFF);
                ac.a(rpg.a.var_cm_a, n4 + 102, n5 + 18, rpg.d.o, 0);
                var_boolean_d = false;
            }
        }
        if (var_boolean_c || var_boolean_arr_a[0]) {
            n3 = n4 + 1;
            n2 = n5 + 10;
            bs.a(n4, n5, n3, n2, 118, 4, this.var_int_arr_b, (byte)0, 4);
        }
        if (var_boolean_c || var_boolean_arr_a[2]) {
            int n6 = n4 + 1;
            n3 = n5 + 33 - 1;
            bs.a(n4, n5, n6, n3, 118, 1, this.var_int_arr_c, (byte)2, 4);
        }
        if (var_boolean_c || var_boolean_arr_a[3]) {
            n3 = n4 + 79;
            n2 = n5 + 4;
            bs.a(n4, n5, n3, n2, 40, 3, this.var_int_arr_d, (byte)3, 4);
        }
        if (var_boolean_c || var_boolean_arr_a[1]) {
            n3 = n4 + 1;
            n2 = n5 + 4;
            bs.a(n4, n5, n3, n2, 40, 3, this.var_int_arr_e, (byte)1, 8);
        }
        for (n2 = 0; n2 < 4; n2 = (int)((byte)(n2 + 1))) {
            int n7 = n5 + 17;
            n3 = n4 + 8 + n2 * 20;
            int n8 = n2;
            byte by2 = di.var_byte_arr_b[n8];
            rpg.a.var_cm_a.b(n3 - 5, n7, 17, 12);
            if (by2 < 0) {
                rpg.a.var_cm_a.a(0);
                rpg.a.var_cm_a.a(n3 - 5, n7, 17, 12);
                continue;
            }
            int n9 = di.var_int_arr_a[n8];
            int n10 = di.var_int_arr_b[n8];
            if (di.boolean_b(n8)) {
                bs.a(by2, n3, n7);
            } else {
                rpg.a.var_cm_a.a(rpg.e.var_cg_arr_g[by2], n3, n7, 20);
            }
            if (n9 > 0) {
                rpg.a.var_cm_a.b(n3 - 5, n7, 5, 12);
                rpg.a.var_cm_a.a(0);
                rpg.a.var_cm_a.a(n3 - 5, n7, 5, 12);
                rpg.a.var_cm_a.b(n3, n7, 12, n9 * 12 / n10);
                rpg.a.var_cm_a.a(rpg.e.var_cg_i, n3, n7, 20);
                continue;
            }
            if (n9 != 0) continue;
            rpg.a.var_cm_a.b(n3 - 5, n7, 5, 12);
            rpg.a.var_cm_a.a(rpg.e.var_cg_j, rpg.a.var_int_a - 120 >> 1, rpg.a.var_int_b - 33, 20);
        }
        bs.e(rpg.a.var_cm_a);
        var_boolean_c = false;
    }

    private static void a(int n2, int n3, int n4, int n5, int n6, int n7, int[] nArray, byte by2, int n8) {
        do do_ = di.var_do_a;
        int n9 = do_.int_e(by2) * n6 / do_.int_f(by2);
        rpg.a.var_cm_a.b(n4, n5, n6, n7);
        rpg.a.var_cm_a.a(rpg.e.var_cg_j, n2, n3, 20);
        if (n9 > 0) {
            n2 = n8 == 4 ? n4 : n4 + n6 - n9;
            for (n3 = 0; n3 < n7; ++n3) {
                if (var_boolean_b && by2 == 0) {
                    rpg.a.var_cm_a.a(0x7F7F7F);
                } else {
                    rpg.a.var_cm_a.a(nArray[n3]);
                }
                rpg.a.var_cm_a.e(n2, n5 + n3, n2 + n9, n5 + n3);
            }
        }
        bs.var_boolean_arr_a[by2] = false;
    }

    private static boolean a(boolean bl2, int n2, int n3) {
        as as2 = di.as_a(bl2);
        rpg.a.var_cm_a.b(n2 - 3, n3, 17, 14);
        rpg.a.var_cm_a.a(0);
        rpg.a.var_cm_a.a(n2 - 3, n3, 17, 14);
        if (as2 == null) {
            return false;
        }
        int n4 = di.var_int_arr_a[4];
        as2.a(rpg.a.var_cm_a, n2, n3, true, true);
        int n5 = di.bj_a(as2.var_byte_a).int_a(as2.var_byte_a, as2.var_byte_b);
        if (n5 > 1) {
            if (n5 > 99) {
                n5 = 99;
            }
            n.b(rpg.a.var_cm_a, n5, n2 + 13, n3 + 7, 8, 0);
        }
        if (n4 > 0) {
            rpg.a.var_cm_a.b(n2, n3, 12, n4 * 12 / 10);
            rpg.a.var_cm_a.a(rpg.e.var_cg_i, n2, n3, 20);
            return false;
        }
        return true;
    }

    public static final void a(int n2, int n3, int n4) {
        rpg.a.var_cm_a.b(n3, n4, 12, 12);
        rpg.a.var_cm_a.a(rpg.e.var_cg_f, n3 - 12 * (n2 - 4), n4, 20);
    }

    private final void a(n n2) {
        if (rpg.a.var_boolean_a) {
            di.var_g_a.c();
            this.f();
            if (n2 != null) {
                n2.e();
            }
            rpg.a.var_boolean_a = false;
        }
    }

    public final void g() {
        this.i();
    }

    private void i() {
        this.var_ch_a = null;
        di.a((byte)3, (byte)11, (byte)1);
    }

    public static final void a(cd object, boolean bl2) {
        o = 24;
        if (bl2 && var_cd_a != null) {
            return;
        }
        if (var_cd_a == object) {
            return;
        }
        var_cd_a = object;
        var_cg_a = cg.a(var_byte_c, 34);
        object = var_cg_a.cm_a();
        ((cm)object).b(0, 0, var_byte_c, 34);
        ((cm)object).a(0);
        ((cm)object).a(0, 0, (int)var_byte_c, 34);
        ((cm)object).a(0xFFFFFF);
        ac.a((cm)object, var_byte_c >> 1, 5, var_cd_a.byte_arr_a(), 0, 1);
        ((cm)object).a(10159117);
        ((cm)object).d(1, 1, var_byte_c - 3, 31);
        ((cm)object).d(42, 22, var_byte_d + 1, 5);
        ((cm)object).a(rpg.e.var_cg_arr_l[0], 2, 22, 20);
        n.b((cm)object, var_cd_a.byte_a(), 39, 21, 8, 1);
    }

    public static void h() {
        var_cd_a = null;
        var_cg_a = null;
        o = 0;
    }

    static {
        var_byte_b = (byte)-1;
        var_boolean_b = false;
        var_byte_c = (byte)(rpg.f.b >> 1);
        var_byte_d = (byte)((var_byte_c >> 1) - 8);
        g = false;
    }
}

