package com.fwh.computernetworklab.config;

import com.fwh.computernetworklab.domain.Person;
import com.fwh.computernetworklab.domain.Role;
import com.fwh.computernetworklab.service.PersonService;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCluster;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Configuration
public class IgniteCfg {

    /**
     * 初始化ignite节点信息
     * @return Ignite
     */
    @Bean
    public Ignite igniteInstance(){
        // 配置一个节点的Configuration
        IgniteConfiguration cfg = new IgniteConfiguration();

        // 设置该节点名称
        cfg.setIgniteInstanceName("springDataNode");

        // 启用Peer类加载器
        cfg.setPeerClassLoadingEnabled(true);

        // 创建一个Cache的配置，名称为PersonCache
        CacheConfiguration ccfg = new CacheConfiguration("PersonCache");

        // 设置这个Cache的键值对模型
        ccfg.setIndexedTypes(Long.class, Person.class);

        // 把这个Cache放入springDataNode这个Node中
        cfg.setCacheConfiguration(ccfg);

        // Ignite persistence configuration.
        // 创建一个持久化存储的设置
        DataStorageConfiguration storageCfg = new DataStorageConfiguration();

        // Enabling the persistence.
        // 是这个设置允许持久化存储
        storageCfg.getDefaultDataRegionConfiguration().setPersistenceEnabled(true);

        // 设置持久化存储路径
        storageCfg.setStoragePath("/opt/storage");



        // Applying settings.
        // 把这个Configuration放到springDataNode这个Node中
        cfg.setDataStorageConfiguration(storageCfg);

        // 启动这个节点
        Ignite ignite = Ignition.start(cfg);

        // 激活集群
        ignite.cluster().active(true);

        return ignite;

    }


    @Autowired
    PersonService personService;


    /**
     * 在启动时计算现有的所有person类，统计数目，作为下一个ID生成的初始值
     * 给Person.ID_GEN赋值
     */
    @Bean
    public void updateId_Gen(){

        Iterator<Person> personIterator = personService.findAll().iterator();
        int sum = 0;
        while (personIterator.hasNext()){
            sum++;
            personIterator.next();
        }
        Person.ID_GEN = new AtomicLong(sum);
    }
}
