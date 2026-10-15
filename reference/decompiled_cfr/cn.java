/*
 * Decompiled with CFR 0.152.
 */
import rpg.b;
import rpg.d;
import rpg.e;
import rpg.f;
import rpg.g;

final class cn
extends l {
    public cn(n n2) {
        super(n2, (byte)2);
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            if (this.var_n_b != null) {
                this.c();
            } else {
                this.var_n_a.var_byte_a = (byte)-2;
                this.var_n_a.c();
            }
            return true;
        }
        if (n2 == 8 || n3 == 53 || n3 == -6) {
            cn cn2 = this;
            switch (cn2.var_byte_a) {
                case 0: {
                    cn2.var_n_b = new cc(cn2);
                    break;
                }
                case 1: {
                    if (!di.var_boolean_e) {
                        byte[] byArray = rpg.e.var_ch_a.a(28);
                        if (di.var_boolean_i) {
                            byArray = g.a(rpg.d.t, byArray);
                            di.var_boolean_i = false;
                            rpg.b.boolean_a();
                        }
                        cn2.var_n_b = new br((n)cn2, byArray, '\u0000');
                        ((br)cn2.var_n_b).e = true;
                        break;
                    }
                    di.k();
                    cn2.var_n_b = new aw(cn2);
                    break;
                }
                default: {
                    return false;
                }
            }
            cn2.var_boolean_a = true;
            return true;
        }
        this.c(n2, n3);
        return true;
    }

    final void void_a(byte by2, byte by3) {
        if (by2 == 3 && by3 == 0) {
            di.var_boolean_e = true;
            rpg.b.boolean_a();
            di.k();
            this.c();
            this.var_n_b = new aw(this);
            return;
        }
        this.c();
    }

    protected final void a(cm cm2) {
        this.void_a(cm2, false, true, true, false);
        this.a(cm2, 71, f.h, false);
    }
}

