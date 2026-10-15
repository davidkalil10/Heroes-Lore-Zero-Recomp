/*
 * Decompiled with CFR 0.152.
 */
import rpg.RPGHeroEx;
import rpg.a;
import rpg.d;

final class cf
extends b {
    private byte[] var_byte_arr_a;
    private String var_java_lang_String_b = null;
    private cg var_cg_b = null;
    private cg var_cg_c = null;
    private cg d = null;
    public static String var_java_lang_String_a;
    private static String var_java_lang_String_c;
    private static boolean e;

    cf(n n2) {
        super(n2, (byte)3);
        this.var_byte_a = 0;
        if (var_java_lang_String_a != null && !var_java_lang_String_a.equals("off")) {
            if (var_java_lang_String_a.equals("static")) {
                this.var_byte_arr_a = rpg.d.E;
            } else {
                this.var_byte_arr_a = rpg.d.D;
                this.var_java_lang_String_b = RPGHeroEx.a.getAppProperty("MoreGames_WAP_URI").trim();
            }
        }
        n2 = this;
        try {
            ((cf)n2).var_cg_c = cg.a("/sks/no.png");
            ((cf)n2).var_cg_b = cg.a("/sks/yes.png");
            ((cf)n2).d = cg.a("/sks/back.png");
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            this.var_n_a.var_byte_a = (byte)6;
            this.var_n_a.c();
            return true;
        }
        if (n.f(n2, n3)) {
            if (!var_java_lang_String_a.equals("static")) {
                String string = this.var_java_lang_String_b;
                System.out.println("inside the platform Request method");
                try {
                    bq.b();
                    RPGHeroEx.a.platformRequest(string);
                    RPGHeroEx.a.notifyDestroyed();
                }
                catch (Exception exception) {
                    System.out.println("excpeton occured" + exception);
                    RPGHeroEx.a.notifyDestroyed();
                }
                finally {
                    RPGHeroEx.a.notifyDestroyed();
                }
            } else {
                return true;
            }
            return true;
        }
        return true;
    }

    protected final void a(cm cm2) {
        rpg.a.a(cm2, true);
        int n2 = rpg.a.d;
        cm2.a(0xFFFFFF);
        ac.a(cm2, rpg.a.c, n2 + 3, this.var_byte_arr_a, 0, 1);
        if (var_java_lang_String_a.equals("static")) {
            cm2.a(this.d, rpg.a.var_int_a, rpg.a.var_int_b, 40);
            return;
        }
        cm2.a(this.var_cg_b, 0, rpg.a.var_int_b, 36);
        cm2.a(this.var_cg_c, rpg.a.var_int_a, rpg.a.var_int_b, 40);
    }

    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 == 3 && by3 == 0) {
            RPGHeroEx.a.a("Tj" + (this.var_byte_a + 1) + "URL");
        }
    }

    public static void a() {
        var_java_lang_String_a = RPGHeroEx.a.getAppProperty("MoreGames_Impl");
        if (var_java_lang_String_a == null) {
            var_java_lang_String_a = "off";
            return;
        }
        if (!((var_java_lang_String_a = var_java_lang_String_a.toLowerCase()).equals("static") || var_java_lang_String_a.equals("wap") || var_java_lang_String_a.equals("wapstatic"))) {
            var_java_lang_String_a = "off";
            return;
        }
        var_java_lang_String_c = RPGHeroEx.a.getAppProperty("MoreGames_WAP_URI");
        if (var_java_lang_String_a.equals("wap") && (!e || var_java_lang_String_c == null || var_java_lang_String_c.trim().equals(""))) {
            var_java_lang_String_a = "off";
        }
        if (var_java_lang_String_a.equals("wapstatic") && (!e || var_java_lang_String_c == null || var_java_lang_String_c.trim().equals(""))) {
            var_java_lang_String_a = "static";
        }
    }

    static {
        var_java_lang_String_a = null;
        var_java_lang_String_c = null;
        e = true;
    }
}

