/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class cm {
    public static final Image var_javax_microedition_lcdui_Image_a;
    private static final Graphics var_javax_microedition_lcdui_Graphics_a;
    private static final cm var_cm_a;
    private Graphics var_javax_microedition_lcdui_Graphics_b = null;
    private int var_int_a = -1;
    private int var_int_b = 0;

    public cm() {
        this.var_javax_microedition_lcdui_Graphics_b = var_javax_microedition_lcdui_Graphics_a;
    }

    public cm(Graphics graphics) {
        this.var_javax_microedition_lcdui_Graphics_b = graphics;
    }

    public static cm cm_a() {
        return var_cm_a;
    }

    public final void a(cg cg2, int n2, int n3, int n4) {
        try {
            if (this.var_int_a != -1) {
                int n5 = cg2.javax_microedition_lcdui_Image_a().getWidth();
                int n6 = cg2.javax_microedition_lcdui_Image_a().getHeight();
                int[] nArray = new int[n5 * n6];
                cg2.javax_microedition_lcdui_Image_a().getRGB(nArray, 0, n5, 0, 0, n5, n6);
                for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
                    if (nArray[i2] >>> 24 == 0) continue;
                    int n7 = i2;
                    nArray[n7] = nArray[n7] & this.var_int_a;
                }
                Image image = Image.createRGBImage((int[])nArray, (int)n5, (int)n6, (boolean)true);
                this.var_javax_microedition_lcdui_Graphics_b.drawImage(image, n2, n3, n4);
                return;
            }
            this.var_javax_microedition_lcdui_Graphics_b.drawImage(cg2.javax_microedition_lcdui_Image_a(), n2, n3, n4);
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
    }

    public final void a(int n2) {
        this.var_javax_microedition_lcdui_Graphics_b.setColor(n2);
        this.var_int_b = n2;
    }

    public final void a(int n2, int n3, int n4) {
        this.var_javax_microedition_lcdui_Graphics_b.setColor(n2, n3, n4);
        this.var_int_b = (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
    }

    public final void a(int n2, int n3, int n4, int n5) {
        if (this.var_int_a == -1) {
            this.var_javax_microedition_lcdui_Graphics_b.fillRect(n2, n3, n4, n5);
            return;
        }
        int[] nArray = new int[n4 * n5];
        int n6 = (this.var_int_b | 0xFF000000) & this.var_int_a;
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            nArray[i2] = n6;
        }
        this.var_javax_microedition_lcdui_Graphics_b.drawRGB(nArray, 0, n4, n2, n3, n4, n5, true);
    }

    public final void b(int n2, int n3, int n4, int n5) {
        this.var_javax_microedition_lcdui_Graphics_b.setClip(n2, n3, n4, n5);
    }

    public final void c(int n2, int n3, int n4, int n5) {
        this.var_javax_microedition_lcdui_Graphics_b.clipRect(n2, n3, n4, n5);
    }

    public final void d(int n2, int n3, int n4, int n5) {
        if (this.var_int_a == -1) {
            this.var_javax_microedition_lcdui_Graphics_b.drawRect(n2, n3, n4, n5);
        }
    }

    public final void e(int n2, int n3, int n4, int n5) {
        if (this.var_int_a == -1) {
            this.var_javax_microedition_lcdui_Graphics_b.drawLine(n2, n3, n4, n5);
        }
    }

    public final void a(String string, int n2, int n3, int n4) {
        if (this.var_int_a == -1) {
            this.var_javax_microedition_lcdui_Graphics_b.drawString(string, n2, n3, n4);
        }
    }

    public final void b(int n2) {
        this.var_int_a = (n2 & 0xFF) << 24 | 0xFFFFFF;
    }

    public final int int_a() {
        return this.var_javax_microedition_lcdui_Graphics_b.getClipX();
    }

    public final int b() {
        return this.var_javax_microedition_lcdui_Graphics_b.getClipY();
    }

    public final int c() {
        return this.var_javax_microedition_lcdui_Graphics_b.getClipWidth();
    }

    public final int d() {
        return this.var_javax_microedition_lcdui_Graphics_b.getClipHeight();
    }

    public final void a(int n2, int n3, int n4, int n5, int n6, int n7) {
        this.var_javax_microedition_lcdui_Graphics_b.fillTriangle(n2, n3, n4, n5, n6, n7);
    }

    static {
        var_javax_microedition_lcdui_Image_a = Image.createImage((int)ct.var_javax_microedition_lcdui_Canvas_a.getWidth(), (int)ct.var_javax_microedition_lcdui_Canvas_a.getHeight());
        var_javax_microedition_lcdui_Graphics_a = var_javax_microedition_lcdui_Image_a.getGraphics();
        var_cm_a = new cm();
    }
}

