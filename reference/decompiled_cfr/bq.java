/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.media.Manager
 *  javax.microedition.media.Player
 *  javax.microedition.media.control.VolumeControl
 */
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import rpg.c;
import rpg.d;
import rpg.e;

public final class bq
implements d {
    private static int var_int_a;
    public static long var_long_a;
    private static long var_long_b;
    private static byte var_byte_a;
    private static byte var_byte_b;
    private static Player[] var_javax_microedition_media_Player_arr_a;
    private static Player var_javax_microedition_media_Player_a;
    private static byte c;
    private static final byte[] var_byte_arr_a;

    public static final void a() {
        if (!rpg.c.var_boolean_b) {
            return;
        }
        if (var_javax_microedition_media_Player_arr_a[14] == null) {
            return;
        }
        if (var_byte_a == 14 && var_javax_microedition_media_Player_arr_a[14].getState() == 400) {
            return;
        }
        if (var_long_a != 0L && var_long_a > System.currentTimeMillis()) {
            return;
        }
        bq.a((byte)14, true);
        var_long_a = 0L;
    }

    public static final void b() {
        var_long_b = 0L;
        var_byte_a = (byte)-1;
        if (var_javax_microedition_media_Player_a == null || var_javax_microedition_media_Player_a.getState() != 400) {
            return;
        }
        try {
            var_javax_microedition_media_Player_a.stop();
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static final void c() {
        if (var_byte_a == 14) {
            bq.b();
        }
    }

    public static final void d() {
        bq.c();
        var_long_a = System.currentTimeMillis() << 1;
    }

    public static final void e() {
        var_long_a = 0L;
        bq.a();
    }

    public static final void f() {
        bq.c();
        bq.k();
    }

    public static final void a(byte by2, boolean bl2) {
        try {
            bq.b();
            if (var_byte_a != by2) {
                var_javax_microedition_media_Player_a = var_javax_microedition_media_Player_arr_a[by2];
            } else if (var_javax_microedition_media_Player_a == null) {
                byte by3 = by2;
                if (by3 == 14) {
                    bq.b(var_byte_b);
                } else {
                    bq.b((int)by3);
                }
                var_javax_microedition_media_Player_a = var_javax_microedition_media_Player_arr_a[by3];
            }
            var_byte_a = by2;
            var_javax_microedition_media_Player_a.setLoopCount(bl2 ? -1 : 1);
            var_javax_microedition_media_Player_a.start();
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        var_long_a = System.currentTimeMillis() + 3000L;
    }

    public static final void b(byte by2, boolean bl2) {
        bq.c();
        bq.b(by2);
        if (bl2) {
            var_long_a = 0L;
            bq.a();
            return;
        }
        by2 = 0;
        by2 = (byte)14;
        bq.a((byte)14, false);
    }

    public static final void a(byte by2) {
        if (rpg.c.var_boolean_c) {
            if (System.currentTimeMillis() - var_long_b < 127L) {
                return;
            }
            if (var_javax_microedition_media_Player_arr_a[by2] == null) {
                bq.b((int)by2);
            }
            bq.a(by2, false);
            var_long_b = System.currentTimeMillis();
        }
    }

    public static final void a(int n2) {
        if (n2 < 0) {
            n2 = 0;
        } else if (n2 > var_int_a) {
            n2 = var_int_a;
        }
        if (var_javax_microedition_media_Player_a != null) {
            try {
                VolumeControl volumeControl;
                if (var_javax_microedition_media_Player_a.getState() != 400 && (volumeControl = (VolumeControl)var_javax_microedition_media_Player_a.getControl("VolumeControl")) != null) {
                    volumeControl.setLevel(n2 * 100 / var_int_a);
                }
                return;
            }
            catch (Exception exception) {}
        }
    }

    public static final void b(byte by2) {
        if (by2 >= 17) {
            return;
        }
        c = by2;
        try {
            Object object = e.a("/snd/b/" + by2);
            object = new ByteArrayInputStream((byte[])object);
            bq.var_javax_microedition_media_Player_arr_a[14] = Manager.createPlayer((InputStream)object, (String)"audio/midi");
            var_javax_microedition_media_Player_arr_a[14].realize();
            var_javax_microedition_media_Player_arr_a[14].prefetch();
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    private static void k() {
        if (var_javax_microedition_media_Player_arr_a[14] != null) {
            var_javax_microedition_media_Player_arr_a[14].close();
            bq.var_javax_microedition_media_Player_arr_a[14] = null;
        }
    }

    public static final void g() {
        bq.b(10);
        bq.b(11);
        bq.b(13);
        for (int i2 = 1; i2 <= 4; ++i2) {
            bq.b(i2);
        }
    }

    public static final void h() {
        for (int i2 = 0; i2 < 6; ++i2) {
            if (var_javax_microedition_media_Player_arr_a[var_byte_arr_a[i2]] == null) continue;
            bq.var_javax_microedition_media_Player_arr_a[bq.var_byte_arr_a[i2]] = null;
        }
        bq.b((int)var_byte_arr_a[di.var_byte_b]);
        try {
            Object object = e.a("/snd/e/" + (di.boolean_a() ? 12 : 11));
            object = new ByteArrayInputStream((byte[])object);
            bq.var_javax_microedition_media_Player_arr_a[11] = Manager.createPlayer((InputStream)object, (String)"audio/x-wav");
            var_javax_microedition_media_Player_arr_a[11].realize();
            var_javax_microedition_media_Player_arr_a[11].prefetch();
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static final void b(int n2) {
        try {
            Object object = e.a("/snd/e/" + n2);
            object = new ByteArrayInputStream((byte[])object);
            bq.var_javax_microedition_media_Player_arr_a[n2] = Manager.createPlayer((InputStream)object, (String)"audio/x-wav");
            var_javax_microedition_media_Player_arr_a[n2].realize();
            var_javax_microedition_media_Player_arr_a[n2].prefetch();
            return;
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
            return;
        }
    }

    public static void i() {
        if (var_byte_a == 14) {
            bq.b();
            if (c >= 0) {
                bq.k();
            }
        }
    }

    public static void j() {
        if (c >= 0) {
            bq.b(c);
        }
    }

    static {
        var_int_a = 10;
        var_byte_a = (byte)-1;
        var_byte_b = (byte)-1;
        var_javax_microedition_media_Player_arr_a = new Player[15];
        c = (byte)-1;
        var_byte_arr_a = new byte[]{8, 5, 7, 9, 8, 6};
    }
}

