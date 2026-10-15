/*
 * Decompiled with CFR 0.152.
 */
final class aa
extends at {
    private s a;
    private byte c = 0;

    aa(s s2, byte by2) {
        super((byte)-20);
        this.a = s2;
        this.c = by2;
        this.var_int_a = this.a.a(by2);
        ((at)this).c = 1;
    }

    final void a(int n2, int n3) {
        this.a.a(this.c, (byte)1, this.var_int_b % this.var_int_a, n2, n3);
    }

    final void a() {
        ++this.var_int_b;
        if (this.var_int_b >= this.var_int_a) {
            this.var_boolean_a = true;
        }
    }
}

