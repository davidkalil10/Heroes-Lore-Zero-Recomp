/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;
import rpg.e;
import rpg.g;

final class ce
extends bp {
    private static final byte[] c = new byte[]{4, 6};
    private o a;

    public ce(n n2) {
        super(n2, bp.var_byte_g, (byte)4, bp.var_byte_f);
        this.var_int_e = 0;
        this.a = this.var_do_a.o_a();
        this.j = 0;
        this.k = (byte)5;
        this.var_byte_i = (byte)(this.var_byte_i + 1);
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            if (this.var_boolean_h) {
                this.var_boolean_h = false;
                this.var_do_a.void_i();
            }
            this.var_n_a.var_byte_a = (byte)4;
            this.var_n_a.c();
            return true;
        }
        if (this.var_boolean_e) {
            if (n2 == 1 || n3 == 50) {
                this.var_boolean_e = false;
                this.var_boolean_f = true;
            } else if (!this.a(n2, n3, (byte)2)) {
                return true;
            }
            return true;
        }
        if (this.var_boolean_f) {
            if (n2 == 1 || n2 == 8 || n3 == 50 || n3 == 53) {
                this.var_byte_a = c[this.j];
                this.var_boolean_f = false;
                return true;
            }
            return this.b(n2, n3, (byte)2);
        }
        if (n.f(n2, n3)) {
            if (this.var_int_e == 0) {
                return this.a(true, (byte)2);
            }
            ce ce2 = this;
            n3 = ce2.var_byte_a < 2 ? 1 : 0;
            byte by2 = (byte)(n3 != 0 ? ce2.var_byte_a : ce2.var_byte_a - 2);
            byte by3 = ce2.a(by2, n3 != 0);
            n3 = by3;
            if (by3 >= 0 && (by2 = ce2.a.byte_b(n3)) >= 0) {
                if (ce2.var_byte_a < 2) {
                    if (ce2.var_boolean_i && by2 < ce2.k) {
                        ce2.a(ax.var_ch_a.a(24, 28, 25));
                    } else {
                        ce2.a(ax.var_ch_a.a(28, 25));
                    }
                } else if (ce2.var_boolean_i && by2 < ce2.k) {
                    if (by2 == 0) {
                        ce2.a(ax.var_ch_a.a(24, 25));
                    } else {
                        ce2.a(ax.var_ch_a.a(new int[]{24, 33, 34, 25}));
                    }
                } else if (by2 == 0) {
                    ce2.a(n3, by2, false, false);
                } else {
                    ce2.a(ax.var_ch_a.a(new int[]{33, 34, 25}));
                }
            }
            return true;
        }
        if (this.a(n2, n3, c[this.j] + 2, true)) {
            return true;
        }
        if (this.d(n2, n3)) {
            return true;
        }
        return true;
    }

    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 == 6) {
            by2 = this.var_byte_a < 2 ? (byte)1 : 0;
            byte by4 = this.var_byte_a;
            if (by2 == 0) {
                by4 = (byte)(by4 - 2);
            }
            by2 = this.a(by4, by2 != 0);
            by4 = this.byte_a(by2);
            if (this.var_int_e == 0) {
                this.a(by3, by2, by4, (byte)2, false);
                return;
            }
            this.b(by3, by2, by4, (byte)2, false);
        }
    }

    protected final void a(cm cm2) {
        int n2 = this.b_ + 13;
        int n3 = n2 + 16;
        this.a(cm2, n2, n3, (byte)2);
        if (this.var_int_e == 0) {
            for (n2 = 0; n2 < 2; ++n2) {
                if (di.var_byte_arr_b[n2 + 2] < 0) continue;
                n.b(cm2, 7 + (n2 << 1), this.a_ + 1 + n2 * (rpg.d.e_ >> 1), n3 + 10, 4, 0);
            }
        }
        n2 = this.a_ + 65;
        n3 = this.b_ + 174 - 14 - 1;
        cm2.a(0);
        n.c(cm2, n2, n3, 35, 14);
        cm2.a(16755968);
        ac.a(cm2, n2 + 3, n3, rpg.g.a(rpg.d.n, ("" + (this.j + 1)).getBytes()), 0);
        this.a(cm2, (byte)2);
    }

    final byte a(byte by2, boolean bl2) {
        if (!bl2) {
            if (by2 < c[this.j]) {
                return (byte)(by2 + this.j * c[0]);
            }
            return -2;
        }
        if (this.var_int_e == 0) {
            return this.b[by2 + 2];
        }
        return this.b[by2];
    }

    final byte byte_a(byte by2) {
        if (this.var_int_e == 1) {
            return this.a.byte_b(by2);
        }
        return this.a.byte_a(by2);
    }

    final boolean boolean_a(byte by2) {
        if (by2 < 0) {
            return false;
        }
        if (this.var_int_e == 0) {
            return di.boolean_a(by2, false);
        }
        return this.a.boolean_c(by2);
    }

    final void a() {
        this.b = this.var_int_e == 0 ? di.var_byte_arr_b : this.a.var_byte_arr_a;
        this.var_ch_a = this.var_int_e == 1 ? ax.c : ax.b;
        this.var_boolean_g = false;
    }

    final void g() {
        ax.b = new ch("/t/sa");
        ax.c = new ch("/t/sp");
    }

    protected final void c(byte by2) {
        this.i();
        by2 = this.var_int_e == 0 ? (byte)(this.a.boolean_a(by2) ? 1 : 0) : (byte)(this.a.boolean_b(by2) ? 1 : 0);
        if (by2 != 0) {
            this.a(ax.var_ch_a.a(58));
        }
    }

    protected final void b(byte by2, byte by3) {
        this.a.a((int)by2, by3);
        this.var_boolean_h = true;
    }

    protected final void h() {
        this.a.void_a((int)this.var_byte_a);
        this.var_boolean_h = true;
    }

    protected final void a(cm cm2, byte by2, int n2, int n3) {
        cm2.a(rpg.e.var_cg_arr_g[by2], n2, n3, 20);
    }
}

