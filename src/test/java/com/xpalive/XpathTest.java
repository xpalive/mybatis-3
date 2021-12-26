package com.xpalive;

import org.apache.ibatis.io.Resources;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;

class XpathTest {
  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  XPathFactory xPathFactory = XPathFactory.newInstance();

  @Test
  void nodeRead() throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
    factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
    factory.setValidating(false);

    factory.setNamespaceAware(false);
    factory.setIgnoringComments(true);
    factory.setIgnoringElementContentWhitespace(false);
    factory.setCoalescing(false);
    factory.setExpandEntityReferences(true);

    DocumentBuilder builder = factory.newDocumentBuilder();
    InputStream inputStream = Resources.getResourceAsStream("Mapper.xml");
    Document document = builder.parse(inputStream);
    XPath xpath = xPathFactory.newXPath();
    Object root = document;
    Object extracted = extracted(xpath, root, "/mapper");
//    extracted(xpath, root, "cache-ref");
//    extracted(xpath, root, "cache");
    // 绝对路径
    extracted(xpath, extracted, "/mapper/resultMap");
//    extracted(xpath, root, "/mapper/sql");
    // 相对路径
    extracted(xpath, extracted, "select|insert|update|delete");
  }

  private Object extracted(XPath xpath, Object root, String expression) throws XPathExpressionException {
    QName returnType = XPathConstants.NODE;
    Object evaluate = xpath.evaluate(expression, root, returnType);
    System.out.println(evaluate);
    return evaluate;
  }
}
