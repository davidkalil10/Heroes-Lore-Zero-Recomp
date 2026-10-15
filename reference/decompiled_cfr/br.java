/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;

class br
extends eb {
    private boolean g;
    private int m;
    private byte[] a;
    public boolean e = false;

    public br(n n2, byte[] byArray, char c2) {
        super(n2, 0, 0, 0, (byte)1);
        this.a = byArray;
        this.void_a(ac.a(this.a, rpg.d.var_int_i));
        this.g = false;
    }

    public br(n n2, byte[] byArray, byte by2) {
        this(n2, byArray, '\u0000');
        this.var_byte_f = by2;
    }

    protected final void void_a(int n2) {
        this.l = n2;
        this.j = rpg.d.f_;
        this.k = 18 + this.l * 12 + (this.l - 1 << 1);
        ((eb)this).e = rpg.a.c - (this.j >> 1);
        this.var_int_f = rpg.a.d - (this.k >> 1);
    }

    public br(n n2, byte[] byArray) {
        this(n2, byArray, '\u0000');
        this.j = ac.a(byArray) + 16;
        ((eb)this).e = rpg.a.c - (this.j >> 1);
        this.g = true;
    }

    boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (this.e) {
            if (n2 == -6) {
                this.var_n_a.void_a((byte)3, (byte)0);
            } else if (n2 == -7) {
                this.var_n_a.void_a((byte)3, (byte)1);
            }
            return true;
        }
        if (this.g) {
            return true;
        }
        if (this.var_n_a != null && (n.f(n2, n3) || n.g(n2, n3))) {
            this.var_n_a.void_a(this.var_byte_f, (byte)-1);
        }
        return true;
    }

    protected void a(cm cm2) {
        cm2.a(7228201);
        cm2.d(((eb)this).e - 3, this.var_int_f - 3, this.j + 5, this.k + 5);
        cm2.a(10646341);
        cm2.d(((eb)this).e - 2, this.var_int_f - 2, this.j + 3, this.k + 3);
        eb.f(cm2, ((eb)this).e, this.var_int_f, this.j, this.k);
        cm2.a(7228201);
        cm2.d(((eb)this).e - 1, this.var_int_f - 1, this.j + 1, this.k + 1);
        int n2 = this.var_int_f + 9;
        cm2.a(3550755);
        if (this.g) {
            this.m = this.m > 100 ? 0 : ++this.m;
            int n3 = this.a.length - this.m % 4;
            byte[] byArray = new byte[n3];
            System.arraycopy(this.a, 0, byArray, 0, n3);
            ac.a(cm2, ((eb)this).e + 8, n2, byArray, 0);
            this.var_boolean_a = true;
            return;
        }
        if (this.l == 1) {
            ac.a(cm2, rpg.a.c, n2, this.a, 1, 1);
            return;
        }
        ac.a(cm2, ((eb)this).e + 8, n2, rpg.d.var_int_i, 1, this.a);
    }
}

