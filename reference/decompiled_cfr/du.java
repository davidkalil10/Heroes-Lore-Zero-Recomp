/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;

abstract class du
implements d {
    protected short h;
    protected short i;
    protected byte q;
    protected byte r;
    protected byte s;
    protected byte t;
    boolean j;
    boolean k;
    byte u = 1;
    boolean l = true;
    public du a;
    public du b;
    boolean m = false;

    public abstract void b(int var1, int var2);

    du(short s2, short s3, byte by2, byte by3) {
        this.a(s2, s3);
        this.q = by2;
        this.r = by3;
        this.E();
        s3 = 1;
        du du2 = this;
        this.l = s3;
    }

    protected final void E() {
        this.s = (byte)(this.h >> 4);
        this.t = (byte)(this.i >> 4);
        this.j = (this.h & 0xF) != 0;
        this.k = (this.i & 0xF) != 0;
    }

    final void a(short s2, short s3) {
        this.h = s2;
        this.i = s3;
    }

    public final void d(boolean bl2) {
        this.l = bl2;
    }

    final du a(byte by2, byte by3, byte by4) {
        return du.a(this.s, this.t, by2, by3, by4);
    }

    public static du a(byte by2, byte by3, byte by4, byte by5, byte by6) {
        g g2 = di.var_g_a;
        by2 = (byte)(by2 + d.H[by4]);
        by3 = (byte)(by3 + d.I[by4]);
        switch (by5) {
            case 1: {
                int n2 = by3 - by6;
                by3 = (byte)n2;
                if (n2 >= 0) break;
                return null;
            }
            case 2: {
                int n3 = by3 + by6;
                by3 = (byte)n3;
                if (n3 < g.var_byte_d) break;
                return null;
            }
            case 3: {
                int n4 = by2 - by6;
                by2 = (byte)n4;
                if (n4 >= 0) break;
                return null;
            }
            case 4: {
                int n5 = by2 + by6;
                by2 = (byte)n5;
                if (n5 < g.var_byte_c) break;
                return null;
            }
            default: {
                if (by6 > 0) {
                    return null;
                }
                by2 = (byte)(by2 + d.H[by5]);
                by3 = (byte)(by3 + d.I[by5]);
            }
            case 0: {
                if (by2 >= 0 && by3 >= 0 && by2 < g.var_byte_c && by3 < g.var_byte_d) break;
                return null;
            }
        }
        return g2.var_du_arr_arr_a[by3][by2];
    }

    protected final byte byte_a(du du2) {
        int n2 = this.int_b(du2);
        int n3 = du2.int_b(this);
        return (byte)Math.min(n2, n3);
    }

    private int int_b(du du2) {
        int n2 = Math.abs(du2.s - this.s);
        int n3 = Math.abs(du2.s - (this.s + this.u - 1));
        return Math.min(n2, n3);
    }

    protected final byte byte_b(du du2) {
        int n2 = du2.t - this.t;
        return (byte)Math.abs(n2);
    }

    protected final int int_a(du du2) {
        return this.byte_a(du2) + this.byte_b(du2);
    }
}

