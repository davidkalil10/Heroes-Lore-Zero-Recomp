/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

public abstract class af
extends cd {
    protected static byte[] var_byte_arr_a;
    protected do var_do_a = null;
    protected boolean var_boolean_b = true;
    protected boolean var_boolean_c = false;
    protected boolean var_boolean_d = false;
    protected boolean e = false;
    protected byte var_byte_a;
    protected byte[] var_byte_arr_b = null;
    protected int var_int_b = -1;
    protected byte[] var_byte_arr_c = null;
    protected byte[] var_byte_arr_d = null;

    protected af(short s2, short s3, short s4, byte by2, s s5) {
        super(s2, s3, s4, by2, s5, true);
        this.var_byte_h = 0;
        this.var_do_a = di.var_do_a;
        this.a((short)-1);
        if (var_byte_arr_a == null) {
            var_byte_arr_a = rpg.e.a("/t/bd");
        }
        g.var_boolean_f = true;
    }

    public static final void void_a_() {
        var_byte_arr_a = null;
    }

    public final void c(int n2) {
    }

    protected final void a(byte[] byArray) {
        g g2 = di.var_g_a;
        for (int i2 = 0; i2 < byArray.length; i2 += 2) {
            try {
                g2.var_du_arr_arr_a[this.t + byArray[i2 + 1]][this.s + byArray[i2]] = this;
                continue;
            }
            catch (Exception exception) {}
        }
    }

    protected final void o() {
    }

    protected final void p() {
        this.n = this.var_dt_a.var_byte_d;
        short s2 = this.var_dt_a.var_short_d;
        this.var_int_j = s2;
        this.var_int_k = s2;
        ((cd)this).d = this.var_dt_a.var_short_b;
        this.var_short_e = this.var_dt_a.var_short_c;
        this.var_short_f = this.var_dt_a.var_short_e;
        this.var_short_g = this.var_dt_a.var_short_f;
    }

    protected final void q() {
    }

    protected final void b(byte[] byArray) {
        g g2 = di.var_g_a;
        for (int i2 = 0; i2 < byArray.length; i2 += 2) {
            try {
                g2.var_du_arr_arr_a[this.t + byArray[i2 + 1]][this.s + byArray[i2]] = null;
                continue;
            }
            catch (Exception exception) {}
        }
    }

    protected final void a(int n2, int n3, boolean bl2) {
        if (!this.var_boolean_b) {
            super.a(n2, n3, bl2);
        }
    }

    protected final void void_b(byte by2) {
        if (this.var_boolean_b) {
            return;
        }
        super.void_b(by2);
    }

    protected final boolean boolean_c() {
        return true;
    }

    public final void c(int n2, int n3) {
    }

    protected final boolean a(byte by2, byte by3) {
        switch (this.var_short_c) {
            case 101: 
            case 102: 
            case 103: 
            case 104: 
            case 105: 
            case 106: 
            case 107: 
            case 108: 
            case 124: 
            case 125: 
            case 126: 
            case 127: 
            case 128: 
            case 129: 
            case 130: 
            case 131: {
                di.var_g_a.b(this);
                break;
            }
            default: {
                di.var_g_a.a(this);
            }
        }
        return true;
    }

    protected void a(al al2, int n2) {
        super.a(al2, n2);
        if (this.var_boolean_d) {
            al2.a(this, n2 / 5, (byte)0, (byte)2);
        }
    }

    protected final int int_a(int n2) {
        super.int_a(n2);
        return n2;
    }

    protected final void a(af af2) {
        this.var_boolean_c = this.var_boolean_c || af2.var_boolean_c;
        this.var_boolean_d = this.var_boolean_d || af2.var_boolean_d;
        this.e = this.e || af2.e;
        af2.e = false;
        af2.var_boolean_d = false;
        af2.var_boolean_c = false;
    }

    public boolean a(do do_, byte by2, int n2, boolean bl2, byte by3, byte by4, boolean bl3, boolean bl4, boolean bl5) {
        if (this.var_boolean_b) {
            return super.a(do_, by2, n2, bl2, by3, by4, bl3, bl4, bl5);
        }
        return super.a(do_, by2, bl5 ? -90 : n2, bl2, by3, by4, bl3, bl4, bl5);
    }

    protected void void_a(int n2, int n3) {
        if (this.var_s_a != null) {
            this.var_s_a.a(this.var_byte_h, this.var_byte_c, this.var_int_c, n2, n3);
        }
    }

    protected void void_e() {
        this.void_a(this.var_byte_arr_c == null ? 0 : this.var_byte_arr_c[this.var_byte_a]);
    }

    static {
        var_byte_arr_a = null;
    }
}

