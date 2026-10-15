/*
 * Decompiled with CFR 0.152.
 */
final class dx
extends du {
    private byte var_byte_a;
    private int var_int_a = -1;

    dx(byte by2, short s2, short s3) {
        super(s2, s3, (byte)0, (byte)0);
        this.var_byte_a = by2;
        this.var_int_a = di.var_g_a.int_a(s2 - 8 >> 4, s3 - 16 >> 4);
        if (this.var_int_a != -1 && this.var_int_a < 0) {
            this.var_int_a += 256;
        }
    }

    public final void b(int n2, int n3) {
        if (g.var_boolean_b || !this.l) {
            return;
        }
        if ((n3 = n3 + this.i + this.r) + 16 < 0) {
            return;
        }
        n2 = n2 + this.h + this.q;
        dx dx2 = this;
        boolean bl2 = dx2.var_int_a >= 19 && dx2.var_int_a <= 21 || dx2.var_int_a == 9 ? di.bj_a((byte)19).int_a((byte)19, (byte)dx2.var_int_a) > 0 : dx2.var_int_a > 0 && di.boolean_a(dx2.var_int_a);
        if (bl2) {
            g.void_a(n2, n3);
            return;
        }
        di.var_g_a.a(this.var_byte_a, n2, n3);
    }
}

