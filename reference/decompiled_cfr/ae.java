/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;

final class ae
extends eb {
    private byte[] a = null;
    private int m = 1;
    private boolean e = false;
    private cg b = null;
    private cg c = null;

    private ae(n n2, byte[] byArray, byte[][] byArray2, boolean n3) {
        super(n2, byArray2.length, byArray2.length, 1, (byte)6);
        this.a = byArray;
        this.l = byArray2.length;
        for (n3 = 0; n3 < this.l; ++n3) {
            int n4 = ac.a(byArray2[n3]);
            if (n4 <= this.j) continue;
            this.j = n4;
        }
        this.j = !this.e && this.j < rpg.d.f_ - 5 ? rpg.d.f_ : (this.j += 5);
        this.m = 1;
        int n5 = ac.a(byArray);
        if (n5 > this.j) {
            this.j = n5;
        }
        this.j += 11;
        if (this.j > rpg.d.f_) {
            this.j = rpg.d.f_;
            this.m = ac.a(byArray, this.j - 10);
        }
        this.k = this.l + this.m << 4;
        if (!this.e) {
            this.k -= 16;
        }
        this.var_int_f = rpg.a.d - (this.k >> 1);
        ((eb)this).e = rpg.a.c - (this.j >> 1);
        try {
            this.b = cg.a("/sks/yes.png");
            this.c = cg.a("/sks/back.png");
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    private ae(n n2, byte[] byArray, byte by2) {
        this(n2, byArray, rpg.e.var_ch_b.a(2, 3), false);
        this.var_byte_f = by2;
        if (this.var_byte_f == 4) {
            this.var_byte_a = 1;
        }
    }

    ae(n n2, byte[] byArray, byte by2, boolean bl2) {
        this(n2, byArray, 3);
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.var_byte_f == 1) {
            return false;
        }
        if (n2 != -6 && n2 == -7) {
            this.var_n_a.c();
        }
        return true;
    }

    protected final void a(cm cm2) {
        int n2 = cm2.int_a();
        int n3 = cm2.b();
        int n4 = cm2.c();
        int n5 = cm2.d();
        cm2.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
        cm2.a(0);
        cm2.a(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
        if (rpg.e.var_cg_k != null) {
            int n6 = rpg.e.var_cg_k.int_a();
            for (int i2 = 0; i2 < rpg.a.var_int_a; i2 += n6) {
                cm2.a(rpg.e.var_cg_k, i2, 0, 20);
                cm2.a(rpg.e.var_cg_k, i2, rpg.a.var_int_b, 36);
            }
            if (this.c != null) {
                cm2.a(this.c, rpg.a.var_int_a, rpg.a.var_int_b, 40);
            }
        }
        cm2.a(0xFFFFFF);
        if (this.m == 1) {
            ac.a(cm2, rpg.a.c + 1, this.var_int_f + 5 + 1, this.a, 0, 1);
        } else {
            ac.a(cm2, 20, this.var_int_f + 5 + 1, rpg.a.var_int_a - 40, 0, this.a);
        }
        cm2.b(n2, n3, n4, n5);
    }
}

