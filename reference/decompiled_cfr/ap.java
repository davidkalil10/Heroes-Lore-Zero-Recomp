/*
 * Decompiled with CFR 0.152.
 */
final class ap
extends cx {
    public static ap a = null;

    public ap(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2);
        this.p = (byte)3;
        this.var_byte_arr_b = new byte[]{0};
        this.var_byte_arr_c[0] = 10;
        if (this.var_short_c == 111 || this.var_short_c == 113) {
            a = this;
            this.i = true;
        }
        this.var_byte_arr_c[0] = 10;
    }

    protected final boolean boolean_a(int n2) {
        boolean bl2 = false;
        switch (this.var_byte_a) {
            case 0: {
                bl2 = n2 == 4 || n2 == 7;
                break;
            }
            case 1: {
                bl2 = n2 == 4;
            }
        }
        return bl2;
    }

    protected final boolean boolean_a_() {
        return false;
    }

    protected final void void_b() {
        switch (this.var_byte_a) {
            case 0: {
                if (this.var_int_c == 4) {
                    this.boolean_l();
                    return;
                }
                this.boolean_m();
                return;
            }
            case 1: {
                this.a(this.var_do_a.s, this.var_do_a.t, false);
            }
        }
    }

    protected final void void_a() {
        if (this.var_byte_b == 6) {
            this.z();
            return;
        }
        switch (this.var_byte_b) {
            case 3: {
                switch (this.var_byte_a) {
                    case 0: {
                        this.var_byte_h = (byte)2;
                        break;
                    }
                    case 1: {
                        this.var_byte_h = (byte)4;
                    }
                }
                break;
            }
            case 4: {
                this.var_byte_h = (byte)3;
                break;
            }
            case 100: {
                this.var_byte_h = (byte)5;
                break;
            }
            case 2: {
                this.var_byte_h = 1;
                break;
            }
            default: {
                this.var_byte_h = 0;
            }
        }
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }

    protected final void y() {
        if (this.boolean_j()) {
            if (cw.a == null || cw.a.boolean_b()) {
                if (cw.a != null) {
                    cw.a.void_g();
                    cw.a = null;
                }
                a = null;
                this.void_g();
                return;
            }
            this.void_a((byte)100);
        }
    }
}

