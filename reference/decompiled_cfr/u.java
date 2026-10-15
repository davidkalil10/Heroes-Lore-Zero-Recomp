/*
 * Decompiled with CFR 0.152.
 */
abstract class u
extends du {
    protected static byte var_byte_a;
    protected static byte var_byte_b;
    public byte c;
    protected short var_short_a;
    protected int var_int_a;
    protected byte d;
    public boolean var_boolean_a;
    public boolean var_boolean_b;

    abstract void a(int var1, int var2);

    abstract void a();

    u(byte by2, byte by3, byte by4, byte by5, boolean bl2) {
        super((short)(by4 << 4), (short)(by5 << 4), (byte)8, (byte)(8 + var_byte_a));
        this.var_boolean_b = true;
        this.c = by2;
        this.d = by3;
        this.var_int_a = -1;
        this.var_boolean_a = false;
    }

    u(byte by2, byte by3, short s2, short s3, boolean bl2) {
        super(s2, s3, (byte)8, (byte)(8 + (bl2 ? var_byte_a : var_byte_b)));
        this.var_boolean_b = bl2;
        this.c = by2;
        this.d = 1;
        this.var_int_a = -1;
        this.var_boolean_a = false;
    }

    public final void b(int n2, int n3) {
        u u2 = this;
        ++u2.var_int_a;
        u2.a();
        if (this.var_boolean_a) {
            di.var_g_a.d(this);
            return;
        }
        this.a(n2, n3);
    }

    static {
        var_byte_a = (byte)2;
        var_byte_b = (byte)-5;
    }
}

