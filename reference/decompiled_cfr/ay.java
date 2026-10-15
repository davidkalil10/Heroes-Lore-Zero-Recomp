/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;
import rpg.g;

public final class ay
extends q {
    private ch a;
    private byte f;

    public ay() {
        super(null, (byte)6, (byte)1, (byte)1);
        this.var_boolean_b = true;
        if (di.var_byte_b == this.var_byte_a) {
            this.boolean_a(5, 54);
            while (!this.boolean_a(this.var_byte_a)) {
                this.boolean_a(5, 54);
            }
        }
        this.a = new ch("/t/j");
        this.f = 0;
        this.var_n_b = new bt(this, this.a.a(3), this.a.a(10, 11));
        bs.bs_a();
        bs.e();
    }

    private void a() {
        this.a = null;
        df.void_e();
        bs.var_boolean_c = true;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.var_n_b != null && this.var_n_b instanceof bw && this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3) && this.f <= 1 || this.f >= 7) {
            this.a();
            return true;
        }
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.f(n2, n3)) {
            if (this.boolean_a(this.var_byte_a)) {
                n2 = di.var_do_a.byte_a() * di.l * 100;
                byte[] byArray = g.a(rpg.d.F, ("" + n2).getBytes());
                this.var_n_b = new bt((n)this, g.a(byArray, rpg.d.G), 3, true);
            } else {
                this.var_n_b = new br((n)this, this.a.a(4), '\u0000');
            }
        } else if (n.h(n2, n3)) {
            this.var_byte_a = (byte)((this.var_byte_a - 1 + this.var_byte_b) % this.var_byte_b);
            if (di.var_byte_b == this.var_byte_a) {
                this.boolean_a(n2, n3);
            }
        } else if (n.i(n2, n3)) {
            this.var_byte_a = (byte)((this.var_byte_a + 1) % this.var_byte_b);
            if (di.var_byte_b == this.var_byte_a) {
                this.boolean_a(n2, n3);
            }
        } else {
            return false;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 == -1 && by3 == -1) {
            this.var_n_b = new br((n)this, this.a.a(9), '\u0000');
            this.f = (byte)8;
            bs.var_boolean_c = true;
            return;
        }
        if (by2 == -2 && by3 == -2) {
            by2 = (byte)3;
            by3 = 0;
        }
        if (by2 == 3) {
            if (this.f == 0) {
                if (by3 != 0) {
                    this.a();
                    return;
                }
                if (di.var_int_e >= 2000) {
                    di.var_int_e -= 2000;
                    di.var_do_a.o();
                    di.var_do_a.p();
                    this.a();
                    return;
                }
                if (eb.var_boolean_f) {
                    this.var_n_b = new br((n)this, this.a.a(9), '\u0000');
                    this.f = (byte)8;
                    return;
                }
                this.var_n_b = new br((n)this, this.a.a(9), '\u0000');
                this.f = (byte)8;
                return;
            }
            if (this.f != 1) {
                if (this.f != 6) return;
                this.a();
                if (by3 != 0) return;
                di.a((byte)6, (byte)1);
                return;
            }
            if (by3 != 0) return;
            by2 = (byte)(di.var_do_a.byte_a() * di.l * 100);
            if (di.var_int_e < by2) {
                if (eb.var_boolean_f) {
                    this.var_n_b = new br((n)this, this.a.a(9), '\u0000');
                    this.f = (byte)7;
                    return;
                }
                this.var_n_b = new br((n)this, this.a.a(9), '\u0000');
                this.f = (byte)7;
                return;
            }
            di.var_int_e -= by2;
            if (di.l < 99) {
                di.l = (byte)(di.l + 1);
            }
            ay ay2 = this;
            this.var_n_b = new br((n)ay2, ay2.a.a(7));
            ay2.f = (byte)2;
            return;
        }
        if (this.f != 0) return;
        if (by3 == 0) {
            this.f = 1;
            return;
        }
        this.var_n_b = new bt((n)this, this.a.a(12), 3, true);
    }

    protected final void a(cm object) {
        if (this.f == 8 || this.var_n_b != null && this.var_n_b instanceof bw) {
            bs.bs_a().d();
        }
        n.a((cm)object, 3);
        if (this.f == 0 || this.f == 8) {
            return;
        }
        int n2 = this.a((cm)object, this.var_byte_a);
        int n3 = n2 + 2;
        ((cm)object).a(0);
        ((cm)object).a(this.a_, n2, rpg.d.e_, 65);
        ((cm)object).a(6379080);
        int n4 = rpg.f.b >> 1;
        n.c((cm)object, this.a_ - 1, n3, n4, 47);
        n.c((cm)object, this.a_ - 1 + n4 + 2, n3, n4, 47);
        n2 = n2 + 47 + 4;
        ((cm)object).a(this.a_, n2, rpg.d.e_, 18);
        int n5 = rpg.a.c - (n4 >>= 1);
        l.a((cm)object, di.var_byte_b, n5, n3 + 26, n.var_int_arr_a[di.var_byte_b], 0, true, true);
        n4 = rpg.a.c + n4;
        l.a((cm)object, this.var_byte_a, n4, n3 + 26, n.var_int_arr_a[this.var_byte_a], 0, true, this.boolean_a(this.var_byte_a));
        int n6 = this.var_byte_a;
        int n7 = 2;
        while (n7 > 0) {
            if ((n6 = (n6 - 1 + 6) % 6) == di.var_byte_b) continue;
            --n7;
        }
        for (n7 = 0; n7 < 5; ++n7) {
            l.a((cm)object, (byte)n6, this.a_ + 4 + 15 + n7 * 31, n2 + 3, n6 != this.var_byte_a ? 3550755 : n.var_int_arr_a[n6], 0xFF0000, n6 == this.var_byte_a, this.boolean_a((byte)n6));
            n6 = (n6 + 1) % this.var_byte_b;
            if (n6 != di.var_byte_b) continue;
            n6 = (n6 + 1) % this.var_byte_b;
        }
        ((cm)object).a(14597755);
        ac.a((cm)object, rpg.a.c, rpg.f.d, this.a.a(0), 0, 1);
        ac.a((cm)object, n5, n3 + 5, this.a.a(1), 0, 1);
        ac.a((cm)object, n4, n3 + 5, this.a.a(2), 0, 1);
        ((cm)object).a(rpg.e.var_cg_m, rpg.a.c, n3 + 18, 17);
        object = this;
        do do_ = di.var_do_a;
        switch (((ay)object).f) {
            case 2: {
                break;
            }
            case 3: {
                n3 = di.boolean_a() ? 1 : 0;
                do_.void_e(((n)object).var_byte_a);
                if (di.boolean_a() == n3) break;
                do_.a(do_.bm_a((byte)0));
                do_.a(do_.bm_a((byte)4));
                do_.a(do_.bm_a((byte)6));
                break;
            }
            case 4: {
                do_.a(do_.bm_a((byte)3));
                do_.a(do_.bm_a((byte)5));
                rpg.e.var_ca_a = rpg.e.rpg_e_a().ca_a();
                break;
            }
            case 5: {
                ((n)object).c();
                ((n)object).var_n_b = new bt((n)object, ((ay)object).a.a(8), 3, true);
                break;
            }
            default: {
                return;
            }
        }
        ((ay)object).f = (byte)(((ay)object).f + 1);
        ((n)object).d();
    }
}

