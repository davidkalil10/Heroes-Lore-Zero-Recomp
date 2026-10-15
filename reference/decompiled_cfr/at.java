/*
 * Decompiled with CFR 0.152.
 */
import rpg.d;

abstract class at
implements d {
    public byte var_byte_a;
    protected int var_int_a;
    protected int var_int_b;
    protected int c;
    protected byte var_byte_b;
    protected boolean var_boolean_a;
    protected boolean var_boolean_b;

    at(byte by2) {
        this.var_byte_a = by2;
        this.var_int_a = 1;
        this.c = 1;
        this.var_byte_b = 0;
        this.var_int_b = 0;
        this.var_boolean_b = true;
    }

    abstract void a(int var1, int var2);

    final void a(int n2, int n3, boolean bl2) {
        if (this.var_boolean_b != bl2 || this.var_boolean_a) {
            return;
        }
        this.a(n2, n3);
        if (di.var_byte_d != 5) {
            this.a();
        }
    }

    void a() {
        ++this.var_int_b;
        if (this.c != -1 && this.var_int_b >= this.var_int_a * this.c) {
            this.var_boolean_a = true;
        }
    }

    public static final boolean a(byte by2) {
        switch (by2) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                return true;
            }
        }
        return false;
    }
}

