/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import rpg.g;

public final class bm
extends as {
    public byte var_byte_d;
    public byte e;
    public byte f;
    public byte g;
    public short a;
    public short b;
    public short var_short_c;
    public short var_short_d;
    public byte h;
    private static byte[] var_byte_arr_d;
    public byte[] var_byte_arr_c = new byte[]{-3, -3, -3, -3, -3, -3};
    public byte i;

    public bm(byte by2, byte by3) {
        super(by2, by3);
        this.e = by3 < 16 ? (byte)0 : 1;
        this.i = (byte)-1;
    }

    protected final byte byte_a() {
        int n2 = super.byte_a();
        for (int i2 = 0; i2 < this.var_byte_arr_c.length; ++i2) {
            n2 += this.var_byte_arr_c[i2] << ((i2 & 1) == 0 ? 2 : 3);
        }
        return (byte)(n2 % 100);
    }

    protected final DataOutputStream a(DataOutputStream dataOutputStream) {
        dataOutputStream = super.a(dataOutputStream);
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeShort(this.var_short_c);
        dataOutputStream.writeShort(this.var_short_d);
        dataOutputStream.writeByte(this.h);
        ((OutputStream)dataOutputStream).write(this.var_byte_arr_c);
        dataOutputStream.write(this.i);
        return dataOutputStream;
    }

    protected final void a(DataInputStream dataInputStream) {
        super.a(dataInputStream);
        this.b = dataInputStream.readShort();
        this.var_short_c = dataInputStream.readShort();
        this.var_short_d = dataInputStream.readShort();
        this.h = dataInputStream.readByte();
        dataInputStream.read(this.var_byte_arr_c);
        this.i = dataInputStream.readByte();
    }

    protected final int a(byte[] byArray, int n2) {
        n2 = super.a(byArray, n2);
        this.var_byte_d = byArray[n2++];
        this.e = byArray[n2++];
        this.f = byArray[n2++];
        this.g = byArray[n2++];
        this.a = rpg.g.short_b(byArray, n2);
        this.b = rpg.g.short_b(byArray, n2 += 2);
        this.var_short_c = rpg.g.short_b(byArray, n2 += 2);
        this.var_short_d = rpg.g.short_b(byArray, n2 += 2);
        n2 += 2;
        this.h = byArray[n2++];
        System.arraycopy(byArray, n2, this.var_byte_arr_c, 0, this.var_byte_arr_c.length);
        n2 += this.var_byte_arr_c.length;
        for (int i2 = 0; i2 < this.var_byte_arr_c.length; ++i2) {
            if (this.var_byte_arr_c[i2] != 100) continue;
            this.var_byte_arr_c[i2] = (byte)rpg.g.a(0, 15);
        }
        return n2;
    }

    public final int int_a(int n2) {
        int n3 = 0;
        for (int i2 = 0; i2 < this.var_byte_arr_c.length; ++i2) {
            if (this.var_byte_arr_c[i2] != n2) continue;
            n3 += var_byte_arr_d[n2];
        }
        return n3;
    }

    public final int int_a() {
        int n2;
        for (n2 = 0; n2 < this.var_byte_arr_c.length && this.var_byte_arr_c[n2] != -3; ++n2) {
        }
        return n2;
    }

    static {
        var_byte_arr_d = new byte[]{5, 5, 5, 5, 50, 1, 8, 5, 1, 100, 8, 8, 8, 8, 1, 3};
    }
}

