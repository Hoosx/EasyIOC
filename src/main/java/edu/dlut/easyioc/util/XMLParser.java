package edu.dlut.easyioc.util;

import edu.dlut.easyioc.common.BeanDefinition;

import java.util.List;

/**
 * @author Shuxiang Hu
 * @date 11/19/2020
 */
public interface XMLParser {
    public List<BeanDefinition> getBeanDefinitions();
}
