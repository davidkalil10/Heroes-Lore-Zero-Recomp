/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import rpg.a;
import rpg.e;
import rpg.g;

public class as {
    private byte d;
    public long var_long_a;
    public byte var_byte_a;
    public byte var_byte_b;
    public byte c;
    public int var_int_a;
    public byte[] var_byte_arr_a;
    public byte[] var_byte_arr_b;
    private boolean var_boolean_a;

    protected as(byte by2, byte by3) {
        this.c = 1;
        this.var_byte_arr_a = null;
        this.var_byte_arr_b = null;
        this.var_boolean_a = true;
        this.var_byte_a = by2;
        this.var_byte_b = by3;
        this.c = 1;
    }

    public static final synchronized as a(byte by2, byte by3) {
        as as2 = by2 >= 0 && by2 <= 15 ? new bm(by2, by3) : (by2 == 18 ? new dv(by2, by3) : (by2 == 17 ? new ba(by2, by3) : new as(by2, by3)));
        byte[] byArray = e.a("/itm/" + (by2 < 10 ? "0" : "") + by2, (int)by3);
        if (!e.boolean_a(byArray)) {
            as2 = null;
        } else {
            try {
                int n2 = as2.a(byArray, 0);
                if (by2 == 19) {
                    as2.var_boolean_a = byArray[n2] != 0;
                }
            }
            catch (Exception exception) {
                as2 = null;
            }
        }
        return as2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final as a(byte[] byArray) {
        as as2;
        block16: {
            as2 = null;
            ByteArrayInputStream byteArrayInputStream = null;
            FilterInputStream filterInputStream = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(byArray);
                filterInputStream = new DataInputStream(byteArrayInputStream);
                byte by2 = ((DataInputStream)filterInputStream).readByte();
                byte by3 = ((DataInputStream)filterInputStream).readByte();
                as2 = as.a(by2, by3);
                if (as2 != null) {
                    as2.a((DataInputStream)filterInputStream);
                }
            }
            catch (Exception exception) {
                as2 = null;
                try {
                    filterInputStream.close();
                }
                catch (Exception exception2) {}
                try {
                    byteArrayInputStream.close();
                }
                catch (Exception exception3) {}
                break block16;
            }
            catch (Throwable throwable) {
                try {
                    filterInputStream.close();
                }
                catch (Exception exception) {}
                try {
                    byteArrayInputStream.close();
                    throw throwable;
                }
                catch (Exception exception) {}
                throw throwable;
            }
            try {
                filterInputStream.close();
            }
            catch (Exception exception) {}
            try {
                byteArrayInputStream.close();
            }
            catch (Exception exception) {}
        }
        if (as2 == null) return as2;
        if (as2.byte_a() == as2.d) return as2;
        return null;
    }

    public static final byte[] a(as as2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        as2.d = as2.byte_a();
        try {
            dataOutputStream = as2.a(dataOutputStream);
            dataOutputStream.close();
            byteArrayOutputStream.close();
        }
        catch (Exception exception) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    protected byte byte_a() {
        int n2 = 0 + as.a(this.var_long_a, 10);
        n2 += as.a(this.var_long_a, 100);
        n2 += as.a(this.var_long_a, 100000);
        n2 += this.c << 3;
        n2 += this.var_byte_a << 6;
        return (byte)((n2 += this.var_byte_b << 3) % 100);
    }

    private static int a(long l2, int n2) {
        if (l2 == 0L) {
            return 0;
        }
        return (int)(l2 / (long)n2 % 10L);
    }

    protected DataOutputStream a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeByte(this.var_byte_a);
        dataOutputStream.writeByte(this.var_byte_b);
        dataOutputStream.writeByte(this.c);
        dataOutputStream.writeLong(this.var_long_a);
        dataOutputStream.writeByte(this.d);
        return dataOutputStream;
    }

    protected void a(DataInputStream dataInputStream) {
        this.c = dataInputStream.readByte();
        this.var_long_a = dataInputStream.readLong();
        this.d = dataInputStream.readByte();
    }

    protected int a(byte[] byArray, int n2) {
        byte by2 = byArray[n2++];
        this.var_byte_arr_a = new byte[by2];
        System.arraycopy(byArray, n2, this.var_byte_arr_a, 0, by2);
        this.var_int_a = g.int_a(byArray, n2 += by2);
        n2 += 4;
        this.var_long_a = System.currentTimeMillis();
        by2 = byArray[n2++];
        this.var_byte_arr_b = new byte[by2];
        System.arraycopy(byArray, n2, this.var_byte_arr_b, 0, by2);
        return n2 += by2;
    }

    public final void void_a(int n2) {
        this.c = (byte)(this.c + n2);
    }

    public final void a(cm cm2, int n2, int n3) {
        this.a(cm2, n2, n3, false, true);
    }

    public final void a(cm cm2, int n2, int n3, boolean bl2, boolean bl3) {
        if (bl2) {
            cm2.b(n2 + 1, n3 + 1, 12, 12);
        } else {
            cm2.b(n2, n3, 14, 14);
        }
        cm2.a(e.var_cg_arr_k[29], n2, n3, 20);
        int n4 = this.var_byte_a + (this.var_byte_a == 20 ? this.var_byte_b : (byte)0);
        cm2.a(e.var_cg_arr_k[n4], n2 + 7, n3 + 7, 3);
        rpg.a.a(cm2);
    }

    public final boolean boolean_a() {
        return this.var_byte_a == 20 && this.var_byte_b >= 2;
    }

    public final boolean b() {
        return this instanceof bm;
    }

    public final boolean c() {
        return this instanceof bm && ((bm)this).i >= 0;
    }

    public final boolean d() {
        return this.var_boolean_a;
    }

    public as() {
    }
}

