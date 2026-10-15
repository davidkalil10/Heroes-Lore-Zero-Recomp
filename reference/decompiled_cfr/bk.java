/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;
import rpg.f;

final class bk
extends dg {
    private byte f = 0;
    private bm a = null;
    private bm b;
    private boolean h = false;

    public bk(n n2, byte by2) {
        super(n2, (byte)12, (byte)3, (byte)4);
        this.f = by2;
        this.var_int_e = 0;
        this.h = true;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            byte by2;
            bk bk2 = this;
            do do_ = di.var_do_a;
            if (bk2.a != null) {
                do_.a(bk2.a);
                bk2.a = null;
            }
            if ((by2 = dg.b[bk2.f]) >= 0) {
                bm bm2 = (bm)di.bj_a().as_a(by2);
                do_.a(bk2.f, bm2);
            }
            do_.void_i();
            this.var_n_a.var_byte_a = this.f;
            this.var_n_a.c();
            return true;
        }
        if (n.f(n2, n3)) {
            n2 = this.var_byte_a + this.var_int_e * 12;
            bm bm3 = this.bm_a(n2);
            if (bm3 == null) {
                return true;
            }
            this.var_n_b = new dj(this, ax.var_ch_a.a(39, 25), 1);
            return true;
        }
        if (n3 == 52 || n2 == 2) {
            if (this.var_boolean_e) {
                this.var_int_e = (this.var_int_e + this.var_int_f - 1) % this.var_int_f;
            } else if (this.var_boolean_f) {
                this.var_boolean_f = false;
            } else if (this.var_int_f > 1 && this.var_byte_a % 4 == 0) {
                this.var_boolean_e = true;
            } else {
                this.void_b((byte)3);
                this.h = true;
            }
            return true;
        }
        if (n3 == 54 || n2 == 5) {
            if (this.var_boolean_e) {
                this.var_boolean_e = false;
            } else if (this.var_boolean_f) {
                this.var_int_e = (this.var_int_e + 1) % this.var_int_f;
            } else if (this.var_int_f > 1 && this.var_byte_a % 4 == 3) {
                this.var_boolean_f = true;
            } else {
                this.void_b((byte)4);
                this.h = true;
            }
            return true;
        }
        if (this.e(n2, n3)) {
            this.h = true;
            return true;
        }
        return true;
    }

    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 == 6) {
            if (by3 == 0) {
                this.var_n_b = new br((n)this, ax.var_ch_a.a(57), '\u0000');
                bk bk2 = this;
                do do_ = di.var_do_a;
                do_.a(bk2.f, bk2.a);
                do_.void_i();
                byte by4 = dg.var_byte_arr_a[bk2.f];
                if (by4 >= 0) {
                    rpg.e.a(rpg.e.var_ca_a, (int)by4);
                }
                dg.g = true;
                this.var_n_a.c();
                return;
            }
            if (by3 == 1) {
                this.var_n_b = new cj((n)this, this.a);
            }
        }
    }

    protected final void a(cm cm2) {
        if (this.h) {
            int n2 = this.var_byte_a + this.var_int_e * 12;
            this.b = this.bm_a(n2);
            if (this.b != null) {
                bm bm2 = this.b;
                bk bk2 = this;
                do do_ = di.var_do_a;
                bk2.a = bm2;
                do_.a(bk2.f, bk2.a);
                do_.void_i();
                dg.var_int_arr_e = new int[7];
                dg.var_int_arr_e = dg.int_arr_a();
            }
            this.h = false;
        }
        this.a(cm2, this.f, this.b, this.b != null, this.f == 5);
    }

    protected final void b(cm cm2) {
        if (this.var_boolean_e) {
            this.e(cm2, n.var_int_arr_b[this.var_byte_e], this.a_ + (rpg.f.b - 122 >> 1) + 56, this.b_ + 17 + 21);
            return;
        }
        if (this.var_boolean_f) {
            this.f(cm2, n.var_int_arr_b[this.var_byte_e], this.a_ + 105 + 73 - 11, this.b_ + 17 + 21);
            return;
        }
        int n2 = this.var_byte_a / this.var_byte_c;
        int n3 = this.var_byte_a % this.var_byte_c;
        n3 = this.a_ + (rpg.f.b - 122 >> 1) + 56 + n3 * 15;
        n2 = this.b_ + 17 + n2 * 15;
        this.a(cm2, n3, n2, 13, 13);
    }

    private bm bm_a(int n2) {
        byte[] byArray = dg.var_byte_arr_arr_a[this.f];
        bm bm2 = null;
        if (byArray != null && n2 < byArray.length) {
            bm2 = (bm)di.bj_a().as_a(byArray[n2]);
        }
        return bm2;
    }
}

