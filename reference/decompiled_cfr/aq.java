/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.e;
import rpg.g;

final class aq
extends de {
    private boolean g = false;
    private static byte f = (byte)5;
    private byte[] c = new byte[]{0, 2, 31, 29, 1, 30};

    public aq(n n2) {
        super(n2, f);
        this.var_byte_a = 0;
        this.f();
        boolean bl2 = false;
        aq aq2 = this;
        if (aq2.g) {
            aq2.var_byte_a = 0;
            aq2.g = false;
            f = (byte)5;
            if (aq2.g) {
                f = (byte)(f + 1);
            }
            aq2.var_byte_b = f;
        }
        new Thread(this).start();
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            de.j();
            i.i_a().c();
            bq.e();
            return true;
        }
        if (n.f(n2, n3)) {
            switch (this.var_byte_a) {
                case 3: {
                    this.var_n_b = new bt((n)this, rpg.e.var_ch_h.a(70), 11, false, true);
                    break;
                }
                case 4: {
                    byte[] byArray = c.a((byte)50, null);
                    this.a(byArray, true, false);
                    break;
                }
                case 0: {
                    this.var_n_b = new aw(this);
                    break;
                }
                case 1: {
                    this.var_n_b = new dd((n)this, null);
                    break;
                }
                case 2: {
                    this.var_n_b = new dl(this);
                    break;
                }
                case 5: {
                    this.var_n_b = new bt((n)this, rpg.e.var_ch_h.a(86), 13, false, true);
                }
            }
            return true;
        }
        return this.c(n2, n3);
    }

    final void void_a(byte by2, byte by3) {
        this.c();
        if (de.e && by2 == 3) {
            if (by3 == 0) {
                i i2 = i.i_a();
                i2.c();
                i2.var_n_b = new aq(i2);
                return;
            }
            de.j();
            i.i_a().c();
            return;
        }
        if (by2 == 13) {
            if (by3 == 0) {
                byte[] byArray = c.a((byte)61, null);
                this.a(byArray, true, false);
                return;
            }
        } else if (by2 == 11) {
            if (this.var_byte_a == 3 && by3 == 0) {
                byte[] byArray = new byte[2 + (null).length + 2 + (null).length];
                short s2 = (short)(null).length;
                rpg.g.a(s2, byArray, 0);
                System.arraycopy(null, 0, byArray, 2, s2);
                by3 = (byte)(s2 + 2);
                s2 = (short)(null).length;
                rpg.g.a(s2, byArray, (int)by3);
                by3 = (byte)(by3 + 2);
                System.arraycopy(null, 0, byArray, by3, s2);
                byArray = c.a((byte)60, byArray);
                this.a(byArray, true, false);
                return;
            }
            if (this.var_byte_a == 5 && by3 == 0) {
                byte[] byArray = c.a((byte)62, null);
                this.a(byArray, true, false);
                return;
            }
        } else if (by2 == 10) {
            byte[] byArray = de.var_java_lang_String_a.getBytes();
            byte[] byArray2 = new byte[1 + byArray.length];
            byte[] byArray3 = byArray2;
            byArray2[0] = (byte)byArray.length;
            System.arraycopy(byArray, 0, byArray3, 1, byArray3[0]);
            byArray3 = c.a((byte)3, byArray3);
            this.a(byArray3, true, false);
        }
    }

    protected final void a(cm cm2) {
        rpg.a.a(cm2, true);
        cm2.a(14597755);
        ac.a(cm2, rpg.a.c, rpg.a.d - 58, rpg.e.var_ch_b.a(9), 0, 1);
        for (byte by2 = 0; by2 < f; by2 = (byte)(by2 + 1)) {
            int n2 = this.b_ + 16 + by2 * 13;
            n.a(cm2, this.a_ + 3, n2, 113, 12, this.var_byte_a == by2 ? 0x660000 : 3550755, this.var_byte_a == by2 ? 0xBD0000 : 7027456);
            cm2.a(this.var_byte_a == by2 ? 0xFFFFFF : 12630160);
            ac.a(cm2, rpg.a.c, n2, rpg.e.var_ch_h.a(this.c[by2]), 0, 1);
        }
    }
}

