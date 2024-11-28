package com.blackhuang.mini.spring.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.blackhuang.mini.spring.beans.BeansException;
import com.blackhuang.mini.spring.beans.PropertyValue;
import com.blackhuang.mini.spring.beans.PropertyValues;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinition;
import com.blackhuang.mini.spring.beans.factory.config.BeanDefinitionRegistry;
import com.blackhuang.mini.spring.beans.factory.config.BeanReference;
import com.blackhuang.mini.spring.beans.factory.support.AbstractBeanDefinitionReader;
import com.blackhuang.mini.spring.core.io.Resource;
import com.blackhuang.mini.spring.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

/**
 * @author blackhuang
 * @date 2024/11/28 17:12
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public static final String BEAN_ELEMENT = "bean";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String REF_ATTRIBUTE = "ref";

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(resourceLoader, registry);
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader loader = getResourceLoader();
        Resource resource = loader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try (InputStream ins = resource.getInputStream()) {
                doLoadBeanDefinitions(ins);
            }
        } catch (Exception e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    protected void doLoadBeanDefinitions(InputStream ins) throws BeansException {
        Document document = XmlUtil.readXML(ins);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (!(node instanceof Element)) {
                continue;
            }
            Element element = (Element) node;

            // 实例化 bean definition
            String className = element.getAttribute(CLASS_ATTRIBUTE);
            Class<?> clz;
            try {
                clz = Class.forName(className);
            } catch (ClassNotFoundException e) {
                throw new BeansException("Cannot find class [" + className + "]");
            }
            BeanDefinition beanDefinition = new BeanDefinition(clz);

            // 加载 bean definition properties
            loadBeanProperties(beanDefinition, element);

            // 注册 bean definition
            String id = element.getAttribute(ID_ATTRIBUTE);
            String name = element.getAttribute(NAME_ATTRIBUTE);
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clz.getSimpleName());
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }

    private void loadBeanProperties(BeanDefinition beanDefinition, Element propertiesElement) {
        for (int i = 0; i < propertiesElement.getChildNodes().getLength(); i++) {
            Node node = propertiesElement.getChildNodes().item(i);
            if (!PROPERTY_ELEMENT.equals(node.getNodeName())) {
                continue;
            }
            Element property = (Element) node;
            // name
            String name = property.getAttribute(NAME_ATTRIBUTE);
            if (StrUtil.isEmpty(name)) {
                throw new BeansException("The name attribute cannot be null or empty");
            }

            // value & ref
            Object value = property.getAttribute(VALUE_ATTRIBUTE);
            String ref = property.getAttribute(REF_ATTRIBUTE);
            if (StrUtil.isNotEmpty(ref)) {
                value = new BeanReference(ref);
            }
            PropertyValue propertyValue = new PropertyValue(name, value);
            beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
        }
    }

}
