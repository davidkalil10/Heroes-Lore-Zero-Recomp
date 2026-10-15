/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

final class bu
extends at {
    bu(byte by2) {
        super(by2);
        byte by3 = e.var_s_a.a(this.var_byte_a);
        this.var_int_a = by3;
        this.c = by3;
    }

    bu(byte by2, int n2) {
        this(by2);
        this.c = n2;
    }

    final void a(int n2, int n3) {
        e.var_s_a.a(this.var_byte_a, (byte)1, this.var_int_b % this.var_int_a, n2, n3);
    }

    final void a() {
        ++this.var_int_b;
        if (this.var_int_b >= this.c) {
            this.var_boolean_a = true;
        }
    }
}

