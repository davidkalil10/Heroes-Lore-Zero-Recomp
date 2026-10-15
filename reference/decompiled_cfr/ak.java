/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

final class ak
extends at {
    private static final byte[] a = new byte[]{17, 19, 8, 18, 17, 9, 16, 16, 17, 18, 19, 13};
    private byte c = (byte)(this.var_byte_a - 11);
    private byte d = 1;

    ak(byte by2) {
        super(by2);
        ((at)this).c = this.var_int_a = (int)e.var_ca_a.a(a[this.c]);
    }

    ak(byte by2, int n2) {
        this(by2);
        ((at)this).c = n2;
    }

    ak(byte by2, byte by3) {
        this(by2);
        if (this.var_byte_a == 15) {
            this.d = by3;
        }
    }

    final void a(int n2, int n3) {
        e.var_ca_a.a(a[this.c], this.d, this.var_int_b % this.var_int_a, n2, n3);
    }

    final void a() {
        ++this.var_int_b;
        if (this.var_int_b >= ((at)this).c) {
            this.var_boolean_a = true;
        }
    }
}

