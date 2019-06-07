package pl.example.notelist.data;

public enum NoteCategoryEnum {
    SHOPPING(0),
    BUSINESS(1),
    FAMILY(2),
    SPORT(3);

    private final int category;

    NoteCategoryEnum(int category) {
        this.category = category;
    }


    public static final NoteCategoryEnum getValue(int category) {
        for(NoteCategoryEnum e : values()) {
            if(e.category == category) {
                return e;
            }
        }
        return null;
    }

    public int getCategory() {
        return category;
    }
}

