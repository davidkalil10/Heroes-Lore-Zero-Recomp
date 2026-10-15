/*
 * Decompiled with CFR 0.152.
 */
final class cy
extends p {
    private bj var_bj_a = null;
    private as var_as_a = null;
    private byte f;
    private boolean e;
    private byte g;

    public cy(n n2, byte by2) {
        super(n2, (byte)28, (byte)4, (byte)7);
        switch (by2) {
            case 0: {
                this.var_bj_a = di.bj_a();
                break;
            }
            case 2: {
                this.var_bj_a = di.bj_b();
                break;
            }
            case 1: {
                this.var_bj_a = di.bj_c();
            }
        }
        this.g = this.f = by2;
        this.e = true;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            this.var_n_a.c();
            return true;
        }
        if (this.e) {
            if (n3 == 50 || n2 == 1) {
                this.g = (byte)((this.g + 2) % 3);
            } else if (n3 == 56 || n2 == 6) {
                this.g = (byte)((this.g + 1) % 3);
            } else {
                if (n3 == 54 || n2 == 5 || n.f(n2, n3)) {
                    this.var_byte_a = 0;
                    this.e = false;
                    return true;
                }
                return true;
            }
            this.var_n_a.var_n_b = new cy(this.var_n_a, this.g);
            return true;
        }
        if (n.f(n2, n3)) {
            this.var_as_a = this.var_bj_a.as_a(this.var_byte_a);
            if (this.var_as_a == null) {
                return true;
            }
            if (this.var_as_a.boolean_a()) {
                this.var_n_b = new dj((n)this, ax.var_ch_a.a(43, 44, 42, 25));
            } else if (this.var_as_a.b() && !this.var_as_a.c() && dp.boolean_a(this.var_as_a)) {
                this.var_n_b = new dj((n)this, ax.var_ch_a.a(65, 42, 25));
            } else if (cy.boolean_a(this.var_as_a)) {
                this.var_n_b = new dj((n)this, ax.var_ch_a.a(41, 42, 25));
            } else if (this.var_as_a.d()) {
                this.var_n_b = new dj((n)this, ax.var_ch_a.a(42, 25));
            } else {
                this.void_a(this.var_as_a);
            }
            return true;
        }
        if ((n3 == 52 || n2 == 2) && this.var_byte_a % 7 == 0) {
            this.e = true;
            return true;
        }
        if (this.d(n2, n3)) {
            return true;
        }
        this.e(n2, n3);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 == 6) {
            cy cy2 = this;
            if (cy2.var_as_a.boolean_a()) {
                switch (by3) {
                    case 0: 
                    case 1: {
                        di.a(by3 == 0, cy2.var_as_a.var_byte_b);
                        return;
                    }
                    case 2: {
                        cy2.a();
                        return;
                    }
                    case 3: {
                        cy2.void_a(cy2.var_as_a);
                    }
                }
                return;
            }
            if (cy2.var_as_a.b() && !cy2.var_as_a.c() && dp.boolean_a(cy2.var_as_a)) {
                if (by3 == 0) {
                    cy2.var_n_b = new dp(cy2);
                    return;
                }
                if (by3 == 1) {
                    cy2.a();
                    return;
                }
                if (by3 != 2) return;
                cy2.void_a(cy2.var_as_a);
                return;
            }
            if (cy.boolean_a(cy2.var_as_a)) {
                if (by3 == 0) {
                    if (di.var_g_a.var_boolean_d) {
                        cy2.var_n_b = new bt((n)cy2, ax.var_ch_a.a(48), 5, true);
                        return;
                    }
                    cy2.a(ax.var_ch_a.a(45));
                    return;
                }
                if (by3 == 1) {
                    cy2.a();
                    return;
                }
                if (by3 != 2) return;
                cy2.void_a(cy2.var_as_a);
                return;
            }
            if (!cy2.var_as_a.d()) return;
            if (by3 == 0) {
                cy2.a();
                return;
            }
            if (by3 != 1) return;
            cy2.void_a(cy2.var_as_a);
            return;
        }
        if (by2 == 4 && by3 == 0) {
            this.var_bj_a.void_a(this.var_byte_a);
            bs.var_boolean_d = true;
            return;
        }
        if (by2 != 5) return;
        if (by3 != 0) return;
        this.var_bj_a.a((int)this.var_byte_a, 1);
        di.a((byte)7, (byte)2);
    }

    private void a() {
        if (this.var_as_a.c()) {
            this.a(ax.var_ch_a.a(47));
            return;
        }
        this.var_n_b = new bt((n)this, ax.var_ch_a.a(46), 4, true, true);
    }

    protected final void a(cm cm2) {
        this.void_a(cm2, false, true, true, false);
        this.a(cm2, this.f, this.e, 3, true);
        this.a(cm2, this.var_bj_a, this.f, this.e, (byte)7, (byte)4, di.var_int_e);
    }

    private static boolean boolean_a(as as2) {
        return as2.var_byte_a == 20 && as2.var_byte_b == 1;
    }
}

