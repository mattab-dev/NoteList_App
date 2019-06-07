package pl.example.notelist.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

import pl.example.notelist.data.converters.DateConverter;
import pl.example.notelist.data.converters.NoteCategoryConverter;

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "content")
    private String content;

    @TypeConverters(NoteCategoryConverter.class)
    private NoteCategoryEnum category;

    @ColumnInfo(name = "priority")
    private boolean isHighPriority;

    @TypeConverters(DateConverter.class)
    private Date createDate;

    public Note(String title, String content, int category, boolean isHighPriority, Date createDate) {
        this.title = title;
        this.content = content;
        this.category = NoteCategoryEnum.getValue(category);
        this.isHighPriority = isHighPriority;
        this.createDate = createDate;
    }

    public Note() {

    }

    @Ignore
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NoteCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(NoteCategoryEnum category) {
        this.category = category;
    }

    public boolean isHighPriority() {
        return isHighPriority;
    }

    public void setHighPriority(boolean highPriority) {
        isHighPriority = highPriority;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
