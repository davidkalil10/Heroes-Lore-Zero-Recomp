/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

final class cj
extends p {
    private as a = null;

    public cj(n n2, as as2) {
        super(n2, (byte)0, (byte)0, (byte)0);
        this.a = as2;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3) || n.f(n2, n3)) {
            this.var_n_a.c();
        }
        return true;
    }

    protected final void a(cm cm2) {
        this.a(cm2, false, true, e.var_ch_b.a(29), false);
        this.b(cm2, this.a_, this.b_ + 13 + 1, this.a);
    }
}

