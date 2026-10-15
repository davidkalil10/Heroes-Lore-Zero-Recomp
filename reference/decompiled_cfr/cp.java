/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;

final class cp
extends n {
    private int e = 0;
    private byte[] a = null;

    public cp(n n2, byte by2, byte by3, int n3, boolean bl2, byte[] byArray) {
        super(n2, by2, (byte)0, (byte)0);
        byte by4 = di.var_int_e > n3 * 99 ? (byte)99 : (byte)(di.var_int_e / n3);
        this.var_byte_b = (byte)(this.var_byte_b < 0 || this.var_byte_b > 99 ? 99 : (int)this.var_byte_b);
        byte by5 = by4 = by4 < 0 || by4 > 99 ? (byte)99 : by4;
        if (bl2) {
            this.var_byte_b = this.var_byte_b > by4 ? by4 : this.var_byte_b;
        }
        this.e = n3;
        this.a = byArray;
        this.var_byte_a = 1;
    }

    final boolean boolean_a(int n2, int n3) {
        if (n.g(n2, n3)) {
            this.var_n_a.void_a((byte)0, (byte)0);
            return true;
        }
        if (n.f(n2, n3)) {
            this.var_n_a.void_a((byte)0, this.var_byte_a);
        } else if (n2 == 1 || n3 == 50) {
            if (this.var_byte_a < this.var_byte_b) {
                this.var_byte_a = (byte)(this.var_byte_a + 10);
            }
            if (this.var_byte_a > this.var_byte_b) {
                this.var_byte_a = this.var_byte_b;
            }
        } else if (n2 == 6 || n3 == 56) {
            if (this.var_byte_a == 1) {
                this.var_byte_a = this.var_byte_b;
            } else if (this.var_byte_a > 10) {
                this.var_byte_a = (byte)(this.var_byte_a - 10);
            }
        } else if (n2 == 2 || n3 == 52) {
            if (this.var_byte_a > 1) {
                this.var_byte_a = (byte)(this.var_byte_a - 1);
            }
        } else if ((n2 == 5 || n3 == 54) && this.var_byte_a < this.var_byte_b) {
            this.var_byte_a = (byte)(this.var_byte_a + 1);
        }
        this.d();
        return true;
    }

    protected final void a(cm cm2) {
        int n2 = 56;
        cm cm3 = cm2;
        int n3 = rpg.a.var_int_b - 56 >> 1;
        int n4 = rpg.a.var_int_a - 150 >> 1;
        cm3.b(n4, n3, 150, 56);
        n.b(cm3, n4, n3, 150, 56);
        cm3.a(0);
        cm3.d(n4, n3, 150, 56);
        cm3.a(15723216);
        cm3.d(n4 + 1, n3 + 1, 148, 54);
        int n5 = n3;
        cm2.a(0);
        if (this.a != null) {
            ac.a(cm2, rpg.a.c, n5 + 5, this.a, 1, 1);
        }
        n3 = rpg.a.c - 21;
        n.c(cm2, n3, n5 += 28, 42, 15, 0);
        n.d(cm2, n3 + 1, n5 + 1, 40, 13, 0xFF0000);
        n.a(cm2, n3 - 5, n5 + 6, 51, 0, false);
        n.c(cm2, rpg.a.c, n5 - 5, 22);
        cm2.a(0xFFFFFF);
        ac.a(cm2, rpg.a.c + 1, n5 + 1, ("" + this.var_byte_a).getBytes(), 0, 1);
        if (this.e > 0) {
            this.b(cm2, rpg.a.c + 40, n5 + 19, this.e * this.var_byte_a);
        }
    }
}

