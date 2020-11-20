package edu.dlut.easyioc.util;

import edu.dlut.easyioc.common.BeanDefinition;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Shuxiang Hu
 * @date 11/19/2020
 */
public class XMLParserImpl implements XMLParser {
    private String xmlPath;
    private Map<String, BeanDefinition> beanDefinitions;

    public XMLParserImpl(String xmlPath) {
        this.xmlPath = xmlPath;
        beanDefinitions = new HashMap<String, BeanDefinition>();
    }

    public void parse(){
        if(!beanDefinitions.isEmpty()){
            beanDefinitions.clear();
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlPath);
            NodeList xmlBeanLst = doc.getElementsByTagName("bean");

            for(int idx = 0, nodeLen=xmlBeanLst.getLength(); idx < nodeLen; idx++){
                Node beanNode =  xmlBeanLst.item(idx);
                BeanDefinition tmp = generateBeanDefinition(beanNode);
                NamedNodeMap contextMap = beanNode.getAttributes();
                Node id = contextMap.getNamedItem("id");
                Node clazz = contextMap.getNamedItem("class");
                tmp.setBeanClassName(clazz.getNodeValue());
                beanDefinitions.put(id.getNodeValue(), tmp);
            }
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BeanDefinition generateBeanDefinition(Node beanNode){
        BeanDefinition tmp = new BeanDefinition("");
        NodeList propertiesLst = beanNode.getChildNodes();
        for(int properIdx=0; properIdx<propertiesLst.getLength(); properIdx++){
            Node propertyNode = propertiesLst.item(properIdx);
            if(propertiesLst.item(properIdx) instanceof Element){
                Element typename = (Element) propertyNode;
                String propStr = typename.getAttribute("name");
                String propVal = typename.getAttribute("value");
                tmp.setPropAndValue(propStr, propVal);
            }
        }
        return tmp;
    }

    public Map<String, BeanDefinition> getBeanDefinitions() {
        return beanDefinitions;
    }
}


