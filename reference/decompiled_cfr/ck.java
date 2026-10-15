/*
 * Decompiled with CFR 0.152.
 */
final class ck
extends cd {
    public static byte a = 0;
    public static short var_short_b;
    private int var_int_b = 0;

    public ck(short s2, short s3, s s4) {
        super(s2, s3, var_short_b, a, s4, true);
        this.void_a((byte)8);
        this.var_int_b = 50;
    }

    protected final void void_c() {
        --this.var_int_b;
        if (this.var_int_b == 0) {
            this.var_int_k = 0;
            this.void_a((byte)6);
        }
        super.void_c();
    }

    protected final void void_a() {
        switch (this.var_byte_b) {
            case 8: {
                this.var_byte_h = (byte)10;
                break;
            }
            case 3: {
                this.var_byte_h = (byte)11;
                break;
            }
            case 6: {
                this.var_byte_h = (byte)13;
                break;
            }
            default: {
                this.var_byte_h = (byte)12;
            }
        }
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }

    protected final void void_a(int n2, int n3) {
        this.var_s_a.a(this.var_byte_h, this.var_byte_h == 12 ? this.var_byte_c : (byte)1, this.var_int_c, n2, n3);
    }

    protected final void void_d() {
        if (this.var_int_c == 1) {
            this.a(dy.f, this.short_a(), true);
        }
        if (this.boolean_j()) {
            this.void_a((byte)1);
        }
    }

    public final void void_g() {
        this.void_a((byte)7);
        di.var_g_a.d(this);
    }
}

