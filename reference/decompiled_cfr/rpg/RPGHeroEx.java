/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.midlet.MIDlet
 */
package rpg;

import javax.microedition.midlet.MIDlet;
import rpg.c;

public class RPGHeroEx
extends MIDlet {
    public static RPGHeroEx a = null;

    protected void startApp() {
        if (a == null) {
            a = this;
            c.rpg_c_a().c();
            return;
        }
        bq.b();
        if (c.rpg_c_a() != null) {
            c.rpg_c_a().b();
        }
    }

    protected void pauseApp() {
        if (c.rpg_c_a() != null) {
            c.rpg_c_a().void_a();
        }
    }

    public void destroyApp(boolean bl2) {
        c.f = false;
        this.notifyDestroyed();
    }

    public final void a(String object) {
        try {
            object = this.getAppProperty((String)object);
            if (object != null && ((String)object).trim().length() > 7) {
                this.platformRequest((String)object);
            }
        }
        catch (Exception exception) {
            object = exception;
            exception.printStackTrace();
        }
        this.destroyApp(true);
    }
}

