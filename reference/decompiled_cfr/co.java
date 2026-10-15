/*
 * Decompiled with CFR 0.152.
 */
final class co
extends cd {
    public static byte a;
    public static short var_short_b;
    private boolean var_boolean_b;

    public co(short s2, short s3, boolean bl2) {
        super(s2, s3, var_short_b, a, av.var_av_a.var_s_a, true);
        this.void_c((byte)1);
        this.void_a((byte)8);
        this.var_boolean_b = bl2;
    }

    protected final void void_a() {
        this.var_byte_h = this.var_byte_b == 8 ? (byte)8 : (this.var_byte_b == 6 ? (byte)10 : (byte)9);
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }

    public final void void_l() {
        switch (this.var_byte_b) {
            case 8: {
                if (!this.boolean_j()) break;
                this.void_a((byte)1);
                return;
            }
            case 6: {
                if (!this.boolean_j()) break;
                this.void_a((byte)7);
                return;
            }
            default: {
                if (!this.var_boolean_b || this.var_short_a != 0) break;
                al[] alArray = cd.al_arr_a();
                for (int i2 = 0; i2 < 2; ++i2) {
                    if (alArray[i2] == null || this.int_a((du)alArray[i2]) > this.i) continue;
                    this.b(alArray[i2], (int)this.short_a(), (byte)0);
                    this.var_short_a = this.var_byte_j;
                }
            }
        }
    }

    protected final void void_a(int n2, int n3) {
        this.var_s_a.a(this.var_byte_h, this.var_byte_c, this.var_int_c, n2, n3);
    }

    public final void c(int n2) {
    }

    public final void void_g() {
        this.void_m();
    }

    final void void_b(byte by2, int n2) {
    }

    final void void_a(byte by2, byte by3, int n2) {
    }

    final boolean boolean_a(byte by2, int n2) {
        return true;
    }

    final boolean boolean_a(byte by2) {
        return true;
    }

    protected final int int_a(int n2) {
        super.int_a(n2);
        return n2;
    }
}

