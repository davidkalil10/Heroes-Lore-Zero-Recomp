/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

final class v
extends af {
    private byte[] O = rpg.e.a(af.var_byte_arr_a, 0);
    private byte[] P = rpg.e.a(af.var_byte_arr_a, 1);
    private int e;
    private int l;
    private boolean i = false;

    public v(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, dt.var_dt_arr_a[by2].var_s_a);
        this.var_byte_arr_b = rpg.e.a(af.var_byte_arr_a, 2);
        this.var_byte_arr_c = rpg.e.a(af.var_byte_arr_a, 3);
        this.var_byte_arr_d = rpg.e.a(af.var_byte_arr_a, 4);
        this.a(this.P);
        this.var_int_b = 2;
        this.var_byte_a = this.var_byte_arr_b[this.var_int_b];
        this.i = false;
        this.var_byte_h = 0;
        this.var_short_a = this.var_byte_arr_c[this.var_byte_a];
        this.l = this.e = this.var_int_k * 10 / 100;
    }

    protected final void void_l() {
        if (this.var_byte_b != 30) {
            super.void_l();
            return;
        }
        if (this.boolean_j()) {
            this.void_a((byte)1);
        }
    }

    protected final int int_c() {
        if (this.boolean_l()) {
            return this.var_int_k;
        }
        return this.l;
    }

    private boolean boolean_l() {
        return this.l <= 0;
    }

    protected final int int_d() {
        if (this.boolean_l()) {
            return this.var_int_j;
        }
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     */
    protected final void void_k() {
        if (this.var_short_a <= 0 && !this.var_boolean_f) {
            this.z();
            this.void_a((byte)3);
            return;
        }
        int n2 = this.byte_a((du)this.var_do_a);
        int n3 = this.byte_b(this.var_do_a);
        int n4 = n2;
        if (this.var_do_a.s > this.s) {
            n4 = 0 - n2;
        }
        int n5 = n3;
        if (this.var_do_a.t > this.t) {
            n5 = 0 - n3;
        }
        byte by2 = 0;
        byte by3 = 0;
        if (n5 != 0) {
            byte by4 = by2 = n5 > 0 ? (byte)1 : 2;
        }
        if (n4 != 0) {
            byte by5 = by3 = n4 > 0 ? (byte)3 : 4;
        }
        if (n2 < n3) {
            this.void_c(by2);
            return;
        }
        this.void_c(by3);
    }

    protected final void void_a(int n2, int n3) {
        this.var_s_a.a(this.var_byte_h, this.var_byte_h == 1 || this.var_byte_h == 2 ? this.var_byte_c : (byte)1, this.var_int_c, n2, n3);
    }

    private final void z() {
        do {
            byte by2 = this.var_byte_a;
            this.var_int_b = (this.var_int_b + 1) % this.var_byte_arr_b.length;
            this.var_byte_a = this.var_byte_arr_b[this.var_int_b];
            if (by2 == 2 && this.boolean_l()) {
                this.var_int_b = 1;
                this.var_byte_a = this.var_byte_arr_b[this.var_int_b];
                this.i = true;
                return;
            }
            if (!this.boolean_l() || this.var_byte_a != 0) continue;
            this.var_int_b = 0;
            this.var_byte_a = this.var_byte_arr_b[this.var_int_b];
            this.i = true;
            return;
        } while (this.var_byte_a == 2 && !this.boolean_l());
    }

    protected final boolean boolean_a(int n2) {
        return n2 == this.var_byte_arr_d[this.var_byte_a];
    }

    protected final void void_b() {
        switch (this.var_byte_a) {
            case 0: {
                this.a(this.O, this.short_a(), true);
                return;
            }
            case 1: {
                for (int i2 = 0; i2 < 6; ++i2) {
                    int n2 = this.var_do_a.s + (Math.abs(al.var_java_util_Random_a.nextInt()) & 0xFF) % 4 - 2;
                    int n3 = this.var_do_a.t + (Math.abs(al.var_java_util_Random_a.nextInt()) & 0xFF) % 4 - 2;
                    if (n2 < 0 || n2 >= g.var_byte_c || n3 < 0 || n3 >= g.var_byte_d) continue;
                    new t(1, (short)(n2 << 4), (short)(n3 << 4), this.var_s_a, 16, false, this, 0, 0, 0);
                }
                break;
            }
        }
    }

    protected final void void_e() {
        if (this.var_byte_a == 1) {
            new ck(((du)this.var_do_a).h, ((du)this.var_do_a).i, this.var_s_a);
            new ck(((du)this.var_do_a).h, ((du)this.var_do_a).i, this.var_s_a);
        }
        this.void_a((int)this.var_byte_arr_c[this.var_byte_a]);
    }

    /*
     * Unable to fully structure code
     */
    protected final void void_a() {
        switch (this.var_byte_b) {
            case 0: 
            case 1: 
            case 2: {
                if (this.l > 0) {
                    this.var_byte_h = this.i != false ? 1 : 0;
                    break;
                }
                v0 = this;
                v1 = 2;
                ** GOTO lbl37
            }
            case 3: {
                switch (this.var_byte_a) {
                    case 0: {
                        this.var_byte_h = (byte)(this.i != false ? 6 : 5);
                        this.i = this.i == false;
                        break;
                    }
                    case 1: {
                        this.var_byte_h = (byte)(this.l > 0 ? 3 : 4);
                        break;
                    }
                    case 2: {
                        this.var_byte_h = (byte)20;
                        this.l = this.e;
                    }
                }
                break;
            }
            case 4: {
                if (this.l > 0) {
                    this.var_byte_h = (byte)(this.i != false ? 8 : 7);
                    break;
                }
                v0 = this;
                v1 = 9;
                ** GOTO lbl37
            }
            case 6: 
            case 7: {
                break;
            }
            case 8: {
                break;
            }
            case 30: {
                v0 = this;
                v1 = this.i != false ? 15 : 14;
lbl37:
                // 3 sources

                v0.var_byte_h = (byte)v1;
            }
        }
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }

    protected final void a(al al2, int n2) {
        if (this.l > 0) {
            this.l -= n2;
            if (this.l <= 0) {
                this.l = 0;
                this.void_a((byte)30);
                return;
            }
        } else {
            this.var_int_k -= n2;
            if (this.var_int_k <= 0) {
                this.var_int_k = 0;
            }
        }
    }

    protected final void void_m() {
        di.var_g_a.d(this);
        this.b(this.P);
    }
}

