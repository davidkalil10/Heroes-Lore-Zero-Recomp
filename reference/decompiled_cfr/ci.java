/*
 * Decompiled with CFR 0.152.
 */
final class ci
extends cd {
    public ci(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, dt.var_dt_arr_a[by2].var_s_a, false);
        this.var_byte_b = 1;
        this.var_int_c = -1;
        this.var_int_f = this.var_s_a.a((byte)0);
    }

    public final void void_a(byte by2) {
        if (by2 == 6 || by2 == 7) {
            super.void_a(by2);
        }
    }

    public final void void_c() {
        if (this.var_byte_b == 6) {
            ++this.var_int_c;
        }
        this.t();
        if (this.var_byte_b == 6) {
            this.y();
        }
    }

    protected final void n() {
    }

    protected final void a(al al2, int n2) {
        super.a(al2, n2);
        this.var_int_c = this.var_int_f - this.var_int_f * this.int_c() / this.int_d() - 1;
    }

    protected final void void_a(int n2, int n3) {
        switch (this.var_byte_b) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.var_s_a.a((byte)0, (byte)1, this.var_int_c, n2, n3);
                return;
            }
            case 6: {
                super.void_a(n2, n3);
            }
        }
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
}

