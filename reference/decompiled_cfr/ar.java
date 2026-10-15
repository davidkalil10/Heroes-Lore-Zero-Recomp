/*
 * Decompiled with CFR 0.152.
 */
public final class ar
implements Runnable {
    private boolean var_boolean_a;
    private Thread var_java_lang_Thread_a;
    private Object var_java_lang_Object_a = new Object();
    private boolean b = false;

    public ar() {
        this.var_java_lang_Thread_a = new Thread(this);
        this.var_java_lang_Thread_a.start();
        this.var_boolean_a = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void run() {
        while (this.var_boolean_a) {
            try {
                Object object = this.var_java_lang_Object_a;
                synchronized (object) {
                    while (true) {
                        this.var_java_lang_Object_a.wait(100000L);
                    }
                }
            }
            catch (Exception exception) {
            }
            finally {
                this.b = false;
            }
        }
    }
}

