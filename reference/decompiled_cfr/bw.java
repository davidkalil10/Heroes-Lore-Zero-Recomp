/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.b;
import rpg.c;
import rpg.d;
import rpg.e;
import rpg.g;

final class bw
extends l {
    private static final cg b = cg.a("/mtx.png");
    private static cg[] var_cg_arr_a;
    private static boolean var_boolean_e;
    private as var_as_a = null;
    private byte[] var_byte_arr_a = null;
    private static int var_int_e;
    private static int f;
    private static int j;

    public bw(n n2) {
        super(n2, (byte)6);
        var_boolean_e = false;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            if (this.var_byte_a == 6 && n2 == -7) {
                di.var_byte_d = (byte)3;
                ax.ax_a().g();
                if (n2 == -7) {
                    di.var_do_a.void_b();
                    ax.var_boolean_g = false;
                }
            } else if ((this.var_byte_a == 7 || this.var_byte_a == 8) && n2 == -7) {
                ax.var_boolean_g = false;
                this.var_n_a.void_a((byte)-1, (byte)-1);
            }
            return true;
        }
        if (n.g(n2, n3)) {
            if (this.var_n_b != null) {
                this.c();
            } else if (ax.var_boolean_g) {
                ax.var_boolean_g = false;
                di.a((byte)7, (byte)0);
            } else {
                this.var_n_a.c();
            }
            var_int_e = 34;
            return true;
        }
        if (n.f(n2, n3)) {
            bw bw2 = this;
            switch (bw2.var_byte_a) {
                case 0: {
                    bw2.var_n_b = new ae((n)bw2, bw2.byte_arr_a((byte)0, (byte)0), 3, true);
                    break;
                }
                case 1: {
                    if (ax.var_boolean_i) {
                        bw2.var_n_b = new br((n)bw2, bw2.byte_arr_a((byte)1, (byte)1), 1);
                        break;
                    }
                    bw2.var_n_b = new ae((n)bw2, bw2.byte_arr_a((byte)0, (byte)1), 3, true);
                    break;
                }
                case 2: {
                    if (ax.j) {
                        bw2.var_n_b = new br((n)bw2, bw2.byte_arr_a((byte)1, (byte)2), 1);
                        break;
                    }
                    bw2.var_n_b = new ae((n)bw2, bw2.byte_arr_a((byte)0, (byte)2), 3, true);
                    break;
                }
                case 3: {
                    if (ax.var_boolean_h) {
                        bw2.var_n_b = new br((n)bw2, bw2.byte_arr_a((byte)1, (byte)3), 1);
                        break;
                    }
                    bw2.var_n_b = new ae((n)bw2, bw2.byte_arr_a((byte)0, (byte)3), 3, true);
                    break;
                }
                case 4: {
                    if (di.var_do_a == null || di.var_do_a.byte_a() >= 99) {
                        bw2.var_n_b = new br((n)bw2, rpg.d.A, 1);
                        break;
                    }
                    bw2.var_n_b = new ae((n)bw2, bw2.byte_arr_a((byte)0, (byte)4), 3, true);
                    break;
                }
                case 5: {
                    bw2.var_n_b = new da((n)bw2, true);
                    break;
                }
                default: {
                    return false;
                }
            }
            bw2.var_boolean_a = true;
            return true;
        }
        if (n3 == 50 || n2 == 1) {
            if (this.var_byte_a > 0) {
                this.var_byte_a = (byte)(this.var_byte_a - 1);
            }
            if (var_int_e >= 34 - (6 - f) * 42 && this.var_byte_a <= 6 - f) {
                var_int_e = -this.var_byte_a * 42 + 34;
            }
            return true;
        }
        if (n3 == 56 || n2 == 6) {
            if (this.var_byte_a < 5) {
                this.var_byte_a = (byte)(this.var_byte_a + 1);
            }
            if (var_int_e > 34 - (6 - f) * 42) {
                var_int_e = -this.var_byte_a * 42 + 34;
            }
            return true;
        }
        return true;
    }

    private byte[] byte_arr_a(byte by2, byte by3) {
        if (by2 == 2) {
            return rpg.d.q;
        }
        if (by2 == 0) {
            byte[][] byArrayArray = new byte[2][];
            if (this.var_byte_a == 7) {
                by3 = 0;
            } else if (this.var_byte_a == 8) {
                by3 = (byte)5;
            }
            byArrayArray[0] = rpg.d.e[by3];
            byte[] byArray = rpg.c.var_ds_a.byte_arr_a(by3 + 1);
            byArrayArray[1] = ("" + byArray[0]).getBytes();
            if (this.var_byte_a == 5 || this.var_byte_a == 8) {
                return rpg.d.z;
            }
            if (this.var_byte_a == 7) {
                System.out.println("MTX Confirmation....");
                return rpg.d.B;
            }
            return bw.a(rpg.d.c, byArrayArray);
        }
        if (by2 == 3) {
            if (this.var_byte_a == 5) {
                return this.var_byte_arr_a;
            }
            if (this.var_byte_a == 4) {
                byte[][] byArrayArray = new byte[1][];
                byte[][] byArrayArray2 = byArrayArray;
                byArrayArray[0] = ("" + (di.var_do_a.byte_a() + 5 > 99 ? 99 : di.var_do_a.byte_a() + 5)).getBytes();
                byte[] byArray = bw.a(rpg.d.var_byte_arr_arr_h, byArrayArray2);
                return byArray;
            }
            if (this.var_byte_a == 7) {
                by3 = 0;
            } else if (this.var_byte_a == 8) {
                return this.var_byte_arr_a;
            }
            byte[][] byArrayArray = new byte[1][];
            byte[][] byArrayArray3 = byArrayArray;
            byArrayArray[0] = rpg.d.e[by3];
            byte[] byArray = bw.a(rpg.d.d, byArrayArray3);
            return byArray;
        }
        if (by2 == 1) {
            byte[][] byArrayArray = new byte[1][];
            byte[][] byArrayArray4 = byArrayArray;
            byArrayArray[0] = rpg.d.e[by3];
            return bw.a(rpg.d.b, byArrayArray4);
        }
        return null;
    }

    public final void a(byte[] byArray, int n2, as as2) {
        this.c();
        if (n2 == 0) {
            this.var_n_b = new br((n)this, byArray, 1);
            return;
        }
        if (n2 == 1) {
            this.var_as_a = as2;
            this.var_byte_arr_a = byArray;
            this.var_n_b = new ae((n)this, this.byte_arr_a((byte)0, (byte)5), 3, true);
        }
    }

    final void void_a(byte by2, byte by3) {
        block19: {
            block16: {
                block18: {
                    block17: {
                        this.c();
                        if (by2 != 3 || by3 != 0) break block16;
                        by2 = this.var_byte_a;
                        if (this.var_byte_a == 7) {
                            by2 = 0;
                        } else if (this.var_byte_a == 8) {
                            by2 = (byte)5;
                        }
                        if (!rpg.c.var_ds_a.boolean_a(by2 + 1)) break block17;
                        this.var_n_b = new br((n)this, this.byte_arr_a((byte)3, this.var_byte_a), 1);
                        switch (this.var_byte_a) {
                            case 0: {
                                di.var_int_e += 20000;
                                di.l();
                                break block18;
                            }
                            case 1: {
                                ax.var_boolean_i = true;
                                rpg.b.boolean_a();
                                break block18;
                            }
                            case 2: {
                                ax.j = true;
                                rpg.b.boolean_a();
                                break block18;
                            }
                            case 3: {
                                ax.var_boolean_h = true;
                                rpg.b.boolean_a();
                                break block18;
                            }
                            case 5: {
                                di.bj_a(this.var_as_a.var_byte_a).a(this.var_as_a, 1);
                                di.l();
                                break block18;
                            }
                            case 4: {
                                di.var_do_a.void_g();
                                di.k();
                                break block18;
                            }
                            case 6: {
                                di.var_byte_d = (byte)3;
                                ax.ax_a().g();
                                di.var_do_a.void_d();
                                break block18;
                            }
                            case 7: {
                                di.var_int_e += 20000;
                                di.l();
                                break block18;
                            }
                            case 8: {
                                di.bj_a(this.var_as_a.var_byte_a).a(this.var_as_a, 1);
                                di.l();
                            }
                        }
                        break block19;
                    }
                    this.var_n_b = new br((n)this, this.byte_arr_a((byte)2, this.var_byte_a), 1);
                }
                return;
            }
            if (by2 == 1 && (this.var_byte_a == 7 || this.var_byte_a == 8)) {
                this.var_n_a.void_a((byte)-2, (byte)-2);
                return;
            }
            if (this.var_byte_a == 6 && by2 == 1) {
                this.var_n_b = new ae((n)this, this.byte_arr_a((byte)0, (byte)6), 3, true);
            }
        }
    }

    public static void a() {
        di.var_byte_d = (byte)7;
        ax.ax_a().g();
        di.var_do_a.void_d();
        di.k();
    }

    protected final void a(cm cm2) {
        if (this.var_byte_a < 6) {
            int n2;
            int n3;
            cm2.a(0);
            cm2.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
            cm2.b(255);
            cm2.a(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
            if (rpg.e.var_cg_k != null) {
                n3 = rpg.e.var_cg_k.int_a();
                j = rpg.e.var_cg_k.b();
                for (n2 = 0; n2 < rpg.a.var_int_a; n2 += n3) {
                    cm2.a(rpg.e.var_cg_k, n2, 1, 20);
                    cm2.a(rpg.e.var_cg_k, n2, rpg.a.var_int_b - 1, 36);
                }
            }
            n3 = var_int_e;
            n2 = n3 + 21;
            int n4 = rpg.a.var_int_a - 48 - 8;
            cm2.b(0, 34, rpg.a.var_int_a, rpg.a.var_int_b - 68);
            for (int i2 = 0; i2 < 6; ++i2) {
                int n5;
                cm2.a(b, 0, n3, 20);
                cm2.a(var_cg_arr_a[i2], 24, n2, 3);
                if (i2 == this.var_byte_a) {
                    cm2.b(40);
                    cm2.a(0xFFFF00);
                    cm2.a(0, n3, rpg.a.var_int_a, 42);
                    cm2.b(255);
                }
                cm2.a(0xFFFFFF);
                ac.a(cm2, 48, n3 + 6, n4, rpg.d.f[i2], 0, rpg.d.f[i2].length, 4);
                int n6 = i2;
                switch (n6) {
                    case 1: {
                        if (ax.var_boolean_i) {
                            n5 = 1;
                            break;
                        }
                        n5 = 0;
                        break;
                    }
                    case 2: {
                        if (ax.j) {
                            n5 = 1;
                            break;
                        }
                        n5 = 0;
                        break;
                    }
                    case 3: {
                        if (ax.var_boolean_h) {
                            n5 = 1;
                            break;
                        }
                        n5 = 0;
                        break;
                    }
                    case 5: {
                        n5 = 0;
                        break;
                    }
                    case 4: {
                        if (di.var_do_a != null && di.var_do_a.byte_a() < 99) {
                            n5 = 0;
                            break;
                        }
                        n5 = 1;
                        break;
                    }
                    default: {
                        n5 = n6 = 0;
                    }
                }
                if (n5 == 0) {
                    cm2.a(65535);
                    Object object = rpg.c.var_ds_a.byte_arr_a(i2 + 1);
                    object = "" + object[0];
                    byte[][] byArrayArray = new byte[1][];
                    byte[][] byArrayArray2 = byArrayArray;
                    byArrayArray[0] = object.getBytes();
                    object = bw.a(rpg.d.var_byte_arr_arr_g, byArrayArray2);
                    ac.a(cm2, rpg.a.var_int_a - 2 - ac.b(object, 0, n4), n3 + 42 - ac.var_int_a - 4, n4, object, 0, ((byte[])object).length, 4);
                } else {
                    cm2.a(0x888888);
                    ac.a(cm2, rpg.a.var_int_a - 2 - ac.b(rpg.d.r, 0, n4), n3 + 42 - ac.var_int_a - 4, n4, rpg.d.r, 0, rpg.d.r.length, 4);
                }
                n3 += 42;
                n2 += 42;
            }
            if (f != 6) {
                cm2.a(16765952);
                if (var_int_e == 34) {
                    cm2.b(rpg.a.c - 8, rpg.a.var_int_b - j, 16, 8);
                    cm2.a(rpg.a.c - 8, rpg.a.var_int_b - j, rpg.a.c + 8, rpg.a.var_int_b - j, rpg.a.c, rpg.a.var_int_b - j + 8);
                } else if (var_int_e < 34 && var_int_e > 34 - (6 - f) * 42) {
                    cm2.b(rpg.a.c - 8, j - 8, 16, 8);
                    cm2.a(rpg.a.c - 8, j, rpg.a.c + 8, j, rpg.a.c, j - 8);
                    cm2.b(rpg.a.c - 8, rpg.a.var_int_b - j, 16, 8);
                    cm2.a(rpg.a.c - 8, rpg.a.var_int_b - j, rpg.a.c + 8, rpg.a.var_int_b - j, rpg.a.c, rpg.a.var_int_b - j + 8);
                } else if (var_int_e == 34 - (6 - f) * 42) {
                    cm2.b(rpg.a.c - 8, j - 8, 16, 8);
                    cm2.a(rpg.a.c - 8, j, rpg.a.c + 8, j, rpg.a.c, j - 8);
                }
                cm2.b(0, 0, rpg.a.var_int_a, rpg.a.var_int_b);
            }
        } else {
            rpg.a.var_boolean_a = true;
        }
        n.a(cm2, 3);
    }

    private static byte[] a(byte[][] byArray, byte[][] byArray2) {
        if (byArray == null || byArray2 == null || byArray.length != byArray2.length + 1) {
            return null;
        }
        byte[] byArray3 = byArray[0];
        for (int i2 = 0; i2 < byArray2.length; ++i2) {
            if (byArray2[i2] != null) {
                byArray3 = g.a(byArray3, byArray2[i2]);
            }
            if (byArray[i2 + 1] == null) continue;
            byArray3 = g.a(byArray3, byArray[i2 + 1]);
        }
        return byArray3;
    }

    static {
        var_cg_arr_a = new cg[6];
        var_boolean_e = false;
        for (int i2 = 0; i2 < 6; ++i2) {
            bw.var_cg_arr_a[i2] = cg.a("/mtx" + i2 + ".png");
        }
        var_int_e = 34;
        f = (rpg.a.var_int_b - 68) / 42;
    }
}

