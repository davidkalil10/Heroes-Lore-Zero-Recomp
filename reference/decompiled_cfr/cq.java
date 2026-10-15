/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

class cq
extends af {
    protected byte[] O = null;
    private byte[] P = null;
    private byte o;
    private byte p;
    protected byte g;
    protected boolean i = false;
    private static byte v = (byte)8;
    private static byte w = (byte)13;

    public cq(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, dt.var_dt_arr_a[cs.g].var_s_a);
        s2 = 1;
        switch (s4) {
            case 102: 
            case 125: {
                this.var_boolean_c = true;
                this.g = 0;
                this.o = (byte)19;
                this.p = (byte)41;
                break;
            }
            case 103: 
            case 126: {
                this.t = (byte)5;
                this.var_boolean_d = true;
                this.g = 1;
                this.o = (byte)7;
                this.p = (byte)26;
                break;
            }
            case 104: 
            case 127: {
                this.e = true;
                this.g = (byte)2;
                this.o = (byte)5;
                this.p = (byte)38;
                break;
            }
            default: {
                s2 = 0;
            }
        }
        if (s2 != 0) {
            this.P = rpg.e.a(af.var_byte_arr_a, 10);
            this.O = rpg.e.a(af.var_byte_arr_a, 5 + this.g);
            this.a(this.O);
            cs.a(this, this.g);
        }
        this.void_c((byte)1);
        this.void_a((byte)1);
    }

    protected void void_a() {
        switch (this.var_byte_b) {
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: {
                this.var_byte_h = (byte)(this.g + (this.boolean_b() ? 4 : 1));
                break;
            }
            case 6: {
                this.var_byte_h = (byte)(8 + this.g);
                break;
            }
            case 7: {
                this.var_byte_h = (byte)(4 + this.g);
            }
        }
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }

    public void z() {
        this.var_byte_h = (byte)(11 + this.g);
        this.void_a((byte)3);
    }

    public void A() {
        this.var_byte_h = (byte)(this.g + (this.boolean_b() ? 18 : 15));
        this.void_a((byte)3);
    }

    public final void void_g() {
        this.i = true;
        this.void_a((byte)1);
    }

    protected final void void_k() {
    }

    protected final boolean boolean_b() {
        return this.i || this.int_c() <= 0;
    }

    protected boolean boolean_a(int n2) {
        if (this.var_byte_h == (byte)(11 + this.g)) {
            if (n2 == 6) {
                g.a(1);
            } else if (n2 == 7) {
                new t(2, (short)(((du)this).h + this.o), (short)(((du)this).i + this.p), this.var_s_a, 21, true, null, 0, 0, 0);
            }
            return n2 >= v && n2 <= w && n2 % 2 == 0;
        }
        return false;
    }

    protected void void_b() {
        int n2 = this.s + this.P[this.g << 1];
        int n3 = this.s + this.P[(this.g << 1) + 1];
        al[] alArray = cd.al_arr_a();
        for (int i2 = 0; i2 < 2; ++i2) {
            if (alArray[i2] == null || alArray[i2].s < n2 || alArray[i2].s > n3) continue;
            this.b(alArray[i2], (int)this.short_a(), (byte)2);
            if (!alArray[i2].boolean_g()) continue;
            alArray[i2].void_b((byte)2);
        }
    }

    protected final void void_m() {
        this.b(this.O);
    }
}

