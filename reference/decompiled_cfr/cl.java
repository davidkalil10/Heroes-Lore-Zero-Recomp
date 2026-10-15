/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;
import rpg.d;
import rpg.e;
import rpg.g;

abstract class cl
implements d {
    protected do var_do_a;
    private byte[] var_byte_arr_a;
    private short[] var_short_arr_a;
    private short[] b;

    public abstract boolean boolean_a(byte var1);

    public abstract boolean a(byte var1, int var2);

    public abstract boolean boolean_b(byte var1);

    protected abstract byte byte_a();

    protected abstract void void_a(byte var1);

    cl(do do_) {
        this.var_do_a = do_;
    }

    public final void void_b(byte n2) {
        int n3;
        byte[] byArray = e.a("/hero/hsd1");
        int n4 = 0;
        for (n3 = 0; n3 < n2; ++n3) {
            n4 += 56;
        }
        n3 = 0;
        this.var_byte_arr_a = new byte[24];
        this.var_short_arr_a = new short[6];
        this.b = new short[6];
        for (n2 = 0; n2 < 8; ++n2) {
            System.arraycopy(byArray, n4, this.var_byte_arr_a, n3, 3);
            n3 += 3;
            if (n2 < 6) {
                this.var_short_arr_a[n2] = g.short_b(byArray, n4 + 3);
                this.b[n2] = g.short_b(byArray, n4 + 5);
            }
            n4 += 7;
        }
    }

    public final int int_a(byte by2) {
        int n2 = by2 - 4;
        by2 = (byte)n2;
        if (n2 < 0 || by2 >= 6) {
            return 0;
        }
        return this.b[by2];
    }

    public final int int_b(byte by2) {
        int n2 = by2 - 4;
        by2 = (byte)n2;
        if (n2 < 0 || by2 >= 6) {
            return 0;
        }
        return this.var_short_arr_a[by2];
    }

    protected final int int_c(byte by2) {
        int n2 = (by2 - 4) * 3;
        return this.a((int)di.var_do_a.byte_a(by2), n2);
    }

    protected final int a(byte by2, int n2, boolean bl2) {
        int n3;
        int n4 = n3 = (by2 - 4) * 3;
        n3 = bl2 ? 1 : 0;
        int n5 = n2;
        n2 = di.var_do_a.byte_a(by2);
        cl cl2 = this;
        n2 = cl2.var_byte_arr_a[n4] + cl2.var_byte_arr_a[n4 + 1] * n2;
        n2 = n3 != 0 ? (n2 += n5) : (n2 *= n5);
        return n2 /= cl2.var_byte_arr_a[n4 + 2];
    }

    private final int a(int n2, int n3) {
        n2 = this.var_byte_arr_a[n3] + this.var_byte_arr_a[n3 + 1] * n2;
        return n2 /= this.var_byte_arr_a[n3 + 2];
    }

    protected final int a(byte by2, boolean bl2) {
        int n2 = this.a(by2, this.var_do_a.int_a(bl2), false);
        by2 = (byte)n2;
        int n3 = n2 + this.var_do_a.int_c(bl2);
        by2 = (byte)n3;
        return n3;
    }

    protected final boolean boolean_a() {
        return this.var_do_a.bm_a((byte)3) != null;
    }

    protected final boolean boolean_b() {
        return this.var_do_a.bm_a((byte)5) != null;
    }

    public byte byte_b() {
        int n2 = this.a((int)di.var_do_a.byte_a((byte)10), 18);
        return (byte)(n2 > 4 ? 4 : n2);
    }

    protected final void void_c(byte by2) {
        if (do.var_byte_h > 0 && by2 < 4) {
            bq.a(do.var_byte_h);
        } else {
            this.void_a(by2);
        }
        do.var_byte_h = (byte)-1;
    }

    protected final boolean a(byte by2, byte by3, int n2, boolean bl2, boolean bl3, boolean n3) {
        n2 = 0;
        Vector vector = this.var_do_a.java_util_Vector_b(by2);
        if (vector == null) {
            return false;
        }
        n3 = vector.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            cd cd2 = (cd)vector.elementAt(i2);
            if (cd2 == null || !cd2.a(this.var_do_a, by3, -1, bl2, this.var_do_a.var_byte_c, this.byte_a(), bl3, true, false)) continue;
            n2 = 1;
        }
        return n2 != 0;
    }
}

