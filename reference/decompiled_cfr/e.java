/*
 * Decompiled with CFR 0.152.
 */
final class e
extends cx {
    public e(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2);
        this.var_byte_arr_b = rpg.e.a(af.var_byte_arr_a, 21);
    }

    protected final void void_a() {
        if (this.var_byte_b == 6) {
            this.z();
            return;
        }
        switch (this.var_byte_b) {
            case 3: {
                switch (this.var_byte_a) {
                    case 1: {
                        this.var_byte_h = (byte)7;
                        break;
                    }
                    case 4: {
                        this.var_byte_h = (byte)3;
                        break;
                    }
                    case 5: {
                        this.var_byte_h = (byte)4;
                        break;
                    }
                    case 6: {
                        this.var_byte_h = (byte)5;
                        break;
                    }
                    case 7: {
                        this.var_byte_h = (byte)6;
                    }
                }
                break;
            }
            case 4: {
                this.var_byte_h = (byte)2;
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
            case 1: {
                bl2 = n2 == 4;
                break;
            }
            case 4: 
            case 5: {
                bl2 = n2 == 2 || n2 == 5 || n2 == 7;
                break;
            }
            case 6: {
                bl2 = n2 == 15;
                break;
            }
            case 7: {
                bl2 = n2 >= 3 && n2 % 2 == 0;
            }
        }
        return bl2;
    }

    protected final boolean boolean_a_() {
        int n2 = (this.var_int_b + 1) % this.var_byte_arr_b.length;
        byte by2 = this.var_byte_arr_b[n2];
        boolean bl2 = false;
        switch (by2) {
            case 10: {
                bl2 = true;
                this.var_int_b = n2;
                this.var_byte_a = by2;
                this.p = (byte)3;
                break;
            }
            case 11: {
                bl2 = true;
                this.var_int_b = n2;
                this.var_byte_a = by2;
                this.p = (byte)100;
                break;
            }
            case 1: {
                if (this.int_a((du)this.var_do_a) < 3) {
                    this.var_int_b = n2;
                    this.var_byte_a = by2;
                    break;
                }
                bl2 = true;
                this.var_int_b = n2;
                this.var_byte_a = by2;
                this.void_a((byte)3);
                break;
            }
            case 6: 
            case 7: {
                bl2 = true;
                this.var_int_b = n2;
                this.var_byte_a = by2;
                this.void_a((byte)3);
            }
        }
        return bl2;
    }

    protected final void void_b() {
        switch (this.var_byte_a) {
            case 1: {
                this.a(this.var_do_a.s, this.var_do_a.t, false);
                return;
            }
            case 4: 
            case 5: {
                boolean bl2;
                this.var_do_a.var_int_j = 0;
                if (this.var_int_c == 2) {
                    bl2 = this.boolean_l();
                } else {
                    boolean bl3 = bl2 = this.boolean_m();
                }
                if (!bl2) break;
                if (this.var_byte_a == 4) {
                    if (!this.var_do_a.boolean_h()) {
                        this.var_do_a.g(50);
                    }
                    if (!this.var_do_a.boolean_h()) {
                        this.var_do_a.c(60, 30);
                    }
                    this.var_do_a.a(new aa(this.var_s_a, 9));
                    return;
                }
                if (this.var_byte_a != 5) break;
                this.h(this.var_do_a.var_int_j);
                this.var_do_a.a(new aa(this.var_s_a, 8));
                return;
            }
            case 6: {
                for (int i2 = 0; i2 < 15; ++i2) {
                    int n2;
                    int n3 = this.s + (Math.abs(al.var_java_util_Random_a.nextInt()) & 0xFF) % 7 + -3;
                    if (g.boolean_a(n3, n2 = this.t + (Math.abs(al.var_java_util_Random_a.nextInt()) & 0xFF) % 7 + -3)) continue;
                    new t(13, (short)(n3 << 4), (short)(n2 << 4), this.var_s_a, 10, true, this, this.short_a(), this.var_byte_d, 3);
                }
                return;
            }
            case 7: {
                new t(13, ((du)this.var_do_a).h, ((du)this.var_do_a).i, this.var_s_a, 11, true, this, this.short_a(), this.var_byte_d, 3);
            }
        }
    }

    protected final void void_a(int n2, int n3) {
        switch (this.var_byte_b) {
            case 6: {
                rpg.e.var_s_a.a((byte)0, (byte)1, this.var_int_c, n2, n3);
                return;
            }
        }
        this.var_s_a.a(this.var_byte_h, this.var_byte_h == 5 ? (byte)1 : this.var_byte_c, this.var_int_c, n2, n3);
    }
}

