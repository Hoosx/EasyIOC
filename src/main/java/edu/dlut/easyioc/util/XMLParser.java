package edu.dlut.easyioc.util;

import edu.dlut.easyioc.common.BeanDefinition;

import java.util.List;
import java.util.Map;

/**
 * @author Shuxiang Hu
 * @date 11/19/2020
 */
public interface XMLParser {
    Map<String, BeanDefinition> getBeanDefinitions();
}
