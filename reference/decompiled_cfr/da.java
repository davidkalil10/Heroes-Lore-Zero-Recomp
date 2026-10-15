/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;

public final class da
extends bo {
    private static final int var_int_e;
    private byte g = 0;
    private byte h = 0;
    private boolean var_boolean_e = false;
    private byte i = 0;
    private bj var_bj_a = null;
    private as var_as_a = null;
    private bm var_bm_a = null;
    private dv var_dv_a = null;
    private byte j = 0;
    private int[] d = new int[3];
    private as[] var_as_arr_a = new as[3];
    private as[] var_as_arr_b = new as[6];
    private byte[] var_byte_arr_b = null;
    private ch var_ch_b;
    private boolean var_boolean_f = false;
    private int var_int_f = 30;

    public da(n n2, boolean bl2) {
        super(n2);
        int n3;
        this.var_boolean_f = true;
        try {
            this.var_ch_b = new ch("/t/ne");
        }
        catch (Exception exception) {}
        this.g = 1;
        this.d();
        this.h = (byte)2;
        this.i = 0;
        this.var_bm_a = null;
        this.var_dv_a = null;
        for (n3 = 0; n3 < 6; ++n3) {
            this.var_as_arr_b[n3] = null;
        }
        for (n3 = 0; n3 < 3; ++n3) {
            this.var_as_arr_a[n3] = null;
        }
        this.var_bj_a = this.h == 1 ? di.bj_a() : di.bj_c();
        this.var_byte_arr_b = this.var_ch_b.a(0 + this.h);
        this.var_boolean_e = false;
        this.d();
    }

    public da(n n2) {
        super(null);
        try {
            this.var_ch_b = new ch("/t/ne");
        }
        catch (Exception exception) {}
        this.g = 0;
        this.var_n_b = new bt(this, this.var_ch_b.a(0), this.var_ch_b.a(1, 2));
        this.d();
    }

    public final void d() {
        super.d();
        rpg.a.var_boolean_a = true;
    }

    protected final boolean boolean_a(as as2) {
        if (this.h == 1) {
            if (as2 != null) {
                if (this.i == 0) {
                    return as2.b();
                }
                if (as2.var_byte_a == 17) {
                    return true;
                }
            }
        } else if (this.h == 2 && as2 != null && as2.var_byte_a == 18) {
            return true;
        }
        return false;
    }

    private byte a(boolean n2) {
        if (n2 != 0) {
            if (this.i <= 0) {
                return 7;
            }
            if (this.var_bm_a == null) {
                if (this.i >= 7) {
                    return 0;
                }
                return 7;
            }
            if (this.i == 1) {
                return 0;
            }
            for (n2 = (int)((byte)(this.i - 2)); n2 >= 0; n2 = (int)((byte)(n2 - 1))) {
                if (this.var_bm_a.var_byte_arr_c[n2] != -1) continue;
                return (byte)(n2 + 1);
            }
            return 0;
        }
        if (this.i >= 7) {
            return 0;
        }
        if (this.var_bm_a == null) {
            if (this.i == 0) {
                return 7;
            }
            return 0;
        }
        for (n2 = this.i; n2 < 6; n2 = (int)((byte)(n2 + 1))) {
            if (this.var_bm_a.var_byte_arr_c[n2] != -1) continue;
            return (byte)(n2 + 1);
        }
        return 7;
    }

    final void void_a(byte by2, byte by3) {
        if (this.g == 0) {
            this.c();
            this.g = 1;
            this.d();
            this.h = (byte)(by3 + 1);
            this.i = 0;
            this.var_bm_a = null;
            this.var_dv_a = null;
            for (by2 = 0; by2 < 6; by2 = (byte)(by2 + 1)) {
                this.var_as_arr_b[by2] = null;
            }
            for (by2 = 0; by2 < 3; by2 = (byte)(by2 + 1)) {
                this.var_as_arr_a[by2] = null;
            }
            this.var_bj_a = this.h == 1 ? di.bj_a() : di.bj_c();
            this.var_byte_arr_b = this.var_ch_b.a(0 + this.h);
            this.var_boolean_e = false;
            return;
        }
        if (by2 == -1 && by3 == -1 && this.var_n_b instanceof bw) {
            this.c();
            this.d();
            return;
        }
        this.c();
        df.void_e();
        this.d();
    }

    /*
     * Enabled aggressive block sorting
     */
    final boolean boolean_a(int n2, int n3) {
        block55: {
            block54: {
                if (this.j > 0) {
                    return true;
                }
                if (((bo)this).f > 0) {
                    return true;
                }
                if (n.g(n2, n3)) {
                    if (this.g == 0) {
                        df.void_e();
                        this.d();
                        return true;
                    }
                    if (this.g == 1) {
                        if (this.var_boolean_e) {
                            this.var_boolean_e = false;
                            this.d();
                        } else {
                            if (this.var_n_b != null && this.var_n_b instanceof bw && this.b(n2, n3)) {
                                return true;
                            }
                            if (this.var_boolean_f) {
                                this.var_n_a.c();
                            }
                            this.g = 0;
                            this.var_n_b = new bt(this, this.var_ch_b.a(0), this.var_ch_b.a(1, 2));
                            this.d();
                            this.var_as_a = null;
                        }
                        bs.var_boolean_c = true;
                        return true;
                    }
                }
                if (this.b(n2, n3)) {
                    return true;
                }
                if (this.var_boolean_e) {
                    if (n.g(n2, n3)) {
                        this.var_boolean_e = false;
                        return true;
                    }
                    if (!n.f(n2, n3)) {
                        this.d(n2, n3);
                        this.e(n2, n3);
                        return true;
                    }
                    this.var_as_a = this.var_bj_a.as_a(this.var_byte_a);
                    if (!this.boolean_a(this.var_as_a)) {
                        this.var_as_a = null;
                        return true;
                    }
                    this.var_boolean_e = false;
                    if (this.h == 2) {
                        if (!(this.var_as_a instanceof dv)) {
                            ((bo)this).f = (byte)15;
                            this.var_byte_arr_a = this.var_ch_b.a(8);
                            return true;
                        }
                        this.var_dv_a = (dv)this.var_as_a;
                        this.var_as_arr_a[0] = null;
                        this.var_as_arr_a[1] = null;
                        this.var_as_arr_a[2] = null;
                        if (this.var_dv_a.d[0] != -1) {
                            this.var_as_arr_a[0] = as.a(this.var_dv_a.d[0], this.var_dv_a.d[1]);
                            this.d[0] = di.bj_a(this.var_dv_a.d[0]).int_a(this.var_dv_a.d[0], this.var_dv_a.d[1]);
                        }
                        if (this.var_dv_a.d[2] != -1) {
                            this.var_as_arr_a[1] = as.a(this.var_dv_a.d[2], this.var_dv_a.d[3]);
                            this.d[1] = di.bj_a(this.var_dv_a.d[2]).int_a(this.var_dv_a.d[2], this.var_dv_a.d[3]);
                        }
                        if (this.var_dv_a.d[4] == -1) return true;
                        this.var_as_arr_a[2] = as.a(this.var_dv_a.d[4], this.var_dv_a.d[5]);
                        this.d[2] = di.bj_a(this.var_dv_a.d[4]).int_a(this.var_dv_a.d[4], this.var_dv_a.d[5]);
                        return true;
                    }
                    if (this.h != 1) return true;
                    if (this.var_as_a instanceof bm) {
                        this.var_bm_a = (bm)this.var_as_a;
                        n2 = 0;
                        while (n2 < 6) {
                            this.var_as_arr_b[n2] = null;
                            ++n2;
                        }
                        return true;
                    }
                    if (this.var_as_a.var_byte_a != 17) {
                        ((bo)this).f = (byte)15;
                        this.var_byte_arr_a = this.var_ch_b.a(9);
                        return true;
                    }
                    n2 = 0;
                    n3 = di.bj_a((byte)17).int_a((byte)17, this.var_as_a.var_byte_b);
                    this.var_as_arr_b[this.i - 1] = this.var_as_a;
                    int n4 = 0;
                    while (true) {
                        if (n4 >= 6) {
                            if (n3 >= n2) return true;
                            this.var_as_arr_b[this.i - 1] = null;
                            ((bo)this).f = (byte)15;
                            this.var_byte_arr_a = this.var_ch_b.a(11);
                            return true;
                        }
                        if (this.var_as_arr_b[n4] != null && this.var_as_arr_b[n4].var_byte_a == 17 && this.var_as_arr_b[n4].var_byte_b == this.var_as_a.var_byte_b) {
                            ++n2;
                        }
                        ++n4;
                    }
                }
                if (this.h != 1) break block54;
                if (n3 == 50 || n2 == 1) {
                    this.i = this.a(true);
                    break block55;
                } else if (n3 == 56 || n2 == 6) {
                    this.i = this.a(false);
                }
                break block55;
            }
            if (n3 == 50 || n2 == 1) {
                this.i = (byte)((this.i + 1) % 2);
            } else if (n3 == 56 || n2 == 6) {
                this.i = (byte)((this.i + 1) % 2);
            }
        }
        if (!n.f(n2, n3)) return true;
        if (this.i == 0) {
            this.var_boolean_e = true;
            this.var_bj_a = this.h == 1 ? di.bj_a() : di.bj_c();
            return true;
        }
        if (this.h == 2) {
            if (this.var_as_a == null) {
                ((bo)this).f = (byte)15;
                this.var_byte_arr_a = rpg.d.x;
                return true;
            }
            if (this.var_boolean_f) {
                da da2 = this;
                as as2 = as.a(da2.var_dv_a.c[0], da2.var_dv_a.c[1]);
                if (!di.bj_a(as2.var_byte_a).a(as2.var_byte_a, as2.var_byte_b, 1)) {
                    bw bw2 = (bw)da2.var_n_a;
                    bw2.a(da2.var_ch_a.a(6), 0, as2);
                    return true;
                }
                bw bw3 = (bw)da2.var_n_a;
                bw3.a(da2.var_ch_a.a(3), 1, as2);
                return true;
            }
            if (this.d[0] != 0 && this.d[1] != 0 && this.d[2] != 0) {
                this.j = (byte)15;
                this.var_byte_arr_a = this.var_ch_b.a(5 + (this.h - 1));
                return true;
            }
            if (!eb.var_boolean_f) {
                ((bo)this).f = (byte)15;
                this.var_byte_arr_a = this.var_ch_b.a(7);
                return true;
            }
        } else {
            if (this.h != 1) return true;
            if (this.i > 0 && this.i < 7) {
                this.var_boolean_e = true;
                this.var_bj_a = di.bj_a((byte)17);
                return true;
            }
            if (this.i != 7) return true;
            if (this.var_bm_a == null) return false;
            if (this.var_bm_a.var_byte_arr_c == null) {
                return false;
            }
            n3 = 0;
            for (n2 = 0; n2 < 6; ++n2) {
                if (this.var_bm_a.var_byte_arr_c[n2] != -1) continue;
                ++n3;
            }
            if (n3 == 0) {
                ((bo)this).f = (byte)15;
                this.var_byte_arr_a = this.var_ch_b.a(10);
                return true;
            }
            byte[] byArray = new byte[16];
            byte[] byArray2 = new byte[16];
            boolean bl2 = false;
            boolean bl3 = false;
            for (n2 = 0; n2 < 16; ++n2) {
                byArray[n2] = 0;
                byArray2[n2] = 0;
            }
            for (n2 = 0; n2 < 6; ++n2) {
                if (this.var_bm_a.var_byte_arr_c[n2] >= 0) {
                    byte by2 = this.var_bm_a.var_byte_arr_c[n2];
                    byArray[by2] = (byte)(byArray[by2] + 1);
                    continue;
                }
                if (this.var_as_arr_b[n2] == null) continue;
                byte by3 = this.var_as_arr_b[n2].var_byte_b;
                byArray2[by3] = (byte)(byArray2[by3] + 1);
                bl3 = true;
            }
            for (n2 = 0; n2 < 6; ++n2) {
                if (byArray2[n2] <= 1) continue;
                bl2 = true;
            }
            for (n2 = 0; n2 < 16; ++n2) {
                if (byArray2[n2] <= 0 || byArray[n2] <= 0) continue;
                bl2 = true;
            }
            if (!bl3) {
                return false;
            }
            if (bl2) {
                ((bo)this).f = (byte)15;
                this.var_byte_arr_a = this.var_ch_b.a(14);
                return true;
            }
            boolean bl4 = true;
            for (n2 = 0; n2 < 6; ++n2) {
                if (this.var_as_arr_b[n2] == null || di.bj_a(this.var_as_arr_b[n2].var_byte_a).int_a(this.var_as_arr_b[n2].var_byte_a, this.var_as_arr_b[n2].var_byte_b) > 0) continue;
                bl4 = false;
            }
            if (bl4) {
                n2 = 0;
                while (true) {
                    if (n2 >= 6) {
                        di.var_do_a.void_i();
                        ((bo)this).f = (byte)15;
                        this.var_byte_arr_a = this.var_ch_a.a(3);
                        return true;
                    }
                    if (this.var_as_arr_b[n2] != null) {
                        this.var_bm_a.var_byte_arr_c[n2] = this.var_as_arr_b[n2].var_byte_b;
                        di.bj_a(this.var_as_arr_b[n2].var_byte_a).b(this.var_as_arr_b[n2].var_byte_a, this.var_as_arr_b[n2].var_byte_b, 1);
                    }
                    this.var_as_arr_b[n2] = null;
                    ++n2;
                }
            }
        }
        ((bo)this).f = (byte)15;
        this.var_byte_arr_a = this.var_ch_b.a(7);
        return true;
    }

    protected final void a(cm cm2) {
        di.var_g_a.c();
        n.a(cm2, 3);
        if (this.g == 0) {
            return;
        }
        if (this.h != 0) {
            int n2;
            byte by2;
            this.a(cm2, false, true, this.var_byte_arr_b, false);
            if (this.var_boolean_e) {
                this.a(cm2, (byte)0, false, 1, true);
                int n3 = this.b_ + 80;
                n.a(cm2, this.a_, n3, 15);
                this.a(cm2, this.var_bj_a);
                int n4 = this.b_ + 174 - 11;
                this.b(cm2);
                as as2 = this.var_bj_a.as_a(this.var_byte_a);
                this.a(cm2, this.a_, n3 + 2, as2);
                cm2.b(this.a_, this.b_, rpg.d.e_, 174);
                cm2.a(3550755);
                this.b(cm2, this.a_ + 111, n4 + 2, di.var_int_e);
            } else {
                int n5;
                Object object;
                Object object2 = object = this.h == 1 ? this.var_bm_a : this.var_dv_a;
                if (this.var_boolean_e) {
                    object = this.var_as_a;
                }
                n.c(cm2, this.a_ + (rpg.d.e_ - 14 >> 1), this.b_ + 15, 14, 14, 0);
                if (object != null) {
                    ((as)object).a(cm2, this.a_ + (rpg.d.e_ - 14 >> 1), this.b_ + 15);
                }
                if (this.i == 0) {
                    bo.b(cm2, this.a_ + (rpg.d.e_ - 14 >> 1), this.b_ + 15);
                }
                n.a(cm2, this.a_, this.b_ + 31, 15);
                this.a(cm2, this.a_, this.b_ + 31 + 2, (as)object, this.h != 1);
                if (this.h == 1) {
                    for (int i2 = 0; i2 < 6; ++i2) {
                        byte by3 = -3;
                        if (this.var_bm_a != null) {
                            by3 = this.var_bm_a.var_byte_arr_c[i2];
                        }
                        if (this.var_as_arr_b[i2] != null) {
                            by3 = ((ba)this.var_as_arr_b[i2]).d;
                        }
                        boolean bl2 = this.i == (byte)(i2 + 1);
                        by2 = by3;
                        n2 = this.b_ + 31 + 2 + 75 + (i2 / 2 << 4);
                        n5 = this.a_ + i2 % 2 * (rpg.d.e_ >> 1);
                        cm cm3 = cm2;
                        object = this;
                        if (by2 <= -2) continue;
                        n.c(cm3, n5 + 1, n2, (rpg.d.e_ >> 1) - 2, 15, bl2 ? 26214 : 7027456);
                        cm3.a(bl2 ? 0xFF0000 : 3550755);
                        cm3.e(n5 + 2, n2, n5 + (rpg.d.e_ >> 1) - 3, n2);
                        cm3.e(n5 + 2, n2 + 14, n5 + (rpg.d.e_ >> 1) - 3, n2 + 14);
                        cm3.e(n5 + 1, n2 + 1, n5 + 1, n2 + 14);
                        cm3.e(n5 + (rpg.d.e_ >> 1) - 2, n2 + 1, n5 + (rpg.d.e_ >> 1) - 2, n2 + 14);
                        object = p.byte_arr_a(by2);
                        n.c(cm3, n5 + 4, n2 + 4, 5, 5, 3550755);
                        cm3.a(0);
                        cm3.a(n5 + 4 + 1, n2 + 4 + 1, 3, 3);
                        cm3.a(15723216);
                        ac.a(cm3, n5 + (rpg.d.e_ >> 2) + 5, n2 + 1, (byte[])object, 0, 1);
                    }
                    this.a(cm2, this.a_ + 3, this.b_ + 174 - 16, rpg.d.e_ - 6, this.var_ch_b.a(3), this.i == 7);
                } else {
                    int n6;
                    for (n6 = 0; n6 < 3; ++n6) {
                        by2 = this.d[n6];
                        as as3 = this.var_as_arr_a[n6];
                        n5 = n6;
                        cm cm4 = cm2;
                        object = this;
                        int n7 = ((n)object).b_ + 31 + 5 + 27 + n5 * 15;
                        n.c(cm4, ((n)object).a_ + 3, n7, 90 + ((da)object).var_int_f, 14, 3550755);
                        cm4.a(by2 == 0 ? 0xFF0000 : 15723216);
                        if (as3 != null) {
                            ac.a(cm4, ((n)object).a_ + 3 + 2, n7 + 1, as3.var_byte_arr_a, 0);
                        }
                        n.c(cm4, ((n)object).a_ + 3 + 90 + 2 + ((da)object).var_int_f, n7, var_int_e - ((da)object).var_int_f, 14, 3550755);
                        cm4.a(15723216);
                        n.b(cm4, by2, ((n)object).a_ + 3 + 90 + 2 + ((da)object).var_int_f + var_int_e - 3 - ((da)object).var_int_f, n7 + 3, 8, 0);
                    }
                    this.a(cm2, this.a_ + 3, this.b_ + 174 - 16, rpg.d.e_ - 6, this.var_ch_b.a(4), this.i == 1);
                    if (this.var_boolean_f) {
                        n6 = rpg.a.c;
                        int n8 = this.b_ + 174 - 46;
                        cm2.a(3550755);
                        ac.a(cm2, n6 - 1, n8 - 1, rpg.d.w, 0, 1);
                        ac.a(cm2, n6 - 1, n8, rpg.d.w, 0, 1);
                        ac.a(cm2, n6 - 1, n8 + 1, rpg.d.w, 0, 1);
                        ac.a(cm2, n6 + 1, n8 - 1, rpg.d.w, 0, 1);
                        ac.a(cm2, n6 + 1, n8, rpg.d.w, 0, 1);
                        ac.a(cm2, n6 + 1, n8 + 1, rpg.d.w, 0, 1);
                        ac.a(cm2, n6, n8 - 1, rpg.d.w, 0, 1);
                        ac.a(cm2, n6, n8 + 1, rpg.d.w, 0, 1);
                        cm2.a(0xFF0000);
                        ac.a(cm2, n6, n8, rpg.d.w, 0, 1);
                    }
                }
            }
            if (this.j > 0 || ((bo)this).f > 0) {
                bo.a(cm2, this.a_, this.b_, this.var_byte_arr_a, 1);
                if (((bo)this).f > 0) {
                    ((bo)this).f = (byte)(((bo)this).f - 1);
                    if (((bo)this).f == 0) {
                        this.j = 0;
                        ((bo)this).f = 0;
                        this.var_byte_arr_a = null;
                    }
                }
                if (this.j > 0) {
                    this.j = (byte)(this.j - 1);
                    if (this.j == 0) {
                        byte[] byArray;
                        da da2 = this;
                        as as4 = as.a(da2.var_dv_a.c[0], da2.var_dv_a.c[1]);
                        if (!di.bj_a(as4.var_byte_a).a(as4.var_byte_a, as4.var_byte_b, 1)) {
                            byArray = da2.var_ch_a.a(6);
                        } else {
                            by2 = di.bj_a(da2.var_dv_a.d[0]).a(da2.var_dv_a.d[0], da2.var_dv_a.d[1], true);
                            n2 = by2 == 0 ? 0 : 1;
                            by2 = di.bj_a(da2.var_dv_a.d[2]).a(da2.var_dv_a.d[2], da2.var_dv_a.d[3], true);
                            n2 = by2 == 0 ? 0 : n2;
                            by2 = di.bj_a(da2.var_dv_a.d[4]).a(da2.var_dv_a.d[4], da2.var_dv_a.d[5], true);
                            n2 = by2 == 0 ? 0 : n2;
                            if (n2 == 0) {
                                byArray = da2.var_ch_b.a(7);
                            } else if (di.bj_a(as4.var_byte_a).a(as4, 1) == 0) {
                                byArray = da2.var_ch_a.a(6);
                            } else {
                                di.bj_a(da2.var_dv_a.d[0]).b(da2.var_dv_a.d[0], da2.var_dv_a.d[1], 1);
                                di.bj_a(da2.var_dv_a.d[2]).b(da2.var_dv_a.d[2], da2.var_dv_a.d[3], 1);
                                di.bj_a(da2.var_dv_a.d[4]).b(da2.var_dv_a.d[4], da2.var_dv_a.d[5], 1);
                                da2.d[0] = da2.d[0] - 1;
                                da2.d[1] = da2.d[1] - 1;
                                da2.d[2] = da2.d[2] - 1;
                                byArray = da2.var_ch_a.a(3);
                            }
                        }
                        this.var_byte_arr_a = byArray;
                        this.j = 0;
                        ((bo)this).f = (byte)15;
                    }
                }
                this.d();
            }
        }
    }

    static {
        var_int_e = rpg.d.e_ - 90 - 6 - 2;
    }
}

