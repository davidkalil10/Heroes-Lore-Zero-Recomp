/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.e;
import rpg.f;

final class aw
extends de {
    public aw(n n2) {
        super(n2, (byte)2);
        this.var_byte_a = 0;
        this.f();
        de.h();
        di.m();
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
            switch (this.var_byte_a) {
                case 0: {
                    this.var_n_b = new w(this);
                    break;
                }
                case 1: {
                    this.var_n_b = new dk(this, 0);
                }
            }
            return true;
        }
        return this.c(n2, n3);
    }

    protected final void a(cm cm2) {
        rpg.a.a(cm2, true);
        int n2 = rpg.f.e;
        cm2.a(14597755);
        ac.a(cm2, rpg.a.c, rpg.a.d - 64, rpg.e.var_ch_b.a(9), 0, 1);
        for (byte by2 = 0; by2 < 2; by2 = (byte)(by2 + 1)) {
            int n3 = this.b_ + 25 + by2 * 17;
            n.a(cm2, this.a_, n3, n2, 15, this.var_byte_a == by2 ? 0x660000 : 3550755, this.var_byte_a == by2 ? 0xBD0000 : 7027456);
            cm2.a(this.var_byte_a == by2 ? 0xFFFFFF : 12630160);
            ac.a(cm2, rpg.a.c, n3, rpg.e.var_ch_h.a(by2 + 18), 0, 1);
        }
        n.a(cm2, 3);
    }
}

