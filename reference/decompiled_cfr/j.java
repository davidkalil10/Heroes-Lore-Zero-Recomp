/*
 * Decompiled with CFR 0.152.
 */
import rpg.RPGHeroEx;
import rpg.a;
import rpg.d;
import rpg.e;
import rpg.f;

final class j
extends b {
    private byte[] var_byte_arr_a;
    private byte[] b;
    private short[] var_short_arr_a;
    private int e = f.b;

    j(n n2) {
        super(n2, (byte)1);
        n2 = this;
        this.var_byte_arr_a = rpg.e.var_ch_f.a(0);
        Object object = "Version: " + RPGHeroEx.a.getAppProperty("MIDlet-Version");
        ((j)n2).b = ("Heroes Lore Zero Copyright 2012 Electronic Arts Inc.;Published by Electronic Arts Inc.;" + (String)object + ";Customer Service: Send email to help@eamobile.com;Copyright 2012 Electronic Arts Inc, EA, the EA logo and Heroes Lore are trademarks of Electronic Arts Inc. All other trademarks are the property of their respective owners.;Copyright 2012 Electronic Arts Inc, All trademarks are the property of their respective owners.;Copyright 2012 Electronic Arts Inc, EA, the EA logo and heroes Lore are trademarks of Electronic Arts Inc." + ";;;|CREDITS&;EA Korea Studio;EA China Studio;;;Last revised by EA Hyderabad:;\\Engineering Lead&;Mahender Domakonda;;\\Engineers&;Rajesh Gorantla;Vishwajeet Jadhav;Ranjith Akuthota").getBytes();
        object = new short[20];
        int n3 = 0;
        for (int i2 = 0; i2 < ((j)n2).b.length; i2 += ac.a(((j)n2).b, i2, ((j)n2).e, 8)) {
            object[n3++] = (short)i2;
        }
        ((j)n2).var_short_arr_a = new short[n3];
        System.arraycopy(object, 0, ((j)n2).var_short_arr_a, 0, ((j)n2).var_short_arr_a.length);
        n2.var_byte_b = (byte)((j)n2).var_short_arr_a.length;
        n2.var_byte_a = 0;
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.f(n2, n3) || n.g(n2, n3)) {
            if (n2 == -7) {
                this.var_n_a.var_byte_a = (byte)5;
                this.var_n_a.c();
            }
            return true;
        }
        return this.c(n2, n3);
    }

    protected final void a(cm cm2) {
        int n2 = rpg.a.d;
        rpg.a.a(cm2, true);
        n2 -= 36;
        cm2.a(14597755);
        ac.a(cm2, rpg.a.c, f.d, this.var_byte_arr_a, 0, 1);
        cm2.a(0xCCCCCC);
        short s2 = this.var_short_arr_a[this.var_byte_a];
        short s3 = this.var_byte_a == this.var_byte_b - 1 ? (short)this.b.length : this.var_short_arr_a[this.var_byte_a + 1];
        int n3 = rpg.a.var_int_a - this.e >> 1;
        ac.a(cm2, n3 + 5, n2, this.e, 1, this.b, s2, 0, s3 - s2);
        if (this.var_byte_b > 1) {
            this.a(cm2, this.a_ + rpg.d.e_ - 10, n2 - 10, this.var_byte_a + 1, this.var_byte_b, 8);
        }
        this.e(cm2, n3 + this.e - 2, n2 - 2, this.var_byte_a, this.var_byte_b);
        n.a(cm2, 2);
    }
}

