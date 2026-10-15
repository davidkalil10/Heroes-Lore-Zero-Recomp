/*
 * Decompiled with CFR 0.152.
 */
import rpg.RPGHeroEx;
import rpg.a;
import rpg.d;
import rpg.e;

abstract class q
extends l {
    private ch var_ch_a = null;
    private boolean[] var_boolean_arr_a;
    private static String var_java_lang_String_a;

    q(n n2, byte by2, byte by3, byte by4) {
        super(n2, (byte)6, (byte)1, (byte)1);
        if (this.var_ch_a == null) {
            this.var_ch_a = new ch("/t/jd");
        }
        this.var_boolean_arr_a = new boolean[6];
        for (byte by5 = 0; by5 < 6; by5 = (byte)(by5 + 1)) {
            this.var_boolean_arr_a[by5] = di.boolean_b(by5);
        }
    }

    protected final int a(cm cm2, byte by2) {
        int n2;
        if (by2 >= 6) {
            n2 = this.a(cm2, false, false, true, false, true);
            by2 = (byte)(by2 - 6);
        } else {
            n2 = this.a(cm2, false, false, true, false, false);
        }
        int n3 = this.b_ + 174 - 60;
        cm2.a(3550755);
        cm2.a(this.a_, n3, rpg.d.e_, 60);
        boolean bl2 = this.boolean_a(by2);
        cm2.a(0xFFFFFF);
        int n4 = 4;
        if (!bl2) {
            n4 = 2;
        }
        for (int i2 = 0; i2 < n4; ++i2) {
            ac.a(cm2, rpg.a.c, n3 + 4 + i2 * 14, this.var_ch_a.a(i2 + (bl2 ? by2 << 2 : 24)), 1, 1);
        }
        n.a(cm2, this.a_ + (rpg.d.e_ - 114) / 2, n3 -= 14, 114, 14, 0x660000, 0x810000);
        n.a(cm2, this.a_ + (rpg.d.e_ - 75) / 2, n3 + 5, 75, 0xFFFFFF, false);
        if (bl2) {
            cm2.a(0xFFFFFF);
        } else {
            cm2.a(0x7F7F7F);
        }
        ac.a(cm2, rpg.a.c, n3, rpg.e.var_ch_d.a(by2 + 1), 1, 1);
        return n2;
    }

    protected final boolean boolean_a(byte by2) {
        try {
            var_java_lang_String_a = RPGHeroEx.a.getAppProperty("UnlockAllCharacters");
        }
        catch (Exception exception) {
            var_java_lang_String_a = null;
        }
        if (var_java_lang_String_a != null && var_java_lang_String_a.equals("true")) {
            return true;
        }
        return this.var_boolean_arr_a[by2];
    }

    static {
        var_java_lang_String_a = null;
    }
}

