/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

final class bb
extends br {
    private byte[] a = new byte[9];
    private int m = 0;

    public bb(dd dd2, byte[] byArray) {
        super((n)dd2, byArray, '\u0000');
        this.var_byte_c = 1;
        this.var_byte_d = (byte)10;
        this.var_byte_b = (byte)10;
        this.void_a(this.l + 3);
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            this.var_n_a.c();
            return true;
        }
        if (n.f(n2, n3)) {
            bb bb2 = this;
            n3 = 0;
            for (int i2 = bb2.a.length - 1; i2 >= 0; --i2) {
                n3 = n3 * 10 + bb2.a[i2];
            }
            int n4 = n3;
            if (n4 > de.var_int_f) {
                this.var_n_b = new br((n)this, rpg.e.var_ch_h.a(25), '\u0000');
            } else {
                ((dd)this.var_n_a).e = n4;
                this.var_n_a.c();
            }
            return true;
        }
        if (n3 == 52 || n2 == 2) {
            ++this.m;
            if (this.m > 8) {
                this.m = 0;
            }
            this.var_byte_a = this.a[this.m];
            return true;
        }
        if (n3 == 54 || n2 == 5) {
            --this.m;
            if (this.m < 0) {
                this.m = 8;
            }
            this.var_byte_a = this.a[this.m];
            return true;
        }
        return this.e(n2, n3);
    }

    protected final boolean e(int n2, int n3) {
        if (n3 == 50 || n2 == 1) {
            this.void_a((byte)4);
            this.a[this.m] = this.var_byte_a;
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            this.void_a((byte)3);
            this.a[this.m] = this.var_byte_a;
            return true;
        }
        return false;
    }

    protected final void a(cm cm2) {
        super.a(cm2);
        int n2 = this.var_int_f + 25;
        int n3 = ((eb)this).e + 20;
        n.a(cm2, this.a, n3, n2 + 16, 8);
        n.a(cm2, n3 - 8, n2 + 19, 86, 3550755, false);
        n.c(cm2, n3 + 2 + (8 - this.m << 3), n2 + 12, 12);
        ac.a(cm2, ((eb)this).e + 10, n2 + 33, rpg.e.var_ch_b.a(31), 0);
        this.b(cm2, ((eb)this).e + 105, n2 + 34, de.var_int_f);
    }
}

