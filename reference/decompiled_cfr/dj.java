/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;

final class dj
extends eb {
    private int m = 0;
    private byte[][] a = null;

    public dj(n n2, byte[][] byArray, int n3) {
        super(n2, byArray.length, byArray.length, 1, (byte)6);
        this.a = byArray;
        this.l = byArray.length;
        for (int i2 = 0; i2 < this.l; ++i2) {
            int n4 = ac.a(byArray[i2]);
            if (n4 <= this.m) continue;
            this.m = n4;
        }
        this.m += 5;
        this.k = this.l * 14 + 4;
        this.var_int_f = rpg.a.d - (this.k >> 1);
        this.e = rpg.a.c;
        if (n3 == 4) {
            this.e -= this.m + 3;
            return;
        }
        if (n3 == 8) {
            this.e += 3;
            return;
        }
        this.e -= this.m >> 1;
    }

    public dj(n n2, byte[][] byArray) {
        this(n2, byArray, 1);
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.c(n2, n3)) {
            this.var_boolean_a = true;
            return true;
        }
        if (n.f(n2, n3)) {
            this.var_n_a.void_a(this.var_byte_f, this.var_byte_a);
        } else if (n.g(n2, n3)) {
            this.var_n_a.c();
        }
        return true;
    }

    protected final void a(cm cm2) {
        eb.f(cm2, this.e, this.var_int_f, this.m, this.k);
        cm2.a(3550755);
        cm2.a(this.e + 2, this.var_int_f + 2 + this.var_byte_a * 14, this.m - 4, 14);
        int n2 = this.e + (this.m >> 1);
        for (int i2 = 0; i2 < this.l; ++i2) {
            cm2.a(i2 == this.var_byte_a ? 0xFFFFFF : 0);
            ac.a(cm2, n2 + 1, this.var_int_f + 2 + i2 * 14, this.a[i2], 0, 1);
        }
    }
}

