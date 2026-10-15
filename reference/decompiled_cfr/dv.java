/*
 * Decompiled with CFR 0.152.
 */
public final class dv
extends as {
    public byte[] c = new byte[]{-1, -1};
    public byte[] d = new byte[]{-1, -1, -1, -1, -1, -1};

    public dv(byte by2, byte by3) {
        super(by2, by3);
    }

    protected final int a(byte[] byArray, int n2) {
        n2 = super.a(byArray, n2);
        System.arraycopy(byArray, n2, this.d, 0, 6);
        System.arraycopy(byArray, n2 += 6, this.c, 0, 2);
        return n2 += 2;
    }
}

