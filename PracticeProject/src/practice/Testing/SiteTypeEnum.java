package practice.Testing;

enum SiteTypeEnum {

    PAYTM(1),
    PAYTMMALL(2);

    private final Integer value;

    SiteTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static Integer getDefaultSite() {
        return PAYTM.value | PAYTMMALL.value;
    }

    public static String getSiteTypeByValue(Integer value) {
        if(value != null) {
            for(SiteTypeEnum siteTypeEnum : SiteTypeEnum.values()) {
                if(siteTypeEnum.getValue().equals(value)) {
                    return siteTypeEnum.name();
                }
            }
        }
        return null;
    }
}