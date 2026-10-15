/*
 * Decompiled with CFR 0.152.
 */
import rpg.g;

final class d
extends cl {
    private final byte[] a = new byte[]{1, 2, 2, 1, 0, 0, 0, 2, 0, 6};
    private final byte[] b = new byte[]{0, 0, 1, 0};

    d(do do_) {
        super(do_);
    }

    public final boolean a(byte by2, int n2) {
        byte by3 = n2 == this.a[by2] ? (byte)1 : 0;
        switch (by2) {
            case 3: {
                if (n2 == 3) {
                    by3 = 1;
                }
            }
            case 0: 
            case 1: 
            case 2: {
                if (by3 == 0) break;
                if (this.a(this.b[by2], by2, -1, false, false, false)) {
                    this.void_c(by2);
                    break;
                }
                return false;
            }
            case 4: {
                this.a(n2);
                n2 = by3;
                d d2 = this;
                if (n2 != 0) {
                    cd cd2 = d2.var_do_a.cd_a();
                    return d2.a(cd2, (byte)4, d2.byte_a());
                }
                return true;
            }
            case 5: {
                if (by3 == 0) break;
                this.void_a(by2);
                by2 = (byte)this.a((byte)5, this.var_do_a.int_f((byte)0), false);
                this.var_do_a.void_c((int)by2);
                break;
            }
            case 6: {
                this.a(n2);
                n2 = by3;
                d d3 = this;
                if (n2 != 0) {
                    cd cd3 = d3.var_do_a.cd_a();
                    if (d3.a(cd3, (byte)6, (byte)3)) {
                        cd3.c(30);
                    } else {
                        return false;
                    }
                }
                return true;
            }
            case 7: {
                if (by3 == 0) break;
                this.void_a(by2);
                this.var_do_a.k();
                break;
            }
            case 8: {
                this.a(n2);
                n2 = by3;
                d d4 = this;
                if (n2 != 0) {
                    cd cd4 = d4.var_do_a.cd_a();
                    if (d4.a(cd4, (byte)8, (byte)3)) {
                        by3 = d4.var_do_a.var_byte_c;
                        cd4.void_b(by3);
                        d4.var_do_a.void_b(by3);
                    } else {
                        return false;
                    }
                }
                return true;
            }
            case 9: {
                if (by3 == 0) break;
                this.void_a(by2);
                by2 = (byte)this.int_c(by2);
                this.var_do_a.b((byte)80, by2);
            }
        }
        return true;
    }

    private boolean a(cd cd2, byte by2, byte by3) {
        if (cd2 != null) {
            int n2;
            byte by4 = by2;
            d d2 = this;
            bm bm2 = d2.var_do_a.bm_a((byte)5);
            int n3 = -2;
            if (bm2 != null) {
                int n4 = d2.var_do_a.int_a(true);
                n3 = n4 + bm2.b + (bm2.var_short_c - bm2.b) * g.a(1, 100) / 100;
                int n5 = d2.a(by4, n4, false);
                n3 += n5;
            }
            if (cd2.a(this.var_do_a, by2, n2 = n3, true, this.var_do_a.var_byte_c, by3, true, true, false)) {
                this.void_a(by2);
                return true;
            }
        }
        return false;
    }

    private void a(int n2) {
        if (n2 == 0) {
            this.a(3, true);
            return;
        }
        if (n2 == 2) {
            this.a(1, false);
        }
    }

    private void a(int n2, boolean bl2) {
        if (this.var_do_a.var_byte_c <= 2) {
            di.var_g_a.void_c(n2, bl2 ? 0 : 1);
            return;
        }
        di.var_g_a.void_b(n2, bl2 ? 0 : 1);
    }

    protected final byte byte_a() {
        int n2 = 2;
        bm bm2 = this.var_do_a.bm_a((byte)3);
        if (bm2 != null && bm2.var_byte_a == 3) {
            n2 = 4;
        }
        return (byte)n2;
    }

    public final boolean boolean_a(byte by2) {
        switch (by2) {
            case 4: 
            case 6: 
            case 8: {
                return this.boolean_b();
            }
            case 5: 
            case 9: {
                return true;
            }
        }
        return this.boolean_a();
    }

    protected final void void_a(byte by2) {
        int n2 = 7;
        switch (by2) {
            case 4: 
            case 6: 
            case 8: {
                break;
            }
            case 5: 
            case 7: 
            case 9: {
                n2 = 0;
                break;
            }
            default: {
                bm bm2 = this.var_do_a.bm_a((byte)3);
                if (bm2 == null || bm2.var_byte_a != 2) break;
                n2 = 4;
            }
        }
        bq.a((byte)n2);
    }

    public final boolean boolean_b(byte by2) {
        switch (by2) {
            case 5: 
            case 7: 
            case 9: {
                return false;
            }
        }
        return true;
    }
}

