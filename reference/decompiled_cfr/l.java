/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;

abstract class l
extends b {
    l(n n2, byte by2, byte by3, byte by4) {
        super(n2, by2, by3, by4);
    }

    protected final int int_a(cm cm2, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        return this.a(cm2, false, true, true, false, false);
    }

    /*
     * WARNING - void declaration
     */
    protected final int a(cm cm2, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        void var2_4;
        int n2;
        int n3;
        int n4;
        int n5;
        void var3_7;
        void var6_17;
        void var5_14;
        void var4_10;
        void var3_5;
        this.void_a(cm2, bl2, (boolean)var3_5, (boolean)var4_10, (boolean)var5_14);
        int n6 = this.b_ + 13;
        int n7 = n6 + 1;
        if (var6_17 != false) {
            var3_7 += 13;
        }
        l.a(cm2, di.var_byte_b, rpg.a.c, (int)var3_7, n.var_int_arr_a[di.var_byte_b], 15723216, true, true);
        cm2.a(0);
        int n8 = this.a_ + 12;
        int n9 = 4;
        if (var6_17 != false) {
            n5 = rpg.a.c;
            n4 = 1;
        }
        int n10 = n6;
        if (var6_17 != false) {
            n3 = n6 + 28;
        }
        ac.a(cm2, n5, n6, rpg.e.var_ch_d.a(0), 1, n4);
        if (var6_17 == false) {
            n2 = this.a_ + rpg.d.e_ - 30 + 7;
        }
        ac.a(cm2, (int)(n2 - 10), n3, rpg.e.var_ch_d.a(1 + di.var_byte_b), 1, 1);
        cm2.a(15723216);
        cm2.e(this.a_, (int)(var2_4 += 13), this.a_ + rpg.d.e_ - 1, (int)var2_4);
        if (var6_17 != false) {
            cm2.e(this.a_, (int)(var2_4 + 13), this.a_ + rpg.d.e_ - 1, (int)(var2_4 + 13));
        }
        return (int)(var2_4 + true);
    }

    protected static void a(cm cm2, byte by2, int n2, int n3, int n4, int n5, boolean bl2, boolean bl3) {
        int n6 = n2 - 15 - 1;
        if (bl2) {
            cm2.a(n5);
            cm2.d(n6 + 1, n3 - 1, 27, 13);
            cm2.d(n6, n3, 29, 11);
        }
        cm2.a(n4);
        n.c(cm2, n6 + 1, n3, 28, 12);
        cm2.a(bl3 ? rpg.e.var_cg_arr_d[by2] : rpg.e.var_cg_h, n2, n3 + 1, 17);
    }

    public l(n n2, byte by2) {
        super(n2, by2);
    }

    protected int a(cm cm2, int n2, int n3, boolean bl2) {
        int n4;
        int n5 = this.var_byte_b;
        int n6 = this.b_ + 3;
        int n7 = rpg.a.c - (n3 >> 1);
        int n8 = rpg.a.c + (bl2 ? 5 : 0);
        int n9 = n6 = n6 + 24 + 4;
        for (n4 = 0; n4 < n5; ++n4) {
            byte by2 = this.var_byte_a;
            cm2.a(n4 != by2 ? 7027456 : 0x810000);
            n.c(cm2, n7, n9, n3, 14);
            cm2.a(n4 != by2 ? 3550755 : 0x660000);
            cm2.a(n7 + 1, n9 + 1, n3 - 2, 12);
            n9 += 15;
        }
        for (n4 = n5; n4 < 8; ++n4) {
            int n10 = 14;
            int n11 = n3;
            int n12 = n9;
            int n13 = n7;
            cm cm3 = cm2;
            cm3.a(15723216);
            cm3.e(n13 + 1, n12, n13 + n11 - 2, n12);
            cm3.e(n13 + 1, n12 + 14 - 1, n13 + n11 - 2, n12 + 14 - 1);
            cm3.e(n13, n12 + 1, n13, n12 + 14 - 2);
            cm3.e(n13 + n11 - 1, n12 + 1, n13 + n11 - 1, n12 + 14 - 2);
            n9 += 15;
        }
        if (n2 >= 0) {
            n9 = n6 + 1;
            for (n4 = 0; n4 < n5; ++n4) {
                if (n4 != this.var_byte_a) {
                    if (!(bl2 && (n4 == -1 && eb.var_boolean_f || n4 == -2 && !ax.var_boolean_h || n4 == 4 && !ax.e))) {
                        cm2.a(12630160);
                    }
                    ac.a(cm2, n8, n9, ax.var_ch_a.a(n2 + n4), 0, 1);
                    if (bl2) {
                        ac.a(cm2, n7 + 5, n9, ("" + (n4 == 9 ? 0 : n4 + 1) + ".").getBytes(), 0, 4);
                    }
                }
                if (bl2) {
                    if (n4 == 0 && di.var_do_a.var_short_a > 0) {
                        if (this.d_ < 0) {
                            this.d_ = 10;
                        }
                        if (this.var_boolean_d) {
                            cm2.a(rpg.e.var_cg_arr_c[0], n8 + 50, n9 + 2, 20);
                        }
                    } else if ((n4 == 3 || n4 == 4 && ax.e) && di.var_do_a.var_short_b > 0) {
                        if (this.d_ < 0) {
                            this.d_ = 10;
                        }
                        if (this.var_boolean_d) {
                            cm2.a(rpg.e.var_cg_arr_c[1], n8 + 50, n9 + 2, 20);
                        }
                    }
                }
                n9 += 15;
            }
            cm2.a(0xFFFFFF);
            n9 = n6 + 1 + 15 * this.var_byte_a;
            ac.a(cm2, n8, n9, ax.var_ch_a.a(n2 + this.var_byte_a), 0, 1);
            if (bl2) {
                ac.a(cm2, n7 + 5, n9, ("" + (this.var_byte_a == 9 ? 0 : this.var_byte_a + 1) + ".").getBytes(), 0, 4);
            }
        }
        return n6;
    }
}

