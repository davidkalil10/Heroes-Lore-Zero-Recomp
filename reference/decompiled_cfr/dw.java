/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;

public final class dw
extends bo {
    private static final int var_int_e;
    private as var_as_a = null;
    private int f = 0;
    private int j = 0;
    private int k = 0;
    private boolean var_boolean_e = false;
    private byte g = 0;
    private bj var_bj_a = null;
    private long var_long_a = 0L;
    private byte[] var_byte_arr_b = null;
    private ch var_ch_b = new ch("/t/nb");

    public dw(n n2) {
        super(null);
        this.var_bj_a = di.bj_a();
        this.var_byte_arr_b = this.var_ch_b.a(0);
        this.k = di.bj_a((byte)20).int_a((byte)20, (byte)0);
        bs.var_boolean_c = true;
    }

    protected final boolean boolean_a(as as2) {
        if (as2 != null) {
            return as2.b();
        }
        return false;
    }

    private static int int_a(as as2) {
        as2 = (bm)as2;
        for (int i2 = 0; i2 < ((bm)as2).var_byte_arr_c.length && ((bm)as2).var_byte_arr_c[i2] != -3; ++i2) {
            if (((bm)as2).var_byte_arr_c[i2] != -2) continue;
            return (i2 + 1) * (i2 + 1);
        }
        return -1;
    }

    private static int b(as as2) {
        as2 = (bm)as2;
        for (int i2 = 0; i2 < ((bm)as2).var_byte_arr_c.length && ((bm)as2).var_byte_arr_c[i2] != -3; ++i2) {
            if (((bm)as2).var_byte_arr_c[i2] != -2) continue;
            return (i2 + 1) * 100 * (((bm)as2).e + 1);
        }
        return -1;
    }

    final void void_a(byte by2, byte by3) {
        this.c();
        this.d();
        if (by2 == -1 && by3 == -1) {
            ((bo)this).f = (byte)15;
            this.var_byte_arr_a = this.var_ch_a.a(5);
            return;
        }
        if (by2 == -2 && by3 == -2) {
            if (this.f > di.var_int_e) {
                if (eb.var_boolean_f) {
                    ((bo)this).f = (byte)15;
                    this.var_byte_arr_a = this.var_ch_a.a(5);
                    return;
                }
                ((bo)this).f = (byte)15;
                this.var_byte_arr_a = this.var_ch_a.a(5);
                return;
            }
            if (this.j > this.k) {
                ((bo)this).f = (byte)15;
                this.var_byte_arr_a = this.var_ch_b.a(4);
                return;
            }
            bm bm2 = (bm)this.var_as_a;
            by3 = 0;
            for (int i2 = 0; i2 < bm2.var_byte_arr_c.length; ++i2) {
                if (bm2.var_byte_arr_c[i2] != -2) continue;
                by3 = 1;
            }
            if (by3 != 0) {
                this.var_long_a = 15L;
                this.var_byte_arr_a = this.var_ch_b.a(5);
                return;
            }
            ((bo)this).f = (byte)15;
            this.var_byte_arr_a = this.var_ch_a.a(8);
        }
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.var_n_b != null && this.var_n_b instanceof bw && this.b(n2, n3)) {
            return true;
        }
        if (this.var_long_a > 0L) {
            return true;
        }
        if (((bo)this).f > 0) {
            this.var_byte_arr_a = null;
            this.var_long_a = 0L;
            ((bo)this).f = 0;
            this.d();
            return true;
        }
        this.d();
        if (this.var_boolean_e) {
            if (n.g(n2, n3)) {
                this.var_boolean_e = false;
                return true;
            }
            if (n.f(n2, n3)) {
                this.var_as_a = this.var_bj_a.as_a(this.var_byte_a);
                if (!this.boolean_a(this.var_as_a)) {
                    this.var_as_a = null;
                    return true;
                }
                if (this.var_as_a != null) {
                    this.f = dw.b(this.var_as_a);
                    this.j = dw.int_a(this.var_as_a);
                }
                this.var_boolean_e = false;
                return true;
            }
            this.d(n2, n3);
            this.e(n2, n3);
        } else {
            if (n3 == 50 || n2 == 1) {
                this.g = (byte)((this.g + 1) % 2);
            } else if (n3 == 56 || n2 == 6) {
                this.g = (byte)((this.g + 1) % 2);
            }
            if (n.f(n2, n3)) {
                if (this.g == 0) {
                    this.var_boolean_e = true;
                } else if (this.var_as_a == null) {
                    ((bo)this).f = (byte)15;
                    this.var_byte_arr_a = this.var_ch_b.a(6);
                } else if (this.f > di.var_int_e) {
                    if (eb.var_boolean_f) {
                        ((bo)this).f = (byte)15;
                        this.var_byte_arr_a = this.var_ch_a.a(5);
                    } else {
                        ((bo)this).f = (byte)15;
                        this.var_byte_arr_a = this.var_ch_a.a(5);
                    }
                } else if (this.j > this.k) {
                    ((bo)this).f = (byte)15;
                    this.var_byte_arr_a = this.var_ch_b.a(4);
                } else {
                    bm bm2 = (bm)this.var_as_a;
                    n3 = 0;
                    for (int i2 = 0; i2 < bm2.var_byte_arr_c.length; ++i2) {
                        if (bm2.var_byte_arr_c[i2] != -2) continue;
                        n3 = 1;
                    }
                    if (n3 != 0) {
                        this.var_long_a = 15L;
                        this.var_byte_arr_a = this.var_ch_b.a(5);
                    } else {
                        ((bo)this).f = (byte)15;
                        this.var_byte_arr_a = this.var_ch_a.a(8);
                    }
                }
            } else if (n.g(n2, n3)) {
                df.void_e();
                bs.var_boolean_c = true;
            }
        }
        return true;
    }

    public final void d() {
        super.d();
        rpg.a.var_boolean_a = true;
    }

    protected final void a(cm cm2) {
        int n2;
        di.var_g_a.c();
        this.a(cm2, false, true, this.var_byte_arr_b, false);
        n.a(cm2, 3);
        if (this.var_boolean_e) {
            this.a(cm2, (byte)0, false, 1, true);
            int n3 = this.b_ + 80;
            n.a(cm2, this.a_, n3, 15);
            this.a(cm2, this.var_bj_a);
            n2 = this.b_ + 174 - 11;
            this.b(cm2);
            as as2 = this.var_bj_a.as_a(this.var_byte_a);
            if (as2 != null) {
                this.a(cm2, this.a_, n3 + 2, as2);
            }
            cm2.b(this.a_, this.b_, rpg.d.e_, 174);
            cm2.a(3550755);
            this.b(cm2, this.a_ + 111, n2 + 2, di.var_int_e);
        } else {
            n.c(cm2, this.a_ + (rpg.d.e_ - 14 >> 1), this.b_ + 15, 14, 14, 0);
            if (this.var_as_a != null) {
                this.var_as_a.a(cm2, this.a_ + (rpg.d.e_ - 14 >> 1), this.b_ + 15);
            }
            if (this.g == 0) {
                bo.b(cm2, this.a_ + (rpg.d.e_ - 14 >> 1), this.b_ + 15);
            }
            n.a(cm2, this.a_, this.b_ + 31, 15);
            this.a(cm2, this.a_, this.b_ + 31 + 2, this.var_as_a);
            this.a(cm2, this.a_, this.b_ + 31 + 2 + 80, this.var_ch_b.a(1), this.k, this.j);
            this.a(cm2, this.a_, this.b_ + 31 + 2 + 80 + 15, this.var_ch_b.a(2), di.var_int_e, this.f);
            this.a(cm2, this.a_ + 3, this.b_ + 174 - 16, rpg.d.e_ - 6, this.var_ch_b.a(3), this.g == 1);
        }
        if (this.var_long_a > 0L || ((bo)this).f > 0) {
            if (this.var_long_a == 1L) {
                int n4;
                block10: {
                    as as3 = this.var_as_a;
                    as3 = (bm)as3;
                    for (n2 = 0; n2 < ((bm)as3).var_byte_arr_c.length && ((bm)as3).var_byte_arr_c[n2] != -3; ++n2) {
                        if (((bm)as3).var_byte_arr_c[n2] != -2) continue;
                        ((bm)as3).var_byte_arr_c[n2] = -1;
                        n4 = 0;
                        break block10;
                    }
                    n4 = 5;
                }
                int n5 = n4;
                this.var_byte_arr_a = this.var_ch_a.a(n5 + 3);
                di.bj_a((byte)20).b((byte)20, (byte)0, this.j);
                this.k = di.bj_a((byte)20).int_a((byte)20, (byte)0);
                di.var_int_e -= this.f;
                this.f = dw.b(this.var_as_a);
                this.j = dw.int_a(this.var_as_a);
                this.var_long_a = 0L;
                ((bo)this).f = (byte)15;
            } else if (this.var_long_a > 0L) {
                --this.var_long_a;
            }
            bo.a(cm2, this.a_, this.b_, this.var_byte_arr_a, 1);
            this.d();
        }
    }

    private void a(cm cm2, int n2, int n3, byte[] byArray, int n4, int n5) {
        n.c(cm2, n2 + 3, n3, 120, 14, 3550755);
        cm2.a(15723216);
        ac.a(cm2, n2 + 3 + 2, n3, byArray, 0);
        if (n5 > 0) {
            cm2.a(n4 < n5 ? 0xFF0000 : 15723216);
            n.b(cm2, n4, n2 + 80 + 30, n3 + 2, 8, 0);
        } else {
            ac.a(cm2, n2 + 80 + 30, n3 + 2, this.var_ch_a.a(2), 0, 8);
        }
        n.c(cm2, n2 + 3 + 80 + 42, n3, var_int_e - 42, 14, 3550755);
        cm2.a(15723216);
        if (n5 > 0) {
            n.b(cm2, n5, n2 + 3 + 80 + 2 + var_int_e - 3, n3 + 2, 8, 0);
            return;
        }
        ac.a(cm2, n2 + 3 + 80 + 2 + var_int_e - 3, n3 + 2, this.var_ch_a.a(2), 0, 8);
    }

    static {
        var_int_e = rpg.d.e_ - 80 - 6 - 2;
    }
}

