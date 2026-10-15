/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;
import rpg.e;
import rpg.g;

final class dk
extends de {
    private byte f;
    private boolean var_boolean_g;
    private boolean var_boolean_h = false;
    private byte var_byte_g = 0;
    private byte var_byte_h = 1;
    private bj var_bj_a = null;
    private as var_as_a = null;

    public dk(n n2, byte by2) {
        super(n2, (byte)28, (byte)4, (byte)7);
        this.f = by2;
        this.var_boolean_g = this.f == 0;
        this.c((byte)0);
        this.var_byte_a = 0;
        this.f();
    }

    private final void c(byte by2) {
        this.var_byte_g = by2;
        this.var_byte_a = 0;
        if (this.var_boolean_g) {
            this.var_byte_h = (byte)3;
            this.var_bj_a = by2 == 0 ? di.bj_a() : (by2 == 2 ? di.bj_b() : di.bj_c());
        } else {
            this.var_byte_h = (byte)de.var_bj_arr_a.length;
            this.var_bj_a = de.var_bj_arr_a[this.var_byte_g];
        }
        dk dk2 = this;
        this.var_byte_d = (byte)(dk2.var_bj_a.var_byte_a / 7);
        dk2.var_byte_b = (byte)(dk2.var_byte_d * dk2.var_byte_c);
        if (dk2.var_byte_a > dk2.var_byte_b) {
            dk2.var_byte_a = (byte)Math.min(dk2.var_byte_b - 1, 0);
        }
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            this.var_n_a.c();
            return true;
        }
        if ((n3 == 49 || n3 == 51) && this.f == 0) {
            dk dk2 = this;
            this.var_boolean_g = !dk2.var_boolean_g;
            dk2.c((byte)0);
            return true;
        }
        if (this.var_boolean_h) {
            if (n3 == 50 || n2 == 1) {
                this.var_byte_g = (byte)((this.var_byte_g + (this.var_byte_h - 1)) % this.var_byte_h);
            } else if (n3 == 56 || n2 == 6) {
                this.var_byte_g = (byte)((this.var_byte_g + 1) % this.var_byte_h);
            } else {
                if (n3 == 54 || n2 == 5) {
                    this.var_byte_a = 0;
                    this.var_boolean_h = false;
                    return true;
                }
                return true;
            }
            this.c(this.var_byte_g);
            return true;
        }
        if (n.f(n2, n3)) {
            this.var_as_a = this.var_bj_a.as_a(this.var_byte_a);
            if (this.f == 1) {
                ((dd)this.var_n_a).a = this.var_as_a;
                this.var_n_a.c();
            } else if (this.var_as_a != null) {
                this.var_n_b = this.var_boolean_g ? new dj((n)this, rpg.e.var_ch_h.a(48, 50, 16)) : new dj((n)this, rpg.e.var_ch_h.a(49, 50, 16));
            }
            return true;
        }
        if ((n3 == 52 || n2 == 2) && this.var_byte_a % this.var_byte_c == 0) {
            this.var_boolean_h = true;
            return true;
        }
        if (this.d(n2, n3)) {
            return true;
        }
        return this.e(n2, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 == 6) {
            if (this.var_boolean_g) {
                switch (by3) {
                    case 0: {
                        if (this.var_as_a.c()) {
                            this.a(rpg.e.var_ch_h.a(52));
                        }
                        if (!de.var_bj_arr_a[this.var_byte_g].a(this.var_as_a.var_byte_a, this.var_as_a.var_byte_b, this.var_as_a.c)) {
                            this.a(rpg.e.var_ch_h.a(55));
                            return;
                        }
                        if (this.var_as_a.c()) return;
                        if (de.var_bj_arr_a[this.var_byte_g].a(this.var_as_a, (int)this.var_as_a.c) <= 0) return;
                        de.i();
                        this.var_bj_a.void_a(this.var_byte_a);
                        this.var_as_a = null;
                        this.a();
                        this.var_n_b = new br((n)this, rpg.e.var_ch_a.a(29), 1);
                        return;
                    }
                    case 1: {
                        dk dk2 = this;
                        if (dk2.var_as_a.c()) {
                            dk2.a(rpg.e.var_ch_h.a(52));
                            break;
                        }
                        if (dk2.var_as_a.d()) {
                            dk2.var_n_b = new bt((n)dk2, rpg.e.var_ch_h.a(51), 4, true, true);
                            return;
                        }
                        dk2.a(rpg.e.var_ch_h.a(56));
                        break;
                    }
                    case 2: {
                        this.void_a(this.var_as_a);
                    }
                }
                return;
            }
            switch (by3) {
                case 0: {
                    bj bj2 = di.bj_a(this.var_as_a.var_byte_a);
                    if (!bj2.a(this.var_as_a.var_byte_a, this.var_as_a.var_byte_b, this.var_as_a.c)) {
                        this.a(rpg.e.var_ch_h.a(55));
                        return;
                    }
                    if (bj2.a(this.var_as_a, (int)this.var_as_a.c) <= 0) return;
                    de.var_bj_arr_a[this.var_byte_g].void_a(this.var_byte_a);
                    this.a();
                    de.i();
                    this.var_as_a = null;
                    return;
                }
                case 1: {
                    this.var_n_b = new bt((n)this, rpg.e.var_ch_h.a(51), 4, true, true);
                    return;
                }
                case 2: {
                    this.void_a(this.var_as_a);
                }
            }
            return;
        }
        if (by2 != 4) return;
        if (by3 != 0) return;
        if (this.var_boolean_g) {
            this.var_bj_a.void_a(this.var_byte_a);
            this.a();
            return;
        }
        de.var_bj_arr_a[this.var_byte_g].void_a(this.var_byte_a);
        de.i();
    }

    protected final void a(cm cm2) {
        this.a(cm2, rpg.e.var_ch_h.a(this.var_boolean_g ? 47 : 0), true, this.f == 0);
        this.a(cm2, this.var_byte_g, this.var_boolean_h, this.var_boolean_g ? 3 : de.var_bj_arr_a.length, this.var_boolean_g);
        this.a(cm2, this.var_bj_a, this.var_boolean_g ? this.var_byte_g : (byte)0, this.var_boolean_h, this.var_byte_c, this.var_byte_d, this.var_boolean_g ? di.var_int_e : de.var_int_f);
    }

    protected final void a(cm cm2, byte by2, int n2, int n3, boolean bl2) {
        cm2.a(0xFFFFFF);
        byte[] byArray = rpg.g.a(rpg.d.n, (" " + by2).getBytes());
        byArray = rpg.g.a(byArray, rpg.d.k);
        ac.a(cm2, n2, n3, byArray, 1);
    }

    protected final void b(cm cm2) {
        if (!this.var_boolean_h) {
            this.e(cm2);
        }
    }
}

