/*
 * Decompiled with CFR 0.152.
 */
final class ab
extends cl {
    private final byte[] a = new byte[]{2, 3, 1, 4};
    private final byte[] b = new byte[]{0, 3, 1, 1};

    ab(do do_) {
        super(do_);
    }

    public final boolean a(byte by2, int n2) {
        switch (by2) {
            case 4: {
                if (n2 >= 2 && n2 <= 5) {
                    this.var_do_a.void_c(true);
                } else if (n2 == 7 || n2 == 9) {
                    di.var_g_a.void_c(2, n2);
                    this.var_do_a.void_c(false);
                }
                if (n2 == 7) {
                    n2 = this.a((byte)4, false);
                    this.var_do_a.a(by2, n2, this.byte_a(), false, false, false);
                    this.void_c(by2);
                }
                return true;
            }
            case 5: {
                ab ab2 = this;
                if (n2 != 3) break;
                cd cd2 = ab2.var_do_a.cd_a();
                if (cd2 != null && cd2.a(ab2.var_do_a, (byte)5, -1, false, ab2.var_do_a.var_byte_c, ab2.byte_a(), false, true, false)) {
                    int n3 = ab2.int_c((byte)5);
                    cd2.c(n3);
                }
                ab2.void_c((byte)5);
                break;
            }
            case 6: {
                ab ab3 = this;
                if (n2 != 4) break;
                n2 = ab3.a((byte)6, false);
                ab3.var_do_a.a((byte)6, (byte)3, ab3.byte_a(), n2);
                ab3.void_c((byte)6);
                break;
            }
            case 7: {
                ab ab4 = this;
                if (n2 == 4) {
                    n2 = ab4.int_c((byte)7);
                    for (byte by3 = 1; by3 <= 12; by3 = (byte)(by3 + 1)) {
                        cd cd3 = ab4.var_do_a.cd_b(by3);
                        if (cd3 == null) continue;
                        if (rpg.g.a(0, 99) < n2) {
                            cd3.g(75);
                            cd3.a(ab4.var_do_a, (byte)7, -1, false, ab4.var_do_a.var_byte_c, (byte)1, false, true, false);
                            continue;
                        }
                        cd3.D();
                    }
                    ab4.void_a((byte)7);
                }
                return true;
            }
            case 8: {
                ab ab5 = this;
                if (n2 == 6) {
                    n2 = ab5.var_do_a.int_f((byte)0) / 10;
                    int n4 = ab5.a((byte)8, n2, false);
                    ab5.var_do_a.void_c(-n2);
                    ab5.var_do_a.h(n4);
                    bs.var_boolean_c = true;
                    ab5.void_a((byte)8);
                } else if (n2 == 4) {
                    g.a(1);
                }
                return true;
            }
            case 9: {
                if (n2 == 0 || n2 == 2 || n2 == 4) {
                    n2 = this.a((byte)9, false);
                    if (this.var_do_a.a((byte)9, n2, this.byte_a())) {
                        this.void_c((byte)9);
                    } else {
                        return false;
                    }
                }
                return true;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                if ((n2 = n2 == this.a[by2] ? 1 : 0) == 0) break;
                if (this.a(this.b[by2], by2, -1, false, false, false)) {
                    this.void_c(by2);
                    break;
                }
                return false;
            }
        }
        return true;
    }

    protected final byte byte_a() {
        int n2 = 1;
        bm bm2 = this.var_do_a.bm_a((byte)3);
        if (bm2 != null && bm2.var_byte_a == 0) {
            n2 = 3;
        }
        return (byte)n2;
    }

    public final boolean boolean_a(byte by2) {
        switch (by2) {
            case 7: 
            case 8: {
                return true;
            }
        }
        return this.boolean_a();
    }

    protected final void void_a(byte by2) {
        byte by3 = 8;
        switch (by2) {
            case 4: {
                by3 = 1;
                break;
            }
            case 5: {
                by3 = 3;
                break;
            }
            case 6: 
            case 7: 
            case 8: {
                by3 = 0;
            }
        }
        bq.a(by3);
    }

    public final boolean boolean_b(byte by2) {
        switch (by2) {
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return false;
            }
        }
        return true;
    }
}

