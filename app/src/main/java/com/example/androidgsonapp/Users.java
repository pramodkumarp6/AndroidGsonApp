package com.example.androidgsonapp;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
@JsonClass(generateAdapter = true)
public class Users {
     @Json(name = "id")
  private int id;

  @Json(name = "title")
  private String title;
  @Json(name = "body")

  private String body;
  @Json(name = "userId") int userIds;
  private int userId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}