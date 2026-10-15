/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;
import rpg.e;

abstract class cx
extends af {
    protected boolean i = false;
    protected byte o = (byte)-1;
    protected byte p = (byte)100;

    public cx(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, dt.var_dt_arr_a[by2].var_s_a);
        this.var_boolean_b = false;
        this.var_byte_arr_c = rpg.e.a(af.var_byte_arr_a, 18);
        this.u();
    }

    protected final void void_f() {
        this.var_al_a = this.var_do_a;
    }

    protected final void void_k() {
        if (this.var_short_a <= 0 && !this.var_boolean_f) {
            this.void_f();
            int n2 = this.int_a((du)this.var_do_a);
            if (n2 < this.o) {
                this.var_byte_a = (byte)2;
                this.void_a((byte)3);
                return;
            }
            if (n2 > this.p) {
                this.var_byte_a = 1;
                this.void_a((byte)3);
                return;
            }
            if (!this.boolean_a_() && !this.a((du)this.var_al_a, ((cd)this).i) && this.boolean_a((du)this.var_al_a)) {
                cx cx2 = this;
                this.var_int_b = (cx2.var_int_b + 1) % cx2.var_byte_arr_b.length;
                cx2.var_byte_a = cx2.var_byte_arr_b[cx2.var_int_b];
                this.void_a((byte)3);
            }
        }
    }

    protected abstract boolean boolean_a_();

    protected void void_a(int n2, int n3) {
        switch (this.var_byte_b) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                this.var_s_a.a(this.var_byte_h, this.var_byte_c, this.var_int_c, n2, n3);
                return;
            }
            case 6: {
                rpg.e.var_s_a.a(this.var_byte_h, (byte)1, this.var_int_c, n2, n3);
                return;
            }
            case 100: {
                this.var_s_a.a(this.var_byte_h, (byte)1, this.var_int_c, n2, n3);
            }
        }
    }

    protected final void a(byte by2, byte by3, boolean bl2) {
        g g2 = di.var_g_a;
        byte by4 = bl2 ? (byte)0 : this.var_do_a.var_byte_c;
        int n2 = 0;
        do {
            byte by5;
            byte by6;
            if (g2.a(this, (int)(by6 = (byte)(by2 + rpg.d.H[by4])), (int)(by5 = (byte)(by3 + rpg.d.I[by4])))) {
                this.v();
                this.a((short)(by6 << 4), (short)(by5 << 4));
                this.E();
                this.u();
                this.void_c(rpg.d.N[bl2 ? this.var_byte_c : this.var_do_a.var_byte_c]);
                return;
            }
            if ((by4 = (byte)(by4 + 1)) <= 4) continue;
            by4 = 1;
        } while (n2++ < 5);
    }

    protected final boolean boolean_l() {
        byte[] byArray = new byte[]{rpg.d.H[this.var_byte_c], rpg.d.I[this.var_byte_c], (byte)(rpg.d.H[this.var_byte_c] << 1), (byte)(rpg.d.I[this.var_byte_c] << 1), (byte)(rpg.d.H[this.var_byte_c] * 3), (byte)(rpg.d.I[this.var_byte_c] * 3)};
        return this.a(byArray, this.short_a(), this.i);
    }

    protected final boolean boolean_m() {
        byte[] byArray = new byte[]{rpg.d.H[this.var_byte_c], rpg.d.I[this.var_byte_c], rpg.d.H[rpg.d.K[this.var_byte_c]], rpg.d.I[rpg.d.K[this.var_byte_c]], rpg.d.H[rpg.d.J[this.var_byte_c]], rpg.d.I[rpg.d.J[this.var_byte_c]]};
        return this.a(byArray, this.short_a(), this.i);
    }

    protected final boolean boolean_b() {
        return super.boolean_b() || this.var_byte_b == 100;
    }

    final void void_b(byte by2, int n2) {
        if (!this.boolean_b()) {
            super.void_b(by2, n2);
        }
    }

    final void void_a(byte by2, byte by3, int n2) {
        if (!this.boolean_b()) {
            super.void_a(by2, by3, n2);
        }
    }

    final boolean boolean_a(byte by2, int n2) {
        if (!this.boolean_b()) {
            return super.boolean_a(by2, n2);
        }
        return true;
    }

    final boolean boolean_a(byte by2) {
        if (!this.boolean_b()) {
            return super.boolean_a(by2);
        }
        return true;
    }

    protected final void z() {
        this.var_byte_h = 0;
        this.var_int_f = this.var_s_a.a(this.var_byte_h);
    }
}

