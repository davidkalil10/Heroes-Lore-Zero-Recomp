/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

class cs
extends af {
    public static byte g;
    protected static af[] a;

    protected cs(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, dt.var_dt_arr_a[by2].var_s_a);
        this.var_byte_arr_b = rpg.e.a(af.var_byte_arr_a, 8);
        this.var_byte_arr_c = rpg.e.a(af.var_byte_arr_a, 9);
        g = by2;
        this.var_int_b = -1;
        if (a == null) {
            a = new af[3];
        }
        this.void_c((byte)1);
    }

    public static final void a(af af2, byte by2) {
        if (a == null) {
            a = new cq[3];
        }
        cs.a[by2] = af2;
    }

    protected void void_a() {
        switch (this.var_byte_b) {
            case 3: {
                this.var_byte_h = (byte)14;
                break;
            }
            case 6: {
                this.var_byte_h = (byte)7;
                break;
            }
            default: {
                this.var_byte_h = 0;
            }
        }
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }

    protected final boolean boolean_a() {
        if (!(a[0] != null && !a[0].boolean_b() || a[1] != null && !a[1].boolean_b() || a[2] != null && !a[2].boolean_b() || this.var_boolean_f)) {
            this.var_int_k = 0;
            this.void_a((byte)6);
            return true;
        }
        return false;
    }

    protected final void void_k() {
        if (!this.boolean_a() && this.var_short_a <= 0 && !this.var_boolean_f) {
            this.z();
            switch (this.var_byte_a) {
                case 0: 
                case 1: 
                case 2: {
                    if (a[this.var_byte_a] == null) break;
                    ((cq)a[this.var_byte_a]).z();
                    return;
                }
                case 3: {
                    for (int i2 = 0; i2 < 3; ++i2) {
                        if (a[i2] == null) continue;
                        ((cq)a[i2]).A();
                    }
                    this.void_a((byte)3);
                }
            }
        }
    }

    private void z() {
        block3: while (true) {
            this.var_int_b = (this.var_int_b + 1) % this.var_byte_arr_b.length;
            this.var_byte_a = this.var_byte_arr_b[this.var_int_b];
            this.var_short_a = this.var_byte_arr_c[this.var_byte_a];
            switch (this.var_byte_a) {
                case 0: 
                case 1: 
                case 2: {
                    if (a[this.var_byte_a] != null && a[this.var_byte_a].int_c() > 0 && !cs.a[this.var_byte_a].var_boolean_g) break block3;
                    continue block3;
                }
            }
            break;
        }
    }

    protected boolean boolean_a(int n2) {
        if (this.var_byte_a == 3) {
            switch (n2) {
                case 10: {
                    g.a(1);
                    break;
                }
                case 11: {
                    di.var_g_a.void_c(2, 2);
                    new t(0, ((du)this).h, (short)(((du)this).i + 112), this.var_s_a, 22, false, null, 0, 0, 0);
                    break;
                }
                case 12: {
                    di.var_g_a.void_c(2, 1);
                    break;
                }
                case 13: {
                    di.var_g_a.void_b(2, 3);
                    break;
                }
                case 14: {
                    di.var_g_a.void_c(2, 4);
                }
            }
            return n2 == 11;
        }
        return false;
    }

    protected void void_b() {
        al[] alArray = cd.al_arr_a();
        for (int i2 = 0; i2 < 2; ++i2) {
            if (alArray[i2] == null || alArray[i2].t > this.t + 7) continue;
            this.b(alArray[i2], (int)this.short_a(), (byte)2);
            if (!alArray[i2].boolean_g()) continue;
            alArray[i2].void_b((byte)2);
        }
    }

    protected final void void_m() {
        a[0].void_m();
        a[1].void_m();
        a[2].void_m();
        di.var_g_a.e(this);
        di.var_g_a.e(a[0]);
        di.var_g_a.e(a[1]);
        di.var_g_a.e(a[2]);
        a = null;
    }

    static {
        a = null;
    }
}

