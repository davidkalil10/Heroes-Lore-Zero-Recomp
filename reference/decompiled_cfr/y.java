/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;

final class y
extends bp {
    private final byte[] c = new byte[]{2, 4, 2};

    public y(n n2) {
        super(n2, bp.var_byte_g, (byte)4, bp.var_byte_f);
        this.j = 0;
        byte by2 = di.var_byte_b;
        for (byte by3 = 0; by3 < by2; by3 = (byte)(by3 + 1)) {
            this.j = (byte)(this.j + (do.boolean_g(by3) ? 4 : 2));
        }
        this.j = (byte)(this.j / 4);
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            y y2 = this;
            if (y2.var_boolean_h) {
                y2.var_do_a.void_a();
                y2.var_do_a.void_i();
                y2.var_boolean_h = false;
            }
            this.var_n_a.var_byte_a = (byte)3;
            this.var_n_a.c();
            return true;
        }
        if (this.var_boolean_e) {
            if ((n2 == 1 || n3 == 50) && this.var_int_e == 1) {
                this.var_boolean_e = false;
                this.var_boolean_f = true;
            } else if (!this.a(n2, n3, (byte)3)) {
                return true;
            }
            return true;
        }
        if (this.var_boolean_f) {
            if (n2 == 1 || n2 == 8 || n3 == 50 || n3 == 53) {
                this.var_byte_a = (byte)(bp.var_byte_arr_a[this.var_int_e] - 2);
                this.var_boolean_f = false;
            } else {
                this.b(n2, n3, (byte)5);
            }
            return true;
        }
        if (n.f(n2, n3)) {
            if (this.var_int_e == 2) {
                y y3 = this;
                n3 = y3.a(y3.var_byte_a, false);
                byte by2 = di.var_do_a.byte_a(n3);
                if (y3.var_boolean_i && by2 < y3.k) {
                    y3.a(ax.var_ch_a.a(24, 25));
                } else {
                    y3.a(n3, by2, true, true);
                }
                return true;
            }
            if (this.var_int_e == 0) {
                return this.a(false, this.c[this.var_int_e]);
            }
            y y4 = this;
            n3 = y4.var_byte_a < y4.c[y4.var_int_e] ? 1 : 0;
            byte by3 = (byte)(n3 != 0 ? y4.var_byte_a : y4.var_byte_a - y4.c[y4.var_int_e]);
            byte by4 = y4.a(by3, n3 != 0);
            n3 = by4;
            if (by4 >= 0 && (by3 = y4.var_do_a.byte_b(n3)) >= 0) {
                if (y4.var_byte_a < y4.c[y4.var_int_e]) {
                    if (y4.var_boolean_i && by3 < y4.k) {
                        y4.a(ax.var_ch_a.a(24, 28, 25));
                    } else {
                        y4.a(ax.var_ch_a.a(28, 25));
                    }
                } else if (y4.var_boolean_i && by3 < y4.k) {
                    if (by3 == 0) {
                        y4.a(ax.var_ch_a.a(24, 25));
                    } else {
                        y4.a(ax.var_ch_a.a(new int[]{24, 33, 34, 35, 36, 25}));
                    }
                } else if (by3 == 0) {
                    y4.a(n3, by3, false, true);
                } else {
                    y4.a(ax.var_ch_a.a(new int[]{33, 34, 35, 36, 25}));
                }
            }
            return true;
        }
        if (this.a(n2, n3, (int)bp.var_byte_arr_a[this.var_int_e], this.var_int_e == 1)) {
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
            if (this.var_int_e == 2) {
                by2 = this.a(this.var_byte_a, false);
                if (by3 == 0) {
                    this.c(by2);
                    return;
                }
                this.a(by2, this.var_do_a.byte_a(by2), true, true);
                return;
            }
            by2 = this.var_byte_a < this.c[this.var_int_e] ? (byte)1 : 0;
            byte by4 = this.var_byte_a;
            if (by2 == 0) {
                by4 = (byte)(by4 - this.c[this.var_int_e]);
            }
            by2 = this.a(by4, by2 != 0);
            if (this.var_int_e == 0) {
                by4 = di.var_do_a.byte_a(by2);
                this.a(by3, by2, by4, this.c[this.var_int_e], true);
                return;
            }
            by4 = this.var_do_a.byte_b(by2);
            this.b(by3, by2, by4, this.c[this.var_int_e], true);
        }
    }

    protected final void c(byte by2) {
        this.i();
        if (this.var_int_e != 1) {
            di.var_do_a.a(di.var_byte_b, by2);
            return;
        }
        di.var_do_a.void_a((int)by2);
    }

    protected final void a(cm cm2) {
        int n2 = this.b_ + 13;
        int n3 = n2 + 16;
        this.a(cm2, n2, n3, this.c[this.var_int_e]);
        if (this.var_int_e == 0) {
            for (n2 = 0; n2 < 2; ++n2) {
                if (di.var_byte_arr_b[n2] <= 0) continue;
                n.b(cm2, 1 + (n2 << 1), this.a_ + 1 + n2 * (rpg.d.e_ >> 1), n3 + 10, 4, 0);
            }
        }
        if (this.var_int_e == 2) {
            for (n2 = 1; n2 < 4; ++n2) {
                for (int i2 = 0; i2 < bp.var_byte_f; ++i2) {
                    int n4 = n3 + 10 + n2 * 29;
                    int n5 = this.a_ + 2 + i2 * (rpg.d.e_ >> 1);
                    cm cm3 = cm2;
                    y y2 = this;
                    bp.a(cm3, n5, n4, y2.var_byte_h, (byte)14, y2.var_byte_i, (byte)3, 15723216);
                }
            }
        }
        if (this.var_int_e == 1) {
            this.a(cm2, (byte)5);
        }
    }

    final boolean boolean_a(byte by2) {
        if (this.var_int_e == 0) {
            return di.boolean_a(by2, true);
        }
        return this.var_do_a.boolean_f(by2);
    }

    final byte byte_a(byte by2) {
        if (this.var_int_e == 1) {
            return this.var_do_a.byte_b(by2);
        }
        return this.var_do_a.byte_a(by2);
    }

    /*
     * WARNING - void declaration
     */
    final byte a(byte by2, boolean bl2) {
        void var2_8;
        if (bl2 && this.var_int_e != 2) {
            return this.b[by2];
        }
        byte by3 = by2;
        switch (this.var_int_e) {
            case 0: {
                byte by4 = (byte)(by2 + 4);
                break;
            }
            case 1: {
                int n2 = bp.var_byte_arr_a[this.var_int_e] - this.c[this.var_int_e];
                byte by5 = (byte)(by2 + this.j * n2);
                break;
            }
            case 2: {
                byte by6 = (byte)(by2 + 10);
            }
        }
        return (byte)var2_8;
    }

    protected final byte byte_b(byte by2) {
        if (this.var_int_e != 1) {
            by2 = (byte)(by2 - 4);
        }
        return by2;
    }

    protected final void a() {
        this.var_byte_b = bp.var_byte_g = bp.var_byte_arr_a[this.var_int_e];
        this.var_byte_d = (byte)4;
        this.b = this.var_int_e == 0 ? di.var_byte_arr_b : this.var_do_a.var_byte_arr_a;
        this.var_ch_a = this.var_int_e == 1 ? ax.c : ax.b;
        this.var_boolean_g = false;
    }

    final void g() {
        ax.b = new ch("/t/s" + di.var_byte_b);
        ax.c = new ch("/t/ps");
    }

    protected final void b(byte by2, byte by3) {
        this.var_do_a.a((int)by2, by3);
        this.var_boolean_h = true;
    }

    protected final void h() {
        this.var_do_a.l((int)this.var_byte_a);
        this.var_boolean_h = true;
    }

    protected final void a(cm cm2, byte by2, int n2, int n3) {
        bs.a(by2 + 4, n2, n3);
    }
}

