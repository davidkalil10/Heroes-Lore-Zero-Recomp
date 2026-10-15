/*
 * Decompiled with CFR 0.152.
 */
import rpg.g;

final class ao
extends cl {
    private final byte[] var_byte_arr_a = new byte[]{2, 1, 1, 1, 1, 1, 1};
    private final byte[] b = new byte[]{2, 1, 1, 4};
    private boolean var_boolean_a = false;

    ao(do do_) {
        super(do_);
    }

    public final boolean a(byte by2, int n2) {
        int n3 = -1;
        byte by3 = n2 == this.var_byte_arr_a[by2] ? (byte)1 : 0;
        int n4 = 0;
        ao ao2 = this;
        byte by4 = 1;
        switch (by2) {
            case 0: 
            case 1: 
            case 2: {
                if (by3 != 0) {
                    this.var_boolean_a = this.a(this.b[by2], by2, -1, false, false, false);
                    if (this.var_boolean_a) {
                        this.void_c(by2);
                    } else {
                        return false;
                    }
                }
                return true;
            }
            case 3: {
                if (!this.var_boolean_a) {
                    this.var_do_a.void_b(0);
                    return true;
                }
                this.a(n2);
                if (by3 != 0) {
                    n4 = this.c();
                    this.void_a(by2);
                    this.a(this.b[by2], by2, -1, n4 != 0, false, false);
                }
                return true;
            }
            case 4: {
                this.a(n2);
                if (by3 != 0) {
                    cd cd2 = this.var_do_a.cd_b();
                    if (cd2 != null) {
                        n3 = this.a((byte)4, false);
                        this.var_do_a.a(cd2, by2, n3, this.var_do_a.var_byte_c, (byte)22, this.c(), false, false);
                        for (by3 = 1; by3 <= 8; by3 = (byte)(by3 + 1)) {
                            boolean bl2 = this.c();
                            n4 = 22;
                            int n5 = n3;
                            byte by5 = by3;
                            byte by6 = by2;
                            cd cd3 = cd2;
                            ao ao3 = this;
                            boolean bl3 = (cd3 = cd3.cd_a(by5)) != null ? ao3.var_do_a.a(cd3, by6, n5, ao3.var_do_a.var_byte_c, (byte)22, bl2, false, false) : false;
                        }
                    }
                    this.void_a(by2);
                }
                return true;
            }
            case 5: {
                if (by3 != 0) {
                    this.void_a(by2);
                    this.var_do_a.boolean_e((byte)3);
                } else if (n2 == 2 && this.var_do_a.cd_a() != null) {
                    this.var_do_a.void_f((byte)6);
                }
                return true;
            }
            case 6: {
                this.a(n2);
                if (by3 == 0) break;
                this.void_a(by2);
                n3 = this.a((byte)5, false);
                n4 = this.c();
            }
        }
        if (by3 != 0) {
            if (this.var_do_a.a(by2, n3, by4, n4 != 0, false, false)) {
                this.void_a(by2);
            } else {
                return false;
            }
        }
        return true;
    }

    private void a(int n2) {
        if (n2 == 2) {
            this.var_do_a.m(5);
            return;
        }
        if (n2 == 4) {
            this.var_do_a.m(-3);
        }
    }

    protected final byte byte_a() {
        return 1;
    }

    public final boolean boolean_a(byte by2) {
        return this.boolean_a();
    }

    private boolean c() {
        return g.a(1, 100) < this.int_c((byte)11);
    }

    protected final void void_a(byte by2) {
        byte by3 = 8;
        switch (by2) {
            case 3: 
            case 4: 
            case 6: {
                by3 = 2;
            }
        }
        bq.a(by3);
    }

    public final boolean boolean_b(byte by2) {
        return by2 != 4;
    }
}

