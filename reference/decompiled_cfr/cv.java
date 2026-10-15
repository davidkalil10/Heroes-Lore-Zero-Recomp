/*
 * Decompiled with CFR 0.152.
 */
import rpg.a;
import rpg.d;
import rpg.e;

public final class cv
extends br {
    private byte h;
    private static x a = null;

    public cv(n n2, byte by2, byte[] byArray) {
        super(n2, byArray, '\u0000');
        de.var_java_lang_String_a = "";
        this.h = by2;
        switch (this.h) {
            case 0: 
            case 2: {
                this.void_a(this.l + 2);
                return;
            }
            case 1: {
                this.void_a(this.l + 5);
            }
        }
    }

    protected final void a(cm cm2) {
        cv cv2 = this;
        if (a == null) {
            switch (cv2.h) {
                case 0: 
                case 2: {
                    a = new x(8);
                    break;
                }
                case 1: {
                    a = new x(25);
                }
            }
        }
        if (a == null) {
            return;
        }
        super.a(cm2);
        int n2 = ((eb)this).e + 4;
        int n3 = this.j - 8;
        int n4 = this.var_int_f + 38;
        n.a(cm2, n2 + 89, n4 - 11, 20, 12, 0x660000, 0xBD0000);
        cm2.a(0xFFFFFF);
        ac.a(cm2, n2 + 100, n4 - 11, a.byte_arr_a(), 0, 1);
        switch (this.h) {
            case 0: 
            case 2: {
                n.a(cm2, n2, n4, n3, 17, 0x660000, 0xBD0000);
                cm2.a(0xFFFFFF);
                cm2.a(a.java_lang_String_a(), rpg.a.c, n4 + 1, 17);
                return;
            }
            case 1: {
                int n5 = n4;
                n.a(cm2, n2, n4, n3, 59, 0x660000, 0xBD0000);
                cm2.a(0xFFFFFF);
                String string = a.java_lang_String_a();
                n3 = string.length();
                while (n3 > 0) {
                    while (bn.a().a(string, 0, n3) >= rpg.d.var_int_i) {
                        --n3;
                    }
                    String string2 = string.substring(0, n3);
                    cm2.a(string2, ((eb)this).e + 5, n5, 20);
                    n5 += 15;
                    string = string.substring(n3);
                    n3 = string.length();
                }
                break;
            }
        }
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3) && a.java_lang_String_a().length() == 0) {
            if (this.h == 2) {
                de.j();
                i.i_a().c();
                c.a(false);
            } else {
                a = null;
                this.var_n_a.c();
            }
            return true;
        }
        if (n2 == 8 && n3 != 53) {
            boolean bl2;
            String string;
            String string2 = string = a.java_lang_String_a();
            if (string == null) {
                bl2 = false;
            } else if (string2.length() != 0) {
                for (int i2 = 0; i2 < string2.length(); ++i2) {
                    String string3 = string2.substring(i2, i2 + 1);
                    char c2 = string3.charAt(0);
                    if (c2 > '/' && c2 < ':' || c2 > '@' && c2 < '[') continue;
                    if (c2 > '`' && c2 < '{') {
                        bl2 = false;
                    } else {
                        if (c2 == ' ') continue;
                        if (c2 > '\u3130' && c2 < '\u3164') {
                            bl2 = false;
                        } else {
                            if (c2 > '\uabff' && c2 < '\ud789') continue;
                            bl2 = false;
                        }
                    }
                    break;
                }
            } else {
                bl2 = true;
            }
            if (bl2) {
                if (this.h == 0 || this.h == 2) {
                    if ((string = string.trim()).length() > 5) {
                        this.var_n_b = new br((n)this, rpg.e.var_ch_h.a(73), '\u0000');
                    } else if (string.length() > 0) {
                        de.var_java_lang_String_a = string;
                        a = null;
                        this.var_n_a.void_a((byte)10, this.var_byte_a);
                    }
                } else {
                    de.var_java_lang_String_a = string;
                    a = null;
                    this.var_n_a.void_a((byte)10, this.var_byte_a);
                }
            } else {
                this.var_n_b = new br((n)this, rpg.e.var_ch_h.a(62), '\u0000');
            }
            return true;
        }
        this.d();
        return a.a(n2, n3);
    }
}

