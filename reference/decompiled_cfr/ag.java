/*
 * Decompiled with CFR 0.152.
 */
final class ag
extends cd {
    private boolean b = false;

    protected ag(short s2, short s3, short s4, byte by2) {
        super(s2, s3, s4, by2, dt.var_dt_arr_a[by2].var_s_a, false);
        if (this.var_short_c == bc.b) {
            ++bc.e;
        }
    }

    protected final void void_b() {
        boolean bl2 = false;
        boolean bl3 = false;
        for (byte by2 = 1; by2 <= 8; by2 = (byte)(by2 + 1)) {
            du du2 = this.a(by2, null);
            if (du2 == null) continue;
            if (du2 instanceof do && !bl2) {
                bl2 = true;
                this.b((al)du2, (int)this.var_short_f, by2);
            }
            if (!(du2 instanceof h) || bl3) continue;
            bl3 = true;
            this.b((al)du2, (int)this.var_short_f, by2);
        }
    }

    protected final void void_e() {
        this.b = true;
        this.a(null, this.var_int_k);
        this.boolean_a();
    }

    protected final void void_a(byte by2) {
        if (by2 == 6) {
            if (this.var_short_c == bc.b) {
                --bc.e;
            }
            by2 = (byte)7;
        }
        super.void_a(by2);
    }

    protected final void o() {
        if (!this.b) {
            super.o();
        }
    }

    protected final void void_i() {
        this.b = false;
        super.void_i();
    }

    protected final void n() {
        if (!this.b) {
            super.n();
        }
    }
}

