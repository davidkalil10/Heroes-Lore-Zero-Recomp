/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
import javax.microedition.lcdui.Image;

public final class cg {
    private Image a = null;

    protected final Image javax_microedition_lcdui_Image_a() {
        return this.a;
    }

    private cg(Image image) {
        this.a = image;
    }

    public final cm cm_a() {
        if (this.a == null) {
            return null;
        }
        return new cm(this.a.getGraphics());
    }

    public static cg a(int n2, int n3) {
        Image image = Image.createImage((int)n2, (int)n3);
        return new cg(image);
    }

    public static cg a(byte[] object, int n2, int n3) {
        object = Image.createImage((byte[])object, (int)0, (int)n3);
        return new cg((Image)object);
    }

    public static cg a(String string) {
        try {
            string = Image.createImage((String)string);
            return new cg((Image)string);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public final int int_a() {
        return this.a.getWidth();
    }

    public final int b() {
        return this.a.getHeight();
    }
}

