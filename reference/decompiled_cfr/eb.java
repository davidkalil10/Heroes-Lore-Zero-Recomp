/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

public abstract class eb
extends n {
    public byte var_byte_f;
    protected int e = 0;
    protected int var_int_f = 0;
    protected int j = 0;
    protected int k;
    protected int l;
    public static boolean var_boolean_f;
    public static byte g;

    public eb(n n2, int n3, int n4, int n5, byte by2) {
        super(n2, (byte)n3, (byte)n4, (byte)n5);
        this.var_byte_f = by2;
    }

    public final byte a() {
        return this.var_byte_a;
    }

    public static void f(cm cm2, int n2, int n3, int n4, int n5) {
        cm2.b(n2 - 1, n3 - 1, n4 + 2, n5 + 2);
        int n6 = n4 / 20 + 1;
        int n7 = n5 / 20 + 1;
        for (int i2 = 0; i2 < n6; ++i2) {
            for (int i3 = 0; i3 < n7; ++i3) {
                cm2.a(rpg.e.u, n2 + i2 * 20, n3 + i3 * 20, 20);
            }
        }
        cm2.a(15723216);
        cm2.d(n2, n3, n4 - 1, n5 - 1);
        cm2.a(3550755);
        cm2.d(n2 - 1, n3 - 1, n4 + 1, n5 + 1);
    }

    static {
        var_boolean_f = false;
        g = 0;
    }
}

