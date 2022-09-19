package com.example.androidgsonapp.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class UsersERt {

  private int id;
  private String title;
  private String body;
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