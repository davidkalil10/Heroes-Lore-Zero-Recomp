/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.g;

public final class cc
extends bo {
    private byte g = 0;
    private byte[] var_byte_arr_b = null;
    private byte h = 1;
    private byte i = 0;
    private byte j = 0;
    private static bj[] var_bj_arr_a;
    private boolean e;
    private as var_as_a = null;
    private ch var_ch_b = new ch("/t/ni");

    public cc(n n2) {
        super(n2);
        this.a();
        cc.var_bj_arr_a[1] = di.bj_a((byte)0);
        this.e = false;
    }

    private void a() {
        this.g = 0;
        this.d();
        this.var_n_b = new bt(this, this.var_ch_b.a(0), this.var_ch_b.a(1, 2));
    }

    public final void d() {
        super.d();
        rpg.a.var_boolean_a = true;
    }

    private void g() {
        this.var_byte_arr_b = this.var_ch_b.a(3 + this.h);
    }

    private static void a(byte by2, int n2) {
        for (int i2 = 0; i2 <= n2; ++i2) {
            var_bj_arr_a[0].a(as.a(by2, (byte)i2), 1);
        }
    }

    private void h() {
        cc.var_bj_arr_a[0] = null;
        cc.var_bj_arr_a[0] = new bj(28);
        switch (this.h) {
            case 0: {
                this.j = (byte)5;
                if (this.i > this.j) {
                    this.i = (byte)(this.j - 1);
                }
                if (this.i == 0) {
                    cc.a((byte)0, 13);
                    cc.a((byte)1, 13);
                    return;
                }
                if (this.i == 1) {
                    cc.a((byte)2, 13);
                    cc.a((byte)3, 13);
                    return;
                }
                if (this.i == 2) {
                    cc.a((byte)4, 13);
                    return;
                }
                if (this.i == 3) {
                    cc.a((byte)5, 13);
                    return;
                }
                cc.a((byte)6, 13);
                return;
            }
            case 1: {
                this.j = (byte)5;
                if (this.i > this.j) {
                    this.i = (byte)(this.j - 1);
                }
                if (this.i == 0) {
                    cc.a((byte)10, 13);
                    return;
                }
                if (this.i == 1) {
                    cc.a((byte)12, 13);
                    cc.a((byte)13, 13);
                    return;
                }
                if (this.i == 2) {
                    cc.a((byte)8, 13);
                    cc.a((byte)9, 13);
                    return;
                }
                if (this.i == 3) {
                    cc.a((byte)14, 13);
                    cc.a((byte)15, 13);
                    return;
                }
                cc.a((byte)7, 13);
                return;
            }
            case 2: {
                this.j = (byte)3;
                if (this.i > this.j) {
                    this.i = (byte)(this.j - 1);
                }
                if (this.i == 0) {
                    cc.a((byte)20, 8);
                    return;
                }
                if (this.i == 1) {
                    cc.a((byte)16, 11);
                    return;
                }
                cc.a((byte)17, 15);
                return;
            }
            case 3: {
                this.j = (byte)3;
                if (this.i > this.j) {
                    this.i = (byte)(this.j - 1);
                }
                if (this.i == 0) {
                    cc.var_bj_arr_a[1] = di.bj_a((byte)0);
                    return;
                }
                if (this.i == 1) {
                    cc.var_bj_arr_a[1] = di.bj_a((byte)18);
                    return;
                }
                cc.var_bj_arr_a[1] = di.bj_a((byte)19);
            }
        }
    }

    private void a(as as2, byte by2) {
        as2 = as.a(as2.var_byte_a, as2.var_byte_b);
        if (di.bj_a(as2.var_byte_a).a(as2, (int)by2) <= 0) {
            this.f = (byte)15;
            this.var_byte_arr_a = this.var_ch_a.a(6);
            return;
        }
        this.f = (byte)15;
        this.var_byte_arr_a = this.var_ch_b.a(21);
        di.e(0 - as2.var_int_a * by2);
    }

    final void void_a(byte by2, byte by3) {
        this.c();
        this.d();
        if (by2 == -1 && by3 == -1) {
            this.f = (byte)15;
            this.var_byte_arr_a = this.var_ch_b.a(20);
            return;
        }
        if (by2 == -2 && by3 == -2) {
            by3 = 0;
        }
        if (this.g == 0) {
            this.g = 1;
            this.e = false;
            this.i = 0;
            this.var_byte_a = 0;
            this.h = by3 == 0 ? (byte)0 : (byte)3;
            this.g();
            this.h();
            return;
        }
        if (this.g == 2) {
            if (by3 == 0) {
                if (this.h < 3) {
                    if (di.var_int_e < this.var_as_a.var_int_a) {
                        if (eb.var_boolean_f) {
                            this.f = (byte)15;
                            this.var_byte_arr_a = this.var_ch_b.a(20);
                        } else {
                            this.f = (byte)15;
                            this.var_byte_arr_a = this.var_ch_b.a(20);
                        }
                    } else if (this.var_as_a.var_byte_a == 20) {
                        this.var_n_b = new cp(this, 99, 1, this.var_as_a.var_int_a, true, this.var_ch_a.a(7));
                        this.g = (byte)3;
                    } else {
                        this.a(this.var_as_a, (byte)1);
                    }
                } else {
                    if (this.var_as_a.c > 1) {
                        this.var_n_b = new cp(this, this.var_as_a.c, 1, this.var_as_a.var_int_a / 10, false, this.var_ch_a.a(7));
                        this.g = (byte)3;
                    } else {
                        di.bj_a(this.var_as_a.var_byte_a).b(this.var_as_a.var_byte_a, this.var_as_a.var_byte_b, 1);
                        di.e(this.var_as_a.var_int_a / 10);
                        this.f = (byte)15;
                        this.var_byte_arr_a = this.var_ch_b.a(22);
                    }
                    if (this.var_as_a.var_byte_a == 20) {
                        bs.var_boolean_d = true;
                    }
                }
                this.d();
            }
            return;
        }
        if (this.g == 3) {
            if (by3 > 0) {
                if (this.h < 3) {
                    this.a(this.var_as_a, by3);
                } else {
                    di.bj_a(this.var_as_a.var_byte_a).b(this.var_as_a.var_byte_a, this.var_as_a.var_byte_b, by3);
                    while (by3 > 0) {
                        di.e(this.var_as_a.var_int_a / 10);
                        by3 = (byte)(by3 - 1);
                    }
                    this.f = (byte)15;
                    this.var_byte_arr_a = this.var_ch_b.a(22);
                }
                bs.var_boolean_d = true;
                this.d();
            }
            return;
        }
        df.void_e();
        this.d();
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.f > 0) {
            this.f = 0;
            this.var_byte_arr_a = null;
            bs.var_boolean_c = true;
            return true;
        }
        if (n.g(n2, n3)) {
            bs.var_boolean_c = true;
            if (this.g == 0) {
                if (this.var_n_a != null) {
                    this.var_n_a.c();
                    return true;
                }
                df.void_e();
                this.d();
                return true;
            }
            if (this.g == 2 || this.g == 3) {
                if (this.var_n_b != null && this.var_n_b instanceof bw && this.b(n2, n3)) {
                    return true;
                }
                this.g = 1;
                this.c();
                return true;
            }
        }
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            this.a();
            this.d();
            return true;
        }
        if (n3 == 49) {
            if (this.h < 3) {
                this.h = (byte)((this.h + 3 - 1) % 3);
            }
            this.h();
            this.g();
            return true;
        }
        if (n3 == 51) {
            if (this.h < 3) {
                this.h = (byte)((this.h + 1) % 3);
            }
            this.h();
            this.g();
            return true;
        }
        if (this.e) {
            if (n.i(n2, n3)) {
                this.e = false;
            } else if (n2 == 1 || n3 == 50) {
                this.i = (byte)((this.i + this.j - 1) % this.j);
                this.h();
            } else if (n2 == 6 || n3 == 56) {
                this.i = (byte)((this.i + 1) % this.j);
                this.h();
            }
        } else {
            if (n.f(n2, n3)) {
                this.var_as_a = var_bj_arr_a[this.h < 3 ? 0 : 1].as_a(this.var_byte_a);
                if (this.var_as_a == null) {
                    return true;
                }
                if (this.var_as_a.c()) {
                    this.f = (byte)15;
                    this.var_byte_arr_a = this.var_ch_b.a(23);
                    this.d();
                } else {
                    byte[][] byArrayArray = new byte[2][];
                    byte[][] byArrayArray2 = byArrayArray;
                    byArrayArray[0] = rpg.d.l;
                    byArrayArray2[1] = rpg.d.m;
                    byte[] byArray = this.var_ch_b.a(this.h < 3 ? 18 : 19);
                    if (this.h < 3 && this.var_as_a instanceof bm && !dp.boolean_a(this.var_as_a)) {
                        byArray = rpg.g.a(rpg.d.v, byArray);
                    }
                    this.var_n_b = new bt(this, byArray, byArrayArray2);
                    this.g = (byte)2;
                    this.d();
                }
                bs.var_boolean_c = true;
                return true;
            }
            this.e(n2, n3);
            if (this.var_byte_a % this.var_byte_c == 0 && this.j > 1 && n.h(n2, n3)) {
                this.e = true;
                return true;
            }
            this.d(n2, n3);
        }
        return true;
    }

    protected final void a(cm cm2) {
        di.var_g_a.c();
        n.a(cm2, 3);
        if (this.g == 0) {
            return;
        }
        this.a(cm2, false, true, this.var_byte_arr_b, this.h < 3);
        if (this.h < 3) {
            this.a(cm2, this.j, this.i, this.e);
        } else {
            this.a(cm2, this.i, this.e, (int)this.j, true);
        }
        int n2 = this.b_ + 80;
        int n3 = this.a_ + 8;
        n.a(cm2, this.a_, n2, 15);
        this.a(cm2, var_bj_arr_a[this.h < 3 ? 0 : 1]);
        int n4 = this.b_ + 174 - 11;
        as as2 = var_bj_arr_a[this.h < 3 ? 0 : 1].as_a(this.var_byte_a);
        if (!this.e) {
            this.b(cm2);
        }
        if (as2 != null) {
            this.a(cm2, this.a_, n2 + 2, as2);
        }
        cm2.a(3550755);
        cm2.a(n3, n4, 55, 11);
        cm2.a(n3 + 1, n4 - 1, 53, 1);
        if (as2 != null) {
            this.b(cm2, n3 + 55 - 4, n4 + 2, this.h >= 3 ? as2.var_int_a / 10 : as2.var_int_a);
        }
        cm2.b(this.a_, this.b_, rpg.d.e_, 174);
        cm2.a(3550755);
        this.b(cm2, this.a_ + 111, n4 + 2, di.var_int_e);
        if (this.f > 0) {
            bo.a(cm2, this.a_, this.b_, this.var_byte_arr_a, 1);
            this.d();
        }
    }

    static {
        var_bj_arr_a = new bj[2];
    }
}

