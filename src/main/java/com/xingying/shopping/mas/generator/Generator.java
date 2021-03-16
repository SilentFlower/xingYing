package com.xingying.shopping.mas.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 代码生成器
 * @author SiletFlower
 * @date 2021/3/15 01:48:48
 * @description
 */
public class Generator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        String tablePre = scanner("请输入表的前缀名: ");
        String packageName = scanner("请输入生成所在的包名: ");
        String projectPath = System.getProperty("user.dir");

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(
                new GlobalConfig()
                        .setAuthor(scanner("作者,将添加到类文档注释中: "))
                        .setOpen(false)
                        .setIdType(IdType.INPUT)
                        .setBaseResultMap(true)
                        .setBaseColumnList(true)
                        .setFileOverride(true)
        ).setDataSource(
                new DataSourceConfig()
                        .setUrl("jdbc:oracle:thin:@localhost:1521:orcl")
                        .setDriverName("oracle.jdbc.OracleDriver")
                        .setUsername("silent")
                        .setPassword("flower")
                        .setSchemaName(tablePre)
        ).setPackageInfo(
                new PackageConfig()
                        .setParent("com.xingying.shopping." + packageName)
                        .setController("controller")
                        .setService("service")
                        .setEntity("entity")
                        .setServiceImpl("service.Impl")
                        .setMapper("dao")
        ).setStrategy(
                //策略配置
                new StrategyConfig()
                        .setNaming(NamingStrategy.underline_to_camel)
                        .setColumnNaming(NamingStrategy.underline_to_camel)
                        .setEntityLombokModel(false)
                        .setRestControllerStyle(true)
                        .setEntityTableFieldAnnotationEnable(true)
                        .setInclude(scanner("表名（要为哪张表生成代码），多个表时需用英文逗号分割").split(","))
                        .setControllerMappingHyphenStyle(true)
        ).setCfg(
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("tablePre", tablePre);
                        map.put("packagePath", "com.xingying.shopping." + packageName);
                        this.setMap(map);
                    }
                }.setFileOutConfigList(
                       new ArrayList<FileOutConfig>(){{
                           add(new FileOutConfig("/templates/controller.java.vm") {
                               @Override
                               public String outputFile(TableInfo tableInfo) {
                                   return projectPath + "/src/main/java/com/xingying/shopping/" + packageName + "/controller/"
                                           + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
                               }
                           });
                           add(new FileOutConfig("/templates/service.java.vm") {
                               @Override
                               public String outputFile(TableInfo tableInfo) {
                                   return projectPath + "/src/main/java/com/xingying/shopping/" + packageName + "/service/"
                                           + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
                               }
                           });
                           add(new FileOutConfig("/templates/serviceImpl.java.vm") {
                               @Override
                               public String outputFile(TableInfo tableInfo) {
                                   return projectPath + "/src/main/java/com/xingying/shopping/" + packageName + "/service/Impl/"
                                           + tableInfo.getEntityName() + "ServiceImpl" + StringPool.DOT_JAVA;
                               }
                           });
                           add(new FileOutConfig("/templates/entity.java.vm") {
                               @Override
                               public String outputFile(TableInfo tableInfo) {
                                   return projectPath + "/src/main/java/com/xingying/shopping/" + packageName + "/entity/"
                                           + tableInfo.getEntityName() + StringPool.DOT_JAVA;
                               }
                           });
                           add(new FileOutConfig("/templates/mapper.java.vm") {
                               @Override
                               public String outputFile(TableInfo tableInfo) {
                                   return projectPath + "/src/main/java/com/xingying/shopping/" + packageName + "/dao/"
                                           + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
                               }
                           });
                           add(new FileOutConfig("/templates/mapper.xml.vm") {
                               @Override
                               public String outputFile(TableInfo tableInfo) {
                                   return projectPath + "/src/main/resources/mapper/"
                                           + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                               }
                           });

                       }}
                )

        ).execute();
        System.out.println("代码生成完毕");

    }


}
