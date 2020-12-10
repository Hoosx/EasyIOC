# About #
This repository is a simple implementation of the IOC container. 

# Features #
### XML ###
XML based configuration is supported, tag format follows the Spring.

A simple XML example
```xml
<bean id="ming" class="edu.dlut.easyioc.pojo.Student">
        <property name="name" value="Wen Ming" />
        <property name="age" value="19" />
        <property name="pencil" value="pencil" />
</bean>

<bean id="pencil" class="edu.dlut.easyioc.pojo.Pencil">
        <property name="name" value="Chen Guang" />
</bean>
``` 
The framework can inject primitive types, corresponding wrapped classes and referenced objects.
### Annotation ###
In addition to the XML based configuration, annotation based configuration is also supported.
Supported annotations are ``@ComponentScan``, ``@Configuration``, ``@Component``,  ``@AutoWired``,  ``@Value`` and ``@Bean``.
 
 A simple example
```java
@AutoWired
private Pencil pencil;

@Value(value = "hu")
private String name;

@Value(value = "10")
private int age;

@Value(value = "20")
private Integer wrappedIntAge;
```

# TODO #
1. More annotations
2. More XML configurations
3. Exception handling

# License #
MIT Licnese