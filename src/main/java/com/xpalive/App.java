package com.xpalive;

import com.xpalive.cmsblog.mapper.CmsBlogMapper;
import com.xpalive.cmsblog.model.CmsBlog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class App {
  public static void main(String[] args) {
    String resource = "mybatis-config.xml";
    InputStream inputStream;
    try {
      inputStream = Resources.getResourceAsStream(resource);

      SqlSessionFactory sqlSessionFactory =
        new SqlSessionFactoryBuilder().build(inputStream);
      try (SqlSession session = sqlSessionFactory.openSession()) {
        CmsBlogMapper mapper = session.getMapper(CmsBlogMapper.class);
        CmsBlog blog = mapper.selectById(101);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
