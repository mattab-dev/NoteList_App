package pl.example.notelist.data.converters;

import androidx.room.TypeConverter;

import pl.example.notelist.data.NoteCategoryEnum;

public class NoteCategoryConverter {

    @TypeConverter
    public static NoteCategoryEnum  toNoteCategoryEnumValue(int value) {
        if (value == NoteCategoryEnum.SHOPPING.getCategory()) {
            return NoteCategoryEnum.SHOPPING;
        } else if (value == NoteCategoryEnum.BUSINESS.getCategory()) {
            return NoteCategoryEnum.SHOPPING;
        } else if (value == NoteCategoryEnum.FAMILY.getCategory()) {
            return NoteCategoryEnum.FAMILY;
        } else if (value == NoteCategoryEnum.SPORT.getCategory()) {
            return NoteCategoryEnum.SPORT;
        } else {
            return null;
        }
    }

    @TypeConverter
    public static int toIntValue(NoteCategoryEnum value) {
        return value == null ? null : value.getCategory();
    }
}
