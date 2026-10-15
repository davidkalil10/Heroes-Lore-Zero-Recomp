/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;
import rpg.d;
import rpg.e;
import rpg.f;

final class dp
extends dg {
    private boolean h = false;

    public dp(n n2) {
        super(n2, (byte)7, (byte)3, (byte)3);
        dg.g = true;
    }

    public static void g() {
        if (dg.b != null) {
            dg.b = null;
        }
        if (dg.var_byte_arr_arr_a != null) {
            dg.var_byte_arr_arr_a = null;
        }
        if (dg.d != null) {
            dg.d = null;
        }
        if (dg.var_int_arr_e != null) {
            dg.var_int_arr_e = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (this.h) {
            this.h = false;
            return true;
        }
        if (n.g(n2, n3)) {
            if (this.var_n_a instanceof ax) {
                this.var_n_a.var_byte_a = (byte)2;
            }
            this.var_n_a.c();
            return true;
        }
        if (n.f(n2, n3)) {
            n3 = this.var_byte_a;
            dp dp2 = this;
            Object object = di.var_do_a.bm_a((byte)n3);
            if (object == null) {
                if (dp2.var_byte_a == 5) {
                    if (!di.boolean_b()) {
                        dp2.a(ax.var_ch_a.a(38));
                        return true;
                    }
                    if (di.var_byte_b != 2 && di.var_do_a.bm_a((byte)3) == null) {
                        dp2.a(ax.var_ch_a.a(59));
                        return true;
                    }
                }
                byte[] byArray = dg.var_byte_arr_arr_a[dp2.var_byte_a];
                object = byArray;
                if (byArray != null) {
                    dp2.var_n_b = new bk(dp2, dp2.var_byte_a);
                    return true;
                }
                dp2.a(ax.var_ch_a.a(60));
                return true;
            }
            byte[] byArray = dg.var_byte_arr_arr_a[dp2.var_byte_a];
            object = byArray;
            if (byArray != null) {
                dp2.var_n_b = new dj(dp2, ax.var_ch_a.a(65, 66), 1);
                return true;
            }
            dp2.var_n_b = new bt((n)dp2, ax.var_ch_a.a(67), 3, true);
            return true;
        }
        if (n3 == 52) return this.boolean_a((byte)3);
        if (n2 == 2) {
            return this.boolean_a((byte)3);
        }
        if (n3 == 54) return this.boolean_a((byte)4);
        if (n2 == 5) {
            return this.boolean_a((byte)4);
        }
        if (n3 == 50) return this.boolean_b((byte)3);
        if (n2 == 1) {
            return this.boolean_b((byte)3);
        }
        if (n3 == 56) return this.boolean_b((byte)4);
        if (n2 != 6) return true;
        return this.boolean_b((byte)4);
    }

    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 == 6) {
            if (by3 == 0) {
                byte[] byArray = dg.var_byte_arr_arr_a[this.var_byte_a];
                if (byArray != null) {
                    this.var_n_b = new bk(this, this.var_byte_a);
                }
                return;
            }
            if (by3 == 1) {
                this.var_n_b = new bt((n)this, ax.var_ch_a.a(67), 3, true, true);
                return;
            }
        } else if (by2 == 3 && by3 == 0) {
            by3 = this.var_byte_a;
            dp dp2 = this;
            do do_ = di.var_do_a;
            do_.j(by3);
            do_.void_i();
            by3 = dg.var_byte_arr_a[by3];
            if (by3 >= 0) {
                rpg.e.a(rpg.e.var_ca_a, (int)by3);
            }
            dg.g = true;
            dp2.a(ax.var_ch_a.a(68));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean boolean_a(byte by2) {
        if (by2 == 4) {
            if (this.var_byte_a != 6) {
                if (this.var_byte_a % 3 == 2) {
                    this.var_byte_a = (byte)(this.var_byte_a - 2);
                    return true;
                }
                this.var_byte_a = (byte)(this.var_byte_a + 1);
                return true;
            }
        } else {
            if (this.var_byte_a == 6) {
                this.var_byte_a = (byte)3;
                return true;
            }
            if (this.var_byte_a % 3 == 0) {
                this.var_byte_a = (byte)(this.var_byte_a + 2);
                return true;
            }
        }
        this.var_byte_a = (byte)(this.var_byte_a - 1);
        return true;
    }

    private boolean boolean_b(byte by2) {
        if (by2 == 4) {
            this.var_byte_a = (byte)(this.var_byte_a + this.var_byte_c);
            if (this.var_byte_a > 8) {
                this.var_byte_a = 1;
            }
            if (this.var_byte_a > 6) {
                this.var_byte_a = (byte)6;
            }
        } else {
            this.var_byte_a = this.var_byte_a == 6 ? (byte)4 : (byte)(this.var_byte_a - this.var_byte_c);
            if (this.var_byte_a == -2) {
                this.var_byte_a = (byte)6;
            } else if (this.var_byte_a < 0) {
                this.var_byte_a = 1;
            }
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final void a(cm cm2) {
        Object object;
        byte by2;
        block23: {
            if (!di.var_boolean_c) {
                di.var_boolean_c = true;
                rpg.b.boolean_a();
                this.h = true;
                di.var_byte_arr_a = rpg.e.var_ch_a.a(13);
                eb.f(cm2, rpg.f.c, rpg.f.d, rpg.d.e_, 174);
                cm2.a(15723216);
                cm2.d(rpg.f.c, rpg.f.d, rpg.d.e_ - 1, 173);
                cm2.a(3550755);
                if (di.var_byte_arr_a != null) {
                    ac.a(cm2, rpg.f.c + 10, rpg.f.d + 10, rpg.f.b - 10, 1, di.var_byte_arr_a);
                }
                return;
            }
            if (!dg.g) break block23;
            dg.b = new byte[7];
            for (int i2 = 0; i2 < 7; ++i2) {
                dg.b[i2] = -1;
            }
            dg.b = di.bj_a().byte_arr_b();
            dp dp2 = this;
            dg.var_byte_arr_arr_a = new byte[7][];
            for (by2 = 0; by2 < 7; by2 = (byte)(by2 + 1)) {
                Object object2;
                block24: {
                    byte by3 = by2;
                    byte by4 = -1;
                    byte by5 = -1;
                    block0 : switch (by3) {
                        case 0: 
                        case 4: 
                        case 6: {
                            by4 = (byte)(by3 + 8);
                            if (!di.boolean_a()) break;
                            by4 = (byte)(by4 + 1);
                            break;
                        }
                        case 1: {
                            by4 = 10;
                            break;
                        }
                        case 2: {
                            by4 = 11;
                            break;
                        }
                        case 3: {
                            switch (di.var_byte_b) {
                                case 0: {
                                    by4 = 0;
                                    by5 = 1;
                                    break block0;
                                }
                                case 1: 
                                case 5: {
                                    by4 = 4;
                                    break block0;
                                }
                                case 2: {
                                    by4 = 2;
                                    by5 = 3;
                                    break block0;
                                }
                                case 3: {
                                    by4 = 5;
                                    break block0;
                                }
                                case 4: {
                                    by4 = 6;
                                }
                            }
                            break;
                        }
                        case 5: {
                            switch (di.var_byte_b) {
                                case 1: {
                                    by4 = 4;
                                    break block0;
                                }
                                case 3: {
                                    by4 = 5;
                                    break block0;
                                }
                                case 2: {
                                    by4 = 7;
                                    break block0;
                                }
                            }
                            object2 = null;
                            break block24;
                        }
                    }
                    object = di.bj_a().a(by4, by5, true, di.var_do_a.byte_a());
                    object2 = object;
                }
                if (object2 == null) continue;
                dg.var_byte_arr_arr_a[by2] = new byte[((as)object).length];
                dg.var_byte_arr_arr_a[by2] = (byte[])object;
            }
            this.void_a();
            dg.g = false;
        }
        by2 = this.var_byte_a;
        object = dg.as_a(by2);
        this.a(cm2, by2, (as)object, false, this.var_byte_a == 5);
    }

    protected final void b(cm cm2) {
        int n2 = this.var_byte_a / this.var_byte_c;
        int n3 = this.var_byte_a % this.var_byte_c;
        int n4 = this.a_ + (rpg.f.b - 122 >> 1) + n3 * 15;
        n3 = this.b_ + 24 + n2 * 15 + (n3 == 1 ? -7 : 0);
        if (n2 == 2) {
            n4 = this.a_ + (rpg.f.b - 122 >> 1) + 15;
            n3 = this.b_ + 24 + 30 - 7;
        }
        if (!this.h) {
            this.a(cm2, n4, n3, 13, 13);
        }
    }

    public static boolean boolean_a(as as2) {
        switch (as2.var_byte_a) {
            case 8: 
            case 12: 
            case 14: {
                return !di.boolean_a();
            }
            case 9: 
            case 13: 
            case 15: {
                return di.boolean_a();
            }
            case 10: 
            case 11: {
                return true;
            }
        }
        switch (di.var_byte_b) {
            case 0: {
                if (as2.var_byte_a != 0 && as2.var_byte_a != 1) break;
                return true;
            }
            case 1: 
            case 5: {
                if (as2.var_byte_a != 4) break;
                return true;
            }
            case 2: {
                if (as2.var_byte_a != 2 && as2.var_byte_a != 3 && as2.var_byte_a != 7) break;
                return true;
            }
            case 3: {
                if (as2.var_byte_a != 5) break;
                return true;
            }
            case 4: {
                if (as2.var_byte_a != 6) break;
                return true;
            }
        }
        return false;
    }
}

