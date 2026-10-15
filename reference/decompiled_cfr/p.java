/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;
import rpg.g;

abstract class p
extends b {
    public static final int[] c = new int[]{0xFFFFFF, 0xFFFF00, 16722152, 65280};
    private static final int e = rpg.d.e_ / 2 - 3;
    private static final int f = rpg.d.e_ / 2 - 3;

    public p(n n2, byte by2, byte by3, byte by4) {
        super(n2, by2, by3, by4);
    }

    public p(n n2, byte by2) {
        this(n2, by2, 1, 1);
    }

    private void a(cm cm2, int n2, int n3, byte by2, byte by3) {
        cm2.b(this.a_, this.b_, rpg.d.e_, 174);
        if (by3 == -3) {
            cm2.a(15723216);
            for (by3 = 0; by3 < 2; by3 = (byte)(by3 + 1)) {
                cm2.e(n2 + 1, n3 + by3 * 13, n2 + by2 - 2, n3 + by3 * 13);
                cm2.e(n2 + by3 * (by2 - 1), n3 + 1, n2 + by3 * (by2 - 1), n3 + 14 - 2);
            }
            return;
        }
        cm2.a(6379080);
        n.c(cm2, n2, n3, by2, 14);
        if (by3 == -2) {
            return;
        }
        if (by3 == -1) {
            b.a(cm2, n2 + 25, n3 + 6);
        } else {
            cm2.a(0xFFFFFF);
            ac.a(cm2, n2 + (by2 >> 1), n3 + 1, p.byte_arr_a(by3), 1, 1);
        }
        p.a(cm2, n2 + 1, n3 + 3, by3, false);
    }

    protected static byte[] byte_arr_a(byte by2) {
        return rpg.e.var_ch_g.a(by2 + 35);
    }

    private static void a(cm cm2, int n2, int n3, byte by2, boolean bl2) {
        cm2.b(n2, n3, 6, 6);
        if (by2 >= 0) {
            cm2.a(rpg.e.s, n2 - by2 * 6, n3, 20);
        } else if (bl2) {
            if (by2 == -1) {
                cm2.a(0);
                cm2.a(n2 + 1, n3 + 1, 4, 4);
            }
            cm2.a(0xAAA27A);
            cm2.d(n2, n3, 5, 5);
        } else {
            cm2.a(0);
            n.c(cm2, n2, n3, 6, 6);
        }
        rpg.a.a(cm2);
    }

    private static void b(cm cm2, int n2, int n3, as as2, boolean bl2) {
        if (bl2) {
            cm2.a(c[((bm)as2).e]);
        } else {
            cm2.a(0xFFFFFF);
        }
        if (as2.var_byte_arr_a != null) {
            ac.a(cm2, n2, n3, as2.var_byte_arr_a, 0);
        }
    }

    private final void a(cm cm2, byte by2, int n2, int n3, int n4) {
        byte by3 = by2;
        ac.a(cm2, n2, n3, rpg.e.var_ch_g.a(by3), 0, n4);
    }

    protected void a(cm cm2, byte by2, int n2, int n3, boolean bl2) {
        cm2.a(di.var_do_a.byte_a() < by2 ? 0xFF0000 : 0xFFFFFF);
        byte[] byArray = g.a(rpg.d.n, ("" + by2).getBytes());
        ac.a(cm2, n2, n3, byArray, 1);
    }

    private void a(cm cm2, int n2, int n3, bm bm2) {
        int n4 = bm2.int_a();
        cm2.a(7368792);
        n.c(cm2, n2, n3, 45, 8);
        for (int i2 = 0; i2 < n4; ++i2) {
            p.a(cm2, n2 + 2 + i2 * 7, n3 + 1, bm2.var_byte_arr_c[i2], true);
        }
        rpg.a.a(cm2);
    }

    protected final void a(cm cm2, int n2, int n3, as as2) {
        this.a(cm2, n2, n3, as2, false);
    }

    protected final void a(cm cm2, int n2, int n3, as as2, boolean bl2) {
        this.a(cm2, n2, n3, as2, bl2, false);
    }

    protected final void a(cm object, int n2, int n3, as as2, boolean bl2, boolean n4) {
        bm bm2;
        int n5;
        if (n4 != 0) {
            n.a((cm)object, this.a_, n3 - 2, 30);
        }
        if (as2 == null) {
            ((cm)object).a(0x7F7F7F);
            int n6 = 24;
            ac.a((cm)object, n2 + 9, n3, rpg.e.var_ch_g.a(n6), 0);
            return;
        }
        ((cm)object).b(this.a_, this.b_, rpg.d.e_, 174);
        int n7 = as2.var_byte_a;
        int n8 = as2 instanceof bm;
        p.b((cm)object, n2 + 9, n3, as2, n8 != 0);
        if (bl2) {
            ((cm)object).a(14597755);
            this.a((cm)object, (byte)n7, n2 + rpg.d.e_ - 9, n3, 8);
        } else if (n4 != 0) {
            ((cm)object).a(14597755);
            this.a((cm)object, (byte)n7, n2 + rpg.d.e_ - 9, n3, 8);
            bm bm3 = (bm)as2;
            if (bm3.int_a() > 0) {
                n8 = n2 + 9;
                n5 = n3 + 15;
                this.a((cm)object, n8, n5, bm3);
            }
        } else if (n8 != 0 && (bm2 = (bm)as2).int_a() > 0) {
            n8 = n2 + rpg.d.e_ - 46;
            n5 = n3 + 2;
            this.a((cm)object, n8, n5, bm2);
        }
        if (!bl2 && n4 == 0) {
            as as3 = as2;
            int n9 = n3 + 15 + 6;
            n3 = n2;
            cm cm2 = object;
            object = this;
            n4 = as3.var_byte_a;
            n7 = as3 instanceof bm;
            bm bm4 = null;
            cm2.a(0);
            if (n7 != 0) {
                bm4 = (bm)as3;
            }
            n5 = n3 + 2;
            int n10 = n5 + e + 2;
            int n11 = n10 + (f >> 1);
            super.f(cm2, n3, n9, n9, 32);
            if (n7 == 0 || dp.boolean_a(as3)) {
                cm2.a(0xFFFFFF);
            } else {
                cm2.a(0xFF0000);
            }
            super.a(cm2, (byte)n4, n11, n9 + 1, 1);
            int n12 = n9 + 17;
            cm2.a(0);
            if (n7 != 0) {
                super.f(cm2, n3, n9, n12, n7 != 0 ? 33 : 34);
                ((p)object).a(cm2, bm4.var_byte_d, n10 + 46, n12 + 1, false);
                n7 = bm4.var_short_d > 0 ? 1 : 0;
                super.f(cm2, n3, n9, n12 += 17, n7 != 0 ? 52 : 51);
                object = n7 != 0 ? new String("" + bm4.var_short_d) : (n4 == 11 ? (bm4.var_short_c > 0 ? new String("" + bm4.var_short_c) : new String("---")) : new String("" + bm4.b + "-" + bm4.var_short_c + "/" + bm4.h + "%"));
                cm2.a(0xFFFFFF);
                ac.a(cm2, n11, n12 + 1, ((String)object).getBytes(), 1, 1);
                return;
            }
            n7 = rpg.f.b - 4;
            n.c(cm2, n5, n12, n7, 43);
            cm2.a(0xFFFFFF);
            if (!(as3 instanceof dv) && as3.var_byte_arr_b != null) {
                ac.a(cm2, n5 + 2, n12 + 2, n7 - 4, 0, as3.var_byte_arr_b);
            }
        }
    }

    private final void f(cm cm2, int n2, int n3, int n4, int n5) {
        int n6 = n5;
        byte[] byArray = rpg.e.var_ch_g.a(n6);
        n3 = n4;
        cm cm3 = cm2;
        n5 = n2 + 2;
        int n7 = n5 + e + 2;
        cm3.a(0);
        n.c(cm3, n5, n3, e, 14);
        n.c(cm3, n7, n3, f, 14);
        cm3.e(n2, n3 + 14 + 1, n2 + rpg.d.e_ - 1, n3 + 14 + 1);
        cm3.a(14597755);
        if (byArray != null) {
            ac.a(cm3, n5 + (e >> 1) + 1, n3 + 1, byArray, 0, 1);
        }
    }

    public final void b(cm cm2, int n2, int n3, as as2) {
        int n4 = as2.var_byte_a;
        int n5 = as2 instanceof bm;
        bm bm2 = null;
        int n6 = n2 + 20;
        cm2.a(0);
        cm2.a(n2, n3, rpg.d.e_, 16);
        as2.a(cm2, n2 + 1, n3 + 1, true, true);
        p.b(cm2, n6, n3 + 3, as2, n5 != 0);
        if (n5 != 0) {
            bm2 = (bm)as2;
            n6 = 28 + bm2.e;
            ac.a(cm2, n2 + rpg.d.e_ - 3, n3 + 3, rpg.e.var_ch_g.a(n6), 0, 8);
        }
        n6 = n2 + 2;
        int n7 = n6 + e + 2;
        int n8 = n7 + (f >> 1);
        int n9 = n3 + 16 + 1;
        this.f(cm2, n2, n3, n9, 32);
        cm2.a(0xFFFFFF);
        this.a(cm2, (byte)n4, n8, n9 + 1, 1);
        n9 += 17;
        cm2.a(0);
        if (n5 != 0) {
            this.f(cm2, n2, n3, n9, n5 != 0 ? 33 : 34);
            this.a(cm2, bm2.var_byte_d, n7 + 8, n9 + 1, false);
            n5 = bm2.var_short_d > 0 ? 1 : 0;
            this.f(cm2, n2, n3, n9 += 17, n5 != 0 ? 52 : 51);
            String string = n5 != 0 ? new String("" + bm2.var_short_d) : (n4 == 11 ? (bm2.var_short_c > 0 ? new String("" + bm2.var_short_c) : new String("---")) : new String("" + bm2.b + "-" + bm2.var_short_c + "/" + bm2.h + "%"));
            cm2.a(0xFFFFFF);
            ac.a(cm2, n8, n9 + 1, string.getBytes(), 1, 1);
            n9 += 17;
            for (n4 = 0; n4 < 6; ++n4) {
                int n10 = n4 >> 1;
                n3 = n4 % 2;
                byte by2 = n3 > 0 ? (byte)f : (byte)e;
                this.a(cm2, n6 + n3 * (e + 2), n9 + n10 * 15, by2, bm2.var_byte_arr_c[n4]);
            }
            return;
        }
        n5 = rpg.f.b - 5;
        n.c(cm2, n6, n9, n5, 119);
        cm2.a(0xFFFFFF);
        if (as2.var_byte_arr_b != null) {
            ac.a(cm2, n6 + 2, n9 + 2, n5 - 4, 0, as2.var_byte_arr_b);
        }
    }

    protected final void void_a(as as2) {
        this.var_n_b = new cj((n)this, as2);
    }

    protected void b(cm cm2) {
        this.e(cm2);
    }

    protected final void e(cm cm2) {
        int n2 = this.var_byte_a / this.var_byte_c;
        int n3 = this.var_byte_a % this.var_byte_c;
        n3 = this.a_ + 70 + n3 * 15;
        n2 = this.b_ + 17 + n2 * 15;
        int n4 = n3;
        n3 = n2;
        n2 = n4;
        cm2.a(0x660000);
        cm2.d(n2, n3 - 1, 13, 15);
        cm2.e(n2 - 1, n3, n2 - 1, n3 + 14 - 1);
        cm2.e(n2 + 14, n3, n2 + 14, n3 + 14 - 1);
        cm2.a(0xFF0000);
        cm2.e(n2, n3 + 1, n2, n3 + 14 - 1 - 1);
        cm2.e(n2 + 14 - 1, n3 + 1, n2 + 14 - 1, n3 + 14 - 1 - 1);
        cm2.e(n2 + 1, n3, n2 + 14 - 2, n3);
        cm2.e(n2 + 1, n3 + 14 - 1, n2 + 14 - 2, n3 + 14 - 1);
    }

    protected final void a(cm cm2, bj bj2, byte by2, boolean bl2, byte n2, byte n3, int n4) {
        int n5;
        int n6;
        int n7 = this.b_ + 80;
        n.a(cm2, this.a_, n7, 15);
        int n8 = this.a_ + 70;
        int n9 = this.b_ + 17;
        int n10 = n2 * 14 + n2;
        int n11 = n3 * 14 + n3;
        cm2.a(15723216);
        n.c(cm2, n8 - 1, n9 - 1, n10 + 1, n11 + 1);
        for (n6 = 0; n6 < n3; ++n6) {
            for (n5 = 0; n5 < n2; ++n5) {
                n11 = n8 + n5 * 15;
                int n12 = n9 + n6 * 15;
                as as2 = bj2.as_a(n6 * n2 + n5);
                if (as2 != null) {
                    as2.a(cm2, n11, n12);
                    if (as2.c > 1) {
                        n.b(cm2, as2.c, n11 + 14 - 1, n12 + 14 - 7, 8, 0);
                    }
                    if (!as2.c()) continue;
                    cm2.a(0xFF0000);
                    cm2.d(n11, n12, 13, 13);
                    continue;
                }
                cm2.a(0);
                n.c(cm2, n11, n12, 14, 14);
            }
        }
        if (bl2) {
            cm2.a(0xFFFFFF);
            int n13 = by2 + 25;
            ac.a(cm2, this.a_ + 9, n7 + 2, rpg.e.var_ch_g.a(n13), 0);
        } else {
            this.b(cm2);
            this.a(cm2, this.a_, n7 + 2, bj2.as_a(this.var_byte_a));
        }
        cm2.b(this.a_, this.b_, rpg.d.e_, 174);
        cm2.a(3550755);
        n6 = this.a_ + 9;
        n5 = this.b_ + 174 - 14;
        ac.a(cm2, n6, n5 + 1, rpg.e.var_ch_b.a(31), 0);
        this.b(cm2, this.a_ + 111, n5 + 5, n4);
    }
}

