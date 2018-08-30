package com.sinokj.code.ibatis;

public abstract interface AbstractDao
{
  public abstract Object selectOne(String paramString, Object paramObject);
}