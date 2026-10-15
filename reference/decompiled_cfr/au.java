/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;
import rpg.g;

final class au
extends b {
    public static int e = 0;
    private byte f = 0;
    private byte[] a;

    public au(n n2, byte by2) {
        super(n2, (byte)3);
        this.f = by2;
        block0 : switch (this.f) {
            case 0: {
                this.a = rpg.e.var_ch_i.a(0);
                return;
            }
            case 1: {
                this.a = rpg.e.var_ch_b.a(6);
                if (di.j > 0) {
                    this.var_byte_a = di.j;
                }
                if (di.var_byte_arr_arr_a[this.var_byte_a] != null) break;
                this.var_byte_a = 0;
                for (int n3 = 0; n3 < 3; n3 = (int)((byte)(n3 + 1))) {
                    if (di.var_byte_arr_arr_a[n3] == null) continue;
                    this.var_byte_a = (byte)n3;
                    break block0;
                }
                return;
            }
            case 2: {
                if (di.var_boolean_i) {
                    this.var_n_b = new br((n)this, rpg.d.t, '\u0000');
                    di.var_boolean_i = false;
                    rpg.b.boolean_a();
                }
                this.a = rpg.e.var_ch_h.a(12);
            }
        }
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            this.var_n_a.var_byte_a = this.f;
            this.var_n_a.c();
            return true;
        }
        if (n.f(n2, n3)) {
            if (this.f == 1) {
                if (di.var_byte_arr_arr_a[this.var_byte_a] == null) {
                    this.var_n_b = new br((n)this, rpg.e.var_ch_i.a(5), '\u0000');
                } else {
                    di.j = this.var_byte_a;
                    byte[] byArray = di.var_byte_arr_arr_a[di.j];
                    di.var_byte_b = byArray[13];
                    di.var_byte_h = byArray[16];
                    di.k = byArray[17];
                    di.void_a(1);
                }
            } else if (this.f == 0) {
                if (di.var_byte_arr_arr_a[this.var_byte_a] != null) {
                    this.var_n_b = new bt((n)this, rpg.e.var_ch_i.a(8), 3, false, true);
                    this.var_n_b.var_byte_a = 1;
                } else {
                    this.a();
                }
            } else if (this.f == 2 && di.var_byte_arr_arr_a[this.var_byte_a] != null) {
                di.j = this.var_byte_a;
                di.f();
                di.h();
                di.boolean_a(false);
                this.var_n_b = new aw(this);
            }
            return true;
        }
        return this.c(n2, n3);
    }

    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 == 3 && by3 == 0) {
            if (this.f == 0) {
                di.var_int_e = 0;
                this.a();
                return;
            }
            if (this.f == 2) {
                this.c();
                this.var_n_b = new br((n)this, rpg.e.var_ch_h.a(14));
                di.f();
                di.boolean_a(true);
                bq.d();
                this.var_n_a.c();
                this.var_n_a.var_n_b = new aq(this.var_n_a);
            }
        }
    }

    private void a() {
        di.j = this.var_byte_a;
        this.var_n_b = new be(this);
    }

    protected final void a(cm cm2) {
        int n2;
        byte by2;
        rpg.a.a(cm2, true);
        cm2.a(14597755);
        ac.a(cm2, rpg.a.c, rpg.f.d, this.a, 0, 1);
        int n3 = rpg.f.e;
        for (by2 = 0; by2 < 3; by2 = (byte)(by2 + 1)) {
            int n4;
            cm cm3;
            n2 = this.b_ + 16 + by2 * 15;
            n.a(cm2, rpg.a.var_int_a - n3 >> 1, n2, n3, 14, this.var_byte_a == by2 ? 0x660000 : 3550755, this.var_byte_a == by2 ? 0xBD0000 : 7027456);
            if (by2 == this.var_byte_a) {
                cm3 = cm2;
                n4 = 0xFFFFFF;
            } else {
                cm3 = cm2;
                n4 = di.var_byte_arr_arr_a[by2] == null ? 0x7F7F7F : 12630160;
            }
            cm3.a(n4);
            ac.a(cm2, rpg.a.c, n2 - 1, g.a(rpg.e.var_ch_b.a(27), (" " + (by2 + 1)).getBytes()), 0, 1);
        }
        n2 = rpg.a.var_int_a - n3 >> 1;
        by2 = this.b_ + 68;
        n.a(cm2, n2, by2, n3, 70, 3550755, 7027456);
        this.b(cm2, n2, by2);
        if (this.var_n_b == null) {
            n.a(cm2, 3);
        }
    }

    private void b(cm cm2, int n2, int n3) {
        byte[] byArray = di.var_byte_arr_arr_a[this.var_byte_a];
        if (byArray == null) {
            cm2.a(12630160);
            ac.a(cm2, n2 + 4, n3 + 4, rpg.e.var_ch_b.a(28), 0);
            return;
        }
        int n4 = di.var_byte_b = byArray[13];
        int n5 = n3 + 3;
        cm2.a(n.var_int_arr_a[n4]);
        n.c(cm2, n2 += 3, n5, 22, 14);
        cm2.a(rpg.e.var_cg_arr_d[di.var_byte_b], n2 + 6, n5 + 1, 20);
        cm2.a(0xFFFFFF);
        ac.a(cm2, n2 + 26, n5 + 1, rpg.e.var_ch_d.a(n4 + 1), 0);
        n4 = byArray[14];
        cm2.a(14597755);
        ac.a(cm2, n2 + 55 + 110, n5 + 1, rpg.e.var_ch_d.a(10), 0);
        n.b(cm2, n4, n2 + 87 + 110, n5 + 5, 4, 0);
        n4 = byArray[15];
        e = n4;
        n.d(cm2, n4, n2 + 100 + 110, n5 + 5);
        long l2 = di.var_long_c = g.long_a(byArray, 18);
        n4 = (int)(di.var_long_c % 60L);
        int n6 = (int)((l2 /= 60L) % 60L);
        int n7 = (int)(l2 / 60L);
        n5 = n3 + 30 + 5;
        cm2.a(0xFFFFFF);
        ac.a(cm2, n2 + 4, n5, rpg.e.var_ch_i.a(6), 0);
        ac.a(cm2, n2 + 64 + 110, n5, ("" + n7 + ":" + n6 + ":" + n4).getBytes(), 0);
        n2 = byArray[26];
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, 27, byArray2, 0, byArray2.length);
        n5 = n3 + 15 + 5;
        ac.a(cm2, rpg.a.c, n5, byArray2, 0, 1);
        int n8 = di.var_byte_h = byArray[16];
        n4 = rpg.e.var_cg_d.int_a();
        n6 = rpg.a.var_int_a - (n4 * ++n8 + (n8 - 1 << 1)) >> 1;
        n5 = n3 + 45 + 3;
        for (n3 = 0; n3 < n8; ++n3) {
            cm2.a(rpg.e.var_cg_d, n6 + (n4 + 2) * n3, n5, 20);
        }
        di.k = byArray[17];
    }
}

