/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;

abstract class dg
extends p {
    protected static final byte[] var_byte_arr_a;
    protected static byte[] b;
    protected static byte[][] var_byte_arr_arr_a;
    protected static int[] d;
    protected static int[] var_int_arr_e;
    protected int var_int_e;
    protected int var_int_f;
    protected boolean var_boolean_e = false;
    protected boolean var_boolean_f = false;
    protected static boolean g;

    public dg(n n2, byte by2, byte by3, byte by4) {
        super(n2, by2, (byte)3, by4);
        this.var_byte_e = 0;
        this.var_int_e = 0;
        this.var_int_f = 1;
        this.var_boolean_f = false;
        this.var_boolean_e = false;
        this.var_boolean_b = true;
    }

    /*
     * WARNING - void declaration
     */
    protected final void a(cm cm2, byte by2, as as2, boolean bl2, boolean bl3) {
        void var5_10;
        int n2;
        int byArray;
        int n3;
        int n4;
        int bm2;
        this.void_a(cm2, false, true, true, false);
        int n5 = this.b_ + 66;
        n.a(cm2, this.a_, n5, 15);
        this.a(cm2, this.a_, n5 + 2, as2, false, true);
        int n8 = this.a_ + (rpg.f.b - 122 >> 1);
        n5 = this.b_ + 24;
        for (bm2 = 0; bm2 < 6; bm2 = (byte)(bm2 + 1)) {
            n4 = bm2 / 3;
            this.a(cm2, (byte)bm2, n8 + n3 * 15, n5 + n4 * 15 + ((n3 = bm2 % 3) == 1 ? -7 : 0));
        }
        this.a(cm2, (byte)6, n8 + 15, n5 + 30 - 7);
        n4 = by2;
        n3 = this.b_ + 17;
        n5 = this.a_ + (rpg.f.b - 122 >> 1) + 56;
        cm cm3 = cm2;
        dg dg2 = this;
        cm3.a(0xAAA27A);
        n.c(cm3, n5 - 7, n3 - 2, 73, 48);
        cm3.a(15723216);
        n.c(cm3, n5 - 6, n3 - 1, 71, 46);
        cm3.a(0xAAA27A);
        cm3.d(n5 - 7 + 5, n3 - 2, 62, 47);
        for (bm2 = 0; bm2 < 3; ++bm2) {
            for (byArray = 0; byArray < 4; ++byArray) {
                n.c(cm3, n5 + byArray * 15, n3 + bm2 * 15, 14, 14);
            }
        }
        cm3.a(3550755);
        for (bm2 = 0; bm2 < 4; ++bm2) {
            for (byArray = 0; byArray < 3; ++byArray) {
                cm3.a(n5 + 1 + bm2 * 15, n3 + 1 + byArray * 15, 12, 12);
            }
        }
        if (var_byte_arr_arr_a[n4] != null) {
            byte[] byArray2 = var_byte_arr_arr_a[n4];
            n4 = byArray2.length;
            dg2.var_int_f = n4 / 12 + 1;
            block5: for (int i2 = 0; i2 < 3; ++i2) {
                for (int i3 = 0; i3 < 4; ++i3) {
                    bm2 = i3 + (i2 << 2);
                    if ((bm2 += dg2.var_int_e * 12) >= n4) continue block5;
                    bm bm3 = (bm)di.bj_a().as_a(byArray2[bm2]);
                    if (bm3 == null) continue;
                    n2 = n5 + i3 * 15;
                    int n6 = n3 + i2 * 15;
                    bm3.a(cm3, n2, n6);
                }
            }
            if (dg2.var_int_f > 1) {
                dg2.e(cm3, 0xAAA27A, n5 - 6, n3 + 21);
                dg2.f(cm3, 0xAAA27A, n5 + 73 - 11, n3 + 21);
            }
        }
        n3 = var5_10;
        n5 = bl2 ? 1 : 0;
        cm3 = cm2;
        dg2 = this;
        n4 = dg2.a_ + 20;
        int n10 = 2 + (rpg.a.var_int_a >> 1);
        int n7 = dg2.b_ + 100;
        cm3.b(dg2.a_, dg2.b_, rpg.d.e_, 174);
        cm3.a(3550755);
        cm3.a(n4 + 60, n7 - 1, 18, 68);
        cm3.a(n10 + 70, n7 - 1, 18, 68);
        cm3.a(rpg.e.var_cg_arr_l[2], n4, n7, 20);
        cm3.a(rpg.e.var_cg_arr_l[4], n4, n7 + 25, 20);
        cm3.a(rpg.e.var_cg_arr_l[5], n4, n7 + 50, 20);
        cm3.a(rpg.e.var_cg_arr_l[3], n10, n7, 20);
        cm3.a(rpg.e.var_cg_arr_l[6], n10, n7 + 25, 20);
        cm3.a(rpg.e.var_cg_arr_l[7], n10, n7 + 50, 20);
        for (n2 = 0; n2 < 3; n2 = (int)((byte)(n2 + 1))) {
            dg2.a(cm3, n2, n4 + 60 + 18, n7 + n2 * 25 + 5, n5 != 0, n3 != 0);
            dg2.a(cm3, n2 + 3, n10 + 70 + 18, n7 + n2 * 25 + 5, n5 != 0, n3 != 0);
        }
    }

    private void a(cm cm2, byte by2, int n2, int n3) {
        if (b == null || b[by2] < 0) {
            int n4 = n2;
            int n5 = n3;
            n3 = by2;
            n2 = n5;
            by2 = (byte)n4;
            cm2.b(by2, n2, 14, 14);
            cm2.a(rpg.e.n, by2 - n3 * 14, n2, 20);
            bs.e(cm2);
            return;
        }
        as as2 = dg.as_a(by2);
        as2.a(cm2, n2, n3);
        cm2.a(15723216);
        cm2.d(n2, n3, 13, 13);
    }

    private static void a(cm cm2, int n2, int n3, byte by2, int n4, boolean bl2) {
        cm2.a(n4);
        for (n4 = 0; n4 < 3; ++n4) {
            if (by2 == 4) {
                cm2.e(n2 + n4, n3 - n4, n2 + n4, n3 + n4);
                continue;
            }
            cm2.e(n2 + 3 - n4 - 1, n3 - n4, n2 + 3 - n4 - 1, n3 + n4);
        }
    }

    protected final void e(cm cm2, int n2, int n3, int n4) {
        dg.a(cm2, n3, n4, (byte)4, n2, false);
    }

    protected final void f(cm cm2, int n2, int n3, int n4) {
        dg.a(cm2, n3, n4, (byte)3, n2, false);
    }

    private void a(cm cm2, int n2, int n3, int n4, boolean bl2, boolean bl3) {
        int n5 = n2;
        if (n2 == 1 && bl3) {
            n5 = 6;
        }
        n.b(cm2, d[n5], n3 - 26, n4, 8, 0);
        if (bl2) {
            n2 = 0;
            if (var_int_arr_e[n5] > 0) {
                n2 = var_int_arr_e[n5] - d[n5];
            }
            if (n2 == 0) {
                this.b(cm2, n3 - 24, n4 + 2);
                return;
            }
            if (n2 > 0) {
                dg.g(cm2, n3 - 20, n4 + 3, 0x6666FF);
            } else {
                dg.g(cm2, n3 - 20, n4 + 3, 0xFF0000);
            }
            n.b(cm2, var_int_arr_e[n5], n3 - 1, n4, 8, 0);
            return;
        }
        this.b(cm2, n3 - 24, n4 + 2);
    }

    private static void g(cm cm2, int n2, int n3, int n4) {
        int n5;
        cm2.a(3550755);
        for (n5 = 0; n5 < 4; ++n5) {
            cm2.e(n2 - n5, n3 - n5, n2 - n5, n3 + n5);
        }
        cm2.e(n2 - 4, n3 - 3, n2 - 4, n3 + 3);
        cm2.a(n4);
        for (n5 = 0; n5 < 3; ++n5) {
            cm2.e(n2 - 1 - n5, n3 - n5, n2 - 1 - n5, n3 + n5);
        }
    }

    private void b(cm cm2, int n2, int n3) {
        cm2.a(3550755);
        cm2.a(n2, n3, 5, 3);
        cm2.a(0xFFFFFF);
        cm2.e(n2 + 1, n3 + 1, n2 + 3, n3 + 1);
        b.a(cm2, n2 + 12, n3 + 1);
    }

    protected static as as_a(byte by2) {
        as as2 = null;
        if (b != null && b[by2] >= 0) {
            as2 = di.bj_a().as_a(b[by2]);
        }
        return as2;
    }

    protected static int[] int_arr_a() {
        do do_ = di.var_do_a;
        int[] nArray = new int[7];
        do_.void_i();
        nArray[0] = do_.int_f((byte)0);
        nArray[3] = do_.int_f((byte)1);
        nArray[1] = do_.int_b(false);
        nArray[4] = do_.int_b((byte)2);
        nArray[2] = do_.var_int_a;
        nArray[5] = do_.int_b((byte)0);
        nArray[6] = do_.int_b(true);
        return nArray;
    }

    protected final void void_a() {
        d = new int[7];
        d = dg.int_arr_a();
    }

    static {
        var_byte_arr_a = new byte[]{2, 0, -1, 6, 1, 7, 3};
        g = false;
    }
}

