/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;

final class cu
extends cl {
    private final byte[] var_byte_arr_a = new byte[]{1, 1, 2, 2, 5, 4, 5, 2, 2, -1, -1};
    private final byte[] b = new byte[]{3, 0, 6};
    private final byte[] c = new byte[]{0, 0, 0, 0, 0, 0, 2};
    private final byte[] d = new byte[]{40, 45, 45, 40, 27, 27, 27, 27, 27, 27, 27, 27, 10, -2, 4};
    private boolean var_boolean_a = false;
    private cd var_cd_a = null;

    cu(do do_) {
        super(do_);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean a(byte by2, int n2) {
        int n3 = 0;
        int n4 = n2 == this.var_byte_arr_a[by2] ? 1 : 0;
        switch (by2) {
            case 0: 
            case 1: 
            case 2: {
                if (n2 == this.b[by2]) {
                    n3 = 1;
                    n4 = 1;
                }
            }
            case 3: {
                if (n4 == 0) return true;
                if (!this.a(this.c[(by2 << 1) + (n3 != 0 ? 1 : 0)], by2, -1, false, n3 != 0, false)) return false;
                this.void_c(by2);
                return true;
            }
            case 4: {
                cu cu2 = this;
                n3 = 1;
                switch (n2) {
                    case 0: {
                        cu2.var_boolean_a = false;
                        return n3 != 0;
                    }
                    case 2: 
                    case 5: {
                        n2 = cu2.a((byte)4, cu2.var_do_a.int_b((byte)1), true);
                        int n5 = n2 = rpg.g.a(0, 99) < n2 ? -100 : -2;
                        if (cu2.var_do_a.a((byte)4, (byte)2, (byte)11, n2)) {
                            cu2.void_a((byte)4);
                        } else {
                            n3 = 0;
                        }
                        cu2.var_boolean_a = cu2.var_do_a.var_byte_g > 0;
                        return n3 != 0;
                    }
                    case 4: 
                    case 6: {
                        if (!cu2.var_boolean_a) return n3 != 0;
                        cu2.var_do_a.void_c(rpg.d.N[cu2.var_do_a.var_byte_c]);
                        cu2.var_boolean_a = false;
                        return n3 != 0;
                    }
                }
                return n3 != 0;
            }
            case 5: {
                cu cu3 = this;
                switch (n2) {
                    case 4: {
                        cd cd2 = cu3.var_do_a.cd_a();
                        if (cd2 != null && !cd2.boolean_b()) {
                            if (rpg.g.a(0, 99) < cu3.int_c((byte)5)) {
                                n4 = cu3.var_do_a.int_c(false);
                                cd2.c(75, n4);
                            } else {
                                cd2.D();
                            }
                        }
                        cu3.void_a((byte)5);
                    }
                    case 6: {
                        di.var_g_a.void_c(2, n2);
                        return true;
                    }
                }
                return true;
            }
            case 6: {
                cu cu4 = this;
                n3 = 0;
                n4 = 0;
                if (n2 > 0 && n2 < 13) {
                    di.var_g_a.void_c(cu4.d[n2 - 1] >> 1, 2);
                }
                switch (n2) {
                    case 1: {
                        cu4.var_cd_a = cu4.var_do_a.cd_a();
                        if (cu4.var_cd_a == null) {
                            cu4.var_boolean_a = false;
                            return true;
                        }
                        n2 = cu4.a((byte)6, false);
                        cu cu5 = cu4;
                        cu4.var_boolean_a = cu4.var_cd_a.a(cu4.var_do_a, (byte)6, n2, false, cu4.var_do_a.var_byte_c, (byte)2, false, true, true);
                        if (cu4.var_boolean_a) {
                            cu4.var_cd_a.c(cu4.d);
                            return true;
                        }
                    }
                    case 2: {
                        if (cu4.var_boolean_a) return true;
                        cu4.var_do_a.var_int_c = 15;
                        return true;
                    }
                    case 3: {
                        cu4.var_do_a.void_c(true);
                        break;
                    }
                    case 8: 
                    case 12: {
                        n4 = 1;
                    }
                    case 5: {
                        n3 = 1;
                        break;
                    }
                    case 13: {
                        cu4.var_do_a.void_c(false);
                        if (cu4.var_cd_a == null) break;
                        cu4.var_cd_a = null;
                        break;
                    }
                    case 14: {
                        di.var_g_a.void_c(2, 2);
                    }
                }
                if (n3 == 0) return true;
                if (cu4.var_cd_a != null) {
                    n2 = cu4.a((byte)6, n4 != 0);
                    cu cu6 = cu4;
                    cu4.var_cd_a.a(cu4.var_do_a, (byte)6, n2, false, cu4.var_do_a.var_byte_c, (byte)2, false, true, true);
                }
                cu4.void_a((byte)6);
                return true;
            }
            case 7: {
                if (n4 == 0) return true;
                by2 = (byte)this.int_c((byte)7);
                cu cu7 = this;
                this.var_do_a.a((byte)7, by2, (byte)2, -2);
                this.void_a((byte)7);
                return true;
            }
            case 8: {
                cu cu8 = this;
                n3 = n2 == 4 ? 1 : 0;
                switch (n2) {
                    case 1: 
                    case 4: {
                        n4 = cu8.a((byte)8, n3 != 0);
                        di.var_g_a.a(new bz(cu8.var_do_a, n2 == 4 ? (byte)1 : 0, 8, n4));
                        cu8.void_a((byte)7);
                        return true;
                    }
                }
                return true;
            }
            case 9: {
                cu cu9 = this;
                if (n2 != 5) return true;
                cu9.var_do_a.void_f((byte)10);
                g.a(1);
                for (n3 = 1; n3 <= 4; n3 = (int)((byte)(n3 + 1))) {
                    cu9.var_do_a.void_i((byte)n3);
                }
                n3 = cu9.int_c((byte)9);
                h.a(di.var_do_a, (short)n3);
                cu9.void_a((byte)9);
                return true;
            }
        }
        return true;
    }

    protected final byte byte_a() {
        return 2;
    }

    public final boolean boolean_a(byte by2) {
        if (by2 == 7) {
            return true;
        }
        return this.boolean_a();
    }

    protected final void void_a(byte by2) {
        byte by3 = 5;
        switch (by2) {
            case 5: 
            case 7: 
            case 9: {
                by3 = 0;
                break;
            }
            case 8: {
                by3 = 4;
            }
        }
        bq.a(by3);
    }

    public final boolean boolean_b(byte by2) {
        switch (by2) {
            case 7: 
            case 9: 
            case 10: {
                return false;
            }
        }
        return true;
    }
}

