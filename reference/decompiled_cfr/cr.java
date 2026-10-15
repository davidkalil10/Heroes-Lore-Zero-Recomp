/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

class cr
extends at {
    protected byte c;
    protected s var_s_a;
    private byte d;
    private static final byte[] var_byte_arr_a;

    cr(byte by2, byte by3, int n2) {
        super(by2);
        ((at)this).c = (byte)n2;
        this.c = var_byte_arr_a[by2 - 30];
        this.d = by3;
        this.var_s_a = e.var_s_arr_a[this.d];
        this.var_int_a = this.var_s_a.a(this.c);
        if (by2 == 41 || by2 == 37) {
            this.var_boolean_b = false;
        }
    }

    void a(int n2, int n3) {
        if (this.var_s_a == null) {
            this.var_boolean_a = true;
            return;
        }
        this.var_s_a.a(this.c, (byte)1, this.var_int_b % this.var_int_a, n2, n3);
    }

    static {
        var_byte_arr_a = new byte[]{0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 0, 0, 1, 0, 0, 0, 1};
    }
}

