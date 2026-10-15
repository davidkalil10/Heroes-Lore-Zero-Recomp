/*
 * Decompiled with CFR 0.152.
 */
final class dm
extends cr {
    private int d;
    private int e;

    dm(byte by2, byte by3, int n2, int n3, int n4, boolean bl2) {
        super(by2, by3, n2);
        this.d = n3 + 8;
        this.e = n4 + 8;
        this.var_boolean_b = bl2;
    }

    final void a(int n2, int n3) {
        if (this.var_s_a == null) {
            this.var_boolean_a = true;
            return;
        }
        this.var_s_a.a(this.c, (byte)1, this.var_int_b % this.var_int_a, n2 += this.d, n3 += this.e);
    }
}

