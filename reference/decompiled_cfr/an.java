/*
 * Decompiled with CFR 0.152.
 */
final class an
extends cs {
    public an(short s2, short s3, short s4, byte by2) {
        super((short)1, (short)1, s4, by2);
    }

    protected final void void_a(int n2, int n3) {
    }

    protected final boolean boolean_a(int n2) {
        if (this.var_byte_a == 3) {
            switch (n2) {
                case 9: {
                    g.a(1);
                    break;
                }
                case 10: {
                    di.var_g_a.void_c(5, 2);
                    new t(0, 180, 170, this.var_s_a, 11, false, null, 0, 0, 0);
                }
            }
            return n2 == 10;
        }
        return false;
    }

    protected final void void_b() {
        al[] alArray = cd.al_arr_a();
        for (int i2 = 0; i2 < 2; ++i2) {
            if (alArray[i2] == null || alArray[i2].t > this.t + 10) continue;
            this.b(alArray[i2], (int)this.short_a(), (byte)2);
            if (!alArray[i2].boolean_g()) continue;
            alArray[i2].void_b((byte)3);
        }
    }

    protected final void void_a() {
        switch (this.var_byte_b) {
            case 3: {
                this.var_byte_h = (byte)4;
                break;
            }
            case 6: {
                this.var_byte_h = 1;
                break;
            }
            default: {
                this.var_byte_h = 0;
            }
        }
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }
}

