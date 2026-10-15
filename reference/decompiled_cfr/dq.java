/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;

final class dq
extends at {
    private int d;
    private boolean c = false;
    private int e;
    private int f;
    private byte[] a;
    private int j;

    dq(boolean bl2, int n2, byte[] byArray, int n3, int n4) {
        super((byte)-10);
        this.c = bl2;
        this.d = n2;
        this.a = byArray;
        this.var_boolean_b = false;
        if (bl2) {
            this.e = n3 + 8;
            this.f = 0;
            this.j = bs.k;
        } else {
            this.e = 0;
            this.f = n4 - 8 + 2;
            this.j = bs.j;
        }
        this.var_int_a = byArray.length;
    }

    final void a(int n2, int n3) {
        n2 += this.e;
        n3 += this.f;
        cm cm2 = rpg.a.var_cm_a;
        cm2.a(this.d);
        byte by2 = this.a[this.var_int_b];
        if (this.c) {
            cm2.a(n2 - (by2 >> 1), 0, (int)by2, this.j);
            return;
        }
        cm2.a(0, n3 - (by2 >> 1), this.j, (int)by2);
    }
}

