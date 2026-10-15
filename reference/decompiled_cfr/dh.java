/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;
import rpg.f;

final class dh
extends l {
    private byte f = 0;

    public dh(n n2) {
        super(n2, (byte)4);
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (this.f != 0) {
            return true;
        }
        if (n.g(n2, n3)) {
            if (this.var_n_b != null) {
                this.c();
            } else if (ax.var_boolean_f) {
                di.a((byte)7, (byte)0);
            } else {
                this.var_n_a.var_byte_a = (byte)7;
                this.var_n_a.c();
            }
            return true;
        }
        if (n.f(n2, n3)) {
            return this.a();
        }
        this.c(n2, n3);
        return true;
    }

    protected final boolean a() {
        switch (this.var_byte_a) {
            case 0: {
                if (di.var_g_a.var_boolean_e) {
                    this.var_n_b = new bt((n)this, ax.var_ch_a.a(18), 3, true, true);
                    break;
                }
                this.var_n_b = new br((n)this, ax.var_ch_a.a(61), 20);
                break;
            }
            case 1: {
                n.var_boolean_c = true;
                this.var_n_b = new bd((n)this, true);
                break;
            }
            case 2: {
                n.var_boolean_c = true;
                this.var_n_b = new r((n)this, true);
                break;
            }
            case 3: {
                byte[] byArray = rpg.e.var_ch_a.a(31);
                dh dh2 = this;
                this.var_n_b = new bt((n)dh2, byArray, 3, false, true);
                break;
            }
            default: {
                return false;
            }
        }
        this.var_boolean_a = true;
        return true;
    }

    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 == 3) {
            if (by3 == 0) {
                if (this.var_byte_a == 3) {
                    di.a((byte)7, (byte)1);
                    return;
                }
                this.f = (byte)2;
                this.var_n_b = new br((n)this, ax.var_ch_a.a(17), '\u0000');
                return;
            }
            if (ax.var_boolean_f) {
                di.a((byte)7, (byte)0);
                return;
            }
        } else if (by2 == 20 && ax.var_boolean_f) {
            di.a((byte)7, (byte)0);
        }
    }

    protected final void a(cm cm2) {
        if (this.f == 2) {
            this.f = 1;
            this.d();
        } else if (this.f == 1) {
            this.f = 0;
            try {
                di.k();
                this.c();
                if (ax.var_boolean_f) {
                    di.a((byte)7, (byte)0);
                } else {
                    this.var_n_b = new br((n)this, ax.var_ch_a.a(16), '\u0000');
                }
            }
            catch (Exception exception) {}
        }
        if (ax.var_boolean_f) {
            return;
        }
        this.void_a(cm2, false, true, true, false);
        this.a(cm2, 49, rpg.f.h, false);
    }
}

