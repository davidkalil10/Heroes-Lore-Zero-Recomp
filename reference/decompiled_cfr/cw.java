/*
 * Decompiled with CFR 0.152.
 */
import rpg.e;

final class cw
extends cx {
    public static cw a = null;
    private byte[] O = rpg.e.a(af.var_byte_arr_a, 19);

    public cw(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2);
        this.o = (byte)3;
        this.var_byte_arr_b = new byte[]{0};
        if (this.var_short_c == 112 || this.var_short_c == 114) {
            a = this;
        }
    }

    protected final void void_a() {
        if (this.var_byte_b == 6) {
            this.z();
            return;
        }
        switch (this.var_byte_b) {
            case 3: {
                switch (this.var_byte_a) {
                    case 0: {
                        this.var_byte_h = (byte)4;
                        break;
                    }
                    case 2: {
                        this.var_byte_h = (byte)3;
                        break;
                    }
                    case 3: {
                        this.var_byte_h = (byte)4;
                    }
                }
                break;
            }
            case 4: {
                this.var_byte_h = (byte)2;
                break;
            }
            case 100: {
                this.var_byte_h = (byte)9;
                break;
            }
            case 2: {
                this.var_byte_h = 1;
                break;
            }
            default: {
                this.var_byte_h = 0;
            }
        }
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }

    protected final boolean boolean_a(int n2) {
        boolean bl2 = false;
        switch (this.var_byte_a) {
            case 0: {
                bl2 = n2 == 4;
                break;
            }
            case 2: {
                bl2 = n2 == 4;
                break;
            }
            case 3: {
                bl2 = n2 % 3 == 1;
            }
        }
        return bl2;
    }

    protected final void void_b() {
        switch (this.var_byte_a) {
            case 0: {
                new t(3, ((du)this).h, ((du)this).i, this.var_s_a, 7, false, this, this.short_a(), this.var_byte_d, ((cd)this).i);
                return;
            }
            case 2: {
                int by2 = Math.abs(this.O[0] - this.s);
                int n2 = Math.abs(this.O[1] - this.s);
                int n3 = Math.abs(this.O[2] - this.t);
                int n4 = Math.abs(this.O[3] - this.t);
                byte by3 = by2 > n2 ? this.O[0] : this.O[1];
                byte by4 = n3 > n4 ? this.O[2] : this.O[3];
                this.a(by3, by4, true);
                return;
            }
            case 3: {
                new t(13, ((du)this.var_do_a).h, ((du)this.var_do_a).i, this.var_s_a, 5, true, this, this.short_a(), this.var_byte_d, 3);
            }
        }
    }

    protected final boolean boolean_a_() {
        if (this.var_byte_a == 2) {
            this.var_byte_a = (byte)3;
            this.void_a((byte)3);
            return true;
        }
        return false;
    }

    protected final void y() {
        if (this.boolean_j()) {
            if (ap.a == null || ap.a.boolean_b()) {
                if (ap.a != null) {
                    ap.a.void_g();
                    ap.a = null;
                }
                a = null;
                this.void_g();
                return;
            }
            this.void_a((byte)100);
        }
    }
}

