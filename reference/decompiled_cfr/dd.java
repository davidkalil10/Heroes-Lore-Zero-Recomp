/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import rpg.a;
import rpg.e;

final class dd
extends de {
    private String b = null;
    protected int e = 0;
    public as a = null;
    private String c = null;

    public dd(n n2, as as2) {
        super(n2, (byte)5);
        if (de.var_bj_arr_a == null || this.var_boolean_f) {
            this.g();
        }
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            this.c();
            this.var_n_a.c();
            return true;
        }
        if (n.f(n2, n3)) {
            switch (this.var_byte_a) {
                case 0: {
                    this.var_n_b = new cv((n)this, 0, rpg.e.var_ch_h.a(61));
                    break;
                }
                case 1: {
                    this.var_n_b = new bb(this, rpg.e.var_ch_h.a(65));
                    break;
                }
                case 2: {
                    this.var_n_b = new dj((n)this, rpg.e.var_ch_h.a(66, 67));
                    break;
                }
                case 3: {
                    this.var_n_b = new cv((n)this, 1, rpg.e.var_ch_h.a(63));
                    break;
                }
                case 4: {
                    this.var_n_b = this.b == null || this.b.length() == 0 ? new br((n)this, rpg.e.var_ch_h.a(38), '\u0000') : (this.e == 0 && this.a == null && (this.c == null || this.c.trim().length() == 0) ? new br((n)this, rpg.e.var_ch_h.a(26), '\u0000') : new bt((n)this, rpg.e.var_ch_h.a(64), 3, false, true));
                }
            }
            return true;
        }
        return this.c(n2, n3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void void_a(byte by2, byte by3) {
        byte[] byArray;
        block31: {
            this.c();
            if (by2 == 10) {
                switch (this.var_byte_a) {
                    case 0: {
                        this.b = de.var_java_lang_String_a;
                        break;
                    }
                    case 3: {
                        this.c = de.var_java_lang_String_a;
                        break;
                    }
                }
                de.var_java_lang_String_a = "";
            } else if (by2 == 6) {
                if (by3 == 0) {
                    this.var_n_b = new dk(this, 1);
                } else {
                    this.a = null;
                }
            }
            if (by2 != 3) return;
            if (by3 != 0) return;
            this.var_n_b = new br((n)this, rpg.e.var_ch_h.a(4));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            byArray = null;
            try {
                if (this.b == null) {
                    dataOutputStream.writeByte(0);
                } else {
                    byArray = this.b.getBytes();
                    dataOutputStream.writeByte(byArray.length);
                    ((OutputStream)dataOutputStream).write(byArray);
                }
                dataOutputStream.writeInt(this.e);
                if (this.a == null) {
                    dataOutputStream.writeLong(0L);
                } else {
                    dataOutputStream.writeLong(this.a.var_long_a);
                }
                if (this.c == null) {
                    dataOutputStream.writeByte(0);
                } else {
                    byArray = this.c.getBytes();
                    dataOutputStream.writeByte(byArray.length);
                    ((OutputStream)dataOutputStream).write(byArray);
                }
                byArray = byteArrayOutputStream.toByteArray();
            }
            catch (Exception exception) {
                byArray = null;
                try {
                    dataOutputStream.close();
                }
                catch (Exception exception2) {}
                try {
                    byteArrayOutputStream.close();
                }
                catch (Exception exception3) {}
                break block31;
            }
            catch (Throwable throwable) {
                try {
                    dataOutputStream.close();
                }
                catch (Exception exception) {}
                try {
                    byteArrayOutputStream.close();
                    throw throwable;
                }
                catch (Exception exception) {}
                throw throwable;
            }
            try {
                dataOutputStream.close();
            }
            catch (Exception exception) {}
            try {
                byteArrayOutputStream.close();
            }
            catch (Exception exception) {}
        }
        if (byArray == null) {
            this.c();
            return;
        }
        byArray = c.a((byte)24, byArray);
        this.a(byArray, false, false);
    }

    protected final void a(cm cm2) {
        this.a(cm2, rpg.e.var_ch_h.a(2), true, false);
        int n2 = this.a_ + 4;
        int n3 = this.a_ + 22;
        int n4 = this.a_ + 68;
        int n5 = this.b_ + 18;
        n.a(cm2, n2, n5, 14, 12, this.var_byte_a == 0 ? 0x660000 : 3550755, this.var_byte_a == 0 ? 0xBD0000 : 7027456);
        n.a(cm2, n3, n5, 93, 12, this.var_byte_a == 0 ? 0x660000 : 3550755, this.var_byte_a == 0 ? 0xBD0000 : 7027456);
        if (this.b != null && this.b.length() != 0) {
            cm2.a(0xFFFFFF);
            ac.a(cm2, n4, n5, this.b.getBytes(), 0, 1);
        } else {
            cm2.a(this.var_byte_a == 0 ? 16775602 : 12630160);
            ac.a(cm2, n4, n5, rpg.e.var_ch_h.a(57), 0, 1);
        }
        ac.a(cm2, this.a_ + 5, n5, rpg.e.var_ch_h.a(46), 0);
        n.a(cm2, n2, n5 += 14, 14, 12, this.var_byte_a == 1 ? 0x660000 : 3550755, this.var_byte_a == 1 ? 0xBD0000 : 7027456);
        cm2.a(rpg.e.t, n2 + 7, n5 + 5, 3);
        n.a(cm2, n3, n5, 93, 12, this.var_byte_a == 1 ? 0x660000 : 3550755, this.var_byte_a == 1 ? 0xBD0000 : 7027456);
        if (this.e > 0) {
            n.b(cm2, this.e, n4, n5 + 2, 1, 0);
        } else {
            cm2.a(this.var_byte_a == 1 ? 16775602 : 12630160);
            ac.a(cm2, n4, n5, rpg.e.var_ch_h.a(58), 0, 1);
        }
        n.a(cm2, n2, n5 += 14, 14, 14, this.var_byte_a == 2 ? 0x660000 : 3550755, this.var_byte_a == 2 ? 0xBD0000 : 7027456);
        n.a(cm2, n3, n5, 93, 12, this.var_byte_a == 2 ? 0x660000 : 3550755, this.var_byte_a == 2 ? 0xBD0000 : 7027456);
        if (this.a != null) {
            this.a.a(cm2, n2, n5 - 1, true, true);
            cm2.a(0xFFFFFF);
            ac.a(cm2, n4, n5, this.a.var_byte_arr_a, 0, 1);
        } else {
            cm2.a(this.var_byte_a == 2 ? 16775602 : 12630160);
            ac.a(cm2, n4, n5, rpg.e.var_ch_h.a(59), 0, 1);
        }
        n.a(cm2, n3, n5 += 14, 93, 41, this.var_byte_a == 3 ? 0x660000 : 3550755, this.var_byte_a == 3 ? 0xBD0000 : 7027456);
        if (this.c != null && this.c.length() > 0) {
            cm2.a(0xFFFFFF);
            ac.a(cm2, n3 + 2, n5 + 2, 89, 0, this.c.getBytes());
        } else {
            cm2.a(this.var_byte_a == 3 ? 16775602 : 12630160);
            ac.a(cm2, n4, n5, rpg.e.var_ch_h.a(60), 0, 1);
        }
        n.a(cm2, n2, n5 += 43, 111, 12, this.var_byte_a == 4 ? 0x660000 : 3550755, this.var_byte_a == 4 ? 0xBD0000 : 7027456);
        cm2.a(this.var_byte_a == 4 ? 16775602 : 12630160);
        ac.a(cm2, rpg.a.c, n5, rpg.e.var_ch_h.a(2), 0, 1);
    }
}

