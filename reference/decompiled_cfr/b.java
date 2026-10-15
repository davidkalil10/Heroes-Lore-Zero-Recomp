/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

abstract class b
extends n {
    b(n n2, byte by2, byte by3, byte by4) {
        super(n2, by2, by3, by4);
    }

    b(n n2, byte by2) {
        this(n2, by2, 1, 1);
    }

    protected final void a(cm cm2, int n2, int n3, int n4, int n5, int n6) {
        int n7 = n.int_a(n4);
        int n8 = n2;
        if (n6 == 8) {
            n8 = n2 - (n7 + 7 + n.int_a(n5));
        } else if (n6 == 1) {
            n8 = n2 - (n7 + 7 + n.int_a(n5) >> 1);
        }
        n.b(cm2, n4, n8, n3, 4, 0);
        cm2.b(n8 + n7, n3, 7, 7);
        cm2.a(rpg.e.w, n8 + n7 - 7, n3, 20);
        n.b(cm2, n5, n8 + n7 + 7, n3, 4, 0);
    }

    protected static void a(cm cm2, int n2, int n3) {
        cm2.a(0xFFFFFF);
        for (int i2 = 0; i2 < 3; ++i2) {
            cm2.e(n2 + (i2 << 2), n3, n2 + (i2 << 2) + 2, n3);
        }
    }

    protected final void a(byte[] byArray) {
        this.var_n_b = new br((n)this, byArray, '\u0000');
    }
}

