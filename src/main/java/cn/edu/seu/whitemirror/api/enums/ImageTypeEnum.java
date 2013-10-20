package cn.edu.seu.whitemirror.api.enums;

/**
 * Created with IntelliJ IDEA.
 * User: snow
 * Date: 13-10-20
 * Time: 上午9:42
 * To change this template use File | Settings | File Templates.
 */
public enum ImageTypeEnum {
    Standard(0),
    Link(1);

    private int value;
    private ImageTypeEnum(final int value) {
        this.value = value;
    }

    public static ImageTypeEnum valueOf(final int value) {
        switch (value) {
            case 0:
                return Standard;
            case 1:
                return Link;
            default:
                return null;
        }
    }

    public int value() {
        return this.value;
    }
}
