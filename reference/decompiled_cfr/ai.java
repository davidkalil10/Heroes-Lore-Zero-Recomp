/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;
import rpg.g;

final class ai
extends b {
    private byte f;
    private byte[] a;
    private byte[] b;
    private byte[] c;
    private byte[] d;
    private boolean e;

    public ai(n n2) {
        super(n2, (byte)0);
        int n3;
        this.var_byte_b = 0;
        this.var_byte_a = 0;
        byte by2 = 0;
        this.a = new byte[63];
        for (n3 = 0; n3 < 35; n3 = (int)((byte)(n3 + 1))) {
            if (di.byte_a(n3 + 1) != 1) continue;
            this.a[by2] = n3;
            by2 = (byte)(by2 + 1);
        }
        this.f = by2;
        for (n3 = 0; n3 < 28; n3 = (int)((byte)(n3 + 1))) {
            if (di.byte_a(n3 + 51) != 1) continue;
            this.a[by2] = n3;
            by2 = (byte)(by2 + 1);
        }
        this.var_byte_b = by2;
        this.e = true;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3) || n.f(n2, n3)) {
            this.var_n_a.var_byte_a = (byte)5;
            this.var_n_a.c();
        } else if (this.d(n2, n3)) {
            this.e = true;
        }
        return true;
    }

    protected final void a(cm cm2) {
        int n2;
        int n3;
        byte by2 = this.var_byte_a;
        ai ai2 = this;
        if (ai2.e) {
            if (ai2.var_byte_b <= 0) {
                ai2.c = ax.var_ch_a.a(62);
            } else {
                n3 = ai2.a[by2];
                if (n3 >= 0) {
                    ch ch2 = by2 < ai2.f ? rpg.e.var_ch_j : rpg.e.var_ch_k;
                    n2 = n3 << 1;
                    ai2.b = ch2.a(n2);
                    ai2.c = ch2.a(n2 + 1);
                    ai2.d = ax.var_ch_a.a(by2 < ai2.f ? 63 : 64);
                    if (by2 >= ai2.f) {
                        switch (n3) {
                            case 1: {
                                ai2.a((byte)20, (byte)0, 10, rpg.d.var_byte_arr_g);
                                break;
                            }
                            case 5: {
                                ai2.a((byte)19, (byte)16, 10, rpg.d.var_byte_arr_h);
                                break;
                            }
                            case 15: {
                                ai2.a((byte)16, (byte)0, 10, rpg.d.var_byte_arr_i);
                                ai2.a((byte)16, (byte)5, 10, rpg.d.j);
                            }
                        }
                    }
                }
            }
        }
        this.void_a(cm2, false, true, true, false);
        int n4 = (rpg.d.e_ - 96 >> 1) + this.a_;
        int n5 = n2 = this.b_ + 13 + 1;
        n3 = n4;
        cm cm3 = cm2;
        ai ai3 = this;
        cm3.a(0);
        cm3.a(n3, n5, 96, 11);
        cm3.a(0xFF0000);
        cm3.d(n3 + 1, n5 + 1, 93, 8);
        n.a(cm3, n3 - 4, n5 + 5, 104, 0, false);
        ai3.a(cm3, n3 + 48, n5 + 2, ai3.var_byte_b <= 0 ? 0 : ai3.var_byte_a + 1, ai3.var_byte_b, 1);
        int n6 = rpg.f.a - 10;
        int n7 = (rpg.d.e_ - n6 >> 1) + this.a_;
        n3 = n2 + 11 + 2;
        n.c(cm2, n7, n3, n6, 14);
        n5 = n3 + 14 + 3;
        n.c(cm2, n7, n5, n6, 120);
        cm2.a(15723216);
        cm2.e(this.a_, n2 + 11, this.a_ + rpg.d.e_ - 1, n2 + 11);
        cm2.e(this.a_, n5 - 2, this.a_ + rpg.d.e_ - 1, n5 - 2);
        if (this.b != null) {
            cm2.a(0xFFFFFF);
            ac.a(cm2, n7 + 6, n3 + 1, this.b, 1, 4);
            cm2.a(this.var_byte_a < this.f ? 14597755 : 0xCCCCCC);
            ac.a(cm2, n7 + n6 - 6 + 2, n3 + 1, this.d, 1, 8);
        } else {
            b.a(cm2, rpg.a.c - 6, n3 + 6);
        }
        if (this.c != null) {
            cm2.a(0xCCCCCC);
            ac.a(cm2, n7 + 6 - 2, n5 + 6, rpg.d.e_ - 14, 1, this.c);
        }
    }

    private final void a(byte by2, byte by3, int n2, byte[] byArray) {
        bj bj2 = di.bj_a(by2);
        int n3 = bj2.int_a(by2, by3);
        by2 = (byte)n3;
        if (n3 > 10) {
            by2 = (byte)10;
        }
        byte[] byArray2 = g.a(";&".getBytes(), byArray);
        byArray2 = g.a(byArray2, ("(" + by2 + "/" + 10 + ")").getBytes());
        this.c = g.a(this.c, byArray2);
    }
}

