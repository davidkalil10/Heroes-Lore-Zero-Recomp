/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;

abstract class bp
extends b {
    protected static final byte[] var_byte_arr_a;
    protected static byte var_byte_f;
    protected static byte var_byte_g;
    protected final byte var_byte_h = (byte)((rpg.f.b >> 1) - 4);
    protected byte var_byte_i = (byte)25;
    protected int var_int_e = 0;
    protected boolean var_boolean_e = true;
    protected boolean var_boolean_f = false;
    protected boolean var_boolean_g;
    protected byte j;
    protected ch var_ch_a;
    protected boolean var_boolean_h;
    protected boolean var_boolean_i;
    protected byte[] b;
    protected byte k;
    protected do var_do_a = di.var_do_a;

    abstract void g();

    abstract void a();

    abstract byte a(byte var1, boolean var2);

    abstract byte byte_a(byte var1);

    abstract boolean boolean_a(byte var1);

    protected abstract void c(byte var1);

    protected abstract void b(byte var1, byte var2);

    protected abstract void h();

    protected abstract void a(cm var1, byte var2, int var3, int var4);

    public bp(n n2, byte by2, byte by3, byte by4) {
        super(n2, by2, (byte)4, by4);
        this.var_boolean_i = this.var_do_a.var_short_b > 0;
        this.var_boolean_g = true;
        this.var_boolean_b = true;
        this.var_boolean_h = false;
        this.k = (byte)3;
        this.g();
    }

    protected final boolean a(int n2, int n3, byte by2) {
        if (n.h(n2, n3)) {
            this.var_int_e = (this.var_int_e + by2 - 1) % by2;
            this.var_boolean_g = true;
        } else if (n.i(n2, n3)) {
            this.var_int_e = (this.var_int_e + 1) % by2;
            this.var_boolean_g = true;
        } else if (n2 == 6 || n2 == 8 || n3 == 56 || n3 == 53) {
            this.var_byte_a = 0;
            this.var_boolean_e = false;
        } else {
            return false;
        }
        return true;
    }

    protected final boolean b(int n2, int n3, byte by2) {
        if (n.h(n2, n3)) {
            this.j = (byte)((this.j + by2 - 1) % by2);
        } else if (n.i(n2, n3)) {
            this.j = (byte)((this.j + 1) % by2);
        } else if (n2 == 6 || n3 == 56) {
            this.var_boolean_f = false;
            this.var_boolean_e = true;
        } else {
            return false;
        }
        return true;
    }

    protected final void a(cm cm2, int n2, int n3, byte by2) {
        int n4;
        int n5;
        if (this.var_boolean_g) {
            this.a();
        }
        by2 = (byte)(by2 >> 1);
        this.void_a(cm2, false, true, true, false);
        int n6 = rpg.a.c - 70;
        cm2.a(0);
        cm2.a(n6, n2, 140, 16);
        if (!this.var_boolean_e) {
            n.a(cm2, n6 - 4, n2 + 7, 148, 0, false);
        }
        cm2.a(14597755);
        ac.a(cm2, rpg.a.c, n2 + 1, ax.var_ch_a.a(20 + this.var_int_e), 0, 1);
        cm2.a(15723216);
        cm2.e(this.a_, n3 + 1, this.a_ + rpg.d.e_ - 1, n3 + 1);
        cm2.e(this.a_, n3 + 120, this.a_ + rpg.d.e_ - 1, n3 + 120);
        for (n6 = 0; n6 < by2; ++n6) {
            for (n5 = 0; n5 < var_byte_f; ++n5) {
                n2 = (byte)(n5 + n6 * var_byte_f);
                n2 = this.a((byte)n2, true);
                this.a(cm2, this.a_ + 2 + n5 * (rpg.d.e_ >> 1), n3 + 10 + n6 * 29, (byte)n2, true);
            }
        }
        if (this.var_int_e != 2) {
            n6 = n3 + 1 + by2 * 30;
            cm2.a(3550755);
            cm2.a(this.a_, n6, rpg.d.e_, 30 * (4 - by2) - 1);
            n5 = 4 - by2;
            for (n6 = 0; n6 < n5; ++n6) {
                for (n4 = 0; n4 < var_byte_f; ++n4) {
                    n2 = (byte)(n4 + n6 * var_byte_f);
                    n2 = this.a((byte)n2, false);
                    this.a(cm2, this.a_ + 2 + n4 * (rpg.d.e_ >> 1), n3 + 10 + (n6 + by2) * 29, (byte)n2, this.boolean_a((byte)n2));
                }
            }
        }
        if (this.var_boolean_i) {
            n6 = this.a_ + rpg.d.e_ - 30 - 1;
            n4 = this.b_ + 174 - 10 - 1;
            cm2.a(3550755);
            cm2.a(n6, n4, 30, 10);
            cm2.a(rpg.e.var_cg_arr_c[1], n6 + 4, n4 + 1, 20);
            n.b(cm2, this.var_do_a.var_short_b, n6 + 30 - 4, n4 + 1, 8, 0);
        }
    }

    protected final void b(cm cm2) {
        int n2 = this.b_ + 13;
        if (this.var_boolean_e) {
            int n3 = rpg.a.c - 70;
            n.a(cm2, n3 - 4, n2 + 5, 148, this.var_boolean_e ? n.var_int_arr_b[this.var_byte_e] : 0, false);
            cm2.d(n3 + 1, n2 + 1, 137, 13);
            return;
        }
        if (this.var_boolean_f) {
            int n4 = this.a_ + 1;
            int n5 = this.b_ + 174 - 14 - 2;
            cm2.a(n.var_int_arr_b[this.var_byte_e]);
            cm2.d(n4, n5, 60, 14);
            return;
        }
        int n6 = this.var_byte_a / var_byte_f;
        int n7 = this.var_byte_a % var_byte_f;
        int n8 = n7 == 0 ? 0 : 4;
        n7 = this.a_ + 2 + (n7 * this.var_byte_h + n8);
        n2 = n2 + 16 + 10 + n6 * 29;
        bp.a(cm2, n7, n2, this.var_byte_h, (byte)14, (byte)(this.var_byte_i + 2), (byte)4, n.var_int_arr_b[this.var_byte_e]);
    }

    protected static void a(cm cm2, int n2, int n3, byte by2, byte by3, byte by4, byte by5, int n4) {
        by3 = (byte)(n2 + (by2 - by4 >> 1));
        int n5 = n3 + 14 - 1;
        cm2.a(n4);
        by2 = (byte)(by2 - 1);
        n4 = by4 - 1;
        cm2.e(n2, n3, n2 + by2, n3);
        cm2.e(by3, n5 + by5, by3 + n4, n5 + by5);
        for (int i2 = 0; i2 < 2; ++i2) {
            cm2.e(n2 + i2 * by2, n3, n2 + i2 * by2, n5);
            cm2.e(by3 + i2 * n4, n5, by3 + i2 * n4, n5 + by5 - 1);
        }
        cm2.e(n2, n5, by3, n5);
        cm2.e(by3 + by4, n5, n2 + by2, n5);
    }

    private void a(cm cm2, int n2, int n3, byte by2, boolean by3) {
        byte by4;
        int n4 = n2 + (this.var_byte_h - this.var_byte_i >> 1);
        int n5 = n3 + 14;
        if (by2 == -2) {
            bp.a(cm2, n2, n3, this.var_byte_h, (byte)14, this.var_byte_i, (byte)3, 0);
            return;
        }
        cm2.a(0);
        cm2.a(n2, n3, (int)this.var_byte_h, 14);
        cm2.a(n4, n5, (int)this.var_byte_i, 3);
        if (by2 < 0) {
            return;
        }
        byte by5 = this.byte_a(by2);
        if (by5 > 0) {
            by4 = this.k == 3 ? (byte)7 : 4;
            cm2.a(by3 != 0 ? 16755968 : 9531436);
            for (by3 = 0; by3 < by5; by3 = (byte)(by3 + 1)) {
                cm2.a(n4 + 1 + by3 * (by4 + 1), n5, (int)by4, 2);
            }
        } else {
            if (by5 == -1) {
                cm2.a(rpg.e.var_cg_h, n2 + (this.var_byte_h >> 1), n3 + 1, 17);
                return;
            }
            if (by5 < -1) {
                return;
            }
        }
        cm2.a(by5 > 0 ? 0xFFFFFF : 0x7F7F7F);
        by4 = this.byte_b(by2);
        by2 = (byte)(n2 + (this.var_byte_h >> 1));
        if (this.var_int_e == 0) {
            this.a(cm2, by4, n2 + 1, n3 + 1);
            rpg.a.a(cm2);
            by2 = (byte)(by2 + 7);
        }
        ac.a(cm2, (int)by2, n3, this.var_ch_a.a(by4 << 1), 1, 1);
    }

    protected final void a(cm cm2, byte by2) {
        int n2 = this.a_ + 1;
        int n3 = this.b_ + 174 - 14 - 1;
        cm2.a(3550755);
        cm2.a(n2, n3, 60, 14);
        cm2.a(14597755);
        ac.a(cm2, n2 + 29, n3, rpg.e.var_ch_b.a(4), 0);
        this.a(cm2, n2 + 8, n3 + 1, this.j + 1, by2, 4);
        n.a(cm2, n2 + 2, n3 + 4, 56, 0xFFFFFF, false);
    }

    protected final void a(byte[][] byArray) {
        int n2 = this.var_int_e == 2 ? (this.var_byte_a % 2 == 1 ? 8 : 4) : (this.var_byte_a % 2 == 0 ? 8 : 4);
        this.var_n_b = new dj(this, byArray, n2);
    }

    protected final void a(byte by2, byte by3, boolean bl2, boolean bl3) {
        if (bl2) {
            by2 = (byte)(by2 - 4);
        }
        this.var_n_b = new dz(this, by2, (byte)this.var_int_e, by3, bl3 ? (byte)3 : 5);
    }

    protected byte byte_b(byte by2) {
        return by2;
    }

    protected final boolean a(int n2, int n3, int n4, boolean bl2) {
        if (n3 == 50 || n2 == 1) {
            if (this.var_byte_a == 0 || this.var_byte_a == 1) {
                this.var_boolean_e = true;
            } else {
                this.var_byte_a = (byte)(this.var_byte_a - 2);
            }
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            if (this.var_byte_a >= n4 - 2) {
                if (bl2) {
                    this.var_boolean_f = true;
                } else {
                    this.var_boolean_e = true;
                }
            } else {
                this.var_byte_a = (byte)(this.var_byte_a + var_byte_f);
            }
            return true;
        }
        return false;
    }

    protected final boolean a(boolean bl2, byte by2) {
        int n2;
        byte by3 = this.var_byte_a < by2 ? (byte)1 : 0;
        byte by4 = (byte)(by3 != 0 ? this.var_byte_a : this.var_byte_a - by2);
        if ((by3 = this.a(by4, by3 != 0)) < 0) {
            return true;
        }
        by4 = this.byte_a(by3);
        if (by4 < 0) {
            return true;
        }
        int n3 = n2 = bl2 ? 2 : 0;
        if (this.var_byte_a < by2) {
            if (this.var_boolean_i && by4 < this.k) {
                this.a(ax.var_ch_a.a(24, 28, 25));
            } else {
                this.a(ax.var_ch_a.a(28, 25));
            }
        } else if (this.var_boolean_i && by4 < this.k) {
            if (by4 == 0) {
                this.a(ax.var_ch_a.a(24, 25));
            } else {
                this.a(ax.var_ch_a.a(24, n2 + 29, n2 + 30, 25));
            }
        } else if (by4 == 0) {
            this.a(by3, by4, !bl2, !bl2);
        } else {
            this.a(ax.var_ch_a.a(n2 + 29, n2 + 30, 25));
        }
        return true;
    }

    protected final void a(byte by2, byte by3, byte by4, byte by5, boolean bl2) {
        if (this.var_byte_a < by5) {
            if (this.var_boolean_i && by4 < this.k) {
                if (by2 == 0) {
                    this.c(by3);
                    return;
                }
                if (by4 > 0 && by2 == 1) {
                    di.void_a(this.var_byte_a, bl2);
                    return;
                }
                this.a(by3, by4, bl2, bl2);
                return;
            }
            if (by2 == 0) {
                di.void_a(this.var_byte_a, bl2);
                return;
            }
            this.a(by3, by4, bl2, bl2);
            return;
        }
        if (this.var_boolean_i && by4 < this.k) {
            if (by2 == 0) {
                this.c(by3);
                return;
            }
            if (by4 > 0 && (by2 == 1 || by2 == 2)) {
                di.d(by2 - 1 + (bl2 ? 0 : 2), by3);
                return;
            }
            this.a(by3, by4, bl2, bl2);
            return;
        }
        if (by2 == 0 || by2 == 1) {
            di.d(by2 + (bl2 ? 0 : 2), by3);
            return;
        }
        this.a(by3, by4, bl2, bl2);
    }

    protected final void b(byte by2, byte by3, byte by4, byte by5, boolean bl2) {
        if (this.var_byte_a < by5) {
            if (this.var_boolean_i && by4 < this.k) {
                if (by2 == 0) {
                    this.c(by3);
                    return;
                }
                if (by2 == 1) {
                    this.h();
                    return;
                }
                this.a(by3, by4, false, bl2);
                return;
            }
            if (by2 == 0) {
                this.h();
                return;
            }
            this.a(by3, by4, false, bl2);
            return;
        }
        if (this.var_boolean_i && by4 < this.k) {
            if (by2 == 0) {
                this.c(by3);
                return;
            }
            if (by4 > 0 && by2 > 0 && by2 <= by5) {
                this.b((byte)(by2 - 1), by3);
                return;
            }
            this.a(by3, by4, false, bl2);
            return;
        }
        if (by2 >= 0 && by2 <= by5 - 1) {
            this.b(by2, by3);
            return;
        }
        this.a(by3, by4, false, bl2);
    }

    protected final void i() {
        this.var_do_a.var_short_b = (short)(this.var_do_a.var_short_b - 1);
        this.var_boolean_i = this.var_do_a.var_short_b > 0;
        this.var_boolean_h = true;
    }

    static {
        var_byte_arr_a = new byte[]{8, 8, 2};
        var_byte_f = (byte)2;
        var_byte_g = (byte)(4 * var_byte_f);
    }
}

