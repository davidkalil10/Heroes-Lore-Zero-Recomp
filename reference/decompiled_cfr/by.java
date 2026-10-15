/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

final class by
extends cq {
    public by(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2);
        switch (s4) {
            case 106: 
            case 129: {
                this.var_boolean_c = true;
                this.g = 0;
                break;
            }
            case 107: 
            case 130: {
                this.var_boolean_d = true;
                this.g = 1;
                break;
            }
            case 108: 
            case 131: {
                this.e = true;
                this.g = (byte)2;
            }
        }
        this.O = rpg.e.a(af.var_byte_arr_a, 11);
        this.a(this.O);
        cs.a(this, this.g);
    }

    protected final void void_a() {
        switch (this.var_byte_b) {
            case 0: 
            case 1: 
            case 2: 
            case 4: 
            case 5: {
                this.var_byte_h = (byte)(this.boolean_b() ? 2 : 0);
                break;
            }
            case 6: {
                this.var_byte_h = 1;
                break;
            }
            case 7: {
                this.var_byte_h = (byte)2;
            }
        }
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }

    public final void z() {
        this.var_byte_h = (byte)3;
        this.void_a((byte)3);
    }

    public final void A() {
        this.var_byte_h = (byte)(this.g + (this.boolean_b() ? 13 : 4));
        this.void_a((byte)3);
    }

    protected final boolean boolean_a(int n2) {
        if (this.var_byte_h == 3 && n2 == 8) {
            g.a(1);
            new t((byte)(4 + this.g), (short)(((du)this).h + 5), (short)(((du)this).i + 5), this.var_s_a, 12, true, this, this.short_a(), 0, 0);
        }
        return false;
    }

    protected final void void_b() {
    }

    protected final void void_a(byte by2) {
        super.void_a(by2);
        if (this.var_byte_b == 6) {
            this.i = true;
            for (by2 = 1; by2 < 3; by2 = (byte)(by2 + 1)) {
                cs.a[(this.g + by2) % 3].a(this);
            }
        }
    }
}

