/*
 * Decompiled with CFR 0.152.
 */
import java.util.Vector;
import rpg.a;
import rpg.e;
import rpg.g;

final class dl
extends de {
    private Vector var_java_util_Vector_a = new Vector();
    private bx var_bx_a = null;

    public dl(n n2) {
        super(n2, (byte)6);
        boolean bl2 = true;
        dl dl2 = this;
        byte[] byArray = c.a((byte)20, null);
        dl2.a(byArray, true, false);
    }

    final boolean boolean_a(int n2, int n3) {
        if (this.b(n2, n3)) {
            return true;
        }
        if (n.g(n2, n3)) {
            this.var_n_a.c();
            return true;
        }
        if (n.f(n2, n3)) {
            if (this.var_byte_a < this.var_java_util_Vector_a.size()) {
                bx bx2 = this.var_bx_a = (bx)this.var_java_util_Vector_a.elementAt(this.var_byte_a);
                this.var_n_b = new dj((n)this, rpg.e.var_ch_h.a(33, 35));
            }
            return true;
        }
        return this.c(n2, n3);
    }

    /*
     * Enabled aggressive block sorting
     */
    final void void_a(byte by2, byte by3) {
        this.c();
        if (by2 != 6) {
            if (by2 != 3) return;
            if (by3 != 0) return;
            dl dl2 = this;
            byte[] byArray = new byte[8];
            g.a(0L, byArray, 0);
            byArray = c.a((byte)22, byArray);
            dl2.a(byArray, true, false);
            return;
        }
        dl dl3 = this;
        bx bx2 = dl3.var_bx_a;
        if (by3 == 0) {
            dl3.k();
            return;
        }
        if (by3 != 1) return;
        dl3.var_n_b = new bt((n)dl3, rpg.e.var_ch_h.a(45), 3, true, true);
    }

    private final void k() {
        byte[] byArray = new byte[8];
        g.a(0L, byArray, 0);
        byArray = c.a((byte)21, byArray);
        this.a(byArray, true, false);
    }

    protected final void a(cm cm2) {
        rpg.a.a(cm2, true);
        cm2.a(14597755);
        ac.a(cm2, rpg.a.c, rpg.a.d - 58, rpg.e.var_ch_h.a(31), 0, 1);
        int n2 = this.var_java_util_Vector_a.size();
        int n3 = this.var_byte_a / 6 * 6;
        int n4 = this.var_byte_a % 6;
        for (int n5 = 0; n5 < 6; n5 = (int)((byte)(n5 + 1))) {
            int n6 = this.b_ + 16 + n5 * 13;
            n.a(cm2, this.a_ + 3, n6, 108, 12, n4 == n5 ? 0x660000 : 3550755, this.var_byte_a == n5 ? 0xBD0000 : 7027456);
            if (n3 < n2) {
                boolean bl2 = n4 == n5;
                int n7 = n6;
                int n8 = this.a_;
                cm cm3 = cm2;
                bx bx2 = (bx)this.var_java_util_Vector_a.elementAt(n3);
                bx2 = bx2;
                cm3.a(bl2 ? 0xFFFFFF : 12630160);
                ac.a(cm3, n8 + 24, n7, null, 0);
                ac.a(cm3, n8 + 109, n7, null, 0, 8);
            }
            ++n3;
        }
        this.a(cm2, rpg.a.c + 52, rpg.a.d - 55, this.var_byte_a / 6 + 1, this.var_byte_b / 6, 8);
        this.e(cm2, rpg.a.c + 54, rpg.a.d - 37, this.var_byte_a / 6, this.var_byte_b / 6);
    }
}

