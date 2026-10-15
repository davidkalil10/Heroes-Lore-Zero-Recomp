/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;

final class dc
extends l {
    private boolean var_boolean_e;
    private do a = di.var_do_a;
    private int var_int_e = 0;

    public dc(n n2) {
        super(n2, (byte)4, (byte)2, (byte)2);
        this.a.void_i();
        if (this.a.var_short_a > 0) {
            this.var_boolean_e = true;
        }
        this.var_boolean_b = true;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            this.var_n_a.var_byte_a = 0;
            this.var_n_a.c();
            return true;
        }
        if (n.f(n2, n3)) {
            if (this.var_boolean_e) {
                dc dc2 = this;
                if (dc2.var_boolean_e && dc2.var_byte_a >= 0 && dc2.var_byte_a < 4) {
                    dc2.a.var_short_a = (short)(dc2.a.var_short_a - 1);
                    if (dc2.a.var_short_a <= 0) {
                        dc2.var_boolean_e = false;
                    }
                    dc2.a.void_h(dc2.var_byte_a);
                    dc2.a.void_i();
                    return true;
                }
                return false;
            }
            this.var_n_a.var_byte_a = 0;
            this.var_n_a.c();
            return true;
        }
        if (!this.var_boolean_e) {
            return true;
        }
        if (this.d(n2, n3)) {
            return true;
        }
        this.e(n2, n3);
        return true;
    }

    protected final void a(cm cm2) {
        int n2;
        int n3 = this.int_a(cm2, false, true, true, false);
        for (n2 = 0; n2 < 2; ++n2) {
            cm2.a(3550755);
            cm2.a(rpg.a.var_int_a - rpg.d.e_ >> 1, n3 + n2 * 77, rpg.d.e_, 22);
            cm2.a(15723216);
            cm2.d(rpg.a.var_int_a - rpg.d.e_ >> 1, n3 + n2 * 77 - 1, rpg.d.e_ - 1, 23);
        }
        n2 = this.a_ + 23;
        n3 = this.b_ + 29;
        cm2.a(rpg.e.var_cg_arr_l[0], n2, n3, 20);
        n.b(cm2, this.a.byte_a(), n2 + 42, n3 + 5, 8, 1);
        int n4 = this.a.int_e((byte)2);
        int n5 = this.a.int_f((byte)2);
        int n6 = rpg.d.e_ - 46;
        n2 = this.a_ + 84;
        cm2.a(rpg.e.var_cg_arr_l[1], n2, n3, 20);
        this.b(cm2, this.a_ + rpg.d.e_ - 3, n3 + 5, n4, n5, 8, 1);
        dc.a(cm2, this.a_ + 23, n3 + 17, 14597755, n6, n4, n5, (byte)2);
        n6 = rpg.d.e_ - 3 >> 1;
        n4 = this.a.int_e((byte)0);
        n5 = this.a.int_f((byte)0);
        n2 = this.a_ + 23;
        n3 = this.b_ + 107;
        cm2.a(rpg.e.var_cg_arr_l[2], n2, n3, 20);
        this.b(cm2, rpg.a.c - 23, n3 + 5, n4, n5, 8, 1);
        dc.a(cm2, this.a_ + 1, n3 + 18, 16737370, n6, n4, n5, (byte)0);
        n4 = this.a.int_e((byte)1);
        n5 = this.a.int_f((byte)1);
        n2 = rpg.a.c + 23;
        cm2.a(rpg.e.var_cg_arr_l[3], n2, n3, 20);
        this.b(cm2, this.a_ + rpg.d.e_ - 23, n3 + 5, n4, n5, 8, 1);
        dc.a(cm2, rpg.a.c + 1, n3 + 18, 6707967, n6, n4, n5, (byte)1);
        n4 = this.a_ + 31;
        n3 = this.b_ + 132;
        cm2.a(rpg.e.var_cg_arr_l[4], n4, n3, 20);
        if (di.boolean_b()) {
            this.b(cm2, n4 + 43 + 1, n3 + 5, this.a.int_b(false), this.a.int_b(true), 4, 1);
        } else {
            n.b(cm2, this.a.int_b(false), n4 + 43 + 8, n3 + 5, 4, 1);
        }
        n5 = rpg.a.c + 15;
        n2 = this.a_ + n5;
        cm2.a(rpg.e.var_cg_arr_l[5], n2 + 10, n3, 20);
        n.b(cm2, this.a.var_int_a, n2 + 43 + 10, n3 + 5, 4, 1);
        n3 = this.b_ + 152;
        cm2.a(rpg.e.var_cg_arr_l[6], n4, n3, 20);
        dc.f(cm2, this.a.int_b((byte)2), this.a_ + 43 + 40, n3 + 5, 1);
        n2 = this.a_ + n5;
        cm2.a(rpg.e.var_cg_arr_l[7], n2 + 10, n3, 20);
        dc.f(cm2, this.a.int_b((byte)0), n2 + 43 + 10, n3 + 5, 1);
        n2 = this.a_ + 45;
        n3 = this.b_ + 59;
        this.a(cm2, n2 + 20, n3, (byte)0);
        this.a(cm2, rpg.a.c + 30, n3, (byte)1);
        this.a(cm2, n2 + 20, n3 += 18, (byte)2);
        this.a(cm2, rpg.a.c + 30, n3, (byte)3);
    }

    private void a(cm cm2, int n2, int n3, byte by2) {
        int n4 = (by2 + 3) % 4;
        cm2.b(n2, n3, 18, 12);
        cm2.a(rpg.e.v, n2 - n4 * 18, n3, 20);
        n.b(cm2, this.a.int_a(by2), n2 + 46, n3 + 3, 8, 1);
    }

    private void b(cm cm2, int n2, int n3, int n4, int n5, int n6, int n7) {
        n7 = dc.int_a(n4, 1);
        int n8 = n2;
        if (n6 == 8) {
            n8 = n2 - (n7 + 7 + dc.int_a(n5, 1));
        } else if (n6 == 1) {
            n8 = n2 - (n7 + 7 + dc.int_a(n5, 1) >> 1);
        }
        n.b(cm2, n4, n8, n3, 4, 1);
        cm2.b(n8 + n7, n3, 7, 7);
        cm2.a(rpg.e.w, n8 + n7 - 7, n3, 20);
        n.b(cm2, n5, n8 + n7 + 7, n3, 4, 1);
    }

    private static int int_a(int n2, int n3) {
        cg cg2 = n3 == 0 ? rpg.e.r : rpg.e.var_cg_arr_h[n3 - 1];
        int n4 = cg2.int_a() / 10 - 1;
        int n5 = 0;
        do {
            n5 += n4;
        } while ((n2 /= 10) != 0);
        return n5;
    }

    private static void f(cm cm2, int n2, int n3, int n4, int n5) {
        n.b(cm2, n2, n3 + 8, n4, 8, 1);
        cm2.b(n3 + 10, n4, 7, 7);
        cm2.a(rpg.e.w, n3 + 10, n4, 20);
        cm2.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
    }

    private static void a(cm cm2, int n2, int n3, int n4, int n5, int n6, int n7, byte by2) {
        cm2.a(0);
        cm2.a(n2, n3, n5, 3);
        n5 = (n5 - 2 - 6) * n6 / n7;
        if (n5 > 0) {
            cm2.a(n4);
            cm2.e(n2 + 1, n3 + 1, n2 + 1 + n5, n3 + 1);
        }
        cm2.a(rpg.e.var_cg_arr_m[by2], n2 + 1 + n5, n3, 20);
    }

    protected final void b(cm cm2) {
        int n2;
        int n3;
        if (this.var_boolean_e) {
            n3 = this.var_byte_a / 2;
            n2 = this.var_byte_a % 2;
            this.a(cm2, this.a_ + 45 + n2 * 80 + 30 + 23, this.b_ + 59 + n3 * 18 + 1, 18, 11);
        }
        cm2.b(this.a_ + 40 - 24, this.b_ + 80 - 26, 40, 38);
        n.b(cm2, this.a_, this.b_ + 13, rpg.d.e_, 161);
        n3 = this.a_ + 40;
        n2 = this.b_ + 80;
        cm2.a(rpg.e.var_cg_arr_e[0], n3, n2 + 6, 33);
        this.var_int_e = rpg.e.var_ca_a.a(this.a.var_byte_a, (byte)2, this.var_int_e, n3, n2) + 1;
        if (this.var_boolean_e) {
            cm2.a(3550755);
            cm2.a(n3 -= 13, n2, 26, 12);
            cm2.a(15723216);
            cm2.d(n3, n2, 26, 12);
            cm2.a(rpg.e.var_cg_arr_c[0], n3 + 2, n2 + 2, 20);
            n.b(cm2, this.a.var_short_a, n3 + 26 - 2, n2 + 3, 8, 0);
        }
    }
}

