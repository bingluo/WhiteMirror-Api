package cn.edu.seu.whitemirror.api.enums;

/**
 * Created with IntelliJ IDEA.
 * User: snow
 * Date: 13-10-17
 * Time: 下午2:17
 * To change this template use File | Settings | File Templates.
 */

public enum SectionTypeEnum {

    Standard(0),
    ExternalLink(1),
    Exclusive(2);

    private int value = 0;

    private SectionTypeEnum(int value) {
        this.value = value;
    }

    public static SectionTypeEnum valueOf(int value) {
        switch (value) {
            case 0:
                return Standard;
            case 1:
                return ExternalLink;
            case 2:
                return Exclusive;
            default:
                return null;
        }
    }
    public int value() {
        return this.value;
    }
}
