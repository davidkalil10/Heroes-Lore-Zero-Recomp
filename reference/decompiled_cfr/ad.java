/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;

final class ad
extends cl {
    private cd a;
    private cd b;

    ad(do do_) {
        super(do_);
    }

    public final boolean a(byte by2, int n2) {
        block53: {
            block0 : switch (by2) {
                case 0: {
                    ad ad2 = this;
                    boolean bl2 = false;
                    boolean bl3 = false;
                    if (n2 == 0) {
                        bl2 = true;
                        ad2.void_c((byte)0);
                    } else if (n2 == 2) {
                        bl3 = true;
                        bl2 = true;
                    }
                    if (!bl2) break;
                    ad ad3 = ad2;
                    ad2.a((byte)0, -1, (byte)4, bl3);
                    break;
                }
                case 4: {
                    ad ad4 = this;
                    boolean bl4 = false;
                    boolean bl5 = false;
                    ad ad5 = ad4;
                    byte by3 = 4;
                    switch (n2) {
                        case 2: {
                            if (ad4.var_do_a.bm_a((byte)3) != null) {
                                by3 = 12;
                            }
                        }
                        case 0: {
                            bl4 = true;
                            break;
                        }
                        case 6: {
                            if (ad4.var_do_a.bm_a((byte)5) != null) {
                                by3 = 13;
                            }
                        }
                        case 4: {
                            bl5 = true;
                            bl4 = true;
                        }
                    }
                    if (!bl4) break;
                    n2 = ad4.a((byte)4, ad4.var_do_a.int_a((byte)1), false);
                    ad4.a((byte)4, n2 += ad4.var_do_a.int_c(bl5), by3, bl5);
                    ad4.void_a((byte)4);
                    break;
                }
                case 5: {
                    ad ad6 = this;
                    switch (n2) {
                        case 0: {
                            ad6.void_a((byte)5);
                            ad6.b = ad6.cd_a();
                            if (ad6.b == null) break;
                            ad6.b.void_b(14);
                            ad6.b.a(new ak(14, 14));
                            break;
                        }
                        case 9: {
                            g.a(1);
                            break;
                        }
                        case 10: {
                            ad6.var_do_a.m(-3);
                            if (ad6.b != null) {
                                int n3 = ad6.b((byte)5, ad6.var_do_a.int_a(false), false);
                                ad ad7 = ad6;
                                ad6.b.a(ad6.var_do_a, (byte)5, n3, false, ad6.var_do_a.var_byte_c, (byte)4, false, false, false);
                            }
                            bq.a((byte)1);
                            break;
                        }
                        case 12: {
                            ad6.var_do_a.m(1);
                        }
                    }
                    break;
                }
                case 6: {
                    int n4;
                    ad ad8 = this;
                    boolean bl6 = false;
                    switch (n2) {
                        case 1: {
                            ad8.b = ad8.cd_a();
                            ad8.var_do_a.void_b(d.N[ad8.var_do_a.var_byte_c]);
                        }
                        case 3: {
                            bl6 = true;
                        }
                        case 5: {
                            n4 = ad8.b((byte)6, ad8.var_do_a.int_a(bl6), bl6);
                            ad8.void_a((byte)6);
                            break;
                        }
                        default: {
                            break block0;
                        }
                    }
                    if (ad8.b == null) {
                        ad8.b = ad8.cd_a();
                    }
                    if (ad8.b == null) break;
                    ad ad9 = ad8;
                    ad8.var_do_a.a(ad8.b, (byte)6, n4, ad8.var_do_a.var_byte_c, (byte)4, false, false, false);
                    break;
                }
                case 7: {
                    ad ad10 = this;
                    boolean bl7 = false;
                    switch (n2) {
                        case 0: {
                            ad10.cd_a();
                        }
                        case 4: 
                        case 8: 
                        case 12: {
                            ad10.void_a((byte)7);
                            break;
                        }
                        case 2: 
                        case 6: 
                        case 10: {
                            bl7 = true;
                            break;
                        }
                        default: {
                            break block0;
                        }
                    }
                    int n5 = ad10.a((byte)7, ad10.var_do_a.int_a(bl7), false);
                    if (n5 <= 0) break;
                    ad ad11 = ad10;
                    ad10.var_do_a.a((byte)7, n5, (byte)4, bl7, false);
                    break;
                }
                case 8: {
                    ad ad12 = this;
                    switch (n2) {
                        case 0: {
                            ad12.void_a((byte)8);
                            break;
                        }
                        case 2: {
                            g.a(1);
                            break;
                        }
                        case 5: {
                            ad12.a = ad12.cd_a();
                            if (ad12.a == null) break;
                            ad12.a.void_b((byte)16, 1);
                        }
                    }
                    break;
                }
                case 9: {
                    ad ad13 = this;
                    switch (n2) {
                        case 0: {
                            ad13.void_a((byte)9);
                            ad13.b = ad13.cd_a();
                            if (ad13.b != null) {
                                ad13.b.void_b(14);
                                ad13.b.a(new ak(14, 14));
                                break block0;
                            }
                            break block53;
                        }
                        case 11: {
                            ad13.var_do_a.m(-3);
                            break block0;
                        }
                        case 12: {
                            if (ad13.b != null) {
                                int n6;
                                if (ad13.b instanceof af) {
                                    n6 = -90;
                                } else {
                                    int n7 = ad13.int_c((byte)9);
                                    n6 = rpg.g.a(0, 99) < n7 ? ad13.b.var_int_k + ad13.b.int_b() : ad13.var_do_a.int_c(false) << 1;
                                }
                                ad13.b.a(ad13.var_do_a, (byte)9, n6, false, ad13.var_do_a.var_byte_c, (byte)15, false, false, false);
                            }
                            bq.a((byte)1);
                            break block0;
                        }
                        case 13: {
                            ad13.var_do_a.m(1);
                        }
                    }
                }
            }
        }
        return true;
    }

    private int b(byte by2, int n2, boolean bl2) {
        int n3 = this.a(by2, n2, false);
        by2 = (byte)n3;
        int n4 = n3 + this.var_do_a.int_c(bl2);
        by2 = (byte)n4;
        return n4;
    }

    private cd cd_a() {
        if (this.a != null && this.a.boolean_k()) {
            if (this.a.boolean_b()) {
                this.a = null;
            } else {
                int n2;
                int n3 = ((du)this.var_do_a).h - ((du)this.a).h;
                int n4 = Math.abs(n3);
                if (n4 <= 96 && (n2 = Math.abs(n4 = ((du)this.var_do_a).i - ((du)this.a).i)) <= 96) {
                    if (n4 > n3 || n3 == 0) {
                        this.var_do_a.var_byte_c = (byte)(n4 > 0 ? 1 : 2);
                    } else if (n4 > n3 || n4 == 0) {
                        this.var_do_a.var_byte_c = (byte)(n3 > 0 ? 3 : 4);
                    }
                    return this.a;
                }
            }
        }
        this.b = this.var_do_a.cd_b();
        return this.b;
    }

    private boolean a(byte by2, int n2, byte by3, boolean bl2) {
        if (bl2 && !this.boolean_b()) {
            return false;
        }
        this.b = this.cd_a();
        if (this.b != null) {
            return this.var_do_a.a(this.b, by2, n2, this.var_do_a.var_byte_c, by3, false, bl2, false);
        }
        return false;
    }

    protected final byte byte_a() {
        return 4;
    }

    public final boolean boolean_a(byte by2) {
        return this.boolean_a();
    }

    protected final void void_a(byte by2) {
        byte by3 = 9;
        switch (by2) {
            case 5: 
            case 8: 
            case 9: {
                by3 = 0;
            }
        }
        bq.a(by3);
    }

    public final boolean boolean_b(byte by2) {
        return false;
    }
}

