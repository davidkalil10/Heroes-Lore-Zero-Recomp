/*
 * Decompiled with CFR 0.152.
 */
final class dr
extends cl {
    private final byte[] a = new byte[]{2, 2, -1, -1, 0, 10, 1, 0, 0, 1, 0, 3};
    private final byte[] b = new byte[]{0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 2, 0};

    dr(do do_) {
        super(do_);
    }

    public final boolean a(byte by2, int n2) {
        boolean bl2 = n2 == this.a[by2];
        block0 : switch (by2) {
            case 4: {
                dr dr2 = this;
                if (n2 == 0) {
                    dr2.void_a((byte)4);
                    n2 = dr2.var_do_a.int_f((byte)0) / 10;
                    dr2.var_do_a.void_c(-n2);
                    n2 = dr2.int_c((byte)4);
                    dr2.var_do_a.i(n2);
                }
                return true;
            }
            case 5: {
                dr dr3 = this;
                switch (n2) {
                    case 3: {
                        dr3.void_a((byte)5);
                    }
                    case 5: 
                    case 7: 
                    case 9: {
                        di.var_g_a.void_c(2, 2);
                        break;
                    }
                    case 10: {
                        n2 = dr3.int_c((byte)5);
                        dr3.var_do_a.n(n2);
                    }
                }
                return true;
            }
            case 9: {
                if (n2 == 1) {
                    di.var_g_a.void_c(3, 1);
                    break;
                }
                if (n2 != 3) break;
                di.var_g_a.void_c(1, 2);
                break;
            }
            case 10: {
                switch (n2) {
                    case 0: 
                    case 1: 
                    case 2: 
                    case 3: {
                        bl2 = true;
                    }
                }
                break;
            }
            case 11: {
                switch (n2) {
                    case 2: {
                        this.void_a(by2);
                        g.a(1);
                        break block0;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        di.var_g_a.a(new bz(this.var_do_a, 2, 11, -1));
                    }
                }
            }
        }
        if (bl2) {
            if (this.a(this.b[by2], by2, -1, false, false, false)) {
                this.void_c(by2);
            } else {
                return false;
            }
        }
        return true;
    }

    protected final byte byte_a() {
        return 2;
    }

    public final boolean boolean_a(byte by2) {
        switch (by2) {
            case 4: 
            case 5: {
                return true;
            }
        }
        return this.boolean_a();
    }

    public final byte byte_b() {
        return (byte)(this.var_do_a.var_int_b > 0 ? 6 : 2);
    }

    protected final void void_a(byte by2) {
        byte by3 = 6;
        switch (by2) {
            case 11: {
                by3 = 2;
                break;
            }
            case 4: 
            case 5: {
                by3 = 0;
            }
        }
        bq.a(by3);
    }

    public final boolean boolean_b(byte by2) {
        switch (by2) {
            case 4: 
            case 5: {
                return false;
            }
        }
        return true;
    }
}

