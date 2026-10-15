/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;

final class bt
extends eb {
    private int m = 0;
    private byte[] var_byte_arr_a = null;
    private byte[][] var_byte_arr_arr_a = null;
    private int n;
    private int o = 1;
    private boolean e = true;
    private boolean g = false;
    private boolean h = true;

    bt(n n2, byte[] byArray, byte[][] byArray2, boolean n3) {
        super(n2, byArray2.length, byArray2.length, 1, (byte)6);
        this.h = n3;
        this.var_byte_arr_a = byArray;
        this.var_byte_arr_arr_a = byArray2;
        this.l = byArray2.length;
        for (n3 = 0; n3 < this.l; ++n3) {
            int n4 = ac.a(byArray2[n3]);
            if (n4 <= this.j) continue;
            this.j = n4;
        }
        this.j = !this.h && this.j < rpg.d.f_ - 5 ? rpg.d.f_ : (this.j += 5);
        this.o = 2;
        int n5 = this.j;
        int n6 = ac.a(byArray);
        if (n6 > this.j) {
            this.j = n6;
        }
        this.j += 11;
        if (this.j > rpg.d.f_) {
            this.j = rpg.d.f_;
            this.o = ac.a(byArray, this.j - 10);
        }
        this.k = (this.l + this.o << 4) + 10 + 3;
        if (!this.h) {
            this.k -= 16;
        }
        this.var_int_f = rpg.a.d - (this.k >> 1);
        ((eb)this).e = rpg.a.c - (this.j >> 1);
        this.n = 4;
        this.m = rpg.a.c - (n5 >> 1);
        this.g = false;
    }

    bt(n n2, byte[] byArray, byte[][] byArray2) {
        this(n2, byArray, byArray2, true);
    }

    bt(n n2, byte[] byArray, byte by2, boolean bl2) {
        this(n2, byArray, rpg.e.var_ch_b.a(2, 3), false);
        this.var_byte_f = by2;
        this.n = 1;
        this.m = rpg.a.c + 1;
        this.e = bl2;
        if (this.var_byte_f == 4) {
            this.var_byte_a = 1;
        }
        if (by2 == 3) {
            this.g = true;
        }
    }

    bt(n n2, byte[] byArray, byte by2, boolean bl2, boolean bl3) {
        this(n2, byArray, by2, bl2);
        this.g = true;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.h) {
            if (this.c(n2, n3)) {
                this.var_boolean_a = true;
                return true;
            }
        } else if (this.d(n2, n3)) {
            this.var_boolean_a = true;
            return true;
        }
        if (n.f(n2, n3)) {
            this.var_n_a.void_a(this.var_byte_f, this.var_byte_a);
        } else if (this.g && n.g(n2, n3)) {
            this.var_n_a.void_a(this.var_byte_f, (byte)1);
        }
        return true;
    }

    protected final void a(cm cm2) {
        int n2;
        int n3;
        if (this.e) {
            eb.f(cm2, ((eb)this).e, this.var_int_f, this.j, this.k);
            cm2.a(15723216);
            cm2.d(((eb)this).e, this.var_int_f, this.j - 1, this.k - 1);
            cm2.a(3550755);
        } else {
            int n4 = this.k;
            int n5 = this.j;
            n3 = this.var_int_f;
            n2 = ((eb)this).e;
            cm cm3 = cm2;
            cm3.b(n2 - 1, n3 - 1, n5 + 2, n4 + 2);
            cm3.a(3550755);
            cm3.a(n2 - 1, n3 - 1, n5 + 2, n4 + 2);
            cm3.a(7027456);
            cm3.d(n2, n3, n5 - 1, n4 - 1);
            cm2.a(0x660000);
        }
        if (this.h) {
            cm2.a(((eb)this).e + 2, this.var_int_f + 5 + (this.var_byte_a + this.o << 4) + 3, this.j - 4, 16);
        }
        if (!this.e) {
            cm2.a(0xFFFFFF);
        }
        if (this.o == 1) {
            ac.a(cm2, rpg.a.c + 1, this.var_int_f + 5 + 1, this.var_byte_arr_a, 0, 1);
        } else {
            ac.a(cm2, ((eb)this).e + 5, this.var_int_f + 5 + 1, this.j - 10, 0, this.var_byte_arr_a);
        }
        if (this.h) {
            for (int i2 = 0; i2 < this.l; ++i2) {
                cm2.a(i2 == this.var_byte_a ? 0xFFFFFF : (this.e ? 0 : 12630160));
                ac.a(cm2, this.m, this.var_int_f + 5 + 1 + (i2 + this.o << 4) + 3, this.var_byte_arr_arr_a[i2], 0, this.n);
            }
            return;
        }
        n2 = this.var_int_f + 5 + 1 + (this.o << 4) + 3;
        for (n3 = 0; n3 < this.l; ++n3) {
            int n6 = rpg.a.c - 30 + n3 * 60;
            if (n3 == this.var_byte_a) {
                cm2.a(0x660000);
                cm2.a(n6 - 26, n2 - 1, 52, 15);
            }
            cm2.a(n3 == this.var_byte_a ? 0xFFFFFF : (this.e ? 0 : 12630160));
            ac.a(cm2, n6, n2, this.var_byte_arr_arr_a[n3], 0, 1);
        }
    }
}

