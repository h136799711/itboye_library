/**
 * 
 */
package com.itboye.utils.xml;

import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

/**
 * 
 * @author hebidu
 * @date 2015年8月25日
 * @version 1.0
 */
public class XMLUtils {
	
	/**
	 * 从xml字符串中，获取org.dom4j.Document对象
	 * @param strXML				xml格式的字符串
	 * @return						org.dom4j.Document对象
	 * @throws DocumentException
	 */
	public static org.dom4j.Document getXMLDocument(String strXML) throws DocumentException{

		org.dom4j.Document document = DocumentHelper.parseText(strXML);
		
		return document;
	}
	
	/**
	 * 获取node的文本信息
	 * @param strXpath					类似 root/leaf 这样格式的字符串
	 * @param xmlDoc					org.dom4j.Document对象
	 * @return 							文本内容
	 * @throws XPathExpressionException
	 */
	public static String getNodeText(String nodeName,org.dom4j.Document xmlDoc){
		
		Element root = xmlDoc.getRootElement();
		
		Node node = root.selectSingleNode("//"+nodeName); 
		if(node == null){
			return "";
		}
		return node.getText(); 
	}
	
	/** 
	* 获取所有名称为nodeName的节点 
	* @param nodeName 
	* @return 
	*/ 
	@SuppressWarnings("unchecked") 
	public static List<Node> getNodeList(String nodeName,org.dom4j.Document xmlDoc){ 

		Element root = xmlDoc.getRootElement();
		
		return root.selectNodes("//"+nodeName); 
	} 
	
	/**
	 * 判断是否含有指定节点
	 * @param nodeName
	 * @param xmlDoc
	 * @return
	 */
	public boolean hasNode(String nodeName,org.dom4j.Document xmlDoc){
		
		Element root = xmlDoc.getRootElement();
		Node node = root.selectSingleNode("//"+nodeName);
		if(node == null){
			return false;
		}
		return true;
	}

}
