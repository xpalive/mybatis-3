package com.xpalive.cmsblog.model;

import java.time.LocalDateTime;
import java.util.StringJoiner;


public class CmsBlog {
  private long id;
  private String title;
  private String author;
  private String content;
  private LocalDateTime createTime;
  private LocalDateTime modifyTime;

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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public LocalDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(LocalDateTime createTime) {
    this.createTime = createTime;
  }

  public LocalDateTime getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(LocalDateTime modifyTime) {
    this.modifyTime = modifyTime;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", CmsBlog.class.getSimpleName() + "[", "]")
      .add("id=" + id)
      .add("title='" + title + "'")
      .add("author='" + author + "'")
      .add("content='" + content + "'")
      .add("createTime=" + createTime)
      .add("modifyTime=" + modifyTime)
      .toString();
  }
}
